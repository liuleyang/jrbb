/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SenkyokuCodeSelect;

import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * SenkyokuCodeSelectDiv のチェックロジックです。
 *
 * @reamsid_L AF-0720-030 zhanggs
 */
public class SenkyokuCodeSelectErrorValidator implements IValidatable {

    private final SenkyokuCodeSelectDiv div;

    /**
     * コンストラクタ
     *
     * @param div 選挙区コード
     */
    public SenkyokuCodeSelectErrorValidator(SenkyokuCodeSelectDiv div) {
        this.div = div;
    }

    /**
     * 選挙区コード検証処理
     *
     * @return チェック結果
     */
    public IValidationMessages validate選挙区コード() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(SenkyokuCodeSelectSpec.選挙区コード).
                thenAdd(SenkyokuCodeSelectValidationMessage.選挙区コード).
                messages()
        );
        return messages;
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
                ifNot(SenkyokuCodeSelectSpec.選挙区コード).
                thenAdd(SenkyokuCodeSelectValidationMessage.選挙区コード).
                messages()
        );
        return messages;
    }
}
