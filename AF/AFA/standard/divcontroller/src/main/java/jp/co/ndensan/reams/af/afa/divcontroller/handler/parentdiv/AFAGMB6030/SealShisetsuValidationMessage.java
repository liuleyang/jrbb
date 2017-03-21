/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB6030;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 施設宛名シールのバリデーションメッセージです。
 *
 * @reamsid_L AF-0620-010 xul
 */
public enum SealShisetsuValidationMessage implements IValidationMessage {

    /**
     * 開始印字位置未入力のチェックメッセージです。
     */
    開始印字位置未入力(UrErrorMessages.必須項目_追加メッセージあり, "開始印字位置");
//    開始印字位置未入力("開始印字位置必須項目です。<br>");

    private final Message message;

    private SealShisetsuValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    private SealShisetsuValidationMessage(IMessageGettable message, String... replace) {
        this.message = message.getMessage().replace(replace);
    }

    @Override
    public Message getMessage() {
        return message;
    }

}
