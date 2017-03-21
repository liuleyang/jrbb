/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRG103;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRG103.TorokushasuListKokuminSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * {@link TorokushasuListKokuminSource}を、ソースファイルへ出力できる形へ編集します。
 *
 * @reamsid_L AF-0360-054 qiuxy
 */
public class TorokushasuListBuilder implements ITorokushasuListBuilder {

    private final ITorokushasuListEditor editor;

    TorokushasuListBuilder(ITorokushasuListEditor editor) {
        this.editor = editor;
    }

    @Override
    public TorokushasuListKokuminSource build() {
        return ReportEditorJoiner.from(new TorokushasuListKokuminSource()).join(editor).buildSource();
    }
}
