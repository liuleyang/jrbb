/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.seikyushomeibotoroku.enumeratedtype;

/**
 * 財産区議会議員選挙時登録の関連値クラス(AFA)。
 *
 * @reamsid_L AF-0150-010 wangh
 */
public enum SeikyuShomeiboTorokuIntEnum {

    /**
     * 0。
     */
    INT_3(3),
    /**
     * 0。
     */
    INT_0(0),
    /**
     * 01。
     */
    INT_10(10),
    /**
     *
     * 01。
     */
    INT_20(20),
    /**
     *
     * 01。
     */
    INT_30(30),
    /**
     *
     * 01。
     */
    INT_40(40),
    /**
     *
     * 01。
     */
    INT_50(50),
    /**
     *
     * 07。
     */
    INT_60(60),
    /**
     *
     * 01。
     */
    INT_70(70),
    /**
     *
     * 01。
     */
    INT_80(80),
    /**
     *
     * 01。
     */
    INT_90(90),
    /**
     *
     * 01。
     */
    INT_100(100);

    private final int key;

    private SeikyuShomeiboTorokuIntEnum(int key) {
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
