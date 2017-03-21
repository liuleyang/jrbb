/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMG1060;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 国民投票帳票再発行のクラス
 *
 * @reamsid_L AF-0400-010 guancy
 */
public enum RePrintKokuminValidationMessage implements IValidationMessage {

    /**
     * 登録者の時点チェック。
     *
     */
    登録者の時点チェック(UrErrorMessages.未入力, "時点"),
    /**
     * 抄本選択チェック。
     *
     */
    抄本選択チェック(UrErrorMessages.対象行を選択),
    /**
     * 出力対象選択チェック。
     *
     */
    出力対象選択チェック(UrErrorMessages.選択されていない, "作成帳票");

    private final Message message;

    RePrintKokuminValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    RePrintKokuminValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
