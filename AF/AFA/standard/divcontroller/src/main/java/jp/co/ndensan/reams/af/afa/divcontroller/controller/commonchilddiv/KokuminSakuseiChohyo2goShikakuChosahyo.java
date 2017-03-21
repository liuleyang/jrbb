/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.KokuminSakuseiChohyoType;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminSakuseiChohyo.KokuminSakuseiChohyo2goShikakuChosahyoDiv;

/**
 * 【共有子Div】KokuminSakuseiChohyoDiv内の<br />
 * KokuminSakuseiChohyo2goShikakuChosahyoDivに対応するコントローラです。
 *
 * @author N1823 有澤 礼恵
 * @reamsid_L AF-0360-012 liwul
 */
public final class KokuminSakuseiChohyo2goShikakuChosahyo {

    private KokuminSakuseiChohyo2goShikakuChosahyo() {
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div KokuminSakuseiChohyo2goShikakuChosahyoDiv
     */
    public static void setData(KokuminSakuseiChohyo2goShikakuChosahyoDiv div) {
        div.getCcdPrintNaiyo2goChosahyo().initialize(KokuminSakuseiChohyoType.国民_2号資格調査.getValue());
    }

    /**
     * 項目をクリアします。
     *
     * @param div KokuminSakuseiChohyo2goShikakuChosahyoDiv
     */
    public static void clearData(KokuminSakuseiChohyo2goShikakuChosahyoDiv div) {
        div.getCcdPrintNaiyo2goChosahyo().clearData();
        div.getChkSeal2goChosahyo().setSelectedItems(div.getChkSeal2goChosahyo().getDataSource());
        div.getChk2goChosaIchiran().setSelectedItems(div.getChk2goChosaIchiran().getDataSource());
    }

}
