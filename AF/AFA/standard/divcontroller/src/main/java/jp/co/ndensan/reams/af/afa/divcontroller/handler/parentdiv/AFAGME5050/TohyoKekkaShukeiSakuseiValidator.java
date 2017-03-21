/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME5050;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5050.TohyoKekkaShukeiSakuseiDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 投票結果集計表の入力チェッククラスです。
 *
 * @reamsid_L AF-0290-010 lit
 */
public class TohyoKekkaShukeiSakuseiValidator implements IValidatable {

    private final TohyoKekkaShukeiSakuseiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div TohyoKekkaShukeiSakuseiDiv
     */
    public TohyoKekkaShukeiSakuseiValidator(TohyoKekkaShukeiSakuseiDiv div) {
        this.div = div;
    }

    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(TohyoKekkaShukeiSakuseiSpec.作成帳票が選択されていること)
                .thenAdd(TohyoKekkaShukeiSakuseiValidationMessage.作成帳票必須)
                .messages());

        return messages;
    }

}
