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
import jp.co.ndensan.reams.af.afa.business.report.AFAPRA104.YukenshasuListParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRA104.YukenshasuListReport;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA103.TorokushasuListSource;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA104.YukenshasuShirabeSource;
import jp.co.ndensan.reams.af.afa.entity.xml.teijitouroku.AFAPRA104Entity;
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
 * 有権者数調べ帳票出力のクラスです。
 *
 * @reamsid_L AF-0010-020 wangm
 */
public class YukenshasuListReportProcess extends BatchProcessBase<AFAPRA104Entity> {

    @BatchWriter
    private BatchReportWriter<YukenshasuShirabeSource> batchReportWriter;
    private ReportSourceWriter<YukenshasuShirabeSource> reportSourceWriter;

    /**
     * ページbreakキーです。
     */
    public static final RString PAGE_COUNT;

    static {
        PAGE_COUNT = new RString("pageCount");

    }
    OutputParameter<Integer> pageCount = new OutputParameter<>();
    private YukenshasuListParam.YukenshasuListParamBuilder builder;
    private static final List<RString> PAGE_BREAK_KEYS
            = Collections.unmodifiableList(Arrays.asList(new RString(YukenshasuShirabeSource.ReportSourceFields.title.name())));

    @Override
    protected void initialize() {
        TeijiCommonJohoItem 帳票共通ヘッダー = new ReportHeadEditor().create帳票共通ヘッダー();
        builder = new YukenshasuListParam.YukenshasuListParamBuilder(帳票共通ヘッダー);
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdKeys.有権者数調べ.value())
                .addBreak(new BreakerCatalog<TorokushasuListSource>().simplePageBreaker(PAGE_BREAK_KEYS)).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(new RString(
                "jp.co.ndensan.reams.af.afa.persistence.db.mapper.teijitouroku.IAFAPRA104tempYukenshasuMapper.selectDataForYukenshasuList"));
    }

    @Override
    protected void process(AFAPRA104Entity entity) {
        List<YukenshasuListParam> params = builder.addData(entity);
        for (YukenshasuListParam param : params) {
            YukenshasuListReport report = new YukenshasuListReport(param);
            report.writeBy(reportSourceWriter);
        }
    }

    @Override
    protected void afterExecute() {
        List<YukenshasuListParam> params = builder.lastSum();
        for (YukenshasuListParam param : params) {
            YukenshasuListReport report = new YukenshasuListReport(param);
            report.writeBy(reportSourceWriter);
        }
        pageCount.setValue(batchReportWriter.getPageCount());
    }

}
