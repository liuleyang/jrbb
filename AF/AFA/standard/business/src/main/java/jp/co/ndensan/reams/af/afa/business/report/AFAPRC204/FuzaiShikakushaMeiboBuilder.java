/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRC204;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRC204.FuzaiShikakushaMeiboSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * {@link FuzaiShikakushaMeiboSource}を、ソースファイルへ出力できる形へ編集します。
 *
 * @reamsid_L AF-0030-036 liss
 */
class FuzaiShikakushaMeiboBuilder implements IFuzaiShikakushaMeiboBuilder {

    private final IFuzaiShikakushaMeiboEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param sourceBuilder IFuzaiShikakushaMeiboReportSourceBuilder
     * <T>FuzaiShikakushaMeiboReportSource;
     * @throws NullPointerException 引数がNullの場合
     */
    public FuzaiShikakushaMeiboBuilder(IFuzaiShikakushaMeiboEditor editor) {
        this.editor = editor;
    }

    @Override
    public FuzaiShikakushaMeiboSource build() {
        return ReportEditorJoiner.from(new FuzaiShikakushaMeiboSource()).join(editor).buildSource();
    }
}
