/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM3010;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 住民投票時登録のバリデーションメッセージです。
 *
 * @reamsid_L AF-0450-010 lis
 */
public enum MasterCsvOutputValidationMessage implements IValidationMessage {

    /**
     * 出力対象マスタ未選択。
     */
    出力対象マスタ未選択(UrErrorMessages.選択されていない, "出力対象マスタ"),
    /**
     * 投票区必須。
     */
    投票区必須(UrErrorMessages.必須, "投票区の選挙種類");

    private final Message message;

    private MasterCsvOutputValidationMessage(IMessageGettable message, String... replace) {
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
