/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA103;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA103.TorokushasuListSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * {@link TorokushasuListSource}を、ソースファイルへ出力できる形へ編集します。
 *
 * @reamsid_L AF-0030-031 liss
 */
class TorokushasuListFuzaiShikakuBuilder implements ITorokushasuListFuzaiShikakuBuilder {

    private final ITorokushasuListFuzaiShikakuEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param sourceBuilder ITorokushasuListReportSourceBuilder
     * <T>TorokushasuListReportSource;
     * @throws NullPointerException 引数がNullの場合
     */
    public TorokushasuListFuzaiShikakuBuilder(ITorokushasuListFuzaiShikakuEditor editor) {
        this.editor = editor;
    }

    @Override
    public TorokushasuListSource build() {
        return ReportEditorJoiner.from(new TorokushasuListSource()).join(editor).buildSource();
    }
}
