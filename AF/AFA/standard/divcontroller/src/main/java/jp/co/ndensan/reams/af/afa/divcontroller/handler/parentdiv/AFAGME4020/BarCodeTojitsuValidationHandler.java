/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME4020;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME4020.BarCodeTojitsuDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.binding.ViewControl;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 不在者投票のValidationHandlerです。
 *
 * @reamsid_L AF-0115-010 xul
 */
public class BarCodeTojitsuValidationHandler {

    private final BarCodeTojitsuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div BarCodeTojitsuDiv
     */
    public BarCodeTojitsuValidationHandler(BarCodeTojitsuDiv div) {
        this.div = div;
    }

    /**
     * ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate入場券() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages入場券確認 = new BarCodeTojitsuValidator(div).validate();
        validateResult.add(createDictionary().check(messages入場券確認));

        return validateResult;
    }

    /**
     * ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validateバーコード重複() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messagesバーコード重複 = new BarCodeTojitsuValidator(div).validateバーコード重複();
        validateResult.add(createDictionary().check(messagesバーコード重複));
        return validateResult;
    }

    /**
     * ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate投票資格() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages message投票資格 = new BarCodeTojitsuValidator(div).validate投票資格();
        validateResult.add(createDictionary().check(message投票資格));

        return validateResult;
    }

    /**
     * バリデーションの結果を返します。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate件数() {
        ValidationMessageControlPairs validResult = new ValidationMessageControlPairs();
        IValidationMessages message件数 = new BarCodeTojitsuValidator(div).validResult件数();
        validResult.add(createDictionary().check(message件数));
        return validResult;
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(BarCodeTojitsuValidationMessage.入場券確認, get入場券())
                .add(BarCodeTojitsuValidationMessage.投票資格チェック)
                .add(BarCodeTojitsuValidationMessage.読込済み確認)
                .add(BarCodeTojitsuValidationMessage.対象データなし_追加メッセージあり)
                .build();
    }

    private List<ViewControl> get入場券() {
        List<ViewControl> viewControls = new ArrayList();
        viewControls.add(div.getCcdNyujokenBarCode().getTxtBarCode());
        return viewControls;
    }

}
