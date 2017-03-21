/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5050;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.TohyoritsuData;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE520.NenreibetsuTohyoritsuReport;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.core.euc.AFAEucEntityId;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.tohyokekkaprint.TohyokekkaPrintMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.tohyokekkaprint.AFABTE505SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.tohyokekkaprint.TohyokekkaPrintEntity;
import jp.co.ndensan.reams.af.afa.entity.euc.afapre520.NenreibetsuTohyoritsuCsvEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE520.NenreibetsuTohyoritsuReportSource;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucCsvWriter;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 年齢別投票率集計表帳票出力のクラスです。
 *
 * @reamsid_L AF-0290-036 lit
 */
public class NenreibetsuTohyoritsuReportProcess extends BatchKeyBreakBase<TohyokekkaPrintEntity> {

    private static final RString MAPPER_ID
            = new RString("jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.tohyokekkaprint."
                    + "IAFABTE505Mapper.selectTohyokekkaPrintList");
    private AFABTE505SelectProcessParameter parameter;
    private TohyokekkaPrintMybatisParameter mybatisparameter;
    private NenreibetsuTohyoritsuBreakCore nenreibetsuTohyoritsuBreakCore;

    private static final List<RString> PAGE_BREAK_KEYS
            = Collections.unmodifiableList(Arrays.asList(new RString(NenreibetsuTohyoritsuReportSource.ReportSourceFileds.tohyokuCode.name()),
                            new RString(NenreibetsuTohyoritsuReportSource.ReportSourceFileds.senkyoNo.name())));

    @BatchWriter
    private BatchReportWriter<NenreibetsuTohyoritsuReportSource> batchReportWriter;
    private ReportSourceWriter<NenreibetsuTohyoritsuReportSource> reportSourceWriter;

    @BatchWriter
    private EucCsvWriter<NenreibetsuTohyoritsuCsvEntity> eucCsvWriter;
    private FileSpoolManager fileSpoolManager;
    private RString eucOutputFilePath;

    private static final RString CSV_DELIMITER = new RString(",");

    OutputParameter<Integer> pageCount = new OutputParameter<>();

    @Override
    protected void initialize() {
        mybatisparameter = parameter.toTohyokekkaPrintMybatisParameter();
    }

    @Override
    protected void beforeExecute() {
        nenreibetsuTohyoritsuBreakCore = new NenreibetsuTohyoritsuBreakCore(parameter);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPER_ID, mybatisparameter);
    }

    @Override
    protected void createWriter() {
        this.fileSpoolManager = new FileSpoolManager(
                UzUDE0835SpoolOutputType.EucOther,
                AFAEucEntityId.年齢別投票率集計表.getEucEntityId(),
                UzUDE0831EucAccesslogFileType.Csv);
        this.eucOutputFilePath = Path.combinePath(fileSpoolManager.getEucOutputDirectry(), AFAEucEntityId.年齢別投票率集計表.getFileName());
        this.eucCsvWriter = new EucCsvWriter.InstanceBuilder(this.eucOutputFilePath, AFAEucEntityId.年齢別投票率集計表.getEucEntityId())
                .setDelimiter(CSV_DELIMITER)
                .setEncode(Encode.SJIS)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .canAppend(true)
                .build();

        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdKeys.年齢別投票率集計表.value()).
                addBreak(new BreakerCatalog<NenreibetsuTohyoritsuReportSource>().simplePageBreaker(PAGE_BREAK_KEYS)).
                create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void usualProcess(TohyokekkaPrintEntity current) {
        nenreibetsuTohyoritsuBreakCore.usualProcess(current);
    }

    @Override
    protected void keyBreakProcess(TohyokekkaPrintEntity current) {
        List<TohyoritsuData> printList;
        if (parameter.isEucFlg()) {
            printList = nenreibetsuTohyoritsuBreakCore.keyBreakCsvProcess(getBefore(), current);
            for (TohyoritsuData data : printList) {
                eucCsvWriter.writeLine(nenreibetsuTohyoritsuBreakCore.createCsvEntity(data));
            }
        }
        printList = nenreibetsuTohyoritsuBreakCore.keyBreakChohyoProcess(getBefore(), current);
        for (TohyoritsuData data : printList) {
            NenreibetsuTohyoritsuReport report = new NenreibetsuTohyoritsuReport(data);
            report.writeBy(reportSourceWriter);
        }

    }

    @Override
    protected void afterExecute() {
        List<TohyoritsuData> printList;
        if (parameter.isEucFlg()) {
            printList = nenreibetsuTohyoritsuBreakCore.keyBreakCsvProcess(getBefore(), null);
            for (TohyoritsuData data : printList) {
                eucCsvWriter.writeLine(nenreibetsuTohyoritsuBreakCore.createCsvEntity(data));
            }

            this.eucCsvWriter.close();
            this.fileSpoolManager.spool(SubGyomuCode.AFA選挙本体, this.eucOutputFilePath);
        }

        printList = nenreibetsuTohyoritsuBreakCore.keyBreakChohyoProcess(getBefore(), null);
        for (TohyoritsuData data : printList) {
            NenreibetsuTohyoritsuReport report = new NenreibetsuTohyoritsuReport(data);
            report.writeBy(reportSourceWriter);
        }

        pageCount.setValue(batchReportWriter.getPageCount());
    }
}
