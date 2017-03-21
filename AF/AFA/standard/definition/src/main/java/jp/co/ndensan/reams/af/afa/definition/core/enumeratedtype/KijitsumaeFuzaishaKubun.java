/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 期日前不在者区分を表す列挙型です。
 */
public enum KijitsumaeFuzaishaKubun {

    /**
     * 通番<br />
     * code：1
     */
    通番("0"),
    /**
     * 期日前投票<br />
     * code：1
     */
    期日前投票("1"),
    /**
     * 不在者投票<br />
     * code：1
     */
    不在者投票("2"),
    /**
     * 当日投票<br />
     * code：2
     */
    当日投票("3");

    private final RString kijitsumaeFuzaishaKubun;

    private KijitsumaeFuzaishaKubun(String kijitsumaeFuzaishaKubun) {
        this.kijitsumaeFuzaishaKubun = new RString(kijitsumaeFuzaishaKubun);
    }

    /**
     * 期日前不在者区分を取得します。
     *
     * @return 期日前不在者区分
     */
    public RString value() {
        return this.kijitsumaeFuzaishaKubun;
    }
}
