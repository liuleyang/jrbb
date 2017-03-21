/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * メニューを表す列挙型です。
 *
 * @reamsid_L AF-0110-010 gaoya
 */
public enum KyojuKubun {

    /**
     * 居住。
     */
    居住("1", "居住"),
    /**
     * 非居住。
     */
    非居住("2", "非居住");

    private final RString code;
    private final RString name;

    private KyojuKubun(String code, String name) {
        this.code = new RString(code);
        this.name = new RString(name);
    }

    /**
     * コードを返します。
     *
     * @return コード
     */
    public RString getCode() {
        return this.code;
    }

    /**
     * 名称を返します。
     *
     * @return 名称
     */
    public RString getName() {
        return this.name;
    }
}
