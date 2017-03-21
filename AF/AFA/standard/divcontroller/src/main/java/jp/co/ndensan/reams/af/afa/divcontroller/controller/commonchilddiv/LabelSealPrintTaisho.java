/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.KijitsumaeFuzaishaKubun;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ViewStateKeys;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.LabelSealPrintTaisho.LabelSealPrintTaishoDiv;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * ラベルシール作成対象共有子divのコントローラクラスです。
 *
 * @reamsid_L AF-0620-016 zhangl
 */
public class LabelSealPrintTaisho {

    /**
     * チェックボックス「宣誓書貼付用を印刷する」のonChangeイベントです。
     *
     * @param div LabelSealPrintTaishoDiv
     * @return ResponseData<LabelSealPrintTaishoDiv>
     */
    public ResponseData<LabelSealPrintTaishoDiv> onChange_chkLabelSenseisho(LabelSealPrintTaishoDiv div) {
        if (KijitsumaeFuzaishaKubun.期日前投票.equals(ViewStateHolder.get(ViewStateKeys.期日前不在者区分, KijitsumaeFuzaishaKubun.class))) {
            div.getHandler().onChangeCheckBox(div.getChkLabelSenseisho(), div.getTxtMaisuSenseisho(),
                    BusinessConfig.get(ConfigKeysAFA.ラベルシール_宣誓書用_期日前_印刷枚数初期値, SubGyomuCode.AFA選挙本体));
        }
        if (KijitsumaeFuzaishaKubun.不在者投票.equals(ViewStateHolder.get(ViewStateKeys.期日前不在者区分, KijitsumaeFuzaishaKubun.class))) {
            div.getHandler().onChangeCheckBox(div.getChkLabelSenseisho(), div.getTxtMaisuSenseisho(),
                    BusinessConfig.get(ConfigKeysAFA.ラベルシール_宣誓書用_不在_印刷枚数初期値, SubGyomuCode.AFA選挙本体));
        }
        return ResponseData.of(div).respond();
    }

    /**
     * チェックボックス「封筒貼付用を印刷する」のonChangeイベントです。
     *
     * @param div LabelSealPrintTaishoDiv
     * @return ResponseData<LabelSealPrintTaishoDiv>
     */
    public ResponseData<LabelSealPrintTaishoDiv> onChange_chkLabelFuto(LabelSealPrintTaishoDiv div) {
        if (div.getChkLabelFuto().getSelectedKeys().isEmpty()) {
            div.getChkSenkyo().getSelectedItems().clear();
        } else {

            List<RString> selectedKeys = ViewStateHolder.get(ViewStateKeys.選択した選挙キー, ArrayList.class);
            div.getChkSenkyo().setSelectedItemsByKey(selectedKeys);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * チェックボックス「抄本貼付用を印刷する」のonChangeイベントです。
     *
     * @param div LabelSealPrintTaishoDiv
     * @return ResponseData<LabelSealPrintTaishoDiv>
     */
    public ResponseData<LabelSealPrintTaishoDiv> onChange_chkLabelShohon(LabelSealPrintTaishoDiv div) {
        if (KijitsumaeFuzaishaKubun.期日前投票.equals(ViewStateHolder.get(ViewStateKeys.期日前不在者区分, KijitsumaeFuzaishaKubun.class))) {
            div.getHandler().onChangeCheckBox(div.getChkLabelShohon(), div.getTxtMaisuShohon(),
                    BusinessConfig.get(ConfigKeysAFA.ラベルシール_抄本用_期日前_印刷枚数初期値, SubGyomuCode.AFA選挙本体));
        }
        if (KijitsumaeFuzaishaKubun.不在者投票.equals(ViewStateHolder.get(ViewStateKeys.期日前不在者区分, KijitsumaeFuzaishaKubun.class))) {
            div.getHandler().onChangeCheckBox(div.getChkLabelShohon(), div.getTxtMaisuShohon(),
                    BusinessConfig.get(ConfigKeysAFA.ラベルシール_抄本用_不在_印刷枚数初期値, SubGyomuCode.AFA選挙本体));
        }
        return ResponseData.of(div).respond();
    }

    /**
     * チェックボックス「入場券貼付用を印刷する」のonChangeイベントです。
     *
     * @param div LabelSealPrintTaishoDiv
     * @return ResponseData<LabelSealPrintTaishoDiv>
     */
    public ResponseData<LabelSealPrintTaishoDiv> onChange_chkLabelNyujoken(LabelSealPrintTaishoDiv div) {
        if (KijitsumaeFuzaishaKubun.期日前投票.equals(ViewStateHolder.get(ViewStateKeys.期日前不在者区分, KijitsumaeFuzaishaKubun.class))) {
            div.getHandler().onChangeCheckBox(div.getChkLabelNyujoken(), div.getTxtMaisuNyujoken(),
                    BusinessConfig.get(ConfigKeysAFA.ラベルシール_入場券用_期日前_印刷枚数初期値, SubGyomuCode.AFA選挙本体));
        }
        if (KijitsumaeFuzaishaKubun.不在者投票.equals(ViewStateHolder.get(ViewStateKeys.期日前不在者区分, KijitsumaeFuzaishaKubun.class))) {
            div.getHandler().onChangeCheckBox(div.getChkLabelNyujoken(), div.getTxtMaisuNyujoken(),
                    BusinessConfig.get(ConfigKeysAFA.ラベルシール_入場券用_不在_印刷枚数初期値, SubGyomuCode.AFA選挙本体));
        }
        return ResponseData.of(div).respond();
    }

}
