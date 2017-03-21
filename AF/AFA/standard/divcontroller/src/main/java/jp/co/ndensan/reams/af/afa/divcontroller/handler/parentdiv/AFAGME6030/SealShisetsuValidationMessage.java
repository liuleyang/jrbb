/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME6030;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 施設宛名シールのチェックメッセージクラスです。
 *
 * @reamsid_L AF-0620-010 xul
 */
public enum SealShisetsuValidationMessage implements IValidationMessage {

    /**
     * 開始印字位置選択チェック。
     */
    開始印字位置選択チェック(UrErrorMessages.必須項目_追加メッセージあり, "開始印字位置");

    private final Message message;

    SealShisetsuValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    SealShisetsuValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
