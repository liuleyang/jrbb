/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMK1040;

import jp.co.ndensan.reams.af.afa.definition.message.AfErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * AFAGMK1040 海区漁業調整委員会委員選挙人名簿最新化ValidatorMessage <br />
 *
 * @reamsid_L AF-0480-010 liuj
 */
public enum KaikuNewMeiboSaishinkaValidationMessage implements IMessageGettable, IValidationMessage {

    /**
     * 抄本選択チェック
     */
    抄本選択チェック(UrErrorMessages.対象行を選択),
    /**
     * 投票状況存在チェック
     */
    投票状況存在チェック(AfErrorMessages.名簿最新化不可, "選挙人");

    private final Message message;

    @Override
    public Message getMessage() {
        return message;
    }

    private KaikuNewMeiboSaishinkaValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

}
