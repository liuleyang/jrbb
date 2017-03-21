/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA106;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA106.ShinkiTorokushaMeiboJuranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * @linkShinkiTorokushaMeiboJuranReportSource}を、ソースファイルへ出力できる形へ編集します。
 *
 */
final class ShinkiTorokushaMeiboJuranBuilder implements IShinkiTorokushaMeiboJuranBuilder {

    private final IShinkiTorokushaMeiboJuranEditor editor;

    public ShinkiTorokushaMeiboJuranBuilder(IShinkiTorokushaMeiboJuranEditor editor) {
        this.editor = editor;
    }

    @Override
    public ShinkiTorokushaMeiboJuranSource build() {
        return ReportEditorJoiner.from(new ShinkiTorokushaMeiboJuranSource()).join(editor).buildSource();

    }

}
