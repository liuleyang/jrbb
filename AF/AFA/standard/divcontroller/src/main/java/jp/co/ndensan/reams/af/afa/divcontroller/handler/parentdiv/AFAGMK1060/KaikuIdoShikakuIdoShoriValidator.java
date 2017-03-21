/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMK1060;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMK1060.KaikuIdoShikakuIdoShoriDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * AFAGMK1060 海区漁業調整委員会委員選挙人名簿登録 <br />
 *
 * @reamsid_L AF-0500-010 zhanggs
 */
public class KaikuIdoShikakuIdoShoriValidator implements IValidatable {

    private final KaikuIdoShikakuIdoShoriDiv div;

    /**
     * コンストラクタ
     *
     * @param div 海区漁業調整委員会委員選挙人名簿登録のDiv
     */
    public KaikuIdoShikakuIdoShoriValidator(KaikuIdoShikakuIdoShoriDiv div) {
        this.div = div;
    }

    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(KaikuIdoShikakuIdoShoriSpec.選択された識別コードでデータの存在チェック)
                .thenAdd(KaikuIdoShikakuIdoShoriValidatorMessage.保存データの存在チェック)
                .ifNot(KaikuIdoShikakuIdoShoriSpec.選択した抄本内で_選択された識別コードでデータの存在チェック)
                .thenAdd(KaikuIdoShikakuIdoShoriValidatorMessage.修正削除データの存在チェック)
                .messages()
        );
        return messages;
    }

}
