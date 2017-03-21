/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM2030;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 選挙区バリデーションメッセージです。
 *
 * @reamsid_L AF-0720-010 liuyj
 */
public enum SenkyokuMaintenanceValidationMessage implements IValidationMessage {

    /**
     * コード重複チェック。
     */
    コード重複チェック(UrErrorMessages.既に登録済, "入力した選挙区コード"),
    /**
     * 他ユーザ使用チェック。
     */
    他ユーザ使用チェック(UrErrorMessages.排他_他ユーザが更新済み);

    private final Message message;

    private SenkyokuMaintenanceValidationMessage(IMessageGettable message, String... replace) {
        this.message = message.getMessage().replace(replace);
    }

    /**
     * 郵便等投票資格登録のバリデーションメッセージを取得します。
     *
     * @return メッセージ
     */
    @Override
    public Message getMessage() {
        return message;
    }

}
