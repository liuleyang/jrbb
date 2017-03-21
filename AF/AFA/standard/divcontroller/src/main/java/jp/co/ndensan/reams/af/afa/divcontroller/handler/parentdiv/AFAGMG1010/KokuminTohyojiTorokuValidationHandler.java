/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMG1010;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMG1010.KokuminTohyojiTorokuDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 国民投票時登録のValidationHandlerです。
 *
 * @reamsid_L AF-0360-010 fulc
 */
public class KokuminTohyojiTorokuValidationHandler {

    private final KokuminTohyojiTorokuDiv div;

    /**
     * コンストラクタ生成
     *
     * @param div KokuminTohyojiTorokuDiv
     *
     */
    public KokuminTohyojiTorokuValidationHandler(KokuminTohyojiTorokuDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ生成
     *
     * @param div KokuminTohyojiTorokuDiv
     * @return KokuminTohyojiTorokuValidationHandler
     */
    public static KokuminTohyojiTorokuValidationHandler of(KokuminTohyojiTorokuDiv div) {
        return new KokuminTohyojiTorokuValidationHandler(div);
    }

    /**
     * 国民投票時登録の入力項目をvalidate
     *
     * @return validateResult
     */
    public ValidationMessageControlPairs validateエラーチェックです() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        KokuminTohyojiTorokuErrorValidator validator = new KokuminTohyojiTorokuErrorValidator(div);
        validateResult.add(createErrorDictionary().check(validator.validate()));
        return validateResult;
    }

    private ValidationDictionary createErrorDictionary() {
        return new ValidationDictionaryBuilder().
                add(KokuminTohyojiTorokuValidationMessage.改正案と略称の両方が空白かつ実データ, div.getKokuminTohyojiNyuryoku().getDgKokuminTohyojiNyuryoku()).
                add(KokuminTohyojiTorokuValidationMessage.改正案一覧グリッドに改正案と略称は片方のみの入力場合, div.getKokuminTohyojiNyuryoku().getDgKokuminTohyojiNyuryoku()).
                add(KokuminTohyojiTorokuValidationMessage.新規の時改正案一覧グリッドに1件も明細に入力がない場合, div.getKokuminTohyojiNyuryoku().getDgKokuminTohyojiNyuryoku()).
                build();
    }

    /**
     * 国民投票時登録の入力項目をvalidate
     *
     * @return validateResult
     */
    public ValidationMessageControlPairs validateウォーニングチェックです() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        KokuminTohyojiTorokuWarningValidator validator = new KokuminTohyojiTorokuWarningValidator(div);
        validateResult.add(createWarningDictionary().check(validator.validate()));
        return validateResult;
    }

    private ValidationDictionary createWarningDictionary() {
        return new ValidationDictionaryBuilder().
                add(KokuminTohyojiTorokuValidationMessage.選挙バッチ実行確認のチェック).
                build();
    }

}
