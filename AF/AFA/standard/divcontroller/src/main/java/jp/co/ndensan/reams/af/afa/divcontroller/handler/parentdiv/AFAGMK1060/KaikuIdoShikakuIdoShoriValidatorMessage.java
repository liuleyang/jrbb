/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMK1060;

import jp.co.ndensan.reams.af.afa.definition.message.AfErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * AFAGMK1060 海区漁業調整委員会委員選挙人名簿登録 <br />
 *
 * @reamsid_L AF-0500-010 zhanggs
 */
public enum KaikuIdoShikakuIdoShoriValidatorMessage implements IMessageGettable, IValidationMessage {

    /**
     * 保存データの存在チェック
     */
    保存データの存在チェック(AfErrorMessages.登録不可, "既に登録済み"),
    /**
     * 削除データの存在チェック
     */
    修正削除データの存在チェック(UrErrorMessages.存在しない, "選択した抄本内に、選択した選挙人");

    private final Message message;

    @Override
    public Message getMessage() {
        return message;
    }

    private KaikuIdoShikakuIdoShoriValidatorMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }
}
