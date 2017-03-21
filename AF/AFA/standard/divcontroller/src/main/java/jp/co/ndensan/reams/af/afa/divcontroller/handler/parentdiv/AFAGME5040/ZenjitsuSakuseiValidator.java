/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME5040;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5040.ZenjitsuSakuseiDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 投票日前日関連帳票の入力チェッククラスです。
 *
 * @reamsid_L AF-0280-010 lit
 */
public class ZenjitsuSakuseiValidator implements IValidatable {

    private final ZenjitsuSakuseiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ZenjitsuSakuseiDiv
     */
    public ZenjitsuSakuseiValidator(ZenjitsuSakuseiDiv div) {
        this.div = div;
    }

    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(ZenjitsuSakuseiSpec.作成帳票が選択されていること)
                .thenAdd(ZenjitsuSakuseiValidationMessage.作成帳票必須)
                .ifNot(ZenjitsuSakuseiSpec.期日前投票が入力されていること)
                .thenAdd(ZenjitsuSakuseiValidationMessage.代理投票集計表必須)
                .ifNot(ZenjitsuSakuseiSpec.不在者投票が入力されていること)
                .thenAdd(ZenjitsuSakuseiValidationMessage.事務処理簿必須)
                .messages());

        return messages;
    }

}
