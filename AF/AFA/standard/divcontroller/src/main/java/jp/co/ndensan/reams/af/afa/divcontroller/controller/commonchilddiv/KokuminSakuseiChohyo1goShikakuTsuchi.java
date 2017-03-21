/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.KokuminSakuseiChohyoType;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminSakuseiChohyo.KokuminSakuseiChohyo1goShikakuTsuchiDiv;

/**
 * 【共有子Div】KokuminSakuseiChohyoDiv内の<br />
 * KokuminSakuseiChohyo1goShikakuTsuchiDivに対応するコントローラです。
 *
 * @author N1823 有澤 礼恵
 * @reamsid_L AF-0360-012 liwul
 */
public final class KokuminSakuseiChohyo1goShikakuTsuchi {

    private KokuminSakuseiChohyo1goShikakuTsuchi() {
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div KokuminSakuseiChohyo1goShikakuTsuchiDiv
     */
    public static void setData(KokuminSakuseiChohyo1goShikakuTsuchiDiv div) {
        div.getCcdPrintNaiyo1goTsuchi().initialize(KokuminSakuseiChohyoType.国民_1号資格通知.getValue());
    }

    /**
     * 項目をクリアします。
     *
     * @param div KokuminSakuseiChohyo1goShikakuTsuchiDiv
     */
    public static void clearData(KokuminSakuseiChohyo1goShikakuTsuchiDiv div) {
        div.getCcdPrintNaiyo1goTsuchi().clearData();
        div.getChkSeal1goTsuchi().setSelectedItems(div.getChkSeal1goTsuchi().getDataSource());
        div.getChk1goTsuchiIchiran().setSelectedItems(div.getChk1goTsuchiIchiran().getDataSource());
    }

}
