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
 * 入場券発行（個別）のチェック操作を担当するクラスです。
 *
 * @reamsid_L AF-0170-010 jihb
 */
public class _NyujokenSakuseiKobetsuErrorValidator implements IValidatable {

    private final NyujokenSakuseiKobetsuDiv div;

    _NyujokenSakuseiKobetsuErrorValidator(NyujokenSakuseiKobetsuDiv div) {
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
                ifNot(NyujokenSakuseiKobetsuSpec.印刷タイプのチェック).
                thenAdd(NyujokenSakuseiKobetsuValidationMessage.印刷タイプのチェック).
                ifNot(NyujokenSakuseiKobetsuSpec.世帯印字人数のチェック).
                thenAdd(NyujokenSakuseiKobetsuValidationMessage.世帯印字人数のチェック).
                ifNot(NyujokenSakuseiKobetsuSpec.選挙人一覧のチェック).
                thenAdd(NyujokenSakuseiKobetsuValidationMessage.選挙人一覧のチェック).
                ifNot(NyujokenSakuseiKobetsuSpec.同一世帯の人が複数選択のチェック).
                thenAdd(NyujokenSakuseiKobetsuValidationMessage.同一世帯の人が複数選択のチェック).
                messages()
        );
        return messages;
    }
}
