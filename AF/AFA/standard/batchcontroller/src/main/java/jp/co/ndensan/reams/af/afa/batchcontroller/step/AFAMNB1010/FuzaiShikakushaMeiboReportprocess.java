/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB1010;

import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.af.afa.batchcontroller.common.ReportHeadEditor;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRC204.FuzaiShikakushaMeiboReport;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.NullHandler;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.business.util.shikakuhantei.ShikakuHantei;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.senkyojitouroku.SenkyojiMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojitouroku.AFABTB101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT114FuzaishaTohyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabtb101.FuzaiShikakushaMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRC204.FuzaiShikakushaMeiboSource;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 不在者投票資格者名簿のクラスです。
 *
 * @reamsid_L AF-0030-036 liss
 */
public class FuzaiShikakushaMeiboReportprocess extends BatchKeyBreakBase<FuzaiShikakushaMeiboEntity> {

    private AFABTB101SelectProcessParameter parameter;
    private SenkyojiMybatisParameter mybatisparameter;
    private TeijiCommonJohoItem 帳票共通ヘッダー;
    private ShikakuHantei shikakuHantei;
    private FuzaiShikakushaMeiboEntity lastFuzaiShikakusha;
    @BatchWriter
    private BatchReportWriter<FuzaiShikakushaMeiboSource> batchReportWriter;
    private ReportSourceWriter<FuzaiShikakushaMeiboSource> reportSourceWriter;
    private int rowCount;

    /**
     * ページ数Parameterです。
     */
    public static final RString PAGE_COUNT;
    /**
     * ページbreakキーです。
     */
    public static final List<RString> PAGE_BREAK_KEY;

    static {
        PAGE_COUNT = new RString("pageCount");
        PAGE_BREAK_KEY = Arrays.asList(new RString("title"), new RString("pageBreak"));

    }
    private OutputParameter<Integer> pageCount;

    @Override
    protected void initialize() {
        mybatisparameter = parameter.toSenkyojiMybatisParameter();
        帳票共通ヘッダー = new ReportHeadEditor().create帳票共通ヘッダー();
        pageCount = new OutputParameter<>();
        shikakuHantei = new ShikakuHantei();
        lastFuzaiShikakusha = null;
        rowCount = 1;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(new RString(
                "jp.co.ndensan.reams.af.afa.persistence.db.mapper.senkyojitouroku.IAFABTB101Mapper.selectFuzaiShikakushaMeibo"),
                mybatisparameter);
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory
                .createBatchReportWriter(ReportIdKeys.不在資格対象者名簿.value(), SubGyomuCode.AFA選挙本体)
                .addBreak(new BreakerCatalog<FuzaiShikakushaMeiboSource>().simplePageBreaker(PAGE_BREAK_KEY)).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void usualProcess(FuzaiShikakushaMeiboEntity current) {
        if (current != null && is不在資格者(current)) {
            FuzaiShikakushaMeiboReport report = new FuzaiShikakushaMeiboReport(current, 帳票共通ヘッダー, rowCount);
            report.writeBy(reportSourceWriter);
            rowCount++;
            lastFuzaiShikakusha = current;
        }
    }

    @Override
    protected void keyBreakProcess(FuzaiShikakushaMeiboEntity current) {
        if (is不在資格者(current) && lastFuzaiShikakusha != null && hasBreak(lastFuzaiShikakusha, current)) {
            rowCount = 1;
        }
    }

    @Override
    protected void afterExecute() {
        pageCount.setValue(batchReportWriter.getPageCount());
    }

    private boolean hasBreak(FuzaiShikakushaMeiboEntity before, FuzaiShikakushaMeiboEntity current) {
        return !before.getFuzaishaTohyoShikakuEntity().getTohyoShikakuShurui().equals(
                current.getFuzaishaTohyoShikakuEntity().getTohyoShikakuShurui())
                || !NullHandler.getNullToRString(before.getBreakPage()).equals(NullHandler.getNullToRString(current.getBreakPage()));
    }

    private boolean is不在資格者(FuzaiShikakushaMeiboEntity entity) {
        ShikibetsuCode 識別コード = entity.getSenkyoninMeiboEntity().getShikibetsuCode();
        FlexibleDate 基準日 = entity.getShohonEntity().getTohyoYMD();
        List<AfT114FuzaishaTohyoShikakuEntity> 不在者投票資格List = Arrays.asList(entity.getFuzaishaTohyoShikakuEntity());
        return shikakuHantei.has郵便投票資格(識別コード, 基準日, 不在者投票資格List)
                || shikakuHantei.has洋上投票資格(識別コード, 基準日, 不在者投票資格List)
                || shikakuHantei.has南極投票資格(識別コード, 基準日, 不在者投票資格List);
    }
}
