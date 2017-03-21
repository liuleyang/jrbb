/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminTaishoShohonJoho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 国民投票抄本情報共有子DIVのチェックを実行する。
 *
 * @reamsid_L AF-0360-011 lis
 */
public enum KokuminTaishoValidationMessage implements IValidationMessage {

    /**
     * 基準日と投票日の関係性チェック。
     */
    基準日と投票日の関係性チェック(UrErrorMessages.大小関係が不正, "基準日"),
    /**
     * 基準日と受付開始日の関係性チェック。
     */
    基準日と受付開始日の関係性チェック(UrErrorMessages.大小関係が不正, "受付開始日"),
    /**
     * 受付開始日と投票日の関係性チェック。
     */
    受付開始日と投票日の関係性チェック(UrErrorMessages.大小関係が不正, "受付開始日"),
    /**
     * 基準日と特定期限日間の妥当性チェック。
     */
    基準日と特定期限日間の妥当性チェック(UrErrorMessages.大小関係が不正, "受付開始日");

    private final Message message;

    private KokuminTaishoValidationMessage(IMessageGettable message, String... replace) {
        this.message = message.getMessage().replace(replace);
    }

    /**
     * 郵便等投票資格登録のバリデーションメッセージを取得します。
     *
     * @return メッセージ
     */
    @Override
    public Message getMessage() {
        return message;
    }

}
