/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 印字文字を表す列挙型です。
 */
public enum InnjiMoji {

    /**
     * 不在者投票済
     */
    不在者投票済("不在者投票済"),
    /**
     * 期日前投票済
     */
    期日前投票済("期日前投票済"),
    /**
     * 不在者交付済
     */
    不在者交付済("不在者交付済"),
    /**
     * 当日投票済
     */
    当日投票済("当日投票済"),
    /**
     * 期・不投票済
     */
    期_不投票済("期・不投票済"),
    /**
     * 投票済
     */
    投票済("投票済"),
    /**
     * 一部投票済
     */
    一部投票済("一部投票済");

    private final RString moji;

    private InnjiMoji(String moji) {
        this.moji = new RString(moji);
    }

    /**
     * 印字文字を取得します。
     *
     * @return 印字文字
     */
    public RString value() {
        return this.moji;
    }
}
