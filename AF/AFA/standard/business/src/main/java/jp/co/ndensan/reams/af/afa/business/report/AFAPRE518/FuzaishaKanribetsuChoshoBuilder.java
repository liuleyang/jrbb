/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE518;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE518.FuzaishaKanribetsuChoshoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * {@link FuzaishaKanribetsuChoshoReportSource}を、ソースファイルへ出力できる形へ編集します。
 *
 * @reamsid_L AF-0280-036 lit
 */
class FuzaishaKanribetsuChoshoBuilder implements IFuzaishaKanribetsuChoshoBuilder {

    private final IFuzaishaKanribetsuChoshoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor IFuzaishaKanribetsuChoshoEditor
     */
    public FuzaishaKanribetsuChoshoBuilder(IFuzaishaKanribetsuChoshoEditor editor) {
        this.editor = editor;
    }

    @Override
    public FuzaishaKanribetsuChoshoReportSource build() {
        return ReportEditorJoiner.from(new FuzaishaKanribetsuChoshoReportSource()).join(editor).buildSource();
    }
}
