/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGME5030;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5030.NippoSakuseiChohyoDiv;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;

/**
 * 【View】NippoSakuseiDiv内の <br />
 * NippoSakuseiChohyoDivに対するコントローラです。
 *
 * @author N1823 有澤 礼恵
 */
public final class NippoSakuseiChohyo {

    private NippoSakuseiChohyo() {
    }

    /**
     * 抄本ドロップダウンリスト選択時の処理をするメソッドです。
     *
     * @param div TaishoShohonJohoDiv
     * @param senkyoShurui SenkyoShurui
     */
    public static void setData(NippoSakuseiChohyoDiv div, SenkyoShurui senkyoShurui) {
        NippoSakuseiChohyoKijitsumaeNippo.setData(div.getNippoSakuseiChohyoKijitsumaeNippo(), senkyoShurui);
        NippoSakuseiChohyoFuzaishaNippo.setData(div.getNippoSakuseiChohyoFuzaishaNippo(), senkyoShurui);
        NippoSakuseiChohyoKijitsumaeIchiran.setData(div.getNippoSakuseiChohyoKijitsumaeIchiran(), senkyoShurui);
        NippoSakuseiChohyoFuzaishaIchiran.setData(div.getNippoSakuseiChohyoFuzaishaIchiran(), senkyoShurui);
        NippoSakuseiChohyoTohyoshaIchiran.setData(div.getNippoSakuseiChohyoTohyoshaIchiran(), senkyoShurui);
        NippoSakuseiChohyoJiyuChosho.setData(div.getNippoSakuseiChohyoJiyuChosho(), senkyoShurui);
        NippoSakuseiChohyoSeirihyo.setData(div.getNippoSakuseiChohyoSeirihyo(), senkyoShurui);
    }

    /**
     * 入力条件のクリア処理をするメソッドです。
     *
     * @param div TaishoShohonJohoDiv
     */
    public static void clearData(NippoSakuseiChohyoDiv div) {
        NippoSakuseiChohyoKijitsumaeNippo.clearThisPanel(div.getNippoSakuseiChohyoKijitsumaeNippo());
        NippoSakuseiChohyoFuzaishaNippo.clearThisPanel(div.getNippoSakuseiChohyoFuzaishaNippo());
        NippoSakuseiChohyoKijitsumaeIchiran.clearThisPanel(div.getNippoSakuseiChohyoKijitsumaeIchiran());
        NippoSakuseiChohyoFuzaishaIchiran.clearThisPanel(div.getNippoSakuseiChohyoFuzaishaIchiran());
        NippoSakuseiChohyoTohyoshaIchiran.clearThisPanel(div.getNippoSakuseiChohyoTohyoshaIchiran());
        NippoSakuseiChohyoJiyuChosho.clearThisPanel(div.getNippoSakuseiChohyoJiyuChosho());
        NippoSakuseiChohyoSeirihyo.clearThisPanel(div.getNippoSakuseiChohyoSeirihyo());
    }

}
