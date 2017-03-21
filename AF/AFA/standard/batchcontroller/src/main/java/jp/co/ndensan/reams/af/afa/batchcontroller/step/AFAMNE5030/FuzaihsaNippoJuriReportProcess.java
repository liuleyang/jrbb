/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5030;

import java.util.List;
import jp.co.ndensan.reams.af.afa.batchcontroller.common.ReportHeadEditor;
import jp.co.ndensan.reams.af.afa.business.core.FuzaihsaNippoParam;
import jp.co.ndensan.reams.af.afa.business.core.nippo.FuzaihsaNippoJuriBreakEditor;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE501.FuzaihsaNippoReport;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.nippo.NippoMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.nippo.AFABTE503SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.nippo.NippoPSMPrintEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE501.FuzaihsaNippoReportSource;
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
 * 不在者投票日報受理帳票出力のクラスです。
 *
 * @reamsid_L AF-0270-020 xul
 */
public class FuzaihsaNippoJuriReportProcess extends BatchKeyBreakBase<NippoPSMPrintEntity> {

    private static final RString MAPPER_ID
            = new RString("jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.nippo."
                    + "INippoMapper.select不在者投票日報受理リスト");
    private List<RString> pageBreakKeys;

    private AFABTE503SelectProcessParameter parameter;
    private NippoMybatisParameter mybatisparameter;
    private TeijiCommonJohoItem 帳票共通ヘッダー;

    @BatchWriter
    private BatchReportWriter<FuzaihsaNippoReportSource> batchReportWriter;
    private ReportSourceWriter<FuzaihsaNippoReportSource> reportSourceWriter;
    private FuzaihsaNippoJuriBreakEditor editor;

    OutputParameter<Integer> pageCount = new OutputParameter<>();

    @Override
    protected void initialize() {
        mybatisparameter = parameter.toNippoMybatisParameter();
        pageBreakKeys = parameter.get改頁項目();
        帳票共通ヘッダー = new ReportHeadEditor().create帳票共通ヘッダー();
    }

    @Override
    protected void beforeExecute() {
        editor = new FuzaihsaNippoJuriBreakEditor(parameter);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPER_ID, mybatisparameter);
    }

    @Override
    protected void createWriter() {

        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdKeys.AFAPRE501_不在者投票日報_受理日報.value()).
                addBreak(new BreakerCatalog<FuzaihsaNippoReportSource>().simplePageBreaker(pageBreakKeys)).
                create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void usualProcess(NippoPSMPrintEntity current) {
        editor.usualProcess(current);
    }

    @Override
    protected void keyBreakProcess(NippoPSMPrintEntity current) {
        FuzaihsaNippoParam printTohyobi = editor.keyBreakProcessByTohyobi(getBefore(), current);
        if (null != printTohyobi) {
            FuzaihsaNippoReport report = new FuzaihsaNippoReport(printTohyobi, create帳票共通ヘッダー(current));
            report.writeBy(reportSourceWriter);
        }
        FuzaihsaNippoParam printSenkyo = editor.keyBreakProcessBySenkyo(getBefore(), current);
        if (null != printSenkyo) {
            FuzaihsaNippoReport report = new FuzaihsaNippoReport(printSenkyo, create帳票共通ヘッダー(current));
            report.writeBy(reportSourceWriter);
        }
        FuzaihsaNippoParam printSenkyo1 = editor.keyBreakProcessBySenkyo1(getBefore(), current);
        if (null != printSenkyo1) {
            FuzaihsaNippoReport report = new FuzaihsaNippoReport(printSenkyo1, create帳票共通ヘッダー(current));
            report.writeBy(reportSourceWriter);
        }
    }

    @Override
    protected void afterExecute() {
        pageCount.setValue(batchReportWriter.getPageCount());
        FuzaihsaNippoParam print1 = editor.createLastProcess1();
        if (null == print1) {
            return;
        }
        FuzaihsaNippoReport report1 = new FuzaihsaNippoReport(print1, create帳票共通ヘッダー());
        report1.writeBy(reportSourceWriter);
        FuzaihsaNippoParam print2 = editor.createLastProcess2();
        FuzaihsaNippoReport report2 = new FuzaihsaNippoReport(print2, create帳票共通ヘッダー());
        report2.writeBy(reportSourceWriter);
        FuzaihsaNippoParam print3 = editor.createLastProcess3();
        FuzaihsaNippoReport report3 = new FuzaihsaNippoReport(print3, create帳票共通ヘッダー());
        report3.writeBy(reportSourceWriter);
    }

    private TeijiCommonJohoItem create帳票共通ヘッダー() {
        return 帳票共通ヘッダー;
    }

    private TeijiCommonJohoItem create帳票共通ヘッダー(NippoPSMPrintEntity current) {
        帳票共通ヘッダー.set選挙名称(current.get選挙Entity().getSenkyoName());
        return 帳票共通ヘッダー;
    }
}
