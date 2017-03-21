/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMH1030;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMH1030.SeikyuShomeiboTorokuDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 署名簿登録のチェック操作を担当するクラスです。
 *
 * @reamsid_L AF-0150-010 wangh
 */
public class SeikyuShomeiboTorokuValidator implements IValidatable {

    private final SeikyuShomeiboTorokuDiv div;

    SeikyuShomeiboTorokuValidator(SeikyuShomeiboTorokuDiv div) {
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
                ifNot(SeikyuShomeiboTorokuSpec.署名状況無効事由相関チェック).
                thenAdd(SeikyuShomeiboTorokuValidationMessage.署名状況に無効を選択した無効事由未入力エラー).
                messages());
        return messages;
    }

}
