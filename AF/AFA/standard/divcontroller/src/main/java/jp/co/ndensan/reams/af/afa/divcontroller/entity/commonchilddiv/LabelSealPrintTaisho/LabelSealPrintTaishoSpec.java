/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.LabelSealPrintTaisho;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * ラベルシール作成対象共有子divのSpecクラスです。
 *
 * @reamsid_L AF-0620-016 zhangl
 */
public enum LabelSealPrintTaishoSpec implements IPredicate<LabelSealPrintTaishoDiv> {

    /**
     * 画面項目選択チェック。
     */
    画面項目選択チェック {
                @Override
                public boolean apply(LabelSealPrintTaishoDiv div) {
                    return !div.getChkFuzaishaTohyoShomeisho().getSelectedKeys().isEmpty()
                    || !div.getChkSenseisho().getSelectedKeys().isEmpty()
                    || !div.getChkLabelSenseisho().getSelectedKeys().isEmpty()
                    || !div.getChkLabelFuto().getSelectedKeys().isEmpty()
                    || !div.getChkLabelShohon().getSelectedKeys().isEmpty()
                    || !div.getChkLabelNyujoken().getSelectedKeys().isEmpty();
                }
            },
    /**
     * 封筒貼付用関連チェック。
     */
    封筒貼付用関連チェック {
                @Override
                public boolean apply(LabelSealPrintTaishoDiv div) {
                    return div.getChkLabelFuto().isDisplayNone()
                    || div.getChkSenkyo().isDisplayNone()
                    || div.getChkLabelFuto().getSelectedKeys().isEmpty()
                    || !div.getChkSenkyo().getSelectedKeys().isEmpty();
                }
            },
    /**
     * 宣誓書貼付用枚数が0枚のチェック。
     */
    宣誓書貼付用枚数が0枚のチェック {
                @Override
                public boolean apply(LabelSealPrintTaishoDiv div) {
                    return SpecHelper.枚数が0枚のチェック(div.getChkLabelSenseisho(), div.getTxtMaisuSenseisho());
                }
            },
    /**
     * 封筒貼付用枚数が0枚のチェック。
     */
    封筒貼付用枚数が0枚のチェック {
                @Override
                public boolean apply(LabelSealPrintTaishoDiv div) {
                    return SpecHelper.枚数が0枚のチェック(div.getChkLabelFuto(), div.getTxtMaisuFuto());
                }
            },
    /**
     * 抄本貼付用枚数が0枚のチェック。
     */
    抄本貼付用枚数が0枚のチェック {
                @Override
                public boolean apply(LabelSealPrintTaishoDiv div) {
                    return SpecHelper.枚数が0枚のチェック(div.getChkLabelShohon(), div.getTxtMaisuShohon());
                }
            },
    /**
     * 入場券貼付用枚数が0枚のチェック。
     */
    入場券貼付用枚数が0枚のチェック {
                @Override
                public boolean apply(LabelSealPrintTaishoDiv div) {
                    return SpecHelper.枚数が0枚のチェック(div.getChkLabelNyujoken(), div.getTxtMaisuNyujoken());
                }
            };

    private static class SpecHelper {

        public static boolean 枚数が0枚のチェック(CheckBoxList チェックボックス, TextBoxNum テキストボックス) {
            return チェックボックス.getSelectedKeys().isEmpty()
                    || (null != テキストボックス.getValue() && !テキストボックス.getValue().equals(Decimal.ZERO));
        }
    }
}
