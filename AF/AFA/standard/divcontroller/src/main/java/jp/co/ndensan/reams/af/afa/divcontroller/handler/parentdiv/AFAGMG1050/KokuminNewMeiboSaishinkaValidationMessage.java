/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMG1050;

import jp.co.ndensan.reams.af.afa.definition.message.AfErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 投票人名簿最新化のクラス
 *
 * @reamsid_L AF-0390-010 jihb
 */
public enum KokuminNewMeiboSaishinkaValidationMessage implements IValidationMessage {

    /**
     * 抄本選択チェック。
     */
    抄本選択チェック(UrErrorMessages.対象行を選択),
    /**
     * 投票状況存在チェック。
     */
    投票状況存在チェック(AfErrorMessages.名簿最新化不可, "投票人");

    private final Message message;

    KokuminNewMeiboSaishinkaValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    KokuminNewMeiboSaishinkaValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
