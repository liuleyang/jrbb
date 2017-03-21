/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMI1010;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMI1010.JuminTohyojiTorokuDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 住民投票時登録
 *
 * @reamsid_L AF-0450-010 lis
 */
public class JuminTohyojiTorokuValidator implements IValidatable {

    private final JuminTohyojiTorokuDiv div;

    /**
     * コンストラクタ
     *
     * @param div 住民投票時登録のDiv
     */
    public JuminTohyojiTorokuValidator(JuminTohyojiTorokuDiv div) {
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
                ifNot(JuminTohyojiTorokuSpec.抄本未選択).
                thenAdd(JuminTohyojiTorokuValidationMessage.抄本未選択).
                ifNot(JuminTohyojiTorokuSpec.転出日未入力).
                thenAdd(JuminTohyojiTorokuValidationMessage.転出日未入力).
                ifNot(JuminTohyojiTorokuSpec.転入日未入力).
                thenAdd(JuminTohyojiTorokuValidationMessage.転入日未入力).
                ifNot(JuminTohyojiTorokuSpec.住定期間未入力).
                thenAdd(JuminTohyojiTorokuValidationMessage.住定期間未入力).
                ifNot(JuminTohyojiTorokuSpec.居住年数未入力).
                thenAdd(JuminTohyojiTorokuValidationMessage.居住年数未入力).
                ifNot(JuminTohyojiTorokuSpec.住定期間大小).
                thenAdd(JuminTohyojiTorokuValidationMessage.住定期間大小関係が不正).
                messages()
        );
        return messages;
    }
}
