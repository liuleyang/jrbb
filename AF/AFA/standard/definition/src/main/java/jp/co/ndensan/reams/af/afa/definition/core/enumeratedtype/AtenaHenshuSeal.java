/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 宛名編集区分（選挙人宛名シール）を表す列挙型です。
 *
 * @reamsid_L AF-0620-013 jihb
 */
public enum AtenaHenshuSeal {

    /**
     * 本人
     */
    本人("1", "本人"),
    /**
     * フリガナと本人
     */
    フリガナと本人("2", "フリガナと本人"),
    /**
     * 世帯主と本人
     */
    世帯主と本人("3", "世帯主と本人");

    private final RString key;
    private final RString value;

    private AtenaHenshuSeal(String key, String value) {
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
