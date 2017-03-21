/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5050;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.JikanbetsuTohyoshaParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE521.JikanbetsuTohyoshaReport;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.tohyokekkaprint.TohyokekkaPrintMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.tohyokekkaprint.AFABTE505SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.tohyokekkaprint.TohyokekkaPrintEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE521.JikanbetsuTohyoshaReportSource;
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
 * 年代別投票率集計表帳票出力のクラスです。
 *
 * @reamsid_L AF-0290-035 lit
 */
public class JikanbetsuTohyoshaReportProcess extends BatchKeyBreakBase<TohyokekkaPrintEntity> {

    private static final RString MAPPER_ID
            = new RString("jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.tohyokekkaprint."
                    + "IAFABTE505Mapper.selectTohyokekkaPrintList");
    private AFABTE505SelectProcessParameter parameter;
    private TohyokekkaPrintMybatisParameter mybatisparameter;
    private JikanbetsuTohyoshaBreakCore core;

    private static final List<RString> PAGE_BREAK_KEYS
            = Collections.unmodifiableList(Arrays.asList(new RString(JikanbetsuTohyoshaReportSource.ReportSourceFileds.subTitle.name()),
                            new RString(JikanbetsuTohyoshaReportSource.ReportSourceFileds.senkyoNo.name())));

    @BatchWriter
    private BatchReportWriter<JikanbetsuTohyoshaReportSource> batchReportWriter;
    private ReportSourceWriter<JikanbetsuTohyoshaReportSource> reportSourceWriter;

    OutputParameter<Integer> pageCount = new OutputParameter<>();

    @Override
    protected void initialize() {
        mybatisparameter = parameter.toTohyokekkaPrintMybatisParameter();
    }

    @Override
    protected void beforeExecute() {
        core = new JikanbetsuTohyoshaBreakCore(parameter);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPER_ID, mybatisparameter);
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdKeys.時間別投票者集計表.value()).
                addBreak(new BreakerCatalog<JikanbetsuTohyoshaReportSource>().simplePageBreaker(PAGE_BREAK_KEYS)).
                create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void usualProcess(TohyokekkaPrintEntity current) {
        core.usualProcess(getBefore(), current);
    }

    @Override
    protected void keyBreakProcess(TohyokekkaPrintEntity current) {
        List<JikanbetsuTohyoshaParam> printList = core.keyBreakProcess(getBefore(), current);
        for (JikanbetsuTohyoshaParam data : printList) {
            JikanbetsuTohyoshaReport report = new JikanbetsuTohyoshaReport(data);
            report.writeBy(reportSourceWriter);
        }
    }

    @Override
    protected void afterExecute() {
        if (null == getBefore()) {
            pageCount.setValue(0);
            return;
        }

        List<JikanbetsuTohyoshaParam> printList = core.keyBreakProcess(getBefore(), null);
        for (JikanbetsuTohyoshaParam data : printList) {
            JikanbetsuTohyoshaReport report = new JikanbetsuTohyoshaReport(data);
            report.writeBy(reportSourceWriter);
        }
        pageCount.setValue(batchReportWriter.getPageCount());
    }
}
