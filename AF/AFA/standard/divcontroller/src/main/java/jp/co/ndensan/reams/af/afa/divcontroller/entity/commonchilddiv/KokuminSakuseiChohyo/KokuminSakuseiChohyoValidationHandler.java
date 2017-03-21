/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminSakuseiChohyo;

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
 * 【共有子Div】KokuminSakuseiChohyoDivに対応するSpecクラスです
 *
 * @reamsid_L AF-0360-012 liwul
 */
public class KokuminSakuseiChohyoValidationHandler {

    private final KokuminSakuseiChohyoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ドメインオブジェクトを取り出したい{@link KokuminSakuseiChohyoDiv}
     */
    public KokuminSakuseiChohyoValidationHandler(KokuminSakuseiChohyoDiv div) {
        this.div = div;
    }

    /**
     * パラメータのバリデーションの結果を返します。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate() {
        ValidationMessageControlPairs validResult = new ValidationMessageControlPairs();
        IValidationMessages message = new KokuminSakuseiChohyoValidationHandler.ControlValidator(div)
                .validResult();
        validResult.add(createDictionary().check(message));

        return validResult;
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(ControlValidationMessage.時点日必須入力チェック, div.getKokuminSakuseiChohyoTorokushasuList().getTxtTorokushasuListKijunYmd())
                .build();
    }

    private static class ControlValidator {

        private final KokuminSakuseiChohyoDiv div;

        public ControlValidator(KokuminSakuseiChohyoDiv div) {
            this.div = div;
        }

        public IValidationMessages validResult() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(KokuminSakuseiChohyoSpec.時点日必須入力チェック)
                    .thenAdd(ControlValidationMessage.時点日必須入力チェック)
                    .messages());
            return messages;
        }
    }

    private static enum ControlValidationMessage implements IValidationMessage {

        時点日必須入力チェック(UrErrorMessages.必須項目_追加メッセージあり, "時点日");
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
