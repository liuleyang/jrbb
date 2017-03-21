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
import jp.co.ndensan.reams.af.afa.business.report.AFAPRA100.MeiboShohonReport;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRA100.MeinoShohonParam;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.teijitouroku.BatchMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.teijitouroku.AFABTA101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101.SenkyoninMeiboShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA100.MeiboShohonSource;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.IBatchReportWriterWithCheckList;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.CheckListInfoFactory;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.CheckListLineItemSet;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.CheckShubetsu;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.ICheckListInfo;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.ICheckTarget;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.ISpecificKey;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 選挙人名簿抄本のクラスです。
 */
public class MeiboShohonReportProcess extends BatchProcessBase<SenkyoninMeiboShohonEntity> {

    private static final RString 利用区分 = new RString("2");
    private static final RString 抽出区分 = new RString("1");
    private static final RString 注意種類コード = new RString("01");
    private static final RString 有効期限 = new RString("0");

    private AFABTA101SelectProcessParameter parameter;
    private BatchMybatisParameter mybatisparameter;
    private List<RString> 出力順ID;
    private static final ReportId REPORT_ID = new ReportId(ReportIdKeys.選挙人名簿抄本.value());
    @BatchWriter
    private IBatchReportWriterWithCheckList<MeiboShohonSource> batchReportWriter;
    private ReportSourceWriter<MeiboShohonSource> reportSourceWriter;

    @BatchWriter
    private IBatchReportWriterWithCheckList<MeiboShohonSource> batchReportWriterJuran;
    private ReportSourceWriter<MeiboShohonSource> reportSourceWriterJuran;

    private MeinoShohonParam.MeinoShohonParamBuilder builder;
    private static final List<RString> PAGE_BREAK_KEYS
            = Collections.unmodifiableList(Arrays.asList(new RString(MeiboShohonSource.ReportSourceFields.realPage.name())));

    private static final RString SORT_AFTER = new RString("\"ShikibetsuTaisho\".\"shikibetsuCode\" asc ");

    /**
     * ページ数Parameterです。
     */
    public static final RString PAGE_COUNT;
    /**
     * ページ数Parameterです。
     */
    public static final RString PAGE_COUNT_JURAN;

    static {
        PAGE_COUNT = new RString("pageCount");
        PAGE_COUNT_JURAN = new RString("pageCountJuran");
    }
    OutputParameter<Integer> pageCount;
    OutputParameter<Integer> pageCountJuran;

    @Override
    protected void initialize() {
        mybatisparameter = parameter.toBatchMybatisParameter();
        mybatisparameter.setRiyoKubun(利用区分);
        mybatisparameter.setChushutsuKubun(抽出区分);
        FlexibleDate kijunbi = parameter.getKijunbi();
        RDateTime 基準日 = RDateTime.of(kijunbi.getYearValue(), kijunbi.getMonthValue(), kijunbi.getDayValue(), 01, 01);
        mybatisparameter.setKonkaiChushutsu(基準日);
        mybatisparameter.setZenkaiChushutsu(基準日);
        mybatisparameter.setChuiShuruiCode(注意種類コード);
        mybatisparameter.setYukoKigenKubun(有効期限);
        mybatisparameter.addSortAfter(SORT_AFTER);
        pageCount = new OutputParameter<>();
        pageCountJuran = new OutputParameter<>();
        出力順ID = get出力順List();

        builder = new MeinoShohonParam.MeinoShohonParamBuilder(parameter, 出力順ID,
                AssociationFinderFactory.createInstance().getAssociation().get市町村名());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(new RString(
                "jp.co.ndensan.reams.af.afa.persistence.db.mapper.teijitouroku.IAFAPRA100Mapper.selectSenkyoninMeiboShohon"),
                mybatisparameter);
    }

    @Override
    protected void createWriter() {
        create文字切れ一覧表に出力Writer();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        reportSourceWriterJuran = new ReportSourceWriter<>(batchReportWriterJuran);
    }

    @Override
    protected void process(SenkyoninMeiboShohonEntity entity) {
        MeinoShohonParam param = builder.addData(entity);

        if (param != null) {
            MeiboShohonReport report = new MeiboShohonReport(new MeinoShohonParam(false, param), false);
            report.writeBy(reportSourceWriter);
            report = new MeiboShohonReport(new MeinoShohonParam(true, param), false);
            report.writeBy(reportSourceWriterJuran);
        }
    }

    @Override
    protected void afterExecute() {

        MeinoShohonParam param = builder.afterAll();
        if (param != null) {
            MeiboShohonReport report = new MeiboShohonReport(new MeinoShohonParam(false, param), false);
            report.writeBy(reportSourceWriter);
            report = new MeiboShohonReport(new MeinoShohonParam(true, param), false);
            report.writeBy(reportSourceWriterJuran);
        }
        pageCount.setValue(batchReportWriter.getPageCount());
        pageCountJuran.setValue(batchReportWriterJuran.getPageCount());

    }

    private List<RString> get出力順List() {
        IChohyoShutsuryokujunFinder chohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();

        List<IOutputOrder> 帳票出力順List = chohyoShutsuryokujunFinder.get出力順(SubGyomuCode.AFA選挙本体, REPORT_ID);
        if (!帳票出力順List.isEmpty()) {
            IOutputOrder 帳票出力順 = 帳票出力順List.get(0);
            return 帳票出力順.getFormated集計項目().split(" ＞ ");
        }
        return new ArrayList<>();
    }

    private void create文字切れ一覧表に出力Writer() {
        CheckListLineItemSet pairs = CheckListLineItemSet.of(
                MeiboShohonReportProcess.ParticularProject.class,
                MeiboShohonReportProcess.CheckProject.class);
        ICheckListInfo info = CheckListInfoFactory.createInstance(
                SubGyomuCode.AFA選挙本体,
                AssociationFinderFactory.createInstance().getAssociation());

        batchReportWriter = BatchWriters
                .batchReportWriterWithCheckList(MeiboShohonSource.class)
                .checkListInfo(info)
                .checkListLineItemSet(pairs)
                .reportId(ReportIdKeys.選挙人名簿抄本.value())
                .addBreak(new BreakerCatalog<MeiboShohonSource>().simplePageBreaker(PAGE_BREAK_KEYS))
                .build();

        batchReportWriterJuran = BatchWriters
                .batchReportWriterWithCheckList(MeiboShohonSource.class)
                .checkListInfo(info)
                .checkListLineItemSet(pairs)
                .reportId(ReportIdKeys.選挙人名簿抄本_縦覧用.value())
                .addBreak(new BreakerCatalog<MeiboShohonSource>().simplePageBreaker(PAGE_BREAK_KEYS))
                .build();
    }

    private enum ParticularProject implements ISpecificKey {

        識別コード("shikibetsuCode", "識別コード");

        private final RString itemName;
        private final RString printName;

        private ParticularProject(String itemName, String printName) {
            this.itemName = new RString(itemName);
            this.printName = new RString(printName);
        }

        @Override
        public RString getItemName() {
            return this.itemName;
        }

        @Override
        public RString getPrintName() {
            return this.printName;
        }
    }

    private enum CheckProject implements ICheckTarget {

        target1("listJusho", "住所", CheckShubetsu.文字切れ),
        target2("listShimei_1", "氏名", CheckShubetsu.文字切れ),
        target3("listShimeiM_1", "氏名", CheckShubetsu.文字切れ);

        private final RString itemName;
        private final RString printName;
        private final CheckShubetsu checkShubetsu;

        private CheckProject(String itemName, String printName, CheckShubetsu checkShubetsu) {
            this.itemName = new RString(itemName);
            this.printName = new RString(printName);
            this.checkShubetsu = checkShubetsu;
        }

        @Override
        public RString getItemName() {
            return this.itemName;
        }

        @Override
        public RString getPrintName() {
            return this.printName;
        }

        @Override
        public CheckShubetsu getCheckShubetsu() {
            return this.checkShubetsu;
        }
    }
}
