/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM3020;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 *
 * 同一人物調査のバリデーションメッセージです。
 *
 * @reamsid_L AF-0690-010 wanghj
 */
public enum DoitsuninCsvOutputValidationMessage implements IValidationMessage {

    /**
     * 判断条件未選択。
     */
    判断条件未選択(UrErrorMessages.選択されていない, "判断条件");

    private final Message message;

    private DoitsuninCsvOutputValidationMessage(IMessageGettable message, String... replace) {
        this.message = message.getMessage().replace(replace);
    }

    /**
     * 郵便等投票資格登録のバリデーションメッセージを取得します。
     *
     * @return メッセージ
     */
    @Override
    public Message getMessage() {
        return message;
    }

}
