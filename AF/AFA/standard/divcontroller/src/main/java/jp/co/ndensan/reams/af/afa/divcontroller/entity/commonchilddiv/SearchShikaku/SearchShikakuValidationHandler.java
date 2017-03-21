/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SearchShikaku;

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
 * バリデーションHandlerです。
 *
 * @reamsid_L AF-0180-011 liuyj
 */
public class SearchShikakuValidationHandler {

    private final SearchShikakuDiv div;

    public SearchShikakuValidationHandler(SearchShikakuDiv div) {
        this.div = div;
    }

    public ValidationMessageControlPairs validate() {
        ValidationMessageControlPairs validResult = new ValidationMessageControlPairs();
        IValidationMessages message名簿登録日大小関係 = new SearchShikakuValidationHandler.ControlValidator(div).validResult名簿登録日大小関係();
        validResult.add(createDictionary().check(message名簿登録日大小関係));
        IValidationMessages message登録停止日大小関係 = new SearchShikakuValidationHandler.ControlValidator(div).validResult登録停止日大小関係();
        validResult.add(createDictionary().check(message登録停止日大小関係));
        IValidationMessages message抹消日大小関係 = new SearchShikakuValidationHandler.ControlValidator(div).validResult抹消日大小関係();
        validResult.add(createDictionary().check(message抹消日大小関係));
        IValidationMessages message表示日大小関係 = new SearchShikakuValidationHandler.ControlValidator(div).validResult表示日大小関係();
        validResult.add(createDictionary().check(message表示日大小関係));
        IValidationMessages message消除予定日大小関係 = new SearchShikakuValidationHandler.ControlValidator(div).validResult消除予定日大小関係();
        validResult.add(createDictionary().check(message消除予定日大小関係));
        IValidationMessages message表示消除日大小関係 = new SearchShikakuValidationHandler.ControlValidator(div).validResult表示消除日大小関係();
        validResult.add(createDictionary().check(message表示消除日大小関係));
        IValidationMessages message刑期終了日大小関係 = new SearchShikakuValidationHandler.ControlValidator(div).validResult刑期終了日大小関係();
        validResult.add(createDictionary().check(message刑期終了日大小関係));
        return validResult;
    }

    private ValidationDictionary createDictionary() {

        return new ValidationDictionaryBuilder().
                add(ControlValidationMessage.名簿登録日大小関係が不正,
                        div.getSearchShikakuShosai().getTxtSearchTorokuYmd()).
                add(ControlValidationMessage.登録停止日大小関係が不正,
                        div.getSearchShikakuShosai().getTxtSearchTeishiYMD()).
                add(ControlValidationMessage.抹消日大小関係が不正,
                        div.getSearchShikakuShosai().getTxtSearchMasshoYMD()).
                add(ControlValidationMessage.表示日大小関係が不正,
                        div.getSearchShikakuShosai().getTxtSearchHyojiYMD()).
                add(ControlValidationMessage.消除予定日大小関係が不正,
                        div.getSearchShikakuShosai().getTxtSearchShojoYoteiYMD()).
                add(ControlValidationMessage.表示消除日大小関係が不正,
                        div.getSearchShikakuShosai().getTxtSearchShojoYMD()).
                add(ControlValidationMessage.刑期終了日大小関係が不正,
                        div.getSearchShikakuShosai().getTxtSearchKeikiShuryoYMD()).
                build();
    }

    private static class ControlValidator {

        private final SearchShikakuDiv div;

        public ControlValidator(SearchShikakuDiv div) {
            this.div = div;
        }

        public IValidationMessages validResult名簿登録日大小関係() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(SearchShikakuSpec.名簿登録日大小関係チェック)
                    .thenAdd(ControlValidationMessage.名簿登録日大小関係が不正)
                    .messages());
            return messages;
        }

        public IValidationMessages validResult登録停止日大小関係() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(SearchShikakuSpec.登録停止日大小関係チェック)
                    .thenAdd(ControlValidationMessage.登録停止日大小関係が不正)
                    .messages());
            return messages;
        }

        public IValidationMessages validResult抹消日大小関係() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(SearchShikakuSpec.抹消日大小関係チェック)
                    .thenAdd(ControlValidationMessage.抹消日大小関係が不正)
                    .messages());
            return messages;
        }

        public IValidationMessages validResult表示日大小関係() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(SearchShikakuSpec.表示日大小関係チェック)
                    .thenAdd(ControlValidationMessage.表示日大小関係が不正)
                    .messages());
            return messages;
        }

        public IValidationMessages validResult消除予定日大小関係() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(SearchShikakuSpec.消除予定日大小関係チェック)
                    .thenAdd(ControlValidationMessage.消除予定日大小関係が不正)
                    .messages());
            return messages;
        }

        public IValidationMessages validResult表示消除日大小関係() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(SearchShikakuSpec.表示消除日大小関係チェック)
                    .thenAdd(ControlValidationMessage.表示消除日大小関係が不正)
                    .messages());
            return messages;
        }

        public IValidationMessages validResult刑期終了日大小関係() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(SearchShikakuSpec.刑期終了日大小関係チェック)
                    .thenAdd(ControlValidationMessage.刑期終了日大小関係が不正)
                    .messages());
            return messages;
        }
    }

    private static enum ControlValidationMessage implements IValidationMessage {

        名簿登録日大小関係が不正(UrErrorMessages.大小関係が不正, "名簿登録日Toは名簿登録日From以降を入力してください"),
        登録停止日大小関係が不正(UrErrorMessages.大小関係が不正, "登録停止日Toは登録停止日From以降を入力してください"),
        抹消日大小関係が不正(UrErrorMessages.大小関係が不正, "抹消日Toは抹消日From以降を入力してください"),
        表示日大小関係が不正(UrErrorMessages.大小関係が不正, "表示日Toは表示日From以降を入力してください"),
        消除予定日大小関係が不正(UrErrorMessages.大小関係が不正, "消除予定日Toは消除予定日From以降を入力してください"),
        表示消除日大小関係が不正(UrErrorMessages.大小関係が不正, "表示消除日Toは表示消除日From以降を入力してください"),
        刑期終了日大小関係が不正(UrErrorMessages.大小関係が不正, "刑期終了日Toは刑期終了日From以降を入力してください");
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
