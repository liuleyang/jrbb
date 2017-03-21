/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRA100.MeiboShohonReport;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRA100.MeinoShohonParam;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.CautionshaSearchKubun;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.kokumintohyoji.KokuminTohyojiMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.kokumintohyoji.AFABTG101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101.SenkyoninMeiboShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA100.MeiboShohonSource;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.KosekiShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.IBatchReportWriterWithCheckList;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.CheckListInfoFactory;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.CheckListLineItemSet;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.CheckShubetsu;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.ICheckListInfo;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.ICheckTarget;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.ISpecificKey;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 投票人名簿抄本のプロセスクラスです。
 *
 * @reamsid_L AF-0360-050 qiuxy
 */
public class TohyoninMeiboShohonReportProcess extends BatchProcessBase<SenkyoninMeiboShohonEntity> {

    private AFABTG101SelectProcessParameter parameter;
    private KokuminTohyojiMybatisParameter mybatisparameter;
    private List<RString> 出力順ID;
    private static final ReportId REPORT_ID = new ReportId(ReportIdKeys.投票人名簿抄本.value());
    @BatchWriter
    private IBatchReportWriterWithCheckList<MeiboShohonSource> batchReportWriter;
    private ReportSourceWriter<MeiboShohonSource> reportSourceWriter;

    @BatchWriter
    private IBatchReportWriterWithCheckList<MeiboShohonSource> batchReportWriterJuran;
    private ReportSourceWriter<MeiboShohonSource> reportSourceWriterJuran;

    private MeinoShohonParam.MeinoShohonParamKokuminBuilder builder;
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
        List<JuminShubetsu> 住民種別 = new ArrayList<>();
        住民種別.add(JuminShubetsu.日本人);
        ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.未定義);
        build.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        build.set基準日(parameter.get基準日());
        build.set住民種別(住民種別);
        build.set戸籍取得区分(KosekiShutokuKubun.戸籍情報を取得する);
        IShikibetsuTaishoPSMSearchKey searchKey = build.build();
        mybatisparameter = parameter.toBatchMybatisParameter(searchKey, searchKey);
        mybatisparameter.setRiyoKubun(CautionshaSearchKubun.利用区分.getCode());
        mybatisparameter.setChushutsuKubun(CautionshaSearchKubun.抽出区分.getCode());
        FlexibleDate kijunbi = parameter.get基準日();
        RDateTime 基準日 = RDateTime.of(kijunbi.getYearValue(), kijunbi.getMonthValue(), kijunbi.getDayValue(), 01, 01);
        mybatisparameter.setKonkaiChushutsu(基準日);
        mybatisparameter.setZenkaiChushutsu(基準日);
        mybatisparameter.setChuiShuruiCode(CautionshaSearchKubun.注意種類コード.getCode());
        mybatisparameter.setYukoKigenKubun(CautionshaSearchKubun.有効期限.getCode());
        mybatisparameter.addSortAfter(SORT_AFTER);
        pageCount = new OutputParameter<>();
        pageCountJuran = new OutputParameter<>();
        出力順ID = get出力順List();

        builder = new MeinoShohonParam.MeinoShohonParamKokuminBuilder(parameter.toAFABTA101SelectProcessParameter(null, null), 出力順ID,
                AssociationFinderFactory.createInstance().getAssociation().get市町村名());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(new RString(
                "jp.co.ndensan.reams.af.afa.persistence.db.mapper.kokumintohyoji.IAFABTG101Mapper.selectTohyoninMeiboShohon"),
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
            MeiboShohonReport report = new MeiboShohonReport(new MeinoShohonParam(false, param), true);
            report.writeBy(reportSourceWriter);
            report = new MeiboShohonReport(new MeinoShohonParam(true, param), true);
            report.writeBy(reportSourceWriterJuran);
        }
    }

    @Override
    protected void afterExecute() {

        MeinoShohonParam param = builder.afterAll();
        if (param != null) {
            MeiboShohonReport report = new MeiboShohonReport(new MeinoShohonParam(false, param), true);
            report.writeBy(reportSourceWriter);
            report = new MeiboShohonReport(new MeinoShohonParam(true, param), true);
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
                TohyoninMeiboShohonReportProcess.ParticularProject.class,
                TohyoninMeiboShohonReportProcess.CheckProject.class);
        ICheckListInfo info = CheckListInfoFactory.createInstance(
                SubGyomuCode.AFA選挙本体,
                AssociationFinderFactory.createInstance().getAssociation());

        batchReportWriter = BatchWriters
                .batchReportWriterWithCheckList(MeiboShohonSource.class)
                .checkListInfo(info)
                .checkListLineItemSet(pairs)
                .reportId(ReportIdKeys.投票人名簿抄本.value())
                .addBreak(new BreakerCatalog<MeiboShohonSource>().simplePageBreaker(PAGE_BREAK_KEYS))
                .build();

        batchReportWriterJuran = BatchWriters
                .batchReportWriterWithCheckList(MeiboShohonSource.class)
                .checkListInfo(info)
                .checkListLineItemSet(pairs)
                .reportId(ReportIdKeys.投票人名簿抄本_縦覧.value())
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
