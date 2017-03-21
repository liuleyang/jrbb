/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5040;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.ZenjitsuCommonJohoItem;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE510.ShisetsuKofuIchiranhyoParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE510.ShisetsuKofuIchiranhyoReport;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.zenjitsuprint.ZenjitsuPrintMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.zenjitsuprint.AFABTE504SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.zenjitsuprint.ZenjitsuPrintEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE510.ShisetsuKofuIchiranhyoSource;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE519.SochishoReportSource;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 施設交付一覧表帳票出力のクラスです。
 *
 * @reamsid_L AF-0280-027 lit
 */
public class ShisetsuKofuIchiranhyoReportProcess extends BatchProcessBase<ZenjitsuPrintEntity> {

    private static final RString MAPPER_ID
            = new RString("jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.zenjitsuprint."
                    + "IAFABTE504Mapper.selectZenjitsuPrintList");
    private static final List<RString> PAGE_BREAK_KEYS
            = Collections.unmodifiableList(Arrays.asList(new RString(ShisetsuKofuIchiranhyoSource.ReportSourceFields.pagecnt.name())));

    private AFABTE504SelectProcessParameter parameter;
    private ZenjitsuPrintMybatisParameter mybatisparameter;
    private ShisetsuKofuIchiranhyoParam.ShisetsuKofuIchiranhyoParamBuilder paramBuilder;

    @BatchWriter
    private BatchReportWriter<ShisetsuKofuIchiranhyoSource> batchReportWriter;
    private ReportSourceWriter<ShisetsuKofuIchiranhyoSource> reportSourceWriter;

    OutputParameter<Integer> pageCount = new OutputParameter<>();

    @Override
    protected void initialize() {
        mybatisparameter = parameter.toZenjitsuPrintMybatisParameter();
    }

    @Override
    protected void beforeExecute() {
        ZenjitsuCommonJohoItem 帳票共通ヘッダー = new ZenjitsuReportHeaderEditor().create帳票共通ヘッダー();
        paramBuilder = new ShisetsuKofuIchiranhyoParam.ShisetsuKofuIchiranhyoParamBuilder(帳票共通ヘッダー);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPER_ID, mybatisparameter);
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdKeys.施設交付一覧表.value()).
                addBreak(new BreakerCatalog<SochishoReportSource>().simplePageBreaker(PAGE_BREAK_KEYS)).
                create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void process(ZenjitsuPrintEntity entity) {

        List<ShisetsuKofuIchiranhyoParam> paramList = paramBuilder.getParam(entity.get選挙Entity(), entity.get投票状況Entity(), entity.get施設Entity());

        if (null != paramList && !paramList.isEmpty()) {
            for (ShisetsuKofuIchiranhyoParam param : paramList) {

                ShisetsuKofuIchiranhyoReport report = new ShisetsuKofuIchiranhyoReport(param);
                report.writeBy(reportSourceWriter);
            }
        }

    }

    @Override
    protected void afterExecute() {

        List<ShisetsuKofuIchiranhyoParam> paramList = paramBuilder.getLastParam();

        if (null != paramList && !paramList.isEmpty()) {
            for (ShisetsuKofuIchiranhyoParam param : paramList) {

                ShisetsuKofuIchiranhyoReport report = new ShisetsuKofuIchiranhyoReport(param);
                report.writeBy(reportSourceWriter);
            }
        }

        pageCount.setValue(batchReportWriter.getPageCount());
    }
}
