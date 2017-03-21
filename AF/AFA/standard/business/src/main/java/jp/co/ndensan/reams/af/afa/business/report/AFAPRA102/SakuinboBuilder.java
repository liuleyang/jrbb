/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA102;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA102.SakuinboSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * {@link SakuinboSource}を、ソースファイルへ出力できる形へ編集します。
 *
 *
 */
class SakuinboBuilder implements ISakuinboBuilder {

    private final ISakuinboEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param sourceBuilder ISakuinboReportSourceBuilder
     * <T>SakuinboReportSource;
     * @throws NullPointerException 引数がNullの場合
     */
    public SakuinboBuilder(ISakuinboEditor editor) {
        this.editor = editor;
    }

    @Override
    public SakuinboSource build() {
        return ReportEditorJoiner.from(new SakuinboSource()).join(editor).buildSource();
    }
}
