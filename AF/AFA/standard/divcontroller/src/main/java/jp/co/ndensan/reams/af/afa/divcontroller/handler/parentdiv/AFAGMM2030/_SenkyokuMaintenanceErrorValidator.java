/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM2030;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2030.SenkyokuMaintenanceDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 選挙区マインテなんせの実装クラス
 *
 * @reamsid_L AF-0720-010 liuyj
 */
public class _SenkyokuMaintenanceErrorValidator implements IValidatable {

    private final SenkyokuMaintenanceDiv div;

    /**
     * コンストラクタ
     *
     * @param div 選挙区マインテなんせのDiv
     */
    public _SenkyokuMaintenanceErrorValidator(SenkyokuMaintenanceDiv div) {
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
                ifNot(SenkyokuMaintenanceSpec.コード重複チェック).
                thenAdd(SenkyokuMaintenanceValidationMessage.コード重複チェック).
                ifNot(SenkyokuMaintenanceSpec.他ユーザ使用チェック).
                thenAdd(SenkyokuMaintenanceValidationMessage.他ユーザ使用チェック).
                messages()
        );
        return messages;
    }
}
