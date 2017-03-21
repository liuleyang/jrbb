/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminTaishoShohonJoho;

import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 国民投票抄本情報共有子DIVのValidationHandlerです。
 *
 * @reamsid_L AF-0360-010 fulc
 */
public class KokuminTaishoShohonJohoValidationHandler {

    private final KokuminTaishoShohonJohoDiv div;

    /**
     * コンストラクタ生成
     *
     * @param div KokuminTaishoShohonJohoDiv
     *
     */
    public KokuminTaishoShohonJohoValidationHandler(KokuminTaishoShohonJohoDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ生成
     *
     * @param div KokuminTaishoShohonJohoDiv
     * @return KokuminTaishoShohonJohoValidationHandler
     */
    public static KokuminTaishoShohonJohoValidationHandler of(KokuminTaishoShohonJohoDiv div) {
        return new KokuminTaishoShohonJohoValidationHandler(div);
    }

    /**
     * 国民投票時登録の入力項目をvalidate
     *
     * @return validateResult
     */
    public ValidationMessageControlPairs validateエラーチェックです() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        KokuminTaishoShohonJohoErrorValidator validator = new KokuminTaishoShohonJohoErrorValidator(div);
        validateResult.add(createErrorDictionary().check(validator.validate()));
        return validateResult;
    }

    private ValidationDictionary createErrorDictionary() {
        return new ValidationDictionaryBuilder().
                add(KokuminTaishoShohonJohoValidationMessage.受付開始日と投票日の大小関係が不正, div.getTxtTohyoUketsukeYMD()).
                add(KokuminTaishoShohonJohoValidationMessage.基準日と受付開始日の大小関係が不正, div.getTxtTohyoUketsukeYMD()).
                add(KokuminTaishoShohonJohoValidationMessage.基準日と投票日の大小関係が不正, div.getTxtKijunYMD()).
                add(KokuminTaishoShohonJohoValidationMessage.基準日と特定期限日間の大小関係が不正, div.getTxtTokuteiKigenYMD()).
                add(KokuminTaishoShohonJohoValidationMessage.対象の抄本の入場券が発行済の場合, div.getRadShori()).
                build();
    }

    /**
     * 国民投票時登録の入力項目をvalidate
     *
     * @return validateResult
     */
    public ValidationMessageControlPairs validateウォーニングチェックです() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        KokuminTaishoShohonJohoWarningValidator validator = new KokuminTaishoShohonJohoWarningValidator(div);
        validateResult.add(createWarningDictionary().check(validator.validate()));
        return validateResult;
    }

    private ValidationDictionary createWarningDictionary() {
        return new ValidationDictionaryBuilder().
                add(KokuminTaishoShohonJohoValidationMessage.同一投票日で既に抄本が存在しています).
                build();
    }

}
