/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMC2020;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMC2020.SeninShikakuTorokuDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 洋上投票資格登録の実装クラス
 *
 * @reamsid_L AF-0210-010 liuj2
 */
public class _SeninShikakuTorokuErrorValidator implements IValidatable {

    private final SeninShikakuTorokuDiv div;

    /**
     * コンストラクタ
     *
     * @param div 郵便等投票資格登録のDiv
     */
    public _SeninShikakuTorokuErrorValidator(SeninShikakuTorokuDiv div) {
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
                ifNot(SeninShikakuTorokuSpec.登録日必須).
                thenAdd(SeninShikakuTorokuValidationMessage.登録日必須).
                ifNot(SeninShikakuTorokuSpec.交付日必須).
                thenAdd(SeninShikakuTorokuValidationMessage.交付日必須).
                ifNot(SeninShikakuTorokuSpec.有効期限日必須).
                thenAdd(SeninShikakuTorokuValidationMessage.有効期限日必須).
                ifNot(SeninShikakuTorokuSpec.抹消日必須).
                thenAdd(SeninShikakuTorokuValidationMessage.抹消日必須).
                ifNot(SeninShikakuTorokuSpec.事由を選択です).
                thenAdd(SeninShikakuTorokuValidationMessage.事由を選択です).
                messages()
        );
        return messages;
    }
}
