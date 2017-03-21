/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE520;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE520.NenreibetsuTohyoritsuReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * {@link NenreibetsuTohyoritsuReportSource}を、ソースファイルへ出力できる形へ編集します。
 *
 * @reamsid_L AF-0290-036 lit
 */
class NenreibetsuTohyoritsuBuilder implements ITohyoritsuBuilder {

    private final ITohyoritsuEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor ITohyoritsuEditor
     */
    public NenreibetsuTohyoritsuBuilder(ITohyoritsuEditor editor) {
        this.editor = editor;
    }

    @Override
    public NenreibetsuTohyoritsuReportSource build() {
        return ReportEditorJoiner.from(new NenreibetsuTohyoritsuReportSource()).join(editor).buildSource();
    }
}
