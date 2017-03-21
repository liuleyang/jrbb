/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 処理種別を表す列挙型です。
 *
 * @reamsid_L AF-0360-010 gaoya
 */
public enum ShoriShubetsu {

    /**
     * 新規登録。
     */
    新規登録("1"),
    /**
     * 再処理。
     */
    再処理("2");

    private final RString shoriShubetsu;

    private ShoriShubetsu(String shoriShubetsu) {
        this.shoriShubetsu = new RString(shoriShubetsu);
    }

    /**
     * 処理種別を返します。
     *
     * @return 処理種別
     */
    public RString getShoriShubetsu() {
        return this.shoriShubetsu;
    }

}
