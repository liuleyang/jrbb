/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ShikakuJohoDiv の列挙型です。
 *
 * @reamsid_L AF-0180-015 lis2
 */
public enum ShikakuJohoEnum {

    /**
     * 有権者<br />
     * code：1
     */
    有権者("1", "有権者"),
    /**
     * 表示者<br />
     * code：2
     */
    表示者("2", "表示者"),
    /**
     * 転出<br />
     * code：3
     */
    転出("3", "転出"),
    /**
     * 死亡<br />
     * code：4
     */
    死亡("4", "死亡抹消"),
    /**
     * 転出4カ月経過抹消<br />
     * code：5
     */
    転出4カ月経過抹消("5", "転出4カ月経過抹消"),
    /**
     * 国籍喪失<br />
     * code：6
     */
    国籍喪失("6", "国籍喪失抹消"),
    /**
     * 表示事由<br />
     * code：7
     */
    表示事由("7", "表示事由"),
    /**
     * 抹消日<br />
     * code：8
     */
    抹消日("8", "抹消日"),
    /**
     * 抹消事由<br />
     * code：9
     */
    抹消事由("9", "抹消理由"),
    /**
     * 表示日<br />
     * code：9
     */
    表示日("10", "表示日"),
    /**
     * 登録停止日<br />
     * code：9
     */
    登録停止日("10", "登録停止日"),
    /**
     * 登録停止事由<br />
     * code：9
     */
    登録停止事由("10", "登録停止事由"),
    /**
     * 表示消除予定日のクリア<br />
     * code：9
     */
    表示消除予定日のクリア("10", "または、表示消除予定日をクリアしてください。"),
    /**
     * 名簿登録日<br />
     * code：9
     */
    名簿登録日("11", "名簿登録日"),
    /**
     * 転出者<br />
     * code：12
     */
    転出者("12", "転出者"),
    /**
     * 表示消除日<br />
     * code：12
     */
    表示消除日("13", "表示消除日"),
    /**
     * 表示消除予定日<br />
     * code：13
     */
    表示消除予定日("13", "表示消除予定日"),
    /**
     * 表示消除のクリア<br />
     * code：14
     */
    表示消除日のクリア("14", "または、表示消除日をクリアしてください。"),
    /**
     * 公選法第11条関係<br />
     * code：15
     */
    公選法第11条関係("15", "公選法第11条関係");

    private final RString code;
    private final RString name;

    private ShikakuJohoEnum(String code, String name) {
        this.code = new RString(code);
        this.name = new RString(name);
    }

    /**
     * 資格情報共有子DIVを取得します。
     *
     * @return 選挙レベルコード
     */
    public RString value() {
        return this.code;
    }

    /**
     * 資格情報共有子DIVを取得します。
     *
     * @return 選挙レベル略称
     */
    public RString toRString() {
        return this.name;
    }

}
