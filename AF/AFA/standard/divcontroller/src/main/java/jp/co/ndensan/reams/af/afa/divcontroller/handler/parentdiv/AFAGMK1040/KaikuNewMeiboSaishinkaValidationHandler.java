/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMK1040;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMK1040.KaikuNewMeiboSaishinkaDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * AFAGMK1040 海区漁業調整委員会委員選挙人名簿最新化ValidatorHandler <br />
 *
 * @reamsid_L AF-0480-010 liuj
 */
public class KaikuNewMeiboSaishinkaValidationHandler {

    private final KaikuNewMeiboSaishinkaDiv div;

    /**
     * コンストラクタです。
     *
     * @param div KaikuNewMeiboSaishinkaDiv
     */
    public KaikuNewMeiboSaishinkaValidationHandler(KaikuNewMeiboSaishinkaDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ生成
     *
     * @param div 海区漁業調整委員会委員選挙人名簿最新化のDiv
     * @return 海区漁業調整委員会委員選挙人名簿最新化のハンドラ
     */
    public static KaikuNewMeiboSaishinkaValidationHandler of(KaikuNewMeiboSaishinkaDiv div) {
        return new KaikuNewMeiboSaishinkaValidationHandler(div);
    }

    /**
     * validateチェックです
     *
     * @return チェック結果
     */
    public ValidationMessageControlPairs validateチェック() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new KaikuNewMeiboSaishinkaValidator(div).validate();
        validateResult.add(createErrorDictionary().check(messages));
        return validateResult;
    }

    private ValidationDictionary createErrorDictionary() {
        return new ValidationDictionaryBuilder().
                add(KaikuNewMeiboSaishinkaValidationMessage.抄本選択チェック).
                add(KaikuNewMeiboSaishinkaValidationMessage.投票状況存在チェック).
                build();
    }
}
