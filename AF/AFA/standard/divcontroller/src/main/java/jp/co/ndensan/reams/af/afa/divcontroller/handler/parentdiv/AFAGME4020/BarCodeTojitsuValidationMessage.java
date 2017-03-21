/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME4020;

import jp.co.ndensan.reams.af.afa.definition.message.AfErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * AFAGME4020 不在者投票の入力チェックのメッセージクラスです。
 *
 * @reamsid_L AF-0115-010 xul
 */
public enum BarCodeTojitsuValidationMessage implements IValidationMessage {

    /**
     * 入場券確認。
     */
    入場券確認(AfErrorMessages.入場券確認),
    /**
     * 投票資格チェック。
     */
    投票資格チェック(AfErrorMessages.投票受付不可, "投票資格なし"),
    /**
     * 対象データなし_追加メッセージあり。
     */
    対象データなし_追加メッセージあり(UrErrorMessages.対象データなし_追加メッセージあり, "選挙人名簿"),
    /**
     * 読込済み確認。
     */
    読込済み確認(AfErrorMessages.読込済み確認),
    /**
     * 対象選挙必須。
     */
    対象選挙必須(UrErrorMessages.選択されていない, "対象選挙");

    private final Message message;

    BarCodeTojitsuValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    BarCodeTojitsuValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
