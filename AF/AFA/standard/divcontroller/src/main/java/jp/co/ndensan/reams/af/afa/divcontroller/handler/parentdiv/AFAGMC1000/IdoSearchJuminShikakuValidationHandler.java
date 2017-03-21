/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMC1000;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMC1000.IdoSearchJuminShikakuDiv;
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
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaFinder.AtenaFinderDiv;

/**
 * 住民検索（資格）のValidationHandlerです。
 *
 * @reamsid_L AF-0180-013 liuyj
 */
public class IdoSearchJuminShikakuValidationHandler {

    private final IdoSearchJuminShikakuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div IdoSearchJuminShikakuDiv
     */
    public IdoSearchJuminShikakuValidationHandler(IdoSearchJuminShikakuDiv div) {
        this.div = div;
    }

    /**
     * 実行ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate検索条件() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new IdoSearchJuminShikakuValidationHandler.IdoSearchJuminShikakuControlValidator(div)
                .validate検索条件();
        validateResult.add(createDictionary().check(messages));
        return validateResult;
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(IdoSearchJuminShikakuValidationMessage.検索条件入力チェック,
                        ((AtenaFinderDiv) div.getIdoSearchJoken().getCcdIdoSearchJukiJoho()).getTxtAtenaMeisho(),
                        ((AtenaFinderDiv) div.getIdoSearchJoken().getCcdIdoSearchJukiJoho()).getTxtSeinenGappi(),
                        ((AtenaFinderDiv) div.getIdoSearchJoken().getCcdIdoSearchJukiJoho()).getTxtShikibetsuCodeSub(),
                        ((AtenaFinderDiv) div.getIdoSearchJoken().getCcdIdoSearchJukiJoho()).getTxtSetaiCodeSub(),
                        div.getIdoSearchJoken().getCcdIdoSearchTohyoShikaku().getCcdTohyokuCode().getTxtTohyokuCode())
                .build();
    }

    private static class IdoSearchJuminShikakuControlValidator {

        private final IdoSearchJuminShikakuDiv div;

        public IdoSearchJuminShikakuControlValidator(IdoSearchJuminShikakuDiv div) {
            this.div = div;
        }

        public IValidationMessages validate検索条件() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
//            messages.add(ValidateChain.validateStart(div)
//                    .ifNot(IdoSearchJuminShikakuSpec.検索条件入力チェック)
//                    .thenAdd(IdoSearchJuminShikakuValidationMessage.検索条件入力チェック)
//                    .messages());
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(IdoSearchJuminShikakuSpec.住基情報検索条件入力チェック)
                    .thenAdd(IdoSearchJuminShikakuValidationMessage.検索条件入力チェック)
                    .messages());
            return messages;
        }

    }

    private static enum IdoSearchJuminShikakuValidationMessage implements IValidationMessage {

        /**
         * 検索条件入力チェック。
         */
        検索条件入力チェック(UrErrorMessages.未入力, "少なくとも１つの検索条件");

        private final Message message;

        IdoSearchJuminShikakuValidationMessage(IMessageGettable message) {
            this.message = message.getMessage();
        }

        IdoSearchJuminShikakuValidationMessage(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

}
