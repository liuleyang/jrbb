/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM3020;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM3020.DoitsuninCsvOutputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 同一人物調査のValidationHandlerです。
 *
 * @reamsid_L AF-0690-010 wanghj
 */
public class DoitsuninCsvOutputValidationHandler {

    private final DoitsuninCsvOutputDiv div;

    /**
     * コンストラクタです。
     *
     * @param div DoitsuninCsvOutputDiv
     */
    public DoitsuninCsvOutputValidationHandler(DoitsuninCsvOutputDiv div) {
        this.div = div;
    }

    /**
     * ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new DoitsuninCsvOutputValidator(div).validate();
        validateResult.add(createDictionary().check(messages));

        return validateResult;
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(DoitsuninCsvOutputValidationMessage.判断条件未選択, div)
                .build();
    }

}
