/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME5030;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5030.NippoSakuseiDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * AFAGME5030_日報のチェックロジックです。
 *
 * @reamsid_L AF-0270-010 xul
 */
public class NippoSakuseiValidator {

    private final NippoSakuseiDiv div;

    /**
     * 出力対象のバリデーションです。
     *
     * @param div NippoSakuseiDiv
     */
    public NippoSakuseiValidator(NippoSakuseiDiv div) {
        this.div = div;
    }

    /**
     * 出力対象のバリデーションです。
     *
     * @return バリデーションメッセージ
     */
    public IValidationMessages validate出力対象() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(NippoSakuseiSpec.出力対象選択チェック)
                .thenAdd(NippoSakuseiValidationMessage.出力対象選択)
                .messages());

        return messages;
    }

    /**
     * 「期日前投票日報」出力チェックボックスがONの場合,バリデーションです。
     *
     * @return バリデーションメッセージ
     */
    public IValidationMessages validate期日前投票日報() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(NippoSakuseiSpec.期日前投票日報の投票日開始チェック)
                .thenAdd(NippoSakuseiValidationMessage.期日前投票日報の投票日開始)
                .ifNot(NippoSakuseiSpec.期日前投票日報の投票日終了チェック)
                .thenAdd(NippoSakuseiValidationMessage.期日前投票日報の投票日終了)
                .ifNot(NippoSakuseiSpec.期日前投票日報の投票日開始と終了関係性チェック)
                .thenAdd(NippoSakuseiValidationMessage.期日前投票日報の投票日開始と終了の関係性)
                .messages());
        return messages;
    }

    /**
     * 「不在者投票日報」出力チェックボックスがONの場合,バリデーションです。
     *
     * @return バリデーションメッセージ
     */
    public IValidationMessages validate不在者投票日報() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(NippoSakuseiSpec.不在者投票日報の交付日と受理日の未選択チェック)
                .thenAdd(NippoSakuseiValidationMessage.不在者投票日報の交付日と受理日の未選択)
                .ifNot(NippoSakuseiSpec.不在者投票日報の交付日開始チェック)
                .thenAdd(NippoSakuseiValidationMessage.不在者投票日報の交付日開始)
                .ifNot(NippoSakuseiSpec.不在者投票日報の交付日終了チェック)
                .thenAdd(NippoSakuseiValidationMessage.不在者投票日報の交付日終了)
                .ifNot(NippoSakuseiSpec.不在者投票日報の交付日開始と終了の関係性チェック)
                .thenAdd(NippoSakuseiValidationMessage.不在者投票日報の交付日開始と終了関係性)
                .ifNot(NippoSakuseiSpec.不在者投票日報の受理日開始チェック)
                .thenAdd(NippoSakuseiValidationMessage.不在者投票日報の受理日開始)
                .ifNot(NippoSakuseiSpec.不在者投票日報の受理日終了チェック)
                .thenAdd(NippoSakuseiValidationMessage.不在者投票日報の受理日終了)
                .ifNot(NippoSakuseiSpec.不在者投票日報の受理日開始と終了の関係性チェック)
                .thenAdd(NippoSakuseiValidationMessage.不在者投票日報の受理日開始と終了関係性)
                .messages());

        return messages;
    }

    /**
     * 「期日前投票者一覧表」出力チェックボックスがONの場合,バリデーションです。
     *
     * @return バリデーションメッセージ
     */
    public IValidationMessages validate期日前投票者一覧表() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(NippoSakuseiSpec.期日前投票者一覧表の期日前投票日開始チェック)
                .thenAdd(NippoSakuseiValidationMessage.期日前投票者一覧表の期日前投票日開始)
                .ifNot(NippoSakuseiSpec.期日前投票者一覧表の期日前投票日終了チェック)
                .thenAdd(NippoSakuseiValidationMessage.期日前投票者一覧表の期日前投票日終了)
                .ifNot(NippoSakuseiSpec.期日前投票者一覧表の期日前投票日開始と終了の関係性チェック)
                .thenAdd(NippoSakuseiValidationMessage.期日前投票者一覧表の期日前投票日開始と終了関係性)
                .ifNot(NippoSakuseiSpec.期日前投票者一覧表の投票時刻開始チェック)
                .thenAdd(NippoSakuseiValidationMessage.期日前投票者一覧表の投票時刻開始)
                .ifNot(NippoSakuseiSpec.期日前投票者一覧表の投票時刻終了チェック)
                .thenAdd(NippoSakuseiValidationMessage.期日前投票者一覧表の投票時刻終了)
                .ifNot(NippoSakuseiSpec.期日前投票者一覧表の投票時刻開始と終了関係性チェック)
                .thenAdd(NippoSakuseiValidationMessage.期日前投票者一覧表の投票時刻開始と終了関係性)
                .messages());

        return messages;
    }

    /**
     * 「不在者投票者一覧表」出力チェックボックスがONの場合,バリデーションです。
     *
     * @return バリデーションメッセージ
     */
    public IValidationMessages validate不在者投票者一覧表() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(NippoSakuseiSpec.不在者投票者一覧表の交付日開始チェック)
                .thenAdd(NippoSakuseiValidationMessage.不在者投票者一覧表の交付日開始)
                .ifNot(NippoSakuseiSpec.不在者投票者一覧表の交付日終了チェック)
                .thenAdd(NippoSakuseiValidationMessage.不在者投票者一覧表の交付日終了)
                .ifNot(NippoSakuseiSpec.不在者投票者一覧表の交付日開始と終了関係性チェック)
                .thenAdd(NippoSakuseiValidationMessage.不在者投票者一覧表の交付日開始と終了関係性)
                .ifNot(NippoSakuseiSpec.不在者投票者一覧表の受理日開始チェック)
                .thenAdd(NippoSakuseiValidationMessage.不在者投票者一覧表の受理日開始)
                .ifNot(NippoSakuseiSpec.不在者投票者一覧表の受理日終了チェック)
                .thenAdd(NippoSakuseiValidationMessage.不在者投票者一覧表の受理日終了)
                .ifNot(NippoSakuseiSpec.不在者投票者一覧表の受理日開始と終了関係性チェック)
                .thenAdd(NippoSakuseiValidationMessage.不在者投票者一覧表の受理日開始と終了関係性)
                .ifNot(NippoSakuseiSpec.不在者投票者一覧表の受理時刻開始チェック)
                .thenAdd(NippoSakuseiValidationMessage.不在者投票者一覧表の受理時刻開始)
                .ifNot(NippoSakuseiSpec.不在者投票者一覧表の受理時刻終了チェック)
                .thenAdd(NippoSakuseiValidationMessage.不在者投票者一覧表の受理時刻終了)
                .ifNot(NippoSakuseiSpec.不在者投票者一覧表の受理時刻開始と終了関係性チェック)
                .thenAdd(NippoSakuseiValidationMessage.不在者投票者一覧表の受理時刻開始と終了関係性)
                .messages());

        return messages;
    }

    /**
     * 「投票者一覧表」出力チェックボックスがONの場合,バリデーションです。
     *
     * @return バリデーションメッセージ
     */
    public IValidationMessages validate投票者一覧表() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(NippoSakuseiSpec.不在者投票者の交付日開始チェック)
                .thenAdd(NippoSakuseiValidationMessage.投票者一覧表の交付日開始)
                .ifNot(NippoSakuseiSpec.不在者投票者の交付日終了チェック)
                .thenAdd(NippoSakuseiValidationMessage.投票者一覧表の交付日終了)
                .ifNot(NippoSakuseiSpec.不在者投票者の交付日開始と終了関係性チェック)
                .thenAdd(NippoSakuseiValidationMessage.投票者一覧表の交付日開始と終了関係性)
                .ifNot(NippoSakuseiSpec.不在者投票者の受理日開始チェック)
                .thenAdd(NippoSakuseiValidationMessage.投票者一覧表の受理日開始)
                .ifNot(NippoSakuseiSpec.不在者投票者の受理日終了チェック)
                .thenAdd(NippoSakuseiValidationMessage.投票者一覧表の受理日終了)
                .ifNot(NippoSakuseiSpec.不在者投票者の受理日開始と終了関係性チェック)
                .thenAdd(NippoSakuseiValidationMessage.投票者一覧表の受理日開始と終了関係性)
                .ifNot(NippoSakuseiSpec.不在者投票者の受理時刻開始チェック)
                .thenAdd(NippoSakuseiValidationMessage.投票者一覧表の受理時刻開始)
                .ifNot(NippoSakuseiSpec.不在者投票者の受理時刻終了チェック)
                .thenAdd(NippoSakuseiValidationMessage.投票者一覧表の受理時刻終了)
                .ifNot(NippoSakuseiSpec.不在者投票者の受理時刻開始と終了関係性チェック)
                .thenAdd(NippoSakuseiValidationMessage.投票者一覧表の受理時刻開始と終了関係性)
                .ifNot(NippoSakuseiSpec.期日前投票者の期日前投票日開始チェック)
                .thenAdd(NippoSakuseiValidationMessage.投票者一覧表の期日前投票日開始)
                .ifNot(NippoSakuseiSpec.期日前投票者の期日前投票日終了チェック)
                .thenAdd(NippoSakuseiValidationMessage.投票者一覧表の期日前投票日終了)
                .ifNot(NippoSakuseiSpec.期日前投票者の期日前投票日開始と終了関係性チェック)
                .thenAdd(NippoSakuseiValidationMessage.投票者一覧表の期日前投票日開始と終了関係性)
                .ifNot(NippoSakuseiSpec.期日前投票者の投票時刻開始チェック)
                .thenAdd(NippoSakuseiValidationMessage.投票者一覧表の投票時刻開始)
                .ifNot(NippoSakuseiSpec.期日前投票者の投票時刻終了チェック)
                .thenAdd(NippoSakuseiValidationMessage.投票者一覧表の投票時刻開始)
                .ifNot(NippoSakuseiSpec.期日前投票者の投票時刻開始と終了関係性チェック)
                .thenAdd(NippoSakuseiValidationMessage.投票者一覧表の投票時刻開始と終了関係性)
                .messages());

        return messages;
    }

    /**
     * 「投票事由調書」出力チェックボックスがONの場合,バリデーションです。
     *
     * @return バリデーションメッセージ
     */
    public IValidationMessages validate投票事由調書() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(NippoSakuseiSpec.投票事由調書の期日前投票日開始チェック)
                .thenAdd(NippoSakuseiValidationMessage.投票事由調書の期日前投票日開始)
                .ifNot(NippoSakuseiSpec.投票事由調書の期日前投票日終了チェック)
                .thenAdd(NippoSakuseiValidationMessage.投票事由調書の期日前投票日終了)
                .ifNot(NippoSakuseiSpec.投票事由調書の期日前投票日開始と終了関係性チェック)
                .thenAdd(NippoSakuseiValidationMessage.投票事由調書の期日前投票日開始と終了関係性)
                .ifNot(NippoSakuseiSpec.投票事由調書の受理日開始チェック)
                .thenAdd(NippoSakuseiValidationMessage.投票事由調書の受理日開始)
                .ifNot(NippoSakuseiSpec.投票事由調書の受理日終了チェック)
                .thenAdd(NippoSakuseiValidationMessage.投票事由調書の受理日終了)
                .ifNot(NippoSakuseiSpec.投票事由調書の受理日開始と終了関係性チェック)
                .thenAdd(NippoSakuseiValidationMessage.投票事由調書の受理日開始と終了関係性)
                .messages());

        return messages;
    }

}
