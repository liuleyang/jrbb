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
public class ShikakuJohoWarnValidator {

    private final ShikakuJohoDiv div;

    ShikakuJohoWarnValidator(ShikakuJohoDiv div) {
        this.div = div;
    }

    /**
     * 経過日3ヶ月検証処理
     *
     * @return チェック結果
     */
    public IValidationMessages validate経過日3ヶ月() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(ShikakuJohoSpec.経過日3ヶ月チェック).
                thenAdd(ShikakuJohoValidationMessage.経過日3ヶ月チェック).
                messages()
        );
        return messages;
    }

    /**
     * バリデーション検証処理
     *
     * @return チェック結果
     */
    public IValidationMessages validate転出時の住民種別Warn() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(ShikakuJohoSpec.表示日の未来日チェック).
                thenAdd(ShikakuJohoValidationMessage.表示日の未来日チェック).
                ifNot(ShikakuJohoSpec.登録停止日の未来日チェック).
                thenAdd(ShikakuJohoValidationMessage.登録停止日の未来日チェック).
                messages()
        );
        return messages;
    }

    /**
     * バリデーション検証処理
     *
     * @return チェック結果
     */
    public IValidationMessages validate登録対象外Warn() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(ShikakuJohoSpec.年齢未満チェック).
                thenAdd(ShikakuJohoValidationMessage.年齢未満チェック).
                ifNot(ShikakuJohoSpec.外国人チェック).
                thenAdd(ShikakuJohoValidationMessage.外国人チェック).
                messages()
        );
        return messages;
    }

    /**
     * バリデーション検証処理
     *
     * @return チェック結果
     */
    public IValidationMessages validate入力日付Warn() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(ShikakuJohoSpec.入力日付チェック５).
                thenAdd(ShikakuJohoValidationMessage.入力日付チェック５).
                messages()
        );
        return messages;
    }

}
