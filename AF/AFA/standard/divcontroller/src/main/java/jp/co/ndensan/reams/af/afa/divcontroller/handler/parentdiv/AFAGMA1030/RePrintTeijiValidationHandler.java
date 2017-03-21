/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMA1030;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMA1030.RePrintTeijiDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.ui.binding.ViewControl;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 定時登録帳票再発行のバリデーションハンドラです。
 *
 * @reamsid_L AF-0020-010 gaoya
 */
public class RePrintTeijiValidationHandler {

    private final RePrintTeijiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div RePrintTeijiDiv
     */
    public RePrintTeijiValidationHandler(RePrintTeijiDiv div) {
        this.div = div;
    }

    /**
     * 必須項目です。
     *
     * @return バリデーションメッセージコントロールペア
     */
    public ValidationMessageControlPairs validate必須項目() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        _RePrintTeijiValidator validator = new _RePrintTeijiValidator(div);
        validateResult.add(createDictionary().check(validator.validate()));
        return validateResult;
    }

    private ValidationDictionary createDictionary() {
        List<ViewControl> list = new ArrayList<>();
        list.add(div.getCcdRePrintTeijiSakuseiChohyo().getSakuseiChohyoSenkyoninMeiboShohon());
        list.add(div.getCcdRePrintTeijiSakuseiChohyo().getSakuseiChohyoEikyuSenkyoninMeibo());
        list.add(div.getCcdRePrintTeijiSakuseiChohyo().getSakuseiChohyoSenkyoninMeiboSakuinbo());
        list.add(div.getCcdRePrintTeijiSakuseiChohyo().getSakuseiChohyoTorokushasuList());
        list.add(div.getCcdRePrintTeijiSakuseiChohyo().getSakuseiChohyoYukenshasuList());
        list.add(div.getCcdRePrintTeijiSakuseiChohyo().getSakuseiChohyoNijuTorokuTsuchi());
        list.add(div.getCcdRePrintTeijiSakuseiChohyo().getSakuseiChohyoIdoTorokushaMeibo());
        list.add(div.getCcdRePrintTeijiSakuseiChohyo().getSakuseiChohyoIdoKikaMeibo());
        list.add(div.getCcdRePrintTeijiSakuseiChohyo().getSakuseiChohyoIdoMasshoshaMeibo());
        list.add(div.getCcdRePrintTeijiSakuseiChohyo().getSakuseiChohyoIdoGakuseiMasshoshaMeibo());
        list.add(div.getCcdRePrintTeijiSakuseiChohyo().getSakuseiChohyoIdoHyojishaMeibo());
        list.add(div.getCcdRePrintTeijiSakuseiChohyo().getSakuseiChohyoIdoHyojiShojoshaMeibo());
        list.add(div.getCcdRePrintTeijiSakuseiChohyo().getSakuseiChohyoIdo19saishaMeibo());
        list.add(div.getCcdRePrintTeijiSakuseiChohyo().getSakuseiChohyoIdoMiseinenshaMeibo());
        list.add(div.getCcdRePrintTeijiSakuseiChohyo().getSakuseiChohyoIdoSaiTennyushaMeibo());
        list.add(div.getCcdRePrintTeijiSakuseiChohyo().getSakuseiChohyoIdoTeiseishaMeibo());
        list.add(div.getCcdRePrintTeijiSakuseiChohyo().getSakuseiChohyoIdoTenshutsushaMeibo());
        list.add(div.getCcdRePrintTeijiSakuseiChohyo().getSakuseiChohyoIdoTeishishaMeibo());
        list.add(div.getCcdRePrintTeijiSakuseiChohyo().getSakuseiChohyoZaigai().getSakuseiChohyoZaigaiSenkyoninMeiboShohon());
        list.add(div.getCcdRePrintTeijiSakuseiChohyo().getSakuseiChohyoZaigai().getSakuseiChohyoZaigaiShikakushaMeibo());
        return new ValidationDictionaryBuilder().
                add(RePrintTeijiValidationMessage.必須項目を選択, div.getRePrintTeijiShohonSelect()).
                add(RePrintTeijiValidationMessage.作成帳票を選択, list).
                build();
    }
}
