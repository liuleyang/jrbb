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
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.JiyuCode;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuKubun;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.teijitouroku.BatchMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.teijitouroku.AFABTA101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101.TorokushaMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA105.ShinkiTorokushaMeiboSource;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
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
 * 表示者名簿のクラスです。
 *
 * @reamsid_L AF-0010-039 qiuxy
 */
public class HyojishaMeiboReportProcess extends BatchKeyBreakBase<TorokushaMeiboEntity> {

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
        帳票共通ヘッダー = new ReportHeadEditor().create帳票共通ヘッダー();
        builder = new ShinkiTorokushaMeiboParam.ShinkiTorokushaMeiboParamBuilder(ReportIdKeys.表示者名簿.value());
        mybatisparameter = parameter.toBatchMybatisParameter();
        pageCount = new OutputParameter<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(new RString(
                "jp.co.ndensan.reams.af.afa.persistence.db.mapper.teijitouroku.IAFABTA101Mapper.selectHyojishaMeiboList"),
                mybatisparameter);
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdKeys.表示者名簿.value())
                .addBreak(new BreakerCatalog<ShinkiTorokushaMeiboSource>().simplePageBreaker(CommonConstant.PAGE_BREAK_KEYS))
                .create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void usualProcess(TorokushaMeiboEntity entity) {
        if (!is表示者(entity)) {
            return;
        }

        if (getBefore() != null
                && !getBefore().getSenkyoninMeiboEntity().getTohyokuCode().equals(entity.getSenkyoninMeiboEntity().getTohyokuCode())
                && !hasBreak(getBefore(), entity)) {
            ShinkiTorokushaMeiboReport 空白行 = new ShinkiTorokushaMeiboReport(get空白行(), 帳票共通ヘッダー);
            空白行.writeBy(reportSourceWriter);
        }
        ShinkiTorokushaMeiboParam param = builder.addData(entity, get事由コード(entity), false);
        ShinkiTorokushaMeiboReport report = new ShinkiTorokushaMeiboReport(param, 帳票共通ヘッダー);
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void keyBreakProcess(TorokushaMeiboEntity entity) {
        if (hasBreak(getBefore(), entity)) {
            ShinkiTorokushaMeiboReport 空白行 = new ShinkiTorokushaMeiboReport(get空白行(), 帳票共通ヘッダー);
            空白行.writeBy(reportSourceWriter);

            ShinkiTorokushaMeiboParam param = builder.addData(getBefore(), get事由コード(getBefore()), true);
            ShinkiTorokushaMeiboReport report = new ShinkiTorokushaMeiboReport(param, 帳票共通ヘッダー);
            report.writeBy(reportSourceWriter);
        }
    }

    private Boolean hasBreak(TorokushaMeiboEntity before, TorokushaMeiboEntity current) {
        return !get事由コード(before).equals(get事由コード(current));
    }

    @Override
    protected void afterExecute() {
        if (getBefore() != null && is表示者(getBefore())) {
            ShinkiTorokushaMeiboReport 空白行 = new ShinkiTorokushaMeiboReport(get空白行(), 帳票共通ヘッダー);
            空白行.writeBy(reportSourceWriter);

            ShinkiTorokushaMeiboParam param = builder.addData(getBefore(), get事由コード(getBefore()), true);
            ShinkiTorokushaMeiboReport report = new ShinkiTorokushaMeiboReport(param, 帳票共通ヘッダー);
            report.writeBy(reportSourceWriter);
        }
        pageCount.setValue(batchReportWriter.getPageCount());
    }

    private ShinkiTorokushaMeiboParam get空白行() {
        return new ShinkiTorokushaMeiboParam(getBefore(), ReportIdKeys.表示者名簿.value(), get事由コード(getBefore()),
                RString.EMPTY, Boolean.TRUE);
    }

    private Boolean is表示者(TorokushaMeiboEntity entity) {
        return !RString.isNullOrEmpty(get事由コード(entity));
    }

    private RString get事由コード(TorokushaMeiboEntity entity) {
        if (NullHandler.getNullToRString(entity.getShikibetsuTaishoEntity().getJuminJotaiCode()).equals(JuminJotai.住民.コード())
                && NullHandler.getNullToRString(entity.getSenkyoShikakuEntity().getShikakuKubun()).equals(SennkyoSikakuKubun.表示者.value())
                && NullHandler.getNullToRString(entity.getSenkyoShikakuEntity().getHyojiJiyuCode()).equals(JiyuCode.転出.getKey())) {
            return JiyuCode.再転入_表示.getKey();
        }
        if (NullHandler.getNullToRString(entity.getShikibetsuTaishoEntity().getJuminJotaiCode()).equals(JuminJotai.転出者.コード())
                && NullHandler.getNullToRString(entity.getSenkyoShikakuEntity().getShikakuKubun()).equals(SennkyoSikakuKubun.表示者.value())
                && NullHandler.getNullToRString(entity.getSenkyoShikakuEntity().getHyojiJiyuCode()).equals(JiyuCode.転出.getKey())) {
            return JiyuCode.転出者.getKey();
        }
        if (NullHandler.getNullToRString(entity.getSenkyoShikakuEntity().getShikakuKubun()).equals(SennkyoSikakuKubun.表示者.value())
                && (NullHandler.getNullToRString(entity.getSenkyoShikakuEntity().getHyojiJiyuCode()).
                equals(JiyuCode.公職選挙法第11条1項2号該当.getKey())
                || NullHandler.getNullToRString(entity.getSenkyoShikakuEntity().getHyojiJiyuCode())
                .equals(JiyuCode.公職選挙法第11条1項3号該当.getKey())
                || NullHandler.getNullToRString(entity.getSenkyoShikakuEntity().getHyojiJiyuCode())
                .equals(JiyuCode.公職選挙法第11条1項4号該当.getKey())
                || NullHandler.getNullToRString(entity.getSenkyoShikakuEntity().getHyojiJiyuCode())
                .equals(JiyuCode.公職選挙法第11条1項5号該当.getKey())
                || NullHandler.getNullToRString(entity.getSenkyoShikakuEntity().getHyojiJiyuCode())
                .equals(JiyuCode.公職選挙法第11条2項該当.getKey()))) {
            return JiyuCode.公民権停止者.getKey();
        }
        return RString.EMPTY;
    }
}
