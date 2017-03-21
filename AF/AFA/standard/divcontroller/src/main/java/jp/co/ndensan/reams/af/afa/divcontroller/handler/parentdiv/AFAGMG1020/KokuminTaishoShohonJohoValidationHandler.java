/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMG1020;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMG1020.KokuminTohyoJohoShuseiDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 国民投票情報修正のバリデーションハンドラです。
 *
 * @reamsid_L AF-0370-010 lis
 */
public class KokuminTaishoShohonJohoValidationHandler {

    private final KokuminTohyoJohoShuseiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div KokuminTohyoJohoShuseiDiv
     */
    public KokuminTaishoShohonJohoValidationHandler(KokuminTohyoJohoShuseiDiv div) {
        this.div = div;
    }

    /**
     * 選挙保存関連チェックです。
     *
     * @return バリデーションメッセージコントロールペア
     */
    public ValidationMessageControlPairs updateValidate関連チェック() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        _KokuminTaishoShohonJohoValidator validator = new _KokuminTaishoShohonJohoValidator(div);
        validateResult.add(createDictionaryForUpdate().check(validator.validate()));
        return validateResult;
    }

    private ValidationDictionary createDictionaryForUpdate() {

        return new ValidationDictionaryBuilder().
                add(KokuminTaishoShohonJohoValidationMessage.改正案入力確認, div.getKokuminShusei().getDgKokuminShusei()).
                add(KokuminTaishoShohonJohoValidationMessage.略称入力確認, div.getKokuminShusei().getDgKokuminShusei()).
                build();
    }
}
