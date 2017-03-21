/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMG1020;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 国民投票情報修正のバリデーションメッセージです。
 *
 * @reamsid_L AF-0370-010 lis
 */
public enum KokuminTaishoShohonJohoValidationMessage implements IValidationMessage {

    /**
     * 抄本名必須チェックです。
     *
     */
    改正案入力確認(UrErrorMessages.必須, "改正案"),
    /**
     * 選挙レベル必須チェックです。
     *
     */
    略称入力確認(UrErrorMessages.必須, "略称");

    private final Message message;

    private KokuminTaishoShohonJohoValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    private KokuminTaishoShohonJohoValidationMessage(IMessageGettable message, String... replace) {
        this.message = message.getMessage().replace(replace);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
