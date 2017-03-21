/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM2010;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 投票区保守Message
 *
 * @reamsid_L AF-0700-010 liuyj
 */
public enum TohyokuMaintenanceValidationMessage implements IValidationMessage {

    /**
     * コード重複チェック。
     */
    コード重複チェック(UrErrorMessages.既に登録済, "入力した投票区コード");

    private final Message message;

    private TohyokuMaintenanceValidationMessage(IMessageGettable message, String... replace) {
        this.message = message.getMessage().replace(replace);
    }

    /**
     * 投票区保守のバリデーションメッセージを取得します。
     *
     * @return メッセージ
     */
    @Override
    public Message getMessage() {
        return message;
    }
}
