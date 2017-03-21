/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB2010;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB2010.NyujokenSakuseiIkkatsuDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 入場券発行（一括）
 *
 * @reamsid_L AF-0160-010 guyq
 */
public class _NyujokenSakuseiIkkatsuWarningValidator implements IValidatable {

    private final NyujokenSakuseiIkkatsuDiv div;

    _NyujokenSakuseiIkkatsuWarningValidator(NyujokenSakuseiIkkatsuDiv div) {
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
                ifNot(NyujokenSakuseiIkkatsuSpec.選挙バッチ実行確認のチェック).
                thenAdd(NyujokenSakuseiIkkatsuValidationMessage.選挙バッチ実行確認のチェック).
                messages()
        );
        return messages;
    }
}
