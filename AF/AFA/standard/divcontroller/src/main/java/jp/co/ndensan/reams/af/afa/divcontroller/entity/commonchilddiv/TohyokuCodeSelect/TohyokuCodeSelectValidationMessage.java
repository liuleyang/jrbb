/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelect;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 *
 * TohyokuCodeSelectDiv のMessageクラスです。
 */
public enum TohyokuCodeSelectValidationMessage implements IValidationMessage {

    /**
     * 投票区コード存在しない。
     */
    投票区コード存在しない(UrErrorMessages.存在しない, "投票区コード");

    private final Message message;

    private TohyokuCodeSelectValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    private TohyokuCodeSelectValidationMessage(IMessageGettable message, String... replace) {
        this.message = message.getMessage().replace(replace);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
