/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM3010;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM3010.MasterCsvOutputDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 住民投票時登録
 *
 * @reamsid_L AF-0450-010 lis
 */
public class MasterCsvOutputValidator implements IValidatable {

    private final MasterCsvOutputDiv div;

    /**
     * コンストラクタ
     *
     * @param div 住民投票時登録のDiv
     */
    public MasterCsvOutputValidator(MasterCsvOutputDiv div) {
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
                ifNot(MasterCsvOutputSpec.出力対象マスタ未選択).
                thenAdd(MasterCsvOutputValidationMessage.出力対象マスタ未選択).
                ifNot(MasterCsvOutputSpec.投票区必須).
                thenAdd(MasterCsvOutputValidationMessage.投票区必須).
                messages()
        );
        return messages;
    }
}
