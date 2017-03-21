/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住所編集を表す列挙型です。
 */
public enum JushoCode {

    /**
     * 番地<br />
     * code：10
     */
    番地("10"),
    /**
     * 住所_番地<br />
     * code：11
     */
    住所_番地("11"),
    /**
     * 住所<br />
     * code：11
     */
    住所("11"),
    /**
     * 行政区<br />
     * code：12
     */
    行政区("12"),
    /**
     * 行政区_番地<br />
     * code：12
     */
    行政区_番地("12"),
    /**
     * 地区コード1<br />
     * code：13
     */
    地区コード１("13"),
    /**
     * 地区コード2<br />
     * code：14
     */
    地区コード２("14"),
    /**
     * 地区コード3<br />
     * code：15
     */
    地区コード３("15");

    private final RString zyusho;

    private JushoCode(String zyusho) {
        this.zyusho = new RString(zyusho);
    }

    /**
     * 住所編集を取得します。
     *
     * @return 住所編集
     */
    public RString value() {
        return this.zyusho;
    }
}
