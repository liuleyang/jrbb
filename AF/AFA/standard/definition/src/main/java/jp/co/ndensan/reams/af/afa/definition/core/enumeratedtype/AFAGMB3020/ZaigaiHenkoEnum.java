/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.afagmb3020;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * AFAGMB3020 証明書記載事項変更用ENUMクラス
 *
 * @reamsid_L AF-0330-010 guancy
 */
public enum ZaigaiHenkoEnum {

    /**
     * 在外投票人情報
     */
    在外投票人情報(new RString("在外投票人情報")),
    /**
     * 在外投票人名簿情報
     */
    在外投票人名簿情報(new RString("在外投票人名簿情報"));

    private final RString value;

    ZaigaiHenkoEnum(RString value) {
        this.value = value;
    }

    /**
     * 指定された証明書記載事項変更用ENUMを返します。
     *
     * @return 証明書記載事項変更用ENUM
     */
    public RString getValue() {
        return this.value;
    }

    /**
     * 指定された証明書記載事項変更用ENUMを返します。
     *
     * @return 証明書記載事項変更用ENUM
     */
    public int getIntValue() {
        return Integer.valueOf(this.value.toString());
    }
}
