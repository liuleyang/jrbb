/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 海区選挙人名簿用ENUMクラス
 *
 * @reamsid_L AF-0500-010 zhanggs
 */
public enum KaikuSenkyoninMeiboEnum {

    /**
     * 選挙資格
     */
    選挙資格(new RString("選挙資格")),
    /**
     * 海区付随情報
     */
    海区付随情報(new RString("海区付随情報")),
    /**
     * 選挙人名簿
     */
    選挙人名簿(new RString("選挙人名簿")),
    /**
     * 抄本番号
     */
    抄本番号(new RString("抄本番号")),
    /**
     * 識別コード
     */
    識別コード(new RString("識別コード"));

    private final RString value;

    KaikuSenkyoninMeiboEnum(RString value) {
        this.value = value;
    }

    /**
     * 指定された海区選挙人名簿用ENUMを返します。
     *
     * @return 海区選挙人名簿用ENUM
     */
    public RString getValue() {
        return this.value;
    }

    /**
     * 指定された海区選挙人名簿用ENUMを返します。
     *
     * @return 海区選挙人名簿用ENUM
     */
    public int getIntValue() {
        return Integer.valueOf(this.value.toString());
    }
}
