/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMH1020;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMH1020.SeikyushaSelectDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 請求代表者選択のバリデーションハンドラクラスです。
 *
 * @reamsid_L AF-0140-020 wangh
 */
public final class SeikyushaSelectValidationHandler {

    private final SeikyushaSelectDiv div;

    /**
     * コンストラクタ生成
     *
     * @param div ZaigaiMeiboTorokuDiv
     */
    public SeikyushaSelectValidationHandler(SeikyushaSelectDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ生成
     *
     * @param div ZaigaiMeiboTorokuDiv
     * @return ZaigaiMeiboTorokuValidationHandler
     */
    public static SeikyushaSelectValidationHandler of(SeikyushaSelectDiv div) {
        return new SeikyushaSelectValidationHandler(div);
    }

    /**
     * 「署名簿を作成する」ボタンクリック時のチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new SeikyushaSelectValidator(div).validate();
        validateResult.add(createDictionary().check(messages));
        return validateResult;
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(SeikyushaSelectValidationMessage.提出期限日チェック)
                .build();
    }
}
