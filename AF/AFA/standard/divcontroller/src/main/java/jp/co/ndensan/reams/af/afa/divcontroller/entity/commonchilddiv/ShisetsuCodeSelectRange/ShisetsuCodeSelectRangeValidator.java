/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShisetsuCodeSelectRange;

import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * ShisetsuCodeSelectRangeDivの入力チェッククラスです。
 *
 * @reamsid_L AF-0270-012 xul
 */
public class ShisetsuCodeSelectRangeValidator implements IValidatable {

    private final ShisetsuCodeSelectRangeDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ShisetsuCodeSelectRangeDiv
     */
    public ShisetsuCodeSelectRangeValidator(ShisetsuCodeSelectRangeDiv div) {
        this.div = div;
    }

    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(ShisetsuCodeSelectRangeSpec.施設コード開始と終了の大小関係チェック)
                .thenAdd(ShisetsuCodeSelectRangeValidationMessage.施設コード範囲)
                .ifNot(ShisetsuCodeSelectRangeSpec.施設コード開始の入力関係チェック)
                .thenAdd(ShisetsuCodeSelectRangeValidationMessage.施設コード開始入力)
                .ifNot(ShisetsuCodeSelectRangeSpec.施設コード終了の入力関係チェック)
                .thenAdd(ShisetsuCodeSelectRangeValidationMessage.施設コード終了入力)
                .messages());

        return messages;
    }

}
