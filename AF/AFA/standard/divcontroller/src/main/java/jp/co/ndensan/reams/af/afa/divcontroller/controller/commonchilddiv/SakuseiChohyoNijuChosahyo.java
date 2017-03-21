/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SakuseiChohyo.SakuseiChohyoNijuChosahyoDiv;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 【共有子Div】SakuseiChohyoDiv内の<br />
 * SakuseiChohyoNijuChosahyoDivに対応するコントローラです。
 *
 * @author N1823 有澤 礼恵
 */
public final class SakuseiChohyoNijuChosahyo {

    private static final int FOUR_MONTH = 4;

    private SakuseiChohyoNijuChosahyo() {
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div SakuseiChohyoNijuChosahyoDiv
     * @param tenshutsuKigenYmd 転出期限日
     */
    public static void setData(SakuseiChohyoNijuChosahyoDiv div, String tenshutsuKigenYmd) {
        //TODO 帳票IDが決定したら、修正すること
        div.getCcdPrintNaiyoNijuChosa().initialize(RString.EMPTY);
        // 開始年月日は管理情報を見に行って計算してセットする。前回選挙の日付とか取得しないといけないか？
        div.getTxtTenshutsuKikan().setFromValue(new RDate(tenshutsuKigenYmd).minusMonth(FOUR_MONTH).plusDay(1));
        div.getTxtTenshutsuKikan().setToValue(new RDate(tenshutsuKigenYmd));
    }

    /**
     * 項目をクリアします。
     *
     * @param div SakuseiChohyoNijuChosahyoDiv
     */
    public static void clearData(SakuseiChohyoNijuChosahyoDiv div) {
        div.getCcdPrintNaiyoNijuChosa().clearData();
        div.getTxtTenshutsuKikan().clearFromValue();
        div.getTxtTenshutsuKikan().clearToValue();
    }

}
