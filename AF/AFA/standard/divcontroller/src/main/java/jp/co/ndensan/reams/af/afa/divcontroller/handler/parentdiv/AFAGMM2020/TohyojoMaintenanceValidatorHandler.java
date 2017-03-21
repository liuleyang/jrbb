/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM2020;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2020.TohyojoMaintenanceDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 投票所保守ValidatorHandler
 *
 * @reamsid_L AF-0710-010 liuyj
 */
public class TohyojoMaintenanceValidatorHandler {

    private final TohyojoMaintenanceDiv div;

    /**
     * コンストラクタです。
     *
     * @param div BarCodeJuriDiv
     */
    public TohyojoMaintenanceValidatorHandler(TohyojoMaintenanceDiv div) {
        this.div = div;
    }

    /**
     * validateチェックです
     *
     * @return チェック結果
     */
    public ValidationMessageControlPairs validateコード重複() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new TohyojoMaintenanceValidator(div).validate();
        validateResult.add(createErrorDictionary_コード重複().check(messages));
        return validateResult;
    }

    private ValidationDictionary createErrorDictionary_コード重複() {
        return new ValidationDictionaryBuilder().
                add(TohyojoMaintenanceValidatorMessage.コード重複, div.getTohyojoInput().getTxtCode())
                .build();
    }

}
