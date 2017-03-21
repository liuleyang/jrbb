/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME8010;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME8010.TakeOutPcDataCreateDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 持出端末用データ作成のバリデーションハンドラです。
 *
 * @reamsid_L AF-0790-010 wanghj
 */
public class TakeOutPcDataCreateValidationHandler {

    private final TakeOutPcDataCreateDiv div;

    /**
     * コンストラクタです。
     *
     * @param div TakeOutPcDataCreateDiv
     */
    public TakeOutPcDataCreateValidationHandler(TakeOutPcDataCreateDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ生成
     *
     * @param div 持出端末用データ作成のDiv
     * @return 持出端末用データ作成のハンドラ
     */
    public static TakeOutPcDataCreateValidationHandler of(TakeOutPcDataCreateDiv div) {
        return new TakeOutPcDataCreateValidationHandler(div);
    }

    /**
     * validateチェックです
     *
     * @return チェック結果
     */
    public ValidationMessageControlPairs validateチェック() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new TakeOutPcDataCreateValidator(div).validate();
        validateResult.add(createErrorDictionary().check(messages));
        return validateResult;
    }

    private ValidationDictionary createErrorDictionary() {
        return new ValidationDictionaryBuilder()
                .add(TakeOutPcDataCreateValidationMessage.処理の続行確認,
                        div.getDdlTohyoYmd())
                .add(TakeOutPcDataCreateValidationMessage.投票日前日確認,
                        div.getDdlTohyoYmd())
                .build();
    }
}
