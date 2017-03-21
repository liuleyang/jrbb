/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMH1010;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMH1010.SeikyushaTorokuDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 請求代表者証明書交付のValidator
 *
 * @reamsid_L AF-0140-010 wangh
 */
public class SeikyushaTorokuValidator implements IValidatable {

    private final SeikyushaTorokuDiv div;

    SeikyushaTorokuValidator(SeikyushaTorokuDiv div) {
        this.div = div;
    }

    /**
     * 「直接請求を登録する」ボタンを押下の入力チェック
     *
     * @return チェック結果
     */
    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(SeikyushaTorokuSpec.請求日交付日大小チェック).
                thenAdd(SeikyushaTorokuValidationMessage.請求日交付日大小チェック).
                ifNot(SeikyushaTorokuSpec.交付日提出期限日大小チェック).
                thenAdd(SeikyushaTorokuValidationMessage.交付日提出期限日大小チェック).
                ifNot(SeikyushaTorokuSpec.請求代表者選択チェック).
                thenAdd(SeikyushaTorokuValidationMessage.請求代表者選択チェック).
                messages());
        return messages;
    }
}
