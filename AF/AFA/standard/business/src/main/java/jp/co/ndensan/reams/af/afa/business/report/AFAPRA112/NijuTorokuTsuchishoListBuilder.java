/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA112;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA112.NijuTorokuTsuchishoListSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * {@link NijuTorokuTsuchishoListSource}を、ソースファイルへ出力できる形へ編集します。
 *
 *
 */
class NijuTorokuTsuchishoListBuilder implements INijuTorokuTsuchishoListBuilder {

    private final INijuTorokuTsuchishoListEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param sourceBuilder INijuTorokuTsuchishoListReportSourceBuilder
     * <T>NijuTorokuTsuchishoListReportSource;
     * @throws NullPointerException 引数がNullの場合
     */
    public NijuTorokuTsuchishoListBuilder(INijuTorokuTsuchishoListEditor editor) {
        this.editor = editor;
    }

    @Override
    public NijuTorokuTsuchishoListSource build() {
        return ReportEditorJoiner.from(new NijuTorokuTsuchishoListSource()).join(editor).buildSource();
    }
}
