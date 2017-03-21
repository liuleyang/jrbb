/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM2010;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2010.TohyokuMaintenanceDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 投票区保守Validator
 *
 * @reamsid_L AF-0700-010 liuyj
 */
public class TohyokuMaintenanceValidator implements IValidatable {

    private final TohyokuMaintenanceDiv div;

    /**
     * コンストラクタ
     *
     * @param div 投票区のDiv
     */
    public TohyokuMaintenanceValidator(TohyokuMaintenanceDiv div) {
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
                ifNot(TohyokuMaintenanceSpec.コード重複チェック).
                thenAdd(TohyokuMaintenanceValidationMessage.コード重複チェック).
                messages()
        );
        return messages;
    }
}
