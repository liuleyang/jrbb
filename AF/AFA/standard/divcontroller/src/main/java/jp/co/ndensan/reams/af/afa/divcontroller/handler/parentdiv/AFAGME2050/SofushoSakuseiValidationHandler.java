/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME2050;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2050.SofushoSakuseiDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 施設送付書発行のチェックロジックです。
 *
 * @reamsid_L AF-0250-010 jihb
 */
public class SofushoSakuseiValidationHandler {

    private final SofushoSakuseiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div SofushoSakuseiDiv
     */
    public SofushoSakuseiValidationHandler(SofushoSakuseiDiv div) {
        this.div = div;
    }

    /**
     * 実行ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate交付日開始と終了入力チェック() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new SofushoSakuseiValidator(div).validate交付日開始と終了入力チェック();
        validateResult.add(createDictionary().check(messages));
        return validateResult;
    }

    /**
     * 実行ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate交付日開始と終了の大小チェック() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new SofushoSakuseiValidator(div).validate交付日開始と終了の大小チェック();
        validateResult.add(createDictionary().check(messages));
        return validateResult;
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(SofushoSakuseiValidationMessage.交付日開始と終了入力チェック_開始は未入力, div.getSofushoSakuseiJoken().getTxtKofuYMD())
                .add(SofushoSakuseiValidationMessage.交付日開始と終了入力チェック_終了は未入力, div.getSofushoSakuseiJoken().getTxtKofuYMD())
                .add(SofushoSakuseiValidationMessage.交付日開始と終了大小関係が不正, div.getSofushoSakuseiJoken().getTxtKofuYMD())
                .build();
    }

}
