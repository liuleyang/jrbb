/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM2040;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2040.TohyoRelateMaintenanceDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 投票区投票所対応保守
 *
 * @reamsid_L AF-0740-010 lis2
 */
public class TohyoRelateMaintenanceErrorValidator implements IValidatable {

    private final TohyoRelateMaintenanceDiv div;

    /**
     * コンストラクタ
     *
     * @param div 選挙区マインテなんせのDiv
     */
    public TohyoRelateMaintenanceErrorValidator(TohyoRelateMaintenanceDiv div) {
        this.div = div;
    }

    /**
     * バリデーション検証処理
     *
     * @return チェック結果
     */
    public IValidationMessages validate投票所必須チェック() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(TohyoRelateMaintenanceSpec.投票所必須チェック).
                thenAdd(TohyoRelateMaintenanceValidationMessage.投票所必須チェック).
                ifNot(TohyoRelateMaintenanceSpec.他ユーザ使用チェック).
                thenAdd(TohyoRelateMaintenanceValidationMessage.他ユーザ使用チェック).
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
        messages.add(ValidateChain.validateStart(div).
                ifNot(TohyoRelateMaintenanceSpec.投票所必須チェック).
                thenAdd(TohyoRelateMaintenanceValidationMessage.投票所必須チェック).
                ifNot(TohyoRelateMaintenanceSpec.他ユーザ使用チェック).
                thenAdd(TohyoRelateMaintenanceValidationMessage.他ユーザ使用チェック).
                messages()
        );
        return messages;
    }
}
