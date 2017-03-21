/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminTaishoShohonJoho;

import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 国民投票抄本情報共有子DIVのバリデーションです。
 *
 * @reamsid_L AF-0360-010 fulc
 */
public class KokuminTaishoShohonJohoErrorValidator implements IValidatable {

    private final KokuminTaishoShohonJohoDiv div;

    KokuminTaishoShohonJohoErrorValidator(KokuminTaishoShohonJohoDiv div) {
        this.div = div;
    }

    /**
     * バリデーション検証処理
     *
     * @return チェック結果
     */
    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(KokuminTaishoShohonJohoSpec.受付開始日と投票日の大小関係が不正).
                thenAdd(KokuminTaishoShohonJohoValidationMessage.受付開始日と投票日の大小関係が不正).
                ifNot(KokuminTaishoShohonJohoSpec.基準日と受付開始日の大小関係が不正).
                thenAdd(KokuminTaishoShohonJohoValidationMessage.基準日と受付開始日の大小関係が不正).
                ifNot(KokuminTaishoShohonJohoSpec.基準日と投票日の大小関係が不正).
                thenAdd(KokuminTaishoShohonJohoValidationMessage.基準日と投票日の大小関係が不正).
                ifNot(KokuminTaishoShohonJohoSpec.基準日と特定期限日間の大小関係が不正).
                thenAdd(KokuminTaishoShohonJohoValidationMessage.基準日と特定期限日間の大小関係が不正).
                ifNot(KokuminTaishoShohonJohoSpec.対象の抄本の入場券が発行済の場合).
                thenAdd(KokuminTaishoShohonJohoValidationMessage.対象の抄本の入場券が発行済の場合).
                messages()
        );
        return messages;
    }
}
