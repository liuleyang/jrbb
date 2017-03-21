/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.af.afa.business.report.AFAPRG111;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRG111.IchigoShikakuTorokuTsuchiSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;


/**
 * {@link IchigoShikakuTorokuTsuchiSource}を、ソースファイルへ出力できる形へ編集します。
 *
 * @reamsid_L AF-0360-055 caijj2
 */
class IchigoShikakuTorokuTsuchiBuilder implements IIchigoShikakuTorokuTsuchiBuilder {
    
    private final IIchigoShikakuTorokuTsuchiEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor IIchigoShikakuTorokuTsuchiEditor
     */
    public IchigoShikakuTorokuTsuchiBuilder(IIchigoShikakuTorokuTsuchiEditor editor) {
        this.editor = editor;
    }

    @Override
    public IchigoShikakuTorokuTsuchiSource build() {
        return ReportEditorJoiner.from(new IchigoShikakuTorokuTsuchiSource()).join(editor).buildSource();
    }
}
