/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMA1000;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SearchShikaku.ISearchShikakuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMA1000.SearchJuminDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaFinder.AtenaFinderDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.ChoikiInput.ChoikiInputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.GyoseikuInput.GyoseikuInputDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.binding.ViewControl;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * SearchJuminに対応するValidationHandlerクラスです。
 *
 * @reamsid_L AF-0230-020 qiuxy
 */
public class SearchJuminValidationHandler {

    private final SearchJuminDiv div;

    /**
     * コンストラクタです。
     *
     * @param div SearchJuminDiv
     */
    public SearchJuminValidationHandler(SearchJuminDiv div) {
        this.div = div;
    }

    /**
     * バリデーションの結果を返します。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate() {
        ValidationMessageControlPairs validResult = new ValidationMessageControlPairs();
        IValidationMessages message検索条件入力 = new SearchJuminValidationHandler.ControlValidator(div)
                .validResult検索条件入力();
        validResult.add(createDictionary().check(message検索条件入力));
        validResult.add(div.getSearchJoken().getCcdSearchTohyoShikaku().日期大小関係チェック());
        return validResult;
    }

    /**
     * バリデーションの結果を返します。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(ControlValidationMessage.検索条件未入力, getコントロール_チェック1())
                .add(ControlValidationMessage.検索条件未指定, getコントロール_チェック2())
                .build();
    }

    private List<ViewControl> getコントロール_チェック1() {
        List<ViewControl> コントロールList = new ArrayList<>();
        AtenaFinderDiv 宛名検索Div = (AtenaFinderDiv) div.getSearchJoken().getCcdSearchJukiJoho();
        ISearchShikakuDiv 資格検索Div = div.getSearchJoken().getCcdSearchTohyoShikaku();
        コントロールList.add(宛名検索Div.getTxtAtenaMeisho());
        コントロールList.add(宛名検索Div.getTxtSeinenGappi());
        コントロールList.add(get住所コントロール(宛名検索Div));
        コントロールList.add(宛名検索Div.getTxtShikibetsuCodeSub());
        コントロールList.add(宛名検索Div.getTxtSetaiCodeSub());
        コントロールList.add(資格検索Div.getCcdTohyokuCode().getTxtTohyokuCode());
        コントロールList.add(資格検索Div.getChkSearchTohyoShikaku());
        return コントロールList;
    }

    private List<ViewControl> getコントロール_チェック2() {
        List<ViewControl> コントロールList = new ArrayList<>();
        AtenaFinderDiv 宛名検索Div = (AtenaFinderDiv) div.getSearchJoken().getCcdSearchJukiJoho();
        ISearchShikakuDiv 資格検索Div = div.getSearchJoken().getCcdSearchTohyoShikaku();
        コントロールList.add(宛名検索Div.getTxtSeinenGappi());
        コントロールList.add(get住所コントロール(宛名検索Div));
        コントロールList.add(宛名検索Div.getTxtSetaiCodeSub());
        コントロールList.add(((GyoseikuInputDiv) 宛名検索Div.getCcdGyoseikuInputSub()).getTxtGyoseikuCode());
        コントロールList.add(資格検索Div.getCcdTohyokuCode().getTxtTohyokuCode());
        return コントロールList;
    }

    private ViewControl get住所コントロール(AtenaFinderDiv 宛名検索Div) {
        if (宛名検索Div.getRadJushoKensakuShuruiKubun().getSelectedIndex() == 0) {
            return ((ChoikiInputDiv) 宛名検索Div.getCcdChoikiInput()).getTxtChoikiCode();
        } else {
            return ((ChoikiInputDiv) 宛名検索Div.getCcdChoikiInput()).getTxtChoikiName();
        }
    }

    private static class ControlValidator {

        private final SearchJuminDiv div;

        public ControlValidator(SearchJuminDiv div) {
            this.div = div;
        }

        public IValidationMessages validResult検索条件入力() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(SearchJuminSpec.検索条件入力チェック)
                    .thenAdd(ControlValidationMessage.検索条件未入力)
                    .ifNot(SearchJuminSpec.検索条件入力チェック2)
                    .thenAdd(ControlValidationMessage.検索条件未指定)
                    .messages());
            return messages;
        }

    }

    private static enum ControlValidationMessage implements IValidationMessage {

        検索条件未入力(UrErrorMessages.未入力, "少なくとも１つの検索条件"),
        検索条件未指定(UrErrorMessages.未指定, "名称が2文字以下の場合は、他の検索条件も");
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
