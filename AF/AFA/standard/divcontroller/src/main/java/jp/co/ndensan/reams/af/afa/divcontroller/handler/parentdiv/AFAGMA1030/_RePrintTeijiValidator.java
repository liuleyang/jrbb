/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMA1030;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMA1030.RePrintTeijiDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 定時登録再発行のバリデーションです。
 *
 * @reamsid_L AF-0020-010 gaoya
 */
class _RePrintTeijiValidator implements IValidatable {

    private final RePrintTeijiDiv div;

    _RePrintTeijiValidator(RePrintTeijiDiv div) {
        this.div = div;
    }

    /**
     * 定時登録再発行のバリデーションです。
     *
     * @return バリデーションメッセージ
     */
    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(RePrintTeijilSpec.実行する時明細必須選択).
                thenAdd(RePrintTeijiValidationMessage.必須項目を選択).
                ifNot(RePrintTeijilSpec.実行する時作成帳票必須選択).
                thenAdd(RePrintTeijiValidationMessage.作成帳票を選択).
                messages());
        return messages;
    }

}
