/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME2010;

import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * AFAGME2010 不在者投票のエラーのメッセージクラスです。
 *
 * @reamsid_L AF-0080-010 lit
 */
public class FuzaishaTohyoErrorMessage implements IValidationMessage {

    private final Message message;

    /**
     * コンストラクス。
     *
     * @param message Message
     */
    public FuzaishaTohyoErrorMessage(Message message) {
        this.message = message;
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
