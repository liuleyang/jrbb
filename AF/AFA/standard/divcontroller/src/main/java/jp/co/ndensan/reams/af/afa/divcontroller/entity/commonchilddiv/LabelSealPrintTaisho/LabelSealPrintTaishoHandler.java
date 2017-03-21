/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.LabelSealPrintTaisho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.shohon.senkyo.Senkyo;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.KijitsumaeFuzaishaKubun;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoLevel;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ViewStateKeys;
import jp.co.ndensan.reams.af.afa.service.core.shohon.senkyo.SenkyoManager;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * ラベルシール作成対象共有子divのHandlerクラスです。
 *
 * @reamsid_L AF-0620-016 zhangl
 */
public class LabelSealPrintTaishoHandler {

    private final LabelSealPrintTaishoDiv div;
    private static final RString ZERO = new RString("0");
    private static final RString ONE = new RString("1");

    /**
     * コンストラクタです。
     *
     * @param div LabelSealPrintTaishoDiv
     */
    public LabelSealPrintTaishoHandler(LabelSealPrintTaishoDiv div) {
        this.div = div;
    }

    /**
     * 初期化イベントです。
     *
     * @param 期日前不在者区分 KijitsumaeFuzaishaKubun
     * @param 抄本番号 ShohonNo
     */
    public void initialize(KijitsumaeFuzaishaKubun 期日前不在者区分, ShohonNo 抄本番号) {
        ViewStateHolder.put(ViewStateKeys.期日前不在者区分, 期日前不在者区分);
        if (期日前不在者区分.equals(KijitsumaeFuzaishaKubun.期日前投票)) {
            setInit期日前();
        }
        if (期日前不在者区分.equals(KijitsumaeFuzaishaKubun.不在者投票)) {
            setInit不在者(抄本番号);
        }
        setLblLabelSeal();
    }

    private void setLblLabelSeal() {
        div.getLblLabelSeal().setDisplayNone(div.getChkLabelSenseisho().isDisplayNone()
                && div.getChkLabelFuto().isDisplayNone()
                && div.getChkLabelShohon().isDisplayNone()
                && div.getChkLabelNyujoken().isDisplayNone());
    }

    private void setInit期日前() {

        div.getChkFuzaishaTohyoShomeisho().setDisplayNone(Boolean.TRUE);
        RString 宣誓書_期日前_使用有無 = BusinessConfig.get(ConfigKeysAFA.宣誓書_期日前_使用有無, SubGyomuCode.AFA選挙本体);
        div.getChkSenseisho().setDisplayNone(ZERO.equals(宣誓書_期日前_使用有無));

        set初期状態Withパラメータ(
                div.getChkLabelSenseisho(),
                div.getTxtMaisuSenseisho(),
                BusinessConfig.get(ConfigKeysAFA.ラベルシール_宣誓書用_期日前_使用有無, SubGyomuCode.AFA選挙本体),
                BusinessConfig.get(ConfigKeysAFA.ラベルシール_宣誓書用_期日前_印刷初期値, SubGyomuCode.AFA選挙本体),
                BusinessConfig.get(ConfigKeysAFA.ラベルシール_宣誓書用_期日前_印刷枚数初期値, SubGyomuCode.AFA選挙本体));

        div.getChkLabelFuto().setDisplayNone(Boolean.TRUE);
        div.getChkSenkyo().setDisplayNone(Boolean.TRUE);

        set初期状態Withパラメータ(
                div.getChkLabelShohon(),
                div.getTxtMaisuShohon(),
                BusinessConfig.get(ConfigKeysAFA.ラベルシール_抄本用_期日前_使用有無, SubGyomuCode.AFA選挙本体),
                BusinessConfig.get(ConfigKeysAFA.ラベルシール_抄本用_期日前_印刷初期値, SubGyomuCode.AFA選挙本体),
                BusinessConfig.get(ConfigKeysAFA.ラベルシール_抄本用_期日前_印刷枚数初期値, SubGyomuCode.AFA選挙本体));

        set初期状態Withパラメータ(
                div.getChkLabelNyujoken(),
                div.getTxtMaisuNyujoken(),
                BusinessConfig.get(ConfigKeysAFA.ラベルシール_入場券用_期日前_使用有無, SubGyomuCode.AFA選挙本体),
                BusinessConfig.get(ConfigKeysAFA.ラベルシール_入場券用_期日前_印刷初期値, SubGyomuCode.AFA選挙本体),
                BusinessConfig.get(ConfigKeysAFA.ラベルシール_入場券用_期日前_印刷枚数初期値, SubGyomuCode.AFA選挙本体));

    }

    private void setInit不在者(ShohonNo 抄本番号) {

        div.getChkFuzaishaTohyoShomeisho().setDisplayNone(Boolean.FALSE);
        RString 宣誓書_不在_使用有無 = BusinessConfig.get(ConfigKeysAFA.宣誓書_不在_使用有無, SubGyomuCode.AFA選挙本体);
        div.getChkSenseisho().setDisplayNone(ZERO.equals(宣誓書_不在_使用有無));

        set初期状態Withパラメータ(
                div.getChkLabelSenseisho(),
                div.getTxtMaisuSenseisho(),
                BusinessConfig.get(ConfigKeysAFA.ラベルシール_宣誓書用_不在_使用有無, SubGyomuCode.AFA選挙本体),
                BusinessConfig.get(ConfigKeysAFA.ラベルシール_宣誓書用_不在_印刷初期値, SubGyomuCode.AFA選挙本体),
                BusinessConfig.get(ConfigKeysAFA.ラベルシール_宣誓書用_不在_印刷枚数初期値, SubGyomuCode.AFA選挙本体));

        set封筒_不在者(抄本番号);

        set初期状態Withパラメータ(
                div.getChkLabelShohon(),
                div.getTxtMaisuShohon(),
                BusinessConfig.get(ConfigKeysAFA.ラベルシール_抄本用_不在_使用有無, SubGyomuCode.AFA選挙本体),
                BusinessConfig.get(ConfigKeysAFA.ラベルシール_抄本用_不在_印刷初期値, SubGyomuCode.AFA選挙本体),
                BusinessConfig.get(ConfigKeysAFA.ラベルシール_抄本用_不在_印刷枚数初期値, SubGyomuCode.AFA選挙本体));

        set初期状態Withパラメータ(
                div.getChkLabelNyujoken(),
                div.getTxtMaisuNyujoken(),
                BusinessConfig.get(ConfigKeysAFA.ラベルシール_入場券用_不在_使用有無, SubGyomuCode.AFA選挙本体),
                BusinessConfig.get(ConfigKeysAFA.ラベルシール_入場券用_不在_印刷初期値, SubGyomuCode.AFA選挙本体),
                BusinessConfig.get(ConfigKeysAFA.ラベルシール_入場券用_不在_印刷枚数初期値, SubGyomuCode.AFA選挙本体));

    }

    private void set初期状態Withパラメータ(
            CheckBoxList チェックボックス,
            TextBoxNum テキストボックス,
            RString 使用有無,
            RString 印刷初期値,
            RString 印刷枚数初期値) {
        if (ZERO.equals(使用有無)) {
            チェックボックス.setDisplayNone(Boolean.TRUE);
            テキストボックス.setDisplayNone(Boolean.TRUE);
        } else {
            チェックボックス.setDisplayNone(Boolean.FALSE);
            チェックボックス.setDisabled(Boolean.FALSE);
            テキストボックス.setDisplayNone(Boolean.FALSE);
            テキストボックス.setDisabled(Boolean.FALSE);
            if (ZERO.equals(印刷初期値)) {
                チェックボックス.getSelectedItems().clear();
                テキストボックス.setValue(Decimal.ZERO);
                テキストボックス.setDisabled(Boolean.TRUE);
            } else {
                チェックボックス.setSelectedItemsByKey(Arrays.asList(ONE));
                テキストボックス.setValue(new Decimal(印刷枚数初期値.toString()));
                テキストボックス.setDisabled(Boolean.FALSE);
            }
        }
    }

    private void set封筒_不在者(ShohonNo 抄本番号) {
        if (ZERO.equals(BusinessConfig.get(ConfigKeysAFA.ラベルシール_封筒用_不在_使用有無, SubGyomuCode.AFA選挙本体))) {
            div.getChkLabelFuto().setDisplayNone(Boolean.TRUE);
            div.getChkSenkyo().setDisplayNone(Boolean.TRUE);
        } else {
            div.getChkLabelFuto().setDisplayNone(Boolean.FALSE);
            div.getChkSenkyo().setDisplayNone(Boolean.FALSE);
            SenkyoManager manager = new SenkyoManager();
            List<Senkyo> 選挙s = manager.get選挙By抄本番号(抄本番号);
            List<KeyValueDataSource> kvds = new ArrayList<>();
            List<RString> selectedKeys = new ArrayList<>();
            if (null != 選挙s && !選挙s.isEmpty()) {
                for (int i = 0; i < 選挙s.size(); i++) {
                    kvds.add(new KeyValueDataSource(new RString(選挙s.get(i).get選挙番号().getColumnValue()), 選挙s.get(i).get選挙略称()));

                    if (!SennkyoLevel.市区町村.value().equals(選挙s.get(i).get選挙レベル().value())) {
                        selectedKeys.add(new RString(選挙s.get(i).get選挙番号().toString()));
                    }
                }
            }
            div.getChkSenkyo().setDataSource(kvds);
            div.getChkSenkyo().setDisplayNone(Boolean.FALSE);
            if (ZERO.equals(BusinessConfig.get(ConfigKeysAFA.ラベルシール_封筒用_不在_印刷初期値, SubGyomuCode.AFA選挙本体))) {
                div.getChkLabelFuto().getSelectedItems().clear();
                div.getChkSenkyo().getSelectedItems().clear();
            } else {
                div.getChkLabelFuto().setSelectedItemsByKey(Arrays.asList(ONE));
                div.getChkSenkyo().setSelectedItemsByKey(selectedKeys);
            }

            ViewStateHolder.put(ViewStateKeys.選択した選挙キー, (ArrayList) selectedKeys);
        }
    }

    /**
     * 印刷するチェックボックスのonChangeメソッドです。
     *
     * @param チェックボックス CheckBoxList
     * @param テキストボックス TextBoxNum
     * @param 印刷枚数初期値 RString
     */
    public void onChangeCheckBox(CheckBoxList チェックボックス, TextBoxNum テキストボックス, RString 印刷枚数初期値) {
        if (チェックボックス.getSelectedKeys().isEmpty()) {
            テキストボックス.setValue(Decimal.ZERO);
            テキストボックス.setDisabled(Boolean.TRUE);
        } else {
            テキストボックス.setDisabled(Boolean.FALSE);
            テキストボックス.setValue(new Decimal(印刷枚数初期値.toString()));
        }
    }
}
