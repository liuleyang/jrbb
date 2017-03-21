/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB1020;

import jp.co.ndensan.reams.af.afa.definition.senkyojohoshusei.SenkyoJohoShuseiValidationMessage;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB1020.SenkyoJohoShuseiDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 選挙修正のバリデーションです。
 *
 */
public class _SenkyoJohoShuseiValidator implements IValidatable {

    private final SenkyoJohoShuseiDiv div;

    _SenkyoJohoShuseiValidator(SenkyoJohoShuseiDiv div) {
        this.div = div;
    }

    /**
     * 選挙修正の選挙追加のバリデーションです。
     *
     * @return バリデーションメッセージ
     */
    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(SenkyoJohoShuseiSpec.選挙追加の選挙レベル必須チェック).
                thenAdd(SenkyoJohoShuseiValidationMessage.選挙レベル入力確認).
                ifNot(SenkyoJohoShuseiSpec.選挙追加の選挙名必須チェック).
                thenAdd(SenkyoJohoShuseiValidationMessage.選挙名入力確認).
                ifNot(SenkyoJohoShuseiSpec.選挙追加の選挙略称必須チェック).
                thenAdd(SenkyoJohoShuseiValidationMessage.選挙略称入力確認).
                ifNot(SenkyoJohoShuseiSpec.選挙追加の選挙マーク必須チェック).
                thenAdd(SenkyoJohoShuseiValidationMessage.選挙マーク入力確認).
                ifNot(SenkyoJohoShuseiSpec.選挙追加の基準日必須チェック).
                thenAdd(SenkyoJohoShuseiValidationMessage.基準日入力確認).
                ifNot(SenkyoJohoShuseiSpec.選挙追加の受付開始日必須チェック).
                thenAdd(SenkyoJohoShuseiValidationMessage.受付開始日入力確認).
                ifNot(SenkyoJohoShuseiSpec.選挙追加の基準日と投票日関連チェック).
                thenAdd(SenkyoJohoShuseiValidationMessage.選挙追加の基準日は投票日より前の日を設定).
                ifNot(SenkyoJohoShuseiSpec.選挙追加の基準日と受付開始日関連チェック).
                thenAdd(SenkyoJohoShuseiValidationMessage.選挙追加の基準日は受付開始日より前の日を設定).
                ifNot(SenkyoJohoShuseiSpec.選挙追加の受付開始日と投票日関連チェック).
                thenAdd(SenkyoJohoShuseiValidationMessage.選挙追加の投票日は受付開始日より後の日を設定).
                messages());
        return messages;
    }

    /**
     * 選挙修正の保存のバリデーションです。
     *
     * @return バリデーションメッセージ
     */
    public IValidationMessages validateForUpdate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(SenkyoJohoShuseiSpec.抄本名必須入力チェック).
                thenAdd(SenkyoJohoShuseiValidationMessage.抄本名入力確認).
                ifNot(SenkyoJohoShuseiSpec.選挙名必須入力チェック).
                thenAdd(SenkyoJohoShuseiValidationMessage.選挙名入力確認).
                ifNot(SenkyoJohoShuseiSpec.選挙略称必須入力チェック).
                thenAdd(SenkyoJohoShuseiValidationMessage.選挙略称入力確認).
                ifNot(SenkyoJohoShuseiSpec.選挙マーク必須入力チェック).
                thenAdd(SenkyoJohoShuseiValidationMessage.選挙マーク入力確認).
                messages());
        return messages;
    }

    /**
     * 選挙修正の選挙追加のバリデーションです（シミュレーションの場合）。
     *
     * @return バリデーションメッセージ
     */
    public IValidationMessages validateSimulation() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(SenkyoJohoShuseiSpec.選挙追加の選挙レベル必須チェック).
                thenAdd(SenkyoJohoShuseiValidationMessage.選挙レベル入力確認).
                ifNot(SenkyoJohoShuseiSpec.選挙追加の選挙名必須チェック).
                thenAdd(SenkyoJohoShuseiValidationMessage.選挙名入力確認).
                ifNot(SenkyoJohoShuseiSpec.選挙追加の選挙略称必須チェック).
                thenAdd(SenkyoJohoShuseiValidationMessage.選挙略称入力確認).
                ifNot(SenkyoJohoShuseiSpec.選挙追加の選挙マーク必須チェック).
                thenAdd(SenkyoJohoShuseiValidationMessage.選挙マーク入力確認).
                ifNot(SenkyoJohoShuseiSpec.選挙追加の基準日必須チェック).
                thenAdd(SenkyoJohoShuseiValidationMessage.基準日入力確認).
                ifNot(SenkyoJohoShuseiSpec.選挙追加の受付開始日必須チェック).
                thenAdd(SenkyoJohoShuseiValidationMessage.受付開始日入力確認).
                ifNot(SenkyoJohoShuseiSpec.選挙追加の基準日と投票日関連チェック).
                thenAdd(SenkyoJohoShuseiValidationMessage.選挙追加の基準日は投票日より前の日を設定).
                ifNot(SenkyoJohoShuseiSpec.選挙追加の受付開始日と投票日関連チェック).
                thenAdd(SenkyoJohoShuseiValidationMessage.選挙追加の投票日は受付開始日より後の日を設定).
                messages());
        return messages;
    }

    /**
     * 選挙修正一覧の選挙追加のバリデーションです。
     *
     * @return バリデーションメッセージ
     */
    public IValidationMessages validateForSenkyoAdd() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(SenkyoJohoShuseiSpec.最大登録選挙数のチェック).
                thenAdd(SenkyoJohoShuseiValidationMessage.最大登録選挙数確認).
                messages());
        return messages;
    }

}
