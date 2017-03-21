/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SakuseiChohyo.SakuseiChohyoIdoKikaMeiboDiv;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 【共有子Div】SakuseiChohyoDiv内の<br />
 * SakuseiChohyoIdoKikaMeiboDivに対応するコントローラです。
 *
 * @author N1823 有澤 礼恵
 */
public final class SakuseiChohyoIdoKikaMeibo {

    private static final int SIX_MONTH = 6;

    private SakuseiChohyoIdoKikaMeibo() {
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div SakuseiChohyoIdoKikaMeiboDiv
     */
    public static void setData(SakuseiChohyoIdoKikaMeiboDiv div) {
        // 管理情報を見に行って計算してセットする？
        div.getTxtKikaKikan().setFromValue(RDate.getNowDate().minusMonth(SIX_MONTH));
        div.getTxtKikaKikan().setToValue(RDate.getNowDate());
    }

    /**
     * 項目のクリアをします。
     *
     * @param div SakuseiChohyoIdoKikaMeiboDiv
     */
    public static void clearData(SakuseiChohyoIdoKikaMeiboDiv div) {
        div.getTxtKikaKikan().clearFromValue();
        div.getTxtKikaKikan().clearToValue();
    }

}
