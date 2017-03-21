/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.batchcontroller.common.ReportHeadEditor;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRA105.ShinkiTorokushaMeiboParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRA105.ShinkiTorokushaMeiboReport;
import jp.co.ndensan.reams.af.afa.business.util.shikakuhantei.ShikakuHantei;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.teijitouroku.BatchMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.teijitouroku.AFABTA101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101.TorokushaMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA105.ShinkiTorokushaMeiboSource;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 再転入者名簿のクラスです。
 *
 * @reamsid_L AF-0010-039 qiuxy
 */
public class SaiTennyushaMeiboReportProcess extends BatchKeyBreakBase<TorokushaMeiboEntity> {

    private AFABTA101SelectProcessParameter parameter;
    private BatchMybatisParameter mybatisparameter;

    @BatchWriter
    private BatchReportWriter<ShinkiTorokushaMeiboSource> batchReportWriter;
    private ReportSourceWriter<ShinkiTorokushaMeiboSource> reportSourceWriter;
    private TeijiCommonJohoItem 帳票共通ヘッダー;
    private ShinkiTorokushaMeiboParam.ShinkiTorokushaMeiboParamBuilder builder;

    private TorokushaMeiboEntity lastEntity;
    private List<UaFt200FindShikibetsuTaishoEntity> uaft200List;
    private RString lastTohyokuCode;

    private static final RString SORT_AFTER = new RString("\"ShikibetsuTaisho\".\"shikibetsuCode\" asc");

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
        builder = new ShinkiTorokushaMeiboParam.ShinkiTorokushaMeiboParamBuilder(ReportIdKeys.再転入者名簿.value());
        mybatisparameter = parameter.toBatchMybatisParameter();
        mybatisparameter.addSortAfter(SORT_AFTER);
        pageCount = new OutputParameter<>();
        lastEntity = null;
        uaft200List = null;
        lastTohyokuCode = null;

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(new RString(
                "jp.co.ndensan.reams.af.afa.persistence.db.mapper.teijitouroku.IAFABTA101Mapper.selectSaiTennyushaMeiboList"),
                mybatisparameter);
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdKeys.再転入者名簿.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void usualProcess(TorokushaMeiboEntity current) {

        List<ShinkiTorokushaMeiboParam> params = getNewRecord(current);
        for (ShinkiTorokushaMeiboParam param : params) {
            ShinkiTorokushaMeiboReport report = new ShinkiTorokushaMeiboReport(param, 帳票共通ヘッダー);
            report.writeBy(reportSourceWriter);
        }
    }

    private List<ShinkiTorokushaMeiboParam> getNewRecord(TorokushaMeiboEntity current) {

        List<ShinkiTorokushaMeiboParam> rsltList = new ArrayList<>();
        if (current != null && lastEntity == null) {
            lastEntity = current;
            uaft200List = new ArrayList<>();
            uaft200List.add(current.getShikibetsuTaishoEntity());
        } else if (current != null && lastEntity.is同じレコード(current)) {
            uaft200List.add(current.getShikibetsuTaishoEntityForAll());
        } else {
            if (is再転入者(uaft200List)) {
                //CHECKSTYLE IGNORE NestedIfDepth FOR NEXT 1 LINES
                if (lastTohyokuCode != null && !lastTohyokuCode.equals(lastEntity.getSenkyoninMeiboEntity().getTohyokuCode())) {
                    rsltList.add(get空白行());
                }
                lastTohyokuCode = lastEntity.getSenkyoninMeiboEntity().getTohyokuCode();
                rsltList.add(builder.addData(lastEntity, RString.EMPTY, false));
            }

            if (current != null) {
                lastEntity = current;
                uaft200List = new ArrayList<>();
                uaft200List.add(current.getShikibetsuTaishoEntityForAll());
            }
        }
        return rsltList;
    }

    @Override
    protected void keyBreakProcess(TorokushaMeiboEntity entity) {

    }

    @Override
    protected void afterExecute() {
        List<ShinkiTorokushaMeiboParam> params = getNewRecord(null);
        for (ShinkiTorokushaMeiboParam param : params) {
            ShinkiTorokushaMeiboReport report = new ShinkiTorokushaMeiboReport(param, 帳票共通ヘッダー);
            report.writeBy(reportSourceWriter);
        }
        if (!reportSourceWriter.pageCount().isZero()) {

            ShinkiTorokushaMeiboReport 空白行 = new ShinkiTorokushaMeiboReport(get空白行(), 帳票共通ヘッダー);
            空白行.writeBy(reportSourceWriter);

            ShinkiTorokushaMeiboParam param = builder.addData(getBefore(), RString.EMPTY, true);
            ShinkiTorokushaMeiboReport report = new ShinkiTorokushaMeiboReport(param, 帳票共通ヘッダー);
            report.writeBy(reportSourceWriter);
        }
        pageCount.setValue(batchReportWriter.getPageCount());
    }

    private boolean is再転入者(List<UaFt200FindShikibetsuTaishoEntity> uaft200List) {

        if (null != uaft200List) {
            return new ShikakuHantei().is再転入者(uaft200List, parameter.getTenshutuKigenbi(),
                    parameter.getTennyuKigenbi(), parameter.getNenreiKigenbi());
        }
        return false;
    }

    private ShinkiTorokushaMeiboParam get空白行() {
        return new ShinkiTorokushaMeiboParam(getBefore(), ReportIdKeys.再転入者名簿.value(), RString.EMPTY,
                RString.EMPTY, Boolean.TRUE);
    }

}
