/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住所種類区分を表す列挙型です。
 *
 * @reamsid_L AF-0320-020 zhanggs
 */
public enum JushoShuruiKubun {

    /**
     * 本籍地住所
     */
    本籍地住所("1", "本籍地住所"),
    /**
     * 国外転出前最終住所
     */
    国外転出前最終住所("2", "国外転出前最終住所"),
    /**
     * 国内転入先住所
     */
    国内転入先住所("3", "国内転入先住所"),
    /**
     * 海外住所
     */
    海外住所("4", "海外住所"),
    /**
     * 海外送付先住所
     */
    海外送付先住所("5", "海外送付先住所");

    private final RString code;
    private final RString name;

    private JushoShuruiKubun(String code, String name) {
        this.code = new RString(code);
        this.name = new RString(name);
    }

    /**
     * 住所種類区分の名称を取得します。
     *
     * @return 住所種類区分名称
     */
    public RString get名称() {
        return this.name;
    }

    /**
     * 住所種類区分のコードを取得します。
     *
     * @return 住所種類区分コード
     */
    public Code getコード() {
        return new Code(this.code);
    }
}
