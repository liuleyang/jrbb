/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.KokuminSakuseiChohyoType;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminSakuseiChohyo.KokuminSakuseiChohyoKokugaiChosahyoDiv;

/**
 * 【共有子Div】KokuminSakuseiChohyoDiv内の<br />
 * KokuminSakuseiChohyoKokugaiChosahyoDivに対応するコントローラです。
 *
 * @author N1823 有澤 礼恵
 * @reamsid_L AF-0360-012 liwul
 */
public final class KokuminSakuseiChohyoKokugaiChosahyo {

    private KokuminSakuseiChohyoKokugaiChosahyo() {
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div KokuminSakuseiChohyoKokugaiChosahyoDiv
     */
    public static void setData(KokuminSakuseiChohyoKokugaiChosahyoDiv div) {
        div.getCcdPrintNaiyoKokugaiChosa().initialize(KokuminSakuseiChohyoType.在外_国外転入照会.getValue());
    }

    /**
     * 項目をクリアします。
     *
     * @param div KokuminSakuseiChohyoKokugaiChosahyoDiv
     */
    public static void clearData(KokuminSakuseiChohyoKokugaiChosahyoDiv div) {
        div.getCcdPrintNaiyoKokugaiChosa().clearData();
        div.getChkSealKokugaiChosa().setSelectedItems(div.getChkSealKokugaiChosa().getDataSource());
        div.getChkKokugaiChosaIchiran().setSelectedItems(div.getChkKokugaiChosaIchiran().getDataSource());
    }

}
