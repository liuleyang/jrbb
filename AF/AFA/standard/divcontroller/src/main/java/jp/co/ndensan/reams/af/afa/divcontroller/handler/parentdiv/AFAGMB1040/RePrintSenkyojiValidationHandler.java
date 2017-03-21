/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB1040;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB1040.RePrintSenkyojiDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.ui.binding.ViewControl;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 選挙時登録帳票再発行のバリデーションハンドラです。
 *
 * @reamsid_L AF-0060-010 liss
 */
public class RePrintSenkyojiValidationHandler {

    private final RePrintSenkyojiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div RePrintSenkyojiDiv
     */
    public RePrintSenkyojiValidationHandler(RePrintSenkyojiDiv div) {
        this.div = div;
    }

    /**
     * 必須項目です。
     *
     * @return バリデーションメッセージコントロールペア
     */
    public ValidationMessageControlPairs validate必須項目() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        RePrintSenkyojiValidator validator = new RePrintSenkyojiValidator(div);
        validateResult.add(createDictionary().check(validator.validate()));
        return validateResult;
    }

    private ValidationDictionary createDictionary() {
        List<ViewControl> list = new ArrayList<>();
        list.add(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoSenkyoninMeiboShohon());
        list.add(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoEikyuSenkyoninMeibo());
        list.add(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoSenkyoninMeiboSakuinbo());
        list.add(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoTorokushasuList());
        list.add(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoYukenshasuList());
        list.add(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoNijuTorokuTsuchi());
        list.add(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoNijuChosahyo());
        list.add(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoTorokushaMeibo());
        list.add(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoKikaMeibo());
        list.add(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoMasshoshaMeibo());
        list.add(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoGakuseiMasshoshaMeibo());
        list.add(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoMasshoYoteishaMeibo());
        list.add(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoHyojishaMeibo());
        list.add(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoHyojiShojoshaMeibo());
        list.add(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoHyojiShojoYoteishaMeibo());
        list.add(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoMiseinenshaMeibo());
        list.add(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoSaiTennyushaMeibo());
        list.add(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoTeiseishaMeibo());
        list.add(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoTenshutsushaMeibo());
        list.add(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoTeishishaMeibo());
        list.add(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoZaigai().getSakuseiChohyoZaigaiSenkyoninMeiboShohon());
        list.add(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoZaigai().getSakuseiChohyoZaigaiShikakushaMeibo());
        list.add(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoZaigai().getSakuseiChohyoZaigaiTohyoKanrihyo());
        list.add(div.getCcdRePrintSenkyojiSakuseiChohyo().getSakuseiChohyoIdoShikkenshaMeibo());
        return new ValidationDictionaryBuilder()
                .add(RePrintSenkyojiValidationMessage.転入期間必須, div.getCcdRePrintSenkyojiSakuseiChohyo()
                        .getSakuseiChohyoNijuTorokuTsuchi().getTxtTennyuKikan())
                .add(RePrintSenkyojiValidationMessage.帰化期間必須, div.getCcdRePrintSenkyojiSakuseiChohyo()
                        .getSakuseiChohyoIdoKikaMeibo().getTxtKikaKikan())
                .add(RePrintSenkyojiValidationMessage.転出期間必須, div.getCcdRePrintSenkyojiSakuseiChohyo()
                        .getSakuseiChohyoNijuChosahyo().getTxtTenshutsuKikan())
                .add(RePrintSenkyojiValidationMessage.必須項目を選択, div.getRePrintSenkyojiShohonSelect().getDgRePrintSenkyojiShohonSelect())
                .add(RePrintSenkyojiValidationMessage.作成帳票を選択, list)
                .build();
    }
}
