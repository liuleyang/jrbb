/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME6010;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME6010.SealSenkyoninDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * AFAGME6010 選挙人宛名シール
 *
 * @reamsid_L AF-0620-012 liuj
 */
public class SealSenkyoninValidator implements IValidatable {

    private final SealSenkyoninDiv div;

    /**
     * コンストラクタ
     *
     * @param div 選挙人宛名シールのDiv
     */
    public SealSenkyoninValidator(SealSenkyoninDiv div) {
        this.div = div;
    }

    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(SealSenkyoninSpec.開始印字位置チェック).
                thenAdd(SealSenkyoninValidationErrorMessage.開始印字位置が選択されていません).messages());

        return messages;
    }
}
