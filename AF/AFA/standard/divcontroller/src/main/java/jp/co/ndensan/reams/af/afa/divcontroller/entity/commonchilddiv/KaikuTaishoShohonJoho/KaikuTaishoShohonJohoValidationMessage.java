/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KaikuTaishoShohonJoho;

import jp.co.ndensan.reams.af.afa.definition.message.AfErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 海区対象抄本情報共有子Divのチェックメッセージクラスです。
 *
 * @reamsid_L AF-0470-020 jihb
 */
public enum KaikuTaishoShohonJohoValidationMessage implements IValidationMessage {

    /**
     * 基準日≧投票日のチェック。
     */
    基準日投票日大小チェック(AfErrorMessages.基準日確認, "投票日"),
    /**
     * 基準日≧受付開始日のチェック。
     */
    基準日受付開始日大小チェック(AfErrorMessages.基準日確認, "受付開始日"),
    /**
     * 受付開始日≧投票日のチェック。
     */
    受付開始日投票日大小チェック(UrErrorMessages.大小関係が不正, "受付開始日、投票日");

    private final Message message;

    KaikuTaishoShohonJohoValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    KaikuTaishoShohonJohoValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
