/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyojoCodeSelect;

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
 * 【共有子Div】TohyojoCodeSelectDivに対するバリデーションクラスです。
 *
 * @reamsid_L AF-0710-020 liuyj
 */
public class TohyojoCodeSelectValidationHandler {

    private final TohyojoCodeSelectDiv div;

    /**
     * コンストラクタです。
     *
     * @param div LabelSealPrintTaishoDiv
     */
    public TohyojoCodeSelectValidationHandler(TohyojoCodeSelectDiv div) {
        this.div = div;
    }

    /**
     * パラメータのバリデーションの結果を返します。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate() {
        ValidationMessageControlPairs validResult = new ValidationMessageControlPairs();
        IValidationMessages message = new TohyojoCodeSelectValidationHandler.ControlValidator(div)
                .validResult();
        validResult.add(createDictionary().check(message));

        return validResult;
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(ControlValidationMessage.投票所コード存在しない, div.getTxtTohyojoCode())
                .build();
    }

    private static class ControlValidator {

        private final TohyojoCodeSelectDiv div;

        public ControlValidator(TohyojoCodeSelectDiv div) {
            this.div = div;
        }

        public IValidationMessages validResult() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(TohyojoCodeSelectSpec.投票所コード有無チェック)
                    .thenAdd(ControlValidationMessage.投票所コード存在しない)
                    .messages());
            return messages;
        }
    }

    private static enum ControlValidationMessage implements IValidationMessage {

        投票所コード存在しない(UrErrorMessages.存在しない, "投票所");

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
