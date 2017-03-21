/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME8010;

import jp.co.ndensan.reams.af.afa.definition.message.AfWarningMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 持出端末用データ作成のバリデーションメッセージです。
 *
 * @reamsid_L AF-0790-010 wanghj
 */
public enum TakeOutPcDataCreateValidationMessage implements IValidationMessage {

    /**
     * 受渡データ再作成。
     */
    処理の続行確認(AfWarningMessages.処理の続行確認, "受渡データが既に作成されています。"),
    /**
     * 投票日整合性。
     */
    投票日前日確認(AfWarningMessages.投票日前日確認);

    private final Message message;

    private TakeOutPcDataCreateValidationMessage(IMessageGettable message, String... replace) {
        this.message = message.getMessage().replace(replace);
    }

    /**
     * 持出端末用データ作成のバリデーションメッセージを取得します。
     *
     * @return メッセージ
     */
    @Override
    public Message getMessage() {
        return message;
    }

}
