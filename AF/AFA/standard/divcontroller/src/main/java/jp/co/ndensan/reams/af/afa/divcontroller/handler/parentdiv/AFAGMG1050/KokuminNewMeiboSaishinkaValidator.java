/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMG1050;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMG1050.KokuminNewMeiboSaishinkaDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 投票人名簿最新化のクラス
 *
 * @reamsid_L AF-0390-010 jihb
 */
public class KokuminNewMeiboSaishinkaValidator implements IValidatable {

    private final KokuminNewMeiboSaishinkaDiv div;

    KokuminNewMeiboSaishinkaValidator(KokuminNewMeiboSaishinkaDiv div) {
        this.div = div;
    }

    /**
     * バリデーション検証処理
     *
     * @return チェック結果
     */
    public IValidationMessages validate抄本() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(KokuminNewMeiboSaishinkaSpec.抄本選択チェック).
                thenAdd(KokuminNewMeiboSaishinkaValidationMessage.抄本選択チェック).
                messages()
        );
        return messages;
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
                ifNot(KokuminNewMeiboSaishinkaSpec.投票状況存在チェック).
                thenAdd(KokuminNewMeiboSaishinkaValidationMessage.投票状況存在チェック).
                messages()
        );
        return messages;
    }
}
