/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGME5030;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5030.NippoSakuseiChohyoKijitsumaeNippoDiv;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;

/**
 * 【View】NippoSakuseiDiv内の <br />
 * NippoSakuseiChohyoDiv内の <br />
 * NippoSakuseiChohyoKijitsumaeNippoDivに対するコントローラです。
 *
 * @author N1823 有澤 礼恵
 */
public final class NippoSakuseiChohyoKijitsumaeNippo {

    private NippoSakuseiChohyoKijitsumaeNippo() {
    }

    /**
     * 抄本ドロップダウンリスト選択時の処理をするメソッドです。
     *
     * @param div NippoSakuseiChohyoKijitsumaeNippoDiv
     * @param senkyoShurui SenkyoShurui
     */
    public static void setData(NippoSakuseiChohyoKijitsumaeNippoDiv div, SenkyoShurui senkyoShurui) {

        div.getCcdKijitsumaeNippoShisetsuCode().initialize();
    }

    /**
     * 入力条件のクリア処理をするメソッドです。
     *
     * @param div NippoSakuseiChohyoKijitsumaeNippoDiv
     */
    public static void clearThisPanel(NippoSakuseiChohyoKijitsumaeNippoDiv div) {
        div.getCcdKijitsumaeNippoShisetsuCode().clearData();
        div.getTxtKijitsumaNippoTohyoYMD().clearFromValue();
        div.getTxtKijitsumaNippoTohyoYMD().clearToValue();
    }

}
