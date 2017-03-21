/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * AFAGMK1060 海区漁業調整委員会委員選挙人名簿登録 <br />
 *
 * @reamsid_L AF-0500-010 zhanggs
 */
public enum KaikuIdoShikakuIdoShoriEnum {

    /**
     * 保存する
     */
    保存する(new RString("btnUpdate")),
    /**
     * 削除する
     */
    削除する(new RString("btnDelete")),
    /**
     * RString_0
     */
    RST_00(new RString("00")),
    /**
     * RString_0
     */
    RST_0(new RString("0")),
    /**
     * RString_1
     */
    RST_1(new RString("1")),
    /**
     * RString_2
     */
    RST_2(new RString("2")),
    /**
     * RString_3
     */
    RST_3(new RString("3"));

    private final RString button;

    private KaikuIdoShikakuIdoShoriEnum(RString button) {
        this.button = button;
    }

    /**
     * buttonを返します
     *
     * @return button
     */
    public RString getValue() {
        return button;
    }
}
