/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelectRange;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * TohyokuCodeSelectRangeDivの入力チェックのメッセージクラスです。
 *
 * @reamsid_L AF-0270-013 xul
 */
public enum TohyokuCodeSelectRangeValidationMessage implements IValidationMessage {

    /**
     * 投票区コード範囲。
     */
    投票区コード範囲(UrErrorMessages.大小関係が不正, "投票区コード"),
    /**
     * 投票区コード開始入力。
     */
    投票区コード開始入力(UrErrorMessages.未入力, "投票区開始"),
    /**
     * 投票区コード終了入力。
     */
    投票区コード終了入力(UrErrorMessages.未入力, "投票区終了");

    private final Message message;

    TohyokuCodeSelectRangeValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    TohyokuCodeSelectRangeValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
