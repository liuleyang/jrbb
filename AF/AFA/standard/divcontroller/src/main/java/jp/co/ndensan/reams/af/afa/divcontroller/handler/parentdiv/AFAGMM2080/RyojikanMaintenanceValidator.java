/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM2080;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2080.RyojikanMaintenanceDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 領事官
 *
 * @reamsid_L AF-0770-010 lis2
 */
public class RyojikanMaintenanceValidator implements IValidatable {

    private final RyojikanMaintenanceDiv div;

    /**
     * コンストラクタ
     *
     * @param div 領事官マインテなんせのDiv
     */
    public RyojikanMaintenanceValidator(RyojikanMaintenanceDiv div) {
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
                ifNot(RyojikanMaintenanceSpec.コード重複チェック).
                thenAdd(RyojikanMaintenanceValidationMessage.コード重複チェック).
                messages()
        );
        return messages;
    }
}
