/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMK1010;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMK1010.KaikuMeiboSakuseiDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 選挙人当初登録のバリデーションハンドラです。
 *
 * @reamsid_L AF-0460-010 liuyj
 */
public class KaikuMeiboSakuseiValidationHandler {

    private final KaikuMeiboSakuseiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div KaikuMeiboSakuseiDiv
     */
    public KaikuMeiboSakuseiValidationHandler(KaikuMeiboSakuseiDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ生成
     *
     * @param div 選挙人当初登録のDiv
     * @return 選挙人当初登録のハンドラ
     */
    public static KaikuMeiboSakuseiValidationHandler of(KaikuMeiboSakuseiDiv div) {
        return new KaikuMeiboSakuseiValidationHandler(div);
    }

    /**
     * validateチェックです
     *
     * @return チェック結果
     */
    public ValidationMessageControlPairs validateチェック() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new KaikuMeiboSakuseiValidator(div).validate();
        validateResult.add(createErrorDictionary().check(messages));
        return validateResult;
    }

    private ValidationDictionary createErrorDictionary() {
        return new ValidationDictionaryBuilder().
                add(KaikuMeiboSakuseiValidationWarningMessage.名簿確定日自動算出日付の確認, div.getKaikuMeiboKoshinKijun().getTxtKakuteiYMD()).
                add(KaikuMeiboSakuseiValidationWarningMessage.年齢到達日自動算出日付の確認, div.getKaikuMeiboKoshinKijun().getTxtNenreiTotatsuYMD()).
                build();
    }
}
