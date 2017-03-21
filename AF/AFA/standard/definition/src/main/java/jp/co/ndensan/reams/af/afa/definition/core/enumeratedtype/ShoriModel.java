/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 処理モードの列挙型クラス
 *
 * @reamsid_L AF-0010-010 xiaomm
 */
public enum ShoriModel {

    /**
     * 通常処理
     */
    通常処理("1"),
    /**
     * シミュレーション
     */
    シミュレーション("2");
    private final RString code;

    ShoriModel(String code) {
        this.code = new RString(code);
    }

    /**
     * コードの取得します。
     *
     * @return RString
     */
    public RString code() {
        return this.code;
    }
}
