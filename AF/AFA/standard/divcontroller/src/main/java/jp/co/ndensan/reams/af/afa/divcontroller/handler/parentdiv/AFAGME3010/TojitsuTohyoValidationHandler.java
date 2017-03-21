/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME3010;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME3010.TojitsuTohyoJokyoDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 当日投票のValidationHandlerです。
 *
 * @reamsid_L AF-0260-010 liuyj
 */
public class TojitsuTohyoValidationHandler {

    private final TojitsuTohyoJokyoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div TojitsuTohyoDiv
     */
    public TojitsuTohyoValidationHandler(TojitsuTohyoJokyoDiv div) {
        this.div = div;

    }

    /**
     * ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate必須項目() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        TojitsuTohyoValidator validator = new TojitsuTohyoValidator(div);
        validateResult.add(createDictionary().check(validator.validate()));
        return validateResult;
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder().
                add(TojitsuTohyoValidationMessage.集計時間必須入力, div.getTxtTime()).
                build();
    }
}
