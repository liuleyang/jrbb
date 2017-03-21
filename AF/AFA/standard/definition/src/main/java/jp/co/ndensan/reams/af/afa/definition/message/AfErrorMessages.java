/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.definition.message;

import static jp.co.ndensan.reams.af.afa.definition.message.MessageCreateHelper.toCode;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * AFのエラーメッセージを表す列挙型です。
 *
 * @reamsid_L AF-0310-011 guancy
 * @author N1823 有澤 礼恵
 */
public enum AfErrorMessages implements IMessageGettable {

    /**
     * バーコード受理不可
     */
    バーコード受理不可(1, "受理可能状態ではないため受付できません。"),
    /**
     * 名簿番号採番確認
     */
    名簿番号採番確認(2, "新しく振られる名簿番号を確認してください。"),
    /**
     * 日付入力確認
     */
    日付入力確認(3, "必須入力の日付をすべて入力してください。"),
    /**
     * 入場券確認
     */
    入場券確認(4, "受付選挙の入場券ではない可能性があります。確認してください。"),
    /**
     * 選択済み確認
     */
    選択済み確認(5, "既に選択済みです。"),
    /**
     * 年齢未到達
     */
    年齢未到達(6, "本日時点で基準年齢に達してません。不在者投票を行ってください。"),
    /**
     * 投票受付不可
     */
    投票受付不可(7, "投票受付できません。：?"),
    /**
     * 投票受付不可_理由付き
     */
    投票受付不可_理由付き(8, "?のため、投票受付できません。"),
    /**
     * 入場券発行済
     */
    入場券発行済(9, "選択した抄本の入場券は発行済みです。?はできません。"),
    /**
     * フォルダなし
     */
    フォルダなし(10, "入力したフォルダが存在しません。"),
    /**
     * 基準日確認
     */
    基準日確認(11, "基準日は?より前の日を設定してください。"),
    /**
     * 交付日確認
     */
    交付日確認(12, "?は?より後の日を設定してください。?"),
    /**
     * 選挙資格なし
     */
    選挙資格なし(13, "?選挙資格がありません。"),
    /**
     * 未入力エラー
     */
    未入力エラー(14, "?が未入力です。"),
    /**
     * 選択資格と事由の不一致
     */
    選択資格と事由の不一致(15, "?に?が選択されていますが、?ではありません。"),
    /**
     * 登録不可
     */
    登録不可(16, "?のため、登録できません。"),
    /**
     * 登録停止者抹消確認
     */
    登録停止者抹消確認(17, "登録停止者とする場合は、選挙資格を抹消してください。"),
    /**
     * 選挙レベル基準日確認
     */
    選挙レベル基準日確認(18, "登録済みの選挙のレベルと基準日が同じものがないと追加登録できません。"),
    /**
     * 名簿最新化不可
     */
    名簿最新化不可(19, "既に投票済の?が存在するため名簿を並び替える事ができません。"),
    /**
     * 同一基準日抄本確認
     */
    同一基準日抄本確認(20, "同一基準日で、既に抄本が存在しています。新規処理ではなく、再処理を行ってください。"),
    /**
     * 定時未実施確認
     */
    定時未実施確認(21, "前回の定時登録が行われていません。"),
    /**
     * 未来日基準日抄本確認
     */
    未来日基準日抄本確認(22, "未来の日付で既に抄本が存在しています。?"),
    /**
     * 過去抄本再処理確認
     */
    過去抄本再処理確認(23, "過去の抄本の再処理はできません。"),
    /**
     * 読込済み確認
     */
    読込済み確認(24, "既に読み込み済みです。"),
    /**
     * 項目数が不正
     */
    項目数が不正(25, "ファイルの項目数が不正です。"),
    /**
     * データ数が不正
     */
    データ数が不正(26, "ファイルの内容が空です。"),
    /**
     * 住登外確認
     */
    住登外確認(27, "住登外者です。登録できません。"),
    /**
     * 施設コードと施設種別の関係不正
     */
    施設コードと施設種別の関係不正(28, "入力済の施設種別に関連しない施設コードは入力できません。"),
    /**
     * 工事中メッセージ
     */
    工事中メッセージ(99999, "現在、作成中です。。。");

    private final Message message;

    private AfErrorMessages(int no, String value) {
        this.message = new ErrorMessage(toCode("E", no), value);
    }

    @Override
    public Message getMessage() {
        return message;
    }

}