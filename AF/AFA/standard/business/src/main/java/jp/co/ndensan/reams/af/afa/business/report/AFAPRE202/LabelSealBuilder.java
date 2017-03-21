/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRE202;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE202.LabelSealSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * {@link LabelSealSource}を編集します。
 *
 * @reamsid_L AF-0070-021 liss
 */
public class LabelSealBuilder implements ILabelSealBuilder {

    private final ILabelSealEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor ILabelSealEditor
     */
    public LabelSealBuilder(ILabelSealEditor editor) {
        this.editor = editor;
    }

    @Override
    public LabelSealSource build() {
        return ReportEditorJoiner.from(new LabelSealSource()).join(editor).buildSource();
    }
}
