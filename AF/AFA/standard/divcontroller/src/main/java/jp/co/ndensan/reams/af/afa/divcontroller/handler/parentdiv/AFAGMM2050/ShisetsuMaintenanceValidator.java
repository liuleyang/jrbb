/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM2050;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2050.ShisetsuMaintenanceDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 不在者投票管理施設保守Validator
 *
 * @reamsid_L AF-0730-010 liuj
 */
public class ShisetsuMaintenanceValidator implements IValidatable {

    private final ShisetsuMaintenanceDiv div;

    /**
     * コンストラクタ
     *
     * @param div 不在者投票管理施設保守のDiv
     */
    public ShisetsuMaintenanceValidator(ShisetsuMaintenanceDiv div) {
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
                ifNot(ShisetsuMaintenanceSpec.コード重複チェック).
                thenAdd(ShisetsuMaintenanceValidationMessage.コード重複チェック).
                messages()
        );
        return messages;
    }
}
