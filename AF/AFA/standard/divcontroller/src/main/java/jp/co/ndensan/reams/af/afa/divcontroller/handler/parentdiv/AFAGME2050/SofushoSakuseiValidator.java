/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME2050;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2050.SofushoSakuseiDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 施設送付書発行のチェックロジックです。
 *
 * @reamsid_L AF-0250-010 jihb
 */
public class SofushoSakuseiValidator {

    private final SofushoSakuseiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div SofushoSakuseiDiv
     */
    public SofushoSakuseiValidator(SofushoSakuseiDiv div) {
        this.div = div;
    }

    /**
     * 開始だけ入力、終了は未入力　或は　終了だけ入力、開始は未入力の場合,バリデーションです。
     *
     * @return バリデーションメッセージ
     */
    public IValidationMessages validate交付日開始と終了入力チェック() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(SofushoSakuseiSpec.交付日開始と終了入力チェック_開始は未入力)
                .thenAdd(SofushoSakuseiValidationMessage.交付日開始と終了入力チェック_開始は未入力)
                .ifNot(SofushoSakuseiSpec.交付日開始と終了入力チェック_終了は未入力)
                .thenAdd(SofushoSakuseiValidationMessage.交付日開始と終了入力チェック_終了は未入力)
                .messages());
        return messages;
    }

    /**
     * 交付日開始～終了の大小チェック
     *
     * @return バリデーションメッセージ
     */
    public IValidationMessages validate交付日開始と終了の大小チェック() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(SofushoSakuseiSpec.交付日開始と終了大小チェック)
                .thenAdd(SofushoSakuseiValidationMessage.交付日開始と終了大小関係が不正)
                .messages());

        return messages;
    }

}
