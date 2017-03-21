/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMF1020;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMF1020.SaibaninTorikomiDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 裁判員候補者予定者取込
 *
 * @reamsid_L AF-0310-010 guancy
 */
public class SaibaninTorikomiValidator implements IValidatable {

    private final SaibaninTorikomiDiv div;

    /**
     * コンストラクタ
     *
     * @param div 裁判員候補者予定者取込のDiv
     */
    public SaibaninTorikomiValidator(SaibaninTorikomiDiv div) {
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
                ifNot(SaibaninTorikomiSpec.ファイル再登録チェック).
                thenAdd(SaibaninTorikomiValidationMessage.ファイル再登録確認).
                ifNot(SaibaninTorikomiSpec.ファイルデータ数チェック).
                thenAdd(SaibaninTorikomiValidationMessage.データ数が不正).
                ifNot(SaibaninTorikomiSpec.ファイル項目数チェック).
                thenAdd(SaibaninTorikomiValidationMessage.項目数が不正).
                ifNot(SaibaninTorikomiSpec.情報存在チェック).
                thenAdd(SaibaninTorikomiValidationMessage.情報存在チェック).
                messages()
        );
        return messages;
    }
}
