/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SenkyokuCodeSelect;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * SenkyokuCodeSelectDiv のチェックロジックです。
 *
 * @reamsid_L AF-0720-030 zhanggs
 */
public enum SenkyokuCodeSelectValidationMessage implements IValidationMessage {

    /**
     * 選挙区コードのチェック。
     */
    選挙区コード(UrErrorMessages.存在しない, "選挙区");

    private final Message message;

    SenkyokuCodeSelectValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    SenkyokuCodeSelectValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
