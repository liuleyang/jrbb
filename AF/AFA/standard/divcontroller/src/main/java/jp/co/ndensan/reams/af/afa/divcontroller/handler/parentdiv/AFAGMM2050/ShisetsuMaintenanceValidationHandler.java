/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM2050;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2050.ShisetsuMaintenanceDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 不在者投票管理施設保守ValidationHandler
 *
 * @reamsid_L AF-0730-010 liuj
 */
public class ShisetsuMaintenanceValidationHandler {

    private final ShisetsuMaintenanceDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ShisetsuMaintenanceDiv
     */
    public ShisetsuMaintenanceValidationHandler(ShisetsuMaintenanceDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ生成
     *
     * @param div 不在者投票管理施設保守のDiv
     * @return 不在者投票管理施設保守のハンドラ
     */
    public static ShisetsuMaintenanceValidationHandler of(ShisetsuMaintenanceDiv div) {
        return new ShisetsuMaintenanceValidationHandler(div);
    }

    /**
     * validateチェックです
     *
     * @return チェック結果
     */
    public ValidationMessageControlPairs validateコード重複チェック() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new ShisetsuMaintenanceValidator(div).validate();
        validateResult.add(createErrorDictionary().check(messages));
        return validateResult;
    }

    /**
     * 不在者投票管理施設保守の入力項目をvalidate
     *
     * @return validateResult
     */
    private ValidationDictionary createErrorDictionary() {
        return new ValidationDictionaryBuilder().
                add(ShisetsuMaintenanceValidationMessage.コード重複チェック, div.getShisetsuInput().getTxtCode())
                .build();
    }
}
