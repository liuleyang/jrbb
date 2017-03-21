/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 敬称を表す列挙型です。
 *
 * @reamsid_L AF-0620-013 jihb
 */
public enum Keisho {

    /**
     * 印字しない
     */
    印字しない("0", "印字しない"),
    /**
     * 様
     */
    様("1", "様"),
    /**
     * 殿
     */
    殿("2", "殿"),
    /**
     * 御中
     */
    御中("3", "御中");

    private final RString key;
    private final RString value;

    private Keisho(String key, String value) {
        this.key = new RString(key);
        this.value = new RString(value);
    }

    /**
     * 敬称のキーを取得します。
     *
     * @return RString
     */
    public RString getKey() {
        return this.key;
    }

    /**
     * 敬称の値を取得します。
     *
     * @return RString
     */
    public RString getValue() {
        return this.value;
    }
}
