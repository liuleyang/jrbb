/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 転出表示区分を表す列挙型です。
 */
public enum TenshutuHyoujiKubun {

    /**
     * 県内転出<br />
     * code：1
     */
    県内転出("1"),
    /**
     * 県外転出<br />
     * code：2
     */
    県外転出("2"),
    /**
     * 国外転出<br />
     * code：3
     */
    国外転出("3"),
    /**
     * 不明<br />
     * code：4
     */
    不明("4");

    private final RString hyoujiKubun;

    private TenshutuHyoujiKubun(String hyoujiKubun) {
        this.hyoujiKubun = new RString(hyoujiKubun);
    }

    /**
     * 転出表示区分を取得します。
     *
     * @return 転出表示区分
     */
    public RString value() {
        return this.hyoujiKubun;
    }

}
