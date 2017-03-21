/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGML1010;

import jp.co.ndensan.reams.af.afa.definition.message.AfErrorMessages;
import jp.co.ndensan.reams.af.afa.definition.message.AfWarningMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 財産区議会議員選挙時登録のチェックメッセージクラスです。
 *
 * @reamsid_L AF-0600-010 lis
 */
public enum ZaisankuSenkyojiTorokuValidatorMessage implements IMessageGettable, IValidationMessage {

    /**
     * 基準日登録日大小チェック
     */
    基準日登録日大小チェック(AfErrorMessages.基準日確認, "登録日"),
    /**
     * 年齢期限日基準日大小チェック
     */
    年齢期限日基準日大小チェック(AfWarningMessages.年齢期限日確認, "基準日"),
    /**
     * 転出期限日基準日大小チェック
     */
    転出期限日基準日大小チェック(AfWarningMessages.転出_転入期限日確認, "転出期限日"),
    /**
     * 転入期限日基準日大小チェック
     */
    転入期限日基準日大小チェック(AfWarningMessages.転出_転入期限日確認, "転入期限日"),
    /**
     * 転出期限日転入期限日大小チェック
     */
    転出期限日転入期限日大小チェック(AfWarningMessages.転出_転入期限日大小確認),
    /**
     * 年齢期限日基準日大小チェック
     */
    投票開始日基準日大小チェック(AfWarningMessages.転出_転入期限日確認, "投票開始日");

    private final Message message;

    @Override
    public Message getMessage() {
        return message;
    }

    private ZaisankuSenkyojiTorokuValidatorMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }
}
