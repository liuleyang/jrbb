/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME3010;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * AFAGME3010 当日投票の入力チェックのメッセージクラスです。
 *
 * @reamsid_L AF-0260-010 liuyj
 */
public enum TojitsuTohyoValidationMessage implements IValidationMessage {

    /**
     * 集計時間必須項目を入力。
     */
    集計時間必須入力(UrErrorMessages.必須項目_追加メッセージあり, "集計時間");

    private final Message message;

    private TojitsuTohyoValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    private TojitsuTohyoValidationMessage(IMessageGettable message, String... replace) {
        this.message = message.getMessage().replace(replace);
    }

    @Override
    public Message getMessage() {
        return message;
    }

}
