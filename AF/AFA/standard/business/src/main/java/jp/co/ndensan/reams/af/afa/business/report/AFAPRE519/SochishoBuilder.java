/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE519;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE519.SochishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * {@link SochishoReportSource}を、ソースファイルへ出力できる形へ編集します。
 *
 * @reamsid_L AF-0280-036 lit
 */
class SochishoBuilder implements ISochishoBuilder {

    private final ISochishoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor ISochishoEditor
     */
    public SochishoBuilder(ISochishoEditor editor) {
        this.editor = editor;
    }

    @Override
    public SochishoReportSource build() {
        return ReportEditorJoiner.from(new SochishoReportSource()).join(editor).buildSource();
    }
}
