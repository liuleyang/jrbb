/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SakuseiChohyo.SakuseiChohyoIdoMasshoshaMeiboDiv;

/**
 * 【共有子Div】SakuseiChohyoDiv内の<br />
 * SakuseiChohyoIdoMasshoshaMeiboDivに対応するコントローラです。
 *
 * @author N1823 有澤 礼恵
 */
public final class SakuseiChohyoIdoMasshoshaMeibo {

    private SakuseiChohyoIdoMasshoshaMeibo() {
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div SakuseiChohyoIdoMasshoshaMeiboDiv
     * @param shoriYmd 処理年月日
     */
    public static void setData(SakuseiChohyoIdoMasshoshaMeiboDiv div, String shoriYmd) {
        // 管理情報を見に行って計算してセットする？
//        div.getTxtMasshoYMD().setValue(new RDate(shoriYmd));
    }

    /**
     * 項目のクリアをします。
     *
     * @param div SakuseiChohyoIdoMasshoshaMeiboDiv
     */
    public static void clearData(SakuseiChohyoIdoMasshoshaMeiboDiv div) {
//        div.getTxtMasshoYMD().clearValue();
    }

}
