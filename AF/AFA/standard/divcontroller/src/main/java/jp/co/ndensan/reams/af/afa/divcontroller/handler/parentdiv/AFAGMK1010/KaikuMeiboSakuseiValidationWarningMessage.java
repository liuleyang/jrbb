/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMK1010;

import jp.co.ndensan.reams.af.afa.definition.message.AfWarningMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 選挙人当初登録のバリデーションハンドラです。
 *
 * @reamsid_L AF-0460-010 liuyj
 */
public enum KaikuMeiboSakuseiValidationWarningMessage implements IMessageGettable, IValidationMessage {

    /**
     * 名簿確定日自動算出日付の確認
     *
     */
    名簿確定日自動算出日付の確認(AfWarningMessages.自動算出日付の確認, "名簿確定日"),
    /**
     * 年齢到達日自動算出日付の確認
     *
     */
    年齢到達日自動算出日付の確認(AfWarningMessages.自動算出日付の確認, "年齢到達日");

    private final Message message;

    @Override
    public Message getMessage() {
        return message;
    }

    private KaikuMeiboSakuseiValidationWarningMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }
}
