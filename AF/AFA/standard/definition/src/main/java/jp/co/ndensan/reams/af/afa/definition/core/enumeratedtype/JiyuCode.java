/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 事由コードのを表す列挙型です
 */
public enum JiyuCode {

    /**
     * 登録事由コード 11:年齢到達
     */
    年齢到達(new RString("年齢到達"), new RString("11")),
    /**
     * 登録事由コード 12:転入3カ月経過
     */
    転入3カ月経過(new RString("転入3カ月経過"), new RString("12")),
    /**
     * 登録事由コード 13:その他
     */
    その他_登録(new RString("その他"), new RString("15")),
    /**
     * 抹消事由コード 01:死亡
     */
    死亡(new RString("死亡"), new RString("01")),
    /**
     * 抹消事由コード 02:国籍喪失
     */
    国籍喪失(new RString("国籍喪失"), new RString("02")),
    /**
     * 抹消事由コード 03:転出4カ月
     */
    転出4カ月(new RString("転出4カ月"), new RString("03")),
    /**
     * 抹消事由コード 04:誤載
     */
    誤載(new RString("誤載"), new RString("04")),
    /**
     * 抹消事由コード 05:二重登録
     */
    二重登録(new RString("二重登録"), new RString("05")),
    /**
     * 抹消事由コード 06:基準日前異動
     */
    基準日前異動(new RString("基準日前異動"), new RString("06")),
    /**
     * 抹消事由コード 07:職権消除
     */
    職権消除(new RString("職権消除"), new RString("07")),
    /**
     * 抹消事由コード 08:居住要件
     */
    居住要件(new RString("居住要件"), new RString("08")),
    /**
     * 抹消事由コード 09:その他
     */
    その他_抹消(new RString("その他"), new RString("09")),
    /**
     * 失権事由コード 01:4ヶ月経過
     */
    _4ヶ月経過(new RString("4ヶ月経過"), new RString("01")),
    /**
     * 失権事由コード 02:公民権停止
     */
    公民権停止(new RString("公民権停止"), new RString("02")),
    /**
     * 失権事由コード 03:転出4カ月
     */
    失権(new RString("失権"), new RString("03")),
    /**
     * 失権事由コード 04:再転入
     */
    再転入_失権(new RString("再転入"), new RString("04")),
    /**
     * 表示事由コード 01:再転入
     */
    再転入_表示(new RString("再転入"), new RString("01")),
    /**
     * 表示事由コード 02:転出者
     */
    転出者(new RString("転出者"), new RString("02")),
    /**
     * 表示事由コード 03:公民権停止者
     */
    公民権停止者(new RString("公民権停止者"), new RString("03")),
    /**
     * 表示事由コード 06:転出
     */
    転出(new RString("転出"), new RString("06")),
    /**
     * 表示事由コード 07:職権消除
     */
    職権消除_表示(new RString("職権消除"), new RString("07")),
    /**
     * 表示事由コード 09:その他
     */
    その他_表示(new RString("その他"), new RString("09")),
    /**
     * 表示事由コード 12:公職選挙法第11条1項2号該当
     */
    公職選挙法第11条1項2号該当(new RString("公職選挙法第11条1項2号該当"), new RString("12")),
    /**
     * 表示事由コード 13:公職選挙法第11条1項3号該当
     */
    公職選挙法第11条1項3号該当(new RString("公職選挙法第11条1項3号該当"), new RString("13")),
    /**
     * 表示事由コード 14:公職選挙法第11条1項4号該当
     */
    公職選挙法第11条1項4号該当(new RString("公職選挙法第11条1項4号該当"), new RString("14")),
    /**
     * 表示事由コード 15:公職選挙法第11条1項5号該当
     */
    公職選挙法第11条1項5号該当(new RString("公職選挙法第11条1項5号該当"), new RString("15")),
    /**
     * 表示事由コード 20:公職選挙法第11条2項該当
     */
    公職選挙法第11条2項該当(new RString("公職選挙法第11条2項該当"), new RString("20")),
    /**
     * 訂正者事由コード 01:転居
     */
    転居(new RString("転居"), new RString("01")),
    /**
     * 訂正者事由コード 02:訂正
     */
    訂正(new RString("訂正"), new RString("02"));
    private final RString value;
    private final RString key;

    private JiyuCode(RString value, RString key) {
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
