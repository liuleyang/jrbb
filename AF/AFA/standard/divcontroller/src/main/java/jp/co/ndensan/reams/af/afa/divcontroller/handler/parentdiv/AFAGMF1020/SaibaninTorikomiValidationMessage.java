/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMF1020;

import jp.co.ndensan.reams.af.afa.definition.message.AfErrorMessages;
import jp.co.ndensan.reams.af.afa.definition.message.AfWarningMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 裁判員候補者予定者取込のバリデーションメッセージです。
 *
 * @reamsid_L AF-0310-010 guancy
 */
public enum SaibaninTorikomiValidationMessage implements IValidationMessage {

    /**
     * ファイル再登録確認。
     */
    ファイル再登録確認(AfWarningMessages.ファイル再登録確認),
    /**
     * ファイル存在チェック。
     */
    情報存在チェック(UrErrorMessages.存在しない, "裁判員名簿作成情報"),
    /**
     * データ数が不正チェック。
     */
    データ数が不正(AfErrorMessages.データ数が不正),
    /**
     * 項目数が不正チェック。
     */
    項目数が不正(AfErrorMessages.項目数が不正);

    private final Message message;

    private SaibaninTorikomiValidationMessage(IMessageGettable message, String... replace) {
        this.message = message.getMessage().replace(replace);
    }

    /**
     * 裁判員候補者予定者取込のバリデーションメッセージを取得します。
     *
     * @return メッセージ
     */
    @Override
    public Message getMessage() {
        return message;
    }

}
