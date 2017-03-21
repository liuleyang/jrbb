/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 投票状況名称を表す列挙型です。
 */
public enum TohyoJokyoMeishou {

    /**
     * 交付済み
     */
    交付済み("交付済み"),
    /**
     * 不在済み
     */
    不在済み("不在済み"),
    /**
     * 交付取消
     */
    交付取消("交付取消"),
    /**
     * 投票棄権
     */
    投票棄権("投票棄権"),
    /**
     * 期日前済
     */
    期日前済("期日前済"),
    /**
     * 当日済み
     */
    当日済み("当日済み");

    private final RString tohyoJokyoMeishou;

    private TohyoJokyoMeishou(String tohyoJokyoMeishou) {
        this.tohyoJokyoMeishou = new RString(tohyoJokyoMeishou);
    }

    /**
     * 投票状況名称を取得します。
     *
     * @return 投票状況名称
     */
    public RString value() {
        return this.tohyoJokyoMeishou;
    }
}
