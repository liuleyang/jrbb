/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM2080;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 領事官
 *
 * @reamsid_L AF-0770-010 lis2
 */
public enum RyojikanMaintenanceValidationMessage implements IValidationMessage {

    /**
     * コード重複チェック。
     */
    コード重複チェック(UrErrorMessages.既に登録済, "入力した領事官コード");

    private final Message message;

    private RyojikanMaintenanceValidationMessage(IMessageGettable message, String... replace) {
        this.message = message.getMessage().replace(replace);
    }

    /**
     * 領事官保守のバリデーションメッセージを取得します。
     *
     * @return メッセージ
     */
    @Override
    public Message getMessage() {
        return message;
    }
}
