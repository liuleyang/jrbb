/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB6030;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME6030.SealShisetsuDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 開始印字位置未入力のチェック
 *
 * @reamsid_L AF-0620-010 xul
 */
public class SealShisetsuValidator implements IValidatable {

    private final SealShisetsuDiv div;

    /**
     * コンストラクタ
     *
     * @param div SealShisetsuDiv
     */
    public SealShisetsuValidator(SealShisetsuDiv div) {
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
                ifNot(SealShisetsuSpec.開始印字位置未入力).
                thenAdd(SealShisetsuValidationMessage.開始印字位置未入力).messages());
        return messages;
    }
}
