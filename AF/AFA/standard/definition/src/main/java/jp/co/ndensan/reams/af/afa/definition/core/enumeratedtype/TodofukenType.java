/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 都道府県を表す列挙型です
 *
 * @reamsid_L AF-0360-060 zhoujie3
 */
public enum TodofukenType {

    /**
     * 不明<br />
     * code：99
     */
    不明("99"),
    /**
     * 国外<br />
     * code：98
     */
    国外("98");

    private final RString code;

    private TodofukenType(String code) {
        this.code = new RString(code);
    }

    /**
     * 帳票valueを取得します。
     *
     * @return code
     */
    public RString value() {
        return this.code;
    }

}
