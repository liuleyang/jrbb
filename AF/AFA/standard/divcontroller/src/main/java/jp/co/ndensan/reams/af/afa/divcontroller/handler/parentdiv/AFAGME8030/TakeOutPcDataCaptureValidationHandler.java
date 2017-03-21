/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME8030;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME8030.TakeOutPcDataCaptureDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 持出端末データ取込のValidationHandlerです。
 *
 * @reamsid_L AF-0690-010 wanghj
 */
public class TakeOutPcDataCaptureValidationHandler {

    private final TakeOutPcDataCaptureDiv div;

    /**
     * コンストラクタです。
     *
     * @param div TakeOutPcDataCaptureDiv
     */
    public TakeOutPcDataCaptureValidationHandler(TakeOutPcDataCaptureDiv div) {
        this.div = div;
    }

    /**
     * ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new TakeOutPcDataCaptureValidator(div).validate();
        validateResult.add(createDictionary().check(messages));

        return validateResult;
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(TakeOutPcDataCaptureValidationMessage.取込対象ファイル必須チェック, div.getUplSelectImportFile())
                .add(TakeOutPcDataCaptureValidationMessage.抄本ファイルチェック, div.getUplSelectImportFile())
                .add(TakeOutPcDataCaptureValidationMessage.投票区確認, div.getUplSelectImportFile())
                .add(TakeOutPcDataCaptureValidationMessage.投票日確認, div.getUplSelectImportFile())
                .add(TakeOutPcDataCaptureValidationMessage.投票状況ファイルチェック, div.getUplSelectImportFile())
                .build();
    }

}
