/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA107;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA107.KikaTaishoshaListSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * {@link KikaTaishoshaListSource}を、ソースファイルへ出力できる形へ編集します。
 *
 *
 */
final class KikaTaishoshaListBuilder implements IKikaTaishoshaListBuilder {

    private final IKikaTaishoshaListEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param sourceBuilder IKikaTaishoshaListReportSourceBuilder
     * <T>KikaTaishoshaListReportSource;
     * @throws NullPointerException 引数がNullの場合
     */
    public KikaTaishoshaListBuilder(IKikaTaishoshaListEditor editor) {
        this.editor = editor;
    }

    @Override
    public KikaTaishoshaListSource build() {
        return ReportEditorJoiner.from(new KikaTaishoshaListSource()).join(editor).buildSource();
    }
}
