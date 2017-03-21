/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShisetsuCodeSelectRange;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * ShisetsuCodeSelectRangeDivの入力チェックのメッセージクラスです。
 *
 * @reamsid_L AF-0270-012 xul
 */
public enum ShisetsuCodeSelectRangeValidationMessage implements IValidationMessage {

    /**
     * 施設コード範囲。
     */
    施設コード範囲(UrErrorMessages.大小関係が不正, "施設コード"),
    /**
     * 施設コード開始入力。
     */
    施設コード開始入力(UrErrorMessages.未入力, "施設コード開始"),
    /**
     * 施設コード終了入力。
     */
    施設コード終了入力(UrErrorMessages.未入力, "施設コード終了");

    private final Message message;

    ShisetsuCodeSelectRangeValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    ShisetsuCodeSelectRangeValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
