/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.message;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link jp.co.ndensan.reams.uz.uza.message.Message Message}
 * のインスタンス生成を補助するためのユーティリティクラスです。
 *
 * @author N1823 有澤 礼恵
 */
final class MessageCreateHelper {

    /**
     * インスタンス化を防ぐためのデフォルトコンストラクタです。
     */
    private MessageCreateHelper() {
    }

    static String toCode(String prefix, int no) {

        RString noString = new RString(Integer.toString(no));
        final int five = 5;
        RString zeroPadded = noString.padZeroToLeft(five);

        return prefix + zeroPadded.toString();
    }
}
