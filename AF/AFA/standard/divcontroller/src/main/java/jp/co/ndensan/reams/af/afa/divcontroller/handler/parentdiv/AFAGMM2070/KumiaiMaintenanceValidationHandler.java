/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM2070;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2070.KumiaiMaintenanceDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * AFAGMM2070_組合保守
 *
 * @reamsid_L AF-0760-010 lis2
 */
public class KumiaiMaintenanceValidationHandler {

    private final KumiaiMaintenanceDiv div;

    /**
     * コンストラクタです。
     *
     * @param div KumiaiMaintenanceDiv
     */
    public KumiaiMaintenanceValidationHandler(KumiaiMaintenanceDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ生成
     *
     * @param div 組合マスタのDiv
     * @return 組合マスタのハンドラ
     */
    public static KumiaiMaintenanceValidationHandler of(KumiaiMaintenanceDiv div) {
        return new KumiaiMaintenanceValidationHandler(div);
    }

    /**
     * validateチェックです
     *
     * @return チェック結果
     */
    public ValidationMessageControlPairs validateコード重複チェック() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new KumiaiMaintenanceValidator(div).validate();
        validateResult.add(createErrorDictionary_コード重複チェック().check(messages));
        return validateResult;
    }

    /**
     * 組合マスタの入力項目をvalidate
     *
     * @return validateResult
     */
    private ValidationDictionary createErrorDictionary_コード重複チェック() {
        return new ValidationDictionaryBuilder().
                add(KumiaiMaintenanceValidationMessage.コード重複チェック, div.getKumiaiInput().getTxtCode())
                .build();
    }
}
