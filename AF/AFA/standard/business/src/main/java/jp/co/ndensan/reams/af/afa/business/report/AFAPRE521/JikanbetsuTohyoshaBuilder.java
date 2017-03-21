/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE521;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE521.JikanbetsuTohyoshaReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * {@link JikanbetsuTohyoshaReportSource}を、ソースファイルへ出力できる形へ編集します。
 *
 * @reamsid_L AF-0290-037 lit
 */
class JikanbetsuTohyoshaBuilder implements IJikanbetsuTohyoshaBuilder {

    private final IJikanbetsuTohyoshaEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor ITohyoritsuEditor
     */
    public JikanbetsuTohyoshaBuilder(IJikanbetsuTohyoshaEditor editor) {
        this.editor = editor;
    }

    @Override
    public JikanbetsuTohyoshaReportSource build() {
        return ReportEditorJoiner.from(new JikanbetsuTohyoshaReportSource()).join(editor).buildSource();
    }
}
