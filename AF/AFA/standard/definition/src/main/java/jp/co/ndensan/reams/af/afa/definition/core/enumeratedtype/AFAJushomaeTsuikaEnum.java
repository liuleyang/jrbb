/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住所の前に市町村名を付加の関連値クラス(AFA)。
 *
 * @reamsid_L AF-0620-020 guanyq
 */
public enum AFAJushomaeTsuikaEnum {

    /**
     * しない。
     */
    しない("0", "しない"),
    /**
     * する。
     */
    する("1", "する"),
    /**
     * 都道府県名から付加。
     */
    都道府県名から付加("2", "都道府県名から付加");

    private final RString key;
    private final RString value;

    private AFAJushomaeTsuikaEnum(String key, String value) {
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

    /**
     * 業務コンフィグの説明の関連値を返します。
     *
     * @param key RString
     * @return 業務コンフィグの説明の関連値
     */
    public RString getValue(RString key) {
        for (AFAJushomaeTsuikaEnum item : AFAJushomaeTsuikaEnum.values()) {
            if (item.key.equals(key)) {
                return item.value;
            }
        }
        return this.value;
    }
}
