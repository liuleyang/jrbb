/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 選挙資格区分を表す列挙型です。
 */
public enum SennkyoSikakuKubun {

    /**
     * 資格なし<br />
     * code：0
     */
    資格なし("0", "なし"),
    /**
     * 有権者<br />
     * code：1
     */
    有権者("1", "有権者"),
    /**
     * 有権者（1号資格）<br />
     * code：1
     */
    有権者_1号資格("1", "1号資格者"),
    /**
     * 有権者（2号資格）<br />
     * code：1
     */
    有権者_2号資格("2", "2号資格者"),
    /**
     * 表示者<br />
     * code：2
     */
    表示者("2", "表示者"),
    /**
     * 抹消者<br />
     * code：3
     */
    抹消者("3", "抹消者"),
    /**
     * 公民権停止<br />
     * code：4
     */
    公民権停止("4", "公民権停止者");

    private final RString sikakuKubun;
    private final RString value;

    private SennkyoSikakuKubun(String sikakuKubun, String value) {
        this.sikakuKubun = new RString(sikakuKubun);
        this.value = new RString(value);
    }

    /**
     * 選挙資格区分を取得します。
     *
     * @return 選挙資格区分
     * @deprecated getKey()を使用してください。
     */
    public RString value() {
        return this.sikakuKubun;
    }

    /**
     * 選挙資格区分を取得します。
     *
     * @return 選挙資格区分
     */
    public RString getKey() {
        return this.sikakuKubun;
    }

    /**
     * 選挙資格区分名称を取得します。
     *
     * @return 選挙資格区分名称
     */
    public RString getValue() {
        return this.value;
    }
}
