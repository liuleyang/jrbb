/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.kaiku;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 海区漁業調整委員会委員選挙人名簿作成のパラーメタです。
 *
 * @reamsid_L AF-0460-020 lis
 */
public enum MeiboKaikuEdited {

    /**
     * ファイルを指定して作成する:1
     */
    ファイルを指定して作成する(new RString("ファイルを指定して作成する"), new RString("1")),
    /**
     * 前年度の選挙人名簿から作成:0
     */
    前年度の選挙人名簿から作成(new RString("前年度の選挙人名簿から作成"), new RString("0")),
    /**
     * 新規処理:1
     */
    新規処理(new RString("新規処理"), new RString("1")),
    /**
     * ファイルを指定して作成する:1
     */
    再処理(new RString("再処理"), new RString("2")),
    /**
     * 公職選挙法第11条1項2号該当:12
     */
    公職選挙法第11条1項2号該当(new RString("公職選挙法第11条1項2号該当"), new RString("12")),
    /**
     * 公職選挙法第11条1項3号該当:13
     */
    公職選挙法第11条1項3号該当(new RString("公職選挙法第11条1項3号該当"), new RString("13")),
    /**
     * 公職選挙法第11条1項4号該当:14
     */
    公職選挙法第11条1項4号該当(new RString("公職選挙法第11条1項4号該当"), new RString("14")),
    /**
     * 公職選挙法第11条1項5号該当:15
     */
    公職選挙法第11条1項5号該当(new RString("公職選挙法第11条1項5号該当"), new RString("15")),
    /**
     * 公職選挙法第11条2項該当:20
     */
    公職選挙法第11条2項該当(new RString("公職選挙法第11条2項該当"), new RString("20")),
    /**
     * 住民状態:1
     */
    住民状態_1(new RString("住民状態"), new RString("1")),
    /**
     * 性別_男:1
     */
    性別_男(new RString("性別_男"), new RString("1")),
    /**
     * 性別_女:2
     */
    性別_女(new RString("性別_女"), new RString("2")),
    /**
     * 世帯主区分:0
     */
    世帯主区分_0(new RString("世帯主区分"), new RString("0")),
    /**
     * 世帯主区分:1
     */
    世帯主区分_1(new RString("世帯主区分"), new RString("1")),
    /**
     * 面数_12:12
     */
    面数_12(new RString("面数_12"), new RString("12")),
    /**
     * 面数_21:21
     */
    面数_21(new RString("面数_21"), new RString("21")),
    /**
     * その他:15
     */
    その他(new RString("その他"), new RString("15")),
    /**
     * 海区漁業調整委員会委員選挙時登録:'AFAGMK1030'
     */
    海区漁業調整委員会委員選挙時登録(new RString("海区漁業調整委員会委員選挙時登録"), new RString("AFAGMK1030")),
    /**
     * 海区漁業調整委員会委員選挙人名簿最新化:'AFAGMK1040'
     */
    海区漁業調整委員会委員選挙人名簿最新化(new RString("海区漁業調整委員会委員選挙人名簿最新化"), new RString("AFAGMK1040"));

    private final RString value;
    private final RString key;

    private MeiboKaikuEdited(RString value, RString key) {
        this.value = value;
        this.key = key;
    }

    /**
     * 値を取得<BR>
     *
     * @return key RString
     */
    public RString getKey() {
        return key;
    }

    /**
     * keyを取得 <BR>
     *
     * @return value RString
     */
    public RString getValue() {
        return value;
    }

}
