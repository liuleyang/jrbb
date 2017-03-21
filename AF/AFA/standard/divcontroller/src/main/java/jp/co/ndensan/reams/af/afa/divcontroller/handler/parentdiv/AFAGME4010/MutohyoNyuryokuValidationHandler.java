/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME4010;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME4010.MutohyoNyuryokuDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeInput.CodeInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 無投票入力のバリデーションハンドラです。
 *
 * @reamsid_L AF-0110-010 wangxt2
 */
public class MutohyoNyuryokuValidationHandler {

    private final MutohyoNyuryokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div MutohyoNyuryokuDiv
     */
    public MutohyoNyuryokuValidationHandler(MutohyoNyuryokuDiv div) {
        this.div = div;
    }

    /**
     * パラメータのバリデーションの結果を返します。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate() {
        ValidationMessageControlPairs validResult = new ValidationMessageControlPairs();
        IValidationMessages message入力値 = new MutohyoNyuryokuValidationHandler.ControlValidator(div).validResultコード入力値();
        validResult.add(createDictionary().check(message入力値));
        return validResult;
    }

    private ValidationDictionary createDictionary() {
        CodeInputDiv codeinput = (CodeInputDiv) div.getMutohyoNyuryokuJoken().getCcdKubunCode();
        return new ValidationDictionaryBuilder().add(MutohyoNyuryokuValidationMessage.入力値が不正_追加メッセージあり,
                codeinput.getTxtCode()).build();
    }

    private static class ControlValidator {

        private final MutohyoNyuryokuDiv div;

        public ControlValidator(MutohyoNyuryokuDiv div) {
            this.div = div;
        }

        public IValidationMessages validResultコード入力値() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(MutohyoNyuryokuSpec.コード入力値チェック)
                    .thenAdd(MutohyoNyuryokuValidationMessage.入力値が不正_追加メッセージあり)
                    .messages());
            return messages;
        }

    }
}
