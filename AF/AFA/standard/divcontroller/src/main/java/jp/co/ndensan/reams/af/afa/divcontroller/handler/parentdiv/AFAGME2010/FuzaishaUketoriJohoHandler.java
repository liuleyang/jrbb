/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME2010;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2010.FuzaishaUketoriJohoDiv;

/**
 * 【View】FuzaishaTohyoDiv内の <br />
 * 【子Div】FuzaishaTohyoJokyoDiv内の <br />
 * FuzaishaUketoriJohoDivに対応するコントローラです。
 *
 * @author N1823 有澤 礼恵
 * @reamsid_L AF-0080-010 lit
 */
public final class FuzaishaUketoriJohoHandler {

    private FuzaishaUketoriJohoHandler() {
    }

    /**
     * 初期表示時のイベントメソッドです。
     *
     * @param div FuzaishaUketoriJohoDiv
     */
    public static void clearThisPanel(FuzaishaUketoriJohoDiv div) {
        div.getTxtUketoriYMD().clearValue();
    }

    /**
     * 投票状況クリック時のイベントメソッドです。
     *
     * @param div FuzaishaUketoriJohoDiv
     * @param blnShiyoFuka Boolean True：画面での入力不可、False：画面での入力可
     */
    public static void setHyoji(FuzaishaUketoriJohoDiv div, Boolean blnShiyoFuka) {
        // blnShiyoFuka  True：画面での入力不可、False：画面での入力可
        div.getTxtUketoriYMD().setReadOnly(blnShiyoFuka);
    }

}
