/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRB101;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB101.NijuTorokuChosaKaitoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * {@link NijuTorokuChosaKaitoSource}を、ソースファイルへ出力できる形へ編集します。
 *
 * @reamsid_L AF-0030-034 liss
 */
class NijuTorokuChosaKaitoBuilder implements INijuTorokuChosaKaitoBuilder {

    private final INijuTorokuChosaKaitoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param sourceBuilder INijuTorokuChosaKaitoReportSourceBuilder
     * <T>NijuTorokuChosaKaitoReportSource;
     * @throws NullPointerException 引数がNullの場合
     */
    public NijuTorokuChosaKaitoBuilder(INijuTorokuChosaKaitoEditor editor) {
        this.editor = editor;
    }

    @Override
    public NijuTorokuChosaKaitoSource build() {
        return ReportEditorJoiner.from(new NijuTorokuChosaKaitoSource()).join(editor).buildSource();
    }
}
