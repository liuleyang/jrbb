/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB2020;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB2020.NyujokenSakuseiKobetsuDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 入場券発行（個別）のチェック操作を担当するクラスです。
 *
 * @reamsid_L AF-0170-010 jihb
 */
public class NyujokenSakuseiKobetsuValidationHandler {

    private final NyujokenSakuseiKobetsuDiv div;

    /**
     * コンストラクタ生成
     *
     * @param div NyujokenSakuseiKobetsuDiv
     *
     */
    public NyujokenSakuseiKobetsuValidationHandler(NyujokenSakuseiKobetsuDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ生成
     *
     * @param div ZaigaiMeiboTorokuDiv
     * @return ZaigaiMeiboTorokuValidationHandler
     */
    public static NyujokenSakuseiKobetsuValidationHandler of(NyujokenSakuseiKobetsuDiv div) {
        return new NyujokenSakuseiKobetsuValidationHandler(div);
    }

    /**
     * 入場券発行（個別）の入力項目をvalidate
     *
     * @return validateResult
     */
    public ValidationMessageControlPairs validateエラーチェックです() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        _NyujokenSakuseiKobetsuErrorValidator validator = new _NyujokenSakuseiKobetsuErrorValidator(div);
        validateResult.add(createErrorDictionary().check(validator.validate()));
        return validateResult;
    }

    private ValidationDictionary createErrorDictionary() {
        return new ValidationDictionaryBuilder().
                add(NyujokenSakuseiKobetsuValidationMessage.印刷タイプのチェック, div.getNyujokenKobetsuSakuseiTaisho().getNyujokenKobetsuSentaku().getTxtNyujokenType()).
                add(NyujokenSakuseiKobetsuValidationMessage.世帯印字人数のチェック, div.getNyujokenKobetsuSakuseiTaisho().getNyujokenKobetsuSentaku().getTxtPrintNinzutxtNyujokenType()).
                add(NyujokenSakuseiKobetsuValidationMessage.選挙人一覧のチェック).
                add(NyujokenSakuseiKobetsuValidationMessage.同一世帯の人が複数選択のチェック, div.getNyujokenKobetsuSakuseiTaisho().getNyujokenKobetsuSentaku().getDgNyujokenKobetsuTaishosha()).
                build();
    }

    /**
     * 入場券発行（個別）の入力項目をvalidate
     *
     * @return validateResult
     */
    public ValidationMessageControlPairs validateウォーニングチェックです() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        _NyujokenSakuseiKobetsuWarningValidator validator = new _NyujokenSakuseiKobetsuWarningValidator(div);
        validateResult.add(createWarningDictionary().check(validator.validate()));
        return validateResult;
    }

    private ValidationDictionary createWarningDictionary() {
        return new ValidationDictionaryBuilder().
                add(NyujokenSakuseiKobetsuValidationMessage.選挙バッチ実行確認のチェック).
                build();
    }

}
