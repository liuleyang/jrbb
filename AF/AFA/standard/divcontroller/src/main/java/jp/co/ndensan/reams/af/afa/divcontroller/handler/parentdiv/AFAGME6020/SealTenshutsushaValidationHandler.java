/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME6020;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME6020.SealTenshutsushaDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * AFAGME6020 転出者宛名シール
 *
 * @reamsid_L AF-0620-011 lis2
 */
public class SealTenshutsushaValidationHandler {

    private SealTenshutsushaDiv div;

    /**
     * コンストラクタです。
     *
     * @param div SealTenshutsushaDiv
     */
    public SealTenshutsushaValidationHandler(SealTenshutsushaDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ生成
     *
     * @param div 転出者宛名シールのDiv
     * @return 転出者宛名シールのハンドラ
     */
    public static SealTenshutsushaValidationHandler of(SealTenshutsushaDiv div) {
        return new SealTenshutsushaValidationHandler(div);
    }

    /**
     * validateチェックです
     *
     * @return チェック結果
     */
    public ValidationMessageControlPairs validateチェック() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new SealTenshutsushaValidator(div).validate();
        validateResult.add(createErrorDictionary().check(messages));
        return validateResult;
    }

    private ValidationDictionary createErrorDictionary() {
        return new ValidationDictionaryBuilder().
                add(SealTenshutsushaErrorMessage.対象期間対象開始年月日が入力がない).
                add(SealTenshutsushaErrorMessage.対象期間対象終了年月日が入力がない).
                add(SealTenshutsushaErrorMessage.対象期間が不正).
                add(SealTenshutsushaErrorMessage.開始印字位置が選択されていません).
                build();
    }
}
