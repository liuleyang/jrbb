/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMA1000;

import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 住民検索のエラーメッセージクラスです。
 *
 * @reamsid_L AF-0230-020 qiuxy
 */
public class SearchJuminErrorMessages implements IValidationMessage {

    private final Message message;

    /**
     * コンストラクス。
     *
     * @param message Message
     */
    public SearchJuminErrorMessages(Message message) {
        this.message = message;
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
