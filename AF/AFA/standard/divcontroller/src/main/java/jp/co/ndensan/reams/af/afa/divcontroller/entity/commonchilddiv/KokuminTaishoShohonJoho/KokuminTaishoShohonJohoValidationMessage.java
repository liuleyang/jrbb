/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminTaishoShohonJoho;

import jp.co.ndensan.reams.af.afa.definition.message.AfErrorMessages;
import jp.co.ndensan.reams.af.afa.definition.message.AfWarningMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 国民投票抄本情報共有子DIVのチェックメッセージクラスです。
 *
 * @reamsid_L AF-0360-010 fulc
 */
public enum KokuminTaishoShohonJohoValidationMessage implements IValidationMessage {

    /**
     * 基準日が空白
     */
    基準日が空白(AfErrorMessages.未入力エラー, "基準日"),
    /**
     * 投票日が空白
     */
    投票日が空白(AfErrorMessages.未入力エラー, "投票日"),
    /**
     * 抄本の入場券発行済チェック
     */
    対象の抄本の入場券が発行済の場合(AfErrorMessages.入場券発行済, "再処理"),
    /**
     * 基準日と投票日の関係性チェック
     */
    基準日と投票日の大小関係が不正(UrErrorMessages.大小関係が不正, "基準日"),
    /**
     * 基準日と受付開始日の関係性チェック
     */
    基準日と受付開始日の大小関係が不正(UrErrorMessages.大小関係が不正, "受付開始日"),
    /**
     * 受付開始日と投票日の関係性チェック
     */
    受付開始日と投票日の大小関係が不正(UrErrorMessages.大小関係が不正, "受付開始日"),
    /**
     * 基準日と特定期限日間の妥当性チェック
     */
    基準日と特定期限日間の大小関係が不正(AfErrorMessages.基準日確認, "特定期限日"),
    /**
     * 同一投票日存在性チェック
     */
    同一投票日で既に抄本が存在しています(AfWarningMessages.同一投票日抄本確認);
    private final Message message;

    KokuminTaishoShohonJohoValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    KokuminTaishoShohonJohoValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
