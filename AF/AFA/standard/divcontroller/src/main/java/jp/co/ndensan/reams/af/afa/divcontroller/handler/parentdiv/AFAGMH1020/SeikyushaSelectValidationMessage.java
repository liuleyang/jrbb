/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMH1020;

import jp.co.ndensan.reams.af.afa.definition.message.AfWarningMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 請求代表者選択のチェックメッセージクラスです。
 *
 * @reamsid_L AF-0140-020 wangh
 */
public enum SeikyushaSelectValidationMessage implements IValidationMessage {

    /**
     * 提出期限日 ＜ システム日付のチェック。
     */
    提出期限日チェック(AfWarningMessages.処理の続行確認, "提出期限日を過ぎています");

    private final Message message;

    SeikyushaSelectValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    SeikyushaSelectValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
