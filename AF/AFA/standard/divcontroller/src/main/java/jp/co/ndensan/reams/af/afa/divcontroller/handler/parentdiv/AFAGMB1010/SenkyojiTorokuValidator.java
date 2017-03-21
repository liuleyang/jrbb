/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB1010;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB1010.SenkyojiTorokuDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 選挙時登録の入力チェッククラスです。
 *
 * @reamsid_L AF-0030-010 liss
 */
public class SenkyojiTorokuValidator implements IValidatable {

    private final SenkyojiTorokuDiv div;
    private final RString パタン;

    /**
     * コンストラクタです。
     *
     * @param div SenkyojiTorokuDiv
     * @param パタン RString
     */
    public SenkyojiTorokuValidator(SenkyojiTorokuDiv div, RString パタン) {
        this.div = div;
        this.パタン = パタン;
    }

    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        if (パタン.equals(new RString("帳票の条件を設定する"))) {
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(SenkyojiTorokuSpec.レベルが入力されていること)
                    .thenAdd(SenkyojiTorokuValidationMessage.レベル必須)
                    .ifNot(SenkyojiTorokuSpec.選挙名が入力されていること)
                    .thenAdd(SenkyojiTorokuValidationMessage.選挙名必須)
                    .ifNot(SenkyojiTorokuSpec.略名が入力されていること)
                    .thenAdd(SenkyojiTorokuValidationMessage.略名必須)
                    .ifNot(SenkyojiTorokuSpec.マークが入力されていること)
                    .thenAdd(SenkyojiTorokuValidationMessage.マーク必須)
//                    .ifNot(SenkyojiTorokuSpec.基準日が入力されていること)
//                    .thenAdd(SenkyojiTorokuValidationMessage.基準日必須)
                    .ifNot(SenkyojiTorokuSpec.受付開始日が入力されていること)
                    .thenAdd(SenkyojiTorokuValidationMessage.受付開始日必須)
                    .messages());
        } else if (パタン.equals(new RString("実行"))) {
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(SenkyojiTorokuSpec.抄本名が入力されていること)
                    .thenAdd(SenkyojiTorokuValidationMessage.抄本名必須)
                    .ifNot(SenkyojiTorokuSpec.投票日が入力されていること)
                    .thenAdd(SenkyojiTorokuValidationMessage.投票日必須)
                    .ifNot(SenkyojiTorokuSpec.年齢期限が入力されていること)
                    .thenAdd(SenkyojiTorokuValidationMessage.年齢期限必須)
                    .ifNot(SenkyojiTorokuSpec.転入期間が入力されていること)
                    .thenAdd(SenkyojiTorokuValidationMessage.転入期間必須)
                    .ifNot(SenkyojiTorokuSpec.帰化期間が入力されていること)
                    .thenAdd(SenkyojiTorokuValidationMessage.帰化期間必須)
                    .ifNot(SenkyojiTorokuSpec.転出期間が入力されていること)
                    .thenAdd(SenkyojiTorokuValidationMessage.転出期間必須)
                    .ifNot(SenkyojiTorokuSpec.レベルが入力されていること)
                    .thenAdd(SenkyojiTorokuValidationMessage.レベル必須)
                    .ifNot(SenkyojiTorokuSpec.選挙名が入力されていること)
                    .thenAdd(SenkyojiTorokuValidationMessage.選挙名必須)
                    .ifNot(SenkyojiTorokuSpec.略名が入力されていること)
                    .thenAdd(SenkyojiTorokuValidationMessage.略名必須)
                    .ifNot(SenkyojiTorokuSpec.マークが入力されていること)
                    .thenAdd(SenkyojiTorokuValidationMessage.マーク必須)
                    .ifNot(SenkyojiTorokuSpec.基準日が入力されていること)
                    .thenAdd(SenkyojiTorokuValidationMessage.基準日必須)
                    .ifNot(SenkyojiTorokuSpec.受付開始日が入力されていること)
                    .thenAdd(SenkyojiTorokuValidationMessage.受付開始日必須)
                    .messages());
            if (messages.getSize() == 0) {
                messages.add(ValidateChain.validateStart(div)
                        .ifNot(SenkyojiTorokuSpec.基準日が投票日より前のこと)
                        .thenAdd(SenkyojiTorokuValidationMessage.基準日確認1)
                        .ifNot(SenkyojiTorokuSpec.基準日が受付開始日より前のこと)
                        .thenAdd(SenkyojiTorokuValidationMessage.基準日確認2)
                        .ifNot(SenkyojiTorokuSpec.受付開始日が投票日より前のこと)
                        .thenAdd(SenkyojiTorokuValidationMessage.交付日確認)
                        .ifNot(SenkyojiTorokuSpec.入場券が発行済のこと)
                        .thenAdd(SenkyojiTorokuValidationMessage.再作成処理不可)
                        .messages());
            }
        } else {
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(SenkyojiTorokuSpec.基準日が入力されていること)
                    .thenAdd(SenkyojiTorokuValidationMessage.基準日必須)
                    .messages());
        }
        return messages;
    }

}
