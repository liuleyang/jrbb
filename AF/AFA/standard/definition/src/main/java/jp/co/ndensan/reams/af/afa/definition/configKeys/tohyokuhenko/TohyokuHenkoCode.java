/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.configkeys.tohyokuhenko;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 投票区変更キーです。
 */
public enum TohyokuHenkoCode {

    /**
     * 登録用選挙人名簿です。
     */
    登録用選挙人名簿キー("senkyoninMeiboForInsert"),
    /**
     * 更新用選挙人名簿です。
     */
    更新用選挙人名簿キー("senkyoninMeiboForUpdate"),
    /**
     * 画面引数です。
     */
    画面引数("gamenhikisu"),
    /**
     * 検索結果
     */
    検索結果("kensakuKekka");
    
    

    private final RString key;

    private TohyokuHenkoCode(String key) {
        this.key = new RString(key);
    }

    /**
     * keyを返します。
     *
     * @return key文字列
     */
    public RString getKey() {
        return key;
    }
}
