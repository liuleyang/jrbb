/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShikakuJoho;

import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * ShikakuJohoDiv のチェックロジックです。
 *
 * @reamsid_L AF-0180-015 lis2
 */
public class ShikakuJohoValidationHandler {

    private final ShikakuJohoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ShikakuJohoDiv
     */
    public ShikakuJohoValidationHandler(ShikakuJohoDiv div) {
        this.div = div;
    }

    /**
     * 実行ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate表示日と表示事由チェック() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        ShikakuJohoErrorValidator validator = new ShikakuJohoErrorValidator(div);
        validateResult.add(createErrorDictionary().check(validator.validate表示日と表示事由()));
        return validateResult;
    }

    /**
     * 実行ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate登録停止者変更時のチェック() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        ShikakuJohoErrorValidator validator = new ShikakuJohoErrorValidator(div);
        validateResult.add(createErrorDictionary().check(validator.validate登録停止者変更時()));
        return validateResult;
    }

    /**
     * 実行ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate表示消除予定年月日チェック() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        ShikakuJohoErrorValidator validator = new ShikakuJohoErrorValidator(div);
        validateResult.add(createErrorDictionary().check(validator.validate表示消除予定年月日()));
        return validateResult;
    }

    /**
     * 実行ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate表示消除年月日チェック() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        ShikakuJohoErrorValidator validator = new ShikakuJohoErrorValidator(div);
        validateResult.add(createErrorDictionary().check(validator.validate表示消除年月日()));
        return validateResult;
    }

    /**
     * 実行ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate転出時の住民種別チェック() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        ShikakuJohoErrorValidator validator = new ShikakuJohoErrorValidator(div);
        validateResult.add(createErrorDictionary().check(validator.validate転出時の住民種別()));
        return validateResult;
    }

    /**
     * 実行ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate同一日チェック() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        ShikakuJohoErrorValidator validator = new ShikakuJohoErrorValidator(div);
        validateResult.add(createErrorDictionary().check(validator.validate同一日()));
        return validateResult;
    }

    /**
     * 実行ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate登録年月日と表示年月日の関連チェック() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        ShikakuJohoErrorValidator validator = new ShikakuJohoErrorValidator(div);
        validateResult.add(createErrorDictionary().check(validator.validate登録年月日と表示年月日の関連()));
        return validateResult;
    }

    /**
     * 実行ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate登録年月日と抹消年月日の関連チェック() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        ShikakuJohoErrorValidator validator = new ShikakuJohoErrorValidator(div);
        validateResult.add(createErrorDictionary().check(validator.validate登録年月日と抹消年月日の関連()));
        return validateResult;
    }

    /**
     * 実行ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate抹消理由と抹消年月日入力チェック() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        ShikakuJohoErrorValidator validator = new ShikakuJohoErrorValidator(div);
        validateResult.add(createErrorDictionary().check(validator.validate抹消事由と抹消年月日入力()));
        return validateResult;
    }

    /**
     * 実行ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate抹消理由と住民種別のチェック() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        ShikakuJohoErrorValidator validator = new ShikakuJohoErrorValidator(div);
        validateResult.add(createErrorDictionary().check(validator.validate抹消理由と住民種別()));
        return validateResult;
    }

    /**
     * 実行ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate入力日付のチェック() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        ShikakuJohoErrorValidator validator = new ShikakuJohoErrorValidator(div);
        validateResult.add(createErrorDictionary().check(validator.validate入力日付()));
        return validateResult;
    }

    /**
     * 実行ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate抹消異動日関連チェック() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        ShikakuJohoErrorValidator validator = new ShikakuJohoErrorValidator(div);
        validateResult.add(createErrorDictionary().check(validator.validate抹消異動日関連()));
        return validateResult;
    }

    /**
     * 実行ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate住登外チェック() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        ShikakuJohoErrorValidator validator = new ShikakuJohoErrorValidator(div);
        validateResult.add(createErrorDictionary().check(validator.validate住登外()));
        return validateResult;
    }
    
    public ValidationMessageControlPairs validate選挙資格の有無チェック() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        ShikakuJohoErrorValidator validator = new ShikakuJohoErrorValidator(div);
        validateResult.add(createErrorDictionary().check(validator.validate選挙資格の有無()));
        return validateResult;
    }

    public ValidationMessageControlPairs validate登録対象外Warnチェック() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        ShikakuJohoWarnValidator validator = new ShikakuJohoWarnValidator(div);
        validateResult.add(createErrorDictionary().check(validator.validate登録対象外Warn()));
        return validateResult;
    }

    private ValidationDictionary createErrorDictionary() {
        return new ValidationDictionaryBuilder().
                add(ShikakuJohoValidationMessage.経過日3ヶ月チェック, div.getTxtMeiboTorokuYMD()).
                add(ShikakuJohoValidationMessage.表示日と表示事由のチェック1, div.getTxtHyojiYMD()).
                add(ShikakuJohoValidationMessage.表示日と表示事由のチェック2, div.getCcdHyojiJiyu().getDdlJiyuNameList()).
                add(ShikakuJohoValidationMessage.登録停止者変更時のチェック).
                add(ShikakuJohoValidationMessage.登録停止日と登録停止事由のチェック1, div.getTxtTorokuTeishiYMD()).
                add(ShikakuJohoValidationMessage.登録停止日と登録停止事由のチェック2, div.getCcdTorokuTeishiJiyu().getDdlJiyuNameList()).
                add(ShikakuJohoValidationMessage.登録停止事由と表示事由のチェック, div.getCcdTorokuTeishiJiyu().getDdlJiyuNameList(), div.getCcdHyojiJiyu().getDdlJiyuNameList()).
                add(ShikakuJohoValidationMessage.表示消除予定日と表示日のチェック, div.getTxtHyojiShojoYoteiYMD(), div.getTxtHyojiYMD()).
                add(ShikakuJohoValidationMessage.表示消除予定日と表示事由のチェック１, div.getCcdHyojiJiyu().getDdlJiyuNameList()).
                add(ShikakuJohoValidationMessage.表示消除予定日と表示事由のチェック２, div.getCcdHyojiJiyu().getDdlJiyuNameList()).
                add(ShikakuJohoValidationMessage.表示消除予定日と名簿登録日のチェック, div.getTxtHyojiShojoYoteiYMD(), div.getTxtMeiboTorokuYMD()).
                add(ShikakuJohoValidationMessage.表示消除日と表示日のチェック, div.getTxtHyojiShojoYMD(), div.getTxtHyojiYMD()).
                add(ShikakuJohoValidationMessage.表示消除日と表示事由のチェック１, div.getTxtHyojiShojoYMD(), div.getCcdHyojiJiyu().getDdlJiyuNameList()).
                add(ShikakuJohoValidationMessage.表示消除日と表示事由のチェック２, div.getTxtHyojiShojoYMD(), div.getCcdHyojiJiyu().getDdlJiyuNameList()).
                add(ShikakuJohoValidationMessage.表示消除日と名簿登録日のチェック, div.getTxtHyojiShojoYMD(), div.getTxtMeiboTorokuYMD()).
                add(ShikakuJohoValidationMessage.転出時の住民種別と状態チェック１, div.getCcdHyojiJiyu().getDdlJiyuNameList()).
                add(ShikakuJohoValidationMessage.転出の表示日と消除異動年月日同一日チェック, div.getTxtHyojiYMD(), div.getCcdHyojiJiyu().getDdlJiyuNameList()).
                add(ShikakuJohoValidationMessage.転出の表示日と消除届出年月日同一日チェック, div.getTxtHyojiYMD(), div.getCcdHyojiJiyu().getDdlJiyuNameList()).
                add(ShikakuJohoValidationMessage.表示年月日と登録日チェック, div.getTxtHyojiYMD(), div.getTxtMeiboTorokuYMD()).
                add(ShikakuJohoValidationMessage.登録停止日と登録日チェック, div.getTxtTorokuTeishiYMD(), div.getTxtMeiboTorokuYMD()).
                add(ShikakuJohoValidationMessage.名簿登録日と抹消年月日チェック, div.getTxtMasshoYMD(), div.getTxtMeiboTorokuYMD()).
                add(ShikakuJohoValidationMessage.抹消事由と抹消年月日入力チェック1, div.getCcdMasshoJiyu().getDdlJiyuNameList()).
                add(ShikakuJohoValidationMessage.抹消事由と抹消年月日入力チェック2, div.getTxtMasshoYMD()).
                add(ShikakuJohoValidationMessage.抹消事由と住民種別と状態チェック１, div.getCcdMasshoJiyu().getDdlJiyuNameList()).
                add(ShikakuJohoValidationMessage.抹消事由と住民種別と状態チェック２, div.getCcdMasshoJiyu().getDdlJiyuNameList()).
                add(ShikakuJohoValidationMessage.入力日付チェック５, div.getTxtMasshoYMD()).
                add(ShikakuJohoValidationMessage.入力日付チェック６, div.getTxtMeiboTorokuYMD(), div.getTxtMasshoYMD()).
                add(ShikakuJohoValidationMessage.入力日付チェック７, div.getTxtMasshoYMD(), div.getTxtTorokuTeishiYMD()).
                add(ShikakuJohoValidationMessage.入力日付チェック８, div.getTxtMasshoYMD(), div.getTxtHyojiYMD()).
                add(ShikakuJohoValidationMessage.抹消異動日関連チェック１, div.getTxtMasshoYMD(), div.getCcdMasshoJiyu().getDdlJiyuNameList()).
                add(ShikakuJohoValidationMessage.抹消異動日関連チェック２, div.getTxtMasshoYMD(), div.getCcdMasshoJiyu().getDdlJiyuNameList()).
                add(ShikakuJohoValidationMessage.抹消異動日関連チェック３, div.getTxtMasshoYMD(), div.getCcdMasshoJiyu().getDdlJiyuNameList()).
                add(ShikakuJohoValidationMessage.抹消異動日関連チェック４, div.getTxtMasshoYMD(), div.getCcdMasshoJiyu().getDdlJiyuNameList()).
                add(ShikakuJohoValidationMessage.抹消異動日関連チェック５, div.getTxtMasshoYMD(), div.getCcdMasshoJiyu().getDdlJiyuNameList()).
                add(ShikakuJohoValidationMessage.住登外チェック).
                add(ShikakuJohoValidationMessage.選挙資格有無チェック).
                add(ShikakuJohoValidationMessage.年齢未満チェック).
                add(ShikakuJohoValidationMessage.外国人チェック).
                build();
    }

    /**
     * 実行ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate経過日3ヶ月チェック() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        ShikakuJohoWarnValidator validator = new ShikakuJohoWarnValidator(div);
        validateResult.add(createErrorDictionary().check(validator.validate経過日3ヶ月()));
        return validateResult;
    }

    /**
     * 資格情報共有子DIVの入力項目をvalidate
     *
     * @return validateResult
     */
    public ValidationMessageControlPairs validate入力日付ウォーニングチェックです() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        ShikakuJohoWarnValidator validator = new ShikakuJohoWarnValidator(div);
        validateResult.add(createWarningDictionary().check(validator.validate入力日付Warn()));
        return validateResult;
    }

    /**
     * 資格情報共有子DIVの入力項目をvalidate
     *
     * @return validateResult
     */
    public ValidationMessageControlPairs validate転出時の住民種別ウォーニングチェックです() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        ShikakuJohoWarnValidator validator = new ShikakuJohoWarnValidator(div);
        validateResult.add(createWarningDictionary().check(validator.validate転出時の住民種別Warn()));
        return validateResult;
    }

    /**
     * 資格情報共有子DIVの入力項目をvalidate
     *
     * @return validateResult
     */
    public ValidationMessageControlPairs validate登録対象外ウォーニングチェックです() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        ShikakuJohoWarnValidator validator = new ShikakuJohoWarnValidator(div);
        validateResult.add(createWarningDictionary().check(validator.validate登録対象外Warn()));
        return validateResult;
    }

    private ValidationDictionary createWarningDictionary() {
        return new ValidationDictionaryBuilder().
                add(ShikakuJohoValidationMessage.入力日付チェック５, div.getTxtMasshoYMD()).
                add(ShikakuJohoValidationMessage.表示日の未来日チェック, div.getTxtHyojiYMD()).
                add(ShikakuJohoValidationMessage.登録停止日の未来日チェック, div.getTxtTorokuTeishiYMD()).
                add(ShikakuJohoValidationMessage.年齢未満チェック, div).
                add(ShikakuJohoValidationMessage.外国人チェック, div).
                build();
    }

}
