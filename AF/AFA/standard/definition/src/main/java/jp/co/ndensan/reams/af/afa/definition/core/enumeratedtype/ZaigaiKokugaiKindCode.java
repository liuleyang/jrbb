/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 在外_国外分類コードを表す列挙型です。
 */
public enum ZaigaiKokugaiKindCode {

    /**
     * 使用しない<br />
     * code：0
     */
    使用しない("0"),
    /**
     * 国籍コード使用する<br />
     * code：1
     */
    国籍コード使用する("1"),
    /**
     * 領事官コード使用する<br />
     * code：2
     */
    領事官コード使用する("2");

    private final RString kokugaiKind;

    private ZaigaiKokugaiKindCode(String kokugaiKind) {
        this.kokugaiKind = new RString(kokugaiKind);
    }

    /**
     * 国外分類コードを取得します。
     *
     * @return 国外分類コード
     */
    public RString value() {
        return this.kokugaiKind;
    }
}
