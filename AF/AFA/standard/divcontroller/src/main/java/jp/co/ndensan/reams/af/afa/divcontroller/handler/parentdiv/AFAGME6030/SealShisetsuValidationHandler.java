/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME6030;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME6030.SealShisetsuDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaSealPositionGuide.AtenaSealPositionGuideDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 施設宛名シールのValidationHandlerです。
 *
 * @reamsid_L AF-0620-010 xul
 */
public class SealShisetsuValidationHandler {

    private final SealShisetsuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div SealShisetsuDiv
     */
    public SealShisetsuValidationHandler(SealShisetsuDiv div) {
        this.div = div;
    }

    /**
     * 実行ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new SealShisetsuValidator(div).validate();

        validateResult.add(createErrorDictionary().check(messages));

        return validateResult;
    }

    private ValidationDictionary createErrorDictionary() {
        return new ValidationDictionaryBuilder()
                .add(SealShisetsuValidationMessage.開始印字位置選択チェック, ((AtenaSealPositionGuideDiv) div.getCcdSealPosition()).getTxtPosition())
                .build();

    }

}
