/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGME5030;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5030.NippoSakuseiChohyoJiyuChoshoDiv;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;

/**
 * 【View】NippoSakuseiDiv内の <br />
 * NippoSakuseiChohyoDiv内の <br />
 * NippoSakuseiChohyoJiyuChoshoDivに対するコントローラです。
 *
 * @author N1823 有澤 礼恵
 */
public final class NippoSakuseiChohyoJiyuChosho {

    private NippoSakuseiChohyoJiyuChosho() {
    }

    /**
     * 抄本ドロップダウンリスト選択時の処理をするメソッドです。
     *
     * @param div NippoSakuseiChohyoJiyuChoshoDiv
     * @param senkyoShurui SenkyoShurui
     */
    public static void setData(NippoSakuseiChohyoJiyuChoshoDiv div, SenkyoShurui senkyoShurui) {

    }

    /**
     * 入力条件のクリア処理をするメソッドです。
     *
     * @param div NippoSakuseiChohyoJiyuChoshoDiv
     */
    public static void clearThisPanel(NippoSakuseiChohyoJiyuChoshoDiv div) {
        div.getChkKijitsumaeJiyuChosho().getSelectedItems().clear();
        div.getChkFuzaishaJiyuChosho().getSelectedItems().clear();
        div.getTxtJiyuChoshoKijitsumaeTohyoYMD().clearFromValue();
        div.getTxtJiyuChoshoKijitsumaeTohyoYMD().clearToValue();
        div.getTxtJiyuChoshoJuriYMD().clearFromValue();
        div.getTxtJiyuChoshoJuriYMD().clearToValue();
    }

}
