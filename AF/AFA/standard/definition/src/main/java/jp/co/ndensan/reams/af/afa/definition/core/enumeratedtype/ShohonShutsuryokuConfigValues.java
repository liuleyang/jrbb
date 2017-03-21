/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.core.config.jushoinput.ConfigKeysCodeName;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 抄本_出力範囲指示の値を表す列挙型です。
 *
 */
public enum ShohonShutsuryokuConfigValues {

    /**
     * 抄本_出力範囲指示:11 住所です。
     */
    出力範囲指示_住所コード(new RString("11"), new RString("住所"), new RString(",\"ShikibetsuTaisho\".\"jutonaiChoikiCode\"")),
    /**
     * 抄本_出力範囲指示:12 行政区。
     */
    出力範囲指示_行政区コード(new RString("12"), new RString("行政区"), new RString(",\"ShikibetsuTaisho\".\"gyoseikuCode\"")),
    /**
     * 抄本_出力範囲指示:13 地区です。
     */
    出力範囲指示_地区コード1(new RString("13"), BusinessConfig.get(
            ConfigKeysCodeName.コード名称_地区の分類１, SubGyomuCode.URZ業務共通_共通系), new RString(",\"ShikibetsuTaisho\".\"chikuCode1\"")),
    /**
     * 抄本_出力範囲指示:14 地区2です。
     */
    出力範囲指示_地区コード2(new RString("14"), BusinessConfig.get(
            ConfigKeysCodeName.コード名称_地区の分類２, SubGyomuCode.URZ業務共通_共通系), new RString(",\"ShikibetsuTaisho\".\"chikuCode2\"")),
    /**
     * 抄本_出力範囲指示:15 地区3です。
     */
    出力範囲指示_地区コード3(new RString("15"), BusinessConfig.get(
            ConfigKeysCodeName.コード名称_地区の分類３, SubGyomuCode.URZ業務共通_共通系), new RString(",\"ShikibetsuTaisho\".\"chikuCode3\""));

    private final RString key;
    private final RString name;
    private final RString 出力順;

    private ShohonShutsuryokuConfigValues(RString key, RString name, RString 出力順) {
        this.key = key;
        this.name = name;
        this.出力順 = 出力順;
    }

    /**
     * キーの値取得メソッド 例: キー:11 名称:住所 11を取得
     *
     *
     * @return キー
     */
    public RString getKey() {
        return key;
    }

    /**
     * 名称の値取得メソッド　例: キー:11 名称:住所 住所を取得
     *
     * @return 名称
     */
    public RString getName() {
        return name;
    }

    /**
     * 出力順の値取得メソッド
     *
     * @return 出力順
     */
    public RString get出力順() {
        return 出力順;
    }
}
