/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5040;

import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.ZenjitsuCommonJohoItem;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE512.NendaibetsuJokyoShirabeParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE512.NendaibetsuJokyoShirabeReport;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.zenjitsuprint.ZenjitsuPrintMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.zenjitsuprint.AFABTE504SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.zenjitsuprint.ZenjitsuPrintEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE512.NendaibetsuJokyoShirabeSource;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 年代別投票状況調べ帳票出力のクラスです。
 *
 * @reamsid_L AF-0280-029 lit
 */
public class NendaibetsuJokyoShirabeReportProcess extends BatchProcessBase<ZenjitsuPrintEntity> {

    private static final RString MAPPER_ID
            = new RString("jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.zenjitsuprint."
                    + "IAFABTE504Mapper.selectZenjitsuPrintList");

    private AFABTE504SelectProcessParameter parameter;
    private ZenjitsuPrintMybatisParameter mybatisparameter;
    private NendaibetsuJokyoShirabeParam.NendaibetsuJokyoShirabeParamBuilder paramBuilder;

    @BatchWriter
    private BatchReportWriter<NendaibetsuJokyoShirabeSource> batchReportWriter;
    private ReportSourceWriter<NendaibetsuJokyoShirabeSource> reportSourceWriter;

    OutputParameter<Integer> pageCount = new OutputParameter<>();

    @Override
    protected void initialize() {
        mybatisparameter = parameter.toZenjitsuPrintMybatisParameter();
    }

    @Override
    protected void beforeExecute() {

        ZenjitsuCommonJohoItem 帳票共通ヘッダー = new ZenjitsuReportHeaderEditor().create帳票共通ヘッダー();
        paramBuilder = new NendaibetsuJokyoShirabeParam.NendaibetsuJokyoShirabeParamBuilder(帳票共通ヘッダー);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPER_ID, mybatisparameter);
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdKeys.年代別投票状況調べ.value()).
                create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void process(ZenjitsuPrintEntity entity) {
        List<NendaibetsuJokyoShirabeParam> paramList
                = paramBuilder.add(entity.get抄本Entity(), entity.get選挙Entity(), entity.get選挙人名簿Entity(), entity.get選挙資格Entity(),
                        entity.get投票状況Entity(), entity.get宛名情報Entity());

        if (!paramList.isEmpty()) {
            for (NendaibetsuJokyoShirabeParam param : paramList) {
                NendaibetsuJokyoShirabeReport report = new NendaibetsuJokyoShirabeReport(param);
                report.writeBy(reportSourceWriter);
            }
        }

    }

    @Override
    protected void afterExecute() {
        List<NendaibetsuJokyoShirabeParam> paramList = paramBuilder.getLastParam();
        if (!paramList.isEmpty()) {
            for (NendaibetsuJokyoShirabeParam param : paramList) {
                NendaibetsuJokyoShirabeReport report = new NendaibetsuJokyoShirabeReport(param);
                report.writeBy(reportSourceWriter);
            }
        }

        pageCount.setValue(batchReportWriter.getPageCount());
    }

}
