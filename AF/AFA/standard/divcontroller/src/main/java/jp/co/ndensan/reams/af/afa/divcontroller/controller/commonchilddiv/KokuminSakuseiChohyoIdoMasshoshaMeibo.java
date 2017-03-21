/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminSakuseiChohyo.KokuminSakuseiChohyoIdoMasshoshaMeiboDiv;

/**
 * 【共有子Div】KokuminSakuseiChohyoDiv内の<br />
 * KokuminSakuseiChohyoIdoMasshoshaMeiboDivに対応するコントローラです。
 *
 * @author N1823 有澤 礼恵
 */
public final class KokuminSakuseiChohyoIdoMasshoshaMeibo {

    private KokuminSakuseiChohyoIdoMasshoshaMeibo() {
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div KokuminSakuseiChohyoIdoMasshoshaMeiboDiv
     * @param shoriYmd 処理日
     */
    public static void setData(KokuminSakuseiChohyoIdoMasshoshaMeiboDiv div, String shoriYmd) {
        // 管理情報を見に行って計算してセットする？
//        div.getTxtMasshoYMD().setValue(new RDate(shoriYmd));
    }

    /**
     * 項目をクリアします。
     *
     * @param div KokuminSakuseiChohyoIdoMasshoshaMeiboDiv
     */
    public static void clearData(KokuminSakuseiChohyoIdoMasshoshaMeiboDiv div) {
//        div.getTxtMasshoYMD().clearValue();
    }

}
