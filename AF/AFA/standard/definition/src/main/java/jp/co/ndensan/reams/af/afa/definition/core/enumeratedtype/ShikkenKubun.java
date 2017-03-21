/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 失権区分を表す列挙型です。
 *
 * @reamsid_L AF-0790-020 wanghj
 */
public enum ShikkenKubun {

    /**
     * 4ヶ月経過抹消者
     */
    四ヶ月経過抹消者("1", "4ヶ月経過抹消者"),
    /**
     * 公民権停止者
     */
    公民権停止者("2", "公民権停止者"),
    /**
     * 失権者
     */
    失権者("3", "失権者"),
    /**
     * 再転入者
     */
    再転入者("4", "再転入者");

    private final RString key;

    private final RString value;

    private ShikkenKubun(String key, String value) {
        this.key = new RString(key);
        this.value = new RString(value);
    }

    /**
     * 表示事由コードkeyを取得します。
     *
     * @return 表示事由コードkey
     */
    public RString getKey() {
        return this.key;
    }

    /**
     * 表示事由コードvalueを取得します。
     *
     * @return 表示事由コードvalue
     */
    public RString getValue() {
        return this.value;
    }
}
