/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010;

import java.util.List;
import jp.co.ndensan.reams.af.afa.batchcontroller.common.ReportHeadEditor;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRA109.TorokuTeishishaMeiboParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRA109.TorokuTeishishaMeiboReport;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.teijitouroku.BatchMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.teijitouroku.AFABTA101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101.EikyuSenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA109.TorokuTeishishaMeiboSource;
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
 * 登録停止者名簿のクラスです。
 *
 */
public class TorokuTeishishaMeiboProcess extends BatchProcessBase<EikyuSenkyoninMeiboEntity> {

    private AFABTA101SelectProcessParameter parameter;
    private BatchMybatisParameter mybatisparameter;

    @BatchWriter
    private BatchReportWriter<TorokuTeishishaMeiboSource> batchReportWriter;
    private ReportSourceWriter<TorokuTeishishaMeiboSource> reportSourceWriter;

    private TorokuTeishishaMeiboParam.TorokuTeishishaMeiboParamBuilder paramBuilder;

    /**
     * ページ数Parameterです。
     */
    public static final RString PAGE_COUNT;

    static {
        PAGE_COUNT = new RString("pageCount");
    }
    OutputParameter<Integer> pageCount;

    @Override
    protected void initialize() {
        mybatisparameter = parameter.toBatchMybatisParameter();
        pageCount = new OutputParameter<>();

        TeijiCommonJohoItem 帳票共通ヘッダー = new ReportHeadEditor().create帳票共通ヘッダー();
        paramBuilder = new TorokuTeishishaMeiboParam.TorokuTeishishaMeiboParamBuilder(帳票共通ヘッダー, parameter.getKijunbi());

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(new RString(
                "jp.co.ndensan.reams.af.afa.persistence.db.mapper.teijitouroku.IAFABTA101Mapper.selectTorokuTeishishaMeiboList"),
                mybatisparameter);
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdKeys.登録停止者名簿.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void process(EikyuSenkyoninMeiboEntity entity) {
        List<TorokuTeishishaMeiboParam> params = paramBuilder.addData(entity);

        for (TorokuTeishishaMeiboParam param : params) {

            TorokuTeishishaMeiboReport report = new TorokuTeishishaMeiboReport(param);
            report.writeBy(reportSourceWriter);
        }

    }

    @Override
    protected void afterExecute() {
        List<TorokuTeishishaMeiboParam> params = paramBuilder.lastSum();

        for (TorokuTeishishaMeiboParam param : params) {

            TorokuTeishishaMeiboReport report = new TorokuTeishishaMeiboReport(param);
            report.writeBy(reportSourceWriter);
        }
        pageCount.setValue(batchReportWriter.getPageCount());
    }

}
