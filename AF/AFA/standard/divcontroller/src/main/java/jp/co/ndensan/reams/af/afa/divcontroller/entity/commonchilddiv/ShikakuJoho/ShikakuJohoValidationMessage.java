/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShikakuJoho;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ShikakuJohoEnum;
import jp.co.ndensan.reams.af.afa.definition.message.AfErrorMessages;
import jp.co.ndensan.reams.af.afa.definition.message.AfWarningMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * ShikakuJohoDiv のチェックロジックです。
 *
 * @reamsid_L AF-0180-015 lis2
 */
public enum ShikakuJohoValidationMessage implements IValidationMessage {

    /**
     * 3ヶ月経過日チェック。
     */
    経過日3ヶ月チェック(AfWarningMessages.処理の続行確認, "転入3か月未満"),
    /**
     * 表示日・表示事由のチェック。
     */
    表示日と表示事由のチェック1(UrErrorMessages.未入力, ShikakuJohoEnum.表示日.toRString().toString()),
    /**
     * 表示日・表示事由のチェック。
     */
    表示日と表示事由のチェック2(UrErrorMessages.未入力, ShikakuJohoEnum.表示事由.toRString().toString()),
    /**
     * 表示日・表示事由のチェック。
     */
    登録停止者変更時のチェック(AfErrorMessages.登録停止者抹消確認),
    /**
     * 登録停止日・登録停止事由のチェック。
     */
    登録停止日と登録停止事由のチェック1(UrErrorMessages.未入力, ShikakuJohoEnum.登録停止日.toRString().toString()),
    /**
     * 登録停止日・登録停止事由のチェック。
     */
    登録停止日と登録停止事由のチェック2(UrErrorMessages.未入力, ShikakuJohoEnum.登録停止事由.toRString().toString()),
    /**
     * 登録停止日・登録停止事由のチェック。
     */
    登録停止事由と表示事由のチェック(UrErrorMessages.両方の指定は不可, ShikakuJohoEnum.登録停止事由.toRString().toString(), ShikakuJohoEnum.表示事由.toRString().toString()),
    /**
     * 表示消除予定日と表示日のチェック。
     */
    表示消除予定日と表示日のチェック(AfErrorMessages.交付日確認, ShikakuJohoEnum.表示消除予定日.toRString().toString(), ShikakuJohoEnum.表示日.toRString().toString(), ShikakuJohoEnum.表示消除予定日のクリア.toRString().toString()),
    /**
     * 表示消除予定日と表示事由のチェック１。
     */
    表示消除予定日と表示事由のチェック１(UrErrorMessages.未入力, ShikakuJohoEnum.表示事由.toRString().toString()),
    /**
     * 表示消除予定日・表示事由のチェック２。
     */
    表示消除予定日と表示事由のチェック２(UrErrorMessages.項目に対する制約, ShikakuJohoEnum.表示事由.toRString().toString(), ShikakuJohoEnum.公選法第11条関係.toRString().toString()),
    /**
     * AfErrorMessages。
     */
    表示消除予定日と名簿登録日のチェック(AfErrorMessages.交付日確認, ShikakuJohoEnum.表示消除予定日.toRString().toString(), ShikakuJohoEnum.名簿登録日.toRString().toString(), ShikakuJohoEnum.表示消除予定日のクリア.toRString().toString()),
    /**
     * 表示消除日と表示日のチェック。
     */
    表示消除日と表示日のチェック(AfErrorMessages.交付日確認, ShikakuJohoEnum.表示消除日.toRString().toString(), ShikakuJohoEnum.表示日.toRString().toString(), ShikakuJohoEnum.表示消除日のクリア.toRString().toString()),
    /**
     * 表示消除日と表示事由のチェック１。
     */
    表示消除日と表示事由のチェック１(UrErrorMessages.未入力, ShikakuJohoEnum.表示事由.toRString().toString()),
    /**
     * 表示消除日と表示事由のチェック２。
     */
    表示消除日と表示事由のチェック２(UrErrorMessages.項目に対する制約, ShikakuJohoEnum.表示事由.toRString().toString(), ShikakuJohoEnum.公選法第11条関係.toRString().toString()),
    /**
     * 表示消除日と名簿登録日のチェック。
     */
    表示消除日と名簿登録日のチェック(AfErrorMessages.交付日確認, ShikakuJohoEnum.表示消除日.toRString().toString(), ShikakuJohoEnum.名簿登録日.toRString().toString(), ShikakuJohoEnum.表示消除日のクリア.toRString().toString()),
    /**
     * 表示日の未来日チェック。
     */
    表示日の未来日チェック(AfWarningMessages.処理の続行確認, "表示日が未来の日付です。"),
    /**
     * 登録停止日の未来日チェック。
     */
    登録停止日の未来日チェック(AfWarningMessages.処理の続行確認, "登録停止日が未来の日付です。"),
    /**
     * 転出時の住民種別・状態チェック１。
     */
    転出時の住民種別と状態チェック１(AfErrorMessages.選択資格と事由の不一致, ShikakuJohoEnum.表示事由.toRString().toString(),
            ShikakuJohoEnum.転出.toRString().toString(), ShikakuJohoEnum.転出者.toRString().toString()),
    /**
     * 転出の表示日と消除異動年月日同一日チェック
     */
    転出の表示日と消除異動年月日同一日チェック(UrErrorMessages.入力値が不正_追加メッセージあり, "表示日が消除異動年月日と違います。"),
    /**
     * 転出の表示日と消除届出年月日同一日チェック
     */
    転出の表示日と消除届出年月日同一日チェック(UrErrorMessages.入力値が不正_追加メッセージあり, "表示日が消除届出年月日と違います。"),
    /**
     * 表示年月日・登録日チェック
     */
    表示年月日と登録日チェック(AfErrorMessages.交付日確認, ShikakuJohoEnum.表示日.toRString().toString(),
            ShikakuJohoEnum.名簿登録日.toRString().toString(),
            "または、表示日をクリアしてください。"),
    /**
     * 表示年月日・登録日チェック
     */
    登録停止日と登録日チェック(AfErrorMessages.交付日確認, ShikakuJohoEnum.登録停止日.toRString().toString(),
            ShikakuJohoEnum.名簿登録日.toRString().toString(), " "),
    /**
     * 名簿登録日・抹消年月日チェック
     */
    名簿登録日と抹消年月日チェック(AfErrorMessages.交付日確認, ShikakuJohoEnum.名簿登録日.toRString().toString(),
            ShikakuJohoEnum.抹消日.toRString().toString(), ""),
    /**
     * 抹消事由/抹消年月日入力チェック
     */
    抹消事由と抹消年月日入力チェック1(UrErrorMessages.未入力, ShikakuJohoEnum.抹消事由.toRString().toString()),
    /**
     * 抹消事由/抹消年月日入力チェック
     */
    抹消事由と抹消年月日入力チェック2(UrErrorMessages.未入力, ShikakuJohoEnum.抹消日.toRString().toString()),
    /**
     * 抹消事由と住民種別と状態チェック１
     */
    抹消事由と住民種別と状態チェック１(AfErrorMessages.選択資格と事由の不一致, ShikakuJohoEnum.抹消事由.toRString().toString(),
            "死亡", "死亡者"),
    /**
     * 抹消事由と住民種別と状態チェック１
     */
    抹消事由と住民種別と状態チェック２(AfErrorMessages.選択資格と事由の不一致, ShikakuJohoEnum.抹消事由.toRString().toString(),
            "転出4ヶ月経過", ShikakuJohoEnum.転出者.toRString().toString()),
    /**
     * 入力日付チェック５
     */
    入力日付チェック５(AfWarningMessages.処理の続行確認, "抹消年月日が未来の日付です。"),
    /**
     * 入力日付チェック６
     */
    入力日付チェック６(AfErrorMessages.交付日確認, ShikakuJohoEnum.抹消日.toRString().toString(),
            ShikakuJohoEnum.名簿登録日.toRString().toString(), ""),
    /**
     * 入力日付チェック７
     */
    入力日付チェック７(AfErrorMessages.交付日確認, ShikakuJohoEnum.抹消日.toRString().toString(),
            ShikakuJohoEnum.登録停止日.toRString().toString(), " "),
    /**
     * 入力日付チェック８
     */
    入力日付チェック８(AfErrorMessages.交付日確認, ShikakuJohoEnum.抹消日.toRString().toString(),
            ShikakuJohoEnum.表示日.toRString().toString(), " "),
    /**
     * 抹消異動日関連チェック１
     */
    抹消異動日関連チェック１(UrErrorMessages.入力値が不正_追加メッセージあり, "抹消日が消除届出年月日と違います。"),
    /**
     * 抹消異動日関連チェック１
     */
    抹消異動日関連チェック２(UrErrorMessages.入力値が不正_追加メッセージあり, "抹消日が消除異動年月日の翌日と違います。"),
    /**
     * 抹消異動日関連チェック３
     */
    抹消異動日関連チェック３(UrErrorMessages.入力値が不正_追加メッセージあり, "抹消日が消除届出年月日の翌日と違います。"),
    /**
     * 抹消異動日関連チェック４
     */
    抹消異動日関連チェック４(UrErrorMessages.入力値が不正_追加メッセージあり, "抹消日が消除異動年月日の翌日と違います。"),
    /**
     * 抹消異動日関連チェック４
     */
    抹消異動日関連チェック５(UrErrorMessages.入力値が不正_追加メッセージあり, "抹消日が消除異動年月日 + ４ヶ月＋1日と違います。"),
    /**
     * 年齢未満チェック。
     */
    年齢未満チェック(AfWarningMessages.処理の続行確認, "年齢到達未満です。"),
    /**
     * 登録停止日の未来日チェック。
     */
    外国人チェック(AfWarningMessages.処理の続行確認, "外国人です。"),
    /**
     * 住登外チェック
     */
    住登外チェック(AfErrorMessages.住登外確認),
    /**
     * 選挙資格有無チェック
     */
    選挙資格有無チェック(UrErrorMessages.選択されていない, "選挙資格");

    private final Message message;

    ShikakuJohoValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    ShikakuJohoValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}
