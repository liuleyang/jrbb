/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME5040;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 投票日前日関連帳票の入力チェックのメッセージクラスです。
 *
 * @reamsid_L AF-0280-010 lit
 */
public enum ZenjitsuSakuseiValidationMessage implements IValidationMessage {

    /**
     * 作成帳票必須。
     */
    作成帳票必須(UrErrorMessages.選択されていない, "作成帳票"),
    /**
     * 代理投票集計表必須。
     */
    代理投票集計表必須(UrErrorMessages.選択されていない, "代理投票集計表の出力対象"),
    /**
     * 事務処理簿必須。
     */
    事務処理簿必須(UrErrorMessages.選択されていない, "事務処理簿の出力対象");

    private final Message message;

    ZenjitsuSakuseiValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    ZenjitsuSakuseiValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
