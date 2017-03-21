/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMC2010;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMC2010.YubinShikakuTorokuDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 郵便等投票資格登録の実装クラス
 *
 * @reamsid_L AF-0200-010 liuj2
 */
public class _YubinShikakuTorokuErrorValidator implements IValidatable {

    private final YubinShikakuTorokuDiv div;

    /**
     * コンストラクタ
     *
     * @param div 郵便等投票資格登録のDiv
     */
    public _YubinShikakuTorokuErrorValidator(YubinShikakuTorokuDiv div) {
        this.div = div;
    }

    /**
     * バリデーション検証処理
     *
     * @return チェック結果
     */
    public IValidationMessages validate登録日() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(YubinShikakuTorokuSpec.登録日未入力).
                thenAdd(YubinShikakuTorokuValidationMessage.登録日未入力).
                messages()
        );
        return messages;
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
                ifNot(YubinShikakuTorokuSpec.資格条件を選択です).
                thenAdd(YubinShikakuTorokuValidationMessage.資格条件を選択です).
                ifNot(YubinShikakuTorokuSpec.登録日必須).
                thenAdd(YubinShikakuTorokuValidationMessage.登録日必須).
                ifNot(YubinShikakuTorokuSpec.交付日必須).
                thenAdd(YubinShikakuTorokuValidationMessage.交付日必須).
                ifNot(YubinShikakuTorokuSpec.満了日必須).
                thenAdd(YubinShikakuTorokuValidationMessage.満了日必須).
                ifNot(YubinShikakuTorokuSpec.抹消日必須).
                thenAdd(YubinShikakuTorokuValidationMessage.抹消日必須).
                ifNot(YubinShikakuTorokuSpec.事由を選択です).
                thenAdd(YubinShikakuTorokuValidationMessage.事由を選択です).
                messages()
        );
        return messages;
    }
}
