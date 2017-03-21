/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.MeiboSakuseiKijun;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

public enum MeiboSakuseiKijunMessage implements IValidationMessage {

    最大登録選挙数のチェック(UrErrorMessages.項目に対する制約, "選挙", "9件以内");

    private final Message message;

    private MeiboSakuseiKijunMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    private MeiboSakuseiKijunMessage(IMessageGettable message, String... replace) {
        this.message = message.getMessage().replace(replace);
    }

    @Override
    public Message getMessage() {
        return message;
    }

}
