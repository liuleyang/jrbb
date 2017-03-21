/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 性別の列挙型
 */
public enum Seibetsu {

    /**
     * 男
     */
    男("1"),
    /**
     * 女
     */
    女("2");
    private final RString code;

    private Seibetsu(String code) {
        this.code = new RString(code);
    }

    /**
     * 性別codeを取得します。
     *
     * @return 性別code
     */
    public RString code() {
        return this.code;
    }
}
