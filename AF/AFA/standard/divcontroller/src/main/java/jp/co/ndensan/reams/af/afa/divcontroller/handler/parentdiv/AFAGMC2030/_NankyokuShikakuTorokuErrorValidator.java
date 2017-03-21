/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMC2030;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMC2030.NankyokuShikakuTorokuDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 洋上投票資格登録の実装クラス
 *
 * @reamsid_L AF-0220-010 guyq
 */
public class _NankyokuShikakuTorokuErrorValidator implements IValidatable {

    private final NankyokuShikakuTorokuDiv div;

    /**
     * コンストラクタ
     *
     * @param div 郵便等投票資格登録のDiv
     */
    public _NankyokuShikakuTorokuErrorValidator(NankyokuShikakuTorokuDiv div) {
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
                ifNot(NankyokuShikakuTorokuSpec.登録日必須).
                thenAdd(NankyokuShikakuTorokuValidationMessage.登録日必須).
                ifNot(NankyokuShikakuTorokuSpec.交付日必須).
                thenAdd(NankyokuShikakuTorokuValidationMessage.交付日必須).
                ifNot(NankyokuShikakuTorokuSpec.有効期限日必須).
                thenAdd(NankyokuShikakuTorokuValidationMessage.有効期限日必須).
                ifNot(NankyokuShikakuTorokuSpec.抹消日必須).
                thenAdd(NankyokuShikakuTorokuValidationMessage.抹消日必須).
                ifNot(NankyokuShikakuTorokuSpec.事由を選択です).
                thenAdd(NankyokuShikakuTorokuValidationMessage.事由を選択です).
                messages()
        );
        return messages;
    }
}
