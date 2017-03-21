/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 市区町村区分の列挙型
 *
 * @reamsid_L AF-0320-021 zhanggs
 */
public enum ShichosonKubun {

    /**
     * 区
     */
    区(1, "区"),
    /**
     * 市
     */
    市(2, "市"),
    /**
     * 町
     */
    町(3, "町"),
    /**
     * 村
     */
    村(4, "村");
    private final int key;
    private final RString value;

    private ShichosonKubun(int key, String value) {
        this.key = key;
        this.value = new RString(value);
    }

    /**
     * 市町村区分keyを取得します。
     *
     * @return 市町村区分key
     */
    public int getKey() {
        return this.key;
    }

    /**
     * 市町村区分valueを取得します。
     *
     * @return 市町村区分value
     */
    public RString getValue() {
        return this.value;
    }
}
