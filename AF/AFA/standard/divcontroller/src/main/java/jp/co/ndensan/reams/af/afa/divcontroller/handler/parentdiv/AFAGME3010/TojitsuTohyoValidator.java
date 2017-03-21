/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME3010;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME3010.TojitsuTohyoJokyoDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 *
 * 当日投票のValidatorです。
 *
 * @reamsid_L AF-0260-010 liuyj
 */
public class TojitsuTohyoValidator implements IValidatable {

    private final TojitsuTohyoJokyoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div BarCodeTojitsuDiv
     */
    public TojitsuTohyoValidator(TojitsuTohyoJokyoDiv div) {
        this.div = div;
    }

    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(TojitsuTohyoSpec.集計時間必須入力)
                .thenAdd(TojitsuTohyoValidationMessage.集計時間必須入力)
                .messages());
        return messages;
    }
}
