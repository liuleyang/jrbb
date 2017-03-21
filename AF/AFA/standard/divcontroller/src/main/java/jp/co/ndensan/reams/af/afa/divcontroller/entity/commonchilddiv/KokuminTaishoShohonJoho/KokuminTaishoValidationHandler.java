/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminTaishoShohonJoho;

import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 国民投票抄本情報共有子DIVのチェックを実行する。
 *
 * @reamsid_L AF-0360-011 lis
 */
public class KokuminTaishoValidationHandler {

    private final KokuminTaishoShohonJohoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div KokuminTaishoShohonJohoDiv
     */
    public KokuminTaishoValidationHandler(KokuminTaishoShohonJohoDiv div) {
        this.div = div;
    }

    /**
     * 実行ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate基準日と投票日の関係性チェック() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new KokuminTaishoValidator(div).validate基準日と投票日の関係性チェック();
        validateResult.add(createDictionary().check(messages));
        return validateResult;
    }

    /**
     * 実行ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate基準日と受付開始日の関係性チェック() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new KokuminTaishoValidator(div).validate基準日と受付開始日の関係性チェック();
        validateResult.add(createDictionary().check(messages));
        return validateResult;
    }

    /**
     * 実行ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate受付開始日と投票日の関係性チェック() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new KokuminTaishoValidator(div).validate受付開始日と投票日の関係性チェック();
        validateResult.add(createDictionary().check(messages));
        return validateResult;
    }

    /**
     * 実行ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate基準日と特定期限日間の妥当性チェック() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new KokuminTaishoValidator(div).validate基準日と特定期限日間の妥当性チェック();
        validateResult.add(createDictionary().check(messages));
        return validateResult;
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(KokuminTaishoValidationMessage.基準日と投票日の関係性チェック, div.getTxtKijunYMD())
                .add(KokuminTaishoValidationMessage.基準日と受付開始日の関係性チェック, div.getTxtTokuteiKigenYMD())
                .add(KokuminTaishoValidationMessage.受付開始日と投票日の関係性チェック, div.getTxtTokuteiKigenYMD())
                .add(KokuminTaishoValidationMessage.基準日と特定期限日間の妥当性チェック, div.getTxtTohyoUketsukeYMD())
                .build();
    }

}
