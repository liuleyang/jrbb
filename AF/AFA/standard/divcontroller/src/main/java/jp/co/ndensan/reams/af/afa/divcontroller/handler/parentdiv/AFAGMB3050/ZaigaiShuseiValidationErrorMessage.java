/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB3050;

import jp.co.ndensan.reams.af.afa.definition.message.AfErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 在外選挙人名簿修正のチェックメッセージクラスです。
 *
 * @reamsid_L AF-0325-034 guancy
 */
public enum ZaigaiShuseiValidationErrorMessage implements IValidationMessage {

    /**
     * 表示日未入力エラー。
     *
     */
    表示日未入力エラー(AfErrorMessages.未入力エラー, "表示日"),
    /**
     * 表示事由未入力エラー。
     *
     */
    表示事由未入力エラー(AfErrorMessages.未入力エラー, "表示事由");

    private final Message message;

    private ZaigaiShuseiValidationErrorMessage(IMessageGettable message, String... replace) {
        this.message = message.getMessage().replace(replace);
    }

    /**
     * 選挙時登録再発行のバリデーションメッセージを取得します。
     *
     * @return メッセージ
     */
    @Override
    public Message getMessage() {
        return message;
    }
}
