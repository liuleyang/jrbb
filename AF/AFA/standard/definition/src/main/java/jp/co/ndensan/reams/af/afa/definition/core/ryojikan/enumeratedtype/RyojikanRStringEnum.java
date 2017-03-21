/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.ryojikan.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * AFAGMM2080 領事官保守
 *
 * @reamsid_L AF-0770-010 lis2
 */
public enum RyojikanRStringEnum {

    /**
     * コードの追加をやめる。
     */
    コードの追加をやめる("コードの追加をやめる"),
    /**
     * コードを追加する。
     */
    コードを追加する("コードを追加する"),
    /**
     * コードの修正をやめる。
     */
    コードの修正をやめる("コードの修正をやめる"),
    /**
     * コードを保存する。
     */
    コードを保存する("コードを保存する"),
    /**
     * コードの削除をやめる。
     */
    コードの削除をやめる("コードの削除をやめる"),
    /**
     * コードを削除する。
     */
    コードを削除する("コードを削除する"),
    /**
     * 追加。
     */
    追加("1"),
    /**
     * 修正。
     */
    修正("2"),
    /**
     * 削除。
     */
    削除("3");

    private final RString key;

    private RyojikanRStringEnum(String key) {
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
