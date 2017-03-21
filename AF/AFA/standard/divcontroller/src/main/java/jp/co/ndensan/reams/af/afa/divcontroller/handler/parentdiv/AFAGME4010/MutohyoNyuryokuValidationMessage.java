/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME4010;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 無投票入力のバリデーションメッセージです。
 *
 * @reamsid_L AF-0110-010 wangxt2
 */
public enum MutohyoNyuryokuValidationMessage implements IValidationMessage {

    /**
     * 入力値が不正_追加メッセージありです。
     *
     */
    入力値が不正_追加メッセージあり(UrErrorMessages.入力値が不正_追加メッセージあり);
    private final Message message;

    private MutohyoNyuryokuValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
