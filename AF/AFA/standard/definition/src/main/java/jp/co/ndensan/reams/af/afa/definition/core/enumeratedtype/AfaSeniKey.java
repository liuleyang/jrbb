/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * AfaSeniKeyのクラスです。
 *
 * @reamsid_L AF-0500-020 gyq
 */
public enum AfaSeniKey {

    /**
     * 海区漁業調整委員会委員選挙人名簿登録
     */
    選挙人名簿登録(new RString("海区漁業調整委員会委員選挙人名簿登録")),
    /**
     * 海区漁業調整委員会委員選挙人名簿登録
     */
    選挙人名簿修正(new RString("海区漁業調整委員会委員選挙人名簿修正")),
    /**
     * 海区漁業調整委員会委員選挙人名簿登録
     */
    選挙人名簿削除(new RString("海区漁業調整委員会委員選挙人名簿削除")),
    /**
     * 国民投票時登録
     */
    国民投票時登録(new RString("AFAGMG1010")),
    /**
     * 国民投票時登録
     */
    国民投票情報修正(new RString("AFAGMG1020"));

    private final RString value;

    private AfaSeniKey(RString value) {
        this.value = value;
    }

    /**
     * valueを返します
     *
     * @return value
     */
    public RString getValue() {
        return value;
    }
}
