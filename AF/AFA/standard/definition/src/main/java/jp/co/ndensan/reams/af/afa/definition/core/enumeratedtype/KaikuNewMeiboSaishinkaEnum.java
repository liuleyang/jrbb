/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * AFAGMK1040 海区漁業調整委員会委員選挙人名簿最新化Enum <br />
 *
 * @reamsid_L AF-0480-010 liuj
 */
public enum KaikuNewMeiboSaishinkaEnum {

    /**
     * 選挙時
     */
    選挙時(new RString("選挙時")),
    /**
     * 当初登録
     */
    当初登録(new RString("当初登録")),
    /**
     * 画面起動チェック_処理可能な
     */
    画面起動チェック_処理可能な(new RString("処理可能な")),
    /**
     * あり
     */
    あり(new RString("1")),
    /**
     * なし
     */
    なし(new RString("0"));

    private final RString value;

    private KaikuNewMeiboSaishinkaEnum(RString value) {
        this.value = value;
    }

    /**
     * 選挙時登録フラグの値を取得します。
     *
     * @return RString
     */
    public RString getValue() {
        return this.value;
    }
}
