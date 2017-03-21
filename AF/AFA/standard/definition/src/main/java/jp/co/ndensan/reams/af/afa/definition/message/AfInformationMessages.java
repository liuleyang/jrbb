/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.message;

import static jp.co.ndensan.reams.af.afa.definition.message.MessageCreateHelper.toCode;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * AFのインフォメーションメッセージを表す列挙型です。
 *
 * @reamsid_L AF-0325-034 guyq
 */
public enum AfInformationMessages implements IMessageGettable {

    /**
     * 処理完了
     */
    処理完了(1, "投票内容を保存しました。"),
    /**
     * 投票受付完了
     */
    投票受付完了(2, "既に投票受付済みです。"),
    /**
     * 一部受付済み
     */
    一部受付済み(3, "既に一部の選挙が投票受付済みです。"),
    /**
     * 一部交付済み
     */
    一部交付済み(4, "既に交付済みで、受理されていない選挙が存在します。"),
    /**
     * 引き続き証明書提示
     */
    引き続き証明書提示(5, "引き続き証明書の提示が必要です。"),
    /**
     * 郵便資格あり
     */
    郵便資格あり(6, "郵便投票資格が登録されています。"),
    /**
     * 船員資格あり
     */
    船員資格あり(7, "船員投票資格が登録されています。選挙人名簿登録証明書の確認をしてください。"),
    /**
     * 別状態同時選択
     */
    別状態同時選択(8, "異なる状態の選挙を選択中です。選択した投票区分の状態で上書きされます。"),
    /**
     * 棄権入力確認
     */
    棄権入力確認(9, "「棄権」で入力した選挙は、再投票できなくなります。?"),
    /**
     * 棄権状態の取消
     */
    棄権状態の取消(10, "「棄権」状態の選挙を選択中です。"),
    /**
     * データ作成_成功
     */
    データ作成_成功(11, "?データ作成：?ファイルを作成しました。"),
    /**
     * データ作成_失敗
     */
    データ作成_失敗(12, "?データ作成：?ファイルの作成に失敗しました。"),
    /**
     * 在外国民投票資格確認
     */
    在外国民投票資格確認(13, "国民投票資格のみです。国民投票の在外投票人名簿管理から処理してください。"),
    /**
     * 投票区変更不可
     */
    投票区変更不可(13, "?投票区変更処理はできません。"), /**
     * 当日投票端末確認
     */
    当日投票端末確認(15, "当日投票用端末として登録されていません。"),
    /**
     * 工事中メッセージ
     */
    工事中メッセージ(99999, "現在、作成中です。。。");

    private final Message message;

    private AfInformationMessages(int no, String value) {
        this.message = new InformationMessage(toCode("I", no), value);
    }

    @Override
    public Message getMessage() {
        return message;
    }

}
