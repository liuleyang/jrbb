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
public class KokuminTaishoShohonJohoWarningValidator implements IValidatable {

    private final KokuminTaishoShohonJohoDiv div;

    KokuminTaishoShohonJohoWarningValidator(KokuminTaishoShohonJohoDiv div) {
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
                ifNot(KokuminTaishoShohonJohoSpec.同一投票日で既に抄本が存在しています).
                thenAdd(KokuminTaishoShohonJohoValidationMessage.同一投票日で既に抄本が存在しています).
                messages()
        );
        return messages;
    }
}
