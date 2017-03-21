/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB1040;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 選挙時登録再発行のバリデーションメッセージです。
 *
 * @reamsid_L AF-0060-010 liss
 */
public enum RePrintSenkyojiValidationMessage implements IValidationMessage {

    /**
     * 転入期間必須。
     */
    転入期間必須(UrErrorMessages.必須, "転入期間"),
    /**
     * 帰化期間必須。
     */
    帰化期間必須(UrErrorMessages.必須, "帰化期間"),
    /**
     * 転出期間必須。
     */
    転出期間必須(UrErrorMessages.必須, "転出期間"),
    /**
     * 必須項目を選択です。
     *
     */
    必須項目を選択(UrErrorMessages.必須項目_追加メッセージあり, "選挙時抄本選択の選択ボタン"),
    /**
     * 必須項目を選択です。
     *
     */
    作成帳票を選択(UrErrorMessages.選択されていない, "作成帳票");

    private final Message message;

    private RePrintSenkyojiValidationMessage(IMessageGettable message, String... replace) {
        this.message = message.getMessage().replace(replace);
    }

    /**
     * 選挙時登録再発行のバリデーションメッセージを取得します。
     *
     * @return メッセージ
     */
    @Override
    public Message getMessage() {
        return message;
    }

}
