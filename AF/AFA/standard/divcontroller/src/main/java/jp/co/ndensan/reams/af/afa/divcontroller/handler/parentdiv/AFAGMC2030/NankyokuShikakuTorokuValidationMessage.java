/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMC2030;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 南極投票資格登録のバリデーションメッセージです。
 *
 * @reamsid_L AF-0220-010 guyq
 */
public enum NankyokuShikakuTorokuValidationMessage implements IValidationMessage {

    /**
     * 登録日必須。
     */
    登録日必須(UrErrorMessages.必須項目_追加メッセージあり, "登録日"),
    /**
     * 交付日必須。
     *
     */
    交付日必須(UrErrorMessages.必須項目_追加メッセージあり, "交付日"),
    /**
     * 満了日必須。
     *
     */
    有効期限日必須(UrErrorMessages.必須項目_追加メッセージあり, "有効期限日"),
    /**
     * 抹消日必須。
     *
     */
    抹消日必須(UrErrorMessages.必須項目_追加メッセージあり, "抹消日"),
    /**
     * 事由を選択です。
     *
     */
    事由を選択です(UrErrorMessages.必須項目_追加メッセージあり, "事由");

    private final Message message;

    private NankyokuShikakuTorokuValidationMessage(IMessageGettable message, String... replace) {
        this.message = message.getMessage().replace(replace);
    }

    /**
     * 洋上投票資格登録のバリデーションメッセージを取得します。
     *
     * @return メッセージ
     */
    @Override
    public Message getMessage() {
        return message;
    }

}
