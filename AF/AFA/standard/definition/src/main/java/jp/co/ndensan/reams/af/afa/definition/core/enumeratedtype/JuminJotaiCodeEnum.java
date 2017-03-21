/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住民状態コードの説明の関連値クラス(AFA)。
 *
 * @reamsid_L AF-0390-030 jihb
 */
public enum JuminJotaiCodeEnum {

    /**
     * 住民。
     */
    住民状態コード_住民("1", "住民"),
    /**
     * 住登外。
     */
    住民状態コード_住登外("2", "住登外"),
    /**
     * 転出者。
     */
    住民状態コード_転出者("3", "転出者"),
    /**
     * 死亡者。
     */
    住民状態コード_死亡者("4", "死亡者"),
    /**
     * 消除者。
     */
    住民状態コード_消除者("9", "消除者");

    private final RString key;
    private final RString value;

    private JuminJotaiCodeEnum(String key, String value) {
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
