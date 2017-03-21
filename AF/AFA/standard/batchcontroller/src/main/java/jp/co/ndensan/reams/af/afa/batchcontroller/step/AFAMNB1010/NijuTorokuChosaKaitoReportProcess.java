/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB1010;

import jp.co.ndensan.reams.af.afa.business.report.AFAPRB101.NijuTorokuChosaKaitoLayoutBreak;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRB101.NijuTorokuChosaKaitoPageBreak;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRB101.NijuTorokuChosaKaitoParameter;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRB101.NijuTorokuChosaKaitoReport;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.NullHandler;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.senkyojitouroku.SenkyojiMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojitouroku.AFABTB101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabtb101.NijuTorokuChosaKaitoEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRB101.NijuTorokuChosaKaitoSource;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.IBatchReportWriterWithCheckList;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.chihokokyodantai.ShichosonAtesaki;
import jp.co.ndensan.reams.ur.urz.business.core.zenkokujusho.ZenkokuJushoItem;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.CheckListInfoFactory;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.CheckListLineItemSet;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.CheckShubetsu;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.ICheckListInfo;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.ICheckTarget;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.ISpecificKey;
import jp.co.ndensan.reams.ur.urz.definition.core.tashichosonsofusakimaintenance.SofusakiGroup;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.chihokokyodantai.CityAtesakiService;
import jp.co.ndensan.reams.ur.urz.service.core.chihokokyodantai.ICityAtesakiFinder;
import jp.co.ndensan.reams.ur.urz.service.core.zenkokujusho.IZenkokuJushoFinder;
import jp.co.ndensan.reams.ur.urz.service.core.zenkokujusho.ZenkokuJushoFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 二重登録調査票（回答）のクラスです。
 *
 * @reamsid_L AF-0030-034 liss
 */
public class NijuTorokuChosaKaitoReportProcess extends BatchKeyBreakBase<NijuTorokuChosaKaitoEntity> {

    private AFABTB101SelectProcessParameter parameter;
    private SenkyojiMybatisParameter mybatisparameter;
    private Association 地方公共団体;
    private int page;
    private int allPage;
    private int rowCount;
    private RString layoutIndex;
    private RString 転出先市町村名;
    private RString 転出先郵便番号;
    private FlexibleDate 転出期間_開始日;
    private FlexibleDate 転出期間_終了日;
    private IZenkokuJushoFinder zenkokuJushoFinder;
    private ICityAtesakiFinder cityAtesakiFinder;
    private static final int FIRST_PAGE_COUNT = 12;
    private static final int AFTER_SECOND_PAGE = 20;
    @BatchWriter
    private IBatchReportWriterWithCheckList<NijuTorokuChosaKaitoSource> batchReportWriter;
    private ReportSourceWriter<NijuTorokuChosaKaitoSource> reportSourceWriter;

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
        pageCount = new OutputParameter<>();
        zenkokuJushoFinder = ZenkokuJushoFinderFactory.createInstance();
        cityAtesakiFinder = CityAtesakiService.createCityAtesakiFinder();
        地方公共団体 = null;
        転出先市町村名 = RString.EMPTY;
        転出先郵便番号 = RString.EMPTY;
        転出期間_開始日 = parameter.get転出期間_開始日();
        転出期間_終了日 = parameter.get転出期間_終了日();
        page = 1;
        allPage = 1;
        rowCount = 0;
        layoutIndex = RString.EMPTY;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(new RString(
                "jp.co.ndensan.reams.af.afa.persistence.db.mapper.senkyojitouroku.IAFABTB101Mapper.selectNijuTorokuChosaKaito"),
                mybatisparameter);
    }

    @Override
    protected void createWriter() {
        create文字切れ一覧表に出力Writer();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void keyBreakProcess(NijuTorokuChosaKaitoEntity current) {
        if (hasBreak(getBefore(), current)) {
            allPage++;
            page = 1;
            rowCount = 0;
        }
    }

    private boolean hasBreak(NijuTorokuChosaKaitoEntity before, NijuTorokuChosaKaitoEntity current) {
        return !NullHandler.get転出確定全国住所コード上5桁(toSenkyoninTohyoJokyoEntity(before))
                .equals(NullHandler.get転出確定全国住所コード上5桁(toSenkyoninTohyoJokyoEntity(current)));
    }

    @Override
    protected void usualProcess(NijuTorokuChosaKaitoEntity entity) {
        if (page == 1) {
            layoutIndex = new RString("1");
            if (rowCount == 0) {
                set共通項目(entity);
            }
        } else {
            layoutIndex = new RString("2");
        }

        NijuTorokuChosaKaitoParameter param = new NijuTorokuChosaKaitoParameter(entity,
                転出先市町村名, 転出先郵便番号, new RString(String.valueOf(allPage)), 地方公共団体, 転出期間_開始日,
                転出期間_終了日, new RString(String.valueOf(page)), layoutIndex);
        NijuTorokuChosaKaitoReport report = new NijuTorokuChosaKaitoReport(param);
        report.writeBy(reportSourceWriter);

        rowCount++;
        if (page == 1 && rowCount == FIRST_PAGE_COUNT) {
            page++;
            allPage++;
            rowCount = 0;
        } else if (page > 1 && rowCount == AFTER_SECOND_PAGE) {
            page++;
            allPage++;
            rowCount = 0;
        }
    }

    @Override
    protected void afterExecute() {
        pageCount.setValue(batchReportWriter.getPageCount());
    }

    private SenkyoninTohyoJokyoEntity toSenkyoninTohyoJokyoEntity(NijuTorokuChosaKaitoEntity entity) {
        SenkyoninTohyoJokyoEntity targetEntity = new SenkyoninTohyoJokyoEntity();
        targetEntity.setAtenaPSMEntity(entity.getShikibetsuTaishoEntity());
        return targetEntity;
    }

    private void set共通項目(NijuTorokuChosaKaitoEntity entity) {
        ZenkokuJushoCode 全国住所コード = ShikibetsuTaishoFactory.createKojin(entity.getShikibetsuTaishoEntity()).get転出確定().get全国住所コード();
        if (null != 全国住所コード && !全国住所コード.isEmpty()) {
            ZenkokuJushoItem zenkokuJushoItem = zenkokuJushoFinder.get全国住所By全国住所コード(全国住所コード);
            if (zenkokuJushoItem != null) {
                転出先市町村名 = zenkokuJushoItem.get都道府県名().concat(zenkokuJushoItem.get市町村名());
            }
            ShichosonAtesaki 市町村宛先 = cityAtesakiFinder.get市町村宛先(
                    new LasdecCode(全国住所コード.getShichosonCode6()), SofusakiGroup.選挙人情報関連.getCode());
            if (市町村宛先 != null) {
                転出先郵便番号 = 市町村宛先.get郵便番号().value();
            }
        }
        LasdecCode 現全国地方公共団体コード = entity.getShikibetsuTaishoEntity().getGenLasdecCode();
        if (null != 現全国地方公共団体コード && !現全国地方公共団体コード.isEmpty()) {
            地方公共団体 = AssociationFinderFactory.createInstance().getAssociation(現全国地方公共団体コード);
        }
    }

    private void create文字切れ一覧表に出力Writer() {
        CheckListLineItemSet pairs = CheckListLineItemSet.of(
                NijuTorokuChosaKaitoReportProcess.特定項目.class,
                NijuTorokuChosaKaitoReportProcess.チェック項目.class);
        ICheckListInfo info = CheckListInfoFactory.createInstance(
                SubGyomuCode.AFA選挙本体,
                AssociationFinderFactory.createInstance().getAssociation());

        batchReportWriter = BatchWriters
                .batchReportWriterWithCheckList(NijuTorokuChosaKaitoSource.class)
                .checkListInfo(info)
                .checkListLineItemSet(pairs)
                .reportId(ReportIdKeys.二重登録調査票_回答.value())
                .addBreak(new NijuTorokuChosaKaitoLayoutBreak())
                .addBreak(new NijuTorokuChosaKaitoPageBreak())
                .build();
    }

    private enum 特定項目 implements ISpecificKey {

        識別コード("shikibetsuCode", "識別コード");

        private final RString itemName;
        private final RString printName;

        private 特定項目(String itemName, String printName) {
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

    private enum チェック項目 implements ICheckTarget {

        target1("juSho", "住所", CheckShubetsu.文字切れ),
        target2("shiMei", "氏名", CheckShubetsu.文字切れ);

        private final RString itemName;
        private final RString printName;
        private final CheckShubetsu checkShubetsu;

        private チェック項目(String itemName, String printName, CheckShubetsu checkShubetsu) {
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
