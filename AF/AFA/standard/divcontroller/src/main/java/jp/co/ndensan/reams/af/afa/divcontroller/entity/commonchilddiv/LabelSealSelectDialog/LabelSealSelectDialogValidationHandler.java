/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.LabelSealSelectDialog;

import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaSealPositionGuide.AtenaSealPositionGuideDiv;
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
 * ラベルシール印刷確認ダイアログ用バリデーションハンドラークラスです。
 *
 * @reamsid_L AF-0620-015 liuyj
 */
public class LabelSealSelectDialogValidationHandler {

    private final LabelSealSelectDialogDiv div;

    /**
     * コンストラクタです。
     *
     * @param div LabelSealSelectDialogDiv
     */
    public LabelSealSelectDialogValidationHandler(LabelSealSelectDialogDiv div) {
        this.div = div;
    }

    /**
     * パラメータのバリデーションの結果を返します。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate() {
        ValidationMessageControlPairs validResult = new ValidationMessageControlPairs();
        validResult.add(div.getCcdLabelSealPrintTaisho().validate());
        IValidationMessages message = new LabelSealSelectDialogValidationHandler.ControlValidator(div).validResult();
        validResult.add(createDictionary().check(message));
        return validResult;
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder().add(ControlValidationMessage.開始印字位置を指定してください,
                ((AtenaSealPositionGuideDiv) div.getCcdSealPosition()).getTxtPosition()).build();
    }

    private static class ControlValidator {

        private final LabelSealSelectDialogDiv div;

        public ControlValidator(LabelSealSelectDialogDiv div) {
            this.div = div;
        }

        public IValidationMessages validResult() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(LabelSealSelectDialogSpec.開始印字位置チェック)
                    .thenAdd(ControlValidationMessage.開始印字位置を指定してください)
                    .messages());
            return messages;
        }
    }

    private static enum ControlValidationMessage implements IValidationMessage {

        開始印字位置を指定してください(UrErrorMessages.未指定, "開始印字位置を");

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
