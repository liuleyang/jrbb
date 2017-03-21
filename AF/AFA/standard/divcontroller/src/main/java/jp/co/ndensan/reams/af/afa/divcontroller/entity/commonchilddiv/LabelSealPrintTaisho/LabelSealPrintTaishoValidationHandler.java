/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.LabelSealPrintTaisho;

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
 * ラベルシール作成対象共有子divのバリデーションハンドラークラスです。
 *
 * @reamsid_L AF-0620-016 zhangl
 */
public class LabelSealPrintTaishoValidationHandler {

    private final LabelSealPrintTaishoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div LabelSealPrintTaishoDiv
     */
    public LabelSealPrintTaishoValidationHandler(LabelSealPrintTaishoDiv div) {
        this.div = div;
    }

    /**
     * パラメータのバリデーションの結果を返します。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate() {
        ValidationMessageControlPairs validResult = new ValidationMessageControlPairs();
        IValidationMessages message = new LabelSealPrintTaishoValidationHandler.ControlValidator(div)
                .validResult();
        validResult.add(createDictionary().check(message));

        return validResult;
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(ControlValidationMessage.印刷対象が選択されていない,
                        div.getChkFuzaishaTohyoShomeisho(),
                        div.getChkSenseisho(),
                        div.getChkLabelSenseisho(),
                        div.getChkLabelFuto(),
                        div.getChkLabelShohon(),
                        div.getChkLabelNyujoken())
                .add(ControlValidationMessage.封筒貼付用の印刷対象選挙が選択されていない, div.getChkSenkyo())
                .add(ControlValidationMessage.宣誓書貼付用番号が0の不正, div.getTxtMaisuSenseisho())
                .add(ControlValidationMessage.抄本貼付用番号が0の不正, div.getChkLabelShohon())
                .add(ControlValidationMessage.入場券貼付用番号が0の不正, div.getChkLabelNyujoken())
                .build();
    }

    private static class ControlValidator {

        private final LabelSealPrintTaishoDiv div;

        public ControlValidator(LabelSealPrintTaishoDiv div) {
            this.div = div;
        }

        public IValidationMessages validResult() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(LabelSealPrintTaishoSpec.画面項目選択チェック)
                    .thenAdd(ControlValidationMessage.印刷対象が選択されていない)
                    .ifNot(LabelSealPrintTaishoSpec.封筒貼付用関連チェック)
                    .thenAdd(ControlValidationMessage.封筒貼付用の印刷対象選挙が選択されていない)
                    .ifNot(LabelSealPrintTaishoSpec.宣誓書貼付用枚数が0枚のチェック)
                    .thenAdd(ControlValidationMessage.宣誓書貼付用番号が0の不正)
                    .ifNot(LabelSealPrintTaishoSpec.抄本貼付用枚数が0枚のチェック)
                    .thenAdd(ControlValidationMessage.抄本貼付用番号が0の不正)
                    .ifNot(LabelSealPrintTaishoSpec.入場券貼付用枚数が0枚のチェック)
                    .thenAdd(ControlValidationMessage.入場券貼付用番号が0の不正)
                    .messages());
            return messages;
        }
    }

    private static enum ControlValidationMessage implements IValidationMessage {

        印刷対象が選択されていない(UrErrorMessages.選択されていない, "印刷対象"),
        封筒貼付用の印刷対象選挙が選択されていない(UrErrorMessages.選択されていない, "封筒貼付用の印刷対象選挙"),
        宣誓書貼付用番号が0の不正(UrErrorMessages.番号が0の不正, "枚数"),
        抄本貼付用番号が0の不正(UrErrorMessages.番号が0の不正, "枚数"),
        入場券貼付用番号が0の不正(UrErrorMessages.番号が0の不正, "枚数");

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
