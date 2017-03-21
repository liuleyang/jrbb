/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5030;

import java.util.Arrays;
import java.util.Collections;
import jp.co.ndensan.reams.af.afa.batchcontroller.common.ReportHeadEditor;
import jp.co.ndensan.reams.af.afa.business.core.ShukeiSeirihyoParam;
import jp.co.ndensan.reams.af.afa.business.core.nippo.ShukeiSeirihyoBreakEditor;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE505.ShukeiSeirihyoReport;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.nippo.NippoMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.nippo.AFABTE503SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.nippo.NippoPSMPrintEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE504.TohyoJiyuChoshoSource;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE505.ShukeiSeirihyoReportSource;
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
 * 受理日だけの集計帳票出力のクラスです。
 *
 * @reamsid_L AF-0270-020 xul
 */
public class ShukeiSeirihyoReportProcess extends BatchKeyBreakBase<NippoPSMPrintEntity> {

    private static final RString MAPPER_ID
            = new RString("jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.nippo."
                    + "INippoMapper.select投票集計整理");

    private AFABTE503SelectProcessParameter parameter;
    private NippoMybatisParameter mybatisparameter;
    private TeijiCommonJohoItem 帳票共通ヘッダー;

    @BatchWriter
    private BatchReportWriter<ShukeiSeirihyoReportSource> batchReportWriter;
    private ReportSourceWriter<ShukeiSeirihyoReportSource> reportSourceWriter;
    @BatchWriter
    private BatchReportWriter<ShukeiSeirihyoReportSource> batchReportWriterFuzaisha;
    private ReportSourceWriter<ShukeiSeirihyoReportSource> reportSourceWriterFuzaisha;
    private ShukeiSeirihyoBreakEditor editor;

    OutputParameter<Integer> pageCount = new OutputParameter<>();

    @Override
    protected void initialize() {
        mybatisparameter = parameter.toNippoMybatisParameter();
        帳票共通ヘッダー = new ReportHeadEditor().create帳票共通ヘッダー();
    }

    @Override
    protected void beforeExecute() {
        editor = new ShukeiSeirihyoBreakEditor(parameter);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPER_ID, mybatisparameter);
    }

    @Override
    protected void createWriter() {

        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdKeys.AFAPRE505_集計整理表.value()).
                addBreak(new BreakerCatalog<ShukeiSeirihyoReportSource>().simplePageBreaker(
                        Collections.unmodifiableList(Arrays.asList(
                                new RString(TohyoJiyuChoshoSource.ReportSourceFileds.senkyoNo.name()))))).
                create();
        batchReportWriterFuzaisha = BatchReportFactory.createBatchReportWriter(ReportIdKeys.AFAPRE505_集計整理表_不在者投票分.value()).
                addBreak(new BreakerCatalog<ShukeiSeirihyoReportSource>().simplePageBreaker(Collections.unmodifiableList(Arrays.asList(
                        new RString(TohyoJiyuChoshoSource.ReportSourceFileds.senkyoNo.name()))))).
                create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        reportSourceWriterFuzaisha = new ReportSourceWriter<>(batchReportWriterFuzaisha);
    }

    @Override
    protected void usualProcess(NippoPSMPrintEntity current) {
        editor.usualProcess(current);
        editor.usualProcessFuzaisha(current);
    }

    @Override
    protected void keyBreakProcess(NippoPSMPrintEntity current) {
        ShukeiSeirihyoParam printTohyokuCode = editor.keyBreakProcessByTohyokuCode(getBefore(), current);
        if (null != printTohyokuCode) {
            ShukeiSeirihyoReport report = new ShukeiSeirihyoReport(printTohyokuCode, create帳票共通ヘッダー(current));
            report.writeBy(reportSourceWriter);
        }

        ShukeiSeirihyoParam printTohyokuCodeFuzaisha = editor.keyBreakProcessByTohyokuCodeFuzaisha(getBefore(), current);
        if (null != printTohyokuCodeFuzaisha) {
            ShukeiSeirihyoReport report = new ShukeiSeirihyoReport(printTohyokuCodeFuzaisha, create帳票共通ヘッダー(current));
            report.writeBy(reportSourceWriterFuzaisha);
        }

        ShukeiSeirihyoParam printSenkyoNo = editor.keyBreakProcessBySenkyoNo(getBefore(), current);
        if (null != printSenkyoNo) {
            ShukeiSeirihyoReport report = new ShukeiSeirihyoReport(printSenkyoNo, create帳票共通ヘッダー(current));
            report.writeBy(reportSourceWriter);
        }
        ShukeiSeirihyoParam printSenkyoNo1 = editor.keyBreakProcessBySenkyoNo1(getBefore(), current);
        if (null != printSenkyoNo1) {
            ShukeiSeirihyoReport report = new ShukeiSeirihyoReport(printSenkyoNo1, create帳票共通ヘッダー(current));
            report.writeBy(reportSourceWriter);
        }

        ShukeiSeirihyoParam printSenkyoNoFuzaisha = editor.keyBreakProcessBySenkyoNoFuzaisha(getBefore(), current);
        if (null != printSenkyoNoFuzaisha) {
            ShukeiSeirihyoReport report = new ShukeiSeirihyoReport(printSenkyoNoFuzaisha, create帳票共通ヘッダー(current));
            report.writeBy(reportSourceWriterFuzaisha);
        }

        ShukeiSeirihyoParam printSenkyoNoFuzaisha1 = editor.keyBreakProcessBySenkyoNoFuzaisha(getBefore(), current);
        if (null != printSenkyoNoFuzaisha1) {
            ShukeiSeirihyoReport report = new ShukeiSeirihyoReport(printSenkyoNoFuzaisha1, create帳票共通ヘッダー(current));
            report.writeBy(reportSourceWriterFuzaisha);
        }
    }

    @Override
    protected void afterExecute() {
        pageCount.setValue(batchReportWriter.getPageCount());
        pageCount.setValue(batchReportWriterFuzaisha.getPageCount());
        ShukeiSeirihyoParam print1 = editor.createLastProcess1();
        if (null == print1) {
            return;
        }
        ShukeiSeirihyoReport report1 = new ShukeiSeirihyoReport(print1, create帳票共通ヘッダー());
        report1.writeBy(reportSourceWriter);
        ShukeiSeirihyoParam printFuzaisha1 = editor.createLastProcessFuzaisha1();
        ShukeiSeirihyoReport reportFuzaisha1 = new ShukeiSeirihyoReport(printFuzaisha1, create帳票共通ヘッダー());
        reportFuzaisha1.writeBy(reportSourceWriterFuzaisha);
        ShukeiSeirihyoParam print2 = editor.createLastProcess2();
        ShukeiSeirihyoReport report2 = new ShukeiSeirihyoReport(print2, create帳票共通ヘッダー());
        report2.writeBy(reportSourceWriter);
        ShukeiSeirihyoParam printFuzaisha2 = editor.createLastProcessFuzaisha2();
        ShukeiSeirihyoReport reportFuzaisha2 = new ShukeiSeirihyoReport(printFuzaisha2, create帳票共通ヘッダー());
        reportFuzaisha2.writeBy(reportSourceWriterFuzaisha);

    }

    private TeijiCommonJohoItem create帳票共通ヘッダー() {
        return 帳票共通ヘッダー;
    }

    private TeijiCommonJohoItem create帳票共通ヘッダー(NippoPSMPrintEntity current) {
        帳票共通ヘッダー.set選挙名称(current.get選挙Entity().getSenkyoName());
        return 帳票共通ヘッダー;
    }
}
