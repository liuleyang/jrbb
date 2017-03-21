/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM2060;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2060.HojoshaMaintenanceDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * AFAGMM2060 投票補助者保守
 *
 * @reamsid_L AF-0750-010 lis2
 */
public class HojoshaMaintenanceValidatorHandler {

    private final HojoshaMaintenanceDiv div;

    /**
     * コンストラクタです。
     *
     * @param div HojoshaMaintenanceDiv
     */
    public HojoshaMaintenanceValidatorHandler(HojoshaMaintenanceDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ生成
     *
     * @param div 投票補助者保守のDiv
     * @return 投票補助者保守のハンドラ
     */
    public static HojoshaMaintenanceValidatorHandler of(HojoshaMaintenanceDiv div) {
        return new HojoshaMaintenanceValidatorHandler(div);
    }

    /**
     * validateチェックです
     *
     * @return チェック結果
     */
    public ValidationMessageControlPairs validateコード重複() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new HojoshaMaintenanceValidator(div).validate();
        validateResult.add(createErrorDictionary_コード重複().check(messages));
        return validateResult;
    }

    private ValidationDictionary createErrorDictionary_コード重複() {
        return new ValidationDictionaryBuilder().
                add(HojoshaMaintenanceValidatorMessage.コード重複のチェック, div.getHojoshaInput().getTxtShikibetsuCode())
                .build();
    }

    /**
     * validateチェックです
     *
     * @return チェック結果
     */
    public ValidationMessageControlPairs validateコード存在() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new HojoshaMaintenanceValidator(div).validate();
        validateResult.add(createErrorDictionary_コード存在().check(messages));
        return validateResult;
    }

    private ValidationDictionary createErrorDictionary_コード存在() {
        return new ValidationDictionaryBuilder().
                add(HojoshaMaintenanceValidatorMessage.コード存在性のチェック, div.getHojoshaInput().getTxtShikibetsuCode()).
                build();
    }

    /**
     * validateチェックです
     *
     * @return チェック結果
     */
    ValidationMessageControlPairs validate他ユーザ使用チェック() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new HojoshaMaintenanceValidator(div).validate();
        validateResult.add(createErrorDictionary_他ユーザ使用().check(messages));
        return validateResult;
    }

    private ValidationDictionary createErrorDictionary_他ユーザ使用() {
        return new ValidationDictionaryBuilder().
                add(HojoshaMaintenanceValidatorMessage.他ユーザ使用のチェック).
                build();
    }

}
