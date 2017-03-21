/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM3010;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM3010.MasterCsvOutputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 住民投票時登録のバリデーションハンドラです。
 *
 * @reamsid_L AF-0450-010 lis
 */
public class MasterCsvOutputValidationHandler {

    private final MasterCsvOutputDiv div;

    /**
     * コンストラクタです。
     *
     * @param div MasterCsvOutputDiv
     */
    public MasterCsvOutputValidationHandler(MasterCsvOutputDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ生成
     *
     * @param div 住民投票時登録のDiv
     * @return 住民投票時登録のハンドラ
     */
    public static MasterCsvOutputValidationHandler of(MasterCsvOutputDiv div) {
        return new MasterCsvOutputValidationHandler(div);
    }

    /**
     * validateチェックです
     *
     * @return チェック結果
     */
    public ValidationMessageControlPairs validateチェック() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new MasterCsvOutputValidator(div).validate();
        validateResult.add(createErrorDictionary().check(messages));
        return validateResult;
    }

    private ValidationDictionary createErrorDictionary() {
        return new ValidationDictionaryBuilder()
                .add(MasterCsvOutputValidationMessage.出力対象マスタ未選択,
                        div.getMasterCsvOutputParam())
                .add(MasterCsvOutputValidationMessage.投票区必須,
                        div.getMasterCsvOutputParam().getChkTohyoku())
                .build();
    }
}
