/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM2020;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2020.TohyojoMaintenanceDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 *
 * @reamsid_L AF-0710-010 liuyj
 */
public class TohyojoMaintenanceValidator implements IValidatable {

    private final TohyojoMaintenanceDiv div;

    /**
     * コンストラクタです。
     *
     * @param div BarCodeTojitsuDiv
     */
    public TohyojoMaintenanceValidator(TohyojoMaintenanceDiv div) {
        this.div = div;
    }

    /**
     * バリデーション検証処理
     *
     * @return チェック結果
     */
    public IValidationMessages validateコード重複() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(TohyojoMaintenanceSpec.コード重複チェック).
                thenAdd(TohyojoMaintenanceValidatorMessage.コード重複).
                messages()
        );
        return messages;
    }

    /**
     * バリデーション検証処理
     *
     * @return チェック結果
     */
    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(TohyojoMaintenanceSpec.コード重複チェック)
                .thenAdd(TohyojoMaintenanceValidatorMessage.コード重複)
                .messages());
        return messages;
    }
}
