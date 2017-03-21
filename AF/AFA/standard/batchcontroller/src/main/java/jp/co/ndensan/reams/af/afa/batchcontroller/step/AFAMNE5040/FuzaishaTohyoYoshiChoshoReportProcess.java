/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5040;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE517.FuzaishaTohyoYoshiChoshoParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE517.FuzaishaTohyoYoshiChoshoReport;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.zenjitsuprint.ZenjitsuPrintMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.zenjitsuprint.AFABTE504SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.zenjitsuprint.ZenjitsuPrintEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE517.FuzaishaTohyoYoshiChoshoSource;
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
 * 不在者投票用紙等の調書帳票出力のクラスです。
 *
 * @reamsid_L AF-0280-034 lit
 */
public class FuzaishaTohyoYoshiChoshoReportProcess extends BatchKeyBreakBase<ZenjitsuPrintEntity> {

    private static final RString MAPPER_ID
            = new RString("jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.zenjitsuprint."
                    + "IAFABTE504Mapper.selectZenjitsuPrintList");
    private static final List<RString> PAGE_BREAK_KEYS
            = Collections.unmodifiableList(Arrays.asList(new RString(FuzaishaTohyoYoshiChoshoSource.ReportSourceFields.pagecnt.name())));

    private AFABTE504SelectProcessParameter parameter;
    private ZenjitsuPrintMybatisParameter mybatisparameter;

    @BatchWriter
    private BatchReportWriter<FuzaishaTohyoYoshiChoshoSource> batchReportWriter;
    private ReportSourceWriter<FuzaishaTohyoYoshiChoshoSource> reportSourceWriter;
    private FuzaishaTohyoYoshiChoshoBreakCore core;

    OutputParameter<Integer> pageCount = new OutputParameter<>();

    @Override
    protected void initialize() {
        mybatisparameter = parameter.toZenjitsuPrintMybatisParameter();
    }

    @Override
    protected void beforeExecute() {
        core = new FuzaishaTohyoYoshiChoshoBreakCore(parameter);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPER_ID, mybatisparameter);
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdKeys.不在者投票用紙等の調書.value()).
                addBreak(new BreakerCatalog<FuzaishaTohyoYoshiChoshoSource>().simplePageBreaker(PAGE_BREAK_KEYS)).
                create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void usualProcess(ZenjitsuPrintEntity current) {
        core.usualProcess(current);
    }

    @Override
    protected void keyBreakProcess(ZenjitsuPrintEntity current) {
        List<FuzaishaTohyoYoshiChoshoParam> printList = core.keyBreakProcess(getBefore(), current);
        for (FuzaishaTohyoYoshiChoshoParam data : printList) {
            FuzaishaTohyoYoshiChoshoReport report = new FuzaishaTohyoYoshiChoshoReport(data);
            report.writeBy(reportSourceWriter);
        }

    }

    @Override
    protected void afterExecute() {
        List<FuzaishaTohyoYoshiChoshoParam> printList = core.createLastProcess(getBefore());
        for (FuzaishaTohyoYoshiChoshoParam data : printList) {
            FuzaishaTohyoYoshiChoshoReport report = new FuzaishaTohyoYoshiChoshoReport(data);
            report.writeBy(reportSourceWriter);
        }

        pageCount.setValue(batchReportWriter.getPageCount());
    }
}
