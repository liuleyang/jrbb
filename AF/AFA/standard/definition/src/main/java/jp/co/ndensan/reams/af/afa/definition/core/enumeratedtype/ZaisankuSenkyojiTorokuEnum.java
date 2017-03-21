/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 財産区議会議員選挙時登録用ENUMクラス
 *
 * @reamsid_L AF-0600-010 lis
 */
public enum ZaisankuSenkyojiTorokuEnum {

    /**
     * 新規処理
     */
    新規処理(new RString("1")),
    /**
     * 再処理
     */
    再処理(new RString("2")),
    /**
     * 1
     */
    ONE(new RString("1")),
    /**
     * 1
     */
    ZERO(new RString("0")),
    /**
     * 抄本0件チェック
     */
    抄本なしチェック(new RString("再処理可能な"));

    private final RString value;

    ZaisankuSenkyojiTorokuEnum(RString value) {
        this.value = value;
    }

    /**
     * 指定された請求代表者登録用ENUMを返します。
     *
     * @return 請求代表者登録用ENUM
     */
    public RString getValue() {
        return this.value;
    }

    /**
     * 指定された請求代表者登録用ENUMを返します。
     *
     * @return 請求代表者登録用ENUM
     */
    public int getIntValue() {
        return Integer.valueOf(this.value.toString());
    }
}
