/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住所編集区分（宛名シール）を表す列挙型です。
 *
 * @reamsid_L AF-0620-013 jihb
 */
public enum JushoHenshuAtenaSeal {

    /**
     * 住所 番地 方書
     */
    住所_番地_方書("1", "住所 番地 方書"),
    /**
     * 住所 (行政区) 番地 方書
     */
    住所_行政区_番地_方書("2", "住所 (行政区) 番地 方書"),
    /**
     * 住所 番地 (行政区) 方書
     */
    住所_番地_行政区_方書("3", "住所 番地 (行政区) 方書"),
    /**
     * (行政区) 住所 番地 方書
     */
    行政区_住所_番地_方書("4", "(行政区) 住所 番地 方書"),
    /**
     * 住所 番地 (行政区) 方書
     */
    住所_番地_方書_行政区("5", "住所 番地 方書 (行政区)"),
    /**
     * 行政区 番地 方書
     */
    行政区_番地_方書("6", "行政区 番地 方書");

    private final RString key;
    private final RString value;

    private JushoHenshuAtenaSeal(String key, String value) {
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
