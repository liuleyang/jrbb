/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMC2010;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 郵便等投票資格登録のバリデーションメッセージです。
 *
 * @reamsid_L AF-0200-010 liuj2
 */
public enum YubinShikakuTorokuValidationMessage implements IValidationMessage {

    /**
     * 資格条件を選択です。
     */
    資格条件を選択です(UrErrorMessages.必須項目_追加メッセージあり, "資格条件"),
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
    満了日必須(UrErrorMessages.必須項目_追加メッセージあり, "満了日"),
    /**
     * 抹消日必須。
     *
     */
    抹消日必須(UrErrorMessages.必須項目_追加メッセージあり, "抹消日"),
    /**
     * 事由を選択です。
     *
     */
    事由を選択です(UrErrorMessages.必須項目_追加メッセージあり, "事由"),
    /**
     * 登録日未入力。
     */
    登録日未入力(UrErrorMessages.未入力, "登録日");

    private final Message message;

    private YubinShikakuTorokuValidationMessage(IMessageGettable message, String... replace) {
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
