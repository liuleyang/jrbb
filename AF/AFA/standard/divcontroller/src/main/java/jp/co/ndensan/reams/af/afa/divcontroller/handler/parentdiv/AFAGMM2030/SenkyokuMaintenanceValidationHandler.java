/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM2030;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2030.SenkyokuMaintenanceDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 郵便等投票資格登録のバリデーションハンドラです。
 *
 * @reamsid_L AF-0720-010 liuyj
 */
public class SenkyokuMaintenanceValidationHandler {

    private final SenkyokuMaintenanceDiv div;

    /**
     * コンストラクタです。
     *
     * @param div YubinShikakuTorokuDiv
     */
    public SenkyokuMaintenanceValidationHandler(SenkyokuMaintenanceDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ生成
     *
     * @param div 選挙区のDiv
     * @return 選挙区のハンドラ
     */
    public static SenkyokuMaintenanceValidationHandler of(SenkyokuMaintenanceDiv div) {
        return new SenkyokuMaintenanceValidationHandler(div);
    }

    /**
     * validateチェックです
     *
     * @return チェック結果
     */
    public ValidationMessageControlPairs validateコード重複チェック() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new _SenkyokuMaintenanceErrorValidator(div).validate();
        validateResult.add(createErrorDictionary().check(messages));
        return validateResult;
    }

    /**
     * 他ユーザ使用のチェック
     *
     * @return バリデーションメッセージコントロールペア
     */
    public ValidationMessageControlPairs validate他ユーザ使用チェック() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        _SenkyokuMaintenanceErrorValidator validator = new _SenkyokuMaintenanceErrorValidator(div);
        validateResult.add(createWarningDictionary().check(validator.validate()));
        return validateResult;
    }

    private ValidationDictionary createWarningDictionary() {
        return new ValidationDictionaryBuilder().
                add(SenkyokuMaintenanceValidationMessage.他ユーザ使用チェック, div.getSenkyokuInput()).
                build();
    }

    /**
     * 選挙区の入力項目をvalidate
     *
     * @return validateResult
     */
    private ValidationDictionary createErrorDictionary() {
        return new ValidationDictionaryBuilder().
                add(SenkyokuMaintenanceValidationMessage.コード重複チェック, div.getSenkyokuInput().getTxtCode())
                .build();
    }
}
