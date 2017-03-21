/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SakuseiChohyo.SakuseiChohyoNijuTorokuTsuchiDiv;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 【共有子Div】SakuseiChohyoDiv内の<br />
 * SakuseiChohyoNijuTorokuTsuchiDivに対応するコントローラです。
 *
 * @author N1823 有澤 礼恵
 */
public final class SakuseiChohyoNijuTorokuTsuchi {

    private static final int FOUR_MONTH = 4;

    private SakuseiChohyoNijuTorokuTsuchi() {
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div SakuseiChohyoNijuTorokuTsuchiDiv
     * @param tennyuKigenYmd 転入期限日
     */
    public static void setData(SakuseiChohyoNijuTorokuTsuchiDiv div, String tennyuKigenYmd) {
        //TODO 帳票IDが決定したら、修正すること
        div.getCcdPrintNaiyoNijuTsuchi().initialize(RString.EMPTY);
        //TODO 開始年月日は管理情報を見に行って計算してセットする。前回選挙の日付とか取得しないといけないか？
        div.getTxtTennyuKikan().setFromValue(new RDate(tennyuKigenYmd).minusMonth(FOUR_MONTH).plusDay(1));
        div.getTxtTennyuKikan().setToValue(new RDate(tennyuKigenYmd));
    }

    /**
     * 項目をクリアします。
     *
     * @param div SakuseiChohyoNijuTorokuTsuchiDiv
     */
    public static void clearData(SakuseiChohyoNijuTorokuTsuchiDiv div) {
        div.getCcdPrintNaiyoNijuTsuchi().clearData();
        div.getTxtTennyuKikan().clearFromValue();
        div.getTxtTennyuKikan().clearToValue();
    }

}
