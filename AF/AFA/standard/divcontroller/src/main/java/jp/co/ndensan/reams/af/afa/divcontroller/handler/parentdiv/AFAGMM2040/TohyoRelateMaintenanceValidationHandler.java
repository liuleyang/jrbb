/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM2040;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2040.TohyoRelateMaintenanceDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 投票区投票所対応保守
 *
 * @reamsid_L AF-0740-010 lis2
 */
public class TohyoRelateMaintenanceValidationHandler {

    private final TohyoRelateMaintenanceDiv div;

    /**
     * コンストラクタです。
     *
     * @param div TohyoRelateMaintenanceDiv
     */
    public TohyoRelateMaintenanceValidationHandler(TohyoRelateMaintenanceDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ生成
     *
     * @param div 選挙区のDiv
     * @return 選挙区のハンドラ
     */
    public static TohyoRelateMaintenanceValidationHandler of(TohyoRelateMaintenanceDiv div) {
        return new TohyoRelateMaintenanceValidationHandler(div);
    }

    /**
     * validateチェックです
     *
     * @return チェック結果
     */
    public ValidationMessageControlPairs validate投票所必須チェック() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new TohyoRelateMaintenanceErrorValidator(div).validate();
        validateResult.add(createErrorDictionary_投票所必須チェック().check(messages));
        return validateResult;
    }

    /**
     * 他ユーザ使用のチェック
     *
     * @return バリデーションメッセージコントロールペア
     */
    public ValidationMessageControlPairs validate他ユーザ使用チェック() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        TohyoRelateMaintenanceErrorValidator validator = new TohyoRelateMaintenanceErrorValidator(div);
        validateResult.add(createErrorDictionary_他ユーザ使用チェック().check(validator.validate()));
        return validateResult;
    }

    private ValidationDictionary createErrorDictionary_他ユーザ使用チェック() {
        return new ValidationDictionaryBuilder().
                add(TohyoRelateMaintenanceValidationMessage.他ユーザ使用チェック, div.getTohyoRelateSelect()).
                build();
    }

    /**
     * 選挙区の入力項目をvalidate
     *
     * @return validateResult
     */
    private ValidationDictionary createErrorDictionary_投票所必須チェック() {
        return new ValidationDictionaryBuilder().
                add(TohyoRelateMaintenanceValidationMessage.投票所必須チェック, div.getTohyoRelateSelect())
                .build();
    }
}
