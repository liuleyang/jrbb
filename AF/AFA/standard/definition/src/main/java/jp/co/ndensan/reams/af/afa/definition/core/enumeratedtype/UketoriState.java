/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 不在者_受取制御
 *
 * @reamsid_L AF-0130-010 lit
 */
public enum UketoriState {

    /**
     * 表示しない
     */
    表示しない(new RString("0")),
    /**
     * 表示する
     */
    表示する(new RString("1"));

    private final RString key;

    UketoriState(RString key) {
        this.key = key;
    }

    /**
     * 指定された不在者_受取制御を返します。
     *
     * @return 不在者_受取制御
     */
    public RString getKey() {
        return this.key;
    }
}
