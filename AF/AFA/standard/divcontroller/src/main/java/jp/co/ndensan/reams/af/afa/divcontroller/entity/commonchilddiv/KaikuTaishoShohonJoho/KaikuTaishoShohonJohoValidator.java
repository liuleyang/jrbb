/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KaikuTaishoShohonJoho;

import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 海区対象抄本情報共有子DivのValidator
 *
 * @reamsid_L AF-0470-020 jihb
 */
public class KaikuTaishoShohonJohoValidator implements IValidatable {

    private final KaikuTaishoShohonJohoDiv div;

    KaikuTaishoShohonJohoValidator(KaikuTaishoShohonJohoDiv div) {
        this.div = div;
    }

    /**
     * 親画面で実行ボタンを押下の検証処理
     *
     * @return チェック結果
     */
    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(KaikuTaishoShohonJohoSpec.基準日投票日大小チェック).
                thenAdd(KaikuTaishoShohonJohoValidationMessage.基準日投票日大小チェック).
                ifNot(KaikuTaishoShohonJohoSpec.基準日受付開始日大小チェック).
                thenAdd(KaikuTaishoShohonJohoValidationMessage.基準日受付開始日大小チェック).
                ifNot(KaikuTaishoShohonJohoSpec.受付開始日投票日大小チェック).
                thenAdd(KaikuTaishoShohonJohoValidationMessage.受付開始日投票日大小チェック).
                messages());
        return messages;
    }
}
