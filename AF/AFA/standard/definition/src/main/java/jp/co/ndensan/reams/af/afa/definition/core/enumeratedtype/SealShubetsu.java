/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * シール種別を表す列挙型です。
 *
 * @reamsid_L AF-0620-016 zhangl
 */
public enum SealShubetsu {

    /**
     * 宣誓書貼付用。
     */
    宣誓書貼付用("宣誓書貼付用"),
    /**
     * 封筒貼付用。
     */
    封筒貼付用("封筒貼付用"),
    /**
     * 抄本貼付用。
     */
    抄本貼付用("抄本貼付用"),
    /**
     * 入場券貼付用。
     */
    入場券貼付用("入場券貼付用");

    private final RString sealShubetsu;

    private SealShubetsu(String sealShubetsu) {
        this.sealShubetsu = new RString(sealShubetsu);
    }

    /**
     * シール種別を返します。
     *
     * @return シール種別
     */
    public RString getシール種別() {
        return this.sealShubetsu;
    }
}
