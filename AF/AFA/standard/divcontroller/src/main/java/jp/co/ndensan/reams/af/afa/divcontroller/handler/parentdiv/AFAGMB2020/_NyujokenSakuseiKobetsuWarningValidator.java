/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB2020;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB2020.NyujokenSakuseiKobetsuDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 *
 * @author LDNS GKJ
 */
public class _NyujokenSakuseiKobetsuWarningValidator implements IValidatable {

    private final NyujokenSakuseiKobetsuDiv div;

    _NyujokenSakuseiKobetsuWarningValidator(NyujokenSakuseiKobetsuDiv div) {
        this.div = div;
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
                ifNot(NyujokenSakuseiKobetsuSpec.選挙バッチ実行確認のチェック).
                thenAdd(NyujokenSakuseiKobetsuValidationMessage.選挙バッチ実行確認のチェック).
                messages()
        );
        return messages;
    }
}
