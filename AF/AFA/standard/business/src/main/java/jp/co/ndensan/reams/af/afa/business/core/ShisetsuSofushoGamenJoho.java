/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 施設送付書画面情報
 *
 * @reamsid_L AF-0250-030 jihb
 */
public class ShisetsuSofushoGamenJoho {

    private RString 発行番号;
    private RDate 発行日;
    private RDate 交付日開始;
    private RDate 交付日終了;

    /**
     * 発行番号を返します。
     *
     * @return 発行番号 RString
     */
    public RString get発行番号() {
        return this.発行番号;
    }

    /**
     * 発行日を返します。
     *
     * @return 発行日 RDate
     */
    public RDate get発行日() {
        return this.発行日;
    }

    /**
     * 交付日開始を返します。
     *
     * @return 交付日開始 RDate
     */
    public RDate get交付日開始() {
        return this.交付日開始;
    }

    /**
     * 交付日終了を返します。
     *
     * @return 交付日終了 RDate
     */
    public RDate get交付日終了() {
        return this.交付日終了;
    }

    /**
     * 発行番号を設定します。
     *
     * @param 発行番号 RString
     */
    public void set発行番号(RString 発行番号) {
        this.発行番号 = 発行番号;
    }

    /**
     * 発行日を設定します。
     *
     * @param 発行日 RDate
     */
    public void set発行日(RDate 発行日) {
        this.発行日 = 発行日;
    }

    /**
     * 交付日開始を設定します。
     *
     * @param 交付日開始 RDate
     */
    public void set交付日開始(RDate 交付日開始) {
        this.交付日開始 = 交付日開始;
    }

    /**
     * 交付日終了を設定します。
     *
     * @param 交付日終了 RDate
     */
    public void set交付日終了(RDate 交付日終了) {
        this.交付日終了 = 交付日終了;
    }

}
