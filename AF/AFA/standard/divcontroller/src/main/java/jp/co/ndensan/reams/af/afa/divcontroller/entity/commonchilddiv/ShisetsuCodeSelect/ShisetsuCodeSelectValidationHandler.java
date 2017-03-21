/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShisetsuCodeSelect;

import jp.co.ndensan.reams.af.afa.definition.message.AfErrorMessages;
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
 * 【共有子Div】ShisetsuCodeSelectDivに対するバリデーションクラスです。
 *
 * @reamsid_L AF-0080-035 qiuxy
 */
public class ShisetsuCodeSelectValidationHandler {

    private final ShisetsuCodeSelectDiv div;

    /**
     * コンストラクタです。
     *
     * @param div LabelSealPrintTaishoDiv
     */
    public ShisetsuCodeSelectValidationHandler(ShisetsuCodeSelectDiv div) {
        this.div = div;
    }

    /**
     * パラメータのバリデーションの結果を返します。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate() {
        ValidationMessageControlPairs validResult = new ValidationMessageControlPairs();
        IValidationMessages message = new ShisetsuCodeSelectValidationHandler.ControlValidator(div)
                .validResult();
        validResult.add(createDictionary().check(message));

        return validResult;
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(ControlValidationMessage.施設存在しない, div.getTxtShisetsuCode())
                .add(ShisetsuCodeValidationMessage.施設コードの関連性チェック, div.getTxtShisetsuCode())
                .build();
    }

    private static class ControlValidator {

        private final ShisetsuCodeSelectDiv div;

        public ControlValidator(ShisetsuCodeSelectDiv div) {
            this.div = div;
        }

        public IValidationMessages validResult() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(ShisetsuCodeSelectSpec.施設コード有無チェック)
                    .thenAdd(ControlValidationMessage.施設存在しない)
                    .ifNot(ShisetsuCodeSelectSpec.施設コード関連チェック)
                    .thenAdd(ShisetsuCodeValidationMessage.施設コードの関連性チェック)
                    .messages());
            return messages;
        }
    }

    private static enum ControlValidationMessage implements IValidationMessage {

        施設存在しない(UrErrorMessages.存在しない, "施設"),
        施設コード関連性ない(AfErrorMessages.施設コードと施設種別の関係不正);

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
