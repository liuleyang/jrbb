/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住民検索簡易版ダイアログ用ENUM
 *
 * @reamsid_L AF-0170-020 lis
 */
public enum SearchSimpleJuminDialogEnum {

    /**
     * 含む
     */
    含む(new RString("含む")),
    /**
     * 個人のみ
     */
    含まない(new RString("含まない"));

    private final RString value;

    SearchSimpleJuminDialogEnum(RString value) {
        this.value = value;
    }

    /**
     * 指定された住民検索簡易版ダイアログ用ENUMを返します。
     *
     * @return 住民検索簡易版ダイアログ用ENUM
     */
    public RString getValue() {
        return this.value;
    }
}
