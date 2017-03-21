/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGME5030;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5030.NippoSakuseiChohyoFuzaishaIchiranDiv;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;

/**
 * 【View】NippoSakuseiDiv内の <br />
 * NippoSakuseiChohyoDiv内の <br />
 * NippoSakuseiChohyoFuzaishaIchiranDivに対するコントローラです。
 *
 * @author N1823 有澤 礼恵
 */
public final class NippoSakuseiChohyoFuzaishaIchiran {

    private NippoSakuseiChohyoFuzaishaIchiran() {
    }

    /**
     * 抄本ドロップダウンリスト選択時の処理をするメソッドです。
     *
     * @param div NippoSakuseiChohyoFuzaishaIchiranDiv
     * @param senkyoShurui SenkyoShurui
     */
    public static void setData(NippoSakuseiChohyoFuzaishaIchiranDiv div, SenkyoShurui senkyoShurui) {

        div.getCcdFuzaishaIchiranTohyokuCode().initialize(senkyoShurui);
        div.getCcdFuzaishaIchiranShisetsuCode().initialize();
    }

    /**
     * 入力条件のクリア処理をするメソッドです。
     *
     * @param div NippoSakuseiChohyoFuzaishaIchiranDiv
     */
    public static void clearThisPanel(NippoSakuseiChohyoFuzaishaIchiranDiv div) {
        div.getCcdFuzaishaIchiranTohyokuCode().clearData();
        div.getCcdFuzaishaIchiranShisetsuCode().clearData();

        div.getTxtFuzaishaIchiranKofuYMD().clearFromValue();
        div.getTxtFuzaishaIchiranKofuYMD().clearToValue();
        div.getTxtFuzaishaIchiranJuriYMD().clearFromValue();
        div.getTxtFuzaishaIchiranJuriYMD().clearToValue();
        div.getTxtFuzaishaIchiranJuriTime().clearFromValue();
        div.getTxtFuzaishaIchiranJuriTime().clearToValue();
        div.getChkFuzaishaIchiranTaisho().getSelectedItems().clear();
    }

}
