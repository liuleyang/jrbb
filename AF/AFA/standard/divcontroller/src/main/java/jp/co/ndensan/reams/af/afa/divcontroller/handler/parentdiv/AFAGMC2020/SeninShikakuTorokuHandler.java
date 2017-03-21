/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMC2020;

import jp.co.ndensan.reams.af.afa.business.core.SenkyoninMeiboTorokuShomeishoParam;
import jp.co.ndensan.reams.af.afa.business.core.meibotorokuzaigai.HonninJohoResult;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.fuzaishatohyoshikaku.FuzaishaTohyoShikaku;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.FuzaishaShikaku.FuzaishaShikakuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMC2020.SeninShikakuTorokuDiv;
import jp.co.ndensan.reams.af.afa.service.core.MeibotorokuZaigai;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 洋上投票資格登録handler
 *
 * @reamsid_L AF-0210-010 liuj2
 */
public final class SeninShikakuTorokuHandler {

    private final SeninShikakuTorokuDiv div;
    private FuzaishaShikakuDiv 不在者資格情報洋上;
    private static final int YEAR_7 = 7;
    private final RString 改行 = new RString("<br/>");
    private final RString 直近履歴の抹消日交付日エラー洋上 = new RString("直前の抹消日よりも入力された交付日の方が小さくなっています。").concat(改行);
    private final RString 満了日交付日関連エラー洋上_1 = new RString("満了日が交付日より小さくなっています。").concat(改行);
    private final RString 満了日交付日関連エラー洋上_2 = new RString("満了日が交付日の７年後ではありません。").concat(改行);
    private final RString 抹消日登録日関連エラー洋上 = new RString("抹消日が登録日より小さくなっています。").concat(改行);
    private final RString 抹消日交付日関連エラー洋上 = new RString("抹消日が交付日よりも小さくなっています。").concat(改行);
    private final RString 抹消日満了日関連エラー洋上 = new RString("抹消日が満了日より大きくなっています。").concat(改行);
    private final RString 交付日関連ウォーニング洋上 = new RString("交付日が未来の日付です。").concat(改行);
    private final RString 抹消日関連ウォーニング洋上 = new RString("抹消日が未来の日付です。").concat(改行);

    private SeninShikakuTorokuHandler(SeninShikakuTorokuDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ生成
     *
     * @param div 洋上投票資格登録のDiv
     * @return 洋上投票資格登録のハンドラ
     */
    public static SeninShikakuTorokuHandler of(SeninShikakuTorokuDiv div) {
        return new SeninShikakuTorokuHandler(div);
    }

    /**
     * 保存前日関連エラーチェック
     *
     * @param 履歴抹消日洋上 FlexibleDate
     * @return wkエラーメッセージ洋上 RString
     */
    public RString validate日付関連エラーチェック洋上(FlexibleDate 履歴抹消日洋上) {
        RString wkエラーメッセージ洋上 = new RString("");
        不在者資格情報洋上 = div.getCcdSeninShikakuJoho().get不在者資格情報();
        RDate 満了日 = 不在者資格情報洋上.getTxtManryoYMD().getValue();
        RDate 交付日 = 不在者資格情報洋上.getTxtKofuYMD().getValue();
        RDate 抹消日 = 不在者資格情報洋上.getTxtMasshoYMD().getValue();
        if (!履歴抹消日洋上.isEmpty() && 交付日 != null
                && !不在者資格情報洋上.getTxtKofuYMD().isDisplayNone()
                && 交付日.isBefore(new RDate(履歴抹消日洋上.toString()))) {
            wkエラーメッセージ洋上 = wkエラーメッセージ洋上.concat(直近履歴の抹消日交付日エラー洋上);
        }
        if (is満了日交付日関連チェック対象洋上(不在者資格情報洋上)
                && null != 満了日 && !満了日.toString().isEmpty()
                && null != 交付日 && !交付日.toString().isEmpty()) {
            wkエラーメッセージ洋上 = wkエラーメッセージ洋上.concat(validate満了日交付日関連エラーチェック洋上(満了日, 交付日));
        }
        if (null != 抹消日 && !抹消日.toString().isEmpty()) {
            wkエラーメッセージ洋上 = wkエラーメッセージ洋上.concat(validat抹消日関連エラーチェック洋上(不在者資格情報洋上));
        }
        return wkエラーメッセージ洋上;
    }

    /**
     * 保存前日関連ウォーニングチェック
     *
     * @return wkウォーニングメッセージ洋上 RString
     */
    public RString validate日付関連ウォーニングチェック洋上() {
        RString wkウォーニングメッセージ洋上 = new RString("");
        不在者資格情報洋上 = div.getCcdSeninShikakuJoho().get不在者資格情報();
        RDate 交付日 = 不在者資格情報洋上.getTxtKofuYMD().getValue();
        RDate 抹消日 = 不在者資格情報洋上.getTxtMasshoYMD().getValue();
        RDate システム日付 = RDate.getNowDate();
        if (!不在者資格情報洋上.getTxtKofuYMD().isReadOnly()
                && !不在者資格情報洋上.getTxtKofuYMD().isDisplayNone()
                && null != 交付日 && !交付日.toString().isEmpty()
                && システム日付.isBefore(交付日)) {
            wkウォーニングメッセージ洋上 = wkウォーニングメッセージ洋上.concat(交付日関連ウォーニング洋上);
        }
        if (!不在者資格情報洋上.getTxtMasshoYMD().isReadOnly()
                && !不在者資格情報洋上.getTxtMasshoYMD().isDisplayNone()
                && null != 抹消日 && !抹消日.toString().isEmpty()
                && システム日付.isBefore(抹消日)) {
            wkウォーニングメッセージ洋上 = wkウォーニングメッセージ洋上.concat(抹消日関連ウォーニング洋上);
        }
        return wkウォーニングメッセージ洋上;
    }

    /**
     * 画面の内容を保存する
     *
     * @param 不在者投票資格洋上 FuzaishaTohyoShikaku
     * @return 不在者投票資格 FuzaishaTohyoShikaku
     */
    public FuzaishaTohyoShikaku edit不在者投票資格洋上(FuzaishaTohyoShikaku 不在者投票資格洋上) {
        不在者資格情報洋上 = div.getCcdSeninShikakuJoho().get不在者資格情報();
        return 不在者投票資格洋上.createBuilderForEdit()
                .set交付年月日(null == 不在者資格情報洋上.getTxtKofuYMD().getValue()
                        ? FlexibleDate.EMPTY : new FlexibleDate(不在者資格情報洋上.getTxtKofuYMD().getValue().toString()))
                .set交付番号(RString.EMPTY)
                .set資格登録年月日(null == 不在者資格情報洋上.getTxtShikakuTorokuYMD().getValue()
                        ? FlexibleDate.EMPTY : new FlexibleDate(不在者資格情報洋上.getTxtShikakuTorokuYMD().getValue().toString()))
                .set資格満了年月日(null == 不在者資格情報洋上.getTxtManryoYMD().getValue()
                        ? FlexibleDate.EMPTY : new FlexibleDate(不在者資格情報洋上.getTxtManryoYMD().getValue().toString()))
                .set資格抹消年月日(null == 不在者資格情報洋上.getTxtMasshoYMD().getValue()
                        ? FlexibleDate.EMPTY : new FlexibleDate(不在者資格情報洋上.getTxtMasshoYMD().getValue().toString()))
                .set資格抹消事由コード(null == 不在者資格情報洋上.getCcdMasshoJiyu().getSelectJiyuCode()
                        ? Code.EMPTY : new Code(不在者資格情報洋上.getCcdMasshoJiyu().getSelectJiyuCode().toString()))
                .build();
    }

    /**
     * 画面の内容を保存する
     *
     * @param 識別コード ShikibetsuCode
     * @return parameter SenkyoninMeiboTorokuShomeishoParam
     */
    public SenkyoninMeiboTorokuShomeishoParam setparameter洋上(ShikibetsuCode 識別コード) {
        不在者資格情報洋上 = div.getCcdSeninShikakuJoho().get不在者資格情報();
        HonninJohoResult honninJohoResult = set宛名PSM洋上(識別コード);
        SenkyoninMeiboTorokuShomeishoParam parameter = new SenkyoninMeiboTorokuShomeishoParam();
        parameter.set宛名PSM(null == honninJohoResult ? null : honninJohoResult.get宛名PSM());
        parameter.set交付年月日(null == 不在者資格情報洋上.getTxtKofuYMD().getValue() || 不在者資格情報洋上.getTxtKofuYMD().getValue().toString().isEmpty()
                ? null : 不在者資格情報洋上.getTxtKofuYMD().getValue());
        return parameter;
    }

    private boolean is満了日交付日関連チェック対象洋上(FuzaishaShikakuDiv 不在者資格情報洋上) {
        return !不在者資格情報洋上.getTxtManryoYMD().isReadOnly()
                || !不在者資格情報洋上.getTxtKofuYMD().isReadOnly();
    }

    private boolean is抹消日登録日チェック対象洋上(FuzaishaShikakuDiv 不在者資格情報洋上) {
        return !不在者資格情報洋上.getTxtMasshoYMD().isReadOnly()
                || !不在者資格情報洋上.getTxtShikakuTorokuYMD().isReadOnly();
    }

    private boolean is抹消日交付日チェック対象洋上(FuzaishaShikakuDiv 不在者資格情報洋上) {
        return !不在者資格情報洋上.getTxtMasshoYMD().isReadOnly()
                || !不在者資格情報洋上.getTxtKofuYMD().isReadOnly();
    }

    private boolean is抹消日満了日チェック対象洋上(FuzaishaShikakuDiv 不在者資格情報洋上) {
        return !不在者資格情報洋上.getTxtMasshoYMD().isReadOnly()
                || !不在者資格情報洋上.getTxtManryoYMD().isReadOnly();
    }

    private RString validate満了日交付日関連エラーチェック洋上(RDate 満了日, RDate 交付日) {
        RString wkエラーメッセージ洋上 = new RString("");
        if (満了日.isBefore(交付日)) {
            wkエラーメッセージ洋上 = wkエラーメッセージ洋上.concat(満了日交付日関連エラー洋上_1);
        }
        RDate 交付日７年後年月日 = get交付日７年後洋上(交付日);
        if (!満了日.equals(交付日７年後年月日)) {
            wkエラーメッセージ洋上 = wkエラーメッセージ洋上.concat(満了日交付日関連エラー洋上_2);
        }
        return wkエラーメッセージ洋上;
    }

    private RString validat抹消日関連エラーチェック洋上(FuzaishaShikakuDiv 不在者資格情報洋上) {
        RDate 満了日 = 不在者資格情報洋上.getTxtManryoYMD().getValue();
        RDate 交付日 = 不在者資格情報洋上.getTxtKofuYMD().getValue();
        RDate 抹消日 = 不在者資格情報洋上.getTxtMasshoYMD().getValue();
        RDate 登録日 = 不在者資格情報洋上.getTxtShikakuTorokuYMD().getValue();
        RString wkエラーメッセージ洋上 = new RString("");
        if (is抹消日登録日チェック対象洋上(不在者資格情報洋上)
                && null != 登録日 && !登録日.toString().isEmpty()) {
            wkエラーメッセージ洋上 = wkエラーメッセージ洋上.concat(validate抹消日登録日関連エラーチェック洋上(抹消日, 登録日));
        }
        if (is抹消日交付日チェック対象洋上(不在者資格情報洋上)
                && null != 交付日 && !交付日.toString().isEmpty()) {
            wkエラーメッセージ洋上 = wkエラーメッセージ洋上.concat(validate抹消日交付日関連エラーチェック洋上(抹消日, 交付日));
        }
        if (is抹消日満了日チェック対象洋上(不在者資格情報洋上)
                && null != 満了日 && !満了日.toString().isEmpty()) {
            wkエラーメッセージ洋上 = wkエラーメッセージ洋上.concat(validate抹消日満了日関連エラーチェック洋上(抹消日, 満了日));
        }
        return wkエラーメッセージ洋上;
    }

    private RString validate抹消日登録日関連エラーチェック洋上(RDate 抹消日, RDate 登録日) {
        if (抹消日.isBefore(登録日)) {
            return 抹消日登録日関連エラー洋上;
        }
        return RString.EMPTY;
    }

    private RString validate抹消日交付日関連エラーチェック洋上(RDate 抹消日, RDate 交付日) {
        if (抹消日.isBefore(交付日)) {
            return 抹消日交付日関連エラー洋上;
        }
        return RString.EMPTY;
    }

    private RString validate抹消日満了日関連エラーチェック洋上(RDate 抹消日, RDate 満了日) {
        if (満了日.isBefore(抹消日)) {
            return 抹消日満了日関連エラー洋上;
        }
        return RString.EMPTY;
    }

    private RDate get交付日７年後洋上(RDate 交付日) {
        int 交付日_年度 = 交付日.getNendo().plusYear(YEAR_7).getYearValue();
        int 交付日_月 = 交付日.getMonthValue();
        int 交付日_日 = 交付日.getDayValue();
        return new RDate(交付日_年度, 交付日_月, 交付日_日);
    }

    private HonninJohoResult set宛名PSM洋上(ShikibetsuCode 識別コード洋上) {
        MeibotorokuZaigai meibotorokuZaigai = MeibotorokuZaigai.createInstance();
        return meibotorokuZaigai.get本人情報初期情報(識別コード洋上);
    }
}
