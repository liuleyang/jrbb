/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMH1010;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 請求代表者証明書交付のチェックメッセージクラスです。
 *
 * @reamsid_L AF-0140-010 wangh
 */
public enum SeikyushaTorokuValidationMessage implements IValidationMessage {

    /**
     * 請求日と交付日の大小チェック。
     */
    請求日交付日大小チェック(UrErrorMessages.大小関係が不正, "交付日は請求日以降を入力してください"),
    /**
     * 交付日と提出期限日の大小チェック。
     */
    交付日提出期限日大小チェック(UrErrorMessages.大小関係が不正, "提出期限日は交付日以降を入力してください"),
    /**
     * 請求代表者一覧が0件だった場合、エラーとする。
     */
    請求代表者選択チェック(UrErrorMessages.選択されていない, "請求代表者");

    private final Message message;

    SeikyushaTorokuValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    SeikyushaTorokuValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
