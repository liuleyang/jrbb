/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.tohyorelate.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * AFAGMM2040 投票区投票所対応保守
 *
 * @reamsid_L AF-0740-010 lis2
 */
public enum TohyoRelateEnum {

    /**
     * 通常選挙
     */
    通常選挙("0");
    private final RString key;

    private TohyoRelateEnum(String key) {
        this.key = new RString(key);
    }

    /**
     * 業務コンフィグの説明の関連値を返します。
     *
     * @return 業務コンフィグの説明の関連値
     */
    public RString getKey() {
        return this.key;
    }
}
