/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRB300;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB300.MeiboShohonZaigaiSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * {@link MeiboShohonZaigaiSource}を、ソースファイルへ出力できる形へ編集します。
 *
 * @reamsid_L AF-0030-035 liss
 */
class MeiboShohonZaigaiBuilder implements IMeiboShohonZaigaiBuilder {

    private final IMeiboShohonZaigaiEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param sourceBuilder IMeiboShohonZaigaiReportSourceBuilder
     * <T>MeiboShohonZaigaiReportSource;
     * @throws NullPointerException 引数がNullの場合
     */
    public MeiboShohonZaigaiBuilder(IMeiboShohonZaigaiEditor editor) {
        this.editor = editor;
    }

    @Override
    public MeiboShohonZaigaiSource build() {
        return ReportEditorJoiner.from(new MeiboShohonZaigaiSource()).join(editor).buildSource();
    }
}
