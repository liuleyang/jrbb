/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB1010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.SimulationMenuId;
import jp.co.ndensan.reams.af.afa.definition.batchprm.senkyojitouroku.AFABTB101BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.MeiboSakuseiKijun.dgSenkyojiSenkyoNyuryoku_Row;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelectRange.ITohyokuCodeSelectRangeDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB1010.SenkyojiTorokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.af.afa.service.core.senkyojitoroku.SenkyojiTourokuValidationService;
import jp.co.ndensan.reams.af.afa.service.core.teijitouroku.TeijiTourokuCyohyoSeitei;
import jp.co.ndensan.reams.af.afa.service.senkyojitouroku.SenkyojiTourokuFinder;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 選挙時登録画面のHandlerです。
 *
 * @reamsid_L AF-0030-010 liss
 */
public class SenkyojiTorokuHandler {

    private static final RString メニューID_シミュレーション = new RString("AFAMNB4010");
    private static final RString 処理モード_通常処理 = new RString("1");
    private static final RString 処理モード_シミュレーション = new RString("2");
    private static final SenkyoShurui SENKYO_SHURUI = SenkyoShurui.国政選挙_地方選挙;
    private static final int 三ヶ月 = 3;
    private final SenkyojiTourokuFinder finder = SenkyojiTourokuFinder.createInstance();
    private final SenkyojiTorokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div SenkyojiTorokuDiv
     */
    public SenkyojiTorokuHandler(SenkyojiTorokuDiv div) {
        this.div = div;
    }

    /**
     * 選挙時登録のLoadメソッドです。
     */
    public void onLoad() {
        ViewState.setメニューID(ResponseHolder.getMenuID());
        CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("btnBatchExecute"), Boolean.TRUE);
        div.getCcdSenkyojiMeiboSakuseiKijun().getCcdShohonNameList().setChkKakoShohonDisplayNoneMode(Boolean.TRUE);
        div.getCcdSenkyojiMeiboSakuseiKijun().getCcdShohonNameList().setReadOnlyMode(Boolean.TRUE);
        div.getCcdSenkyojiMeiboSakuseiKijun().initialize(SENKYO_SHURUI);
        div.getCcdSenkyojiSakuseiChohyo().initialize(SENKYO_SHURUI);
        div.getCcdSenkyojiSakuseiChohyo().initialize(null, null, null, null);
        div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoNijuTorokuTsuchi().setIsOpen(Boolean.TRUE);
        div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoNijuChosahyo().setIsOpen(Boolean.TRUE);
        div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoIdoKikaMeibo().setIsOpen(Boolean.TRUE);
    }

    /**
     * 実行ボタン押下時のイベントメソッドです。
     *
     * @return AFABTB101BatchParameter
     */
    public AFABTB101BatchParameter onClick_btnExecute() {
        AFABTB101BatchParameter paramter = new AFABTB101BatchParameter();
        this.setParamter(paramter, div);
        return paramter;
    }

    /**
     * 「帳票の条件を設定する」ボタンのイベントメソッドです。
     */
    //CHECKSTYLE IGNORE CyclomaticComplexity FOR NEXT 20 LINES
    public void onClick_btnSetChohyoYmd() {
        RDate 転入期限日 = RDate.MAX;
        RDate 転出期限日 = RDate.MIN;
        RDate 基準日 = RDate.MIN;
        List<dgSenkyojiSenkyoNyuryoku_Row> dataSource = div.getCcdSenkyojiMeiboSakuseiKijun().get選挙情報();
        for (dgSenkyojiSenkyoNyuryoku_Row row : dataSource) {
            基準日 = get基準日の最大値(row, 基準日);
            転出期限日 = get転出日の最大値(row, 転出期限日);
            転入期限日 = get転入日の最小値(row, 転入期限日);
        }

        TeijiTourokuCyohyoSeitei cyohyoSeitei = finder.calcChouhyoDateInfo(基準日, 転入期限日, 転出期限日);
        if (null != cyohyoSeitei && null != cyohyoSeitei.get転入期間From() && !cyohyoSeitei.get転入期間From().isEmpty()) {
            div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoNijuTorokuTsuchi().getTxtTennyuKikan().setFromValue(
                    new RDate(cyohyoSeitei.get転入期間From().getYearValue(),
                            cyohyoSeitei.get転入期間From().getMonthValue(),
                            cyohyoSeitei.get転入期間From().getDayValue()));
        } else {
            div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoNijuTorokuTsuchi().getTxtTennyuKikan().clearFromValue();
        }
        if (null != cyohyoSeitei && null != cyohyoSeitei.get転入期間To() && !cyohyoSeitei.get転入期間To().isEmpty()) {
            div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoNijuTorokuTsuchi().getTxtTennyuKikan().setToValue(
                    new RDate(cyohyoSeitei.get転入期間To().getYearValue(),
                            cyohyoSeitei.get転入期間To().getMonthValue(),
                            cyohyoSeitei.get転入期間To().getDayValue()));
        } else {
            div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoNijuTorokuTsuchi().getTxtTennyuKikan().clearToValue();
        }
        if (null != cyohyoSeitei && null != cyohyoSeitei.get転出期間From() && !cyohyoSeitei.get転出期間From().isEmpty()) {
            div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoNijuChosahyo().getTxtTenshutsuKikan().setFromValue(
                    new RDate(cyohyoSeitei.get転出期間From().getYearValue(),
                            cyohyoSeitei.get転出期間From().getMonthValue(),
                            cyohyoSeitei.get転出期間From().getDayValue()));
        } else {
            div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoNijuChosahyo().getTxtTenshutsuKikan().clearFromValue();
        }
        if (null != cyohyoSeitei && null != cyohyoSeitei.get転出期間To() && !cyohyoSeitei.get転出期間To().isEmpty()) {
            div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoNijuChosahyo().getTxtTenshutsuKikan().setToValue(
                    new RDate(cyohyoSeitei.get転出期間To().getYearValue(),
                            cyohyoSeitei.get転出期間To().getMonthValue(),
                            cyohyoSeitei.get転出期間To().getDayValue()));
        } else {
            div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoNijuChosahyo().getTxtTenshutsuKikan().clearToValue();
        }
        if (null != cyohyoSeitei && null != cyohyoSeitei.get帰化期間From() && !cyohyoSeitei.get帰化期間From().isEmpty()) {
            div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoIdoKikaMeibo().getTxtKikaKikan().setFromValue(
                    new RDate(cyohyoSeitei.get帰化期間From().getYearValue(),
                            cyohyoSeitei.get帰化期間From().getMonthValue(),
                            cyohyoSeitei.get帰化期間From().getDayValue()));
        } else {
            div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoIdoKikaMeibo().getTxtKikaKikan().clearFromValue();
        }
        if (null != cyohyoSeitei && null != cyohyoSeitei.get帰化期間To() && !cyohyoSeitei.get帰化期間To().isEmpty()) {
            div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoIdoKikaMeibo().getTxtKikaKikan().setToValue(
                    new RDate(cyohyoSeitei.get帰化期間To().getYearValue(),
                            cyohyoSeitei.get帰化期間To().getMonthValue(),
                            cyohyoSeitei.get帰化期間To().getDayValue()));
        } else {
            div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoIdoKikaMeibo().getTxtKikaKikan().clearToValue();
        }
    }

    /**
     * 年齢期限日と投票日の関係性チェックです。
     *
     * @return チェック結果
     */
    public boolean 年齢期限日と投票日の関係性チェック() {
        RDate 年齢期限日 = div.getCcdSenkyojiMeiboSakuseiKijun().getTxtNenreiTotatsuYMD().getValue();
        RDate 投票日 = div.getCcdSenkyojiMeiboSakuseiKijun().getTxtTohyoYMD().getValue();
        return 年齢期限日.compareTo(投票日.plusDay(1)) != 0;
    }

    /**
     * 定時登録実行有無確認です。
     *
     * @return チェック結果
     */
    public boolean 定時登録実行有無確認() {
        if (new SimulationMenuId().isSimulationMenuId(ResponseHolder.getMenuID())) {
            return false;
        }
        RDate 基準日To = RDate.MIN;
        for (dgSenkyojiSenkyoNyuryoku_Row 選挙情報 : div.getCcdSenkyojiMeiboSakuseiKijun().get選挙情報()) {
            if (基準日To.isBefore(選挙情報.getTxtKijunYMD().getValue())) {
                基準日To = 選挙情報.getTxtKijunYMD().getValue();
            }
        }
        RDate 基準日From = 基準日To.minusMonth(三ヶ月);
        FlexibleDate 編集済基準日From = new FlexibleDate(基準日From.getYearValue(), 基準日From.getMonthValue(), 基準日From.getDayValue());
        FlexibleDate 編集済基準日To = new FlexibleDate(基準日To.getYearValue(), 基準日To.getMonthValue(), 基準日To.getDayValue());
        return SenkyojiTourokuValidationService.createInstance().validate定時登録実行有無(編集済基準日From, 編集済基準日To);
    }

    /**
     * 同じ抄本チェックです。
     *
     * @return チェック結果
     */
    public boolean 同じ抄本チェック() {
        RString 投票日 = div.getCcdSenkyojiMeiboSakuseiKijun().getTxtTohyoYMD().getText();
        return SenkyojiTourokuValidationService.createInstance().validate同じ抄本(投票日);
    }

    private void setParamter(AFABTB101BatchParameter paramter, SenkyojiTorokuDiv div) {
        paramter.set処理モード(get処理モード());
        paramter.set処理種別(div.getCcdSenkyojiMeiboSakuseiKijun().getRadShori().getSelectedKey());
        paramter.set抄本番号(getNullToInteger(div.getCcdSenkyojiMeiboSakuseiKijun().getCcdShohonNameList().getSelectedShohonNo()));
        paramter.set抄本名(div.getCcdSenkyojiMeiboSakuseiKijun().getTxtShohonName().getValue());
        paramter.set投票日(getNullToFDate(div.getCcdSenkyojiMeiboSakuseiKijun().getTxtTohyoYMD().getValue()));
        paramter.set年齢期限日(getNullToFDate(div.getCcdSenkyojiMeiboSakuseiKijun().getTxtNenreiTotatsuYMD().getValue()));
        paramter.set研修用データ作成有無(!メニューID_シミュレーション.equals(ResponseHolder.getMenuID()));

        ArrayList<RString> 選挙Noリスト = new ArrayList<>();
        ArrayList<RString> 選挙レベルリスト = new ArrayList<>();
        ArrayList<RString> 選挙名リスト = new ArrayList<>();
        ArrayList<RString> 選挙略称リスト = new ArrayList<>();
        ArrayList<RString> 選挙マークリスト = new ArrayList<>();
        ArrayList<FlexibleDate> 基準日リスト = new ArrayList<>();
        ArrayList<FlexibleDate> 登録日リスト = new ArrayList<>();
        ArrayList<FlexibleDate> 告示日リスト = new ArrayList<>();
        ArrayList<FlexibleDate> 転出期限日リスト = new ArrayList<>();
        ArrayList<FlexibleDate> 転入期限日リスト = new ArrayList<>();
        ArrayList<FlexibleDate> 受付開始日リスト = new ArrayList<>();
        int i = 0;
        for (dgSenkyojiSenkyoNyuryoku_Row row : div.getCcdSenkyojiMeiboSakuseiKijun().get選挙情報()) {
            if (RString.isNullOrEmpty(row.getTxtNo())) {
                選挙Noリスト.add(new RString(String.valueOf(i + 1)));
            } else {
                選挙Noリスト.add(row.getTxtNo());
            }
            選挙レベルリスト.add(row.getDdlLevel().getSelectedKey());
            選挙名リスト.add(row.getTxtSenkyoName().getValue());
            選挙略称リスト.add(row.getTxtSenkyoRyakusho().getValue());
            選挙マークリスト.add(row.getTxtSenkyoMark().getValue());
            基準日リスト.add(getNullToFDate(row.getTxtKijunYMD().getValue()));
            登録日リスト.add(getNullToFDate(row.getTxtMeiboTorokuYMD().getValue()));
            告示日リスト.add(getNullToFDate(row.getTxtKokujiYMD().getValue()));
            転出期限日リスト.add(getNullToFDate(row.getTxtTenshutsuKigenYMD().getValue()));
            転入期限日リスト.add(getNullToFDate(row.getTxtTennyuKigenYMD().getValue()));
            受付開始日リスト.add(getNullToFDate(row.getTxtTohyoUketsukeYMD().getValue()));
            i++;
        }

        paramter.set選挙Noリスト(選挙Noリスト);
        paramter.set選挙レベルリスト(選挙レベルリスト);
        paramter.set選挙名リスト(選挙名リスト);
        paramter.set選挙略称リスト(選挙略称リスト);
        paramter.set選挙マークリスト(選挙マークリスト);
        paramter.set基準日リスト(基準日リスト);
        paramter.set登録日リスト(登録日リスト);
        paramter.set告示日リスト(告示日リスト);
        paramter.set転出期限日リスト(転出期限日リスト);
        paramter.set転入期限日リスト(転入期限日リスト);
        paramter.set受付開始日リスト(受付開始日リスト);
        paramter.set選挙人名簿抄本出力有無(div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoSenkyoninMeiboShohon().isIsPublish());
        paramter.set永久選挙人名簿出力有無(div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoEikyuSenkyoninMeibo().isIsPublish());
        paramter.set出力条件(
                div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoEikyuSenkyoninMeibo().getRadEikyuMeiboShoriKubun().getSelectedKey());
        paramter.set識別コード(
                div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoEikyuSenkyoninMeibo().getTxtEikyuMeiboShikibetsuCode().getDomain().value());
        ArrayList<FlexibleDate> 指定日 = new ArrayList<>();
        指定日.add(getNullToFDate(div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoEikyuSenkyoninMeibo().getTxtEikyuMeiboShiteiYmdRange().getFromValue()));
        指定日.add(getNullToFDate(div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoEikyuSenkyoninMeibo().getTxtEikyuMeiboShiteiYmdRange().getToValue()));
        paramter.set指定日(指定日);
        paramter.set異動事由(div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoEikyuSenkyoninMeibo().getDdlEikyuMeiboIdoJiyu().getSelectedValue());
        paramter.set選挙人名簿索引簿出力有無(div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoSenkyoninMeiboSakuinbo().isIsPublish());
        paramter.set登録者数リスト出力有無(div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoTorokushasuList().isIsPublish());
        paramter.set時点(getNullToFDate(div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoTorokushasuList().getTxtTorokushasuListKijunYmd().getValue()));
        paramter.set不在者投票資格者分作成有無(!div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoTorokushasuList().getChkTorokuListFuzaishabun()
                .getSelectedKeys().isEmpty());
        paramter.set不在資格対象者名簿作成有無(!div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoTorokushasuList().getChkFuzaiTohyoMeibo()
                .getSelectedKeys().isEmpty());
        paramter.set有榷者数調べ出力有無(div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoYukenshasuList().isIsPublish());
        paramter.set二重登録通知出力有無(div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoNijuTorokuTsuchi().isIsPublish());
        paramter.set発行日(getNullToFDate(div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoNijuTorokuTsuchi()
                .getCcdPrintNaiyoNijuTsuchi().getTxtHakkoYMD().getValue()));
        RString 発行番号_号 = div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoNijuTorokuTsuchi().getCcdPrintNaiyoNijuTsuchi().getCcdHakkoBango()
                .get発行番号_号();
        RString 発行番号_番号 = div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoNijuTorokuTsuchi().getCcdPrintNaiyoNijuTsuchi().getCcdHakkoBango()
                .get発行番号_番号();
        RString 発行番号_第 = div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoNijuTorokuTsuchi().getCcdPrintNaiyoNijuTsuchi().getCcdHakkoBango()
                .get発行番号_第();
        paramter.set発行番号の第(発行番号_第);
        paramter.set発行番号の番号(発行番号_番号);
        paramter.set発行番号の号(発行番号_号);
        ArrayList<FlexibleDate> 転入期間 = new ArrayList<>();
        転入期間.add(getNullToFDate(div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoNijuTorokuTsuchi().getTxtTennyuKikan().getFromValue()));
        転入期間.add(getNullToFDate(div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoNijuTorokuTsuchi().getTxtTennyuKikan().getToValue()));
        paramter.set転入期間(転入期間);
        paramter.set送付先宛名シール作成有無(
                !div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoNijuTorokuTsuchi().getChkSealNijuTsuchi().getSelectedKeys().isEmpty());
        paramter.set二重登録通知一覧表作成有無(
                !div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoNijuTorokuTsuchi().getChkNijuTsuchiIchiran().getSelectedKeys().isEmpty());
        paramter.set二重登録調査票有無(div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoNijuChosahyo().isIsPublish());
        RString 発行番号_号_調査票 = div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoNijuChosahyo().getCcdPrintNaiyoNijuChosa().getCcdHakkoBango()
                .get発行番号_号();
        RString 発行番号_番号_調査票 = div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoNijuChosahyo().getCcdPrintNaiyoNijuChosa().getCcdHakkoBango()
                .get発行番号_番号();
        RString 発行番号_第_調査票 = div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoNijuChosahyo().getCcdPrintNaiyoNijuChosa().getCcdHakkoBango()
                .get発行番号_第();
        paramter.set発行番号の第_調査票(発行番号_第_調査票);
        paramter.set発行番号の番号_調査票(発行番号_番号_調査票);
        paramter.set発行番号の号_調査票(発行番号_号_調査票);
        paramter.set発行日_調査票(getNullToFDate(div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoNijuChosahyo()
                .getCcdPrintNaiyoNijuChosa().getTxtHakkoYMD().getValue()));
        ArrayList<FlexibleDate> 転出期間 = new ArrayList<>();
        転出期間.add(getNullToFDate(div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoNijuChosahyo().getTxtTenshutsuKikan().getFromValue()));
        転出期間.add(getNullToFDate(div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoNijuChosahyo().getTxtTenshutsuKikan().getToValue()));
        paramter.set転出期間_調査票(転出期間);
        paramter.set送付先宛名シール作成有無_調査票(!div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoNijuChosahyo()
                .getChkSealNijuChosahyo().getSelectedKeys().isEmpty());
        paramter.set二重調査票一覧表作成有無_調査票(!div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoNijuChosahyo()
                .getChkNijuChosahyoIchiran().getSelectedKeys().isEmpty());
        paramter.set登録者名簿出力有無(div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoIdoTorokushaMeibo().isIsPublish());
        paramter.set縦覧用作成有無_登録者(!div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoIdoTorokushaMeibo().getChkTorokushaMeiboJuran()
                .getSelectedKeys().isEmpty());
        paramter.set新規登録者宛名シール作成有無(!div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoIdoTorokushaMeibo().getChkSealTorokushaMeibo()
                .getSelectedKeys().isEmpty());
        paramter.set帰化対象者名簿出力有無(div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoIdoKikaMeibo().isIsPublish());
        ArrayList<FlexibleDate> 帰化期間 = new ArrayList<>();
        帰化期間.add(getNullToFDate(div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoIdoKikaMeibo().getTxtKikaKikan().getFromValue()));
        帰化期間.add(getNullToFDate(div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoIdoKikaMeibo().getTxtKikaKikan().getToValue()));
        paramter.set帰化期間(帰化期間);
        paramter.set抹消者名簿出力有無(div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoIdoMasshoshaMeibo().isIsPublish());
        paramter.set縦覧用作成有無_抹消者(!div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoIdoMasshoshaMeibo().getChkMasshoshaMeiboJuran()
                .getSelectedKeys().isEmpty());
        paramter.set居住要件抹消者名簿出力有無(div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoIdoGakuseiMasshoshaMeibo().isIsPublish());
        paramter.set抹消予定者名簿出力有無(div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoIdoMasshoYoteishaMeibo().isIsPublish());
        paramter.set失権者名簿出力有無(div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoIdoShikkenshaMeibo().isIsPublish());
        paramter.set表示者名簿出力有無(div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoIdoHyojishaMeibo().isIsPublish());
        paramter.set表示消除者名簿出力有無(div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoIdoHyojiShojoshaMeibo().isIsPublish());
        paramter.set表示消除予定者名簿出力有無(div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoIdoHyojiShojoYoteishaMeibo().isIsPublish());
        paramter.set規定年齢未到達者名簿出力有無(div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoIdoMiseinenshaMeibo().isIsPublish());
        paramter.set再転入者名簿出力有無(div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoIdoSaiTennyushaMeibo().isIsPublish());
        paramter.set訂正者名簿出力有無(div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoIdoTeiseishaMeibo().isIsPublish());
        paramter.set転出者名簿出力有無(div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoIdoTenshutsushaMeibo().isIsPublish());
        paramter.set登録停止者名簿出力有無(div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoIdoTeishishaMeibo().isIsPublish());
        if (!div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoZaigai().isDisplayNone()) {
            paramter.set在外選挙人名簿抄本出力有無(div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoZaigai()
                    .getSakuseiChohyoZaigaiSenkyoninMeiboShohon().isIsPublish());
            paramter.set在外投票資格者名簿出力有無(div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoZaigai()
                    .getSakuseiChohyoZaigaiShikakushaMeibo().isIsPublish());
            paramter.set在外投票管理票出力有無(div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoZaigai()
                    .getSakuseiChohyoZaigaiTohyoKanrihyo().isIsPublish());
        } else {
            paramter.set在外選挙人名簿抄本出力有無(false);
            paramter.set在外投票資格者名簿出力有無(false);
            paramter.set在外投票管理票出力有無(false);
        }
        ITohyokuCodeSelectRangeDiv 投票区コード = div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoSenkyoninMeiboShohon().getCcdTohyokuCodeRange();
        paramter.set投票区From(投票区コード.get投票区コードFROM());
        paramter.set投票区To(投票区コード.get投票区コードTO());
    }

    private RString getNullToInteger(RString args) {
        if (null == args || args.isEmpty()) {
            return new RString("0");
        } else {
            return args;
        }
    }

    private FlexibleDate getNullToFDate(RDate date) {
        if (null == date) {
            return FlexibleDate.EMPTY;
        } else {
            return new FlexibleDate(date.toDateString().toString());
        }
    }

    private RDate get転入日の最小値(dgSenkyojiSenkyoNyuryoku_Row row, RDate wkMinTennyuYmd) {
        row.getTxtTennyuKigenYMD().setValue(div.getCcdSenkyojiMeiboSakuseiKijun().getTxtTennyuYMD().getValue());
//        if (div.getCcdSenkyojiMeiboSakuseiKijun().getTxtTennyuYMD().getValue() != null) {
//            if (!row.getTxtTennyuKigenYMD().toString().isEmpty()
//                    && !wkMinTennyuYmd.isBefore(row.getTxtTennyuKigenYMD().getValue())) {
        if (div.getCcdSenkyojiMeiboSakuseiKijun().getTxtTennyuYMD().getValue() != null
                && !row.getTxtTennyuKigenYMD().toString().isEmpty()
                && !wkMinTennyuYmd.isBefore(row.getTxtTennyuKigenYMD().getValue())) {
            wkMinTennyuYmd = row.getTxtTennyuKigenYMD().getValue();
//            }
        }
        return wkMinTennyuYmd;
    }

    private RDate get転出日の最大値(dgSenkyojiSenkyoNyuryoku_Row row, RDate wkMaxTenshutsuYmd) {
        row.getTxtTenshutsuKigenYMD().setValue(div.getCcdSenkyojiMeiboSakuseiKijun().getTxtTenshutsuYMD().getValue());
//        if (div.getCcdSenkyojiMeiboSakuseiKijun().getTxtTenshutsuYMD().getValue() != null) {
//            if (!row.getTxtTenshutsuKigenYMD().toString().isEmpty()
//                    && wkMaxTenshutsuYmd.isBefore(row.getTxtTenshutsuKigenYMD().getValue())) {
        if (div.getCcdSenkyojiMeiboSakuseiKijun().getTxtTenshutsuYMD().getValue() != null
                && !row.getTxtTenshutsuKigenYMD().toString().isEmpty()
                && wkMaxTenshutsuYmd.isBefore(row.getTxtTenshutsuKigenYMD().getValue())) {
            wkMaxTenshutsuYmd = row.getTxtTenshutsuKigenYMD().getValue();
//            }
        }
        return wkMaxTenshutsuYmd;
    }

    private RDate get基準日の最大値(dgSenkyojiSenkyoNyuryoku_Row row, RDate wkMaxKijunYmd) {
        row.getTxtKijunYMD().setValue(div.getCcdSenkyojiMeiboSakuseiKijun().getTxtKijunYMD().getValue());
//        if (div.getCcdSenkyojiMeiboSakuseiKijun().getTxtKijunYMD().getValue() != null) {
//            if (!row.getTxtKijunYMD().toString().isEmpty()
//                    && wkMaxKijunYmd.isBefore(row.getTxtKijunYMD().getValue())) {
        if (div.getCcdSenkyojiMeiboSakuseiKijun().getTxtKijunYMD().getValue() != null
                && !row.getTxtKijunYMD().toString().isEmpty()
                && wkMaxKijunYmd.isBefore(row.getTxtKijunYMD().getValue())) {
            wkMaxKijunYmd = row.getTxtKijunYMD().getValue();
//            }
        }
        return wkMaxKijunYmd;
    }

    private RString get処理モード() {
        RString 処理モード;
        if (メニューID_シミュレーション.equals(ResponseHolder.getMenuID())) {
            処理モード = 処理モード_シミュレーション;
        } else {
            処理モード = 処理モード_通常処理;
        }
        return 処理モード;
    }
}
