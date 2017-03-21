/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.senkyojizaisanku.enumeratedtype;

/**
 * 財産区議会議員選挙時登録の関連値クラス(AFA)。
 *
 * @reamsid_L AF-0390-030 jihb
 */
public enum SenkyojiZaisankuIntEnum {

    /**
     * 25。
     */
    帳票最大行(25),
    /**
     * 0。
     */
    INT_0(0),
    /**
     * 1。
     */
    INT_1(1),
    /**
     * 2。
     */
    INT_2(2),
    /**
     * 3。
     */
    INT_3(3),
    /**
     * 4。
     */
    INT_4(4);

    private final int key;

    private SenkyojiZaisankuIntEnum(int key) {
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
