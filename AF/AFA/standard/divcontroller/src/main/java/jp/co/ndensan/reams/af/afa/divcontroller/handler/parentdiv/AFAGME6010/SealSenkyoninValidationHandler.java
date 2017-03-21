/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME6010;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME6010.SealSenkyoninDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 選挙人宛名シールのバリデーションハンドラです。
 *
 * @reamsid_L AF-0620-012 liuj
 */
public class SealSenkyoninValidationHandler {

    private final SealSenkyoninDiv div;

    /**
     * コンストラクタです。
     *
     * @param div SealSenkyoninDiv
     */
    public SealSenkyoninValidationHandler(SealSenkyoninDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ生成
     *
     * @param div 選挙人宛名シールのDiv
     * @return 選挙人宛名シールのハンドラ
     */
    public static SealSenkyoninValidationHandler of(SealSenkyoninDiv div) {
        return new SealSenkyoninValidationHandler(div);
    }

    /**
     * validateチェックです
     *
     * @return チェック結果
     */
    public ValidationMessageControlPairs validateチェック() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new SealSenkyoninValidator(div).validate();
        validateResult.add(createErrorDictionary().check(messages));
        return validateResult;
    }

    private ValidationDictionary createErrorDictionary() {
        return new ValidationDictionaryBuilder().
                add(SealSenkyoninValidationErrorMessage.開始印字位置が選択されていません).
                build();
    }
}
