/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyoJokyoNyuryoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * TohyoJokyoNyuryokuDivのチェックメッセージクラスです。
 *
 * @reamsid_L AF-0070-014 liss
 */
public enum TohyoJokyoNyuryokuValidationMessage implements IValidationMessage {

    /**
     * グリッド選択必須。
     */
    グリッド選択必須(UrErrorMessages.選択されていない, "対象選挙"),
    /**
     * 投票事由コード存在。
     */
    投票事由コード存在(UrErrorMessages.存在しない, "投票事由コード"),
    /**
     * 投票日時制約。
     */
    投票日時制約(UrErrorMessages.項目に対する制約, "投票受付日", "受付開始日以降で、投票日以前"),
    /**
     * 拒否事由必須。
     */
    拒否事由必須(UrErrorMessages.必須, "拒否事由");

    private final Message message;

    TohyoJokyoNyuryokuValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    TohyoJokyoNyuryokuValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
