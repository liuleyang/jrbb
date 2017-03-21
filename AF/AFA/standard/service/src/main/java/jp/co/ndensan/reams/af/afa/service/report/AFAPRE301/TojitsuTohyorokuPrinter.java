/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.report.AFAPRE301;

import jp.co.ndensan.reams.af.afa.business.core.TohyorokuChohyo;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE301.TojitsuTohyorokuProperty;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE301.TojitsuTohyorokuReport;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE301.TojitsuTohyorokuReportSource;
import jp.co.ndensan.reams.uz.uza.report.IReportProperty;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportAssemblerBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;

/**
 * 当日投票録Printerクラスです。
 *
 * @reamsid_L AF-0130-021 lit
 */
public class TojitsuTohyorokuPrinter {

    /**
     * 印刷処理
     *
     * @param item 当日投票録対象クラス
     * @return 印刷結果
     */
    public SourceDataCollection print(TohyorokuChohyo item) {
        TojitsuTohyorokuProperty property = new TojitsuTohyorokuProperty();
        return new Printer<TojitsuTohyorokuReportSource>().spool(property, toReport(item));
    }

    /**
     * 印刷処理
     *
     * @param item 当日投票録対象クラス
     * @param reportManager 印刷管理
     */
    public void print(TohyorokuChohyo item, ReportManager reportManager) {
        TojitsuTohyorokuProperty property = new TojitsuTohyorokuProperty();
        try (ReportAssembler<TojitsuTohyorokuReportSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<TojitsuTohyorokuReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
            TojitsuTohyorokuReport report = toReport(item);
            report.writeBy(reportSourceWriter);
        }
    }

    private TojitsuTohyorokuReport toReport(TohyorokuChohyo item) {
        return new TojitsuTohyorokuReport(item);
    }

    private static <T extends IReportSource, R extends Report<T>> ReportAssembler<T>
            createAssembler(IReportProperty<T> property, ReportManager manager) {
        ReportAssemblerBuilder builder = manager.reportAssembler(property.reportId().value(), property.subGyomuCode());
        for (BreakAggregator<? super T, ?> breaker : property.breakers()) {
            builder.addBreak(breaker);
        }
        builder.isHojinNo(property.containsHojinNo());
        builder.isKojinNo(property.containsKojinNo());
        return builder.<T>create();
    }
}
