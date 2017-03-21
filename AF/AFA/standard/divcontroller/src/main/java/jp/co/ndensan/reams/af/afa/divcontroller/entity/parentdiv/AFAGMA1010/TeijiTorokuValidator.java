/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMA1010;

import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 定時登録のValidatorクラス
 *
 */
public class TeijiTorokuValidator implements IValidatable {

    private final TeijiTorokuDiv div;
    private final Boolean is実行;
    private final Boolean isError;

    public TeijiTorokuValidator(TeijiTorokuDiv div, Boolean is実行, Boolean isError) {
        this.div = div;
        this.is実行 = is実行;
        this.isError = isError;
    }

    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        if (!is実行) {
            messages.add(ValidateChain.validateStart(div).
                    ifNot(TeijiTorokuSpec.基準日必須入力).
                    thenAdd(TeijiTorokuValidationMessage.基準日必須項目を入力).
                    ifNot(TeijiTorokuSpec.転出期限必須入力).
                    thenAdd(TeijiTorokuValidationMessage.転出期限必須項目を入力).
                    ifNot(TeijiTorokuSpec.登録日必須入力).
                    thenAdd(TeijiTorokuValidationMessage.登録日必須項目を入力).
                    ifNot(TeijiTorokuSpec.転入期限必須入力).
                    thenAdd(TeijiTorokuValidationMessage.転入期限必須項目を入力).
                    ifNot(TeijiTorokuSpec.年齢期限必須入力).
                    thenAdd(TeijiTorokuValidationMessage.年齢期限必須項目を入力).
                    messages()
            );
        } else {
            if (isError) {
                messages.add(ValidateChain.validateStart(div).
                        ifNot(TeijiTorokuSpec.基準日必須入力).
                        thenAdd(TeijiTorokuValidationMessage.基準日必須項目を入力).
                        ifNot(TeijiTorokuSpec.転出期限必須入力).
                        thenAdd(TeijiTorokuValidationMessage.転出期限必須項目を入力).
                        ifNot(TeijiTorokuSpec.登録日必須入力).
                        thenAdd(TeijiTorokuValidationMessage.登録日必須項目を入力).
                        ifNot(TeijiTorokuSpec.転入期限必須入力).
                        thenAdd(TeijiTorokuValidationMessage.転入期限必須項目を入力).
                        ifNot(TeijiTorokuSpec.年齢期限必須入力).
                        thenAdd(TeijiTorokuValidationMessage.年齢期限必須項目を入力).
                        ifNot(TeijiTorokuSpec.基準日と登録日の関係性チェック).
                        thenAdd(TeijiTorokuValidationMessage.基準日と登録日の関係性チェック).
                        ifNot(TeijiTorokuSpec.未来基準日抄本確認).
                        thenAdd(TeijiTorokuValidationMessage.未来基準日抄本確認).
                        ifNot(TeijiTorokuSpec.定時未実施確認).
                        thenAdd(TeijiTorokuValidationMessage.定時未実施確認).
                        ifNot(TeijiTorokuSpec.同一基準日抄本確認).
                        thenAdd(TeijiTorokuValidationMessage.同一基準日抄本確認).
                        ifNot(TeijiTorokuSpec.過去抄本再処理確認).
                        thenAdd(TeijiTorokuValidationMessage.過去抄本再処理確認).
                        messages());
            } else {
                messages.add(ValidateChain.validateStart(div).
                        ifNot(TeijiTorokuSpec.年齢期限日と基準日の関係性チェック).
                        thenAdd(TeijiTorokuValidationMessage.年齢期限日と基準日の関係性チェック).
                        ifNot(TeijiTorokuSpec.転出期限と基準日の関係性チェック).
                        thenAdd(TeijiTorokuValidationMessage.転出期限と基準日の関係性チェック).
                        ifNot(TeijiTorokuSpec.転入期限と基準日の関係性チェック).
                        thenAdd(TeijiTorokuValidationMessage.転入期限と基準日の関係性チェック).
                        ifNot(TeijiTorokuSpec.転出期限と転入期限の関係性チェック).
                        thenAdd(TeijiTorokuValidationMessage.転出期限と転入期限の関係性チェック).
                        messages());
            }
        }
        return messages;
    }

}
