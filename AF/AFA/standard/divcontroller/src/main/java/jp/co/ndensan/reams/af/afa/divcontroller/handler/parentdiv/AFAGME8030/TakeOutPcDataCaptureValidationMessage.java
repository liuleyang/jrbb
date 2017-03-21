/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME8030;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 *
 * 持出端末データ取込のバリデーションメッセージです。
 *
 * @reamsid_L AF-0795-010 wanghj
 */
public enum TakeOutPcDataCaptureValidationMessage implements IValidationMessage {

    /**
     * 取込対象ファイル必須チェック。
     */
    取込対象ファイル必須チェック(UrErrorMessages.必須項目),
    /**
     * 投票日確認。
     */
    投票日確認(UrErrorMessages.項目に対する制約, "取込ファイル", "指定した投票日のファイル"),
    /**
     * 投票区確認。
     */
    投票区確認(UrErrorMessages.項目に対する制約, "取込ファイル", "指定した投票区のファイル"),
    /**
     * 抄本ファイルチェック。
     */
    抄本ファイルチェック(UrErrorMessages.選択されていない, "抄本ファイル"),
    /**
     * 投票状況ファイルチェック。
     */
    投票状況ファイルチェック(UrErrorMessages.選択されていない, "投票状況ファイル");

    private final Message message;

    private TakeOutPcDataCaptureValidationMessage(IMessageGettable message, String... replace) {
        this.message = message.getMessage().replace(replace);
    }

    /**
     * 郵便等投票資格登録のバリデーションメッセージを取得します。
     *
     * @return メッセージ
     */
    @Override
    public Message getMessage() {
        return message;
    }

}
