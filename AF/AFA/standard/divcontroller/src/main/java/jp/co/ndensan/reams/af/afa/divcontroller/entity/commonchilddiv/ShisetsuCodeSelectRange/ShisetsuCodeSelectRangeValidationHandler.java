/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShisetsuCodeSelectRange;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.binding.ViewControl;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * ShisetsuCodeSelectRangeDivのValidationHandlerです。
 *
 * @reamsid_L AF-0270-012 xul
 */
public class ShisetsuCodeSelectRangeValidationHandler {

    private final ShisetsuCodeSelectRangeDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ShisetsuCodeSelectRangeDiv
     */
    public ShisetsuCodeSelectRangeValidationHandler(ShisetsuCodeSelectRangeDiv div) {
        this.div = div;
    }

    /**
     * 実行ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new ShisetsuCodeSelectRangeValidator(div).validate();
        validateResult.add(createDictionary().check(messages));
        return validateResult;
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(ShisetsuCodeSelectRangeValidationMessage.施設コード範囲, get施設コード())
                .add(ShisetsuCodeSelectRangeValidationMessage.施設コード開始入力, get施設コード開始())
                .add(ShisetsuCodeSelectRangeValidationMessage.施設コード終了入力, get施設コード終了())
                .build();
    }

    private List<ViewControl> get施設コード() {
        List<ViewControl> viewControls = new ArrayList();
        viewControls.add(div.getCcdShisetsuCodeFrom().getTxtShisetsuCode());
        viewControls.add(div.getCcdShisetsuCodeTo().getTxtShisetsuCode());
        return viewControls;
    }

    private List<ViewControl> get施設コード開始() {
        List<ViewControl> viewControls = new ArrayList();
        viewControls.add(div.getCcdShisetsuCodeFrom().getTxtShisetsuCode());
        return viewControls;
    }

    private List<ViewControl> get施設コード終了() {
        List<ViewControl> viewControls = new ArrayList();
        viewControls.add(div.getCcdShisetsuCodeTo().getTxtShisetsuCode());
        return viewControls;
    }
}
