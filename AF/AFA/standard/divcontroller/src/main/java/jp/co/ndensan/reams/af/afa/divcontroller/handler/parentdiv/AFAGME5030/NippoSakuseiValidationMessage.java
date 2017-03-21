/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME5030;

import jp.co.ndensan.reams.af.afa.business.core.AFACommonConstant;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * AFAGME5030_日報のチェックロジックです。
 *
 * @reamsid_L AF-0270-010 xul
 */
public enum NippoSakuseiValidationMessage implements IValidationMessage {

    /**
     * 出力対象選択。
     */
    出力対象選択(UrErrorMessages.選択されていない, "出力対象の日報"),
    /**
     * 期日前投票日報　出力チェックボックスがONの場合、投票日開始～終了。
     */
    期日前投票日報の投票日開始(UrErrorMessages.未入力, "投票日開始"),
    /**
     * 期日前投票日報　出力チェックボックスがONの場合、投票日開始～終了。
     */
    期日前投票日報の投票日終了(UrErrorMessages.未入力, "投票日終了"),
    /**
     * 期日前投票日報　出力チェックボックスがONの場合、投票日開始と終了の関係性チェック。
     */
    期日前投票日報の投票日開始と終了の関係性(UrErrorMessages.終了日が開始日以前),
    /**
     * 不在者投票日報　出力チェックボックスがONの場合,交付日と受理日の未選択チェック。
     */
    不在者投票日報の交付日と受理日の未選択(UrErrorMessages.選択されていない, "出力対象の日報"),
    /**
     * 不在者投票日報　出力チェックボックスがONの場合,交付日開始と終了。
     */
    不在者投票日報の交付日開始(UrErrorMessages.未入力, "交付日開始"),
    /**
     * 不在者投票日報　出力チェックボックスがONの場合,交付日開始と終了。
     */
    不在者投票日報の交付日終了(UrErrorMessages.未入力, "交付日終了"),
    /**
     * 不在者投票日報　出力チェックボックスがONの場合,交付日開始と終了関係性。
     */
    不在者投票日報の交付日開始と終了関係性(UrErrorMessages.終了日が開始日以前),
    /**
     * 不在者投票日報　出力チェックボックスがONの場合,受理日開始と終了。
     */
    不在者投票日報の受理日開始(UrErrorMessages.未入力, AFACommonConstant.受理日開始.toString()),
    /**
     * 不在者投票日報　出力チェックボックスがONの場合,受理日開始と終了。
     */
    不在者投票日報の受理日終了(UrErrorMessages.未入力, AFACommonConstant.受理日終了.toString()),
    /**
     * 不在者投票日報　出力チェックボックスがONの場合,受理日開始と終了関係性。
     */
    不在者投票日報の受理日開始と終了関係性(UrErrorMessages.終了日が開始日以前),
    /**
     * 期日前投票者一覧表　出力チェックボックスがONの場合、期日前投票日開始と終了。
     */
    期日前投票者一覧表の期日前投票日開始(UrErrorMessages.未入力, "期日前投票日開始"),
    /**
     * 期日前投票者一覧表　出力チェックボックスがONの場合、期日前投票日開始と終了。
     */
    期日前投票者一覧表の期日前投票日終了(UrErrorMessages.未入力, "期日前投票日終了"),
    /**
     * 期日前投票者一覧表　出力チェックボックスがONの場合
     */
    期日前投票者一覧表の期日前投票日開始と終了関係性(UrErrorMessages.終了日が開始日以前),
    /**
     * 期日前投票者一覧表　出力チェックボックスがONの場合、投票時刻開始と終了。
     */
    期日前投票者一覧表の投票時刻開始(UrErrorMessages.未入力, "投票時刻開始"),
    /**
     * 期日前投票者一覧表　出力チェックボックスがONの場合、投票時刻開始と終了。
     */
    期日前投票者一覧表の投票時刻終了(UrErrorMessages.未入力, "投票時刻終了"),
    /**
     * 期日前投票者一覧表　出力チェックボックスがONの場合、投票時刻開始と終了関係性。
     */
    期日前投票者一覧表の投票時刻開始と終了関係性(UrErrorMessages.大小関係が不正, "投票時刻"),
    /**
     * 不在者投票者一覧表　出力チェックボックスがONの場合,交付日開始と終了。
     */
    不在者投票者一覧表の交付日開始(UrErrorMessages.未入力, "交付日開始"),
    /**
     * 不在者投票者一覧表　出力チェックボックスがONの場合,交付日開始と終了。
     */
    不在者投票者一覧表の交付日終了(UrErrorMessages.未入力, "交付日終了"),
    /**
     * 不在者投票者一覧表　出力チェックボックスがONの場合,交付日開始と終了関係性。
     */
    不在者投票者一覧表の交付日開始と終了関係性(UrErrorMessages.終了日が開始日以前),
    /**
     * 不在者投票者一覧表　出力チェックボックスがONの場合,受理日開始と終了。
     */
    不在者投票者一覧表の受理日開始(UrErrorMessages.未入力, AFACommonConstant.受理日開始.toString()),
    /**
     * 不在者投票者一覧表　出力チェックボックスがONの場合,受理日開始と終了。
     */
    不在者投票者一覧表の受理日終了(UrErrorMessages.未入力, AFACommonConstant.受理日終了.toString()),
    /**
     * 不在者投票者一覧表　出力チェックボックスがONの場合,受理日開始と終了関係性。
     */
    不在者投票者一覧表の受理日開始と終了関係性(UrErrorMessages.終了日が開始日以前),
    /**
     * 不在者投票者一覧表　出力チェックボックスがONの場合、受理時刻開始と終了。
     */
    不在者投票者一覧表の受理時刻開始(UrErrorMessages.未入力, "受理時刻開始"),
    /**
     * 不在者投票者一覧表　出力チェックボックスがONの場合、受理時刻開始と終了。
     */
    不在者投票者一覧表の受理時刻終了(UrErrorMessages.未入力, "受理時刻終了"),
    /**
     * 不在者投票者一覧表　出力チェックボックスがONの場合、受理時刻開始と終了関係性。
     */
    不在者投票者一覧表の受理時刻開始と終了関係性(UrErrorMessages.大小関係が不正, "受理時刻"),
    /**
     * 投票者一覧表　出力チェックボックスがONの場合 不在者投票者のチェックボックスがONの場合,交付日開始～終了
     */
    投票者一覧表の交付日開始(UrErrorMessages.未入力, "交付日開始"),
    /**
     * 投票者一覧表　出力チェックボックスがONの場合 不在者投票者のチェックボックスがONの場合,交付日開始～終了
     */
    投票者一覧表の交付日終了(UrErrorMessages.未入力, "交付日終了"),
    /**
     * 投票者一覧表　出力チェックボックスがONの場合 * 不在者投票者のチェックボックスがONの場合,交付日開始～終了
     */
    投票者一覧表の交付日開始と終了関係性(UrErrorMessages.終了日が開始日以前),
    /**
     * 投票者一覧表　出力チェックボックスがONの場合 不在者投票者のチェックボックスがONの場合,受理日開始～終了
     */
    投票者一覧表の受理日開始(UrErrorMessages.未入力, AFACommonConstant.受理日開始.toString()),
    /**
     * 投票者一覧表　出力チェックボックスがONの場合 不在者投票者のチェックボックスがONの場合,受理日開始～終了
     */
    投票者一覧表の受理日終了(UrErrorMessages.未入力, AFACommonConstant.受理日終了.toString()),
    /**
     * 投票者一覧表　出力チェックボックスがONの場合 不在者投票者のチェックボックスがONの場合,受理日開始～終了
     */
    投票者一覧表の受理日開始と終了関係性(UrErrorMessages.終了日が開始日以前),
    /**
     * 投票者一覧表　出力チェックボックスがONの場合 不在者投票者のチェックボックスがONの場合,受理時刻開始～終了
     */
    投票者一覧表の受理時刻開始(UrErrorMessages.未入力, "受理時刻開始"),
    /**
     * 投票者一覧表　出力チェックボックスがONの場合 不在者投票者のチェックボックスがONの場合,受理時刻開始～終了
     */
    投票者一覧表の受理時刻終了(UrErrorMessages.未入力, "受理時刻終了"),
    /**
     * 投票者一覧表　出力チェックボックスがONの場合 不在者投票者のチェックボックスがONの場合,受理時刻開始～終了
     */
    投票者一覧表の受理時刻開始と終了関係性(UrErrorMessages.大小関係が不正, "受理時刻"),
    /**
     * 投票者一覧表　出力チェックボックスがONの場合 期日前投票者のチェックボックスがONの場合,期日前投票日開始～終了
     */
    投票者一覧表の期日前投票日開始(UrErrorMessages.未入力, "期日前投票日開始"),
    /**
     * 投票者一覧表　出力チェックボックスがONの場合 期日前投票者のチェックボックスがONの場合,期日前投票日開始～終了
     */
    投票者一覧表の期日前投票日終了(UrErrorMessages.未入力, "期日前投票日終了"),
    /**
     * 投票者一覧表　出力チェックボックスがONの場合 期日前投票者のチェックボックスがONの場合,期日前投票日開始～終了
     */
    投票者一覧表の期日前投票日開始と終了関係性(UrErrorMessages.終了日が開始日以前),
    /**
     * 投票者一覧表　出力チェックボックスがONの場合 期日前投票者のチェックボックスがONの場合,投票時刻開始～終了
     */
    投票者一覧表の投票時刻開始(UrErrorMessages.未入力, "投票時刻開始"),
    /**
     * 投票者一覧表　出力チェックボックスがONの場合 期日前投票者のチェックボックスがONの場合,投票時刻開始～終了
     */
    投票者一覧表の投票時刻終了(UrErrorMessages.未入力, "投票時刻終了"),
    /**
     * 投票者一覧表　出力チェックボックスがONの場合 期日前投票者のチェックボックスがONの場合,投票時刻開始～終了
     */
    投票者一覧表の投票時刻開始と終了関係性(UrErrorMessages.大小関係が不正, "投票時刻"),
    /**
     * 投票事由調書　出力チェックボックスがONの場合 期日前投票チェックボックスがONの場合,期日前投票日開始～終了
     */
    投票事由調書の期日前投票日開始(UrErrorMessages.未入力, "期日前投票日開始"),
    /**
     * 投票事由調書　出力チェックボックスがONの場合 期日前投票チェックボックスがONの場合,期日前投票日開始～終了
     */
    投票事由調書の期日前投票日終了(UrErrorMessages.未入力, "期日前投票日終了"),
    /**
     * 投票事由調書　出力チェックボックスがONの場合 期日前投票チェックボックスがONの場合,期日前投票日開始～終了
     */
    投票事由調書の期日前投票日開始と終了関係性(UrErrorMessages.終了日が開始日以前),
    /**
     * 投票者一覧表　出力チェックボックスがONの場合 期日前投票者のチェックボックスがONの場合,受理日開始～終了
     */
    投票事由調書の受理日開始(UrErrorMessages.未入力, AFACommonConstant.受理日開始.toString()),
    /**
     * 投票者一覧表　出力チェックボックスがONの場合 期日前投票者のチェックボックスがONの場合,受理日開始～終了
     */
    投票事由調書の受理日終了(UrErrorMessages.未入力, AFACommonConstant.受理日終了.toString()),
    /**
     * 投票者一覧表　出力チェックボックスがONの場合 期日前投票者のチェックボックスがONの場合,受理日開始～終了
     */
    投票事由調書の受理日開始と終了関係性(UrErrorMessages.終了日が開始日以前);

    private final Message message;

    NippoSakuseiValidationMessage(IMessageGettable message) {
        this.message = message.getMessage();
    }

    NippoSakuseiValidationMessage(IMessageGettable message, String... replacements) {
        this.message = message.getMessage().replace(replacements);
    }

    @Override
    public Message getMessage() {
        return message;
    }

}
