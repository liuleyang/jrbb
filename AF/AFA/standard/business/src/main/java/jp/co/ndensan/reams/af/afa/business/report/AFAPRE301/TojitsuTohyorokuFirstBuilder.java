/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE301;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE301.TojitsuTohyorokuReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * {@link TojitsuTohyorokuReportSource}を、ソースファイルへ出力できる形へ編集します。
 *
 * @reamsid_L AF-0130-021 lit
 */
class TojitsuTohyorokuFirstBuilder implements ITojitsuTohyorokuBuilder {

    private final ITojitsuTohyorokuEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor ITojitsuTohyorokuEditor
     */
    public TojitsuTohyorokuFirstBuilder(ITojitsuTohyorokuEditor editor) {
        this.editor = editor;
    }

    @Override
    public TojitsuTohyorokuReportSource build() {
        return ReportEditorJoiner.from(new TojitsuTohyorokuReportSource()).join(editor).buildSource();
    }
}
