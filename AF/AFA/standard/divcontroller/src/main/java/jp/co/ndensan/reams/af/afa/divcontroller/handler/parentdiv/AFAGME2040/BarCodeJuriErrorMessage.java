/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME2040;

import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * AFAGME2040 投票受付　施設一括バーコード受理のエラーメッセージクラスです。
 *
 * @reamsid_L AF-0240-010 qiuxy
 */
public class BarCodeJuriErrorMessage implements IValidationMessage {

    private final Message message;

    /**
     * コンストラクス。
     *
     * @param message Message
     */
    public BarCodeJuriErrorMessage(Message message) {
        this.message = message;
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
