/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME4020;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME4020.BarCodeTojitsuDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * AFAGME4020 不在者投票のの入力チェッククラスです。
 *
 * @reamsid_L AF-0115-010 xul
 */
public class BarCodeTojitsuValidator implements IValidatable {

    private final BarCodeTojitsuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div BarCodeTojitsuDiv
     */
    public BarCodeTojitsuValidator(BarCodeTojitsuDiv div) {
        this.div = div;
    }

    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(BarCodeTojitsuSpec.入場券確認チェック)
                .thenAdd(BarCodeTojitsuValidationMessage.入場券確認)
                .messages());
        return messages;
    }

    /**
     * ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public IValidationMessages validateバーコード重複() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(BarCodeTojitsuSpec.バーコード重複チェック)
                .thenAdd(BarCodeTojitsuValidationMessage.読込済み確認)
                .messages());
        return messages;
    }

    /**
     * ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public IValidationMessages validate投票資格() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(BarCodeTojitsuSpec.投票資格チェック)
                .thenAdd(BarCodeTojitsuValidationMessage.投票資格チェック)
                .messages());
        return messages;
    }

    /**
     * ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public IValidationMessages validResult件数() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(BarCodeTojitsuSpec.件数チェック)
                .thenAdd(BarCodeTojitsuValidationMessage.対象データなし_追加メッセージあり)
                .messages());
        return messages;
    }
}
