/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMA1010;

import java.util.ArrayList;
import jp.co.ndensan.reams.af.afa.definition.batchprm.teijitouroku.AFABTA101BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.af.afa.service.core.teijitouroku.TeijiTourokuCyohyoSeitei;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 *
 * 定時登録Handlerです。
 */
public class TeijiTorokuHandler {

    private final TeijiTorokuDiv div;
    private static final SenkyoShurui SENKYO_SHURUI = SenkyoShurui.定時登録;

    /**
     *
     * @param div
     */
    public TeijiTorokuHandler(TeijiTorokuDiv div) {
        this.div = div;
    }

    /**
     * 定時登録のLoadメソッです。
     */
    public void onLoad() {
        ViewState.setメニューID(ResponseHolder.getMenuID());
        div.getCcdTeijiMeiboSakuseiKijun().initialize(SENKYO_SHURUI);
        div.getCcdTeijiSakuseiChohyo().initialize(SENKYO_SHURUI);
        this.onClick_btnSetChohyoYmd();
    }

    /**
     * 実行ボタン押下時のイベントメソッドです。
     *
     * @param seitei TeijiTourokuCyohyoSeitei
     * @param 処理モード 処理モード
     * @return AFABTA101BatchParameter
     */
    public AFABTA101BatchParameter onClick_btnExecute(TeijiTourokuCyohyoSeitei seitei, RString 処理モード) {
        AFABTA101BatchParameter paramter = new AFABTA101BatchParameter();
        this.setParamter(paramter, seitei, 処理モード);
        return paramter;
    }

    /**
     * 「帳票の条件を設定する」ボタンのイベントメソッドです。
     */
    public void onClick_btnSetChohyoYmd() {
        div.getCcdTeijiSakuseiChohyo().initialize(div.getCcdTeijiMeiboSakuseiKijun().getTxtTennyuYMD().getValue(),
                div.getCcdTeijiMeiboSakuseiKijun().getTxtTenshutsuYMD().getValue(),
                div.getCcdTeijiMeiboSakuseiKijun().getTxtKijunYMD().getValue(),
                null);

    }

    private void setParamter(AFABTA101BatchParameter paramter, TeijiTourokuCyohyoSeitei seitei, RString 処理モード) {
        paramter.set処理種別(div.getCcdTeijiMeiboSakuseiKijun().getRadShori().getSelectedKey());
        paramter.set抄本番号(div.getCcdTeijiMeiboSakuseiKijun().getCcdShohonNameList().getSelectedShohonNo());
        paramter.set抄本名(div.getCcdTeijiMeiboSakuseiKijun().getTxtShohonName().getValue());
        paramter.set投票日(getNullToFDate(div.getCcdTeijiMeiboSakuseiKijun().getTxtKijunYMD().getValue()));
        paramter.set基準日(getNullToFDate(div.getCcdTeijiMeiboSakuseiKijun().getTxtKijunYMD().getValue()));
        paramter.set登録日(getNullToFDate(div.getCcdTeijiMeiboSakuseiKijun().getTxtMeiboTorokuYMD().getValue()));
        paramter.set転出期限日(getNullToFDate(div.getCcdTeijiMeiboSakuseiKijun().getTxtTenshutsuYMD().getValue()));
        paramter.set転入期限日(getNullToFDate(div.getCcdTeijiMeiboSakuseiKijun().getTxtTennyuYMD().getValue()));
        paramter.set年齢期限日(getNullToFDate(div.getCcdTeijiMeiboSakuseiKijun().getTxtNenreiTotatsuYMD().getValue()));
        paramter.set選挙人名簿抄本出力有無(div.getCcdTeijiSakuseiChohyo().getSakuseiChohyoSenkyoninMeiboShohon().isIsPublish());
        paramter.set投票区From(div.getCcdTeijiSakuseiChohyo().getSakuseiChohyoSenkyoninMeiboShohon().getCcdTohyokuCodeRange().get投票区コードFROM());
        paramter.set投票区To(div.getCcdTeijiSakuseiChohyo().getSakuseiChohyoSenkyoninMeiboShohon().getCcdTohyokuCodeRange().get投票区コードTO());
        paramter.set永久選挙人名簿出力有無(div.getCcdTeijiSakuseiChohyo().getSakuseiChohyoEikyuSenkyoninMeibo().isIsPublish());
        paramter.set出力条件(
                div.getCcdTeijiSakuseiChohyo().getSakuseiChohyoEikyuSenkyoninMeibo().getRadEikyuMeiboShoriKubun().getSelectedKey());
        paramter.set識別コード(
                div.getCcdTeijiSakuseiChohyo().getSakuseiChohyoEikyuSenkyoninMeibo().getTxtEikyuMeiboShikibetsuCode().getDomain().value());
        ArrayList<FlexibleDate> 指定日List = new ArrayList<>();
        指定日List.add(getNullToFDate(
                div.getCcdTeijiSakuseiChohyo().getSakuseiChohyoEikyuSenkyoninMeibo().getTxtEikyuMeiboShiteiYmdRange().getFromValue()));
        指定日List.add(getNullToFDate(
                div.getCcdTeijiSakuseiChohyo().getSakuseiChohyoEikyuSenkyoninMeibo().getTxtEikyuMeiboShiteiYmdRange().getToValue()));
        paramter.set指定日(指定日List);
        paramter.set異動事由(div.getCcdTeijiSakuseiChohyo().getSakuseiChohyoEikyuSenkyoninMeibo().getDdlEikyuMeiboIdoJiyu().getSelectedKey());
        paramter.set選挙人名簿索引簿出力有無(div.getCcdTeijiSakuseiChohyo().getSakuseiChohyoSenkyoninMeiboSakuinbo().isIsPublish());
        Boolean 登録者数リスト出力有無 = div.getCcdTeijiSakuseiChohyo().getSakuseiChohyoTorokushasuList().isIsPublish();
        paramter.set登録者数リスト出力有無(登録者数リスト出力有無);
        if (登録者数リスト出力有無) {
            paramter.set不在者投票資格者分作成有無(!div.getCcdTeijiSakuseiChohyo().getSakuseiChohyoTorokushasuList().getChkTorokuListFuzaishabun()
                    .getSelectedKeys().isEmpty());
            paramter.set不在資格対象者名簿作成有無(!div.getCcdTeijiSakuseiChohyo().getSakuseiChohyoTorokushasuList().getChkFuzaiTohyoMeibo()
                    .getSelectedKeys().isEmpty());
        } else {
            paramter.set不在者投票資格者分作成有無(false);
            paramter.set不在資格対象者名簿作成有無(false);
        }
        paramter.set時点(getNullToFDate(div.getCcdTeijiMeiboSakuseiKijun().getTxtKijunYMD().getValue()));
        paramter.set有榷者数調べ出力有無(div.getCcdTeijiSakuseiChohyo().getSakuseiChohyoYukenshasuList().isIsPublish());
        Boolean 二重登録通知出力有無 = div.getCcdTeijiSakuseiChohyo().getSakuseiChohyoNijuTorokuTsuchi().isIsPublish();
        paramter.set二重登録通知出力有無(二重登録通知出力有無);
        paramter.set発行日(getNullToFDate(
                div.getCcdTeijiSakuseiChohyo().getSakuseiChohyoNijuTorokuTsuchi().getCcdPrintNaiyoNijuTsuchi().getTxtHakkoYMD().getValue()));
        RString 発行番号_号 = div.getCcdTeijiSakuseiChohyo().getSakuseiChohyoNijuTorokuTsuchi().getCcdPrintNaiyoNijuTsuchi().getCcdHakkoBango()
                .get発行番号_号();
        RString 発行番号_番号 = div.getCcdTeijiSakuseiChohyo().getSakuseiChohyoNijuTorokuTsuchi().getCcdPrintNaiyoNijuTsuchi().getCcdHakkoBango()
                .get発行番号_番号();
        RString 発行番号_第 = div.getCcdTeijiSakuseiChohyo().getSakuseiChohyoNijuTorokuTsuchi().getCcdPrintNaiyoNijuTsuchi().getCcdHakkoBango()
                .get発行番号_第();
        paramter.set発行番号の第(発行番号_第);
        paramter.set発行番号の番号(発行番号_番号);
        paramter.set発行番号の号(発行番号_号);
        RDate 転入期間From = div.getCcdTeijiSakuseiChohyo().getSakuseiChohyoNijuTorokuTsuchi().getTxtTennyuKikan().getFromValue();
        RDate 転入期間To = div.getCcdTeijiSakuseiChohyo().getSakuseiChohyoNijuTorokuTsuchi().getTxtTennyuKikan().getToValue();
        ArrayList<FlexibleDate> 転入期間List = new ArrayList<>();
        if (null == 転入期間From || null == 転入期間To) {
            転入期間List.add(seitei.get転入期間From());
            転入期間List.add(seitei.get転入期間To());
        } else {
            転入期間List.add(getNullToFDate(転入期間From));
            転入期間List.add(getNullToFDate(転入期間To));
        }
        paramter.set転入期間(転入期間List);
        if (二重登録通知出力有無) {
            paramter.set送付先宛名シール作成有無(
                    !div.getCcdTeijiSakuseiChohyo().getSakuseiChohyoNijuTorokuTsuchi().getChkSealNijuTsuchi().getSelectedKeys().isEmpty());
            paramter.set二重登録通知一覧表作成有無(
                    !div.getCcdTeijiSakuseiChohyo().getSakuseiChohyoNijuTorokuTsuchi().getChkNijuTsuchiIchiran().getSelectedKeys().isEmpty());
        } else {
            paramter.set送付先宛名シール作成有無(false);
            paramter.set二重登録通知一覧表作成有無(false);
        }
        Boolean 登録者名簿出力有無 = div.getCcdTeijiSakuseiChohyo().getSakuseiChohyoIdoTorokushaMeibo().isIsPublish();
        paramter.set登録者名簿出力有無(登録者名簿出力有無);
        if (登録者名簿出力有無) {
            paramter.set縦覧用作成有無_登録者(!div.getCcdTeijiSakuseiChohyo().getSakuseiChohyoIdoTorokushaMeibo().getChkTorokushaMeiboJuran()
                    .getSelectedKeys().isEmpty());
            paramter.set新規登録者宛名シール作成有無(!div.getCcdTeijiSakuseiChohyo().getSakuseiChohyoIdoTorokushaMeibo().getChkSealTorokushaMeibo()
                    .getSelectedKeys().isEmpty());
        } else {
            paramter.set縦覧用作成有無_登録者(false);
            paramter.set新規登録者宛名シール作成有無(false);
        }
        paramter.set帰化対象者名簿出力有無(div.getCcdTeijiSakuseiChohyo().getSakuseiChohyoIdoKikaMeibo().isIsPublish());
        RDate 帰化期間From = div.getCcdTeijiSakuseiChohyo().getSakuseiChohyoIdoKikaMeibo().getTxtKikaKikan().getFromValue();
        RDate 帰化期間To = div.getCcdTeijiSakuseiChohyo().getSakuseiChohyoIdoKikaMeibo().getTxtKikaKikan().getToValue();
        ArrayList<FlexibleDate> 帰化期間List = new ArrayList<>();
        if (null == 帰化期間From || null == 帰化期間To) {
            帰化期間List.add(seitei.get帰化期間From());
            帰化期間List.add(seitei.get帰化期間To());
        } else {
            帰化期間List.add(getNullToFDate(帰化期間From));
            帰化期間List.add(getNullToFDate(帰化期間To));
        }
        paramter.set帰化期間(帰化期間List);
        Boolean 抹消者名簿出力有無 = div.getCcdTeijiSakuseiChohyo().getSakuseiChohyoIdoMasshoshaMeibo().isIsPublish();
        paramter.set抹消者名簿出力有無(抹消者名簿出力有無);
        if (抹消者名簿出力有無) {
            paramter.set縦覧用作成有無_抹消者(!div.getCcdTeijiSakuseiChohyo().getSakuseiChohyoIdoMasshoshaMeibo().getChkMasshoshaMeiboJuran()
                    .getSelectedKeys().isEmpty());
        } else {
            paramter.set縦覧用作成有無_抹消者(false);
        }
        paramter.set居住要件抹消者名簿出力有無(div.getCcdTeijiSakuseiChohyo().getSakuseiChohyoIdoGakuseiMasshoshaMeibo().isIsPublish());
        paramter.set表示者名簿出力有無(div.getCcdTeijiSakuseiChohyo().getSakuseiChohyoIdoHyojishaMeibo().isIsPublish());
        paramter.set表示消除者名簿出力有無(div.getCcdTeijiSakuseiChohyo().getSakuseiChohyoIdoHyojiShojoshaMeibo().isIsPublish());
        Boolean 規定年齢前名簿出力有無 = div.getCcdTeijiSakuseiChohyo().getSakuseiChohyoIdo19saishaMeibo().isIsPublish();
        paramter.set規定年齢前名簿出力有無(規定年齢前名簿出力有無);
        if (規定年齢前名簿出力有無) {
            paramter.set規定年齢前シール作成有無(!div.getCcdTeijiSakuseiChohyo().getSakuseiChohyoIdo19saishaMeibo().getChkSeal19saishaMeibo()
                    .getSelectedKeys().isEmpty());
        } else {
            paramter.set規定年齢前シール作成有無(false);
        }
        paramter.set規定年齢未到達者名簿出力有無(div.getCcdTeijiSakuseiChohyo().getSakuseiChohyoIdoMiseinenshaMeibo().isIsPublish());
        paramter.set再転入者名簿出力有無(div.getCcdTeijiSakuseiChohyo().getSakuseiChohyoIdoSaiTennyushaMeibo().isIsPublish());
        paramter.set訂正者名簿出力有無(div.getCcdTeijiSakuseiChohyo().getSakuseiChohyoIdoTeiseishaMeibo().isIsPublish());
        paramter.set転出者名簿出力有無(div.getCcdTeijiSakuseiChohyo().getSakuseiChohyoIdoTenshutsushaMeibo().isIsPublish());
        paramter.set登録停止者名簿出力有無(div.getCcdTeijiSakuseiChohyo().getSakuseiChohyoIdoTeishishaMeibo().isIsPublish());
        if (div.getCcdTeijiSakuseiChohyo().getSakuseiChohyoZaigai().isDisplayNone()) {
            paramter.set在外選挙人名簿抄本出力有無(false);
            paramter.set在外投票資格者名簿出力有無(false);
        } else {
            paramter.set在外選挙人名簿抄本出力有無(div.getCcdTeijiSakuseiChohyo().getSakuseiChohyoZaigai()
                    .getSakuseiChohyoZaigaiSenkyoninMeiboShohon().isIsPublish());
            paramter.set在外投票資格者名簿出力有無(div.getCcdTeijiSakuseiChohyo().getSakuseiChohyoZaigai()
                    .getSakuseiChohyoZaigaiShikakushaMeibo().isIsPublish());
        }

        paramter.set処理モード(処理モード);
    }

    /**
     * RDateから、FlexibleDateに変換する処理です。
     *
     * @param date date
     * @return FlexibleDate
     */
    public FlexibleDate getNullToFDate(RDate date) {
        if (null == date) {
            return FlexibleDate.EMPTY;
        } else {
            return new FlexibleDate(date.getYearValue(), date.getMonthValue(), date.getDayValue());
        }
    }
}
