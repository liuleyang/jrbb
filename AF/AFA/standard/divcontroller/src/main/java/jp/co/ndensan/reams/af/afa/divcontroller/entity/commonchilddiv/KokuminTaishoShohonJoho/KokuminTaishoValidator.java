/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminTaishoShohonJoho;

import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 国民投票抄本情報共有子DIVのチェックを実行する。
 *
 * @reamsid_L AF-0360-011 lis
 */
public class KokuminTaishoValidator {

    private final KokuminTaishoShohonJohoDiv div;

    /**
     * 出力対象のバリデーションです。
     *
     * @param div NippoSakuseiDiv
     */
    public KokuminTaishoValidator(KokuminTaishoShohonJohoDiv div) {
        this.div = div;
    }

    /**
     * 基準日と投票日の関係性チェックのバリデーションです。
     *
     * @return バリデーションメッセージ
     */
    public IValidationMessages validate基準日と投票日の関係性チェック() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(KokuminTaishoSpec.基準日と投票日の関係性チェック)
                .thenAdd(KokuminTaishoValidationMessage.基準日と投票日の関係性チェック)
                .messages());

        return messages;
    }

    /**
     * 基準日と受付開始日の関係性チェックのバリデーションです。
     *
     * @return バリデーションメッセージ
     */
    public IValidationMessages validate基準日と受付開始日の関係性チェック() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(KokuminTaishoSpec.基準日と受付開始日の関係性チェック)
                .thenAdd(KokuminTaishoValidationMessage.基準日と受付開始日の関係性チェック)
                .messages());

        return messages;
    }

    /**
     * 受付開始日と投票日の関係性チェックのバリデーションです。
     *
     * @return バリデーションメッセージ
     */
    public IValidationMessages validate受付開始日と投票日の関係性チェック() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(KokuminTaishoSpec.受付開始日と投票日の関係性チェック)
                .thenAdd(KokuminTaishoValidationMessage.受付開始日と投票日の関係性チェック)
                .messages());

        return messages;
    }

    /**
     * 受付開始日と投票日の関係性チェックのバリデーションです。
     *
     * @return バリデーションメッセージ
     */
    public IValidationMessages validate基準日と特定期限日間の妥当性チェック() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(KokuminTaishoSpec.基準日と特定期限日間の妥当性チェック)
                .thenAdd(KokuminTaishoValidationMessage.基準日と特定期限日間の妥当性チェック)
                .messages());

        return messages;
    }

}
