/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB1010;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojitouroku.AFABTB101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA103.TorokushasuListSource;
import jp.co.ndensan.reams.af.afa.entity.xml.senkyojitouroku.AFAPRA103FuzaiShikakuEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 登録者数リスト（不在者投票資格者分）帳票出力のクラスです。
 *
 * @reamsid_L AF-0030-031 liss
 */
public class TorokushasuListFuzaiShikakuReportProcess extends BatchKeyBreakBase<AFAPRA103FuzaiShikakuEntity> {

    private AFABTB101SelectProcessParameter parameter;
    @BatchWriter
    private BatchReportWriter<TorokushasuListSource> batchReportWriter;
    private ReportSourceWriter<TorokushasuListSource> reportSourceWriter;

    private TorokushasuListFuzaiShikakuBreakCore core;
    private static final List<RString> PAGE_BREAK_KEYS
            = Collections.unmodifiableList(Arrays.asList(new RString(TorokushasuListSource.ReportSourceFields.title.name()),
                            new RString(TorokushasuListSource.ReportSourceFields.senkyoNo.name()),
                            new RString(TorokushasuListSource.ReportSourceFields.sumType.name())));

    /**
     * ページ数Parameterです。
     */
    public static final RString PAGE_COUNT;

    static {
        PAGE_COUNT = new RString("pageCount");
    }
    OutputParameter<Integer> pageCount = new OutputParameter<>();

    @Override
    protected void initialize() {
        core = new TorokushasuListFuzaiShikakuBreakCore(parameter);
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdKeys.不在者投票資格者分.value())
                .addBreak(new BreakerCatalog<TorokushasuListSource>().simplePageBreaker(PAGE_BREAK_KEYS)).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(new RString(
                "jp.co.ndensan.reams.af.afa.persistence.db.mapper.senkyojitouroku.IAFAPRB103tempTorokushasuListFuzaiMapper."
                + "selectDataForTorokushasuList"));
    }

    @Override
    protected void usualProcess(AFAPRA103FuzaiShikakuEntity entity) {
        core.usualProcess(entity, reportSourceWriter);
    }

    @Override
    protected void keyBreakProcess(AFAPRA103FuzaiShikakuEntity entity) {
        core.keyBreakProcess(getBefore(), entity, reportSourceWriter);
    }

    @Override
    protected void afterExecute() {
        core.createLastProcess(reportSourceWriter);
        pageCount.setValue(batchReportWriter.getPageCount());
    }

}
