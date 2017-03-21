/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 四隅項目（選挙人用）を表す列挙型です。
 *
 * @reamsid_L AF-0620-013 jihb
 */
public enum YosumiKomokuSenkyonin {

    /**
     * 印字しない
     */
    印字しない("00", "印字しない"),
    /**
     * 識別コード
     */
    識別コード("01", "識別コード"),
    /**
     * 世帯コード
     */
    世帯コード("02", "世帯コード"),
    /**
     * 住所コード
     */
    住所コード("03", "住所コード"),
    /**
     * 行政区コード
     */
    行政区コード("04", "行政区コード"),
    /**
     * [地区1]コード
     */
    地区1コード("05", "[地区1]コード"),
    /**
     * [地区2]コード
     */
    地区2コード("06", "[地区2]コード"),
    /**
     * [地区3]コード
     */
    地区3コード("07", "[地区3]コード"),
    /**
     * 通し番号
     */
    通し番号("08", "通し番号"),
    /**
     * 住所
     */
    住所("09", "住所"),
    /**
     * 行政区名
     */
    行政区名("10", "行政区名"),
    /**
     * [地区1]
     */
    地区1("11", "[地区1]"),
    /**
     * [地区2]
     */
    地区2("12", "[地区2]"),
    /**
     * [地区3]
     */
    地区3("13", "[地区3]"),
    /**
     * 日付
     */
    日付("14", "日付"),
    /**
     * 投票区コード
     */
    投票区コード("15", "投票区コード"),
    /**
     * 名簿番号
     */
    名簿番号("16", "名簿番号");

    private final RString key;
    private final RString value;

    private YosumiKomokuSenkyonin(String key, String value) {
        this.key = new RString(key);
        this.value = new RString(value);
    }

    /**
     * 四隅項目のキーを取得します。
     *
     * @return RString
     */
    public RString getKey() {
        return this.key;
    }

    /**
     * 四隅項目の値を取得します。
     *
     * @return RString
     */
    public RString getValue() {
        return this.value;
    }
}
