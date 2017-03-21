/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMG1010;

import jp.co.ndensan.reams.af.afa.definition.message.AfErrorMessages;
import jp.co.ndensan.reams.af.afa.definition.message.AfWarningMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 国民投票時登録のチェックメッセージクラスです。
 *
 * @reamsid_L AF-0360-010 fulc
 */
public enum KokuminTohyojiTorokuValidationMessage implements IValidationMessage {

    /**
     * 改正案一覧の必須入力チェック
     */
    新規の時改正案一覧グリッドに1件も明細に入力がない場合(AfErrorMessages.未入力エラー, "改正案"),
    /**
     * 改正案一覧の改正案と略称の両方必須入力チェック
     */
    改正案一覧グリッドに改正案と略称は片方のみの入力場合(UrErrorMessages.必須, "改正案、略称"),
    /**
     * 実データ※の必須入力チェック
     */
    改正案と略称の両方が空白かつ実データ(UrErrorMessages.必須, "改正案、略称"),
    /**
     * バッチ実行のチェック
     */
    選挙バッチ実行確認のチェック(AfWarningMessages.選挙バッチ実行確認_排他あり);

    private final Message message;

    KokuminTohyojiTorokuValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    KokuminTohyojiTorokuValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
