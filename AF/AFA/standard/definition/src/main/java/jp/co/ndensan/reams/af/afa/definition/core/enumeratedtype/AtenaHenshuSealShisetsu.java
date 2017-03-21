/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 宛名編集区分（施設宛名シール）を表す列挙型です。
 *
 * @reamsid_L AF-0620-013 jihb
 */
public enum AtenaHenshuSealShisetsu {

    /**
     * 施設名
     */
    施設名("1", "施設名"),
    /**
     * 施設宛名
     */
    施設宛名("2", "施設宛名"),
    /**
     * 施設名と施設宛名
     */
    施設名と施設宛名("3", "施設名と施設宛名");

    private final RString key;
    private final RString value;

    private AtenaHenshuSealShisetsu(String key, String value) {
        this.key = new RString(key);
        this.value = new RString(value);
    }

    /**
     * 宛名編集区分のキーを取得します。
     *
     * @return RString
     */
    public RString getKey() {
        return this.key;
    }

    /**
     * 宛名編集区分の値を取得します。
     *
     * @return RString
     */
    public RString getValue() {
        return this.value;
    }
}
