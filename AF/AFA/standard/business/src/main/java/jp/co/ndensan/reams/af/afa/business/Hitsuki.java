/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business;

import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 *
 * 日付オブジェクト
 *
 * @reamsid_L AF-0360-030 guancy
 */
public class Hitsuki {

    private RDate 基準日;
    private RDate 名簿登録日;
    private RDate 年齢到達日;
    private RDate 特定期限日;
    private RDate 受付開始日;
    private RDate 名簿確定日;

    /**
     * 基準日を返します。
     *
     * @return 基準日 RDate
     */
    public RDate get基準日() {
        return this.基準日;
    }

    /**
     * 名簿登録日を返します。
     *
     * @return 名簿登録日 RDate
     */
    public RDate get名簿登録日() {
        return this.名簿登録日;
    }

    /**
     * 年齢到達日を返します。
     *
     * @return 年齢到達日 RDate
     */
    public RDate get年齢到達日() {
        return this.年齢到達日;
    }

    /**
     * 特定期限日を返します。
     *
     * @return 特定期限日 RDate
     */
    public RDate get特定期限日() {
        return this.特定期限日;
    }

    /**
     * 受付開始日を返します。
     *
     * @return 受付開始日 RDate
     */
    public RDate get受付開始日() {
        return this.受付開始日;
    }

    /**
     * 名簿確定日を返します。
     *
     * @return 名簿確定日 RDate
     */
    public RDate get名簿確定日() {
        return 名簿確定日;
    }

    /**
     * 基準日を設定します。
     *
     * @param 基準日 RDate
     */
    public void set基準日(RDate 基準日) {
        this.基準日 = 基準日;
    }

    /**
     * 名簿登録日を設定します。
     *
     * @param 名簿登録日 RDate
     */
    public void set名簿登録日(RDate 名簿登録日) {
        this.名簿登録日 = 名簿登録日;
    }

    /**
     * 年齢到達日を設定します。
     *
     * @param 年齢到達日 RDate
     */
    public void set年齢到達日(RDate 年齢到達日) {
        this.年齢到達日 = 年齢到達日;
    }

    /**
     * 特定期限日を設定します。
     *
     * @param 特定期限日 RDate
     */
    public void set特定期限日(RDate 特定期限日) {
        this.特定期限日 = 特定期限日;
    }

    /**
     * 受付開始日を設定します。
     *
     * @param 受付開始日 RDate
     */
    public void set受付開始日(RDate 受付開始日) {
        this.受付開始日 = 受付開始日;
    }

    /**
     * 名簿確定日を設定します。
     *
     * @param 名簿確定日 RDate
     */
    public void set名簿確定日(RDate 名簿確定日) {
        this.名簿確定日 = 名簿確定日;
    }
}
