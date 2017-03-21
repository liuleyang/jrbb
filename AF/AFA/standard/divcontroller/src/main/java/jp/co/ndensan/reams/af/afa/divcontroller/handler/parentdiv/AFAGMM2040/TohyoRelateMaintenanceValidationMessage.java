/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM2040;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 投票区投票所対応保守
 *
 * @reamsid_L AF-0740-010 lis2
 */
public enum TohyoRelateMaintenanceValidationMessage implements IValidationMessage {

    /**
     * 投票所必須チェック。
     */
    投票所必須チェック(UrErrorMessages.選択されていない, "投票所"),
    /**
     * 他ユーザ使用チェック。
     */
    他ユーザ使用チェック(UrErrorMessages.排他_他ユーザが更新済み);

    private final Message message;

    private TohyoRelateMaintenanceValidationMessage(IMessageGettable message, String... replace) {
        this.message = message.getMessage().replace(replace);
    }

    /**
     * 投票区に対し、投票所が空白（未選択）だった場合のバリデーションメッセージを取得します。
     *
     * @return メッセージ
     */
    @Override
    public Message getMessage() {
        return message;
    }
}
