/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.BarCodeNyuryoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 【共有子Div】BarCodeNyuryokuDivに対するバリデーションハンドラークラスです。
 *
 * @reamsid_L AF-0080-020 qiuxy
 */
public class BarCodeNyuryokuValidationHandler {

    private final BarCodeNyuryokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div BarCodeNyuryokuDiv
     */
    public BarCodeNyuryokuValidationHandler(BarCodeNyuryokuDiv div) {
        this.div = div;
    }

    /**
     * パラメータのバリデーションの結果を返します。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate() {
        ValidationMessageControlPairs validResult = new ValidationMessageControlPairs();
        IValidationMessages message = new BarCodeNyuryokuValidationHandler.ControlValidator(div)
                .validResult();
        validResult.add(createDictionary().check(message));

        return validResult;
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(ControlValidationMessage.桁数１９指定, div.getTxtBarCode())
                .add(ControlValidationMessage.桁数２０指定, div.getTxtBarCode())
                .build();
    }

    private static class ControlValidator {

        private final BarCodeNyuryokuDiv div;

        public ControlValidator(BarCodeNyuryokuDiv div) {
            this.div = div;
        }

        public IValidationMessages validResult() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(BarCodeNyuryokuSpec.is１９桁チェック)
                    .thenAdd(ControlValidationMessage.桁数１９指定)
                    .ifNot(BarCodeNyuryokuSpec.is２０桁チェック)
                    .thenAdd(ControlValidationMessage.桁数２０指定)
                    .messages());
            return messages;
        }
    }

    private static enum ControlValidationMessage implements IValidationMessage {

        桁数１９指定(UrErrorMessages.桁数が不正, "バーコード", "19"),
        桁数２０指定(UrErrorMessages.桁数が不正, "バーコード", "20");

        private final Message message;

        ControlValidationMessage(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
