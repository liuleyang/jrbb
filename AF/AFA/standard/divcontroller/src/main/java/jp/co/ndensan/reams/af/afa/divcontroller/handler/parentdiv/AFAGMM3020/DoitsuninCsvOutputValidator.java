/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM3020;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM3020.DoitsuninCsvOutputDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 *
 * 同一人物調査。
 *
 * @reamsid_L AF-0690-010 wanghj
 */
public class DoitsuninCsvOutputValidator implements IValidatable {

    private final DoitsuninCsvOutputDiv div;

    /**
     * コンストラクタです。
     *
     * @param div DoitsuninCsvOutputDiv
     */
    public DoitsuninCsvOutputValidator(DoitsuninCsvOutputDiv div) {
        this.div = div;
    }

    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(DoitsuninCsvOutputSpec.判断条件の選択チェック)
                .thenAdd(DoitsuninCsvOutputValidationMessage.判断条件未選択)
                .messages());
        return messages;
    }
}
