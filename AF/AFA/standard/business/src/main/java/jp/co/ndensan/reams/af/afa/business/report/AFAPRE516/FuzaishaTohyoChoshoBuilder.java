/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE516;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE516.FuzaishaTohyoChoshoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票AFAPRE516_FuzaishaTohyoChosho_不在者投票に関する調書（25号様式）のBuilderクラスです。
 *
 * @reamsid_L AF-0280-033 wangm
 */
public class FuzaishaTohyoChoshoBuilder implements IFuzaishaTohyoChoshoBuilder {

    private final IFuzaishaTohyoChoshoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link FuzaishaTohyoChoshoEditor}
     */
    public FuzaishaTohyoChoshoBuilder(IFuzaishaTohyoChoshoEditor editor) {
        this.editor = editor;
    }

    @Override
    public FuzaishaTohyoChoshoSource build() {
        return ReportEditorJoiner.from(new FuzaishaTohyoChoshoSource()).join(editor).buildSource();
    }

}
