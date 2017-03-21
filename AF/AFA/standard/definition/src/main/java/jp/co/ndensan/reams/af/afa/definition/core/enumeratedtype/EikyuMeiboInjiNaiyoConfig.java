/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 *
 * 永久名簿_印字内容を表す列挙型です。
 */
public enum EikyuMeiboInjiNaiyoConfig {

    /**
     * 永久選挙人名簿の住所欄の出力内容
     */
    永久名簿_印字内容_住所,
    /**
     * 永久選挙人名簿の住所欄の出力内容 11：住所＋番地
     */
    住所と番地(new RString("11")),
    /**
     * 永久選挙人名簿の住所欄の出力内容　12：行政区＋番地
     */
    行政区と番地(new RString("12")),
    /**
     * 永久選挙人名簿の住所欄の出力内容　13：地区名1＋番地
     */
    地区名1と番地(new RString("13")),
    /**
     * 永久選挙人名簿の地区・行政区名欄に印字する内容 （"00"：（空欄）　"11"：住所　"12"：行政区　"13"：地区コード1）
     *
     */
    永久名簿_印字内容_地区行政区名,
    /**
     * 永久選挙人名簿の地区・行政区名欄に印字する内容 00：(空欄)
     */
    空欄(RString.EMPTY, new RString("00")),
    /**
     * 永久選挙人名簿の地区・行政区名欄に印字する内容 11：住所
     */
    住所(new RString("住所"), new RString("11")),
    /**
     * 永久選挙人名簿の地区・行政区名欄に印字する内容 12：行政区
     */
    行政区(new RString("行政区"), new RString("12")),
    /**
     * 永久選挙人名簿の地区・行政区名欄に印字する内容 13：地区コード1
     */
    地区コード1(new RString("地区コード1"), new RString("13")),
    /**
     * 永久選挙人名簿のコード欄1に印字する内容（"1"：世帯コード　"2"：識別コード　"3"：地区1　"4"：地区2　"5"：地区3）
     */
    永久名簿_印字内容_コード欄1,
    /**
     * 永久選挙人名簿のコード欄2に印字する内容（"1"：世帯コード　"2"：識別コード　"3"：地区1　"4"：地区2　"5"：地区3）
     */
    永久名簿_印字内容_コード欄2,
    /**
     * 永久選挙人名簿のコード欄1に印字する内容 1：世帯コード <BR>
     * 永久選挙人名簿のコード欄1に印字する内容 2：世帯コード
     */
    世帯(new RString("世帯コード"), new RString("1")),
    /**
     * 永久選挙人名簿のコード欄1に印字する内容 1：識別コード <BR>
     * 永久選挙人名簿のコード欄1に印字する内容 2：識別コード
     */
    識別コード(new RString("識別コード"), new RString("2")),
    /**
     * 永久選挙人名簿のコード欄1に印字する内容 1：地区1 <BR>
     * 永久選挙人名簿のコード欄1に印字する内容 2：地区1
     */
    地区1(new RString("地区コード1"), new RString("3")),
    /**
     * 永久選挙人名簿のコード欄1に印字する内容 1：地区2 <BR>
     * 永久選挙人名簿のコード欄1に印字する内容 2：地区2
     */
    地区2(new RString("地区コード2"), new RString("4")),
    /**
     * 永久選挙人名簿のコード欄1に印字する内容 1：地区3 <BR>
     * 永久選挙人名簿のコード欄1に印字する内容 2：地区3
     */
    地区3(new RString("地区コード3"), new RString("5"));
    private final RString value;
    private final RString key;

    private EikyuMeiboInjiNaiyoConfig() {
        this.value = null;
        this.key = null;
    }

    private EikyuMeiboInjiNaiyoConfig(RString value) {
        this.value = value;
        this.key = null;
    }

    private EikyuMeiboInjiNaiyoConfig(RString key, RString value) {
        this.value = value;
        this.key = key;
    }

    /**
     * 値を取得
     *
     * @return value RString
     */
    public RString getValue() {
        return value;
    }

    /**
     * keyを取得
     *
     * @return key RString
     */
    public RString getKey() {
        return key;
    }
}
