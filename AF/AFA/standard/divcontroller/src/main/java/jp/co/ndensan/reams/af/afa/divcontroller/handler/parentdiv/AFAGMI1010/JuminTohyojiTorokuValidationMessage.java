/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMI1010;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 住民投票時登録のバリデーションメッセージです。
 *
 * @reamsid_L AF-0450-010 lis
 */
public enum JuminTohyojiTorokuValidationMessage implements IValidationMessage {

    /**
     * 投票区未選択。
     */
    抄本未選択(UrErrorMessages.選択されていない, "抄本"),
    /**
     * 行政区未入力。
     */
    転出日未入力(UrErrorMessages.未入力, "転出日"),
    /**
     * 住所未入力。
     */
    転入日未入力(UrErrorMessages.未入力, "転入日"),
    /**
     * 住定期間未入力。
     */
    住定期間未入力(UrErrorMessages.未入力, "住定期間"),
    /**
     * 居住年数未入力。
     */
    居住年数未入力(UrErrorMessages.未入力, "居住年数"),
    /**
     * 居住年数大小関係が不正。
     */
    住定期間大小関係が不正(UrErrorMessages.大小関係が不正, "住定期間");

    private final Message message;

    private JuminTohyojiTorokuValidationMessage(IMessageGettable message, String... replace) {
        this.message = message.getMessage().replace(replace);
    }

    /**
     * 住民投票時登録のバリデーションメッセージを取得します。
     *
     * @return メッセージ
     */
    @Override
    public Message getMessage() {
        return message;
    }

}
