/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMH1030;

import jp.co.ndensan.reams.af.afa.definition.message.AfErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 署名簿登録のチェック操作を担当するクラスです。
 *
 * @reamsid_L AF-0150-010 wangh
 */
public enum SeikyuShomeiboTorokuValidationMessage implements IValidationMessage {

    /**
     * 署名状況に無効を選択した無効事由未入力エラー。
     *
     */
    署名状況に無効を選択した無効事由未入力エラー(AfErrorMessages.未入力エラー, "無効事由");

    private final Message message;

    SeikyuShomeiboTorokuValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    SeikyuShomeiboTorokuValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
