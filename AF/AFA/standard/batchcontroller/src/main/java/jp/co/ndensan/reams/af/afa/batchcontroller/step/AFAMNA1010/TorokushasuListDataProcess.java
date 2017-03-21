/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.batchcontroller.common.ReportHeadEditor;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRA103.TorokushasuListParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRA103.TorokushasuListReport;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.processprm.teijitouroku.AFABTA101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA103.TorokushasuListSource;
import jp.co.ndensan.reams.af.afa.entity.xml.teijitouroku.AFAPRA103Entity;
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
 * @reamsid_L AF-0010-020 wangm
 */
public class TorokushasuListDataProcess extends BatchProcessBase<AFAPRA103Entity> {

    private AFABTA101SelectProcessParameter parameter;
    private RString 帳票出力順;
    private TorokushasuListParam.TorokushasuListParamBuilder paramBuilder;
    @BatchWriter
    private BatchReportWriter<TorokushasuListSource> batchReportWriter;
    private ReportSourceWriter<TorokushasuListSource> reportSourceWriter;

    /**
     * ページ数Parameterです。
     */
    public static final RString PAGE_COUNT;

    static {
        PAGE_COUNT = new RString("pageCount");
    }
    OutputParameter<Integer> pageCount = new OutputParameter<>();

    private static final RString 帳票タイトル = new RString("登録者数リスト");
    private static final List<RString> PAGE_BREAK_KEYS
            = Collections.unmodifiableList(Arrays.asList(new RString(TorokushasuListSource.ReportSourceFields.senkyoNo.name()),
                            new RString(TorokushasuListSource.ReportSourceFields.sumType.name())));

    @Override
    protected void initialize() {

        IChohyoShutsuryokujunFinder chohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
        List<IOutputOrder> 出力順List = chohyoShutsuryokujunFinder.get出力順(SubGyomuCode.AFA選挙本体,
                new ReportId(ReportIdKeys.登録者数リスト.value()));
        帳票出力順 = 出力順List.isEmpty() ? RString.EMPTY : 出力順List.get(0).getFormated出力順項目();

        paramBuilder = new TorokushasuListParam.TorokushasuListParamBuilder(new ReportHeadEditor().create帳票共通ヘッダー(),
                帳票出力順,
                帳票タイトル,
                parameter.getSenkyoShurui());
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdKeys.登録者数リスト.value())
                .addBreak(new BreakerCatalog<TorokushasuListSource>().simplePageBreaker(PAGE_BREAK_KEYS)).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(new RString(
                "jp.co.ndensan.reams.af.afa.persistence.db.mapper.teijitouroku.IAFAPRA103tempTorokushasuListMapper.selectDataForTorokushasuList"));
    }

    @Override
    protected void process(AFAPRA103Entity entity) {
        List<TorokushasuListParam> params = paramBuilder.addData(entity);

        for (TorokushasuListParam param : params) {

            TorokushasuListReport report = new TorokushasuListReport(param);
            report.writeBy(reportSourceWriter);
        }

    }

    @Override
    protected void afterExecute() {
        List<TorokushasuListParam> params = paramBuilder.lastSum();

        for (TorokushasuListParam param : params) {

            TorokushasuListReport report = new TorokushasuListReport(param);
            report.writeBy(reportSourceWriter);
        }
        pageCount.setValue(batchReportWriter.getPageCount());
    }

}
