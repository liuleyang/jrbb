/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyoJokyoNyuryoku;

import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * TohyoJokyoNyuryokuDiv のチェック操作を担当するクラスです。
 *
 * @reamsid_L AF-0070-014 liss
 */
public class TohyoJokyoNyuryokuValidator implements IValidatable {

    private final TohyoJokyoNyuryokuDiv div;
    private final RString パタン;

    /**
     * コンストラクタです。
     *
     * @param div TohyoJokyoNyuryokuDiv
     * @param パタン RString
     */
    public TohyoJokyoNyuryokuValidator(TohyoJokyoNyuryokuDiv div, RString パタン) {
        this.div = div;
        this.パタン = パタン;
    }

    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        if (パタン.equals(new RString("グリッドチェック"))) {
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(TohyoJokyoNyuryokuSpec.グリッドが選択されていること)
                    .thenAdd(TohyoJokyoNyuryokuValidationMessage.グリッド選択必須)
                    .messages());
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(TohyoJokyoNyuryokuSpec.投票事由コードが存在されていること)
                    .thenAdd(TohyoJokyoNyuryokuValidationMessage.投票事由コード存在)
                    .messages());
        } else if (パタン.equals(new RString("受付拒否"))) {
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(TohyoJokyoNyuryokuSpec.拒否事由が入力されていること)
                    .thenAdd(TohyoJokyoNyuryokuValidationMessage.拒否事由必須)
                    .messages());
        } else {
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(TohyoJokyoNyuryokuSpec.投票日付が正確)
                    .thenAdd(TohyoJokyoNyuryokuValidationMessage.投票日時制約)
                    .messages());
        }

        return messages;

    }
}
