/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 列挙型です。
 *
 * @reamsid_L AF-0500-030 guyq
 */
public enum AfaSeniKey {

    /**
     * 海区漁業削除
     */
    海区漁業削除(new RString("delete"));

    private final RString value;

    private AfaSeniKey(RString value) {
        this.value = value;
    }

    /**
     * valueを返します
     *
     * @return value
     */
    public RString getValue() {
        return value;
    }

}
