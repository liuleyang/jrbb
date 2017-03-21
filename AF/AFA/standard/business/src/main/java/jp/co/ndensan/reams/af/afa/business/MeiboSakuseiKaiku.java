/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business;

import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 海区漁業調整委員会委員選挙人名簿作成
 *
 * @reamsid_L AF-0460-030 wanghj
 */
public class MeiboSakuseiKaiku {

    private static final int 月_3 = 3;
    private static final int 日_4 = 4;

    /**
     * 日付を自動計算する
     *
     * @param 基準日 RDate
     * @return Hitsuki 日付オブジェクト
     */
    public Hitsuki get日付(RDate 基準日) {
        if (null != 基準日) {
            Hitsuki hitsuki = new Hitsuki();
            RDate 名簿確定日 = 基準日.plusMonth(月_3).plusDay(日_4);
            hitsuki.set名簿確定日(名簿確定日);
            hitsuki.set年齢到達日(名簿確定日.plusDay(1));
            return hitsuki;
        }
        return null;
    }
}
