/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShisetsuCodeSelect;

import jp.co.ndensan.reams.af.afa.definition.message.AfErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 施設宛名シールのチェックメッセージクラスです。
 *
 * @reamsid_L AF-0620-010 xul
 */
public enum ShisetsuCodeValidationMessage implements IValidationMessage {

    /**
     * 開始印字位置選択チェック。
     */
    施設コードの関連性チェック(AfErrorMessages.施設コードと施設種別の関係不正);

    private final Message message;

    ShisetsuCodeValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    ShisetsuCodeValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
