/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME2010;

import jp.co.ndensan.reams.af.afa.definition.message.AfErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * AFAGME2010 不在者投票の入力チェックのメッセージクラスです。
 *
 * @reamsid_L AF-0080-010 lit
 */
public enum FuzaishaTohyoValidationMessage implements IValidationMessage {

    /**
     * 施設存在しない。
     */
    施設存在しない(UrErrorMessages.存在しない, "施設コード"),
    /**
     * 入場券確認。
     */
    入場券確認(AfErrorMessages.入場券確認),
    /**
     * 選挙人未指定。
     */
    選挙人未指定(UrErrorMessages.未指定, "処理対象の選挙人を"),
    /**
     * 対象データなし_追加メッセージあり。
     */
    対象データなし_追加メッセージあり(UrErrorMessages.対象データなし_追加メッセージあり),
    /**
     * 対象選挙必須。
     */
    対象選挙必須(UrErrorMessages.選択されていない, "対象選挙"),
    /**
     * 交付日確認１。
     */
    交付日確認１(AfErrorMessages.交付日確認, "交付日", "請求日", ""),
    /**
     * 交付日確認２。
     */
    交付日確認２(AfErrorMessages.交付日確認, "受理日", "交付日", "");

    private final Message message;

    FuzaishaTohyoValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    FuzaishaTohyoValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
