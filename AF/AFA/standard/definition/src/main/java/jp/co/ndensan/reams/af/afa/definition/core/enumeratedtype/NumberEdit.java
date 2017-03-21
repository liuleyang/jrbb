/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

/**
 * 固定数の列挙型
 *
 * @reamsid_L AF-0460-034 wanghj
 */
public enum NumberEdit {

    /**
     * 固定数：０<br />
     */
    固定数_０(0),
    /**
     * 固定数：１<br />
     */
    固定数_１(1),
    /**
     * 固定数：２<br />
     */
    固定数_２(2),
    /**
     * 固定数：３<br />
     */
    固定数_３(3),
    /**
     * 固定数：４<br />
     */
    固定数_４(4),
    /**
     * 固定数：5<br />
     */
    固定数_５(5),
    /**
     * 固定数：８<br />
     */
    固定数_８(8),
    /**
     * 固定数：９<br />
     */
    固定数_９(9),
    /**
     * 固定数：11<br />
     */
    固定数_11(11),
    /**
     * 固定数：13<br />
     */
    固定数_13(13),
    /**
     * 固定数：15<br />
     */
    固定数_15(15);

    private final int key;

    private NumberEdit(int key) {
        this.key = key;
    }

    /**
     * 固定数keyを取得します。
     *
     * @return 市町村区分key
     */
    public int getKey() {
        return this.key;
    }

}
