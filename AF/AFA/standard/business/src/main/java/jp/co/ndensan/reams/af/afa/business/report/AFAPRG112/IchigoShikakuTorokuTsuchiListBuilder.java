/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.af.afa.business.report.AFAPRG112;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRG112.IchigoShikakuTorokuTsuchiListSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * {@link IchigoShikakuTorokuTsuchiListSource}を、ソースファイルへ出力できる形へ編集します。
 *
 * @reamsid_L AF-0360-056 caijj2
 */
public class IchigoShikakuTorokuTsuchiListBuilder implements IIchigoShikakuTorokuTsuchiListBuilder {
    
    private final IIchigoShikakuTorokuTsuchiListEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor ITohyoritsuEditor
     */
    public IchigoShikakuTorokuTsuchiListBuilder(IIchigoShikakuTorokuTsuchiListEditor editor) {
        this.editor = editor;
    }

    @Override
    public IchigoShikakuTorokuTsuchiListSource build() {
        return ReportEditorJoiner.from(new IchigoShikakuTorokuTsuchiListSource()).join(editor).buildSource();
    }
}
