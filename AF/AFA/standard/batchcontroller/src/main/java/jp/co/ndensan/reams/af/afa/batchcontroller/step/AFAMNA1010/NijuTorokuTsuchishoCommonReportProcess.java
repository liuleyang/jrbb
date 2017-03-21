/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNA1010;

import java.util.HashMap;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRA111.NijuTorokuTsuchishoLayoutBreak;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRA111.NijuTorokuTsuchishoPageBreak;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRA111.NijuTorokuTsuchishoParameter;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRA111.NijuTorokuTsuchishoReport;
import static jp.co.ndensan.reams.af.afa.business.teijitouroku.NullHandler.getNullToRString;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.teijitouroku.BatchMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.teijitouroku.AFABTA101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoMeiboShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA111.NijuTorokuTsuchishoCommonSource;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.IBatchReportWriterWithCheckList;
import jp.co.ndensan.reams.ur.urz.business.core.chihokokyodantai.ShichosonAtesaki;
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
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 二重登録通知書のクラスです。
 *
 * @reamsid_L AF-0010-044 xiaoj
 */
public class NijuTorokuTsuchishoCommonReportProcess extends BatchKeyBreakBase<SenkyoMeiboShohonEntity> {

    private static final int 転入前全国住所コード上5桁 = 5;
    private AFABTA101SelectProcessParameter parameter;
    private BatchMybatisParameter mybatisparameter;
    private int itemCout;
    private int page;
    private RString layoutIndex;
    private RString 発行番号_第;
    private RString 発行番号_番号;
    private RString 発行番号_号;
    private FlexibleDate 転入期間_開始日;
    private FlexibleDate 転入期間_終了日;
    private RString 選挙名称;
    private ShikibetsuCode 識別コード;
    private boolean 選挙名称設定フラグ;
    private HashMap<SenkyoNo, RString> 選挙番号;
    private ShichosonAtesaki atesaki;
    @BatchWriter
    private IBatchReportWriterWithCheckList<NijuTorokuTsuchishoCommonSource> atesakiCsvWriter;
    private ReportSourceWriter<NijuTorokuTsuchishoCommonSource> reportSourceWriter;

    /**
     * ページ数Parameterです。
     */
    public static final RString PAGE_COUNT;

    static {
        PAGE_COUNT = new RString("pageCount");
    }
    OutputParameter<Integer> pageCount;

    private static final int FIRST_PAGE_COUNT = 15;
    private static final int AFTER_SECOND_PAGE = 20;

    @Override
    protected void initialize() {
        mybatisparameter = parameter.toBatchMybatisParameter();
        選挙名称 = RString.EMPTY;
        選挙名称設定フラグ = true;
        選挙番号 = new HashMap();
        pageCount = new OutputParameter<>();
        発行番号_第 = parameter.get発行番号_第();
        発行番号_番号 = parameter.get発行番号_番号();
        発行番号_号 = parameter.get発行番号_号();
        転入期間_開始日 = parameter.get転入期間_開始日();
        転入期間_終了日 = parameter.get転入期間_終了日();
        page = 1;
        itemCout = 0;
        layoutIndex = RString.EMPTY;
        atesaki = null;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(new RString(
                "jp.co.ndensan.reams.af.afa.persistence.db.mapper.teijitouroku.IAFABTA101Mapper.selectNijuTorokuList"),
                mybatisparameter);
    }

    @Override
    protected void createWriter() {
        create文字切れ一覧表に出力Writer();
        reportSourceWriter = new ReportSourceWriter<>(atesakiCsvWriter);
    }

    @Override
    protected void keyBreakProcess(SenkyoMeiboShohonEntity current) {
        if (hasBreak(getBefore(), current)) {
            page++;
            itemCout = 0;
        }
    }

    private boolean hasBreak(SenkyoMeiboShohonEntity before, SenkyoMeiboShohonEntity current) {
        return !get転入前全国住所コード上5桁(before)
                .equals(get転入前全国住所コード上5桁(current));
    }

    @Override
    protected void usualProcess(SenkyoMeiboShohonEntity entity) {
        ShikibetsuCode shikibetsuCode = entity.getAtenaPSMEntity().getShikibetsuCode();
        if (選挙名称設定フラグ && (識別コード == null || 識別コード.equals(shikibetsuCode))) {
            選挙番号.put(entity.getSenkyoEntity().getSenkyoNo(), entity.getSenkyoEntity().getSenkyoName());
            get選挙名称(entity);
        }
        if (shikibetsuCode == null || shikibetsuCode.equals(識別コード)) {
            return;
        }
        識別コード = shikibetsuCode;
        if (page == 1) {
            layoutIndex = new RString("1");
        } else {
            layoutIndex = new RString("2");
        }
        ZenkokuJushoCode 転入前全国住所コード = entity.getAtenaPSMEntity().getTennyumaeZenkokuJushoCode();
        if (itemCout == 0) {

            ICityAtesakiFinder finder = CityAtesakiService.createCityAtesakiFinder();
            if (null == 転入前全国住所コード || 転入前全国住所コード.isEmpty()) {
                atesaki = null;
            } else {
                LasdecCode 地方公共団体コード = new LasdecCode(転入前全国住所コード.getShichosonCode6());
                atesaki = finder.get市町村宛先(地方公共団体コード, SofusakiGroup.選挙人情報関連.getCode());
            }
        }
        NijuTorokuTsuchishoParameter param = new NijuTorokuTsuchishoParameter(entity,
                発行番号_第, 発行番号_番号, 発行番号_号, 転入期間_開始日, 転入期間_終了日, new RString(page),
                layoutIndex, atesaki, 選挙名称);
        NijuTorokuTsuchishoReport report = new NijuTorokuTsuchishoReport(param);
        report.writeBy(reportSourceWriter);

        itemCout++;
        if (page == 1 && itemCout == FIRST_PAGE_COUNT) {
            page++;
            itemCout = 0;
        } else if (page > 1 && itemCout == AFTER_SECOND_PAGE) {
            page++;
            itemCout = 0;
        }
    }

    private void get選挙名称(SenkyoMeiboShohonEntity entity) {
        if (選挙番号.containsKey(new SenkyoNo(1)) && 選挙番号.size() > 1
                && entity.getSenkyoEntity().getSenkyoName() != null) {
            選挙名称 = 選挙名称.concat("　他");
            選挙名称設定フラグ = false;
        } else if (選挙番号.containsKey(new SenkyoNo(1))) {
            選挙名称 = entity.getSenkyoEntity().getSenkyoName();
        } else {
            選挙名称設定フラグ = false;
        }
    }

    @Override
    protected void afterExecute() {

        pageCount.setValue(atesakiCsvWriter.getPageCount());
    }

    private void create文字切れ一覧表に出力Writer() {
        CheckListLineItemSet pairs = CheckListLineItemSet.of(
                NijuTorokuTsuchishoCommonReportProcess.特定項目.class,
                NijuTorokuTsuchishoCommonReportProcess.チェック項目.class);
        ICheckListInfo info = CheckListInfoFactory.createInstance(
                SubGyomuCode.AFA選挙本体,
                AssociationFinderFactory.createInstance().getAssociation());

        atesakiCsvWriter = BatchWriters
                .batchReportWriterWithCheckList(NijuTorokuTsuchishoCommonSource.class)
                .checkListInfo(info)
                .checkListLineItemSet(pairs)
                .reportId(ReportIdKeys.二重登録通知書.value())
                .addBreak(new NijuTorokuTsuchishoLayoutBreak())
                .addBreak(new NijuTorokuTsuchishoPageBreak())
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

    private RString get転入前全国住所コード上5桁(SenkyoMeiboShohonEntity entity) {
        RString 転入前全国住所コード = getNullToRString(entity.getAtenaPSMEntity().getTennyumaeZenkokuJushoCode());
        if (転入前全国住所コード.isNullOrEmpty()) {
            return RString.EMPTY;
        } else {
            return 転入前全国住所コード.substring(0, 転入前全国住所コード上5桁);
        }
    }
}
