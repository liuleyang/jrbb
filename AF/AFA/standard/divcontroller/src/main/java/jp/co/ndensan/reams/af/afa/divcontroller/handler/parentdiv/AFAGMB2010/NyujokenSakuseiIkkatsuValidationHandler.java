/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB2010;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB2010.NyujokenSakuseiIkkatsuDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 入場券発行（一括）のチェック操作を担当するクラスです。
 *
 * @reamsid_L AF-0160-010 guyq
 */
public class NyujokenSakuseiIkkatsuValidationHandler {

    private final NyujokenSakuseiIkkatsuDiv div;

    /**
     * コンストラクタ生成
     *
     * @param div NyujokenSakuseiKobetsuDiv
     *
     */
    public NyujokenSakuseiIkkatsuValidationHandler(NyujokenSakuseiIkkatsuDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ生成
     *
     * @param div ZaigaiMeiboTorokuDiv
     * @return ZaigaiMeiboTorokuValidationHandler
     */
    public static NyujokenSakuseiIkkatsuValidationHandler of(NyujokenSakuseiIkkatsuDiv div) {
        return new NyujokenSakuseiIkkatsuValidationHandler(div);
    }

    /**
     * 入場券発行（一括）の入力項目をvalidate
     *
     * @return validateResult
     */
    public ValidationMessageControlPairs validateエラーチェックです() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        _NyujokenSakuseiIkkatsuErrorValidator validator = new _NyujokenSakuseiIkkatsuErrorValidator(div);
        validateResult.add(createErrorDictionary().check(validator.validate()));
        return validateResult;
    }

    private ValidationDictionary createErrorDictionary() {
        return new ValidationDictionaryBuilder().
                add(NyujokenSakuseiIkkatsuValidationMessage.出力対象のチェック, div.getNyujokenSakuseiTaisho().getNyujokenSentaku().getChkTaisho()).
                add(NyujokenSakuseiIkkatsuValidationMessage.印刷タイプのチェック, div.getNyujokenSakuseiTaisho().getNyujokenSentaku().getTxtNyujokenType()).
                add(NyujokenSakuseiIkkatsuValidationMessage.世帯印字人数のチェック, div.getNyujokenSakuseiTaisho().getNyujokenSentaku().getTxtPrintNinzutxtNyujokenType()).
                add(NyujokenSakuseiIkkatsuValidationMessage.投票区一覧のチェック, div.getNyujokenSakuseiTaisho().getNyujokenSentaku().getDgNyujokenTohyokuSelect()).
                add(NyujokenSakuseiIkkatsuValidationMessage.転出日Fromのチェック, div.getNyujokenSakuseiTaisho().getNyujokenOshiraseHagaki().getTxtTenshutsuYMDRange()).
                add(NyujokenSakuseiIkkatsuValidationMessage.転出日Toのチェック, div.getNyujokenSakuseiTaisho().getNyujokenOshiraseHagaki().getTxtTenshutsuYMDRange()).
                add(NyujokenSakuseiIkkatsuValidationMessage.転出日Fromと転出日Toのチェック, div.getNyujokenSakuseiTaisho().getNyujokenOshiraseHagaki().getTxtTenshutsuYMDRange()).
                add(NyujokenSakuseiIkkatsuValidationMessage.転出日From不正のチェック, div.getNyujokenSakuseiTaisho().getNyujokenOshiraseHagaki().getTxtTenshutsuYMDRange()).
                add(NyujokenSakuseiIkkatsuValidationMessage.転出日To不正のチェック, div.getNyujokenSakuseiTaisho().getNyujokenOshiraseHagaki().getTxtTenshutsuYMDRange()).
                add(NyujokenSakuseiIkkatsuValidationMessage.抽出対象世帯人数のチェック, div.getNyujokenSakuseiTaisho().getNyujokenSentaku().getTxtSetaiNinzu()).
                build();
    }

    /**
     * 入場券発行（一括）の入力項目をvalidate
     *
     * @return validateResult
     */
    public ValidationMessageControlPairs validateウォーニングチェックです() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        _NyujokenSakuseiIkkatsuWarningValidator validator = new _NyujokenSakuseiIkkatsuWarningValidator(div);
        validateResult.add(createWarningDictionary().check(validator.validate()));
        return validateResult;
    }

    private ValidationDictionary createWarningDictionary() {
        return new ValidationDictionaryBuilder().
                add(NyujokenSakuseiIkkatsuValidationMessage.選挙バッチ実行確認のチェック).
                build();
    }

}
