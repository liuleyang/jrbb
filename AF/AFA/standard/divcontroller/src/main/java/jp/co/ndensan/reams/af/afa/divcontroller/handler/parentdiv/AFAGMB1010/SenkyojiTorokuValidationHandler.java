/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB1010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB1010.SenkyojiTorokuDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.binding.ViewControl;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 選挙時登録画面のValidationHandlerです。
 *
 * @reamsid_L AF-0030-010 liss
 */
public class SenkyojiTorokuValidationHandler {

    private final SenkyojiTorokuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div SenkyojiTorokuDiv
     */
    public SenkyojiTorokuValidationHandler(SenkyojiTorokuDiv div) {
        this.div = div;
    }

    /**
     * 実行ボタンクリック時のバリデーションチェックです。
     *
     * @param パタン RString
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate(RString パタン) {
        IValidationMessages messages = new SenkyojiTorokuValidator(div, パタン).validate();
        return createDictionary(パタン).check(messages);
    }

    private ValidationDictionary createDictionary(RString パタン) {
        if (パタン.equals(new RString("帳票の条件を設定する"))) {
            return new ValidationDictionaryBuilder()
                    .add(SenkyojiTorokuValidationMessage.レベル必須, get選挙時登録())
                    .add(SenkyojiTorokuValidationMessage.選挙名必須, get選挙時登録())
                    .add(SenkyojiTorokuValidationMessage.略名必須, get選挙時登録())
                    .add(SenkyojiTorokuValidationMessage.マーク必須, get選挙時登録())
                    .add(SenkyojiTorokuValidationMessage.受付開始日必須, get受付開始日())
                    .build();
        } else if (パタン.equals(new RString("実行"))) {
            return new ValidationDictionaryBuilder()
                    .add(SenkyojiTorokuValidationMessage.抄本名必須, div.getCcdSenkyojiMeiboSakuseiKijun().getTxtShohonName())
                    .add(SenkyojiTorokuValidationMessage.投票日必須, div.getCcdSenkyojiMeiboSakuseiKijun().getTxtTohyoYMD())
                    .add(SenkyojiTorokuValidationMessage.転入期間必須,
                            div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoNijuTorokuTsuchi().getTxtTennyuKikan())
                    .add(SenkyojiTorokuValidationMessage.帰化期間必須,
                            div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoIdoKikaMeibo().getTxtKikaKikan())
                    .add(SenkyojiTorokuValidationMessage.転出期間必須,
                            div.getCcdSenkyojiSakuseiChohyo().getSakuseiChohyoNijuChosahyo().getTxtTenshutsuKikan())
                    .add(SenkyojiTorokuValidationMessage.年齢期限必須,
                            div.getCcdSenkyojiMeiboSakuseiKijun().getTxtNenreiTotatsuYMD())
                    .add(SenkyojiTorokuValidationMessage.レベル必須, get選挙時登録())
                    .add(SenkyojiTorokuValidationMessage.選挙名必須, get選挙時登録())
                    .add(SenkyojiTorokuValidationMessage.略名必須, get選挙時登録())
                    .add(SenkyojiTorokuValidationMessage.マーク必須, get選挙時登録())
                    .add(SenkyojiTorokuValidationMessage.受付開始日必須, get受付開始日())
                    .add(SenkyojiTorokuValidationMessage.基準日確認1, get投票日())
                    .add(SenkyojiTorokuValidationMessage.基準日確認2, get選挙時登録())
                    .add(SenkyojiTorokuValidationMessage.交付日確認, get選挙時登録())
                    .add(SenkyojiTorokuValidationMessage.再作成処理不可, get選挙時登録())
                    .build();
        } else {
            return new ValidationDictionaryBuilder()
                    .add(SenkyojiTorokuValidationMessage.基準日必須, get選挙時登録())
                    .build();
        }

    }

    private List<ViewControl> get選挙時登録() {
        List<ViewControl> viewControls = new ArrayList();
        viewControls.add(div);
        return viewControls;
    }

    private List<ViewControl> get受付開始日() {
        List<ViewControl> viewControls = new ArrayList();
        viewControls.add(div.getCcdSenkyojiMeiboSakuseiKijun().getSenkyoNyuryoku().getDgSenkyojiSenkyoNyuryoku());
        return viewControls;
    }

    private List<ViewControl> get投票日() {
        List<ViewControl> viewControls = new ArrayList();
        viewControls.add(div.getCcdSenkyojiMeiboSakuseiKijun().getTxtTohyoYMD());
        return viewControls;
    }

}
