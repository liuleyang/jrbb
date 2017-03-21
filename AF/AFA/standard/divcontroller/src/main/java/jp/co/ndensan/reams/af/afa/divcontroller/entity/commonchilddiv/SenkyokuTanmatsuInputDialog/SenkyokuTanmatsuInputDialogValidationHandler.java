/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SenkyokuTanmatsuInputDialog;

import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * SenkyokuTanmatsuInputDialogDiv のチェックロジックです。
 *
 * @reamsid_L AF-0720-020 liuyj
 */
public class SenkyokuTanmatsuInputDialogValidationHandler {

    private final SenkyokuTanmatsuInputDialogDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ShikakuJohoDiv
     */
    public SenkyokuTanmatsuInputDialogValidationHandler(SenkyokuTanmatsuInputDialogDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ生成
     *
     * @param div 選挙区端末のDiv
     * @return 選挙区端末のハンドラ
     */
    public static SenkyokuTanmatsuInputDialogValidationHandler of(SenkyokuTanmatsuInputDialogDiv div) {
        return new SenkyokuTanmatsuInputDialogValidationHandler(div);
    }

    /**
     * バリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate二重登録チェック() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        SenkyokuTanmatsuInputDialogErrorValidator validator = new SenkyokuTanmatsuInputDialogErrorValidator(div);
        validateResult.add(createErrorDictionary1().check(validator.validate二重登録チェック()));
        return validateResult;
    }

    /**
     * 更新ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate他ユーザ使用チェック() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        SenkyokuTanmatsuInputDialogErrorValidator validator = new SenkyokuTanmatsuInputDialogErrorValidator(div);
        validateResult.add(createErrorDictionary2().check(validator.validate他ユーザ使用チェック()));
        return validateResult;
    }

    /**
     * 更新ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate空白行の確認() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        SenkyokuTanmatsuInputDialogErrorValidator validator = new SenkyokuTanmatsuInputDialogErrorValidator(div);
        validateResult.add(createErrorDictionary3().check(validator.validate空白行の確認チェック()));
        return validateResult;
    }

    private ValidationDictionary createErrorDictionary1() {
        return new ValidationDictionaryBuilder().
                add(SenkyokuTanmatsuInputDialogValidationMessage.二重登録チェック, div.getDgSenkyokuTanmatsuInput()).build();
    }

    private ValidationDictionary createErrorDictionary2() {
        return new ValidationDictionaryBuilder().
                add(SenkyokuTanmatsuInputDialogValidationMessage.他ユーザ使用チェック, div.getDgSenkyokuTanmatsuInput()).build();
    }

    private ValidationDictionary createErrorDictionary3() {
        return new ValidationDictionaryBuilder().
                add(SenkyokuTanmatsuInputDialogValidationMessage.空白行の確認チェック, div.getDgSenkyokuTanmatsuInput()).build();
    }

}
