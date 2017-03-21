/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB1040;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.batchprm.reprintsenkyoji.AFABTB104BatchParameter;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelectRange.ITohyokuCodeSelectRangeDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB1040.RePrintSenkyojiDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB1040.dgRePrintSenkyojiSenkyoList_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB1040.dgRePrintSenkyojiShohonSelect_Row;
import jp.co.ndensan.reams.af.afa.service.core.teijitouroku.TeijiTourokuCyohyoSeitei;
import jp.co.ndensan.reams.af.afa.service.senkyojitouroku.SenkyojiTourokuFinder;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 選挙時登録再発行のハンドラクラスです。
 *
 * @reamsid_L AF-0060-010 liss
 */
public class RePrintSenkyojiHandler {

    private final RePrintSenkyojiDiv div;
    private final SenkyojiTourokuFinder finder = SenkyojiTourokuFinder.createInstance();

    /**
     * コンストラクタです。
     *
     * @param div RePrintSenkyojiDiv
     */
    public RePrintSenkyojiHandler(RePrintSenkyojiDiv div) {
        this.div = div;
    }

    /**
     * 選挙一覧を設定します。
     *
     * @param createDataSource List<dgRePrintTeijiShohonSelect_Row>
     */
    public void set選挙一覧(List<dgRePrintSenkyojiShohonSelect_Row> createDataSource) {
        div.getRePrintSenkyojiShohonSelect().getDgRePrintSenkyojiShohonSelect().setDataSource(createDataSource);
    }

    /**
     * 「帳票の条件を設定する」ボタンのイベントメソッドです。
     */
    //CHECKSTYLE IGNORE CyclomaticComplexity FOR NEXT 1 LINES
    public void setChohyoYmd() {
        RString 基準日 = div.getRePrintSenkyojiShohonSelect().getTxtHdnKijunYMD();
        RString 転出期限日 = div.getRePrintSenkyojiShohonSelect().getTxtHdnTenshutsuKigenYMD();
        RString 転入期限日 = div.getRePrintSenkyojiShohonSelect().getTxtHdnTennyuKigenYMD();
        TeijiTourokuCyohyoSeitei cyohyoSeitei = new TeijiTourokuCyohyoSeitei();
        if (基準日 != null && !基準日.equals(RString.EMPTY)) {
            cyohyoSeitei = finder.calcChouhyoDateInfo(
                    new RDate(基準日.toString()), new RDate(転入期限日.toString()), new RDate(転出期限日.toString()));
        }

        if (null != cyohyoSeitei && null != cyohyoSeitei.get転入期間From() && !cyohyoSeitei.get転入期間From().isEmpty()) {
            div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoNijuTorokuTsuchi().getTxtTennyuKikan().setFromValue(
                    new RDate(cyohyoSeitei.get転入期間From().getYearValue(),
                            cyohyoSeitei.get転入期間From().getMonthValue(),
                            cyohyoSeitei.get転入期間From().getDayValue()));
        } else {
            div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoNijuTorokuTsuchi().getTxtTennyuKikan().setFromValue(RDate.MIN);
        }
        if (null != cyohyoSeitei && null != cyohyoSeitei.get転入期間To() && !cyohyoSeitei.get転入期間To().isEmpty()) {
            div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoNijuTorokuTsuchi().getTxtTennyuKikan().setToValue(
                    new RDate(cyohyoSeitei.get転入期間To().getYearValue(),
                            cyohyoSeitei.get転入期間To().getMonthValue(),
                            cyohyoSeitei.get転入期間To().getDayValue()));
        } else {
            div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoNijuTorokuTsuchi().getTxtTennyuKikan().setToValue(RDate.MIN);
        }
        if (null != cyohyoSeitei && null != cyohyoSeitei.get転出期間From() && !cyohyoSeitei.get転出期間From().isEmpty()) {
            div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoNijuChosahyo().getTxtTenshutsuKikan().setFromValue(
                    new RDate(cyohyoSeitei.get転出期間From().getYearValue(),
                            cyohyoSeitei.get転出期間From().getMonthValue(),
                            cyohyoSeitei.get転出期間From().getDayValue()));
        } else {
            div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoNijuChosahyo().getTxtTenshutsuKikan().setFromValue(RDate.MIN);
        }
        if (null != cyohyoSeitei && null != cyohyoSeitei.get転出期間To() && !cyohyoSeitei.get転出期間To().isEmpty()) {
            div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoNijuChosahyo().getTxtTenshutsuKikan().setToValue(
                    new RDate(cyohyoSeitei.get転出期間To().getYearValue(),
                            cyohyoSeitei.get転出期間To().getMonthValue(),
                            cyohyoSeitei.get転出期間To().getDayValue()));
        } else {
            div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoNijuChosahyo().getTxtTenshutsuKikan().setToValue(RDate.MIN);
        }
        if (null != cyohyoSeitei && null != cyohyoSeitei.get帰化期間From() && !cyohyoSeitei.get帰化期間From().isEmpty()) {
            div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoKikaMeibo().getTxtKikaKikan().setFromValue(
                    new RDate(cyohyoSeitei.get帰化期間From().getYearValue(),
                            cyohyoSeitei.get帰化期間From().getMonthValue(),
                            cyohyoSeitei.get帰化期間From().getDayValue()));
        } else {
            div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoKikaMeibo().getTxtKikaKikan().setFromValue(RDate.MIN);
        }
        if (null != cyohyoSeitei && null != cyohyoSeitei.get帰化期間To() && !cyohyoSeitei.get帰化期間To().isEmpty()) {
            div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoKikaMeibo().getTxtKikaKikan().setToValue(
                    new RDate(cyohyoSeitei.get帰化期間To().getYearValue(),
                            cyohyoSeitei.get帰化期間To().getMonthValue(),
                            cyohyoSeitei.get帰化期間To().getDayValue()));
        } else {
            div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoKikaMeibo().getTxtKikaKikan().setToValue(RDate.MIN);
        }
    }

    /**
     * バッチパラメータを設定します。
     *
     * @param div RePrintSenkyojiDiv
     * @return バッチパラメータ
     */
    public AFABTB104BatchParameter setParamter(RePrintSenkyojiDiv div) {
        AFABTB104BatchParameter paramter = new AFABTB104BatchParameter();
        dgRePrintSenkyojiShohonSelect_Row selectedRow = div.getRePrintSenkyojiShohonSelect()
                .getDgRePrintSenkyojiShohonSelect().getSelectedItems().get(0);
        paramter.set抄本番号(selectedRow.getTxtShohonNo());
        paramter.set投票日(selectedRow.getTxtTohyoYMD().getValue());
        paramter.set年齢期限日(selectedRow.getTxtNenreiTotatsuYMD().getValue());
        ArrayList<RString> 選挙Noリスト = new ArrayList<>();
        ArrayList<RString> 選挙名リスト = new ArrayList<>();
        ArrayList<FlexibleDate> 基準日リスト = new ArrayList<>();
        ArrayList<FlexibleDate> 登録日リスト = new ArrayList<>();
        ArrayList<FlexibleDate> 告示日リスト = new ArrayList<>();
        ArrayList<FlexibleDate> 転出期限日リスト = new ArrayList<>();
        ArrayList<FlexibleDate> 転入期限日リスト = new ArrayList<>();
        ArrayList<FlexibleDate> 受付開始日リスト = new ArrayList<>();
        ArrayList<Boolean> 無投票選挙フラグリスト = new ArrayList<>();
        for (dgRePrintSenkyojiSenkyoList_Row row : div.getRePrintSenkyojiShohonSelect().getDgRePrintSenkyojiSenkyoList().getDataSource()) {
            選挙Noリスト.add(row.getTxtSenkyoNo());
            選挙名リスト.add(row.getTxtSenkyoName());
            基準日リスト.add(getNullToFDate(row.getTxtKijunYMD().getValue()));
            登録日リスト.add(getNullToFDate(row.getTxtMeiboTorokuYMD().getValue()));
            告示日リスト.add(getNullToFDate(row.getTxtKokujiYMD().getValue()));
            転出期限日リスト.add(getNullToFDate(row.getTxtTenshutsuKigenYMD().getValue()));
            転入期限日リスト.add(getNullToFDate(row.getTxtTennyuKigenYMD().getValue()));
            受付開始日リスト.add(getNullToFDate(row.getTxtTohyoUketsukeYMD().getValue()));
            無投票選挙フラグリスト.add(row.getChkMutohyoSenkyoFlag());
        }
        paramter.set選挙Noリスト(選挙Noリスト);
        paramter.set選挙名リスト(選挙名リスト);
        paramter.set基準日リスト(基準日リスト);
        paramter.set登録日リスト(登録日リスト);
        paramter.set告示日リスト(告示日リスト);
        paramter.set転出期限日リスト(転出期限日リスト);
        paramter.set転入期限日リスト(転入期限日リスト);
        paramter.set受付開始日リスト(受付開始日リスト);
        paramter.set無投票選挙フラグリスト(無投票選挙フラグリスト);
        paramter.set選挙人名簿抄本出力有無(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoSenkyoninMeiboShohon().isIsPublish());
        paramter.set永久選挙人名簿出力有無(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoEikyuSenkyoninMeibo().isIsPublish());
        paramter.set出力条件(
                div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoEikyuSenkyoninMeibo().getRadEikyuMeiboShoriKubun().getSelectedKey());
        paramter.set識別コード(
                div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoEikyuSenkyoninMeibo().getTxtEikyuMeiboShikibetsuCode().getDomain().value());
        ArrayList<FlexibleDate> 指定日 = new ArrayList<>();
        指定日.add(getNullToFDate(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoEikyuSenkyoninMeibo().getTxtEikyuMeiboShiteiYmdRange().getFromValue()));
        指定日.add(getNullToFDate(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoEikyuSenkyoninMeibo().getTxtEikyuMeiboShiteiYmdRange().getToValue()));
        paramter.set指定日(指定日);
        paramter.set異動事由(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoEikyuSenkyoninMeibo().getDdlEikyuMeiboIdoJiyu().getSelectedValue());
        paramter.set選挙人名簿索引簿出力有無(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoSenkyoninMeiboSakuinbo().isIsPublish());
        paramter.set登録者数リスト出力有無(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoTorokushasuList().isIsPublish());
        paramter.set時点(getNullToFDate(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoTorokushasuList().getTxtTorokushasuListKijunYmd().getValue()));

        paramter.set不在者投票資格者分作成有無(!div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoTorokushasuList().getChkTorokuListFuzaishabun()
                .getSelectedKeys().isEmpty());
        paramter.set不在資格対象者名簿作成有無(!div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoTorokushasuList().getChkFuzaiTohyoMeibo()
                .getSelectedKeys().isEmpty());
        paramter.set有榷者数調べ出力有無(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoYukenshasuList().isIsPublish());
        paramter.set二重登録通知出力有無(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoNijuTorokuTsuchi().isIsPublish());

        paramter.set発行日(getNullToFDate(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoNijuTorokuTsuchi().getCcdPrintNaiyoNijuTsuchi().getTxtHakkoYMD().getValue()));
        RString 発行番号_号 = div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoNijuTorokuTsuchi().getCcdPrintNaiyoNijuTsuchi().getCcdHakkoBango()
                .get発行番号_号();
        RString 発行番号_番号 = div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoNijuTorokuTsuchi().getCcdPrintNaiyoNijuTsuchi().getCcdHakkoBango()
                .get発行番号_番号();
        RString 発行番号_第 = div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoNijuTorokuTsuchi().getCcdPrintNaiyoNijuTsuchi().getCcdHakkoBango()
                .get発行番号_第();
        paramter.set発行番号の第(発行番号_第);
        paramter.set発行番号の番号(発行番号_番号);
        paramter.set発行番号の号(発行番号_号);
        ArrayList<FlexibleDate> 転入期間 = new ArrayList<>();
        転入期間.add(getNullToFDate(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoNijuTorokuTsuchi().getTxtTennyuKikan().getFromValue()));
        転入期間.add(getNullToFDate(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoNijuTorokuTsuchi().getTxtTennyuKikan().getToValue()));
        paramter.set転入期間(転入期間);

        paramter.set送付先宛名シール作成有無(
                !div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoNijuTorokuTsuchi().getChkSealNijuTsuchi().getSelectedKeys().isEmpty());
        paramter.set二重登録通知一覧表作成有無(
                !div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoNijuTorokuTsuchi().getChkNijuTsuchiIchiran().getSelectedKeys().isEmpty());

        paramter.set二重登録調査票有無(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoNijuChosahyo().isIsPublish());
        RString 発行番号_号_調査票 = div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoNijuChosahyo().getCcdPrintNaiyoNijuChosa().getCcdHakkoBango()
                .get発行番号_号();
        RString 発行番号_番号_調査票 = div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoNijuChosahyo().getCcdPrintNaiyoNijuChosa().getCcdHakkoBango()
                .get発行番号_番号();
        RString 発行番号_第_調査票 = div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoNijuChosahyo().getCcdPrintNaiyoNijuChosa().getCcdHakkoBango()
                .get発行番号_第();
        paramter.set発行番号の第_調査票(発行番号_第_調査票);
        paramter.set発行番号の番号_調査票(発行番号_番号_調査票);
        paramter.set発行番号の号_調査票(発行番号_号_調査票);

        paramter.set発行日_調査票(getNullToFDate(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoNijuChosahyo().getCcdPrintNaiyoNijuChosa().getTxtHakkoYMD().getValue()));
        ArrayList<FlexibleDate> 転出期間 = new ArrayList<>();
        転出期間.add(getNullToFDate(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoNijuChosahyo().getTxtTenshutsuKikan().getFromValue()));
        転出期間.add(getNullToFDate(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoNijuChosahyo().getTxtTenshutsuKikan().getToValue()));
        paramter.set転出期間_調査票(転出期間);
        paramter.set送付先宛名シール作成有無_調査票(!div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoNijuChosahyo().getChkSealNijuChosahyo().getSelectedKeys().isEmpty());

        paramter.set二重調査票一覧表作成有無_調査票(!div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoNijuChosahyo().getChkNijuChosahyoIchiran().getSelectedKeys().isEmpty());

        paramter.set登録者名簿出力有無(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoTorokushaMeibo().isIsPublish());
        paramter.set縦覧用作成有無_登録者(!div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoTorokushaMeibo().getChkTorokushaMeiboJuran()
                .getSelectedKeys().isEmpty());
        paramter.set新規登録者宛名シール作成有無(!div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoTorokushaMeibo().getChkSealTorokushaMeibo()
                .getSelectedKeys().isEmpty());
        paramter.set帰化対象者名簿出力有無(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoKikaMeibo().isIsPublish());
        ArrayList<FlexibleDate> 帰化期間 = new ArrayList<>();
        帰化期間.add(getNullToFDate(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoKikaMeibo().getTxtKikaKikan().getFromValue()));
        帰化期間.add(getNullToFDate(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoKikaMeibo().getTxtKikaKikan().getToValue()));
        paramter.set帰化期間(帰化期間);
        paramter.set抹消者名簿出力有無(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoMasshoshaMeibo().isIsPublish());
        paramter.set縦覧用作成有無_抹消者(!div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoMasshoshaMeibo().getChkMasshoshaMeiboJuran()
                .getSelectedKeys().isEmpty());
        paramter.set居住要件抹消者名簿出力有無(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoGakuseiMasshoshaMeibo().isIsPublish());

        paramter.set抹消予定者名簿出力有無(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoMasshoYoteishaMeibo().isIsPublish());
        paramter.set失権者名簿出力有無(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoShikkenshaMeibo().isIsPublish());
        paramter.set表示者名簿出力有無(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoHyojishaMeibo().isIsPublish());
        paramter.set表示消除者名簿出力有無(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoHyojiShojoshaMeibo().isIsPublish());
        paramter.set表示消除予定者名簿出力有無(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoHyojiShojoYoteishaMeibo().isIsPublish());
        paramter.set規定年齢未到達者名簿出力有無(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoMiseinenshaMeibo().isIsPublish());
        paramter.set再転入者名簿出力有無(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoSaiTennyushaMeibo().isIsPublish());
        paramter.set訂正者名簿出力有無(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoTeiseishaMeibo().isIsPublish());
        paramter.set転出者名簿出力有無(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoTenshutsushaMeibo().isIsPublish());

        paramter.set登録停止者名簿出力有無(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoTeishishaMeibo().isIsPublish());
        if (!div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoZaigai().isDisplayNone()) {
            paramter.set在外選挙人名簿抄本出力有無(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoZaigai()
                    .getSakuseiChohyoZaigaiSenkyoninMeiboShohon().isIsPublish());
            paramter.set在外投票資格者名簿出力有無(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoZaigai()
                    .getSakuseiChohyoZaigaiShikakushaMeibo().isIsPublish());
            paramter.set在外投票管理票出力有無(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoZaigai()
                    .getSakuseiChohyoZaigaiTohyoKanrihyo().isIsPublish());
        } else {
            paramter.set在外選挙人名簿抄本出力有無(false);
            paramter.set在外投票資格者名簿出力有無(false);
            paramter.set在外投票管理票出力有無(false);
        }

        ITohyokuCodeSelectRangeDiv 投票区コード = div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoSenkyoninMeiboShohon()
                .getCcdTohyokuCodeRange();
        paramter.set投票区From(投票区コード.get投票区コードFROM());
        paramter.set投票区To(投票区コード.get投票区コードTO());

        return paramter;

    }

    private FlexibleDate getNullToFDate(RDate date) {
        if (null == date) {
            return FlexibleDate.EMPTY;
        } else {
            return new FlexibleDate(date.toDateString().toString());
        }
    }
}
