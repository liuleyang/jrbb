/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME6020;

import jp.co.ndensan.reams.af.afa.definition.message.AfErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * AFAGME6020 転出者宛名シール
 *
 * @reamsid_L AF-0620-011 lis2
 */
public enum SealTenshutsushaErrorMessage implements IMessageGettable, IValidationMessage {

    /**
     * 対象期間対象終了年月日入力チェック
     */
    対象期間対象開始年月日が入力がない(AfErrorMessages.未入力エラー, "対象開始年月日"),
    /**
     * 対象期間対象終了年月日入力チェック
     */
    対象期間対象終了年月日が入力がない(AfErrorMessages.未入力エラー, "対象終了年月日"),
    /**
     * 対象期間関連チェック
     */
    対象期間が不正(AfErrorMessages.交付日確認, "対象終了年月日", "対象開始年月日", ""),
    /**
     * 開始印字位置選択チェック
     */
    開始印字位置が選択されていません(UrErrorMessages.必須項目_追加メッセージあり, "開始印字位置");

    private final Message message;

    @Override
    public Message getMessage() {
        return message;
    }

    private SealTenshutsushaErrorMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }
}
