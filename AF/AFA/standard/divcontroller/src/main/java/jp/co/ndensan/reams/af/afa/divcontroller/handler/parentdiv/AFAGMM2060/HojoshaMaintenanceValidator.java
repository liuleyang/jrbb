/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM2060;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2060.HojoshaMaintenanceDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * AFAGMM2060 投票補助者保守
 *
 * @reamsid_L AF-0750-010 lis2
 */
public class HojoshaMaintenanceValidator implements IValidatable {

    private final HojoshaMaintenanceDiv div;

    /**
     * コンストラクタ
     *
     * @param div 投票補助者保守のDiv
     */
    public HojoshaMaintenanceValidator(HojoshaMaintenanceDiv div) {
        this.div = div;
    }

    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(HojoshaMaintenanceSpec.コード重複のチェック)
                .thenAdd(HojoshaMaintenanceValidatorMessage.コード重複のチェック)
                .ifNot(HojoshaMaintenanceSpec.他ユーザ使用のチェック)
                .thenAdd(HojoshaMaintenanceValidatorMessage.他ユーザ使用のチェック)
                .ifNot(HojoshaMaintenanceSpec.コード存在性のチェック)
                .thenAdd(HojoshaMaintenanceValidatorMessage.コード存在性のチェック)
                .messages()
        );
        return messages;
    }

}
