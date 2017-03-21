/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMG1010;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMG1010.KokuminTohyojiTorokuDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 国民投票時登録のバリデーションです。
 *
 * @reamsid_L AF-0360-010 fulc
 */
public class KokuminTohyojiTorokuWarningValidator implements IValidatable {

    private final KokuminTohyojiTorokuDiv div;

    KokuminTohyojiTorokuWarningValidator(KokuminTohyojiTorokuDiv div) {
        this.div = div;

    }

    /**
     * バリデーション検証処理
     *
     * @return チェック結果
     */
    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(KokuminTohyojiTorokuSpec.選挙バッチ実行確認のチェック).
                thenAdd(KokuminTohyojiTorokuValidationMessage.選挙バッチ実行確認のチェック).
                messages()
        );
        return messages;
    }
}
