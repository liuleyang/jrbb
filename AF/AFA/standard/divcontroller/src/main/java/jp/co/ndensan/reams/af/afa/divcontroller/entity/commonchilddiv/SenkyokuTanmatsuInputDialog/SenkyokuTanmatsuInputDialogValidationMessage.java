/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SenkyokuTanmatsuInputDialog;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * SenkyokuTanmatsuInputDialogDiv のチェックロジックです。
 *
 * @reamsid_L AF-0720-020 liuyj
 */
public enum SenkyokuTanmatsuInputDialogValidationMessage implements IValidationMessage {

    /**
     * 二重登録チェック。
     */
    二重登録チェック(UrErrorMessages.既に存在, "入力した端末ID"),
    /**
     * 二重登録チェック。
     */
    空白行の確認チェック(UrErrorMessages.必須, "端末ID"),
    /**
     * 他ユーザ使用チェック
     */
    他ユーザ使用チェック(UrErrorMessages.排他_他ユーザが更新済み);

    private final Message message;

    SenkyokuTanmatsuInputDialogValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    SenkyokuTanmatsuInputDialogValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
