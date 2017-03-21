/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SearchSimpleJuminDialog;

//import jp.co.ndensan.reams.af.afa.business.core.master.Shisetsu;
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
 * SearchSimpleJuminValidationHandler の操作を担当するクラスです。
 * <p>
 * このクラスを通してShisetsuCodeSelectDivの入力可否、表示・非表示の制御を行ったり、情報を受け取ったりすることができます。
 * </p>
 *
 * @reamsid_L AF-0170-020 lis
 */
public class SearchSimpleJuminValidationHandler {

    private final SearchSimpleJuminDialogDiv div;

    /**
     * コンストラクタです。
     *
     * @param div SearchSimpleJuminDialogDiv
     */
    public SearchSimpleJuminValidationHandler(SearchSimpleJuminDialogDiv div) {
        this.div = div;
    }

    /**
     * 実行ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate対象者が存在しない() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new SearchSimpleJuminValidationHandler.SearchSimpleJuminControlValidator(div)
                .validate対象者が存在しない();
        validateResult.add(createDictionary().check(messages));
        return validateResult;
    }

    /**
     * 実行ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate検索() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new SearchSimpleJuminValidationHandler.SearchSimpleJuminControlValidator(div)
                .validate検索();
        validateResult.add(createDictionary().check(messages));
        return validateResult;
    }

    /**
     * 実行ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate対象者を選択() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new SearchSimpleJuminValidationHandler.SearchSimpleJuminControlValidator(div).
                validate対象者選択();
        validateResult.add(createDictionary().check(messages));
        return validateResult;
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(SearchSimpleJuminValidationMessage.表示件数上限, div.getSearchSimpleJoken().getTxtMaxDisplayCount())
                .add(SearchSimpleJuminValidationMessage.対象者を選択)
                .add(SearchSimpleJuminValidationMessage.対象者が存在しない)
                .add(SearchSimpleJuminValidationMessage.検索条件入力チェック,
                        ((AtenaFinderDiv) div.getSearchSimpleJoken().getCcdSearchSimpleJukiJoho()).getTxtAtenaMeisho(),
                        ((AtenaFinderDiv) div.getSearchSimpleJoken().getCcdSearchSimpleJukiJoho()).getTxtSeinenGappi(),
                        ((AtenaFinderDiv) div.getSearchSimpleJoken().getCcdSearchSimpleJukiJoho()).getTxtShikibetsuCodeSub(),
                        ((AtenaFinderDiv) div.getSearchSimpleJoken().getCcdSearchSimpleJukiJoho()).getTxtSetaiCodeSub(),
                        div.getSearchSimpleJoken().getCcdTohyokuCode().getTxtTohyokuCode())
                .build();
    }

    private static class SearchSimpleJuminControlValidator {

        private final SearchSimpleJuminDialogDiv div;

        public SearchSimpleJuminControlValidator(SearchSimpleJuminDialogDiv div) {
            this.div = div;
        }

        public IValidationMessages validate検索() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(SearchSimpleJuminDialogSpec.最大表示件数チェック)
                    .thenAdd(SearchSimpleJuminValidationMessage.表示件数上限)
                    .ifNot(SearchSimpleJuminDialogSpec.検索条件入力チェック)
                    .thenAdd(SearchSimpleJuminValidationMessage.検索条件入力チェック)
                    .messages());

            return messages;
        }

        public IValidationMessages validate対象者が存在しない() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(SearchSimpleJuminDialogSpec.対象者が存在しないチェック)
                    .thenAdd(SearchSimpleJuminValidationMessage.対象者が存在しない)
                    .messages());

            return messages;
        }

        public IValidationMessages validate対象者選択() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(SearchSimpleJuminDialogSpec.対象者選択チェック)
                    .thenAdd(SearchSimpleJuminValidationMessage.対象者を選択)
                    .messages());

            return messages;
        }

    }

    private static enum SearchSimpleJuminValidationMessage implements IValidationMessage {

        /**
         * 表示件数上限。
         */
        表示件数上限(UrErrorMessages.項目に対する制約, "最大表示件数", "100以下"),
        /**
         * 対象者を選択。
         */
        対象者を選択(UrErrorMessages.対象者を選択),
        /**
         * 施設コード終了入力。
         */
        対象者が存在しない(UrErrorMessages.対象者が存在しない),
        /**
         * 検索条件入力チェック。
         */
        検索条件入力チェック(UrErrorMessages.未入力, "少なくとも１つの検索条件");

        private final Message message;

        SearchSimpleJuminValidationMessage(IMessageGettable message) {
            this.message = message.getMessage();
        }

        SearchSimpleJuminValidationMessage(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

}
