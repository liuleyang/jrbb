/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB3050;

import jp.co.ndensan.reams.af.afa.definition.message.AfErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.WarningMessage;

/**
 * 在外選挙人名簿修正のチェックメッセージクラスです。
 *
 * @reamsid_L AF-0325-034 guancy
 */
public enum ZaigaiShuseiWarningValidationMessage implements IValidationMessage {

    /**
     * 在外選挙人名簿情報の表示日_表示事由のチェック_表示日未入力。
     *
     */
    在外選挙人名簿情報の表示日_表示事由のチェック_表示日未入力(AfErrorMessages.未入力エラー, "表示日"),
    /**
     * 在外選挙人名簿情報の表示日_表示事由のチェック_表示事由未入力。
     *
     */
    在外選挙人名簿情報の表示日_表示事由のチェック_表示事由未入力(AfErrorMessages.未入力エラー, "表示事由"),
    /**
     * 在外選挙人名簿情報の表示日関連のチェック_未来日。
     *
     */
    在外選挙人名簿情報の表示日関連のチェック_未来日("表示日が未来の日付です。<br>"),
    /**
     * 在外選挙人名簿情報の表示日関連のチェック_登録日以降。
     *
     */
    在外選挙人名簿情報の表示日関連のチェック_登録日以降("表示日が登録日より小さくなっています。<br>"),
    /**
     * 在外選挙人名簿情報の国内転入日関連のチェック_表示事由。
     *
     */
    在外選挙人名簿情報の国内転入日関連のチェック_表示事由("表示事由に国内転入が選択されていますが、国内転入日が入力されていません。<br>"),
    /**
     * 在外選挙人名簿情報の国内転入日関連のチェック_抹消事由。
     *
     */
    在外選挙人名簿情報の国内転入日関連のチェック_抹消事由("抹消事由に国内転入4ヶ月経過抹消が選択されていますが、国内転入日が入力されていません。<br>"),
    /**
     * 在外選挙人名簿情報の修正日関連のチェック_未来日。
     *
     */
    在外選挙人名簿情報の修正日関連のチェック_未来日("修正日が未来の日付です。<br>"),
    /**
     * 在外選挙人名簿情報の修正日関連のチェック_登録日以降。
     *
     */
    在外選挙人名簿情報の修正日関連のチェック_登録日以降("修正日が登録日より小さくなっています。<br>");

    private final RString message;

    ZaigaiShuseiWarningValidationMessage(String message) {
        this.message = new RString(message);
    }

    ZaigaiShuseiWarningValidationMessage(IMessageGettable message, String... replacements) {
        this.message = new RString(message.getMessage().replace(replacements).evaluate());
    }

    @Override
    public Message getMessage() {
        return new WarningMessage("", message.toString());
    }
}
