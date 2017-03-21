/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 抹消事由コードを表す列挙型です。
 *
 * @reamsid_L AF-0320-010 lis
 */
public enum HyojiJiyuCodeZaigai {

    /**
     * 国内転入
     */
    国内転入("06", "国内転入"),
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

    private HyojiJiyuCodeZaigai(String key, String value) {
        this.key = new RString(key);
        this.value = new RString(value);
    }

    /**
     * 抹消事由コードkeyを取得します。
     *
     * @return 抹消事由コードkey
     */
    public RString getKey() {
        return this.key;
    }

    /**
     * 抹消事由コードvalueを取得します。
     *
     * @return 抹消事由コードvalue
     */
    public RString getValue() {
        return this.value;
    }
}
