/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5040;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE513.JikanbetsuJokyoGokeiParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE513.JikanbetsuJokyoGokeiReport;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.zenjitsuprint.ZenjitsuPrintMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.zenjitsuprint.AFABTE504SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.zenjitsuprint.ZenjitsuPrintEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE513.JikanbetsuJokyoGokeiSource;
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
 * 時間別投票状況表　合計帳票出力のクラスです。
 *
 * @reamsid_L AF-0280-030 lit
 */
public class JikanbetsuGokeiReportProcess extends BatchKeyBreakBase<ZenjitsuPrintEntity> {

    private static final RString MAPPER_ID
            = new RString("jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.zenjitsuprint."
                    + "IAFABTE504Mapper.selectZenjitsuPrintList");
    private AFABTE504SelectProcessParameter parameter;
    private ZenjitsuPrintMybatisParameter mybatisparameter;
    private JikanbetsuGokeiBreakCore jikanbetsuGokeiBreakCore;
    private static final List<RString> PAGE_BREAK_KEYS
            = Collections.unmodifiableList(Arrays.asList(new RString(JikanbetsuJokyoGokeiSource.ReportSourceFields.senkyoNo.name())));

    @BatchWriter
    private BatchReportWriter<JikanbetsuJokyoGokeiSource> batchReportWriter;
    private ReportSourceWriter<JikanbetsuJokyoGokeiSource> reportSourceWriter;

    OutputParameter<Integer> pageCount = new OutputParameter<>();

    @Override
    protected void initialize() {
        mybatisparameter = parameter.toZenjitsuPrintMybatisParameter();
    }

    @Override
    protected void beforeExecute() {
        jikanbetsuGokeiBreakCore = new JikanbetsuGokeiBreakCore();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPER_ID, mybatisparameter);
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdKeys.時間別投票状況表合計.value()).
                addBreak(new BreakerCatalog<JikanbetsuJokyoGokeiSource>().simplePageBreaker(PAGE_BREAK_KEYS)).
                create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void usualProcess(ZenjitsuPrintEntity current) {
        jikanbetsuGokeiBreakCore.usualProcess(current);
    }

    @Override
    protected void keyBreakProcess(ZenjitsuPrintEntity current) {
        List<JikanbetsuJokyoGokeiParam> printList = jikanbetsuGokeiBreakCore.keyBreakProcess(getBefore(), current);
        for (JikanbetsuJokyoGokeiParam data : printList) {
            JikanbetsuJokyoGokeiReport report = new JikanbetsuJokyoGokeiReport(data);
            report.writeBy(reportSourceWriter);
        }
    }

    @Override
    protected void afterExecute() {
        List<JikanbetsuJokyoGokeiParam> printList = jikanbetsuGokeiBreakCore.createLastProcess();
        for (JikanbetsuJokyoGokeiParam data : printList) {
            JikanbetsuJokyoGokeiReport report = new JikanbetsuJokyoGokeiReport(data);
            report.writeBy(reportSourceWriter);
        }

        pageCount.setValue(batchReportWriter.getPageCount());
    }
}
