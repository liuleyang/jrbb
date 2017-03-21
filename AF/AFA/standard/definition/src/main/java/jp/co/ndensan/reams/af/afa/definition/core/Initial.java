/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core;

/**
 * 保守のクラス
 *
 * @reamsid_L AF-0700-010 liuyj
 */
public enum Initial {

    /**
     * 表示順初期値。
     */
    表示順初期値(0);
    private final int key;

    private Initial(int key) {
        this.key = key;
    }

    /**
     * 業務コンフィグの説明の関連値を返します。
     *
     * @return 業務コンフィグの説明の関連値
     */
    public int getKey() {
        return this.key;
    }
}
