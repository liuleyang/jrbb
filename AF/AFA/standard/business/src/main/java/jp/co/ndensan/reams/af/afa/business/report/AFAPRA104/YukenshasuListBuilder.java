/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA104;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA104.YukenshasuShirabeSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * {@link YukenshasuListSource}を、ソースファイルへ出力できる形へ編集します。
 *
 * @reamsid_L AF-0010-038 wangm
 */
class YukenshasuListBuilder implements IYukenshasuListBuilder {

    private final IYukenshasuListEditor editor;

    public YukenshasuListBuilder(IYukenshasuListEditor editor) {
        this.editor = editor;
    }

    @Override
    public YukenshasuShirabeSource build() {
        return ReportEditorJoiner.from(new YukenshasuShirabeSource()).join(editor).buildSource();
    }
}
