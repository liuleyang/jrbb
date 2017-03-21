/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME2010;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2010.FuzaishaTohyoDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * AFAGME2010 不在者投票のの入力チェッククラスです。
 *
 * @reamsid_L AF-0080-010 lit
 */
public class FuzaishaTohyoValidator implements IValidatable {

    private final FuzaishaTohyoDiv div;
    private final Enum button;

    /**
     * コンストラクタです。
     *
     * @param div FuzaishaTohyoDiv
     * @param button Enum
     */
    public FuzaishaTohyoValidator(FuzaishaTohyoDiv div, Enum button) {
        this.div = div;
        this.button = button;
    }

    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        if (button.name().equals(FuzaishaTohyoHandler.GamenButton.選挙人を選択する.name())) {
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(FuzaishaTohyoSpec.施設コード有無チェック)
                    .thenAdd(FuzaishaTohyoValidationMessage.施設存在しない)
                    .messages());

        } else if (button.name().equals(FuzaishaTohyoHandler.GamenButton.入場券バーコード.name())) {
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(FuzaishaTohyoSpec.入場券確認チェック)
                    .thenAdd(FuzaishaTohyoValidationMessage.入場券確認)
                    .messages());

        } else if (button.name().equals(FuzaishaTohyoHandler.GamenButton.投票を受け付ける.name())) {
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(FuzaishaTohyoSpec.グリッドの選択チェック)
                    .thenAdd(FuzaishaTohyoValidationMessage.対象選挙必須)
                    .ifNot(FuzaishaTohyoSpec.交付日と請求日の相関性チェック)
                    .thenAdd(FuzaishaTohyoValidationMessage.交付日確認１)
                    .ifNot(FuzaishaTohyoSpec.交付日と受理日の相関性チェック)
                    .thenAdd(FuzaishaTohyoValidationMessage.交付日確認２)
                    .messages());
        } else if (button.name().equals(FuzaishaTohyoHandler.GamenButton.投票情報を入力する.name())) {
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(FuzaishaTohyoSpec.選挙人なしチェック)
                    .thenAdd(FuzaishaTohyoValidationMessage.選挙人未指定)
                    .messages());
        }

        return messages;
    }

}
