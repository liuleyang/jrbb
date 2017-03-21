/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010;

import jp.co.ndensan.reams.af.afa.batchcontroller.common.ReportHeadEditor;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRA105.ShinkiTorokushaMeiboParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRA105.ShinkiTorokushaMeiboReport;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.CommonConstant;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.NullHandler;
import jp.co.ndensan.reams.af.afa.business.util.shikakuhantei.ShikakuHantei;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.JiyuCode;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.teijitouroku.BatchMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.teijitouroku.AFABTA101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101.TorokushaMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA105.ShinkiTorokushaMeiboSource;
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
 * 抹消者名簿のクラスです。
 *
 * @reamsid_L AF-0010-039 qiuxy
 */
public class MasshoshaMeiboReportProcess extends BatchKeyBreakBase<TorokushaMeiboEntity> {

    private AFABTA101SelectProcessParameter parameter;
    private BatchMybatisParameter mybatisparameter;

    @BatchWriter
    private BatchReportWriter<ShinkiTorokushaMeiboSource> batchReportWriter;
    private ReportSourceWriter<ShinkiTorokushaMeiboSource> reportSourceWriter;
    private TeijiCommonJohoItem 帳票共通ヘッダー;
    private ShinkiTorokushaMeiboParam.ShinkiTorokushaMeiboParamBuilder builder;

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
        builder = new ShinkiTorokushaMeiboParam.ShinkiTorokushaMeiboParamBuilder(ReportIdKeys.抹消者名簿.value());
        帳票共通ヘッダー = new ReportHeadEditor().create帳票共通ヘッダー();
        mybatisparameter = parameter.toBatchMybatisParameter();
        pageCount = new OutputParameter<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(new RString(
                "jp.co.ndensan.reams.af.afa.persistence.db.mapper.teijitouroku.IAFABTA101Mapper.selectMasshoshaMeiboList"),
                mybatisparameter);
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdKeys.抹消者名簿.value())
                .addBreak(new BreakerCatalog<ShinkiTorokushaMeiboSource>().simplePageBreaker(CommonConstant.PAGE_BREAK_KEYS))
                .create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void usualProcess(TorokushaMeiboEntity current) {
        if (is抹消者(current) && isRight抹消事由(current)) {
            if (getBefore() != null
                    && !getBefore().getSenkyoninMeiboEntity().getTohyokuCode().equals(current.getSenkyoninMeiboEntity().getTohyokuCode())
                    && !hasBreak(getBefore(), current)) {
                ShinkiTorokushaMeiboReport 空白行 = new ShinkiTorokushaMeiboReport(get空白行(), 帳票共通ヘッダー);
                空白行.writeBy(reportSourceWriter);
            }
            ShinkiTorokushaMeiboParam param = builder.addData(current, get抹消事由コード(current), false);
            ShinkiTorokushaMeiboReport report = new ShinkiTorokushaMeiboReport(param, 帳票共通ヘッダー);
            report.writeBy(reportSourceWriter);
        }
    }

    private Boolean isRight抹消事由(TorokushaMeiboEntity entity) {
        RString 事由コード = NullHandler.getNullToRString(entity.getSenkyoShikakuEntity().getMasshoJiyuCode());
        return 事由コード.equals(JiyuCode.死亡.getKey()) || 事由コード.equals(JiyuCode.国籍喪失.getKey())
                || 事由コード.equals(JiyuCode.転出4カ月.getKey()) || 事由コード.equals(JiyuCode.誤載.getKey())
                || 事由コード.equals(JiyuCode.職権消除.getKey()) || 事由コード.equals(JiyuCode.居住要件.getKey())
                || 事由コード.equals(JiyuCode.その他_抹消.getKey());
    }

    @Override
    protected void keyBreakProcess(TorokushaMeiboEntity entity) {
        if (hasBreak(getBefore(), entity) && is抹消者(getBefore()) && isRight抹消事由(getBefore())) {
            ShinkiTorokushaMeiboReport 空白行 = new ShinkiTorokushaMeiboReport(get空白行(), 帳票共通ヘッダー);
            空白行.writeBy(reportSourceWriter);

            ShinkiTorokushaMeiboParam 集計行 = builder.addData(getBefore(), get抹消事由コード(getBefore()), true);
            ShinkiTorokushaMeiboReport 集計行Out = new ShinkiTorokushaMeiboReport(集計行, 帳票共通ヘッダー);
            集計行Out.writeBy(reportSourceWriter);
        }
    }

    private boolean hasBreak(TorokushaMeiboEntity before, TorokushaMeiboEntity current) {
        return !NullHandler.getNullToRString(before.getSenkyoShikakuEntity().getMasshoJiyuCode())
                .equals(NullHandler.getNullToRString(current.getSenkyoShikakuEntity().getMasshoJiyuCode()));
    }

    @Override
    protected void afterExecute() {
        if (getBefore() != null && is抹消者(getBefore()) && isRight抹消事由(getBefore())) {
            ShinkiTorokushaMeiboReport 空白行 = new ShinkiTorokushaMeiboReport(get空白行(), 帳票共通ヘッダー);
            空白行.writeBy(reportSourceWriter);

            ShinkiTorokushaMeiboParam param = builder.addData(getBefore(), get抹消事由コード(getBefore()), true);
            ShinkiTorokushaMeiboReport report = new ShinkiTorokushaMeiboReport(param, 帳票共通ヘッダー);
            report.writeBy(reportSourceWriter);
        }
        pageCount.setValue(batchReportWriter.getPageCount());
    }

    private ShinkiTorokushaMeiboParam get空白行() {
        return new ShinkiTorokushaMeiboParam(getBefore(), ReportIdKeys.抹消者名簿.value(), get抹消事由コード(getBefore()),
                RString.EMPTY, Boolean.TRUE);
    }

    private Boolean is抹消者(TorokushaMeiboEntity entity) {
        return new ShikakuHantei().is抹消者(entity.getShikibetsuTaishoEntity(), parameter.getTenshutuKigenbi(), parameter.getNenreiKigenbi());
    }

    private RString get抹消事由コード(TorokushaMeiboEntity entity) {
        return NullHandler.getNullToRString(entity.getSenkyoShikakuEntity().getMasshoJiyuCode());
    }
}
