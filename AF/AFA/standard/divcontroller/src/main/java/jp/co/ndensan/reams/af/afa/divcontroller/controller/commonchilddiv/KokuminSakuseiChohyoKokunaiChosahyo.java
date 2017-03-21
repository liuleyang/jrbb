/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.KokuminSakuseiChohyoType;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminSakuseiChohyo.KokuminSakuseiChohyoKokunaiChosahyoDiv;

/**
 * 【共有子Div】KokuminSakuseiChohyoDiv内の<br />
 * KokuminSakuseiChohyoKokunaiChosahyoDivに対応するコントローラです。
 *
 * @author N1823 有澤 礼恵
 * @reamsid_L AF-0360-012 liwul
 */
public final class KokuminSakuseiChohyoKokunaiChosahyo {

    private KokuminSakuseiChohyoKokunaiChosahyo() {
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div KokuminSakuseiChohyoKokunaiChosahyoDiv
     */
    public static void setData(KokuminSakuseiChohyoKokunaiChosahyoDiv div) {
        div.getCcdPrintNaiyoKokunaiChosa().initialize(KokuminSakuseiChohyoType.在外_国内転入照会.getValue());
    }

    /**
     * 項目をクリアします。
     *
     * @param div KokuminSakuseiChohyoKokunaiChosahyoDiv
     */
    public static void clearData(KokuminSakuseiChohyoKokunaiChosahyoDiv div) {
        div.getCcdPrintNaiyoKokunaiChosa().clearData();
        div.getChkSealKokunaiChosa().setSelectedItems(div.getChkSealKokunaiChosa().getDataSource());
        div.getChkKokunaiChosaIchiran().setSelectedItems(div.getChkKokunaiChosaIchiran().getDataSource());
    }

}
