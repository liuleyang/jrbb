/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.message;

import static jp.co.ndensan.reams.uz.uza.definition.enumeratedtype.message.MessageCreateHelper.toCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.WarningMessage;

/**
 * AFのインフォメーションメッセージを表す列挙型です。
 *
 * @reamsid_L AF-0790-010 wanghj
 */
public enum AfWarningMessages implements IMessageGettable {

    /**
     * 年齢期限日確認
     */
    受付開始日経過(1, "受付開始日が過ぎていますが、変更しますか？"),
    /**
     * 無投票入力_投票日前
     */
    無投票入力_投票日前(2, "投票日を過ぎていません。無投票入力は、投票日後にお願いします。<br>この処理を行うと、画面に表示されている選挙人すべてが更新されてしまいます。"),
    /**
     * 投票区変更_未変更
     */
    投票区変更_未変更(3, "変更前と同じ投票区が選択されています。移動先投票区を指定してください。"),
    /**
     * 不在者投票_上書き保存の確認
     */
    不在者投票_上書き保存の確認(4, "既に登録済のデータも選択しています。<br>画面情報で上書きされますがよろしいですか？"),
    /**
     * ファイル存在_上書き保存の確認
     */
    ファイル存在_上書き保存の確認(5, "?が、既に存在します。上書きされますがよろしいですか？"),
    /**
     * 年齢期限日確認
     */
    年齢期限日確認(6, "年齢期限日が?の翌日ではありません。処理を続行してもよろしいですか。"),
    /**
     * 転出_転入期限日確認
     */
    転出_転入期限日確認(7, "?が基準日より大きくなっています。処理を続行してもよろしいですか。"),
    /**
     * 転出_転入期限日大小確認
     */
    転出_転入期限日大小確認(8, "転入期限が転出期限より小さくなっています。処理を続行してもよろしいですか。"),
    /**
     * 選挙バッチ実行確認_排他あり
     */
    選挙バッチ実行確認_排他あり(9, "警告！この処理は住基の窓口入力処理終了後に行ってください。<br>処理実行中は住基及び選挙業務の更新処理は行えなくなります。<br>処理を実行してもよろしいですか？"),
    /**
     * 同一投票日抄本確認
     */
    同一投票日抄本確認(10, "同一投票日で、既に抄本が存在しています。処理を続行してもよろしいですか？"),
    /**
     * ファイル再登録確認
     */
    ファイル再登録確認(11, "既に取込済みです。再登録しますか？"),
    /**
     * 処理の続行確認
     */
    処理の続行確認(12, "?<br>処理を続行してもよろしいですか？"),
    /**
     * 交付番号存在確認
     */
    交付番号存在確認(13, "過去に使用された交付番号です。<br>よろしいですか？"),
    /**
     * 無投票入力_データ削除確認
     */
    無投票入力_データ削除確認(14, "投票受付データが?件存在しています。無投票に変更する場合、データを削除しますがよろしいですか？"),
    /**
     * 選挙追加確認
     */
    自動算出日付の確認(15, "?と日付自動算出の結果が異なっています。<br>処理を続行してもよろしいですか？"),
    /**
     * 選挙追加確認
     */
    選挙追加確認(16, "登録済みの選挙のレベルと基準日が同じでないと追加登録できません。<br>選挙を追加しますか？"),
    /**
     * 定時登録実行有無確認
     */
    定時登録実行有無確認(17, "定時登録が行われていません。通常は、定時登録後に選挙時登録を行います。<br>処理を続行してもよろしいですか？"),
    /**
     * 投票日前日確認
     */
    投票日前日確認(18, "本日は投票日前日または当日ではありません。<br>処理を続行してもよろしいですか？"),
    /**
     * 同一投票日存在性チェック
     */
    同一投票日存在性チェック(19, "同一投票日で、既に抄本が存在しています。処理を続行してもよろしいですか？");

    private final int no;

    private final RString message;

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     */
    private AfWarningMessages(int no, String message) {
        this.no = no;
        this.message = new RString(message);
    }

    @Override
    public Message getMessage() {
        return new WarningMessage(toCode("W", no), message.toString());
    }
}
