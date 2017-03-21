/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 印字有無を表す列挙型です。
 */
public enum InnjiFlg {

    /**
     * 印字しない<br />
     * code：0
     */
    印字しない("0"),
    /**
     * 印字する<br />
     * code：1
     */
    印字する("1"),
    /**
     * 印字その他<br />
     * code：2
     */
    印字その他("2");

    private final RString innjiFlg;

    private InnjiFlg(String innjiFlg) {
        this.innjiFlg = new RString(innjiFlg);
    }

    /**
     * 印字有無を取得します。
     *
     * @return 印字有無
     */
    public RString value() {
        return this.innjiFlg;
    }
}
