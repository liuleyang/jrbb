/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.afagmb3050;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 在外選挙人名簿修正用ENUMクラス
 *
 * @reamsid_L AF-0325-034 guancy
 */
public enum ZaigaiShuseiEnum {

    /**
     * 在外投票人名簿修正
     */
    在外投票人名簿修正(new RString("在外投票人名簿修正")),
    /**
     * 在外選挙人名簿修正
     */
    在外選挙人名簿修正(new RString("在外選挙人名簿修正")),
    /**
     * 在外投票人名簿情報
     */
    在外投票人名簿情報(new RString("在外投票人名簿情報"));

    private final RString value;

    ZaigaiShuseiEnum(RString value) {
        this.value = value;
    }

    /**
     * 指定された在外選挙人名簿修正用ENUMを返します。
     *
     * @return 在外選挙人名簿修正用ENUM
     */
    public RString getValue() {
        return this.value;
    }

    /**
     * 指定された在外選挙人名簿修正用ENUMを返します。
     *
     * @return 在外選挙人名簿修正用ENUM
     */
    public int getIntValue() {
        return Integer.valueOf(this.value.toString());
    }
}
