/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGME5030;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5030.NippoSakuseiChohyoKijitsumaeIchiranDiv;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;

/**
 * 【View】NippoSakuseiDiv内の <br />
 * NippoSakuseiChohyoDiv内の <br />
 * NippoSakuseiChohyoKijitsumaeIchiranDivに対するコントローラです。
 *
 * @author N1823 有澤 礼恵
 */
public final class NippoSakuseiChohyoKijitsumaeIchiran {

    private NippoSakuseiChohyoKijitsumaeIchiran() {
    }

    /**
     * 抄本ドロップダウンリスト選択時の処理をするメソッドです。
     *
     * @param div NippoSakuseiChohyoKijitsumaeIchiranDiv
     * @param senkyoShurui SenkyoShurui
     */
    public static void setData(NippoSakuseiChohyoKijitsumaeIchiranDiv div, SenkyoShurui senkyoShurui) {

        div.getCcdKijitsumaeIchiranTohyokuCode().initialize(senkyoShurui);
        div.getCcdKijitsumaeIchiranShisetsuCode().initialize();
    }

    /**
     * 入力条件のクリア処理をするメソッドです。
     *
     * @param div NippoSakuseiChohyoKijitsumaeIchiranDiv
     */
    public static void clearThisPanel(NippoSakuseiChohyoKijitsumaeIchiranDiv div) {
        div.getCcdKijitsumaeIchiranTohyokuCode().clearData();
        div.getCcdKijitsumaeIchiranShisetsuCode().clearData();

        div.getTxtKijitsumaeIchiranTohyoYMD().clearFromValue();
        div.getTxtKijitsumaeIchiranTohyoYMD().clearToValue();
        div.getTxtKijitsumaeIchiranTohyoTime().clearFromValue();
        div.getTxtKijitsumaeIchiranTohyoTime().clearToValue();
        div.getChkKjitsuzenIchiranTaisho().getSelectedItems().clear();
    }

}
