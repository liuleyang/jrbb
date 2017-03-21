/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMC2010;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.YubinTohyoShomeishoParam;
import jp.co.ndensan.reams.af.afa.business.core.meibotorokuzaigai.HonninJohoResult;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.fuzaishatohyoshikaku.FuzaishaTohyoShikaku;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.fuzaishatohyoshikakuyubin.FuzaishaTohyoShikakuYubin;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.YubinShikaku.YubinShikakuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMC2010.YubinShikakuTorokuDiv;
import jp.co.ndensan.reams.af.afa.service.core.MeibotorokuZaigai;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 郵便等投票資格登録handler
 *
 * @reamsid_L AF-0200-010 liuj2
 */
public final class YubinShikakuTorokuHandler {

    private final YubinShikakuTorokuDiv div;
    private YubinShikakuDiv yubinShikakuDiv;
    private static final int YEAR_7 = 7;
    private final RString 改行 = new RString("<br/>");
    private final RString 直近履歴の抹消日交付日エラー = new RString("直前の抹消日よりも入力された交付日の方が小さくなっています。").concat(改行);
    private final RString 満了日交付日関連エラー_1 = new RString("満了日が交付日より小さくなっています。").concat(改行);
    private final RString 満了日交付日関連エラー_2 = new RString("満了日が交付日の７年後ではありません。").concat(改行);
    private final RString 抹消日登録日関連エラー = new RString("抹消日が登録日より小さくなっています。").concat(改行);
    private final RString 抹消日交付日関連エラー = new RString("抹消日が交付日よりも小さくなっています。").concat(改行);
    private final RString 抹消日満了日関連エラー = new RString("抹消日が満了日より大きくなっています。").concat(改行);
    private final RString 交付日関連ウォーニング = new RString("交付日が未来の日付です。").concat(改行);
    private final RString 抹消日関連ウォーニング = new RString("抹消日が未来の日付です。").concat(改行);
    private static final RString INDEX_0 = new RString("1");
    private static final RString INDEX_1 = new RString("2");
    private static final RString INDEX_2 = new RString("3");
    private static final Code 代理記載者入力区分_0 = new Code("0");
    private static final Code 代理記載者入力区分_1 = new Code("1");
    private static final Code 代理記載者入力区分_2 = new Code("2");

    private YubinShikakuTorokuHandler(YubinShikakuTorokuDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ生成
     *
     * @param div 郵便等投票資格登録のDiv
     * @return 郵便等投票資格登録のハンドラ
     */
    public static YubinShikakuTorokuHandler of(YubinShikakuTorokuDiv div) {
        return new YubinShikakuTorokuHandler(div);
    }

    /**
     * 保存前日関連エラーチェック
     *
     * @param 履歴抹消日 FlexibleDate
     * @return wkエラーメッセージ RString
     */
    public RString validate日付関連エラーチェック(FlexibleDate 履歴抹消日) {
        RString wkエラーメッセージ = new RString("");
        yubinShikakuDiv = div.getCcdYubinShikakuJoho().get郵便等投票資格情報();
        RDate 満了日 = yubinShikakuDiv.getTxtManryoYMD().getValue();
        RDate 交付日 = yubinShikakuDiv.getTxtKofuYMD().getValue();
        RDate 抹消日 = yubinShikakuDiv.getTxtMasshoYMD().getValue();
        if (!履歴抹消日.isEmpty()
                && null != 交付日 && !交付日.toString().isEmpty()
                && !yubinShikakuDiv.getTxtKofuYMD().isDisplayNone()
                && 交付日.isBefore(new RDate(履歴抹消日.toString()))) {
            wkエラーメッセージ = wkエラーメッセージ.concat(直近履歴の抹消日交付日エラー);
        }

        if (is満了日交付日関連チェック対象(yubinShikakuDiv)
                && null != 満了日 && !満了日.toString().isEmpty()
                && null != 交付日 && !交付日.toString().isEmpty()) {
            wkエラーメッセージ = wkエラーメッセージ.concat(validate満了日交付日関連エラーチェック(満了日, 交付日));
        }
        if (null != 抹消日 && !抹消日.toString().isEmpty()) {
            wkエラーメッセージ = wkエラーメッセージ.concat(validat抹消日関連エラーチェック(yubinShikakuDiv));
        }
        return wkエラーメッセージ;
    }

    /**
     * 保存前日関連ウォーニングチェック
     *
     * @return wkウォーニングメッセージ RString
     */
    public RString validate日付関連ウォーニングチェック() {
        RString wkウォーニングメッセージ = new RString("");
        yubinShikakuDiv = div.getCcdYubinShikakuJoho().get郵便等投票資格情報();
        RDate 交付日 = yubinShikakuDiv.getTxtKofuYMD().getValue();
        RDate 抹消日 = yubinShikakuDiv.getTxtMasshoYMD().getValue();
        RDate システム日付 = RDate.getNowDate();
        if (!yubinShikakuDiv.getTxtKofuYMD().isDisabled()
                && !yubinShikakuDiv.getTxtKofuYMD().isDisplayNone()
                && null != 交付日 && !交付日.toString().isEmpty()
                && システム日付.isBefore(交付日)) {
            wkウォーニングメッセージ = wkウォーニングメッセージ.concat(交付日関連ウォーニング);
        }

        if (!yubinShikakuDiv.getTxtMasshoYMD().isDisabled()
                && !yubinShikakuDiv.getTxtMasshoYMD().isDisplayNone()
                && null != 抹消日 && !抹消日.toString().isEmpty()
                && システム日付.isBefore(抹消日)) {
            wkウォーニングメッセージ = wkウォーニングメッセージ.concat(抹消日関連ウォーニング);
        }
        return wkウォーニングメッセージ;
    }

    /**
     * 画面の内容を保存する
     *
     * @param 不在者投票資格 FuzaishaTohyoShikaku
     * @param 郵便投票資格付随情報 FuzaishaTohyoShikakuYubin
     * @param 識別コード ShikibetsuCode
     * @return 不在者投票資格 FuzaishaTohyoShikaku
     */
    public FuzaishaTohyoShikaku edit不在者投票資格(FuzaishaTohyoShikaku 不在者投票資格, FuzaishaTohyoShikakuYubin 郵便投票資格付随情報, ShikibetsuCode 識別コード) {
        yubinShikakuDiv = div.getCcdYubinShikakuJoho().get郵便等投票資格情報();
        return 不在者投票資格.createBuilderForEdit()
                .setFuzaishaTohyoShikakuYubin(edit郵便投票資格付随情報(郵便投票資格付随情報))
                .set交付年月日(null == yubinShikakuDiv.getTxtKofuYMD().getValue()
                        ? FlexibleDate.EMPTY : new FlexibleDate(yubinShikakuDiv.getTxtKofuYMD().getValue().toString()))
                .set交付番号(null == yubinShikakuDiv.getTxtKofuNo().getValue()
                        ? RString.EMPTY : yubinShikakuDiv.getTxtKofuNo().getValue())
                .set資格登録年月日(null == yubinShikakuDiv.getTxtShikakuTorokuYMD().getValue()
                        ? FlexibleDate.EMPTY : new FlexibleDate(yubinShikakuDiv.getTxtShikakuTorokuYMD().getValue().toString()))
                .set資格満了年月日(null == yubinShikakuDiv.getTxtManryoYMD().getValue()
                        ? FlexibleDate.EMPTY : new FlexibleDate(yubinShikakuDiv.getTxtManryoYMD().getValue().toString()))
                .set資格抹消年月日(null == yubinShikakuDiv.getTxtMasshoYMD().getValue()
                        ? FlexibleDate.EMPTY : new FlexibleDate(yubinShikakuDiv.getTxtMasshoYMD().getValue().toString()))
                .set資格抹消事由コード(null == yubinShikakuDiv.getCcdMasshoJiyu().getSelectJiyuCode()
                        ? Code.EMPTY : new Code(yubinShikakuDiv.getCcdMasshoJiyu().getSelectJiyuCode().toString()))
                .build();
    }

    private FuzaishaTohyoShikakuYubin edit郵便投票資格付随情報(FuzaishaTohyoShikakuYubin 郵便投票資格付随情報) {
        yubinShikakuDiv = div.getCcdYubinShikakuJoho().get郵便等投票資格情報();
        Code 代理記載者入力区分 = get代理記載者入力区分(yubinShikakuDiv);
        List<RString> selectedKeys = yubinShikakuDiv.getChkShikakuJoken().getSelectedKeys();
        return 郵便投票資格付随情報.createBuilderForEdit()
                .set身体障害者手帳有フラグ(has身体障害者手帳有フラグ(selectedKeys))
                .set戦傷病者手帳有フラグ(has戦傷病者手帳有フラグ(selectedKeys))
                .set介護保険被保険者証有フラグ(has介護保険被保険者証有フラグ(selectedKeys))
                .set代理記載者入力区分(代理記載者入力区分)
                .set代理記載者識別コード(yubinShikakuDiv.getTxtDairiShikibetsuCode().getDomain())
                .set代理記載者漢字氏名(null == yubinShikakuDiv.getTxtDairiKanjiShimei().getDomain()
                        ? AtenaMeisho.EMPTY : yubinShikakuDiv.getTxtDairiKanjiShimei().getDomain())
                .set代理記載者カナ氏名(null == yubinShikakuDiv.getTxtDairiKanaShimei().getValue()
                        ? AtenaKanaMeisho.EMPTY : new AtenaKanaMeisho(yubinShikakuDiv.getTxtDairiKanaShimei().getValue()))
                .set代理記載者生年月日(null == yubinShikakuDiv.getTxtDairiSeinengappiYMD().getValue()
                        ? FlexibleDate.EMPTY : yubinShikakuDiv.getTxtDairiSeinengappiYMD().getValue())
                .set代理記載者性別コード(代理記載者入力区分.equals(代理記載者入力区分_0)
                        ? RString.EMPTY : yubinShikakuDiv.getDdlDairiSeibetsu().getSelectedKey())
                .set代理記載者郵便番号(null == yubinShikakuDiv.getTxtYubinNo().getValue()
                        ? YubinNo.EMPTY : yubinShikakuDiv.getTxtYubinNo().getValue())
                .set代理記載者住所(null == yubinShikakuDiv.getTxtDairiJusho().getDomain()
                        ? AtenaJusho.EMPTY : yubinShikakuDiv.getTxtDairiJusho().getDomain())
                .build();

    }

    /**
     * 画面の内容を保存する
     *
     * @param 識別コード ShikibetsuCode
     * @return parameter YubinTohyoShomeishoParam
     */
    public YubinTohyoShomeishoParam setparameter(ShikibetsuCode 識別コード) {
        yubinShikakuDiv = div.getCcdYubinShikakuJoho().get郵便等投票資格情報();
        HonninJohoResult honninJohoResult = set宛名PSM(識別コード);
        YubinTohyoShomeishoParam parameter = new YubinTohyoShomeishoParam(
                null == honninJohoResult ? null : honninJohoResult.get宛名PSM(),
                null == yubinShikakuDiv.getTxtKofuYMD().getValue() || yubinShikakuDiv.getTxtKofuYMD().getValue().toString().isEmpty()
                ? null : yubinShikakuDiv.getTxtKofuYMD().getValue(),
                null == yubinShikakuDiv.getTxtManryoYMD().getValue() || yubinShikakuDiv.getTxtManryoYMD().getValue().toString().isEmpty()
                ? null : yubinShikakuDiv.getTxtManryoYMD().getValue()
        );
        return parameter;
    }

    private boolean is満了日交付日関連チェック対象(YubinShikakuDiv yubinShikakuDiv) {
        return !yubinShikakuDiv.getTxtManryoYMD().isDisabled()
                || !yubinShikakuDiv.getTxtKofuYMD().isDisabled();
    }

    private boolean is抹消日登録日チェック対象(YubinShikakuDiv yubinShikakuDiv) {
        return !yubinShikakuDiv.getTxtMasshoYMD().isDisabled()
                || !yubinShikakuDiv.getTxtShikakuTorokuYMD().isDisabled();
    }

    private boolean is抹消日交付日チェック対象(YubinShikakuDiv yubinShikakuDiv) {
        return !yubinShikakuDiv.getTxtMasshoYMD().isDisabled()
                || !yubinShikakuDiv.getTxtKofuYMD().isDisabled();
    }

    private boolean is抹消日満了日チェック対象(YubinShikakuDiv yubinShikakuDiv) {
        return !yubinShikakuDiv.getTxtMasshoYMD().isDisabled()
                || !yubinShikakuDiv.getTxtManryoYMD().isDisplayNone();
    }

    private RString validate満了日交付日関連エラーチェック(RDate 満了日, RDate 交付日) {
        RString wkエラーメッセージ = new RString("");
        if (満了日.isBefore(交付日)) {
            wkエラーメッセージ = wkエラーメッセージ.concat(満了日交付日関連エラー_1);
        }
        RDate 交付日７年後年月日 = get交付日７年後年月日(交付日);
        if (!満了日.equals(交付日７年後年月日)) {
            wkエラーメッセージ = wkエラーメッセージ.concat(満了日交付日関連エラー_2);
        }
        return wkエラーメッセージ;
    }

    private RString validat抹消日関連エラーチェック(YubinShikakuDiv yubinShikakuDiv) {
        RDate 満了日 = yubinShikakuDiv.getTxtManryoYMD().getValue();
        RDate 交付日 = yubinShikakuDiv.getTxtKofuYMD().getValue();
        RDate 抹消日 = yubinShikakuDiv.getTxtMasshoYMD().getValue();
        RDate 登録日 = yubinShikakuDiv.getTxtShikakuTorokuYMD().getValue();
        RString wkエラーメッセージ = new RString("");
        if (is抹消日登録日チェック対象(yubinShikakuDiv)
                && null != 登録日 && !登録日.toString().isEmpty()) {
            wkエラーメッセージ = wkエラーメッセージ.concat(validate抹消日登録日関連エラーチェック(抹消日, 登録日));
        }

        if (is抹消日交付日チェック対象(yubinShikakuDiv)
                && null != 交付日 && !交付日.toString().isEmpty()) {
            wkエラーメッセージ = wkエラーメッセージ.concat(validate抹消日交付日関連エラーチェック(抹消日, 交付日));
        }

        if (is抹消日満了日チェック対象(yubinShikakuDiv)
                && null != 満了日 && !満了日.toString().isEmpty()) {
            wkエラーメッセージ = wkエラーメッセージ.concat(validate抹消日満了日関連エラーチェック(抹消日, 満了日));
        }
        return wkエラーメッセージ;
    }

    private RString validate抹消日登録日関連エラーチェック(RDate 抹消日, RDate 登録日) {
        if (抹消日.isBefore(登録日)) {
            return 抹消日登録日関連エラー;
        }
        return RString.EMPTY;
    }

    private RString validate抹消日交付日関連エラーチェック(RDate 抹消日, RDate 交付日) {
        if (抹消日.isBefore(交付日)) {
            return 抹消日交付日関連エラー;
        }
        return RString.EMPTY;
    }

    private RString validate抹消日満了日関連エラーチェック(RDate 抹消日, RDate 満了日) {
        if (満了日.isBefore(抹消日)) {
            return 抹消日満了日関連エラー;
        }
        return RString.EMPTY;
    }

    private RDate get交付日７年後年月日(RDate 交付日) {
        int 交付日_年度 = 交付日.getNendo().plusYear(YEAR_7).getYearValue();
        int 交付日_月 = 交付日.getMonthValue();
        int 交付日_日 = 交付日.getDayValue();
        return new RDate(交付日_年度, 交付日_月, 交付日_日);
    }

    private boolean has身体障害者手帳有フラグ(List<RString> selectedKeys) {
        if (null == selectedKeys || selectedKeys.isEmpty()) {
            return Boolean.FALSE;
        } else if (selectedKeys.contains(INDEX_0)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private boolean has戦傷病者手帳有フラグ(List<RString> selectedKeys) {
        if (null == selectedKeys || selectedKeys.isEmpty()) {
            return Boolean.FALSE;
        } else if (selectedKeys.contains(INDEX_1)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private boolean has介護保険被保険者証有フラグ(List<RString> selectedKeys) {
        if (null == selectedKeys || selectedKeys.isEmpty()) {
            return Boolean.FALSE;
        } else if (selectedKeys.contains(INDEX_2)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private Code get代理記載者入力区分(YubinShikakuDiv yubinShikakuDiv) {
        if (!RString.isNullOrEmpty(yubinShikakuDiv.getTxtDairiJuminShubetsu().getValue())
                || !RString.isNullOrEmpty(yubinShikakuDiv.getTxtDairiJusho().getDomain().getColumnValue())
                || !RString.isNullOrEmpty(yubinShikakuDiv.getTxtDairiKanaShimei().getValue())
                || !RString.isNullOrEmpty(yubinShikakuDiv.getTxtDairiKanjiShimei().getDomain().getColumnValue())
                || !RString.isNullOrEmpty(yubinShikakuDiv.getTxtDairiNenrei().getValue())
                || !(null == yubinShikakuDiv.getTxtDairiSeinengappiYMD().getValue() || yubinShikakuDiv.getTxtDairiSeinengappiYMD().getValue().isEmpty())
                || !RString.isNullOrEmpty(yubinShikakuDiv.getTxtDairiSetaiCode().getDomain().getColumnValue())
                || !RString.isNullOrEmpty(yubinShikakuDiv.getDdlDairiSeibetsu().getSelectedKey())
                || !RString.isNullOrEmpty(yubinShikakuDiv.getTxtDairiShikibetsuCode().getDomain().getColumnValue())) {
            if (yubinShikakuDiv.getTxtDairiKanaShimei().isDisabled()
                    || yubinShikakuDiv.getTxtDairiKanaShimei().isReadOnly()) {
                return 代理記載者入力区分_1;
            } else {
                return 代理記載者入力区分_2;
            }
        } else {
            return 代理記載者入力区分_0;
        }
    }

    private HonninJohoResult set宛名PSM(ShikibetsuCode 識別コード) {
        MeibotorokuZaigai meibotorokuZaigai = MeibotorokuZaigai.createInstance();
        return meibotorokuZaigai.get本人情報初期情報(識別コード);
    }
}
