/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010;

import jp.co.ndensan.reams.af.afa.batchcontroller.common.ReportHeadEditor;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRA102.SakuinboParam;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRA102.SakuinboReport;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.teijitouroku.BatchMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.teijitouroku.AFABTA101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101.SakuinboEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA102.SakuinboSource;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
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
 * 選挙人名簿索引簿帳票出力(投票区別50音順)のクラスです。
 *
 * @reamsid_L AF-0010-036 qiuxy
 */
public class SakuinboReportTouhyo50Process extends BatchKeyBreakBase<SakuinboEntity> {

    private AFABTA101SelectProcessParameter parameter;
    private BatchMybatisParameter mybatisparameter;
    @BatchWriter
    private BatchReportWriter<SakuinboSource> batchReportWriter;
    private ReportSourceWriter<SakuinboSource> reportSourceWriter;
    private SakuinboParam.SakuinboParamBuilder builder;
    private TeijiCommonJohoItem 帳票共通ヘッダー;

    private static final RString 帳票タイトル = new RString("投票区別５０音選挙人索引簿");

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
        帳票共通ヘッダー = new ReportHeadEditor().create帳票共通ヘッダー();
        帳票共通ヘッダー.set帳票タイトル(帳票タイトル);
        pageCount = new OutputParameter<>();
        builder = new SakuinboParam.SakuinboParamBuilder();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(new RString(
                "jp.co.ndensan.reams.af.afa.persistence.db.mapper.teijitouroku.IAFABTA101Mapper.selectSakuinboTouhyo50List"),
                mybatisparameter);
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdKeys.選挙人名簿索引簿_投票区別50音順.value(), SubGyomuCode.AFA選挙本体).
                addBreak(new BreakerCatalog<SakuinboSource>().simplePageBreaker(new RString("headKana"), new RString("headTohyokuCode"))).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void usualProcess(SakuinboEntity entity) {

        SakuinboParam param = builder.addData(entity);

        if (param != null) {
            SakuinboReport report = new SakuinboReport(param, 帳票共通ヘッダー);
            report.writeBy(reportSourceWriter);
        }
    }

    @Override
    protected void keyBreakProcess(SakuinboEntity current) {
    }

    @Override
    protected void afterExecute() {
        if (null == getBefore()) {
            pageCount.setValue(0);
        } else {
            pageCount.setValue(batchReportWriter.getPageCount());
        }
    }
}
