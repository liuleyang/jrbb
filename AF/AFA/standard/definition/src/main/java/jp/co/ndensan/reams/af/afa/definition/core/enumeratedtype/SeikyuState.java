/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 不在者_請求処理制御
 *
 * @reamsid_L AF-0130-010 lit
 */
public enum SeikyuState {

    /**
     * 個別処理しない
     */
    個別処理しない(new RString("0")),
    /**
     * 個別処理する
     */
    個別処理する(new RString("1"));

    private final RString key;

    SeikyuState(RString key) {
        this.key = key;
    }

    /**
     * 指定された不在者_請求処理制御を返します。
     *
     * @return 不在者_請求処理制御
     */
    public RString getKey() {
        return this.key;
    }
}
