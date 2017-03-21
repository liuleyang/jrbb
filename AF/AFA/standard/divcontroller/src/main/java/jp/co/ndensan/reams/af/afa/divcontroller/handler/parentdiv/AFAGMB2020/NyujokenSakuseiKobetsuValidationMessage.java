/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB2020;

import jp.co.ndensan.reams.af.afa.definition.message.AfWarningMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 入場券発行（個別）のチェック操作を担当するクラスです。
 *
 * @reamsid_L AF-0170-010 jihb
 */
public enum NyujokenSakuseiKobetsuValidationMessage implements IValidationMessage {

    /**
     * 申請日のチェック
     */
    印刷タイプのチェック(UrErrorMessages.未指定, "印刷タイプ"),
    /**
     * 申請日のチェック
     */
    世帯印字人数のチェック(UrErrorMessages.未指定, "世帯印字人数"),
    /**
     * 申請日のチェック
     */
    選挙人一覧のチェック(UrErrorMessages.未指定, "選挙人"),
    /**
     * 申請日のチェック
     */
    同一世帯の人が複数選択のチェック(UrErrorMessages.特定不可, "同一世帯の選挙人"),
    /**
     * 申請日のチェック
     */
    選挙バッチ実行確認のチェック(AfWarningMessages.選挙バッチ実行確認_排他あり);

    private final Message message;

    private NyujokenSakuseiKobetsuValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }

}
