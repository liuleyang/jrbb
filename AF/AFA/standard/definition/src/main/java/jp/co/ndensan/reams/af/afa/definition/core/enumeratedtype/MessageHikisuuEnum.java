/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * メッセージ引数を表す列挙型です。
 *
 * @reamsid_L AF-0400-010 guancy
 */
public enum MessageHikisuuEnum {

    /**
     * 抄本件数エラー_処理可能な
     */
    抄本件数エラー_処理可能な(new RString("処理可能な"));

    private final RString massge;

    private MessageHikisuuEnum(RString massge) {
        this.massge = massge;
    }

    /**
     * 印字文字を取得します。
     *
     * @return 印字文字
     */
    public String getValue() {
        return this.massge.toString();
    }
}
