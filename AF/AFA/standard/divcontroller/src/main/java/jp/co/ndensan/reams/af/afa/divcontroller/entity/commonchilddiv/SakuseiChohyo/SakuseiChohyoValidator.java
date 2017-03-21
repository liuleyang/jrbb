/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SakuseiChohyo;

import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 *
 * 作成帳票共有子DIVのValidatorクラス
 */
public class SakuseiChohyoValidator implements IValidatable {

    private final SakuseiChohyoDiv div;

    public SakuseiChohyoValidator(SakuseiChohyoDiv div) {
        this.div = div;
    }

    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(SakuseiChohyoSpec.二重登録通知_転入期間).
                thenAdd(SakuseiChohyoValidationMessage.二重登録通知_転入期間).
                ifNot(SakuseiChohyoSpec.帰化期間).
                thenAdd(SakuseiChohyoValidationMessage.帰化期間).
                ifNot(SakuseiChohyoSpec.二重登録調査票_転出期間).
                thenAdd(SakuseiChohyoValidationMessage.二重登録調査票_転出期間).
                ifNot(SakuseiChohyoSpec.永久選挙人名簿_出力条件).
                thenAdd(SakuseiChohyoValidationMessage.永久選挙人名簿_出力条件).
                messages());
        return messages;
    }
}
