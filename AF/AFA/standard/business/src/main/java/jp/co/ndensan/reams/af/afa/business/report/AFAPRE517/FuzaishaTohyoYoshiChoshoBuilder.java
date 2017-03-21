/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE517;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE517.FuzaishaTohyoYoshiChoshoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票AFAPRE517_FuzaishaTohyoYoshiChosho_不在者投票用紙等の調書のBuilderクラスです。
 *
 * @reamsid_L AF-0280-034 wangm
 */
public class FuzaishaTohyoYoshiChoshoBuilder implements IFuzaishaTohyoYoshiChoshoBuilder {

    private final IFuzaishaTohyoYoshiChoshoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link FuzaishaTohyoYoshiChoshoEditor}
     */
    public FuzaishaTohyoYoshiChoshoBuilder(IFuzaishaTohyoYoshiChoshoEditor editor) {
        this.editor = editor;
    }

    @Override
    public FuzaishaTohyoYoshiChoshoSource build() {
        return ReportEditorJoiner.from(new FuzaishaTohyoYoshiChoshoSource()).join(editor).buildSource();
    }

}
