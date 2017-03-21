/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.batchcontroller.common.ReportHeadEditor;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRG103.TorokushasuListReport;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRG103.TorokushasuListParameter;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.processprm.kokumintohyoji.AFABTG101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRG103.TorokushasuListKokuminSource;
import jp.co.ndensan.reams.af.afa.entity.xml.kokumintohyojitoroku.AFAPRG103Entity;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 登録者数リスト帳票出力のクラスです。
 *
 * @reamsid_L AF-0360-054 qiuxy
 */
public class TorokushasuListReportProcess extends BatchProcessBase<AFAPRG103Entity> {

    private AFABTG101SelectProcessParameter parameter;
    private RString 帳票出力順;
    private TorokushasuListParameter.TorokushasuListParameterBuilder paramBuilder;
    @BatchWriter
    private BatchReportWriter<TorokushasuListKokuminSource> batchReportWriter;
    private ReportSourceWriter<TorokushasuListKokuminSource> reportSourceWriter;

    /**
     * ページ数Parameterです。
     */
    public static final RString PAGE_COUNT;

    static {
        PAGE_COUNT = new RString("pageCount");
    }
    OutputParameter<Integer> pageCount = new OutputParameter<>();

    private static final RString 帳票タイトル = new RString("投票人名簿登録者数リスト");
    private static final List<RString> PAGE_BREAK_KEYS
            = Collections.unmodifiableList(Arrays.asList(new RString(TorokushasuListKokuminSource.ReportSourceFields.senkyoNo.name()),
                            new RString(TorokushasuListKokuminSource.ReportSourceFields.sumType.name())));

    @Override
    protected void initialize() {

        IChohyoShutsuryokujunFinder chohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
        List<IOutputOrder> 出力順List = chohyoShutsuryokujunFinder.get出力順(SubGyomuCode.AFA選挙本体,
                new ReportId(ReportIdKeys.AFAPRG103_投票人名簿登録者数リスト.value()));
        帳票出力順 = 出力順List.isEmpty() ? RString.EMPTY : 出力順List.get(0).getFormated出力順項目();

        paramBuilder = new TorokushasuListParameter.TorokushasuListParameterBuilder(new ReportHeadEditor().create帳票共通ヘッダー(),
                帳票出力順,
                帳票タイトル,
                parameter.get選挙種類());
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdKeys.AFAPRG103_投票人名簿登録者数リスト.value())
                .addBreak(new BreakerCatalog<TorokushasuListKokuminSource>().simplePageBreaker(PAGE_BREAK_KEYS)).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(new RString(
                "jp.co.ndensan.reams.af.afa.persistence.db.mapper.kokumintohyoji.IAFAPRG103tempTorokushasuListMapper.selectDataForTorokushasuList"));
    }

    @Override
    protected void process(AFAPRG103Entity entity) {
        List<TorokushasuListParameter> params = paramBuilder.addData(entity);

        for (TorokushasuListParameter param : params) {

            TorokushasuListReport report = new TorokushasuListReport(param);
            report.writeBy(reportSourceWriter);
        }

    }

    @Override
    protected void afterExecute() {
        List<TorokushasuListParameter> params = paramBuilder.lastSum();

        for (TorokushasuListParameter param : params) {

            TorokushasuListReport report = new TorokushasuListReport(param);
            report.writeBy(reportSourceWriter);
        }
        pageCount.setValue(batchReportWriter.getPageCount());
    }
}
