/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB1010;

import jp.co.ndensan.reams.af.afa.business.report.AFAPRB300.MeiboShohonZaigaiPageBreak;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRB300.MeiboShohonZaigaiParameter;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRB300.MeiboShohonZaigaiReport;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ToriatsukaiChuishaShutsurokuHoshikiConfig;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.senkyojitouroku.SenkyojiMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojitouroku.AFABTB101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoMeiboShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB300.MeiboShohonZaigaiSource;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.cautionsha.UaFt400FindeCautionShaMapperEntity;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.IBatchReportWriterWithCheckList;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.CheckListInfoFactory;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.CheckListLineItemSet;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.CheckShubetsu;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.ICheckListInfo;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.ICheckTarget;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.ISpecificKey;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 在外選挙人名簿抄本（縦覧用）のクラスです。
 *
 * @reamsid_L AF-0030-035 liss
 */
public class MeiboShohonZaigaiJuranReportProcess extends BatchKeyBreakBase<SenkyoMeiboShohonEntity> {

    private static final int 帳票最大行 = 25;
    private static final RString 出力区分 = new RString("データ");
    private static final RString 利用区分 = new RString("2");
    private static final RString 抽出区分 = new RString("1");
    private static final RString 注意種類コード = new RString("01");
    private static final RString 有効期限 = new RString("0");

    private AFABTB101SelectProcessParameter parameter;
    private SenkyojiMybatisParameter mybatisparameter;
    private RString 取扱注意者の出力方式;
    private int itemCout;
    private int page;
    private int totalPage;
    private Association association;
    @BatchWriter
    private IBatchReportWriterWithCheckList<MeiboShohonZaigaiSource> batchReportWriter;
    private ReportSourceWriter<MeiboShohonZaigaiSource> reportSourceWriter;

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
        page = 1;
        itemCout = 0;
        totalPage = 1;
        取扱注意者の出力方式 = BusinessConfig.get(
                ToriatsukaiChuishaShutsurokuHoshikiConfig.取扱注意者_出力方式, SubGyomuCode.AFA選挙本体);
        IAssociationFinder associationFinder = AssociationFinderFactory.createInstance();
        association = associationFinder.getAssociation();
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
        reportSourceWriter.pageCount().value();
    }

    @Override
    protected void usualProcess(SenkyoMeiboShohonEntity entity) {
        取扱い注意者判断(entity);
        itemCout++;
        int 最大印字行 = Integer.valueOf(BusinessConfig.get(ConfigKeysAFA.抄本_在外_ページ行数, SubGyomuCode.AFA選挙本体).toString());
        if (itemCout == (最大印字行 > 帳票最大行 ? 帳票最大行 : 最大印字行)) {
            totalPage++;
            page++;
            itemCout = 0;
        }
    }

    @Override
    protected void keyBreakProcess(SenkyoMeiboShohonEntity entity) {
        if (itemCout != 0 && hasBreakBy投票区(getBefore(), entity)) {
            page = 1;
            totalPage++;
            itemCout = 0;
        }
    }

    private Boolean hasBreakBy投票区(SenkyoMeiboShohonEntity before, SenkyoMeiboShohonEntity current) {
        return !before.getZaigaiSenkyoninMeiboEntity().getTohyokuCode().equals(current.getZaigaiSenkyoninMeiboEntity().getTohyokuCode());
    }

    @Override
    protected void afterExecute() {
        pageCount.setValue(batchReportWriter.getPageCount());
    }

    private void 取扱い注意者判断(SenkyoMeiboShohonEntity entity) {
        UaFt400FindeCautionShaMapperEntity findeCautionShaMapperEntity = entity.getFindeCautionShaMapperEntity();
        if (findeCautionShaMapperEntity != null && findeCautionShaMapperEntity.isGaitoKubun()) {
            if (!ToriatsukaiChuishaShutsurokuHoshikiConfig.行を詰める.getValue().equals(取扱注意者の出力方式)) {
                MeiboShohonZaigaiParameter param = new MeiboShohonZaigaiParameter(entity,
                        取扱注意者の出力方式, new RString(String.valueOf(page)),
                        new RString(String.valueOf(totalPage)), association, null,
                        false, false, false, false, 0, 0,
                        null, null, null, null, null,
                        null, null, null);
                MeiboShohonZaigaiReport report = new MeiboShohonZaigaiReport(param, ReportIdKeys.在外選挙人名簿抄本_縦覧用.value());
                report.writeBy(reportSourceWriter);
            }
        } else {
            MeiboShohonZaigaiParameter param = new MeiboShohonZaigaiParameter(entity,
                    出力区分, new RString(String.valueOf(page)),
                    new RString(String.valueOf(totalPage)), association, null,
                    false, false, false, false, 0, 0,
                    null, null, null, null, null,
                    null, null, null);
            MeiboShohonZaigaiReport report = new MeiboShohonZaigaiReport(param, ReportIdKeys.在外選挙人名簿抄本_縦覧用.value());
            report.writeBy(reportSourceWriter);
        }
    }

    private void create文字切れ一覧表に出力Writer() {
        CheckListLineItemSet pairs = CheckListLineItemSet.of(
                MeiboShohonZaigaiJuranReportProcess.ParticularProject.class,
                MeiboShohonZaigaiJuranReportProcess.CheckProject.class);
        ICheckListInfo info = CheckListInfoFactory.createInstance(
                SubGyomuCode.AFA選挙本体,
                AssociationFinderFactory.createInstance().getAssociation());

        batchReportWriter = BatchWriters
                .batchReportWriterWithCheckList(MeiboShohonZaigaiSource.class)
                .checkListInfo(info)
                .checkListLineItemSet(pairs)
                .reportId(ReportIdKeys.在外選挙人名簿抄本_縦覧用.value())
                .addBreak(new MeiboShohonZaigaiPageBreak())
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
