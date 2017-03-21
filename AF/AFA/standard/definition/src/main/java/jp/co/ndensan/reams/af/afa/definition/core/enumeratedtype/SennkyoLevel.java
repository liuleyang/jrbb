/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 選挙レベルを表す列挙型です。
 */
public enum SennkyoLevel {

    /**
     * 国<br />
     * code：1
     */
    国("1", "国"),
    /**
     * 都道府県<br />
     * code：2
     */
    都道府県("2", "県"),
    /**
     * 市区町村<br />
     * code：3
     */
    市区町村("3", "市"),
    /**
     * その他<br />
     * code：9
     */
    その他("9", "その他");

    private final RString code;
    private final RString name;

    private SennkyoLevel(String code, String name) {
        this.code = new RString(code);
        this.name = new RString(name);
    }

    /**
     * 選挙レベルコードを取得します。
     *
     * @return 選挙レベルコード
     */
    public RString value() {
        return this.code;
    }

    /**
     * 選挙レベル略称を取得します。
     *
     * @return 選挙レベル略称
     */
    public RString toRString() {
        return this.name;
    }
}
