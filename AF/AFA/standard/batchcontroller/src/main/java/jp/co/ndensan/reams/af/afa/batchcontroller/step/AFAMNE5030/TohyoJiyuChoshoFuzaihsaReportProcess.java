/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE5030;

import java.util.Arrays;
import java.util.Collections;
import jp.co.ndensan.reams.af.afa.batchcontroller.common.ReportHeadEditor;
import jp.co.ndensan.reams.af.afa.business.core.TohyoJiyuChoshoParam;
import jp.co.ndensan.reams.af.afa.business.core.nippo.TohyoJiyuChoshoFuzaihsaBreakEditor;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE504.TohyoJiyuChoshoReport;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.nippo.NippoMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.nippo.AFABTE503SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.nippo.NippoPrintEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE504.TohyoJiyuChoshoSource;
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
 * 不在者投票の事由に関する調書帳票出力のクラスです。
 *
 * @reamsid_L AF-0270-020 xul
 */
public class TohyoJiyuChoshoFuzaihsaReportProcess extends BatchKeyBreakBase<NippoPrintEntity> {

    private static final RString MAPPER_ID
            = new RString("jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.nippo."
                    + "INippoMapper.select不在者投票の事由に関する調書");

    private AFABTE503SelectProcessParameter parameter;
    private NippoMybatisParameter mybatisparameter;
    private TeijiCommonJohoItem 帳票共通ヘッダー;

    @BatchWriter
    private BatchReportWriter<TohyoJiyuChoshoSource> batchReportWriter;
    private ReportSourceWriter<TohyoJiyuChoshoSource> reportSourceWriter;
    private TohyoJiyuChoshoFuzaihsaBreakEditor editor;

    OutputParameter<Integer> pageCount = new OutputParameter<>();

    @Override
    protected void initialize() {
        mybatisparameter = parameter.toNippoMybatisParameter();
        帳票共通ヘッダー = new ReportHeadEditor().create帳票共通ヘッダー();
    }

    @Override
    protected void beforeExecute() {
        editor = new TohyoJiyuChoshoFuzaihsaBreakEditor(parameter);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPER_ID, mybatisparameter);
    }

    @Override
    protected void createWriter() {

        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdKeys.AFAPRE504_投票事由調書_不在者.value()).
                addBreak(new BreakerCatalog<TohyoJiyuChoshoSource>().simplePageBreaker(
                                Collections.unmodifiableList(Arrays.asList(
                                                new RString(TohyoJiyuChoshoSource.ReportSourceFileds.senkyoNo.name()))))).
                create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void usualProcess(NippoPrintEntity current) {
        editor.usualProcess(current);
    }

    @Override
    protected void keyBreakProcess(NippoPrintEntity current) {
        TohyoJiyuChoshoParam printTohyokuCode = editor.keyBreakProcessByTohyokuCode(getBefore(), current);
        if (null != printTohyokuCode) {
            TohyoJiyuChoshoReport report = new TohyoJiyuChoshoReport(printTohyokuCode, create帳票共通ヘッダー(current));
            report.writeBy(reportSourceWriter);
        }
        TohyoJiyuChoshoParam printSenkyoNo1 = editor.keyBreakProcessBySenkyoNo(getBefore(), current);
        if (null != printSenkyoNo1) {
            TohyoJiyuChoshoReport report = new TohyoJiyuChoshoReport(printSenkyoNo1, create帳票共通ヘッダー(current));
            report.writeBy(reportSourceWriter);
        }
        TohyoJiyuChoshoParam printSenkyoNo2 = editor.keyBreakProcessBySenkyoNo1(getBefore(), current);
        if (null != printSenkyoNo2) {
            TohyoJiyuChoshoReport report = new TohyoJiyuChoshoReport(printSenkyoNo2, create帳票共通ヘッダー(current));
            report.writeBy(reportSourceWriter);
        }

    }

    @Override
    protected void afterExecute() {
        pageCount.setValue(batchReportWriter.getPageCount());
        TohyoJiyuChoshoParam print1 = editor.createLastProcess1();
        if (null == print1) {
            return;
        }
        TohyoJiyuChoshoReport report1 = new TohyoJiyuChoshoReport(print1, create帳票共通ヘッダー());
        report1.writeBy(reportSourceWriter);
        TohyoJiyuChoshoParam print2 = editor.createLastProcess2();
        TohyoJiyuChoshoReport report2 = new TohyoJiyuChoshoReport(print2, create帳票共通ヘッダー());
        report2.writeBy(reportSourceWriter);

    }

    private TeijiCommonJohoItem create帳票共通ヘッダー() {
        return 帳票共通ヘッダー;
    }

    private TeijiCommonJohoItem create帳票共通ヘッダー(NippoPrintEntity current) {
        帳票共通ヘッダー.set選挙名称(current.get選挙Entity().getSenkyoName());
        return 帳票共通ヘッダー;
    }
}
