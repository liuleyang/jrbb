/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM2010;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2010.TohyokuMaintenanceDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 投票区保守ValidationHandler
 *
 * @reamsid_L AF-0700-010 liuyj
 */
public class TohyokuMaintenanceValidationHandler {

    private final TohyokuMaintenanceDiv div;

    /**
     * コンストラクタです。
     *
     * @param div TohyokuMaintenanceDiv
     */
    public TohyokuMaintenanceValidationHandler(TohyokuMaintenanceDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ生成
     *
     * @param div 投票区保守のDiv
     * @return 投票区保守のハンドラ
     */
    public static TohyokuMaintenanceValidationHandler of(TohyokuMaintenanceDiv div) {
        return new TohyokuMaintenanceValidationHandler(div);
    }

    /**
     * validateチェックです
     *
     * @return チェック結果
     */
    public ValidationMessageControlPairs validateコード重複チェック() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new TohyokuMaintenanceValidator(div).validate();
        validateResult.add(createErrorDictionary().check(messages));
        return validateResult;
    }

    /**
     * 投票区保守の入力項目をvalidate
     *
     * @return validateResult
     */
    private ValidationDictionary createErrorDictionary() {
        return new ValidationDictionaryBuilder().
                add(TohyokuMaintenanceValidationMessage.コード重複チェック, div.getTohyokuInput().getTxtCode())
                .build();
    }
}
