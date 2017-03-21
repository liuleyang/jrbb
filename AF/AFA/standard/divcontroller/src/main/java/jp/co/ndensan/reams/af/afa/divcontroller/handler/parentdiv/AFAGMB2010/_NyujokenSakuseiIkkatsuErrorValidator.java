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
 * 入場券発行（一括）のチェック操作を担当するクラスです。
 *
 * @reamsid_L AF-0160-010 guyq
 */
public class _NyujokenSakuseiIkkatsuErrorValidator implements IValidatable {

    private final NyujokenSakuseiIkkatsuDiv div;

    _NyujokenSakuseiIkkatsuErrorValidator(NyujokenSakuseiIkkatsuDiv div) {
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
                ifNot(NyujokenSakuseiIkkatsuSpec.出力対象のチェック).
                thenAdd(NyujokenSakuseiIkkatsuValidationMessage.出力対象のチェック).
                ifNot(NyujokenSakuseiIkkatsuSpec.印刷タイプのチェック).
                thenAdd(NyujokenSakuseiIkkatsuValidationMessage.印刷タイプのチェック).
                ifNot(NyujokenSakuseiIkkatsuSpec.世帯印字人数のチェック).
                thenAdd(NyujokenSakuseiIkkatsuValidationMessage.世帯印字人数のチェック).
                ifNot(NyujokenSakuseiIkkatsuSpec.投票区一覧のチェック).
                thenAdd(NyujokenSakuseiIkkatsuValidationMessage.投票区一覧のチェック).
                ifNot(NyujokenSakuseiIkkatsuSpec.転出日From不正のチェック).
                thenAdd(NyujokenSakuseiIkkatsuValidationMessage.転出日From不正のチェック).
                ifNot(NyujokenSakuseiIkkatsuSpec.転出日To不正のチェック).
                thenAdd(NyujokenSakuseiIkkatsuValidationMessage.転出日To不正のチェック).
                ifNot(NyujokenSakuseiIkkatsuSpec.抽出対象世帯人数のチェック).
                thenAdd(NyujokenSakuseiIkkatsuValidationMessage.抽出対象世帯人数のチェック).
                messages()
        );
        return messages;
    }
}
