/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME5040;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5040.ZenjitsuSakuseiChohyoDairiShukeiDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5040.ZenjitsuSakuseiChohyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5040.ZenjitsuSakuseiChohyoJimuShoriboDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5040.ZenjitsuSakuseiDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.binding.ViewControl;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * 投票日前日関連帳票のValidationHandlerです。
 *
 * @reamsid_L AF-0280-010 lit
 */
public class ZenjitsuSakuseiValidationHandler {

    private final ZenjitsuSakuseiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ZenjitsuSakuseiDiv
     */
    public ZenjitsuSakuseiValidationHandler(ZenjitsuSakuseiDiv div) {
        this.div = div;
    }

    /**
     * 実行ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        IValidationMessages messages = new ZenjitsuSakuseiValidator(div).validate();
        validateResult.add(createDictionary().check(messages));

        ZenjitsuSakuseiChohyoDiv chohyoDiv = div.getZenjitsuSakuseiChohyo();
        if (chohyoDiv.getZenjitsuSakuseiChohyoTohyoShukei().isIsPublish()) {
            validateResult.add(chohyoDiv.getZenjitsuSakuseiChohyoTohyoShukei().getCcdTohyoShukeiTohyokuCode().関係チェック());
        }
        if (chohyoDiv.getZenjitsuSakuseiChohyoDairiShukei().isIsPublish()) {
            validateResult.add(chohyoDiv.getZenjitsuSakuseiChohyoDairiShukei().getCcdDairiShukeiTohyokuCode().関係チェック());
        }
        if (chohyoDiv.getZenjitsuSakuseiChohyoNendaibetsu().isIsPublish()) {
            validateResult.add(chohyoDiv.getZenjitsuSakuseiChohyoNendaibetsu().getCcdNendaibetsuTohyokuCode().関係チェック());
        }
        if (chohyoDiv.getZenjitsuSakuseiChohyoJikanbetsu().isIsPublish()) {
            validateResult.add(chohyoDiv.getZenjitsuSakuseiChohyoJikanbetsu().getCcdJikanbetsuTohyokuCode().関係チェック());
        }
        if (chohyoDiv.getZenjitsuSakuseiChohyoKofuIchiran().isIsPublish()) {
            validateResult.add(chohyoDiv.getZenjitsuSakuseiChohyoKofuIchiran().getCcdKofuIchiranShisetsuCode().関係チェック());
        }
        if (chohyoDiv.getZenjitsuSakuseiChohyoJimuShoribo().isIsPublish()) {
            validateResult.add(chohyoDiv.getZenjitsuSakuseiChohyoJimuShoribo().getCcdJimuShoriboTohyokuCode().関係チェック());
        }
        if (chohyoDiv.getZenjitsuSakuseiChohyoFuzaishaChosho().isIsPublish()) {
            validateResult.add(chohyoDiv.getZenjitsuSakuseiChohyoFuzaishaChosho().getCcdFuzaishaChoshoTohyokuCode().関係チェック());
        }
        if (chohyoDiv.getZenjitsuSakuseiChohyoKofuChosho().isIsPublish()) {
            validateResult.add(chohyoDiv.getZenjitsuSakuseiChohyoKofuChosho().getCcdKofuChoshoTohyokuCode().関係チェック());
        }
        if (chohyoDiv.getZenjitsuSakuseiChohyoKanrishaChosho().isIsPublish()) {
            validateResult.add(chohyoDiv.getZenjitsuSakuseiChohyoKanrishaChosho().getCcdKanrishaChoshoTohyokuCode().関係チェック());
        }
        if (chohyoDiv.getZenjitsuSakuseiChohyoTorokushaList().isIsPublish()) {
            validateResult.add(chohyoDiv.getZenjitsuSakuseiChohyoTorokushaList().getCcdTorokushaListTohyokuCode().関係チェック());
        }
        if (chohyoDiv.getZenjitsuSakuseiChohyoYukenshaList().isIsPublish()) {
            validateResult.add(chohyoDiv.getZenjitsuSakuseiChohyoYukenshaList().getCcdYukenshaListTohyokuCode().関係チェック());
        }
        if (chohyoDiv.getZenjitsuSakuseiChohyoShohon().isIsPublish()) {
            validateResult.add(chohyoDiv.getZenjitsuSakuseiChohyoShohon().getCcdShohonTohyokuCode().関係チェック());
        }
        if (chohyoDiv.getZenjitsuSakuseiChohyoSochisho().isIsPublish()) {
            validateResult.add(chohyoDiv.getZenjitsuSakuseiChohyoSochisho().getCcdSochishoTohyokuCode().関係チェック());
        }

        return validateResult;
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(ZenjitsuSakuseiValidationMessage.作成帳票必須, get作成帳票())
                .add(ZenjitsuSakuseiValidationMessage.代理投票集計表必須, get期日前投票())
                .add(ZenjitsuSakuseiValidationMessage.事務処理簿必須, get不在者投票())
                .build();
    }

    private List<ViewControl> get作成帳票() {
        List<ViewControl> viewControls = new ArrayList();
        viewControls.add(div);
        return viewControls;
    }

    private List<ViewControl> get期日前投票() {
        List<ViewControl> viewControls = new ArrayList();
        ZenjitsuSakuseiChohyoDairiShukeiDiv shukeiDiv = div.getZenjitsuSakuseiChohyo().getZenjitsuSakuseiChohyoDairiShukei();
        viewControls.add(shukeiDiv.getChkDairiTohyoTaisho());
        return viewControls;
    }

    private List<ViewControl> get不在者投票() {
        List<ViewControl> viewControls = new ArrayList();
        ZenjitsuSakuseiChohyoJimuShoriboDiv shoriboDiv = div.getZenjitsuSakuseiChohyo().getZenjitsuSakuseiChohyoJimuShoribo();
        viewControls.add(shoriboDiv.getChkJimuShoriboTaisho());
        return viewControls;
    }
}
