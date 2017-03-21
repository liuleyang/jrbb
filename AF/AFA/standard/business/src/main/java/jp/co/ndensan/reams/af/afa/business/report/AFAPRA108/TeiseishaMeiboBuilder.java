/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA108;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA108.TeiseishaMeiboSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * {@link TeiseishaMeiboSource}を、ソースファイルへ出力できる形へ編集します。
 *
 *
 */
class TeiseishaMeiboBuilder implements ITeiseishaMeiboBuilder {

    private final ITeiseishaMeiboEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param sourceBuilder ITeiseishaMeiboReportSourceBuilder
     * <T>TeiseishaMeiboReportSource;
     * @throws NullPointerException 引数がNullの場合
     */
    public TeiseishaMeiboBuilder(ITeiseishaMeiboEditor editor) {
        this.editor = editor;
    }

    @Override
    public TeiseishaMeiboSource build() {
        return ReportEditorJoiner.from(new TeiseishaMeiboSource()).join(editor).buildSource();
    }
}
