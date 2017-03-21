/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.senkyojohoshusei;

import jp.co.ndensan.reams.af.afa.definition.message.AfErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 選挙修正のバリデーションメッセージです。
 *
 */
public enum SenkyoJohoShuseiValidationMessage implements IValidationMessage {

    /**
     * 選挙レベル基準日確認です。
     *
     */
    選挙レベル基準日確認(AfErrorMessages.選挙レベル基準日確認),
    /**
     * 選挙追加の基準日は投票より前の日を設定します。
     *
     */
    選挙追加の基準日は投票日より前の日を設定(AfErrorMessages.基準日確認, "投票日"),
    /**
     * 選挙追加の基準日は投票より前の日を設定します。
     *
     */
    選挙追加の基準日は受付開始日より前の日を設定(AfErrorMessages.基準日確認, "受付開始日"),
    /**
     * 選挙追加の投票日は受付開始日より前の日を設定します。
     *
     */
    選挙追加の投票日は受付開始日より後の日を設定(AfErrorMessages.交付日確認, "投票日", "受付開始日", ""),
    /**
     * 抄本名必須チェックです。
     *
     */
    抄本名入力確認(UrErrorMessages.必須, "抄本名"),
    /**
     * 選挙レベル必須チェックです。
     *
     */
    選挙レベル入力確認(UrErrorMessages.必須, "選挙レベル"),
    /**
     * 選挙名必須チェックです。
     *
     */
    選挙名入力確認(UrErrorMessages.必須, "選挙名"),
    /**
     * 選挙略称必須チェックです。
     *
     */
    選挙略称入力確認(UrErrorMessages.必須, "略称"),
    /**
     * 選挙マーク必須チェックです。
     *
     */
    選挙マーク入力確認(UrErrorMessages.必須, "マーク"),
    /**
     * 基準日必須チェックです。
     *
     */
    基準日入力確認(UrErrorMessages.必須, "基準日"),
    /**
     * 受付開始日必須チェックです。
     *
     */
    受付開始日入力確認(UrErrorMessages.必須, "受付開始日"),
    /**
     * 最大登録選挙数チェックです。
     *
     */
    最大登録選挙数確認(UrErrorMessages.項目に対する制約, "選挙", "9件以内");

    private final Message message;

    private SenkyoJohoShuseiValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    private SenkyoJohoShuseiValidationMessage(IMessageGettable message, String... replace) {
        this.message = message.getMessage().replace(replace);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
