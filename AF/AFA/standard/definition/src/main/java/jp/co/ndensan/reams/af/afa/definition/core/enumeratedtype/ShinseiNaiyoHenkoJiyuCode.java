/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申請内容変更事由コードの列挙型
 *
 * @reamsid_L AF-0330-020 lis2
 */
public enum ShinseiNaiyoHenkoJiyuCode {

    /**
     * 住所変更
     */
    住所変更("1", "住所変更"),
    /**
     * 氏名変更
     */
    氏名変更("2", "氏名変更"),
    /**
     * 本籍地変更
     */
    本籍地変更("3", "本籍地変更"),
    /**
     * 送付先変更
     */
    送付先変更("4", "送付先変更"),
    /**
     * その他
     */
    その他("5", "その他");
    private final RString key;
    private final RString value;

    private ShinseiNaiyoHenkoJiyuCode(String key, String value) {
        this.key = new RString(key);
        this.value = new RString(value);
    }

    /**
     * 申請内容変更事由コードkeyを取得します。
     *
     * @return 申請内容変更事由コードkey
     */
    public RString getKey() {
        return this.key;
    }

    /**
     * 申請内容変更事由コードvalueを取得します。
     *
     * @return 申請内容変更事由コードvalue
     */
    public RString getValue() {
        return this.value;
    }
}
