/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMF1020;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMF1020.SaibaninTorikomiDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 裁判員候補者予定者取込のバリデーションハンドラです。
 *
 * @reamsid_L AF-0310-010 guancy
 */
public class SaibaninTorikomiValidationHandler {

    private final SaibaninTorikomiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div SaibaninTorikomiDiv
     */
    public SaibaninTorikomiValidationHandler(SaibaninTorikomiDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ生成
     *
     * @param div 裁判員候補者予定者取込のDiv
     * @return 裁判員候補者予定者取込のハンドラ
     */
    public static SaibaninTorikomiValidationHandler of(SaibaninTorikomiDiv div) {
        return new SaibaninTorikomiValidationHandler(div);
    }

    /**
     * validateチェックです
     *
     * @return チェック結果
     */
    public ValidationMessageControlPairs validateチェック() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new SaibaninTorikomiValidator(div).validate();
        validateResult.add(createErrorDictionary().check(messages));
        return validateResult;
    }

    private ValidationDictionary createErrorDictionary() {
        return new ValidationDictionaryBuilder()
                .add(SaibaninTorikomiValidationMessage.ファイル再登録確認,
                        div.getUplSaibaninTorikomiFileSelect())
                .add(SaibaninTorikomiValidationMessage.情報存在チェック,
                        div.getUplSaibaninTorikomiFileSelect())
                .add(SaibaninTorikomiValidationMessage.データ数が不正,
                        div.getUplSaibaninTorikomiFileSelect())
                .add(SaibaninTorikomiValidationMessage.項目数が不正,
                        div.getUplSaibaninTorikomiFileSelect())
                .build();
    }
}
