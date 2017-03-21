/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMG1020;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMG1020.KokuminTohyoJohoShuseiDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 国民投票情報修正のバリデーションです。
 *
 * @reamsid_L AF-0370-010 lis
 */
public class _KokuminTaishoShohonJohoValidator implements IValidatable {

    private final KokuminTohyoJohoShuseiDiv div;

    _KokuminTaishoShohonJohoValidator(KokuminTohyoJohoShuseiDiv div) {
        this.div = div;
    }

    /**
     * 選挙修正の保存のバリデーションです。
     *
     * @return バリデーションメッセージ
     */
    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(KokuminTaishoShohonJohoSpec.選挙追加の改正案必須チェック).
                thenAdd(KokuminTaishoShohonJohoValidationMessage.改正案入力確認).
                ifNot(KokuminTaishoShohonJohoSpec.選挙追加の選挙略称必須チェック).
                thenAdd(KokuminTaishoShohonJohoValidationMessage.略称入力確認).
                messages());
        return messages;
    }

}
