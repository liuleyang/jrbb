/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMG1060;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMG1060.RePrintKokuminDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 国民投票帳票再発行のクラス。
 *
 * @reamsid_L AF-0400-010 guancy
 */
public class RePrintKokuminValidationHandler {

    private final RePrintKokuminDiv div;

    /**
     * コンストラクタ生成。
     *
     * @param div RePrintKokuminDiv
     *
     */
    public RePrintKokuminValidationHandler(RePrintKokuminDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ生成。
     *
     * @param div RePrintKokuminDiv
     * @return RePrintKokuminValidationHandler
     */
    public static RePrintKokuminValidationHandler of(RePrintKokuminDiv div) {
        return new RePrintKokuminValidationHandler(div);
    }

    /**
     * 国民投票帳票再発行のバリデーション。
     *
     * @return validateResult
     */
    public ValidationMessageControlPairs validate() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new RePrintKokuminValidator(div).validate();
        validateResult.add(createDictionary().check(messages));

        return validateResult;
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(RePrintKokuminValidationMessage.抄本選択チェック, div.getRePrintKokuminShohonSelect())
                .add(RePrintKokuminValidationMessage.出力対象選択チェック)
                .add(RePrintKokuminValidationMessage.登録者の時点チェック,
                        div.getCcdRePrintKokuminSakuseiChohy().get投票人名簿登録者数リスト().getTxtTorokushasuListKijunYmd())
                .build();
    }
}
