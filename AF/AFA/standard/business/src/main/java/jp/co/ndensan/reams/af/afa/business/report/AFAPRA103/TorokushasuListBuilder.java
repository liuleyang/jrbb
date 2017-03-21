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
 *
 */
class TorokushasuListBuilder implements ITorokushasuListBuilder {

    private final ITorokushasuListEditor editor;

    public TorokushasuListBuilder(ITorokushasuListEditor editor) {
        this.editor = editor;
    }

    @Override
    public TorokushasuListSource build() {
        return ReportEditorJoiner.from(new TorokushasuListSource()).join(editor).buildSource();
    }
}
