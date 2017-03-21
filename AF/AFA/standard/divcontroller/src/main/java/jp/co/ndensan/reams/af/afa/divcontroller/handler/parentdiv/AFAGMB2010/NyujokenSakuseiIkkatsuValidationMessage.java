/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB2010;

import jp.co.ndensan.reams.af.afa.definition.message.AfWarningMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 入場券発行（一括）のチェック操作を担当するクラスです。
 *
 * @reamsid_L AF-0160-010 guyq
 */
public enum NyujokenSakuseiIkkatsuValidationMessage implements IValidationMessage {

    /**
     * 申請日のチェック
     */
    出力対象のチェック(UrErrorMessages.未指定, "出力対象"),
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
    投票区一覧のチェック(UrErrorMessages.選択されていない, "投票区"),
    /**
     * 申請日のチェック
     */
    転出日Fromのチェック(UrErrorMessages.必須, "転出日From"),
    /**
     * 転出日Toのチェック
     */
    転出日Toのチェック(UrErrorMessages.必須, "転出日To"),
    /**
     * 転出日Toのチェック
     */
    転出日Fromと転出日Toのチェック(UrErrorMessages.終了日が開始日以前),
    /**
     * 転出日Toのチェック
     */
    転出日From不正のチェック(UrErrorMessages.期間が不正),
    /**
     * 転出日Toのチェック
     */
    転出日To不正のチェック(UrErrorMessages.期間が不正),
    /**
     * 抽出対象世帯人数のチェック
     */
    抽出対象世帯人数のチェック(UrErrorMessages.未指定, "抽出対象世帯人数"),
    /**
     * 申請日のチェック
     */
    選挙バッチ実行確認のチェック(AfWarningMessages.選挙バッチ実行確認_排他あり);

    private final Message message;

    private NyujokenSakuseiIkkatsuValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }

}
