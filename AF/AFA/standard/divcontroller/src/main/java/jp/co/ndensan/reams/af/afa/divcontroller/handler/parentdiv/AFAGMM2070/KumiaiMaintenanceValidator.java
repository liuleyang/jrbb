/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM2070;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2070.KumiaiMaintenanceDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * AFAGMM2070_組合保守
 *
 * @reamsid_L AF-0760-010 lis2
 */
public class KumiaiMaintenanceValidator implements IValidatable {

    private final KumiaiMaintenanceDiv div;

    /**
     * コンストラクタ
     *
     * @param div 組合マインテなんせのDiv
     */
    public KumiaiMaintenanceValidator(KumiaiMaintenanceDiv div) {
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
                ifNot(KumiaiMaintenanceSpec.コード重複チェック).
                thenAdd(KumiaiMaintenanceValidationMessage.コード重複チェック).
                messages()
        );
        return messages;
    }
}
