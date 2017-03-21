/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME2050;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 施設送付書発行のチェックロジックです。
 *
 * @reamsid_L AF-0250-010 jihb
 */
public enum SofushoSakuseiValidationMessage implements IValidationMessage {

    /**
     * 期日前投票日報　出力チェックボックスがONの場合、投票日開始～終了。
     */
    交付日開始と終了入力チェック_開始は未入力(UrErrorMessages.未入力, "交付日開始"),
    /**
     * 期日前投票日報　出力チェックボックスがONの場合、投票日開始～終了。
     */
    交付日開始と終了入力チェック_終了は未入力(UrErrorMessages.未入力, "交付日終了"),
    /**
     * 期日前投票日報　出力チェックボックスがONの場合、投票日開始と終了の関係性チェック。
     */
    交付日開始と終了大小関係が不正(UrErrorMessages.大小関係が不正, "交付日");

    private final Message message;

    SofushoSakuseiValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    SofushoSakuseiValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }

}
