/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMK1010;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMK1010.KaikuMeiboSakuseiDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 選挙人当初登録のバリデーションハンドラです。
 *
 * @reamsid_L AF-0460-010 liuyj
 */
public class KaikuMeiboSakuseiValidator implements IValidatable {

    private final KaikuMeiboSakuseiDiv div;

    /**
     * コンストラクタ
     *
     * @param div 海区漁業調整委員会委員選挙人名簿のDiv
     */
    public KaikuMeiboSakuseiValidator(KaikuMeiboSakuseiDiv div) {
        this.div = div;
    }

    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(KaikuMeiboSakuseiSpec.名簿確定日非自動算出日付)
                .thenAdd(KaikuMeiboSakuseiValidationWarningMessage.名簿確定日自動算出日付の確認)
                .ifNot(KaikuMeiboSakuseiSpec.年齢到達日非自動算出日付)
                .thenAdd(KaikuMeiboSakuseiValidationWarningMessage.年齢到達日自動算出日付の確認)
                .messages()
        );
        return messages;
    }
}
