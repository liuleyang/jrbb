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
public enum MasshoJiyuCodeZaigai {

    /**
     * 死亡抹消
     */
    死亡抹消("01", "死亡抹消"),
    /**
     * 国籍喪失抹消
     */
    国籍喪失抹消("02", "国籍喪失抹消"),
    /**
     * 国内転入4カ月経過抹消
     */
    国内転入4カ月経過抹消("03", "国内転入4カ月経過抹消"),
    /**
     * 誤載抹消
     */
    誤載抹消("04", "誤載抹消"),
    /**
     * その他
     */
    その他("09", "その他");

    private final RString key;
    private final RString value;

    private MasshoJiyuCodeZaigai(String key, String value) {
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
