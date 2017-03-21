/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME2040;

import jp.co.ndensan.reams.af.afa.definition.message.AfErrorMessages;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2040.BarCodeJuriDiv;
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
 * AFAGME2040 投票受付　施設一括バーコード受理のバリデーションハンドラクラスです。
 *
 * @reamsid_L AF-0240-010 qiuxy
 */
public class BarCodeJuriValidationHandler {

    private final BarCodeJuriDiv div;

    /**
     * コンストラクタです。
     *
     * @param div BarCodeJuriDiv
     */
    public BarCodeJuriValidationHandler(BarCodeJuriDiv div) {
        this.div = div;
    }

    /**
     * バリデーションの結果を返します。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validateバーコード桁数と一致性() {
        ValidationMessageControlPairs validResult = new ValidationMessageControlPairs();
        IValidationMessages messageバーコードの一致性 = new BarCodeJuriValidationHandler.ControlValidator(div)
                .validResultバーコードの一致性();
        validResult.add(createDictionary().check(messageバーコードの一致性));
        validResult.add(div.getBarCodeJuriNyuryoku().getCcdJuriBarCode().validateバーコード());
        return validResult;
    }

    /**
     * バリデーションの結果を返します。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate選挙() {
        ValidationMessageControlPairs validResult = new ValidationMessageControlPairs();
        IValidationMessages message選挙 = new BarCodeJuriValidationHandler.ControlValidator(div)
                .validResult選挙();
        validResult.add(createDictionary().check(message選挙));
        return validResult;
    }

    /**
     * バリデーションの結果を返します。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate件数() {
        ValidationMessageControlPairs validResult = new ValidationMessageControlPairs();
        IValidationMessages message件数 = new BarCodeJuriValidationHandler.ControlValidator(div)
                .validResult件数();
        validResult.add(createDictionary().check(message件数));
        return validResult;
    }

    /**
     * バリデーションの結果を返します。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate投票資格() {
        ValidationMessageControlPairs validResult = new ValidationMessageControlPairs();
        IValidationMessages message投票資格 = new BarCodeJuriValidationHandler.ControlValidator(div)
                .validResult投票資格();
        validResult.add(createDictionary().check(message投票資格));
        return validResult;
    }

    /**
     * バリデーションの結果を返します。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate受理日() {
        ValidationMessageControlPairs validResult = new ValidationMessageControlPairs();
        IValidationMessages message受理日 = new BarCodeJuriValidationHandler.ControlValidator(div)
                .validResult受理日();
        validResult.add(createDictionary().check(message受理日));

        return validResult;
    }

    /**
     * バリデーションの結果を返します。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validateバーコード重複() {
        ValidationMessageControlPairs validResult = new ValidationMessageControlPairs();
        IValidationMessages messageバーコード重複 = new BarCodeJuriValidationHandler.ControlValidator(div)
                .validResultバーコード重複();
        validResult.add(createDictionary().check(messageバーコード重複));

        return validResult;
    }

    /**
     * バリデーションの結果を返します。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(ControlValidationMessage.入場券確認, div.getBarCodeJuriNyuryoku().getCcdJuriBarCode().getTxtBarCode())
                .add(ControlValidationMessage.項目に対する制約, div.getBarCodeJuriNyuryoku().getBarCodeJuriJoho().getTxtJuriYMD())
                .add(ControlValidationMessage.無投票選挙, div.getBarCodeJuriNyuryoku().getCcdJuriBarCode().getTxtBarCode())
                .add(ControlValidationMessage.対象データなし_追加メッセージあり, div.getBarCodeJuriNyuryoku().getCcdJuriBarCode().getTxtBarCode())
                .add(ControlValidationMessage.投票資格なし, div.getBarCodeJuriNyuryoku().getCcdJuriBarCode().getTxtBarCode())
                .add(ControlValidationMessage.読込済み確認, div.getBarCodeJuriNyuryoku().getCcdJuriBarCode().getTxtBarCode())
                .build();
    }

    private static class ControlValidator {

        private final BarCodeJuriDiv div;

        public ControlValidator(BarCodeJuriDiv div) {
            this.div = div;
        }

        public IValidationMessages validResultバーコードの一致性() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(BarCodeJuriSpec.バーコードの抄本番号一致性チェック)
                    .thenAdd(ControlValidationMessage.入場券確認)
                    .messages());
            return messages;
        }

        public IValidationMessages validResult選挙() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(BarCodeJuriSpec.無投票選挙かどうかをチェック)
                    .thenAdd(ControlValidationMessage.無投票選挙)
                    .messages());
            return messages;
        }

        public IValidationMessages validResult件数() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(BarCodeJuriSpec.件数チェック)
                    .thenAdd(ControlValidationMessage.対象データなし_追加メッセージあり)
                    .messages());
            return messages;
        }

        public IValidationMessages validResult投票資格() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(BarCodeJuriSpec.投票資格チェック)
                    .thenAdd(ControlValidationMessage.投票資格なし)
                    .messages());
            return messages;
        }

        public IValidationMessages validResult受理日() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(BarCodeJuriSpec.受理日と抄本の投票年月日大小チェック)
                    .thenAdd(ControlValidationMessage.項目に対する制約)
                    .messages());
            return messages;
        }

        public IValidationMessages validResultバーコード重複() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(BarCodeJuriSpec.バーコード重複チェック)
                    .thenAdd(ControlValidationMessage.読込済み確認)
                    .messages());
            return messages;
        }

    }

    private static enum ControlValidationMessage implements IValidationMessage {

        入場券確認(AfErrorMessages.入場券確認),
        無投票選挙(AfErrorMessages.投票受付不可, "無投票選挙です"),
        対象データなし_追加メッセージあり(UrErrorMessages.対象データなし_追加メッセージあり, "投票状況"),
        投票資格なし(AfErrorMessages.投票受付不可, "投票資格なし"),
        項目に対する制約(UrErrorMessages.項目に対する制約, "受理日", "抄本の投票年月日より前"),
        読込済み確認(AfErrorMessages.読込済み確認);

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
