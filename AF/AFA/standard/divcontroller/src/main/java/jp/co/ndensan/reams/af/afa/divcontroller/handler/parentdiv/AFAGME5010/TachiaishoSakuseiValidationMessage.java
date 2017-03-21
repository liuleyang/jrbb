/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME5010;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * AFAGME5010 立会人引継書の入力チェックのメッセージクラスです。
 *
 * @reamsid_L AF-0120-010 xul
 */
public enum TachiaishoSakuseiValidationMessage implements IValidationMessage {

    /**
     * 抄本データドロップダウン未入力。
     */
    抄本データドロップダウン未入力(UrErrorMessages.必須, "抄本"),
    /**
     * 期日前投票日未入力。
     */
    期日前投票日未入力(UrErrorMessages.必須, "期日前投票日"),
    /**
     * 選挙名未入力。
     */
    選挙名未入力(UrErrorMessages.必須, "選挙名"),
    /**
     * 期日前投票所未入力。
     */
    期日前投票所未入力(UrErrorMessages.必須, "期日前投票所"),
    /**
     * 立会人氏名。
     */
    立会人氏名(UrErrorMessages.必須, "立会人氏名"),
    /**
     * 立会時間。
     */
    立会時間(UrErrorMessages.必須, "立会時間");

    private final Message message;

    TachiaishoSakuseiValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    TachiaishoSakuseiValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
