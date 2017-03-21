/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME8010;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME8010.TakeOutPcDataCreateDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 住民投票時登録
 *
 * @reamsid_L AF-0790-010 wanghj
 */
public class TakeOutPcDataCreateValidator implements IValidatable {

    private final TakeOutPcDataCreateDiv div;

    /**
     * コンストラクタ
     *
     * @param div 住民投票時登録のDiv
     */
    public TakeOutPcDataCreateValidator(TakeOutPcDataCreateDiv div) {
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
                ifNot(TakeOutPcDataCreateSpec.処理の続行確認).
                thenAdd(TakeOutPcDataCreateValidationMessage.処理の続行確認).
                ifNot(TakeOutPcDataCreateSpec.投票日前日確認).
                thenAdd(TakeOutPcDataCreateValidationMessage.投票日前日確認).
                messages()
        );
        return messages;
    }
}
