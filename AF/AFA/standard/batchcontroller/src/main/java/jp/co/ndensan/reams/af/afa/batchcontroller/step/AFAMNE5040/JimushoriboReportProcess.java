/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5040;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE515.JimushoriboParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE515.JimushoriboReport;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.zenjitsuprint.ZenjitsuPrintMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.zenjitsuprint.AFABTE504SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.zenjitsuprint.ZenjitsuPrintEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE511.DairiTohyoShukeihyoSource;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE515.JimushoriboSource;
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
 * 事務処理簿帳票出力のクラスです。
 *
 * @reamsid_L AF-0280-032 lit
 */
public class JimushoriboReportProcess extends BatchKeyBreakBase<ZenjitsuPrintEntity> {

    private static final RString MAPPER_ID
            = new RString("jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.zenjitsuprint."
                    + "IAFABTE504Mapper.selectZenjitsuPrintList");
    private static final List<RString> PAGE_BREAK_KEYS
            = Collections.unmodifiableList(Arrays.asList(new RString(JimushoriboSource.ReportSourceFields.senkyoNo.name())));

    private AFABTE504SelectProcessParameter parameter;
    private ZenjitsuPrintMybatisParameter mybatisparameter;

    @BatchWriter
    private BatchReportWriter<JimushoriboSource> batchReportWriter;
    private ReportSourceWriter<JimushoriboSource> reportSourceWriter;
    private JimushoriboBreakCore core;

    OutputParameter<Integer> pageCount = new OutputParameter<>();

    @Override
    protected void initialize() {
        mybatisparameter = parameter.toZenjitsuPrintMybatisParameter();
    }

    @Override
    protected void beforeExecute() {
        TohyoJokyo 投票状況 = TohyoJokyo.toValue(parameter.get投票状況リスト().get(0));
        core = new JimushoriboBreakCore(TohyoJokyo.期日前.equals(投票状況));
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPER_ID, mybatisparameter);
    }

    @Override
    protected void createWriter() {
        TohyoJokyo 投票状況 = TohyoJokyo.toValue(parameter.get投票状況リスト().get(0));
        batchReportWriter = BatchReportFactory.createBatchReportWriter(TohyoJokyo.期日前.equals(投票状況)
                ? ReportIdKeys.事務処理簿_期日前.value()
                : ReportIdKeys.事務処理簿_不在者.value()).
                addBreak(new BreakerCatalog<DairiTohyoShukeihyoSource>().simplePageBreaker(PAGE_BREAK_KEYS)).
                create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void usualProcess(ZenjitsuPrintEntity current) {
        core.usualProcess(current);
    }

    @Override
    protected void keyBreakProcess(ZenjitsuPrintEntity current) {
        List<JimushoriboParam> printList = core.keyBreakProcess(getBefore(), current);
        for (JimushoriboParam data : printList) {
            JimushoriboReport report = new JimushoriboReport(data);
            report.writeBy(reportSourceWriter);
        }

    }

    @Override
    protected void afterExecute() {
        List<JimushoriboParam> printList = core.createLastProcess(getBefore());
        for (JimushoriboParam data : printList) {
            JimushoriboReport report = new JimushoriboReport(data);
            report.writeBy(reportSourceWriter);
        }

        pageCount.setValue(batchReportWriter.getPageCount());
    }
}
