/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 取扱注意者の検索条件区分を表す列挙型です。
 *
 * @reamsid_L AF-0360-052 qiuxy
 */
public enum CautionshaSearchKubun {

    /**
     * 利用区分。
     */
    利用区分("2"),
    /**
     * 抽出区分。
     */
    抽出区分("1"),
    /**
     * 注意種類コード。
     */
    注意種類コード("01"),
    /**
     * 有効期限。
     */
    有効期限("0");
    private final RString code;

    private CautionshaSearchKubun(String code) {
        this.code = new RString(code);
    }

    /**
     * 区分コードを返します。
     *
     * @return 区分コード
     */
    public RString getCode() {
        return this.code;
    }
}
