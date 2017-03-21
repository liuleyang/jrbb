/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 年月日検索基準を表す列挙型です。
 *
 */
public enum YMDKensakuKijunConfig {

    /**
     * 登録年月日検索基準
     */
    登録年月日検索基準,
    /**
     * 消除年月日検索基準
     */
    消除年月日検索基準,
    /**
     * 登録年月日検索基準 2:登録異動年月日
     */
    登録異動年月日(new RString("2")),
    /**
     * 登録年月日検索基準 1:登録届出年月日
     */
    登録届出年月日(new RString("1")),
    /**
     * 消除年月日検索基準 2:消除異動年月日
     */
    消除異動年月日(new RString("2")),
    /**
     * 消除年月日検索基準 1:消除届出年月日
     */
    消除届出年月日(new RString("1"));
    private final RString value;

    private YMDKensakuKijunConfig() {
        this.value = null;
    }

    private YMDKensakuKijunConfig(RString value) {
        this.value = value;
    }

    /**
     * 年月日検索基準を取得
     *
     * @return 年月日検索基準
     */
    public RString getValue() {
        return value;
    }
}
