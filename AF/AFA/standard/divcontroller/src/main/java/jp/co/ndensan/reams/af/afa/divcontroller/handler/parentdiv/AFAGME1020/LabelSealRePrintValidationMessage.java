/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME1020;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * ラベルシール再印刷のチェックメッセージクラスです。
 *
 * @reamsid_L AF-0620-014 jihb
 */
public enum LabelSealRePrintValidationMessage implements IValidationMessage {

    /**
     * 施設コードの入力チェック_未入力。
     */
    施設コードの入力チェック_未入力(UrErrorMessages.未指定, "施設コードを"),
    /**
     * 選挙人一覧データチェック_データなし。
     */
    選挙人一覧データチェック_データなし(UrErrorMessages.未指定, "再印刷対象者を"),
    /**
     * 選挙人一覧選択チェック_選択しなし。
     */
    選挙人一覧選択チェック_選択しなし(UrErrorMessages.選択されていない, "再印刷対象者"),
    /**
     * 開始印字位置選択チェック_選択しなし。
     */
    開始印字位置選択チェック_選択しなし(UrErrorMessages.未指定, "開始印字位置を");

    private final Message message;

    LabelSealRePrintValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    LabelSealRePrintValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
