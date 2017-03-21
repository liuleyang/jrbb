/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business;

import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 国民投票時登録
 *
 * @reamsid_L AF-0360-030 guancy
 */
public class KokuminTohyoji {

    private static final int 日_50 = 50;
    private static final int 日_14 = 14;

    /**
     * 日付項目の自動算出処理
     *
     * @param 投票日 FlexibleDate
     * @return Hitsuki 日付
     */
    public Hitsuki get日付項目_自動算出処理(RDate 投票日) {
        Hitsuki hitsuki = new Hitsuki();
        if (null != 投票日) {
            RDate 基準日 = 投票日.minusDay(日_50);
            hitsuki.set基準日(基準日);
            hitsuki.set名簿登録日(基準日.plusDay(1));
            hitsuki.set年齢到達日(投票日.plusDay(1));
            hitsuki.set特定期限日(基準日.plusDay(日_14));
            hitsuki.set受付開始日(投票日.minusDay(日_14));
        }
        return hitsuki;
    }

    /**
     * 帳票条件の日付取得処理
     *
     * @param 投票日 RDate
     * @return 抹消日 RDate
     */
    public RDate get帳票条件_日付取得処理(RDate 投票日) {
        if (null != 投票日) {
            return 投票日.minusDay(日_50);
        }
        return null;
    }
}
