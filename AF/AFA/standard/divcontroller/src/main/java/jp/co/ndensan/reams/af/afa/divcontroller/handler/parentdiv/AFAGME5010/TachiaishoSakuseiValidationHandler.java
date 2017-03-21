/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME5010;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5010.TachiaishoSakuseiDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * AFAGME5010 立会人引継書のValidationHandlerです。
 *
 * @reamsid_L AF-0120-010 xul
 */
public final class TachiaishoSakuseiValidationHandler {

    private final TachiaishoSakuseiDiv div;

    private TachiaishoSakuseiValidationHandler(TachiaishoSakuseiDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ生成
     *
     * @param div 立会人引継書
     * @return 立会人引継書のバリデーションハンドラ
     */
    public static TachiaishoSakuseiValidationHandler of(TachiaishoSakuseiDiv div) {
        return new TachiaishoSakuseiValidationHandler(div);
    }

    /**
     * ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new TachiaishoSakuseiValidator(div).validate();
        validateResult.add(createDictionary().check(messages));

        return validateResult;
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(TachiaishoSakuseiValidationMessage.抄本データドロップダウン未入力,
                        div.getCcdShohonNameList().getDdlShohonItem())
                .add(TachiaishoSakuseiValidationMessage.期日前投票日未入力,
                        div.getTxtTohyoYMDJoken())
                .add(TachiaishoSakuseiValidationMessage.選挙名未入力,
                        div.getDdlSenkyoName())
                .add(TachiaishoSakuseiValidationMessage.期日前投票所未入力,
                        div.getDdlShisetsu())
                .build();
    }

    /**
     * ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate_引継内容詳細() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new TachiaishoSakuseiValidator(div).validate_引継内容詳細();
        validateResult.add(createDictionary_引継内容詳細().check(messages));

        return validateResult;
    }

    private ValidationDictionary createDictionary_引継内容詳細() {
        return new ValidationDictionaryBuilder()
                .add(TachiaishoSakuseiValidationMessage.立会人氏名,
                        div.getTxtTachiaininShimei())
                .add(TachiaishoSakuseiValidationMessage.立会時間,
                        div.getTxtTachiaiTimeRange())
                .build();
    }

}
