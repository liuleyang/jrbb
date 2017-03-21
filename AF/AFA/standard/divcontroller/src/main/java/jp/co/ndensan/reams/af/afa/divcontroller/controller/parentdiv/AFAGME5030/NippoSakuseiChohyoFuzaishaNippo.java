/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGME5030;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5030.NippoSakuseiChohyoFuzaishaNippoDiv;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;

/**
 * 【View】NippoSakuseiDiv内の <br />
 * NippoSakuseiChohyoDiv内の <br />
 * NippoSakuseiChohyoFuzaishaNippoDivに対するコントローラです。
 *
 * @author N1823 有澤 礼恵
 */
public final class NippoSakuseiChohyoFuzaishaNippo {

    private NippoSakuseiChohyoFuzaishaNippo() {
    }

    /**
     * 抄本ドロップダウンリスト選択時の処理をするメソッドです。
     *
     * @param div NippoSakuseiChohyoFuzaishaNippoDiv
     * @param senkyoShurui SenkyoShurui
     */
    public static void setData(NippoSakuseiChohyoFuzaishaNippoDiv div, SenkyoShurui senkyoShurui) {

    }

    /**
     * 入力条件のクリア処理をするメソッドです。
     *
     * @param div NippoSakuseiChohyoFuzaishaNippoDiv
     */
    public static void clearThisPanel(NippoSakuseiChohyoFuzaishaNippoDiv div) {
        div.getChkKofuNippo().getSelectedItems().clear();
        div.getChkJuriNippo().getSelectedItems().clear();
        div.getTxtFuzaishaNippoKofuYMD().clearFromValue();
        div.getTxtFuzaishaNippoKofuYMD().clearToValue();
        div.getTxtFuzaishaNippoJuriYMD().clearFromValue();
        div.getTxtFuzaishaNippoJuriYMD().clearToValue();
    }

}
