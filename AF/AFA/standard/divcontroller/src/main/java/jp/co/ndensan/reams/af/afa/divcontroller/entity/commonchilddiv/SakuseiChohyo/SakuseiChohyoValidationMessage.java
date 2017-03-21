/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SakuseiChohyo;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 *
 * 作成帳票共有子DIVのValidationMessageの列挙型
 */
public enum SakuseiChohyoValidationMessage implements IValidationMessage {

    二重登録通知_転入期間(UrErrorMessages.期間が不正_追加メッセージあり１, "転入期間終了", "転入期間開始"),
    帰化期間(UrErrorMessages.期間が不正_追加メッセージあり１, "帰化期間終了", "帰化期間開始"),
    二重登録調査票_転出期間(UrErrorMessages.期間が不正_追加メッセージあり１, "転出期間終了", "転出期間開始"),
    永久選挙人名簿_出力条件(UrErrorMessages.選択されていない, "指定日の入力もしくは異動事由");
    private final Message message;

    private SakuseiChohyoValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    private SakuseiChohyoValidationMessage(IMessageGettable message, String... replace) {
        this.message = message.getMessage().replace(replace);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
