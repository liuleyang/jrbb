/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMG1020;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.shohon.senkyo.Senkyo;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMG1020.KokuminTohyoJohoShuseiDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMG1020.dgKokuminShusei_Row;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 国民投票情報修正のHandlerクラスです。
 *
 * @reamsid_L AF-0370-010 lis
 */
public final class KokuminTohyoJohoShuseiHandler {

    private final KokuminTohyoJohoShuseiDiv div;

    private KokuminTohyoJohoShuseiHandler(KokuminTohyoJohoShuseiDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ
     *
     * @param div 返戻帳票照会Div
     * @return KojiKessaiShinseiPanelHandler
     */
    public static KokuminTohyoJohoShuseiHandler of(KokuminTohyoJohoShuseiDiv div) {
        return new KokuminTohyoJohoShuseiHandler(div);
    }

    /**
     * set選挙一覧の設定です。
     *
     * @param rowList List<dgSenkyoShusei_Row>
     */
    public void set選挙一覧(List<dgKokuminShusei_Row> rowList) {
        div.getKokuminShusei().getDgKokuminShusei().setDataSource(rowList);
    }

    /**
     * 抄本情報と選挙情報を画面に表示する。
     *
     * @param mainPanel KokuminTohyoJohoShuseiDiv
     * @param senkyoResult List<Senkyo>
     *
     */
    public void set抄本情報と選挙情報(KokuminTohyoJohoShuseiDiv mainPanel, List<Senkyo> senkyoResult) {
        RDate 年齢到達日 = mainPanel.getCcdKokuminShuseiShohon().getCcdShohonNameList().getSelectedKiteiNenreiTotatsuYMD();
        RString 抄本名 = mainPanel.getCcdKokuminShuseiShohon().getCcdShohonNameList().getSelectedShohonName();
        RDate 投票日 = mainPanel.getCcdKokuminShuseiShohon().getCcdShohonNameList().getSelectedTohyoYMD();
        mainPanel.getCcdKokuminShuseiShohon().get国民投票抄本情報().getTxtShohonName().setValue(抄本名);
        mainPanel.getCcdKokuminShuseiShohon().get国民投票抄本情報().getTxtTohyoYMD().setValue(投票日);
        mainPanel.getCcdKokuminShuseiShohon().get国民投票抄本情報().getTxtNenreiTotatsuYMD().setValue(年齢到達日);

        FlexibleDate 名簿基準年月日 = senkyoResult.get(0).get名簿基準年月日();
        FlexibleDate 名簿登録日 = senkyoResult.get(0).get名簿登録年月日();
        FlexibleDate 特定期限日 = senkyoResult.get(0).get転入期限年月日();
        FlexibleDate 受付開始日 = senkyoResult.get(0).get投票受付開始年月日();
        if (名簿基準年月日 != null && !名簿基準年月日.isEmpty() && 名簿基準年月日.isValid()) {
            mainPanel.getCcdKokuminShuseiShohon().get国民投票抄本情報().getTxtKijunYMD()
                    .setValue(new RDate(名簿基準年月日.toString()));
        }
        if (名簿登録日 != null && !名簿登録日.isEmpty() && 名簿登録日.isValid()) {
            mainPanel.getCcdKokuminShuseiShohon().get国民投票抄本情報().getTxtMeiboTorokuYMD()
                    .setValue(new RDate(名簿登録日.toString()));
        }
        if (特定期限日 != null && !特定期限日.isEmpty() && 特定期限日.isValid()) {
            mainPanel.getCcdKokuminShuseiShohon().get国民投票抄本情報().getTxtTokuteiKigenYMD()
                    .setValue(new RDate(特定期限日.toString()));
        }
        if (受付開始日 != null && !受付開始日.isEmpty() && 受付開始日.isValid()) {
            mainPanel.getCcdKokuminShuseiShohon().get国民投票抄本情報().getTxtTohyoUketsukeYMD()
                    .setValue(new RDate(受付開始日.toString()));
        }
    }

    /**
     * clean選挙一覧をクリアする。
     *
     */
    public void clean選挙一覧() {
        div.getKokuminShusei().getDgKokuminShusei().getDataSource().clear();
    }

}
