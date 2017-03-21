/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMC2030;

import jp.co.ndensan.reams.af.afa.business.core.NankyokuSenkyoninShomeishoParam;
import jp.co.ndensan.reams.af.afa.business.core.meibotorokuzaigai.HonninJohoResult;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.fuzaishatohyoshikaku.FuzaishaTohyoShikaku;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.FuzaishaShikaku.FuzaishaShikakuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMC2030.NankyokuShikakuTorokuDiv;
import jp.co.ndensan.reams.af.afa.service.core.MeibotorokuZaigai;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 南極投票資格登録handler
 *
 * @reamsid_L AF-0220-010 guyq
 */
public final class NankyokuShikakuTorokuHandler {

    private final NankyokuShikakuTorokuDiv div;
    private FuzaishaShikakuDiv fuzaishaShikakuDiv;
    private final RString 改行 = new RString("<br/>");
    private final RString 直近履歴の抹消日交付日エラー南極 = new RString("直前の抹消日よりも入力された交付日の方が小さくなっています。").concat(改行);
    private final RString 満了日交付日関連エラー南極_1 = new RString("満了日が交付日より小さくなっています。").concat(改行);
    private final RString 抹消日登録日関連エラー南極 = new RString("抹消日が登録日より小さくなっています。").concat(改行);
    private final RString 抹消日交付日関連エラー南極 = new RString("抹消日が交付日よりも小さくなっています。").concat(改行);
    private final RString 抹消日満了日関連エラー南極 = new RString("抹消日が満了日より大きくなっています。").concat(改行);
    private final RString 交付日関連ウォーニング南極 = new RString("交付日が未来の日付です。").concat(改行);
    private final RString 抹消日関連ウォーニング南極 = new RString("抹消日が未来の日付です。").concat(改行);

    private NankyokuShikakuTorokuHandler(NankyokuShikakuTorokuDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ生成
     *
     * @param div 南極投票資格登録のDiv
     * @return 南極投票資格登録のハンドラ
     */
    public static NankyokuShikakuTorokuHandler of(NankyokuShikakuTorokuDiv div) {
        return new NankyokuShikakuTorokuHandler(div);
    }

    /**
     * 保存前日関連エラーチェック
     *
     * @param 履歴抹消日南極 FlexibleDate
     * @return wkエラーメッセージ南極 RString
     */
    public RString validate日付関連エラーチェック南極(FlexibleDate 履歴抹消日南極) {
        RString wkエラーメッセージ南極 = new RString("");
        fuzaishaShikakuDiv = div.getCcdNankyokuShikakuJoho().get不在者資格情報();
        RDate 満了日 = fuzaishaShikakuDiv.getTxtManryoYMD().getValue();
        RDate 交付日 = fuzaishaShikakuDiv.getTxtKofuYMD().getValue();
        RDate 抹消日 = fuzaishaShikakuDiv.getTxtMasshoYMD().getValue();
        if (!履歴抹消日南極.isEmpty()
                && fuzaishaShikakuDiv.getTxtKofuYMD().getValue() != null
                && !fuzaishaShikakuDiv.getTxtKofuYMD().isDisplayNone()
                && 交付日.isBefore(new RDate(履歴抹消日南極.toString()))) {
            wkエラーメッセージ南極 = wkエラーメッセージ南極.concat(直近履歴の抹消日交付日エラー南極);
        }
        if (is満了日交付日関連チェック対象南極(fuzaishaShikakuDiv)
                && null != 満了日 && !満了日.toString().isEmpty()
                && null != 交付日 && !交付日.toString().isEmpty()) {
            wkエラーメッセージ南極 = wkエラーメッセージ南極.concat(validate満了日交付日関連エラーチェック南極(満了日, 交付日));
        }
        if (null != 抹消日 && !抹消日.toString().isEmpty()) {
            wkエラーメッセージ南極 = wkエラーメッセージ南極.concat(validat抹消日関連エラーチェック南極(fuzaishaShikakuDiv));
        }
        return wkエラーメッセージ南極;
    }

    /**
     * 保存前日関連ウォーニングチェック
     *
     * @return wkウォーニングメッセージ南極 RString
     */
    public RString validate日付関連ウォーニングチェック南極() {
        RString wkウォーニングメッセージ南極 = new RString("");
        fuzaishaShikakuDiv = div.getCcdNankyokuShikakuJoho().get不在者資格情報();
        RDate 交付日 = fuzaishaShikakuDiv.getTxtKofuYMD().getValue();
        RDate 抹消日 = fuzaishaShikakuDiv.getTxtMasshoYMD().getValue();
        RDate システム日付 = RDate.getNowDate();
        if (!fuzaishaShikakuDiv.getTxtKofuYMD().isReadOnly()
                && !fuzaishaShikakuDiv.getTxtKofuYMD().isDisplayNone()
                && null != 交付日 && !交付日.toString().isEmpty()
                && システム日付.isBefore(交付日)) {
            wkウォーニングメッセージ南極 = wkウォーニングメッセージ南極.concat(交付日関連ウォーニング南極);
        }
        if (!fuzaishaShikakuDiv.getTxtMasshoYMD().isReadOnly()
                && !fuzaishaShikakuDiv.getTxtMasshoYMD().isDisplayNone()
                && null != 抹消日 && !抹消日.toString().isEmpty()
                && システム日付.isBefore(抹消日)) {
            wkウォーニングメッセージ南極 = wkウォーニングメッセージ南極.concat(抹消日関連ウォーニング南極);
        }
        return wkウォーニングメッセージ南極;
    }

    /**
     * 画面の内容を保存する
     *
     * @param 不在者投票資格南極 FuzaishaTohyoShikaku
     * @return 不在者投票資格南極 FuzaishaTohyoShikaku
     */
    public FuzaishaTohyoShikaku edit不在者投票資格南極(FuzaishaTohyoShikaku 不在者投票資格南極) {
        fuzaishaShikakuDiv = div.getCcdNankyokuShikakuJoho().get不在者資格情報();
        return 不在者投票資格南極.createBuilderForEdit()
                .set交付年月日(null == fuzaishaShikakuDiv.getTxtKofuYMD().getValue()
                        ? FlexibleDate.EMPTY : new FlexibleDate(fuzaishaShikakuDiv.getTxtKofuYMD().getValue().toString()))
                .set交付番号(RString.EMPTY)
                .set資格登録年月日(null == fuzaishaShikakuDiv.getTxtShikakuTorokuYMD().getValue()
                        ? FlexibleDate.EMPTY : new FlexibleDate(fuzaishaShikakuDiv.getTxtShikakuTorokuYMD().getValue().toString()))
                .set資格満了年月日(null == fuzaishaShikakuDiv.getTxtManryoYMD().getValue()
                        ? FlexibleDate.EMPTY : new FlexibleDate(fuzaishaShikakuDiv.getTxtManryoYMD().getValue().toString()))
                .set資格抹消年月日(null == fuzaishaShikakuDiv.getTxtMasshoYMD().getValue()
                        ? FlexibleDate.EMPTY : new FlexibleDate(fuzaishaShikakuDiv.getTxtMasshoYMD().getValue().toString()))
                .set資格抹消事由コード(null == fuzaishaShikakuDiv.getCcdMasshoJiyu().getSelectJiyuCode()
                        ? Code.EMPTY : new Code(fuzaishaShikakuDiv.getCcdMasshoJiyu().getSelectJiyuCode().toString()))
                .build();
    }

    /**
     * 画面の内容を保存する
     *
     * @param 識別コード ShikibetsuCode
     * @return parameter NankyokuSenkyoninShomeishoParam
     */
    public NankyokuSenkyoninShomeishoParam setparameter南極(ShikibetsuCode 識別コード) {
        fuzaishaShikakuDiv = div.getCcdNankyokuShikakuJoho().get不在者資格情報();
        HonninJohoResult honninJohoResult = set宛名PSM南極(識別コード);
        NankyokuSenkyoninShomeishoParam parameter = new NankyokuSenkyoninShomeishoParam();
        parameter.set宛名PSM(null == honninJohoResult ? null : honninJohoResult.get宛名PSM());
        parameter.set交付年月日(null == fuzaishaShikakuDiv.getTxtKofuYMD().getValue() || fuzaishaShikakuDiv.getTxtKofuYMD().getValue().toString().isEmpty()
                ? null : fuzaishaShikakuDiv.getTxtKofuYMD().getValue());
        parameter.set資格満了年月日(null == fuzaishaShikakuDiv.getTxtManryoYMD().getValue() || fuzaishaShikakuDiv.getTxtManryoYMD().getValue().toString().isEmpty()
                ? null : fuzaishaShikakuDiv.getTxtManryoYMD().getValue());
        return parameter;
    }

    private boolean is満了日交付日関連チェック対象南極(FuzaishaShikakuDiv fuzaishaShikakuDiv) {
        return !fuzaishaShikakuDiv.getTxtManryoYMD().isReadOnly()
                || !fuzaishaShikakuDiv.getTxtKofuYMD().isReadOnly();
    }

    private boolean is抹消日登録日チェック対象南極(FuzaishaShikakuDiv fuzaishaShikakuDiv) {
        return !fuzaishaShikakuDiv.getTxtMasshoYMD().isReadOnly()
                || !fuzaishaShikakuDiv.getTxtShikakuTorokuYMD().isReadOnly();
    }

    private boolean is抹消日交付日チェック対象南極(FuzaishaShikakuDiv fuzaishaShikakuDiv) {
        return !fuzaishaShikakuDiv.getTxtMasshoYMD().isReadOnly()
                || !fuzaishaShikakuDiv.getTxtKofuYMD().isReadOnly();
    }

    private boolean is抹消日満了日チェック対象南極(FuzaishaShikakuDiv fuzaishaShikakuDiv) {
        return !fuzaishaShikakuDiv.getTxtMasshoYMD().isReadOnly()
                || !fuzaishaShikakuDiv.getTxtManryoYMD().isReadOnly();
    }

    private RString validate満了日交付日関連エラーチェック南極(RDate 満了日, RDate 交付日) {
        if (満了日.isBefore(交付日)) {
            return 満了日交付日関連エラー南極_1;
        }
        return RString.EMPTY;
    }

    private RString validat抹消日関連エラーチェック南極(FuzaishaShikakuDiv fuzaishaShikakuDiv) {
        RDate 満了日 = fuzaishaShikakuDiv.getTxtManryoYMD().getValue();
        RDate 交付日 = fuzaishaShikakuDiv.getTxtKofuYMD().getValue();
        RDate 抹消日 = fuzaishaShikakuDiv.getTxtMasshoYMD().getValue();
        RDate 登録日 = fuzaishaShikakuDiv.getTxtShikakuTorokuYMD().getValue();
        RString wkエラーメッセージ南極 = new RString("");
        if (is抹消日登録日チェック対象南極(fuzaishaShikakuDiv)
                && null != 登録日 && !登録日.toString().isEmpty()) {
            wkエラーメッセージ南極 = wkエラーメッセージ南極.concat(validate抹消日登録日関連エラーチェック南極(抹消日, 登録日));
        }
        if (is抹消日交付日チェック対象南極(fuzaishaShikakuDiv)
                && null != 交付日 && !交付日.toString().isEmpty()) {
            wkエラーメッセージ南極 = wkエラーメッセージ南極.concat(validate抹消日交付日関連エラーチェック南極(抹消日, 交付日));
        }
        if (is抹消日満了日チェック対象南極(fuzaishaShikakuDiv)
                && null != 満了日 && !満了日.toString().isEmpty()) {
            wkエラーメッセージ南極 = wkエラーメッセージ南極.concat(validate抹消日満了日関連エラーチェック南極(抹消日, 満了日));
        }
        return wkエラーメッセージ南極;
    }

    private RString validate抹消日登録日関連エラーチェック南極(RDate 抹消日, RDate 登録日) {

        if (抹消日.isBefore(登録日)) {
            return 抹消日登録日関連エラー南極;
        }
        return RString.EMPTY;
    }

    private RString validate抹消日交付日関連エラーチェック南極(RDate 抹消日, RDate 交付日) {
        if (抹消日.isBefore(交付日)) {
            return 抹消日交付日関連エラー南極;
        }
        return RString.EMPTY;
    }

    private RString validate抹消日満了日関連エラーチェック南極(RDate 抹消日, RDate 満了日) {
        if (満了日.isBefore(抹消日)) {
            return 抹消日満了日関連エラー南極;
        }
        return RString.EMPTY;
    }

    private HonninJohoResult set宛名PSM南極(ShikibetsuCode 識別コード南極) {
        MeibotorokuZaigai meibotorokuZaigai = MeibotorokuZaigai.createInstance();
        return meibotorokuZaigai.get本人情報初期情報(識別コード南極);
    }
}
