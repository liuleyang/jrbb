/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE201;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE201.FuzaishaTohyoShomeishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * {@link FuzaishaTohyoShomeishoReportSource}を編集します。
 *
 * @reamsid_L AF-0090-020 lit
 */
class FuzaishaTohyoShomeishoBuilder implements IFuzaishaTohyoShomeishoBuilder {

    private final IFuzaishaTohyoShomeishoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor IFuzaishaTohyoShomeishoEditor
     */
    public FuzaishaTohyoShomeishoBuilder(IFuzaishaTohyoShomeishoEditor editor) {
        this.editor = editor;
    }

    @Override
    public FuzaishaTohyoShomeishoReportSource build() {
        return ReportEditorJoiner.from(new FuzaishaTohyoShomeishoReportSource()).join(editor).buildSource();
    }
}
