/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelectRange;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.binding.ViewControl;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * TohyokuCodeSelectRangeDivのValidationHandlerです。
 *
 * @reamsid_L AF-0270-013 xul
 */
public class TohyokuCodeSelectRangeValidationHandler {

    private final TohyokuCodeSelectRangeDiv div;

    /**
     * コンストラクタです。
     *
     * @param div TohyokuCodeSelectRangeDiv
     */
    public TohyokuCodeSelectRangeValidationHandler(TohyokuCodeSelectRangeDiv div) {
        this.div = div;
    }

    /**
     * 実行ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new TohyokuCodeSelectRangeValidator(div).validate();
        validateResult.add(createDictionary().check(messages));
        return validateResult;
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(TohyokuCodeSelectRangeValidationMessage.投票区コード範囲, get投票区コード())
                .add(TohyokuCodeSelectRangeValidationMessage.投票区コード開始入力, get投票区コード開始())
                .add(TohyokuCodeSelectRangeValidationMessage.投票区コード終了入力, get投票区コード終了())
                .build();
    }

    private List<ViewControl> get投票区コード() {
        List<ViewControl> viewControls = new ArrayList();
        viewControls.add(div.getCcdTohyokuCodeFrom().getTxtTohyokuCode());
        viewControls.add(div.getCcdTohyokuCodeTo().getTxtTohyokuCode());
        return viewControls;
    }

    private List<ViewControl> get投票区コード開始() {
        List<ViewControl> viewControls = new ArrayList();
        viewControls.add(div.getCcdTohyokuCodeFrom().getTxtTohyokuCode());
        return viewControls;
    }

    private List<ViewControl> get投票区コード終了() {
        List<ViewControl> viewControls = new ArrayList();
        viewControls.add(div.getCcdTohyokuCodeTo().getTxtTohyokuCode());
        return viewControls;
    }
}
