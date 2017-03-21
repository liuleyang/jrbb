/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE506;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE506.KijitsumaeTohyorokuReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * {@link KijitsumaeTohyorokuReportSource}を、ソースファイルへ出力できる形へ編集します。
 *
 * @reamsid_L AF-0130-020 lit
 */
class KijitsumaeTohyorokuThreeMaiFirstBuilder implements IKijitsumaeTohyorokuBuilder {

    private final IKijitsumaeTohyorokuEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor IKijitsumaeTohyorokuEditor
     */
    public KijitsumaeTohyorokuThreeMaiFirstBuilder(IKijitsumaeTohyorokuEditor editor) {
        this.editor = editor;
    }

    @Override
    public KijitsumaeTohyorokuReportSource build() {
        return ReportEditorJoiner.from(new KijitsumaeTohyorokuReportSource()).join(editor).buildSource();
    }
}
