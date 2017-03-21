/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5040;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.TohyoShukeiData;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE508.TohyoShukeiReport;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.zenjitsuprint.ZenjitsuPrintMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.zenjitsuprint.AFABTE504SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.zenjitsuprint.ZenjitsuPrintEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE508.TohyoShukeiReportSource;
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
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 投票日前日関連帳票出力のクラスです。
 *
 * @reamsid_L AF-0280-020 lit
 */
public class TohyoShukeiReportProcess extends BatchKeyBreakBase<ZenjitsuPrintEntity> {

    private static final RString MAPPER_ID
            = new RString("jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.zenjitsuprint."
                    + "IAFABTE504Mapper.selectZenjitsuPrintList");
    private AFABTE504SelectProcessParameter parameter;
    private ZenjitsuPrintMybatisParameter mybatisparameter;

    @BatchWriter
    private BatchReportWriter<TohyoShukeiReportSource> batchReportWriter;
    private ReportSourceWriter<TohyoShukeiReportSource> reportSourceWriter;
    private TohyoShukeiBreakCore tohyoShukeiBreakCore;
    private RString 抄本_住所編集_ヘッダ部住所;

    private static final List<RString> PAGE_BREAK_KEYS
            = Collections.unmodifiableList(Arrays.asList(new RString(TohyoShukeiReportSource.ReportSourceFileds.tohyokuCode.name()),
                            new RString(TohyoShukeiReportSource.ReportSourceFileds.senkyoNo.name())));

    OutputParameter<Integer> pageCount = new OutputParameter<>();

    @Override
    protected void beforeExecute() {
        抄本_住所編集_ヘッダ部住所 = BusinessConfig.get(ConfigKeysAFA.抄本_住所編集_ヘッダ部住所);
        tohyoShukeiBreakCore = new TohyoShukeiBreakCore(parameter).createInstance(抄本_住所編集_ヘッダ部住所);
    }

    @Override
    protected void initialize() {
        mybatisparameter = parameter.toZenjitsuPrintMybatisParameter();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPER_ID, mybatisparameter);
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdKeys.投票集計表.value()).
                addBreak(new BreakerCatalog<TohyoShukeiReportSource>().simplePageBreaker(PAGE_BREAK_KEYS)).
                create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void usualProcess(ZenjitsuPrintEntity current) {
        tohyoShukeiBreakCore.usualProcess(current);
    }

    @Override
    protected void keyBreakProcess(ZenjitsuPrintEntity current) {
        List<TohyoShukeiData> writeEntityList = tohyoShukeiBreakCore.keyBreakProcess(getBefore(), current);
        for (TohyoShukeiData data : writeEntityList) {
            TohyoShukeiReport report = new TohyoShukeiReport(data);
            report.writeBy(reportSourceWriter);
        }
    }

    @Override
    protected void afterExecute() {
        if (null == getBefore()) {
            pageCount.setValue(0);
            return;
        }
        List<TohyoShukeiData> writeEntityList = tohyoShukeiBreakCore.createLastProcess(getBefore());
        for (TohyoShukeiData data : writeEntityList) {
            TohyoShukeiReport report = new TohyoShukeiReport(data);
            report.writeBy(reportSourceWriter);
        }

        pageCount.setValue(batchReportWriter.getPageCount());
    }
}
