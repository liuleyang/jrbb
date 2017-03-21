/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMG1060;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMG1060.RePrintKokuminDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 国民投票帳票再発行のクラス
 *
 * @reamsid_L AF-0400-010 guancy
 */
public class RePrintKokuminValidator implements IValidatable {

    private final RePrintKokuminDiv div;

    RePrintKokuminValidator(RePrintKokuminDiv div) {
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
                ifNot(RePrintKokuminSpec.抄本選択チェック).
                thenAdd(RePrintKokuminValidationMessage.抄本選択チェック).
                ifNot(RePrintKokuminSpec.出力対象選択チェック).
                thenAdd(RePrintKokuminValidationMessage.出力対象選択チェック).
                ifNot(RePrintKokuminSpec.登録者の時点チェック).
                thenAdd(RePrintKokuminValidationMessage.登録者の時点チェック).
                messages()
        );
        return messages;
    }

}
