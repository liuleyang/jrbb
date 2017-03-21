/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申請状態の列挙型クラス
 *
 * @reamsid_L AF-0320-012 zhanggs
 */
public enum ShinseiJotai {

    /**
     * 未届
     */
    未届("0", "未届"),
    /**
     * 申請
     */
    申請("1", "申請"),
    /**
     * 申請取下げ
     */
    申請取下げ("2", "申請取下げ"),
    /**
     * 申請却下
     */
    申請却下("3", "申請却下"),
    /**
     * 証明書交付
     */
    証明書交付("4", "証明書交付");

    private final RString key;
    private final RString value;

    private ShinseiJotai(String key, String value) {
        this.key = new RString(key);
        this.value = new RString(value);
    }

    /**
     * 申請状態のキーを取得します。
     *
     * @return RString
     */
    public RString getKey() {
        return this.key;
    }

    /**
     * 申請状態の値を取得します。
     *
     * @return RString
     */
    public RString getValue() {
        return this.value;
    }
}
