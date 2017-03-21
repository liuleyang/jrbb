/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 印刷枚数表_集計単位の説明の関連値クラス(AFA)。
 *
 * @reamsid_L AF-0160-020 guyq
 */
public enum AFAShokeitanniTypeEnum {

    /**
     * 入場券_印刷枚数表_集計単位_投票区コード。
     */
    入場券_印刷枚数表_集計単位_投票区コード("10", "投票区"),
    /**
     * 入場券_印刷枚数表_集計単位_住所コード。
     */
    入場券_印刷枚数表_集計単位_住所コード("11", "住所"),
    /**
     * 入場券_印刷枚数表_集計単位_行政区コード。
     */
    入場券_印刷枚数表_集計単位_行政区コード("12", "行政区"),
    /**
     * 入場券_印刷枚数表_集計単位_郵便番号。
     */
    入場券_印刷枚数表_集計単位_郵便番号("20", "郵便番号");

    private final RString key;
    private final RString value;

    private AFAShokeitanniTypeEnum(String key, String value) {
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
