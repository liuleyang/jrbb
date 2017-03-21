/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGML1010;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGML1010.ZaisankuSenkyojiTorokuDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 財産区議会議員選挙時登録のValidator
 *
 * @reamsid_L AF-0600-010 lis
 */
public class ZaisankuSenkyojiTorokuValidator implements IValidatable {

    private final ZaisankuSenkyojiTorokuDiv div;

    /**
     * コンストラクタ
     *
     * @param div 海区漁業調整委員会委員選挙人名簿登録のDiv
     */
    public ZaisankuSenkyojiTorokuValidator(ZaisankuSenkyojiTorokuDiv div) {
        this.div = div;
    }

    /**
     * 実行ボタンを押下の検証処理
     *
     * @return IValidationMessages
     */
    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(ZaisankuSenkyojiTorokuSpec.基準日登録日大小チェック)
                .thenAdd(ZaisankuSenkyojiTorokuValidatorMessage.基準日登録日大小チェック)
                .messages()
        );
        return messages;
    }

    /**
     * 実行ボタンを押下の検証処理
     *
     * @return IValidationMessages
     */
    public IValidationMessages validate1() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(ZaisankuSenkyojiTorokuSpec.年齢期限日基準日大小チェック)
                .thenAdd(ZaisankuSenkyojiTorokuValidatorMessage.年齢期限日基準日大小チェック).
                ifNot(ZaisankuSenkyojiTorokuSpec.転出期限日基準日大小チェック)
                .thenAdd(ZaisankuSenkyojiTorokuValidatorMessage.転出期限日基準日大小チェック).
                ifNot(ZaisankuSenkyojiTorokuSpec.転入期限日基準日大小チェック)
                .thenAdd(ZaisankuSenkyojiTorokuValidatorMessage.転入期限日基準日大小チェック).
                ifNot(ZaisankuSenkyojiTorokuSpec.転出期限日転入期限日大小チェック)
                .thenAdd(ZaisankuSenkyojiTorokuValidatorMessage.転出期限日転入期限日大小チェック).
                ifNot(ZaisankuSenkyojiTorokuSpec.投票開始日基準日大小チェック)
                .thenAdd(ZaisankuSenkyojiTorokuValidatorMessage.投票開始日基準日大小チェック)
                .messages()
        );
        return messages;
    }

}
