/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME6020;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME6020.SealTenshutsushaDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * AFAGME6020 転出者宛名シール
 *
 * @reamsid_L AF-0620-011 lis2
 */
public class SealTenshutsushaValidator implements IValidatable {

    private final SealTenshutsushaDiv div;

    /**
     * コンストラクタ
     *
     * @param div 転出者宛名シールのDiv
     */
    public SealTenshutsushaValidator(SealTenshutsushaDiv div) {
        this.div = div;
    }

    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(SealTenshutsushaSpec.対象期間対象開始年月日未入力チェック)
                .thenAdd(SealTenshutsushaErrorMessage.対象期間対象開始年月日が入力がない)
                .ifNot(SealTenshutsushaSpec.対象期間対象終了年月日未入力チェック)
                .thenAdd(SealTenshutsushaErrorMessage.対象期間対象終了年月日が入力がない)
                .ifNot(SealTenshutsushaSpec.対象期間関連チェック)
                .thenAdd(SealTenshutsushaErrorMessage.対象期間が不正)
                .ifNot(SealTenshutsushaSpec.開始印字位置チェック)
                .thenAdd(SealTenshutsushaErrorMessage.開始印字位置が選択されていません).messages());
        return messages;
    }

}
