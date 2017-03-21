/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB1010;

import jp.co.ndensan.reams.af.afa.business.report.AFAPRB300.MeiboShohonZaigaiPageBreak;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRB300.MeiboShohonZaigaiParameter;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRB300.MeiboShohonZaigaiReport;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.senkyojitouroku.SenkyojiMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojitouroku.AFABTB101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoMeiboShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB300.MeiboShohonZaigaiSource;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.IBatchReportWriterWithCheckList;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.CheckListInfoFactory;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.CheckListLineItemSet;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.CheckShubetsu;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.ICheckListInfo;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.ICheckTarget;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.ISpecificKey;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 在外選挙人名簿抄本のクラスです。
 *
 * @reamsid_L AF-0030-035 liss
 */
public class MeiboShohonZaigaiReportProcess extends BatchKeyBreakBase<SenkyoMeiboShohonEntity> {

    private static final RString 利用区分 = new RString("2");
    private static final RString 抽出区分 = new RString("1");
    private static final RString 注意種類コード = new RString("01");
    private static final RString 有効期限 = new RString("0");

    private AFABTB101SelectProcessParameter parameter;
    private SenkyojiMybatisParameter mybatisparameter;
    @BatchWriter
    private IBatchReportWriterWithCheckList<MeiboShohonZaigaiSource> batchReportWriter;
    private ReportSourceWriter<MeiboShohonZaigaiSource> reportSourceWriter;
    MeiboShohonZaigaiReportProcessCore breakProcessCore;

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
        mybatisparameter = parameter.toSenkyojiMybatisParameter();
        mybatisparameter.setRiyoKubun(利用区分);
        mybatisparameter.setChushutsuKubun(抽出区分);
        FlexibleDate kijunbi = parameter.getKijunbi();
        RDateTime 基準日 = RDateTime.of(kijunbi.getYearValue(), kijunbi.getMonthValue(), kijunbi.getDayValue(), 01, 01);
        mybatisparameter.setKonkaiChushutsu(基準日);
        mybatisparameter.setZenkaiChushutsu(基準日);
        mybatisparameter.setChuiShuruiCode(注意種類コード);
        mybatisparameter.setYukoKigenKubun(有効期限);
        pageCount = new OutputParameter<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(new RString(
                "jp.co.ndensan.reams.af.afa.persistence.db.mapper.senkyojitouroku.IAFABTB101Mapper.selectSenkyoninmeiboshohonWithZaigai"),
                mybatisparameter);
    }

    @Override
    protected void createWriter() {
        create文字切れ一覧表に出力Writer();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void beforeExecute() {
        breakProcessCore = new MeiboShohonZaigaiReportProcessCore(parameter);
    }

    @Override
    protected void usualProcess(SenkyoMeiboShohonEntity entity) {
        breakProcessCore.usualProcess(entity);
    }

    @Override
    protected void keyBreakProcess(SenkyoMeiboShohonEntity entity) {
        MeiboShohonZaigaiParameter param = breakProcessCore.keyBreakProcess(getBefore(), entity);
        MeiboShohonZaigaiReport report = new MeiboShohonZaigaiReport(param, ReportIdKeys.在外選挙人名簿抄本.value());
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void afterExecute() {
        if (getBefore() != null) {
            MeiboShohonZaigaiParameter param = breakProcessCore.getLastLow(getBefore());
            MeiboShohonZaigaiReport report = new MeiboShohonZaigaiReport(param, ReportIdKeys.在外選挙人名簿抄本.value());
            report.writeBy(reportSourceWriter);
        }
        pageCount.setValue(batchReportWriter.getPageCount());
    }

    private void create文字切れ一覧表に出力Writer() {
        CheckListLineItemSet pairs = CheckListLineItemSet.of(
                MeiboShohonZaigaiReportProcess.ParticularProject.class,
                MeiboShohonZaigaiReportProcess.CheckProject.class);
        ICheckListInfo info = CheckListInfoFactory.createInstance(
                SubGyomuCode.AFA選挙本体,
                AssociationFinderFactory.createInstance().getAssociation());

        batchReportWriter = BatchWriters
                .batchReportWriterWithCheckList(MeiboShohonZaigaiSource.class)
                .checkListInfo(info)
                .checkListLineItemSet(pairs)
                .reportId(ReportIdKeys.在外選挙人名簿抄本.value())
                .addBreak(new BreakerCatalog<MeiboShohonZaigaiSource>().simplePageBreaker(new MeiboShohonZaigaiPageBreak().breakKeys()))
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
