/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB3050;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB3050.ZaigaiShuseiDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 在外選挙人名簿修正のValidator
 *
 * @reamsid_L AF-0325-034 guancy
 */
public class _ZaigaiShuseiValidator implements IValidatable {

    private final ZaigaiShuseiDiv div;

    _ZaigaiShuseiValidator(ZaigaiShuseiDiv div) {
        this.div = div;
    }

    /**
     * バリデーション検証処理
     *
     * @return チェック結果
     */
    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(ZaigaiShuseiSpec.在外選挙人名簿情報の表示日_表示事由のチェック_表示日未入力).
                thenAdd(ZaigaiShuseiWarningValidationMessage.在外選挙人名簿情報の表示日_表示事由のチェック_表示日未入力).
                ifNot(ZaigaiShuseiSpec.在外選挙人名簿情報の表示日_表示事由のチェック_表示事由未入力).
                thenAdd(ZaigaiShuseiWarningValidationMessage.在外選挙人名簿情報の表示日_表示事由のチェック_表示事由未入力).
                ifNot(ZaigaiShuseiSpec.在外選挙人名簿情報の表示日関連のチェック_未来日).
                thenAdd(ZaigaiShuseiWarningValidationMessage.在外選挙人名簿情報の表示日関連のチェック_未来日).
                ifNot(ZaigaiShuseiSpec.在外選挙人名簿情報の表示日関連のチェック_登録日以降).
                thenAdd(ZaigaiShuseiWarningValidationMessage.在外選挙人名簿情報の表示日関連のチェック_登録日以降).
                ifNot(ZaigaiShuseiSpec.在外選挙人名簿情報の国内転入日関連のチェック_表示事由).
                thenAdd(ZaigaiShuseiWarningValidationMessage.在外選挙人名簿情報の国内転入日関連のチェック_表示事由).
                messages());
        return messages;
    }

}
