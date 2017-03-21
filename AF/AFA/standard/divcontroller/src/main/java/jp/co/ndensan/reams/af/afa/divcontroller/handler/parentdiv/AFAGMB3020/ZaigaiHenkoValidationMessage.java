/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB3020;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 証明書記載事項変更のチェックメッセージクラスです。
 *
 * @reamsid_L AF-0330-010 guancy
 */
public enum ZaigaiHenkoValidationMessage implements IValidationMessage {

    /**
     * 在住情報の住定日関連のチェック_未来日。
     */
    在住情報の住定日関連のチェック_未来日("住定日が未来の日付です。<br>"),
    /**
     * 在住情報の住定日関連のチェック_転出日以降。
     */
    在住情報の住定日関連のチェック_転出日以降("住定日が転出日より小さくなっています。<br>"),
    /**
     * 本人情報の最終住所エリアの転出日関連のチェック。
     */
    本人情報の最終住所エリアの転出日関連のチェック("転出日が未来の日付です。<br>"),
    /**
     * 申請情報の申請日関連のチェック_未来日。
     */
    申請情報の申請日関連のチェック_未来日("申請日が未来の日付です。<br>"),
    /**
     * 申請情報の申請日関連のチェック_住定日以降。
     */
    申請情報の申請日関連のチェック_住定日以降("申請日が住定日より小さくなっています。<br>"),
    /**
     * 申請情報の申請取下げ日関連のチェック_未来日。
     */
    申請情報の申請取下げ日関連のチェック_未来日("申請取り下げ日が未来の日付です。<br>"),
    /**
     * 申請情報の申請取下げ日関連のチェック_申請日以降。
     */
    申請情報の申請取下げ日関連のチェック_申請日以降("申請取下げ日が申請日より小さくなっています。<br>"),
    /**
     * 在外選挙人名簿情報の登録日関連のチェック_未来日。
     */
    在外選挙人名簿情報の登録日関連のチェック_未来日("登録日が未来の日付です。<br>"),
    /**
     * 在外選挙人名簿情報の登録日関連のチェック_申請日以降。
     */
    在外選挙人名簿情報の登録日関連のチェック_申請日以降("登録日が申請日より小さくなっています。<br>"),
    /**
     * 在外選挙人名簿情報の登録日関連のチェック_規定年齢到達日。
     */
    在外選挙人名簿情報の登録日関連のチェック_規定年齢到達日("登録日が規定年齢到達日より小さくなっています。<br>"),
    /**
     * 在外選挙人名簿情報の登録日関連のチェック_転入3か月経過。
     */
    在外選挙人名簿情報の登録日関連のチェック_転入3か月経過("登録日が転入3ヶ月経過日より小さくなっています。<br>"),
    /**
     * 申請情報の選挙人証交付日関連のチェック_未来日。
     */
    申請情報の選挙人証交付日関連のチェック_未来日("選挙人証交付日が未来の日付です。<br>"),
    /**
     * 申請情報の選挙人証交付日関連のチェック_登録日以降。
     */
    申請情報の選挙人証交付日関連のチェック_登録日以降("選挙人証交付日が登録日より小さくなっています。<br>"),
    /**
     * 申請情報の選挙人証交付日関連のチェック_交付履歴。
     */
    申請情報の選挙人証交付日関連のチェック_交付履歴("選挙人証交付日が前回の交付日以前になっています。<br>"),
    /**
     * 在外選挙人名簿情報の表示日関連のチェック_未来日。
     */
    在外選挙人名簿情報の表示日関連のチェック_未来日("表示日が未来の日付です。<br>"),
    /**
     * 在外選挙人名簿情報の表示日関連のチェック_登録日以降。
     */
    在外選挙人名簿情報の表示日関連のチェック_登録日以降("表示日が登録日より小さくなっています。<br>"),
    /**
     * 在外選挙人名簿情報の国内転入日関連のチェック_表示事由。
     */
    在外選挙人名簿情報の国内転入日関連のチェック_表示事由("表示事由に国内転入が選択されていますが、国内転入日が入力されていません。<br>"),
    /**
     * 在外選挙人名簿情報の国内転入日関連のチェック_抹消事由。
     */
    在外選挙人名簿情報の国内転入日関連のチェック_抹消事由("抹消事由に国内転入4ヶ月経過抹消が選択されていますが、国内転入日が入力されていません。<br>"),
    /**
     * 在外選挙人名簿情報の修正日関連のチェック_未来日。
     */
    在外選挙人名簿情報の修正日関連のチェック_未来日("修正日が未来の日付です。<br>"),
    /**
     * 在外選挙人名簿情報の修正日関連のチェック_登録日以降。
     */
    在外選挙人名簿情報の修正日関連のチェック_登録日以降("修正日が登録日より小さくなっています。<br>"),
    /**
     * 申請取下げ日取下げ事由のチェック_申請取下げ日未入力。
     */
    申請取下げ日取下げ事由のチェック_申請取下げ日未入力("申請取下げ日が未入力です。<br>"),
    /**
     * 申請取下げ日取下げ事由のチェック_取下げ事由未入力。
     */
    申請取下げ日取下げ事由のチェック_取下げ事由未入力("取下げ事由が未入力です。<br>"),
    /**
     * 却下日却下事由のチェック_却下日未入力。
     */
    却下日却下事由のチェック_却下日未入力("却下日が未入力です。<br>"),
    /**
     * 却下日却下事由のチェック_却下事由未入力。
     */
    却下日却下事由のチェック_却下事由未入力("却下事由が未入力です。<br>"),
    /**
     * 表示日表示事由のチェック_表示日未入力。
     */
    表示日表示事由のチェック_表示日未入力("表示日が未入力です。<br>"),
    /**
     * 表示日表示事由のチェック_表示事由未入力。
     */
    表示日表示事由のチェック_表示事由未入力("表示事由が未入力です。<br>"),
    /**
     * 抹消日抹消事由のチェック_抹消日未入力。
     */
    抹消日抹消事由のチェック_抹消日未入力("抹消日が未入力です。<br>"),
    /**
     * 抹消日抹消事由のチェック_抹消事由未入力。
     */
    抹消日抹消事由のチェック_抹消事由未入力("抹消事由が未入力です。<br>");

    private final RString message;

    ZaigaiHenkoValidationMessage(String message) {
        this.message = new RString(message);
    }

    @Override
    public Message getMessage() {
        return new ErrorMessage("", message.toString());
    }
}
