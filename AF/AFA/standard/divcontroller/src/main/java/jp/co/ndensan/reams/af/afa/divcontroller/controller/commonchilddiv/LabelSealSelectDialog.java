/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv;

import java.util.ArrayList;
import java.util.Arrays;
import jp.co.ndensan.reams.af.afa.business.labelsealselectdialog.LabelSealSelectDialogModel;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.KijitsumaeFuzaishaKubun;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.LabelSealPrintTaisho.LabelSealPrintTaishoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.LabelSealSelectDialog.LabelSealSelectDialogDiv;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * ラベルシール印刷確認ダイアログ用コントローラクラスです。
 *
 * @reamsid_L AF-0620-015 liuyj
 */
public class LabelSealSelectDialog {

    private static final RString 位置指定区分の表示有無 = new RString("FALSE");
    private static final RString 位置指定区分 = new RString("2");
    private static final RString 印字開始位置 = new RString("1");
    private static final RString ZERO = new RString("0");
    private static final RString SELECTED = new RString("1");

    /**
     * 初期表示のイベントです。
     *
     * @param div LabelSealSelectDialogDiv
     * @return ResponseData<LabelSealSelectDialogDiv>
     */
    public ResponseData<LabelSealSelectDialogDiv> onLoad(LabelSealSelectDialogDiv div) {

        LabelSealSelectDialogModel model = DataPassingConverter.deserialize(div.getLabelSealSelectDialogModel(), LabelSealSelectDialogModel.class);
        KijitsumaeFuzaishaKubun 期日前不在者区分 = model.getKijitsumaeFuzaishaKubun();
        ShohonNo 抄本番号 = model.getShohonNo();
        div.getCcdLabelSealPrintTaisho().initialize(期日前不在者区分, 抄本番号);

        LabelSealPrintTaishoDiv labelSealPrintTaishoDiv = (LabelSealPrintTaishoDiv) div.getCcdLabelSealPrintTaisho();
        if (model.isChkShomeishoHakko()) {
            labelSealPrintTaishoDiv.getChkFuzaishaTohyoShomeisho().setSelectedItemsByKey(Arrays.asList(SELECTED));
        }

        if (ZERO.equals(BusinessConfig.get(ConfigKeysAFA.ラベルシール_ラベルプリンタ使用有無, SubGyomuCode.AFA選挙本体))) {
            RString mensu = BusinessConfig.get(ConfigKeysAFA.宛名シール_面数, SubGyomuCode.AFA選挙本体);
            div.getCcdSealPosition().initialize();
            div.getCcdSealPosition().load(位置指定区分の表示有無, 位置指定区分, new ArrayList(), 印字開始位置, mensu);
        } else {
            div.getCcdSealPosition().setDisplayNone(Boolean.TRUE);
        }
        if (div.getCcdLabelSealPrintTaisho().is全てのチェックボックス非表示()) {
            return ResponseData.of(div).dialogOKClose();
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 「取り消す」ボタンのクリックイベントです。
     *
     * @param div LabelSealSelectDialogDiv
     * @return ResponseData<LabelSealSelectDialogDiv>
     */
    public ResponseData<LabelSealSelectDialogDiv> onClick_btnCancel(LabelSealSelectDialogDiv div) {
        return ResponseData.of(div).dialogOKClose();
    }

    /**
     * 「印刷する」ボタンのクリックイベントです。
     *
     * @param div LabelSealSelectDialogDiv
     * @return ResponseData
     */
    public ResponseData<LabelSealSelectDialogDiv> onClick_btnPrint(LabelSealSelectDialogDiv div) {
        ValidationMessageControlPairs validResult = div.getValidationHandler().validate();
        if (validResult.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(validResult).respond();
        }
        LabelSealSelectDialogModel model = DataPassingConverter.deserialize(div.getLabelSealSelectDialogModel(), LabelSealSelectDialogModel.class);

        return div.getHandler().print(model);
    }

}
