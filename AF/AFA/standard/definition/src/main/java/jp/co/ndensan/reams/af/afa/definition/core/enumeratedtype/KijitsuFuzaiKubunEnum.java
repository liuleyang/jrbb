/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 期日前不在者区分の説明の関連値クラス(AFA)。
 *
 * @reamsid_L AF-0795-020 chenh
 */
public enum KijitsuFuzaiKubunEnum {

    /**
     * 期日前投票。
     */
    期日前投票("1", "期日前投票"),
    /**
     * 不在者投票。
     */
    不在者投票("2", "不在者投票"),
    /**
     * 当日投票。
     */
    当日投票("3", "当日投票");

    private final RString key;
    private final RString value;

    private KijitsuFuzaiKubunEnum(String key, String value) {
        this.key = new RString(key);
        this.value = new RString(value);
    }

    /**
     * 業務コンフィグの説明の関連値を返します。
     *
     * @return 業務コンフィグの説明の関連値
     */
    public RString getKey() {
        return this.key;
    }

    /**
     * 業務コンフィグの説明の関連値を返します。
     *
     * @return 業務コンフィグの説明の関連値
     */
    public RString getValue() {
        return this.value;
    }

}
