/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA101;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA101.EikyuMeiboSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * {@link EikyuMeiboSource}を、ソースファイルへ出力できる形へ編集します。
 *
 *
 */
class EikyuMeiboBuilder implements IEikyuMeiboBuilder {

    private final IEikyuMeiboEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param sourceBuilder IEikyuMeiboReportSourceBuilder
     * <T>EikyuMeiboReportSource;
     * @throws NullPointerException 引数がNullの場合
     */
    public EikyuMeiboBuilder(IEikyuMeiboEditor editor) {
        this.editor = editor;
    }

    @Override
    public EikyuMeiboSource build() {
        return ReportEditorJoiner.from(new EikyuMeiboSource()).join(editor).buildSource();
    }
}
