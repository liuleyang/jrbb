/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMA1030;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 定時登録再発行のバリデーションメッセージです。
 *
 * @reamsid_L AF-0020-010 gaoya
 */
public enum RePrintTeijiValidationMessage implements IValidationMessage {

    /**
     * 必須項目を選択です。
     *
     */
    必須項目を選択(UrErrorMessages.選択されていない, "抄本"),
    /**
     * 必須項目を選択です。
     *
     */
    作成帳票を選択(UrErrorMessages.選択されていない, "作成帳票");

    private final Message message;

    private RePrintTeijiValidationMessage(IMessageGettable message, String... replace) {
        this.message = message.getMessage().replace(replace);
    }

    /**
     * 定時登録再発行のバリデーションメッセージを取得します。
     *
     * @return メッセージ
     */
    @Override
    public Message getMessage() {
        return message;
    }

}
