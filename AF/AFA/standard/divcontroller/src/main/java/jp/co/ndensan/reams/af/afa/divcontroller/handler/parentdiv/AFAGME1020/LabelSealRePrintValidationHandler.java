/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME1020;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME1020.LabelSealRePrintDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaSealPositionGuide.AtenaSealPositionGuideDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * ラベルシール再印刷のバリデーションハンドラクラスです。
 *
 * @reamsid_L AF-0620-014 jihb
 */
public final class LabelSealRePrintValidationHandler {

    private final LabelSealRePrintDiv div;

    /**
     * コンストラクタ生成
     *
     * @param div ZaigaiMeiboTorokuDiv
     */
    public LabelSealRePrintValidationHandler(LabelSealRePrintDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ生成
     *
     * @param div ZaigaiMeiboTorokuDiv
     * @return ZaigaiMeiboTorokuValidationHandler
     */
    public static LabelSealRePrintValidationHandler of(LabelSealRePrintDiv div) {
        return new LabelSealRePrintValidationHandler(div);
    }

    /**
     * 一括交付者を検索するボタンクリック時のチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new LabelSealRePrintValidator(div).validate();
        validateResult.add(createDictionary().check(messages));
        return validateResult;
    }

    /**
     * 実行するボタンクリック時のチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate2() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new LabelSealRePrintValidator(div).validate2();
        validateResult.add(createDictionary().check(messages));
        return validateResult;
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(LabelSealRePrintValidationMessage.施設コードの入力チェック_未入力,
                        div.getLabelSealSakuseiTaisho().getCcdShisetsuCode().getTxtShisetsuCode())
                .add(LabelSealRePrintValidationMessage.選挙人一覧データチェック_データなし)
                .add(LabelSealRePrintValidationMessage.選挙人一覧選択チェック_選択しなし)
                .add(LabelSealRePrintValidationMessage.開始印字位置選択チェック_選択しなし,
                        ((AtenaSealPositionGuideDiv) div.getLabelSealSakuseiTaisho().getCcdSealPosition()).getTxtPosition())
                .build();
    }
}
