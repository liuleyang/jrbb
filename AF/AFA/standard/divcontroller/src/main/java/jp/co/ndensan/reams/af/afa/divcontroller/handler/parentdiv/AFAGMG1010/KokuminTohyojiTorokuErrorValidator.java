/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMG1010;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMG1010.KokuminTohyojiTorokuDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 国民投票時登録のバリデーションです。
 *
 * @reamsid_L AF-0360-010 fulc
 */
public class KokuminTohyojiTorokuErrorValidator implements IValidatable {

    private final KokuminTohyojiTorokuDiv div;

    KokuminTohyojiTorokuErrorValidator(KokuminTohyojiTorokuDiv div) {
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
                ifNot(KokuminTohyojiTorokuSpec.改正案と略称の両方が空白かつ実データ).
                thenAdd(KokuminTohyojiTorokuValidationMessage.改正案と略称の両方が空白かつ実データ).
                ifNot(KokuminTohyojiTorokuSpec.改正案一覧グリッドに改正案と略称は片方のみの入力場合).
                thenAdd(KokuminTohyojiTorokuValidationMessage.改正案一覧グリッドに改正案と略称は片方のみの入力場合).
                ifNot(KokuminTohyojiTorokuSpec.新規の時改正案一覧グリッドに1件も明細に入力がない場合).
                thenAdd(KokuminTohyojiTorokuValidationMessage.新規の時改正案一覧グリッドに1件も明細に入力がない場合).
                messages()
        );
        return messages;
    }
}
