/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 表示事由コードを表す列挙型です。
 *
 * @reamsid_L AF-0790-020 wanghj
 */
public enum HyojiJiyuCode {

    /**
     * 公職選挙法第11条1項2号該当
     */
    公職選挙法第11条1項2号該当("12", "公職選挙法第11条1項2号該当"),
    /**
     * 公職選挙法第11条1項3号該当
     */
    公職選挙法第11条1項3号該当("13", "公職選挙法第11条1項3号該当"),
    /**
     * 公職選挙法第11条1項4号該当
     */
    公職選挙法第11条1項4号該当("14", "公職選挙法第11条1項4号該当"),
    /**
     * 公職選挙法第11条1項5号該当
     */
    公職選挙法第11条1項5号該当("15", "公職選挙法第11条1項5号該当"),
    /**
     * 公職選挙法第11条2項該当
     */
    公職選挙法第11条2項該当("20", "公職選挙法第11条2項該当"),
    /**
     * 転出
     */
    転出("06", "転出"),
    /**
     * 職権消除
     */
    職権消除("07", "職権消除"),
    /**
     * その他
     */
    その他("09", "その他");

    private final RString key;

    private final RString value;

    private HyojiJiyuCode(String key, String value) {
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
