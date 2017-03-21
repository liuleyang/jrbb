/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

/**
 *
 * @reamsid_L AF-0360-064 b_caiyf
 */
public enum CodeTopType {

    /**
     * コード上5桁
     */
    コード上5桁(5);
    private final int code;

    private CodeTopType(int code) {
        this.code = code;
    }

    /**
     * valueを取得します。
     *
     * @return code
     */
    public int value() {
        return this.code;
    }
}
