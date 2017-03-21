/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelectRange;

import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * TohyokuCodeSelectRangeDivの入力チェッククラスです。
 *
 * @reamsid_L AF-0270-013 xul
 */
public class TohyokuCodeSelectRangeValidator implements IValidatable {

    private final TohyokuCodeSelectRangeDiv div;

    /**
     * コンストラクタです。
     *
     * @param div TohyokuCodeSelectRangeDiv
     */
    public TohyokuCodeSelectRangeValidator(TohyokuCodeSelectRangeDiv div) {
        this.div = div;
    }

    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(TohyokuCodeSelectRangeSpec.投票区コード開始と終了の大小関係チェック)
                .thenAdd(TohyokuCodeSelectRangeValidationMessage.投票区コード範囲)
                .ifNot(TohyokuCodeSelectRangeSpec.投票区コード開始の入力関係チェック)
                .thenAdd(TohyokuCodeSelectRangeValidationMessage.投票区コード開始入力)
                .ifNot(TohyokuCodeSelectRangeSpec.投票区コード終了の入力関係チェック)
                .thenAdd(TohyokuCodeSelectRangeValidationMessage.投票区コード終了入力)
                .messages());

        return messages;
    }

}
