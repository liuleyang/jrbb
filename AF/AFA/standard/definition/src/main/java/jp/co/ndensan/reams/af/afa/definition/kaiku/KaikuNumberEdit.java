/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.kaiku;

/**
 *
 * 海区漁業調整委員会委員選挙人名簿作成のパラーメタです。
 *
 * @reamsid_L AF-0460-020 lis
 */
public enum KaikuNumberEdit {

    /**
     * 固定数：0<br />
     */
    固定数_0(0),
    /**
     * 固定数：1<br />
     */
    固定数_1(1),
    /**
     * 固定数：1<br />
     */
    固定数_2(2),
    /**
     * 固定数：1<br />
     */
    固定数_3(3),
    /**
     * 固定数：1<br />
     */
    固定数_4(4),
    /**
     * 固定数：1<br />
     */
    固定数_5(5),
    /**
     * 固定数：1<br />
     */
    固定数_6(6),
    /**
     * 固定数：7<br />
     */
    固定数_7(7),
    /**
     * 固定数：8<br />
     */
    固定数_8(8),
    /**
     * 固定数：9<br />
     */
    固定数_9(9),
    /**
     * 固定数：10<br />
     */
    固定数_10(10),
    /**
     * 固定数：11<br />
     */
    固定数_11(11),
    /**
     * 固定数：12<br />
     */
    固定数_12(12),
    /**
     * 固定数：13<br />
     */
    固定数_13(13),
    /**
     * 固定数：14<br />
     */
    固定数_14(14),
    /**
     * 固定数：16<br />
     */
    固定数_16(16),
    /**
     * 固定数：17<br />
     */
    固定数_17(17),
    /**
     * 固定数：18<br />
     */
    固定数_18(18),
    /**
     * 固定数：19<br />
     */
    固定数_19(19),
    /**
     * 固定数：20<br />
     */
    固定数_20(20),
    /**
     * 固定数：21br />
     */
    固定数_21(21),
    /**
     * 固定数：15<br />
     */
    固定数_15(15),
    /**
     * 帳票最大行：25<br />
     */
    帳票最大行(25),
    /**
     * 年月の桁数：4<br />
     */
    年月の桁数(4),
    /**
     * 漁業日数：90<br />
     */
    リスト数3(3),
    /**
     * 漁業日数：90<br />
     */
    漁業日数(90),
    /**
     * 面数_12<br />
     */
    面数_12(12),
    /**
     * 面数_21<br />
     */
    面数_21(21);

    private final int key;

    private KaikuNumberEdit(int key) {
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
