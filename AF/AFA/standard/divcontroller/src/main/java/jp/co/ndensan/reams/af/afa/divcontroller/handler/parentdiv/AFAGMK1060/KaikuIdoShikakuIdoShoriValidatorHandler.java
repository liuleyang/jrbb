/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMK1060;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMK1060.KaikuIdoShikakuIdoShoriDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * AFAGMK1060 海区漁業調整委員会委員選挙人名簿登録 <br />
 *
 * @reamsid_L AF-0500-010 zhanggs
 */
public class KaikuIdoShikakuIdoShoriValidatorHandler {

    private final KaikuIdoShikakuIdoShoriDiv div;

    /**
     * コンストラクタです。
     *
     * @param div KaikuIdoShikakuIdoShoriDiv
     */
    public KaikuIdoShikakuIdoShoriValidatorHandler(KaikuIdoShikakuIdoShoriDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ生成
     *
     * @param div 海区漁業調整委員会委員選挙人名簿登録のDiv
     * @return 海区漁業調整委員会委員選挙人名簿登録のハンドラ
     */
    public static KaikuIdoShikakuIdoShoriValidatorHandler of(KaikuIdoShikakuIdoShoriDiv div) {
        return new KaikuIdoShikakuIdoShoriValidatorHandler(div);
    }

    /**
     * validateチェックです
     *
     * @return チェック結果
     */
    public ValidationMessageControlPairs validate保存データチェック() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new KaikuIdoShikakuIdoShoriValidator(div).validate();
        validateResult.add(createErrorDictionary_保存データ().check(messages));
        return validateResult;
    }

    private ValidationDictionary createErrorDictionary_保存データ() {
        return new ValidationDictionaryBuilder().
                add(KaikuIdoShikakuIdoShoriValidatorMessage.保存データの存在チェック).
                build();
    }

    /**
     * validateチェックです
     *
     * @return チェック結果
     */
    public ValidationMessageControlPairs validate修正削除データチェック() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new KaikuIdoShikakuIdoShoriValidator(div).validate();
        validateResult.add(createErrorDictionary_修正削除データ().check(messages));
        return validateResult;
    }

    private ValidationDictionary createErrorDictionary_修正削除データ() {
        return new ValidationDictionaryBuilder().
                add(KaikuIdoShikakuIdoShoriValidatorMessage.修正削除データの存在チェック).
                build();
    }
}
