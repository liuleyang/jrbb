/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME5050;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 投票日前日関連帳票の入力チェックのメッセージクラスです。
 *
 * @reamsid_L AF-0290-010 lit
 */
public enum TohyoKekkaShukeiSakuseiValidationMessage implements IValidationMessage {

    /**
     * 作成帳票必須。
     */
    作成帳票必須(UrErrorMessages.選択されていない, "作成帳票");

    private final Message message;

    TohyoKekkaShukeiSakuseiValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    TohyoKekkaShukeiSakuseiValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
