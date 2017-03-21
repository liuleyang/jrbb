/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME5010;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5010.TachiaishoSakuseiDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * AFAGME5010 立会人引継書のの入力チェッククラスです。
 *
 * @reamsid_L AF-0120-010 xul
 */
public class TachiaishoSakuseiValidator implements IValidatable {

    private final TachiaishoSakuseiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div TachiaishoSakuseiDiv
     */
    public TachiaishoSakuseiValidator(TachiaishoSakuseiDiv div) {
        this.div = div;
    }

    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(TachiaishoSakuseiSpec.抄本データドロップダウン未入力)
                .thenAdd(TachiaishoSakuseiValidationMessage.抄本データドロップダウン未入力)
                .ifNot(TachiaishoSakuseiSpec.期日前投票日未入力)
                .thenAdd(TachiaishoSakuseiValidationMessage.期日前投票日未入力)
                .ifNot(TachiaishoSakuseiSpec.選挙名未入力)
                .thenAdd(TachiaishoSakuseiValidationMessage.選挙名未入力)
                .ifNot(TachiaishoSakuseiSpec.期日前投票所未入力)
                .thenAdd(TachiaishoSakuseiValidationMessage.期日前投票所未入力)
                .messages());
        return messages;
    }

    /**
     * バリデーションの結果を返します。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public IValidationMessages validate_引継内容詳細() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(TachiaishoSakuseiSpec.立会人氏名)
                .thenAdd(TachiaishoSakuseiValidationMessage.立会人氏名)
                .ifNot(TachiaishoSakuseiSpec.立会時間)
                .thenAdd(TachiaishoSakuseiValidationMessage.立会時間)
                .messages());
        return messages;
    }
}
