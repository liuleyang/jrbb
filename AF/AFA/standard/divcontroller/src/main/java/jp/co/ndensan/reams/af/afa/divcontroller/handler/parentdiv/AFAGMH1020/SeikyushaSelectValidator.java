/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMH1020;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMH1020.SeikyushaSelectDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 請求代表者選択のValidator
 *
 * @reamsid_L AF-0140-020 wangh
 */
public class SeikyushaSelectValidator implements IValidatable {

    private final SeikyushaSelectDiv div;

    SeikyushaSelectValidator(SeikyushaSelectDiv div) {
        this.div = div;
    }

    /**
     * 「署名簿を作成する」ボタンを押下の検証処理
     *
     * @return チェック結果
     */
    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(SeikyushaSelectSpec.提出期限日チェック).
                thenAdd(SeikyushaSelectValidationMessage.提出期限日チェック).
                messages());
        return messages;
    }
}
