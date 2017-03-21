/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 抄本コンフィグの値を表す列挙型です。
 */
public enum MeiboShohonConfigValue {

    /**
     * 抄本_冊区分管理_使用しない
     */
    抄本_冊区分管理_使用しない(new RString("0")),
    /**
     * 抄本_冊区分管理_性別を冊区分とする
     */
    抄本_冊区分管理_性別を冊区分とする(new RString("1")),
    /**
     * 抄本_グループコード_未使用
     */
    抄本_グループコード_未使用(new RString("0")),
    /**
     * 抄本_グループコード_居住区分毎
     */
    抄本_グループコード_居住区分毎(new RString("1")),
    /**
     * 抄本_グループコード_資格区分毎
     */
    抄本_グループコード_資格区分毎(new RString("2"));

    private final RString value;

    private MeiboShohonConfigValue(RString value) {
        this.value = value;
    }

    /**
     * MeiboShohonConfigValue 対応の値の取得メソッド
     *
     * @return RString
     */
    public RString getValue() {
        return value;
    }
}
