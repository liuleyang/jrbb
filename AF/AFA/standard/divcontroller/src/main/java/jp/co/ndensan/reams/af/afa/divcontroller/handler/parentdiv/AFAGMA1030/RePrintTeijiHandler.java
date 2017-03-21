/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMA1030;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.shohon.shohon.Shohon;
import jp.co.ndensan.reams.af.afa.definition.batchprm.reprintteiji.AFABTA103BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SakuseiChohyo.ISakuseiChohyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMA1030.RePrintTeijiDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMA1030.dgRePrintTeijiShohonSelect_Row;
import jp.co.ndensan.reams.af.afa.service.core.shohon.shohon.ShohonManager;
import jp.co.ndensan.reams.af.afa.service.core.teijitouroku.TeijiTourokuCyohyoSeitei;
import jp.co.ndensan.reams.af.afa.service.senkyojitouroku.SenkyojiTourokuFinder;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 定時登録再発行のハンドラクラスです。
 *
 * @reamsid_L AF-0020-010 gaoya
 */
public class RePrintTeijiHandler {

    private final RePrintTeijiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div RePrintTeijiDiv
     */
    public RePrintTeijiHandler(RePrintTeijiDiv div) {
        this.div = div;
    }

    /**
     * 選挙一覧を設定します。
     *
     * @param createDataSource List<dgRePrintTeijiShohonSelect_Row>
     */
    public void set選挙一覧(List<dgRePrintTeijiShohonSelect_Row> createDataSource) {
        div.getRePrintTeijiShohonSelect().getDgRePrintTeijiShohonSelect().setDataSource(createDataSource);
    }

    /**
     * バッチパラメータを設定します。
     *
     * @param div RePrintTeijiDiv
     * @return バッチパラメータ
     */
    //CHECKSTYLE IGNORE CyclomaticComplexity FOR NEXT 10 LINES
    public AFABTA103BatchParameter setバッチパラメータ(RePrintTeijiDiv div) {
        AFABTA103BatchParameter paramter = new AFABTA103BatchParameter();
        dgRePrintTeijiShohonSelect_Row row
                = div.getRePrintTeijiShohonSelect().getDgRePrintTeijiShohonSelect().getClickedItem();
        ISakuseiChohyoDiv sakuseiChohyo = div.getCcdRePrintTeijiSakuseiChohyo();
        Shohon shohon = ShohonManager.createInstance().get抄本(new ShohonNo(row.getTxtShohonNo()));
        paramter.set投票日(shohon.get投票年月日());
        paramter.set抄本番号(row.getTxtShohonNo());
        paramter.set抄本名(row.getTxtShohonName());
        paramter.set基準日(row.getTxtKijunYMD().getValue());
        paramter.set登録日(row.getTxtMeiboTorokuYMD().getValue());
        paramter.set転出期限日(row.getTxtTenshutsuKigenYMD().getValue());
        paramter.set転入期限日(row.getTxtTennyuKigenYMD().getValue());
        paramter.set年齢期限日(row.getTxtNenreiTotatsuYMD().getValue());
        paramter.set処理日(row.getTxtShoriYMD().getValue());
        paramter.set選挙人名簿抄本出力有無(sakuseiChohyo.getSakuseiChohyoSenkyoninMeiboShohon().isIsPublish());
        paramter.set投票区From(sakuseiChohyo.getSakuseiChohyoSenkyoninMeiboShohon().getCcdTohyokuCodeRange().get投票区コードFROM());
        paramter.set投票区To(sakuseiChohyo.getSakuseiChohyoSenkyoninMeiboShohon().getCcdTohyokuCodeRange().get投票区コードTO());
        paramter.set永久選挙人名簿出力有無(sakuseiChohyo.getSakuseiChohyoEikyuSenkyoninMeibo().isIsPublish());
        paramter.set出力条件(
                sakuseiChohyo.getSakuseiChohyoEikyuSenkyoninMeibo().getRadEikyuMeiboShoriKubun().getSelectedKey());
        paramter.set識別コード(
                sakuseiChohyo.getSakuseiChohyoEikyuSenkyoninMeibo().getTxtEikyuMeiboShikibetsuCode().getDomain().value());
        ArrayList<FlexibleDate> 指定日List = new ArrayList<>();
        指定日List.add(getNullToFDate(
                sakuseiChohyo.getSakuseiChohyoEikyuSenkyoninMeibo().getTxtEikyuMeiboShiteiYmdRange().getFromValue()));
        指定日List.add(getNullToFDate(
                sakuseiChohyo.getSakuseiChohyoEikyuSenkyoninMeibo().getTxtEikyuMeiboShiteiYmdRange().getToValue()));
        paramter.set指定日(指定日List);
        paramter.set異動事由(sakuseiChohyo.getSakuseiChohyoEikyuSenkyoninMeibo().getDdlEikyuMeiboIdoJiyu().getSelectedValue());
        paramter.set選挙人名簿索引簿出力有無(sakuseiChohyo.getSakuseiChohyoSenkyoninMeiboSakuinbo().isIsPublish());
        Boolean 登録者数リスト出力有無 = sakuseiChohyo.getSakuseiChohyoTorokushasuList().isIsPublish();
        paramter.set登録者数リスト出力有無(登録者数リスト出力有無);
        if (登録者数リスト出力有無) {
            paramter.set不在者投票資格者分作成有無(!sakuseiChohyo.getSakuseiChohyoTorokushasuList().getChkTorokuListFuzaishabun()
                    .getSelectedKeys().isEmpty());
            paramter.set不在資格対象者名簿作成有無(!sakuseiChohyo.getSakuseiChohyoTorokushasuList().getChkFuzaiTohyoMeibo()
                    .getSelectedKeys().isEmpty());
        } else {
            paramter.set不在者投票資格者分作成有無(Boolean.FALSE);
            paramter.set不在資格対象者名簿作成有無(Boolean.FALSE);
        }
        paramter.set時点(getNullToFDate(sakuseiChohyo.getSakuseiChohyoTorokushasuList().getTxtTorokushasuListKijunYmd().getValue()));
        if ((null != paramter.get基準日() && !paramter.get基準日().isEmpty()
                && (null == paramter.get時点() || paramter.get時点().isEmpty()))) {
            paramter.set時点(paramter.get基準日());
        }

        paramter.set有榷者数調べ出力有無(sakuseiChohyo.getSakuseiChohyoYukenshasuList().isIsPublish());
        Boolean 二重登録通知出力有無 = sakuseiChohyo.getSakuseiChohyoNijuTorokuTsuchi().isIsPublish();
        paramter.set二重登録通知出力有無(二重登録通知出力有無);
        paramter.set発行日(getNullToFDate(
                sakuseiChohyo.getSakuseiChohyoNijuTorokuTsuchi().getCcdPrintNaiyoNijuTsuchi().getTxtHakkoYMD().getValue()));
        RString 発行番号_号 = sakuseiChohyo.getSakuseiChohyoNijuTorokuTsuchi().getCcdPrintNaiyoNijuTsuchi().getCcdHakkoBango()
                .get発行番号_号();
        RString 発行番号_番号 = sakuseiChohyo.getSakuseiChohyoNijuTorokuTsuchi().getCcdPrintNaiyoNijuTsuchi().getCcdHakkoBango()
                .get発行番号_番号();
        RString 発行番号_第 = sakuseiChohyo.getSakuseiChohyoNijuTorokuTsuchi().getCcdPrintNaiyoNijuTsuchi().getCcdHakkoBango()
                .get発行番号_第();
        paramter.set発行番号の第(発行番号_第);
        paramter.set発行番号の番号(発行番号_番号);
        paramter.set発行番号の号(発行番号_号);
        ArrayList<FlexibleDate> 転入期間List = new ArrayList<>();
        転入期間List.add(getNullToFDate(sakuseiChohyo.getSakuseiChohyoNijuTorokuTsuchi().getTxtTennyuKikan().getFromValue()));
        転入期間List.add(getNullToFDate(sakuseiChohyo.getSakuseiChohyoNijuTorokuTsuchi().getTxtTennyuKikan().getToValue()));
        paramter.set転入期間(転入期間List);
        if (二重登録通知出力有無) {
            paramter.set送付先宛名シール作成有無(
                    !sakuseiChohyo.getSakuseiChohyoNijuTorokuTsuchi().getChkSealNijuTsuchi().getSelectedKeys().isEmpty());
            paramter.set二重登録通知一覧表作成有無(
                    !sakuseiChohyo.getSakuseiChohyoNijuTorokuTsuchi().getChkNijuTsuchiIchiran().getSelectedKeys().isEmpty());
        } else {
            paramter.set送付先宛名シール作成有無(Boolean.FALSE);
            paramter.set二重登録通知一覧表作成有無(Boolean.FALSE);
        }
        Boolean 登録者名簿出力有無 = sakuseiChohyo.getSakuseiChohyoIdoTorokushaMeibo().isIsPublish();
        paramter.set登録者名簿出力有無(登録者名簿出力有無);
        if (登録者名簿出力有無) {
            paramter.set縦覧用作成有無_登録者(!sakuseiChohyo.getSakuseiChohyoIdoTorokushaMeibo().getChkTorokushaMeiboJuran()
                    .getSelectedKeys().isEmpty());
            paramter.set新規登録者宛名シール作成有無(!sakuseiChohyo.getSakuseiChohyoIdoTorokushaMeibo().getChkSealTorokushaMeibo()
                    .getSelectedKeys().isEmpty());
        } else {
            paramter.set縦覧用作成有無_登録者(Boolean.FALSE);
            paramter.set新規登録者宛名シール作成有無(Boolean.FALSE);
        }

        paramter.set帰化対象者名簿出力有無(sakuseiChohyo.getSakuseiChohyoIdoKikaMeibo().isIsPublish());
        ArrayList<FlexibleDate> 帰化期間List = new ArrayList<>();
        帰化期間List.add(getNullToFDate(sakuseiChohyo.getSakuseiChohyoIdoKikaMeibo().getTxtKikaKikan().getFromValue()));
        帰化期間List.add(getNullToFDate(sakuseiChohyo.getSakuseiChohyoIdoKikaMeibo().getTxtKikaKikan().getToValue()));
        paramter.set帰化期間(帰化期間List);

        if ((null != paramter.get基準日() && !paramter.get基準日().isEmpty())
                && null != paramter.get転入期限日() && !paramter.get転入期限日().isEmpty()
                && null != paramter.get転出期限日() && !paramter.get転出期限日().isEmpty()) {
            TeijiTourokuCyohyoSeitei teijiTourokuCyohyoSeitei
                    = SenkyojiTourokuFinder.createInstance().calcChouhyoDateInfo(
                            new RDate(paramter.get基準日().toString()),
                            new RDate(paramter.get転入期限日().toString()),
                            new RDate(paramter.get転出期限日().toString()));
            if (転入期間List.get(0).isEmpty() || 転入期間List.get(1).isEmpty()) {
                転入期間List.set(0, teijiTourokuCyohyoSeitei.get転入期間From());
                転入期間List.set(1, teijiTourokuCyohyoSeitei.get転入期間To());
                paramter.set転入期間(転入期間List);
            }
            if (帰化期間List.get(0).isEmpty() || 帰化期間List.get(1).isEmpty()) {
                帰化期間List.set(0, teijiTourokuCyohyoSeitei.get帰化期間From());
                帰化期間List.set(1, teijiTourokuCyohyoSeitei.get帰化期間To());
                paramter.set帰化期間(帰化期間List);
            }
        }

        Boolean 抹消者名簿出力有無 = sakuseiChohyo.getSakuseiChohyoIdoMasshoshaMeibo().isIsPublish();
        paramter.set抹消者名簿出力有無(抹消者名簿出力有無);
        if (抹消者名簿出力有無) {
            paramter.set縦覧用作成有無_抹消者(!sakuseiChohyo.getSakuseiChohyoIdoMasshoshaMeibo().getChkMasshoshaMeiboJuran()
                    .getSelectedKeys().isEmpty());
        } else {
            paramter.set縦覧用作成有無_抹消者(Boolean.FALSE);
        }
        paramter.set居住要件抹消者名簿出力有無(sakuseiChohyo.getSakuseiChohyoIdoGakuseiMasshoshaMeibo().isIsPublish());
        paramter.set表示者名簿出力有無(sakuseiChohyo.getSakuseiChohyoIdoHyojishaMeibo().isIsPublish());
        paramter.set表示消除者名簿出力有無(sakuseiChohyo.getSakuseiChohyoIdoHyojiShojoshaMeibo().isIsPublish());
        Boolean 規定年齢前名簿出力有無 = sakuseiChohyo.getSakuseiChohyoIdo19saishaMeibo().isIsPublish();
        paramter.set規定年齢前名簿出力有無(規定年齢前名簿出力有無);
        if (規定年齢前名簿出力有無) {
            paramter.set規定年齢前シール作成有無(!sakuseiChohyo.getSakuseiChohyoIdo19saishaMeibo().getChkSeal19saishaMeibo()
                    .getSelectedKeys().isEmpty());
        } else {
            paramter.set規定年齢前シール作成有無(Boolean.FALSE);
        }
        paramter.set規定年齢未到達者名簿出力有無(sakuseiChohyo.getSakuseiChohyoIdoMiseinenshaMeibo().isIsPublish());
        paramter.set再転入者名簿出力有無(sakuseiChohyo.getSakuseiChohyoIdoSaiTennyushaMeibo().isIsPublish());
        paramter.set訂正者名簿出力有無(sakuseiChohyo.getSakuseiChohyoIdoTeiseishaMeibo().isIsPublish());
        paramter.set転出者名簿出力有無(sakuseiChohyo.getSakuseiChohyoIdoTenshutsushaMeibo().isIsPublish());
        paramter.set登録停止者名簿出力有無(sakuseiChohyo.getSakuseiChohyoIdoTeishishaMeibo().isIsPublish());
        paramter.set在外選挙人名簿抄本出力有無(sakuseiChohyo.getSakuseiChohyoZaigai()
                .getSakuseiChohyoZaigaiSenkyoninMeiboShohon().isIsPublish());
        paramter.set在外投票資格者名簿出力有無(sakuseiChohyo.getSakuseiChohyoZaigai()
                .getSakuseiChohyoZaigaiShikakushaMeibo().isIsPublish());
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
