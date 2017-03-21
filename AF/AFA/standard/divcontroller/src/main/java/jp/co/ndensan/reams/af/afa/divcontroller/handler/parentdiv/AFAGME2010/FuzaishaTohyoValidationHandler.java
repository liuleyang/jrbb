/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME2010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.fuzaishatohyo.SenkyoninSearchResult;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2010.FuzaishaTohyoDiv;
import jp.co.ndensan.reams.af.afa.service.fuzaishatohyo.FuzaishaTohyoValidationService;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.binding.ViewControl;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 不在者投票のValidationHandlerです。
 *
 * @reamsid_L AF-0130-010 lit
 */
public class FuzaishaTohyoValidationHandler {

    private final FuzaishaTohyoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div FuzaishaTohyoDiv
     */
    public FuzaishaTohyoValidationHandler(FuzaishaTohyoDiv div) {
        this.div = div;
    }

    /**
     * ボタンクリック時のバリデーションチェックです。
     *
     * @param button パタン
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate(Enum button) {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new FuzaishaTohyoValidator(div, button).validate();
        validateResult.add(createDictionary(button).check(messages));

        return validateResult;
    }

    /**
     * ボタンクリック時のバリデーションチェックです。
     *
     * @param 選挙人リスト List<SenkyoninSearchResult>
     * @param 投票年月日 FlexibleDate
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate各種チェック(List<SenkyoninSearchResult> 選挙人リスト, FlexibleDate 投票年月日) {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = FuzaishaTohyoValidationService.createInstance().validate各種チェック(選挙人リスト, 投票年月日);

        if (null != messages) {
            for (IValidationMessage message : messages.getList()) {
                validateResult.add(this.validateカスタマイズチェック(message));
            }
        }
        return validateResult;
    }

    /**
     * ボタンクリック時のバリデーションチェックです。
     *
     * @param 選挙人リスト List<SenkyoninSearchResult>
     * @param 投票年月日 FlexibleDate
     * @return バリデーション突合結果
     */
    public IValidationMessages validate確認チェック(List<SenkyoninSearchResult> 選挙人リスト, FlexibleDate 投票年月日) {
        IValidationMessages messages = FuzaishaTohyoValidationService.createInstance().validate確認チェック(選挙人リスト, 投票年月日);
        return null == messages ? ValidationMessagesFactory.createInstance() : messages;
    }

    private ValidationDictionary createDictionary(Enum button) {
        if (button.name().equals(FuzaishaTohyoHandler.GamenButton.選挙人を選択する.name())) {
            return new ValidationDictionaryBuilder()
                    .add(FuzaishaTohyoValidationMessage.施設存在しない, get施設()).build();

        } else if (button.name().equals(FuzaishaTohyoHandler.GamenButton.入場券バーコード.name())) {
            return new ValidationDictionaryBuilder()
                    .add(FuzaishaTohyoValidationMessage.入場券確認, get入場券())
                    .add(FuzaishaTohyoValidationMessage.対象データなし_追加メッセージあり, get入場券())
                    .build();

        } else if (button.name().equals(FuzaishaTohyoHandler.GamenButton.選挙人を検索する.name())) {
            return new ValidationDictionaryBuilder()
                    .add(FuzaishaTohyoValidationMessage.対象データなし_追加メッセージあり).build();
        } else if (button.name().equals(FuzaishaTohyoHandler.GamenButton.投票を受け付ける.name())) {
            return new ValidationDictionaryBuilder()
                    .add(FuzaishaTohyoValidationMessage.対象選挙必須, getDataGrid())
                    .add(FuzaishaTohyoValidationMessage.交付日確認１, get交付日())
                    .add(FuzaishaTohyoValidationMessage.交付日確認２, get受理日())
                    .build();
        } else if (button.name().equals(FuzaishaTohyoHandler.GamenButton.投票情報を入力する.name())) {
            return new ValidationDictionaryBuilder()
                    .add(FuzaishaTohyoValidationMessage.選挙人未指定, getDataGrid()).build();
        }
        return new ValidationDictionaryBuilder().build();
    }

    private List<ViewControl> get施設() {
        List<ViewControl> viewControls = new ArrayList();
        viewControls.add(div.getFuzaishaJohoSearch().getCcdShisetsuCode().getTxtShisetsuCode());
        return viewControls;
    }

    private List<ViewControl> get入場券() {
        List<ViewControl> viewControls = new ArrayList();
        viewControls.add(div.getFuzaishaSenkyoninSearch().getCcdFuzaishaBarCode().getTxtBarCode());
        return viewControls;
    }

    private List<ViewControl> get交付日() {
        List<ViewControl> viewControls = new ArrayList();
        viewControls.add(div.getFuzaishaTohyoJokyo().getFuzaishaKofuJoho().getTxtKofuYMD());
        return viewControls;
    }

    private List<ViewControl> get受理日() {
        List<ViewControl> viewControls = new ArrayList();
        viewControls.add(div.getFuzaishaTohyoJokyo().getFuzaishaJuriJoho().getTxtJuriYMD());
        return viewControls;
    }

    private List<ViewControl> getDataGrid() {
        List<ViewControl> viewControls = new ArrayList();
        viewControls.add(div.getFuzaishaTohyoJokyo().getDgFuzaishaTohyoJokyo());
        return viewControls;
    }

    /**
     * ボタンクリック時のバリデーションチェックです。
     *
     * @param msg メッセージ
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validateカスタマイズチェック(IValidationMessage msg) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        List<ViewControl> viewControls = new ArrayList();
        ValidationDictionary dictionary = new ValidationDictionaryBuilder().add(msg, viewControls).build();
        messages.add(msg);

        return dictionary.check(messages);

    }

}
