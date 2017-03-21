/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMA1010;

import jp.co.ndensan.reams.af.afa.definition.message.AfErrorMessages;
import jp.co.ndensan.reams.af.afa.definition.message.AfWarningMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

public enum TeijiTorokuValidationMessage implements IValidationMessage {

    基準日必須項目を入力(UrErrorMessages.必須項目_追加メッセージあり, "基準日"),
    投票日必須項目を入力(UrErrorMessages.必須項目_追加メッセージあり, "投票日"),
    登録日必須項目を入力(UrErrorMessages.必須項目_追加メッセージあり, "登録日"),
    転出期限必須項目を入力(UrErrorMessages.必須項目_追加メッセージあり, "転出期限日"),
    転入期限必須項目を入力(UrErrorMessages.必須項目_追加メッセージあり, "転入期限日"),
    年齢期限必須項目を入力(UrErrorMessages.必須項目_追加メッセージあり, "年齢期限日"),
    基準日と登録日の関係性チェック(AfErrorMessages.基準日確認, "登録日"),
    未来基準日抄本確認(AfErrorMessages.未来日基準日抄本確認),
    定時未実施確認(AfErrorMessages.定時未実施確認),
    同一基準日抄本確認(AfErrorMessages.同一基準日抄本確認),
    過去抄本再処理確認(AfErrorMessages.過去抄本再処理確認),
    年齢期限日と基準日の関係性チェック(AfWarningMessages.年齢期限日確認, "基準日"),
    転出期限と基準日の関係性チェック(AfWarningMessages.転出_転入期限日確認, "転出期限日"),
    転入期限と基準日の関係性チェック(AfWarningMessages.転出_転入期限日確認, "転入期限日"),
    投票日と基準日の関係性チェック(AfErrorMessages.基準日確認, "投票日"),
    転出期限と転入期限の関係性チェック(AfWarningMessages.転出_転入期限日大小確認);
    private final Message message;

    private TeijiTorokuValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    private TeijiTorokuValidationMessage(IMessageGettable message, String... replace) {
        this.message = message.getMessage().replace(replace);
    }

    @Override
    public Message getMessage() {
        return message;
    }

}
