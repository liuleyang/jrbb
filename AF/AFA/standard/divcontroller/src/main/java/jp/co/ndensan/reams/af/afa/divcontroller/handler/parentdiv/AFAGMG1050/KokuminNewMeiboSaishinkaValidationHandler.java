/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMG1050;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMG1050.KokuminNewMeiboSaishinkaDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 投票人名簿最新化のクラス
 *
 * @reamsid_L AF-0390-010 jihb
 */
public class KokuminNewMeiboSaishinkaValidationHandler {

    private final KokuminNewMeiboSaishinkaDiv div;

    /**
     * コンストラクタ生成
     *
     * @param div KokuminNewMeiboSaishinkaDiv
     *
     */
    public KokuminNewMeiboSaishinkaValidationHandler(KokuminNewMeiboSaishinkaDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ生成
     *
     * @param div KokuminNewMeiboSaishinkaDiv
     * @return KokuminNewMeiboSaishinkaValidationHandler
     */
    public static KokuminNewMeiboSaishinkaValidationHandler of(KokuminNewMeiboSaishinkaDiv div) {
        return new KokuminNewMeiboSaishinkaValidationHandler(div);
    }

    /**
     * 投票人名簿最新化の入力項目をvalidate
     *
     * @return validateResult
     */
    public ValidationMessageControlPairs validate抄本() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new KokuminNewMeiboSaishinkaValidator(div).validate抄本();
        validateResult.add(createDictionary().check(messages));

        return validateResult;
    }

    /**
     * 投票人名簿最新化の入力項目をvalidate
     *
     * @return validateResult
     */
    public ValidationMessageControlPairs validate投票状況存在() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new KokuminNewMeiboSaishinkaValidator(div).validate();
        validateResult.add(createDictionary().check(messages));

        return validateResult;
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(KokuminNewMeiboSaishinkaValidationMessage.抄本選択チェック, div.getKokuminNewShohonSelect())
                .add(KokuminNewMeiboSaishinkaValidationMessage.投票状況存在チェック, div.getKokuminNewShohonSelect())
                .build();
    }
}
