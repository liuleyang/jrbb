/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 交付_受理方法を表す列挙型です。
 *
 * @reamsid_L AF-0070-010 gaoya
 */
public enum KofuHoho {

    /**
     * 直接<br />
     * コード：1<br />
     */
    直接("1"),
    /**
     * 郵便<br />
     * コード：2<br />
     */
    郵便("2");

    private final RString code;

    private KofuHoho(String cd) {
        this.code = new RString(cd);
    }

    /**
     * 交付_受理方法コードを返します。
     *
     * @return 交付_受理方法コード
     */
    public RString getCode() {
        return code;
    }
}
