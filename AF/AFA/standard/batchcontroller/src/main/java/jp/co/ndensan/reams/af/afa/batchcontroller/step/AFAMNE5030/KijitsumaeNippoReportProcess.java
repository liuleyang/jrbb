/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5030;

import java.util.List;
import jp.co.ndensan.reams.af.afa.batchcontroller.common.ReportHeadEditor;
import jp.co.ndensan.reams.af.afa.business.core.KijitsumaeNippoParam;
import jp.co.ndensan.reams.af.afa.business.core.nippo.KijitsumaeNippoBreakEditor;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE500.KijitsumaeNippoReport;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.nippo.NippoMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.nippo.AFABTE503SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.nippo.NippoPSMPrintEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE500.KijitsumaeNippoReportSource;
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
 * 期日前投票日報帳票出力のクラスです。
 *
 * @reamsid_L AF-0270-020 xul
 */
public class KijitsumaeNippoReportProcess extends BatchKeyBreakBase<NippoPSMPrintEntity> {

    private static final RString MAPPER_ID
            = new RString("jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.nippo."
                    + "INippoMapper.select期日前投票日報リスト");
    private List<RString> pageBreakKeys;

    private AFABTE503SelectProcessParameter parameter;
    private NippoMybatisParameter mybatisparameter;
    private TeijiCommonJohoItem 帳票共通ヘッダー;
    private RString currentSenkyoName;

    @BatchWriter
    private BatchReportWriter<KijitsumaeNippoReportSource> batchReportWriter;
    private ReportSourceWriter<KijitsumaeNippoReportSource> reportSourceWriter;
    private KijitsumaeNippoBreakEditor editor;

    OutputParameter<Integer> pageCount = new OutputParameter<>();

    @Override
    protected void initialize() {
        mybatisparameter = parameter.toNippoMybatisParameter();
        pageBreakKeys = parameter.get改頁項目();
        帳票共通ヘッダー = new ReportHeadEditor().create帳票共通ヘッダー();
        currentSenkyoName = null;
    }

    @Override
    protected void beforeExecute() {
        editor = new KijitsumaeNippoBreakEditor(parameter);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPER_ID, mybatisparameter);
    }

    @Override
    protected void createWriter() {

        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdKeys.AFAPRE500_期日前投票日報.value()).
                addBreak(new BreakerCatalog<KijitsumaeNippoReportSource>().simplePageBreaker(pageBreakKeys)).
                create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void usualProcess(NippoPSMPrintEntity current) {
        editor.usualProcess(current);
        currentSenkyoName = current.get選挙Entity().getSenkyoName();
    }

    @Override
    protected void keyBreakProcess(NippoPSMPrintEntity current) {
        List<KijitsumaeNippoParam> printList = editor.keyBreakProcess(getBefore(), current);
        for (KijitsumaeNippoParam kijitsumaeNippoParam : printList) {
            KijitsumaeNippoReport report = new KijitsumaeNippoReport(kijitsumaeNippoParam, create帳票共通ヘッダー(getBefore()));
            report.writeBy(reportSourceWriter);

        }

    }

    @Override
    protected void afterExecute() {
        pageCount.setValue(batchReportWriter.getPageCount());
        KijitsumaeNippoParam print1 = editor.createLastProcess1();
        if (null == print1) {
            return;
        }
        帳票共通ヘッダー.set選挙名称(currentSenkyoName);
        KijitsumaeNippoReport report1 = new KijitsumaeNippoReport(print1, 帳票共通ヘッダー);
        report1.writeBy(reportSourceWriter);
        KijitsumaeNippoParam print2 = editor.createLastProcess2();
        KijitsumaeNippoReport report2 = new KijitsumaeNippoReport(print2, 帳票共通ヘッダー);
        report2.writeBy(reportSourceWriter);
        List<KijitsumaeNippoParam> printList = editor.createLastProcess3();
        for (KijitsumaeNippoParam kijitsumaeNippoParam : printList) {
            KijitsumaeNippoReport report = new KijitsumaeNippoReport(kijitsumaeNippoParam, 帳票共通ヘッダー);
            report.writeBy(reportSourceWriter);
        }

    }

    private TeijiCommonJohoItem create帳票共通ヘッダー(NippoPSMPrintEntity current) {
        帳票共通ヘッダー.set選挙名称(current.get選挙Entity().getSenkyoName());
        return 帳票共通ヘッダー;
    }

}
