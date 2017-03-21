/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShikakuJoho;

import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * ShikakuJohoDiv のチェックロジックです。
 *
 * @reamsid_L AF-0180-015 lis2
 */
public class ShikakuJohoErrorValidator {

    private final ShikakuJohoDiv div;

    /**
     * コンストラクタ
     *
     * @param div 郵便等投票資格登録のDiv
     */
    public ShikakuJohoErrorValidator(ShikakuJohoDiv div) {
        this.div = div;
    }

    /**
     * 表示日・表示事由のチェック
     *
     * @return チェック結果
     */
    public IValidationMessages validate表示日と表示事由() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(ShikakuJohoSpec.表示日と表示事由のチェック1).
                thenAdd(ShikakuJohoValidationMessage.表示日と表示事由のチェック1).
                ifNot(ShikakuJohoSpec.表示日と表示事由のチェック2).
                thenAdd(ShikakuJohoValidationMessage.表示日と表示事由のチェック2).
                messages()
        );
        return messages;
    }

    /**
     * 登録停止者変更時のチェック
     *
     * @return チェック結果
     */
    public IValidationMessages validate登録停止者変更時() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(ShikakuJohoSpec.登録停止者変更時のチェック).
                thenAdd(ShikakuJohoValidationMessage.登録停止者変更時のチェック).
                ifNot(ShikakuJohoSpec.登録停止日と登録停止事由のチェック1).
                thenAdd(ShikakuJohoValidationMessage.登録停止日と登録停止事由のチェック1).
                ifNot(ShikakuJohoSpec.登録停止日と登録停止事由のチェック2).
                thenAdd(ShikakuJohoValidationMessage.登録停止日と登録停止事由のチェック2).
                ifNot(ShikakuJohoSpec.登録停止事由と表示事由のチェック).
                thenAdd(ShikakuJohoValidationMessage.登録停止事由と表示事由のチェック).
                messages()
        );
        return messages;
    }

    /**
     * 表示消除予定年月日チェック
     *
     * @return チェック結果
     */
    public IValidationMessages validate表示消除予定年月日() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(ShikakuJohoSpec.表示消除予定日と表示日のチェック).
                thenAdd(ShikakuJohoValidationMessage.表示消除予定日と表示日のチェック).
                ifNot(ShikakuJohoSpec.表示消除予定日と表示事由のチェック１).
                thenAdd(ShikakuJohoValidationMessage.表示消除予定日と表示事由のチェック１).
                ifNot(ShikakuJohoSpec.表示消除予定日と表示事由のチェック２).
                thenAdd(ShikakuJohoValidationMessage.表示消除予定日と表示事由のチェック２).
                ifNot(ShikakuJohoSpec.表示消除予定日と名簿登録日のチェック).
                thenAdd(ShikakuJohoValidationMessage.表示消除予定日と名簿登録日のチェック).
                messages()
        );
        return messages;
    }

    /**
     * 表示消除年月日チェック
     *
     * @return チェック結果
     */
    public IValidationMessages validate表示消除年月日() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(ShikakuJohoSpec.表示消除日と表示日のチェック).
                thenAdd(ShikakuJohoValidationMessage.表示消除日と表示日のチェック).
                ifNot(ShikakuJohoSpec.表示消除日と表示事由のチェック１).
                thenAdd(ShikakuJohoValidationMessage.表示消除日と表示事由のチェック１).
                ifNot(ShikakuJohoSpec.表示消除日と表示事由のチェック２).
                thenAdd(ShikakuJohoValidationMessage.表示消除日と表示事由のチェック２).
                ifNot(ShikakuJohoSpec.表示消除日と名簿登録日のチェック).
                thenAdd(ShikakuJohoValidationMessage.表示消除日と名簿登録日のチェック).
                messages()
        );
        return messages;
    }

    /**
     * 「転出時」の住民種別チェック
     *
     * @return チェック結果
     */
    public IValidationMessages validate転出時の住民種別() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(ShikakuJohoSpec.転出時の住民種別と状態チェック１).
                thenAdd(ShikakuJohoValidationMessage.転出時の住民種別と状態チェック１).
                messages()
        );
        return messages;
    }

    /**
     * 同一日チェック
     *
     * @return チェック結果
     */
    public IValidationMessages validate同一日() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(ShikakuJohoSpec.転出の表示日と消除異動年月日同一日チェック).
                thenAdd(ShikakuJohoValidationMessage.転出の表示日と消除異動年月日同一日チェック).
                ifNot(ShikakuJohoSpec.転出の表示日と消除届出年月日同一日チェック).
                thenAdd(ShikakuJohoValidationMessage.転出の表示日と消除届出年月日同一日チェック).
                messages()
        );
        return messages;
    }

    /**
     * 登録年月日と表示年月日の関連チェック
     *
     * @return チェック結果
     */
    public IValidationMessages validate登録年月日と表示年月日の関連() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(ShikakuJohoSpec.表示年月日と登録日チェック).
                thenAdd(ShikakuJohoValidationMessage.表示年月日と登録日チェック).
                ifNot(ShikakuJohoSpec.登録停止日と登録日チェック).
                thenAdd(ShikakuJohoValidationMessage.登録停止日と登録日チェック).
                messages()
        );
        return messages;
    }

    /**
     * 登録年月日と表示年月日の関連チェック
     *
     * @return チェック結果
     */
    public IValidationMessages validate登録年月日と抹消年月日の関連() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(ShikakuJohoSpec.名簿登録日と抹消年月日チェック).
                thenAdd(ShikakuJohoValidationMessage.名簿登録日と抹消年月日チェック).
                messages()
        );
        return messages;
    }

    /**
     * 抹消理由/抹消年月日入力チェック
     *
     * @return チェック結果
     */
    public IValidationMessages validate抹消事由と抹消年月日入力() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(ShikakuJohoSpec.抹消事由と抹消年月日入力チェック1).
                thenAdd(ShikakuJohoValidationMessage.抹消事由と抹消年月日入力チェック1).
                ifNot(ShikakuJohoSpec.抹消事由と抹消年月日入力チェック2).
                thenAdd(ShikakuJohoValidationMessage.抹消事由と抹消年月日入力チェック2).
                ifNot(ShikakuJohoSpec.抹消事由と抹消年月日入力チェック3).
                thenAdd(ShikakuJohoValidationMessage.抹消事由と抹消年月日入力チェック2).
                ifNot(ShikakuJohoSpec.抹消事由と抹消年月日入力チェック4).
                thenAdd(ShikakuJohoValidationMessage.抹消事由と抹消年月日入力チェック1).
                messages()
        );
        return messages;
    }

    /**
     * 抹消理由と住民種別のチェック
     *
     * @return チェック結果
     */
    public IValidationMessages validate抹消理由と住民種別() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(ShikakuJohoSpec.抹消事由と住民種別と状態チェック１).
                thenAdd(ShikakuJohoValidationMessage.抹消事由と住民種別と状態チェック１).
                ifNot(ShikakuJohoSpec.抹消事由と住民種別と状態チェック２).
                thenAdd(ShikakuJohoValidationMessage.抹消事由と住民種別と状態チェック２).
                messages()
        );
        return messages;
    }

    /**
     * 入力日付のチェック
     *
     * @return チェック結果
     */
    public IValidationMessages validate入力日付() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(ShikakuJohoSpec.入力日付チェック６).
                thenAdd(ShikakuJohoValidationMessage.入力日付チェック６).
                ifNot(ShikakuJohoSpec.入力日付チェック７).
                thenAdd(ShikakuJohoValidationMessage.入力日付チェック７).
                ifNot(ShikakuJohoSpec.入力日付チェック８).
                thenAdd(ShikakuJohoValidationMessage.入力日付チェック８).
                messages()
        );
        return messages;
    }

    /**
     * 抹消理由と住民種別のチェック
     *
     * @return チェック結果
     */
    public IValidationMessages validate抹消異動日関連() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(ShikakuJohoSpec.抹消異動日関連チェック１).
                thenAdd(ShikakuJohoValidationMessage.抹消異動日関連チェック１).
                ifNot(ShikakuJohoSpec.抹消異動日関連チェック２).
                thenAdd(ShikakuJohoValidationMessage.抹消異動日関連チェック２).
                ifNot(ShikakuJohoSpec.抹消異動日関連チェック３).
                thenAdd(ShikakuJohoValidationMessage.抹消異動日関連チェック３).
                ifNot(ShikakuJohoSpec.抹消異動日関連チェック４).
                thenAdd(ShikakuJohoValidationMessage.抹消異動日関連チェック４).
                ifNot(ShikakuJohoSpec.抹消異動日関連チェック５).
                thenAdd(ShikakuJohoValidationMessage.抹消異動日関連チェック５).
                messages()
        );
        return messages;
    }

    /**
     * 住登外のチェック
     *
     * @return チェック結果
     */
    public IValidationMessages validate住登外() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(ShikakuJohoSpec.住登外チェック).
                thenAdd(ShikakuJohoValidationMessage.住登外チェック).
                messages()
        );
        return messages;
    }

    /**
     * 選挙資格有無のチェック
     *
     * @return チェック結果
     */
    public IValidationMessages validate選挙資格の有無() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ShikakuJohoValidationMessage.選挙資格有無チェック);
        return messages;
    }
}
