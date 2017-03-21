/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMK1040;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMK1040.KaikuNewMeiboSaishinkaDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * AFAGMK1040 海区漁業調整委員会委員選挙人名簿最新化Validator <br />
 *
 * @reamsid_L AF-0480-010 liuj
 */
public class KaikuNewMeiboSaishinkaValidator implements IValidatable {

    private final KaikuNewMeiboSaishinkaDiv div;

    /**
     * コンストラクタ
     *
     * @param div 海区漁業調整委員会委員選挙人名簿最新化のDiv
     */
    public KaikuNewMeiboSaishinkaValidator(KaikuNewMeiboSaishinkaDiv div) {
        this.div = div;
    }

    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(KaikuNewMeiboSaishinkaSpec.抄本選択チェック).
                thenAdd(KaikuNewMeiboSaishinkaValidationMessage.抄本選択チェック).
                ifNot(KaikuNewMeiboSaishinkaSpec.投票状況存在チェック).
                thenAdd(KaikuNewMeiboSaishinkaValidationMessage.投票状況存在チェック).messages());
        return messages;
    }

}
