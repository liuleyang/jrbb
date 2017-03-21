/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 【共有子Div】KokuminSakuseiChohyoDivに対応列挙型です。
 *
 * @reamsid_L AF-0360-012 liwul
 */
public enum KokuminSakuseiChohyoType {

    /**
     * 国民_1号資格通知
     */
    国民_1号資格通知(new RString("国民_1号資格通知"), new RString("0")),
    /**
     * 国民_2号資格調査
     */
    国民_2号資格調査(new RString("国民_2号資格調査"), new RString("0")),
    /**
     * 国民_未登録者抹消
     */
    国民_未登録者抹消(new RString("国民_未登録者抹消"), new RString("0")),
    /**
     * 在外_国内転入照会
     */
    在外_国内転入照会(new RString("在外_国内転入照会"), new RString("0")),
    /**
     * 在外_国外転入照会
     */
    在外_国外転入照会(new RString("在外_国外転入照会"), new RString("0"));

    private final RString value;
    private final RString key;

    private KokuminSakuseiChohyoType(RString value, RString key) {
        this.value = value;
        this.key = key;

    }

    /**
     * 値を取得<BR>
     * 例: 死亡(new RString("死亡"), new RString("01")) =>return 01
     *
     * @return key RString
     */
    public RString getKey() {
        return key;
    }

    /**
     * keyを取得 <BR>
     * 例: 死亡(new RString("死亡"), new RString("01")) =>return 死亡
     *
     * @return value RString
     */
    public RString getValue() {
        return value;
    }

}
