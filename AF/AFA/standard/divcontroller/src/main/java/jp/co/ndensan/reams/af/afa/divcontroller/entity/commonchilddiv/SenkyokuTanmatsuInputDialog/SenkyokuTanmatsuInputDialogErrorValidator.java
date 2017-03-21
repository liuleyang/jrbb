/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SenkyokuTanmatsuInputDialog;

import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * SenkyokuTanmatsuInputDialogDiv のチェックロジックです。
 *
 * @reamsid_L AF-0720-020 liuyj
 */
public class SenkyokuTanmatsuInputDialogErrorValidator {

    private final SenkyokuTanmatsuInputDialogDiv div;

    /**
     * コンストラクタ
     *
     * @param div のDiv
     */
    public SenkyokuTanmatsuInputDialogErrorValidator(SenkyokuTanmatsuInputDialogDiv div) {
        this.div = div;
    }

    /**
     * 二重登録チェック検証処理
     *
     * @return チェック結果
     */
    public IValidationMessages validate二重登録チェック() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(SenkyokuTanmatsuInputDialogSpec.二重登録チェック).
                thenAdd(SenkyokuTanmatsuInputDialogValidationMessage.二重登録チェック).
                messages()
        );
        return messages;
    }

    /**
     * 他ユーザ使用チェックのチェック
     *
     * @return チェック結果
     */
    public IValidationMessages validate他ユーザ使用チェック() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(SenkyokuTanmatsuInputDialogSpec.他ユーザ使用チェック).
                thenAdd(SenkyokuTanmatsuInputDialogValidationMessage.他ユーザ使用チェック).
                messages()
        );
        return messages;
    }

    /**
     * 空白行の確認チェック
     *
     * @return チェック結果
     */
    public IValidationMessages validate空白行の確認チェック() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(SenkyokuTanmatsuInputDialogSpec.空白行の確認チェック).
                thenAdd(SenkyokuTanmatsuInputDialogValidationMessage.空白行の確認チェック).
                messages()
        );
        return messages;
    }

}
