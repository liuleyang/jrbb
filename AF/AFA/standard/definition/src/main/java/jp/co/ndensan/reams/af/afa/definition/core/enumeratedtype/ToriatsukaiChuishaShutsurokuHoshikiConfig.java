/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 取扱注意者_出力方式のコンフィグと値
 */
public enum ToriatsukaiChuishaShutsurokuHoshikiConfig {

    /**
     * 取扱注意者_出力方式,
     */
    取扱注意者_出力方式,
    /**
     * 取扱注意者_出力方式が0の場合、何もしない
     */
    何もしない(new RString("0")),
    /**
     * 取扱注意者_出力方式が1の場合、行を詰める
     */
    行を詰める(new RString("1")),
    /**
     * 取扱注意者_出力方式が2の場合、行を空白
     */
    行を空白(new RString("2")),
    /**
     * 取扱注意者_出力方式が3の場合、行をマスク
     */
    行をマスク(new RString("3"));
    private final RString value;

    private ToriatsukaiChuishaShutsurokuHoshikiConfig() {
        this.value = null;
    }

    private ToriatsukaiChuishaShutsurokuHoshikiConfig(RString value) {
        this.value = value;
    }

    /**
     * 取扱注意者_出力方式を取得
     *
     * @return 取扱注意者_出力方式
     */
    public RString getValue() {
        return value;
    }

}
