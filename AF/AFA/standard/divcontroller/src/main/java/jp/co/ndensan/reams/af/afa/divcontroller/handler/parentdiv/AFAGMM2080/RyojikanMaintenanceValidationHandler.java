/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM2080;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2080.RyojikanMaintenanceDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 領事官
 *
 * @reamsid_L AF-0770-010 lis2
 */
public class RyojikanMaintenanceValidationHandler {

    private final RyojikanMaintenanceDiv div;

    /**
     * コンストラクタです。
     *
     * @param div RyojikanMaintenanceDiv
     */
    public RyojikanMaintenanceValidationHandler(RyojikanMaintenanceDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ生成
     *
     * @param div 領事官のDiv
     * @return 領事官のハンドラ
     */
    public static RyojikanMaintenanceValidationHandler of(RyojikanMaintenanceDiv div) {
        return new RyojikanMaintenanceValidationHandler(div);
    }

    /**
     * validateチェックです
     *
     * @return チェック結果
     */
    public ValidationMessageControlPairs validateコード重複チェック() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new RyojikanMaintenanceValidator(div).validate();
        validateResult.add(createErrorDictionary_コード重複チェック().check(messages));
        return validateResult;
    }

    /**
     * 領事官の入力項目をvalidate
     *
     * @return validateResult
     */
    private ValidationDictionary createErrorDictionary_コード重複チェック() {
        return new ValidationDictionaryBuilder().
                add(RyojikanMaintenanceValidationMessage.コード重複チェック, div.getRyojikanInput().getTxtCode())
                .build();
    }
}
