/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME1020;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME1020.LabelSealRePrintDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * ラベルシール再印刷のValidator
 *
 * @reamsid_L AF-0620-014 jihb
 */
public class LabelSealRePrintValidator implements IValidatable {

    private final LabelSealRePrintDiv div;

    LabelSealRePrintValidator(LabelSealRePrintDiv div) {
        this.div = div;
    }

    /**
     * 一括交付者を検索するボタンを押下の検証処理
     *
     * @return チェック結果
     */
    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(LabelSealRePrintSpec.施設コードの入力チェック_未入力).
                thenAdd(LabelSealRePrintValidationMessage.施設コードの入力チェック_未入力).
                messages());
        return messages;
    }

    /**
     * 実行するボタンを押下の検証処理
     *
     * @return チェック結果
     */
    public IValidationMessages validate2() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(LabelSealRePrintSpec.選挙人一覧データチェック_データなし).
                thenAdd(LabelSealRePrintValidationMessage.選挙人一覧データチェック_データなし).
                ifNot(LabelSealRePrintSpec.選挙人一覧選択チェック_選択しなし).
                thenAdd(LabelSealRePrintValidationMessage.選挙人一覧選択チェック_選択しなし).
                ifNot(LabelSealRePrintSpec.開始印字位置選択チェック_選択しなし).
                thenAdd(LabelSealRePrintValidationMessage.開始印字位置選択チェック_選択しなし).
                messages());
        return messages;
    }
}
