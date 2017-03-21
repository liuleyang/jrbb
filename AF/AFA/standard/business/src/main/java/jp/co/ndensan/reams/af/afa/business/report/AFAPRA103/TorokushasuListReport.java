/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.report.AFAPRA103;

import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA103.TorokushasuListSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 登録者数リスト作成を出力する、リアル・バッチ両方で使用可能なReportクラスです。<br />
 * n行を生成可能とするため、リストの登録者数リストソースクラスを受け取ります。
 *
 */
public final class TorokushasuListReport extends Report<TorokushasuListSource> {

    private final TorokushasuListParam target;

    /**
     * インスタンスを生成します。
     *
     * @param target TorokushasuListParam
     */
    public TorokushasuListReport(TorokushasuListParam target) {
        this.target = target;
    }

    @Override
    public void writeBy(ReportSourceWriter<TorokushasuListSource> writer) {
        ITorokushasuListEditor editor = new TorokushasuListEditor(target);
        ITorokushasuListBuilder builder = new TorokushasuListBuilder(editor);
        writer.writeLine(builder);
    }

}
