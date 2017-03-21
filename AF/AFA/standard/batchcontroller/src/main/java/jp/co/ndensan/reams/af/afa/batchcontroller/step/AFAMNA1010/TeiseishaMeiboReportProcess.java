/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.batchcontroller.common.ReportHeadEditor;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRA108.TeiseishaMeiboParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRA108.TeiseishaMeiboReport;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.teijitouroku.BatchMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.teijitouroku.AFABTA101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101.TeiseishaMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA108.TeiseishaMeiboSource;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.idojiyu.JukiIdoJiyu;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 訂正者名簿のクラスです。
 *
 */
public class TeiseishaMeiboReportProcess extends BatchProcessBase<TeiseishaMeiboEntity> {

    private AFABTA101SelectProcessParameter parameter;
    private BatchMybatisParameter mybatisparameter;

    private static final RString SORT_BEFORE = new RString("\"idoJiyuCode_tenKyo\" desc,\"before_tohyokuCode\" asc ");

    @BatchWriter
    private BatchReportWriter<TeiseishaMeiboSource> batchReportWriter;
    private ReportSourceWriter<TeiseishaMeiboSource> reportSourceWriter;

    private TeiseishaMeiboParam.TeiseishaMeiboParamBuilder builder;

    private static final List<RString> PAGE_BREAK_KEYS
            = Collections.unmodifiableList(Arrays.asList(new RString(TeiseishaMeiboSource.ReportSourceFields.subTitle.name())));

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
        pageCount = new OutputParameter<>();

        mybatisparameter = parameter.toBatchMybatisParameter();
        TeijiCommonJohoItem 帳票共通ヘッダー = new ReportHeadEditor().create帳票共通ヘッダー();
        builder = new TeiseishaMeiboParam.TeiseishaMeiboParamBuilder(帳票共通ヘッダー);
        mybatisparameter.addSortBefore(SORT_BEFORE);
        mybatisparameter.setIdoJiyuCodeList(get訂正者事由());

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(new RString(
                "jp.co.ndensan.reams.af.afa.persistence.db.mapper.teijitouroku.IAFAPRA108Mapper.selectTeiseishaList"),
                mybatisparameter);
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdKeys.訂正者名簿.value(), SubGyomuCode.AFA選挙本体).
                addBreak(new BreakerCatalog<TeiseishaMeiboSource>().simplePageBreaker(PAGE_BREAK_KEYS)).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void process(TeiseishaMeiboEntity entity) {

        List<TeiseishaMeiboParam> params = builder.addData(entity);

        for (TeiseishaMeiboParam param : params) {

            TeiseishaMeiboReport report = new TeiseishaMeiboReport(param);
            report.writeBy(reportSourceWriter);
        }
    }

    @Override
    protected void afterExecute() {
        TeiseishaMeiboParam param = builder.lastSum();

        if (param != null) {

            TeiseishaMeiboReport report = new TeiseishaMeiboReport(param);
            report.writeBy(reportSourceWriter);
        }
        pageCount.setValue(batchReportWriter.getPageCount());
    }

    private List<RString> get訂正者事由() {
        List<RString> list = new ArrayList<>();
        list.add(JukiIdoJiyu.転居.get異動事由コード());
        list.add(JukiIdoJiyu.世帯主変更.get異動事由コード());
        list.add(JukiIdoJiyu.世帯分離.get異動事由コード());
        list.add(JukiIdoJiyu.世帯合併.get異動事由コード());
        list.add(JukiIdoJiyu.世帯構成変更.get異動事由コード());
        list.add(JukiIdoJiyu.職権修正.get異動事由コード());
        list.add(JukiIdoJiyu.職権回復.get異動事由コード());
        list.add(JukiIdoJiyu.住民票改製.get異動事由コード());
        list.add(JukiIdoJiyu.表示順変更.get異動事由コード());
        return list;
    }

}
