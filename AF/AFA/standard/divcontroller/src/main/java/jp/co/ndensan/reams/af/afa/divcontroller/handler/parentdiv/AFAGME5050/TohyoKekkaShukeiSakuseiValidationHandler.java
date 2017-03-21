/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME5050;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5050.TohyoKekkaSakuseiChohyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5050.TohyoKekkaShukeiSakuseiDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.binding.ViewControl;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 投票結果集計表のValidationHandlerです。
 *
 * @reamsid_L AF-0290-010 lit
 */
public class TohyoKekkaShukeiSakuseiValidationHandler {

    private final TohyoKekkaShukeiSakuseiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div TohyoKekkaShukeiSakuseiDiv
     */
    public TohyoKekkaShukeiSakuseiValidationHandler(TohyoKekkaShukeiSakuseiDiv div) {
        this.div = div;
    }

    /**
     * 実行ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new TohyoKekkaShukeiSakuseiValidator(div).validate();
        validateResult.add(createDictionary().check(messages));

        TohyoKekkaSakuseiChohyoDiv chohyoDiv = div.getTohyoKekkaSakuseiChohyo();
        if (chohyoDiv.getTohyoKekkaSakuseiChohyoNenreibetsu().isIsPublish()) {
            validateResult.add(chohyoDiv.getTohyoKekkaSakuseiChohyoNenreibetsu().getCcdNenreibetsuTohyokuCode().関係チェック());
        }
        if (chohyoDiv.getTohyoKekkaSakuseiChohyoNendaibetsu().isIsPublish()) {
            validateResult.add(chohyoDiv.getTohyoKekkaSakuseiChohyoNendaibetsu().getCcdNendaibetsuTohyokuCode().関係チェック());
        }
        return validateResult;
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(TohyoKekkaShukeiSakuseiValidationMessage.作成帳票必須, get作成帳票())
                .build();
    }

    private List<ViewControl> get作成帳票() {
        List<ViewControl> viewControls = new ArrayList();
        viewControls.add(div);
        return viewControls;
    }
}
