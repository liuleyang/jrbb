/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRB100;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB100.NijuTorokuChosaShokaiSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * {@link NijuTorokuChosaShokaiListSource}を、ソースファイルへ出力できる形へ編集します。
 *
 * @reamsid_L AF-0030-033 liss
 */
class NijuTorokuChosaShokaiListBuilder implements INijuTorokuChosaShokaiListBuilder {

    private final INijuTorokuChosaShokaiListEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param sourceBuilder INijuTorokuChosaShokaiListReportSourceBuilder
     * <T>NijuTorokuChosaShokaiListReportSource;
     * @throws NullPointerException 引数がNullの場合
     */
    public NijuTorokuChosaShokaiListBuilder(INijuTorokuChosaShokaiListEditor editor) {
        this.editor = editor;
    }

    @Override
    public NijuTorokuChosaShokaiSource build() {
        return ReportEditorJoiner.from(new NijuTorokuChosaShokaiSource()).join(editor).buildSource();
    }
}
