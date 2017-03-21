/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM2020;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 *
 * @reamsid_L AF-0710-010 liuyj
 */
public enum TohyojoMaintenanceValidatorMessage implements IValidationMessage {

    /**
     * コード重複。
     */
    コード重複(UrErrorMessages.既に登録済, "入力した投票所コード");

    private final Message message;

    TohyojoMaintenanceValidatorMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    TohyojoMaintenanceValidatorMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
