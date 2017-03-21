/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM2060;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * AFAGMM2060 投票補助者保守
 *
 * @reamsid_L AF-0750-010 lis2
 */
public enum HojoshaMaintenanceValidatorMessage implements IMessageGettable, IValidationMessage {

    /**
     * コード重複のチェック
     */
    コード重複のチェック(UrErrorMessages.既に登録済, "入力した識別コード"),
    /**
     * 他ユーザ使用のチェック
     */
    他ユーザ使用のチェック(UrErrorMessages.排他_他ユーザが更新済み),
    /**
     * コード存在性のチェック
     */
    コード存在性のチェック(UrErrorMessages.存在しない, "入力した識別コード");

    private final Message message;

    @Override
    public Message getMessage() {
        return message;
    }

    private HojoshaMaintenanceValidatorMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }
}
