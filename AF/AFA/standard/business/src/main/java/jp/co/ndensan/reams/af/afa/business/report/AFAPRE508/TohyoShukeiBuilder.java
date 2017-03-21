/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE508;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE508.TohyoShukeiReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * {@link TohyoShukeiReportSource}を、ソースファイルへ出力できる形へ編集します。
 *
 * @reamsid_L AF-0280-025 lit
 */
class TohyoShukeiBuilder implements ITohyoShukeiBuilder {

    private final ITohyoShukeiEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor ITohyoShukeiEditor
     */
    public TohyoShukeiBuilder(ITohyoShukeiEditor editor) {
        this.editor = editor;
    }

    @Override
    public TohyoShukeiReportSource build() {
        return ReportEditorJoiner.from(new TohyoShukeiReportSource()).join(editor).buildSource();
    }
}
