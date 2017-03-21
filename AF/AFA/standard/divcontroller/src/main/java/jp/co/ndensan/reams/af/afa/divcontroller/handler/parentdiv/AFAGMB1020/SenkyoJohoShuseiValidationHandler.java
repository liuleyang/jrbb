/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB1020;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.senkyojohoshusei.SenkyoJohoShuseiValidationMessage;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB1020.SenkyoJohoShuseiDiv;
import jp.co.ndensan.reams.af.afa.service.senkyojohoshuseivalidation.SenkyoJohoShuseiValidationService;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.binding.ViewControl;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 選挙修正のバリデーションハンドラです。
 *
 */
public class SenkyoJohoShuseiValidationHandler {

    private final SenkyoJohoShuseiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div SenkyoJohoShuseiDiv
     */
    public SenkyoJohoShuseiValidationHandler(SenkyoJohoShuseiDiv div) {
        this.div = div;
    }

    /**
     * 選挙修正の選挙追加関連チェックです。
     *
     * @return バリデーションメッセージコントロールペア
     */
    public ValidationMessageControlPairs senkyoAddValidateチェック() {
        IValidationMessages pairs = new SenkyoJohoShuseiValidationHandler.ControlValidator(div).validateSenkyoAdd();
        return createDictionarySenkyoAdd().check(pairs);
    }

    /**
     * 選挙追加関連チェックです。
     *
     * @param isSimulation Boolean
     * @return バリデーションメッセージコントロールペア
     */
    public ValidationMessageControlPairs senkyoAddValidate関連チェック(Boolean isSimulation) {
        IValidationMessages pairs = new SenkyoJohoShuseiValidationHandler.ControlValidator(div).validate(isSimulation);
        if (isSimulation) {
            return createDictionarySimulation().check(pairs);
        }
        return createDictionary().check(pairs);
    }

    /**
     * 選挙保存関連チェックです。
     *
     * @return バリデーションメッセージコントロールペア
     */
    public ValidationMessageControlPairs senkyoUpdateValidate関連チェック() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        _SenkyoJohoShuseiValidator validator = new _SenkyoJohoShuseiValidator(div);
        validateResult.add(createDictionaryForUpdate().check(validator.validateForUpdate()));
        return validateResult;
    }

    private ValidationDictionary createDictionarySimulation() {
        List<ViewControl> list = new ArrayList<>();
        list.add(div.getSenkyoInput().getDdlSenkyoLevel());
        list.add(div.getSenkyoInput().getTxtKijunYMD());
        return new ValidationDictionaryBuilder().
                add(SenkyoJohoShuseiValidationMessage.選挙名入力確認, div.getSenkyoInput().getTxtSenkyoName()).
                add(SenkyoJohoShuseiValidationMessage.選挙レベル入力確認, div.getSenkyoInput().getDdlSenkyoLevel()).
                add(SenkyoJohoShuseiValidationMessage.選挙略称入力確認, div.getSenkyoInput().getTxtSenkyoRyakusho()).
                add(SenkyoJohoShuseiValidationMessage.選挙マーク入力確認, div.getSenkyoInput().getTxtSenkyoMark()).
                add(SenkyoJohoShuseiValidationMessage.基準日入力確認, div.getSenkyoInput().getTxtKijunYMD()).
                add(SenkyoJohoShuseiValidationMessage.受付開始日入力確認, div.getSenkyoInput().getTxtUketsukeYMD()).
                add(SenkyoJohoShuseiValidationMessage.選挙レベル基準日確認, list).
                add(SenkyoJohoShuseiValidationMessage.選挙追加の基準日は投票日より前の日を設定,
                        div.getSenkyoInput().getTxtKijunYMD()).
                add(SenkyoJohoShuseiValidationMessage.選挙追加の投票日は受付開始日より後の日を設定,
                        div.getSenkyoInput().getTxtUketsukeYMD()).
                build();
    }

    private ValidationDictionary createDictionary() {
        List<ViewControl> list = new ArrayList<>();
        list.add(div.getSenkyoInput().getDdlSenkyoLevel());
        list.add(div.getSenkyoInput().getTxtKijunYMD());
        return new ValidationDictionaryBuilder().
                add(SenkyoJohoShuseiValidationMessage.選挙名入力確認, div.getSenkyoInput().getTxtSenkyoName()).
                add(SenkyoJohoShuseiValidationMessage.選挙レベル入力確認, div.getSenkyoInput().getDdlSenkyoLevel()).
                add(SenkyoJohoShuseiValidationMessage.選挙略称入力確認, div.getSenkyoInput().getTxtSenkyoRyakusho()).
                add(SenkyoJohoShuseiValidationMessage.選挙マーク入力確認, div.getSenkyoInput().getTxtSenkyoMark()).
                add(SenkyoJohoShuseiValidationMessage.基準日入力確認, div.getSenkyoInput().getTxtKijunYMD()).
                add(SenkyoJohoShuseiValidationMessage.受付開始日入力確認, div.getSenkyoInput().getTxtUketsukeYMD()).
                add(SenkyoJohoShuseiValidationMessage.選挙レベル基準日確認, list).
                add(SenkyoJohoShuseiValidationMessage.選挙追加の基準日は投票日より前の日を設定,
                        div.getSenkyoInput().getTxtKijunYMD()).
                add(SenkyoJohoShuseiValidationMessage.選挙追加の基準日は受付開始日より前の日を設定,
                        div.getSenkyoInput().getTxtKijunYMD()).
                add(SenkyoJohoShuseiValidationMessage.選挙追加の投票日は受付開始日より後の日を設定,
                        div.getSenkyoInput().getTxtUketsukeYMD()).
                build();
    }

    private ValidationDictionary createDictionaryForUpdate() {
        return new ValidationDictionaryBuilder().
                add(SenkyoJohoShuseiValidationMessage.抄本名入力確認, div.getCcdSenkyoShuseiShohon().getTxtShohonName()).
                add(SenkyoJohoShuseiValidationMessage.選挙名入力確認, div.getSenkyoShusei().getDgSenkyoShusei()).
                add(SenkyoJohoShuseiValidationMessage.選挙略称入力確認, div.getSenkyoShusei().getDgSenkyoShusei()).
                add(SenkyoJohoShuseiValidationMessage.選挙マーク入力確認, div.getSenkyoShusei().getDgSenkyoShusei()).
                build();
    }

    private ValidationDictionary createDictionarySenkyoAdd() {
        return new ValidationDictionaryBuilder().
                add(SenkyoJohoShuseiValidationMessage.最大登録選挙数確認, div.getSenkyoShusei().getDgSenkyoShusei()).
                build();
    }

    private static class ControlValidator {

        private final SenkyoJohoShuseiDiv div;

        public ControlValidator(SenkyoJohoShuseiDiv div) {
            this.div = div;
        }

        public IValidationMessages validate(Boolean isSimulation) {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            _SenkyoJohoShuseiValidator validator = new _SenkyoJohoShuseiValidator(div);
            if (isSimulation) {
                messages.add(validator.validateSimulation());
            } else {
                messages.add(validator.validate());
            }
            if (null != div.getSenkyoInput().getTxtKijunYMD().getValue()
                    && !RString.isNullOrEmpty(div.getSenkyoInput().getDdlSenkyoLevel().getSelectedKey())) {
                messages = validate選挙レベル基準日(messages);
            }

            return messages;
        }

        public IValidationMessages validateUpdate() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            _SenkyoJohoShuseiValidator validator = new _SenkyoJohoShuseiValidator(div);
            messages.add(validator.validate());
            if (null != div.getSenkyoInput().getTxtKijunYMD().getValue()
                    && !RString.isNullOrEmpty(div.getSenkyoInput().getDdlSenkyoLevel().getSelectedKey())) {
                messages.add(validate選挙レベル基準日(messages));
            }
            return messages;
        }

        private IValidationMessages validate選挙レベル基準日(IValidationMessages messages) {
            SenkyoJohoShuseiValidationService validateService = SenkyoJohoShuseiValidationService.createInstance();
            messages.add(validateService.validate(new ShohonNo(div.getCcdSenkyoShuseiShohon().getTxtHdnShohonNo()),
                    new Code(div.getSenkyoInput().getDdlSenkyoLevel().getSelectedKey()),
                    new FlexibleDate(div.getSenkyoInput().getTxtKijunYMD().getValue().toDateString())));
            return messages;
        }

        public IValidationMessages validateSenkyoAdd() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            _SenkyoJohoShuseiValidator validator = new _SenkyoJohoShuseiValidator(div);
            messages.add(validator.validateForSenkyoAdd());
            return messages;
        }
    }
}
