/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB1040;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB1040.RePrintSenkyojiDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 選挙時登録再発行のバリデーションです。
 *
 * @reamsid_L AF-0060-010 liss
 */
class RePrintSenkyojiValidator implements IValidatable {

    private final RePrintSenkyojiDiv div;

    RePrintSenkyojiValidator(RePrintSenkyojiDiv div) {
        this.div = div;
    }

    /**
     * 選挙時登録再発行のバリデーションです。
     *
     * @return バリデーションメッセージ
     */
    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(RePrintSenkyojiSpec.転入期間が入力されていること)
                .thenAdd(RePrintSenkyojiValidationMessage.転入期間必須)
                .ifNot(RePrintSenkyojiSpec.帰化期間が入力されていること)
                .thenAdd(RePrintSenkyojiValidationMessage.帰化期間必須)
                .ifNot(RePrintSenkyojiSpec.転出期間が入力されていること)
                .thenAdd(RePrintSenkyojiValidationMessage.転出期間必須)
                .ifNot(RePrintSenkyojiSpec.実行する時明細必須選択)
                .thenAdd(RePrintSenkyojiValidationMessage.必須項目を選択)
                .ifNot(RePrintSenkyojiSpec.実行する時作成帳票必須選択)
                .thenAdd(RePrintSenkyojiValidationMessage.作成帳票を選択)
                .messages());
        return messages;
    }

}
