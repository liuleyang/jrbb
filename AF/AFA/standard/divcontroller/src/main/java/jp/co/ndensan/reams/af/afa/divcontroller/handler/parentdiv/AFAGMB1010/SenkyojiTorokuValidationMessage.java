/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB1010;

import jp.co.ndensan.reams.af.afa.definition.message.AfErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 選挙時登録の入力チェックのメッセージクラスです。
 *
 * @reamsid_L AF-0030-010 liss
 */
public enum SenkyojiTorokuValidationMessage implements IValidationMessage {

    /**
     * 抄本名必須。
     */
    抄本名必須(UrErrorMessages.必須, "抄本名"),
    /**
     * 投票日必須。
     */
    投票日必須(UrErrorMessages.必須, "投票日"),
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
     * 年齢期限必須。
     */
    年齢期限必須(UrErrorMessages.必須, "年齢期限日"),
    /**
     * レベル必須。
     */
    レベル必須(UrErrorMessages.必須, "選挙一覧.レベル"),
    /**
     * 選挙名必須。
     */
    選挙名必須(UrErrorMessages.必須, "選挙一覧.選挙名"),
    /**
     * 略名必須。
     */
    略名必須(UrErrorMessages.必須, "選挙一覧.略名"),
    /**
     * マーク必須。
     */
    マーク必須(UrErrorMessages.必須, "選挙一覧.マーク"),
    /**
     * 基準日必須。
     */
    基準日必須(UrErrorMessages.必須, "選挙一覧.基準日"),
    /**
     * 受付開始日必須。
     */
    受付開始日必須(UrErrorMessages.必須, "選挙一覧.受付開始日"),
    /**
     * 基準日確認1。
     */
    基準日確認1(AfErrorMessages.基準日確認, "投票日"),
    /**
     * 基準日確認2。
     */
    基準日確認2(AfErrorMessages.基準日確認, "受付開始日"),
    /**
     * 交付日確認。
     */
    交付日確認(AfErrorMessages.交付日確認, "投票日", "受付開始日", ""),
    /**
     * 再作成処理不可。
     */
    再作成処理不可(AfErrorMessages.入場券発行済, "再作成処理");

    private final Message message;

    SenkyojiTorokuValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    SenkyojiTorokuValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
