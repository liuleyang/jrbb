/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA100;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA100.MeiboShohonSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * {@link MeiboShohonSource}を、ソースファイルへ出力できる形へ編集します。
 *
 */
public class MeiboShohonBuilder implements IMeiboShohonBuilder {

    private final IMeiboShohonEditor shohonEditor;

    /**
     * コンストラクタです。
     *
     * @param shohonEditor IMeiboShohonEditor
     */
    public MeiboShohonBuilder(IMeiboShohonEditor shohonEditor) {
        this.shohonEditor = shohonEditor;
    }

    @Override
    public MeiboShohonSource build() {
        return ReportEditorJoiner.from(new MeiboShohonSource()).join(shohonEditor).buildSource();
    }

}
