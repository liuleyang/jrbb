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
import jp.co.ndensan.reams.af.afa.batchcontroller.common.ReportHeadEditor;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRG114.NigoShikakuChosahyoKaitoParameter;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRG114.NigoShikakuChosahyoKaitoReport;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.kokumintohyoji.KokuminTohyojiMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.kokumintohyoji.AFABTG101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.kokumintohyoji.MitorokushaMasshoTsuchiListEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRG114.NigoShikakuChosahyoKaitoSource;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.KosekiShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
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
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.definition.core.tashichosonsofusakimaintenance.SofusakiGroup;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.chihokokyodantai.CityAtesakiService;
import jp.co.ndensan.reams.ur.urz.service.core.chihokokyodantai.ICityAtesakiFinder;
import jp.co.ndensan.reams.ur.urz.service.core.zenkokujusho.IZenkokuJushoFinder;
import jp.co.ndensan.reams.ur.urz.service.core.zenkokujusho.ZenkokuJushoFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 2号資格調査票（回答）のバッチ処理クラスです。
 *
 * @reamsid_L AF-0360-062 fulc
 */
public class NigoShikakuChosahyoKaitoProcess extends BatchProcessBase<MitorokushaMasshoTsuchiListEntity> {

    private AFABTG101SelectProcessParameter parameter;
    private KokuminTohyojiMybatisParameter mybatisParameter;
    private TeijiCommonJohoItem 帳票共通ヘッダー;
    @BatchWriter
    private IBatchReportWriterWithCheckList<NigoShikakuChosahyoKaitoSource> btchReportWriter;
    private ReportSourceWriter<NigoShikakuChosahyoKaitoSource> reportSouceWriter;
    private IZenkokuJushoFinder zenkokuJushoFinder;
    private ICityAtesakiFinder cityAtesakiFinder;
    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(new RString(
            NigoShikakuChosahyoKaitoSource.ReportSourceFields.tennyumaeZenkokuJushoCode.name())));
    private Association association;
    private RString 転入先郵便番号;
    private RString 転入先市区町村名;
    private RString 転入先市区町村区分名称;
    private RString 転入前市区町村名区分名称;
    private RString 転入前市区町村名;
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
        転入先郵便番号 = RString.EMPTY;
        転入先市区町村名 = RString.EMPTY;
        転入先市区町村区分名称 = RString.EMPTY;
        転入前市区町村名区分名称 = RString.EMPTY;
        転入前市区町村名 = RString.EMPTY;
        zenkokuJushoFinder = ZenkokuJushoFinderFactory.createInstance();
        cityAtesakiFinder = CityAtesakiService.createCityAtesakiFinder();
        association = AssociationFinderFactory.createInstance().getAssociation();
        帳票共通ヘッダー = new ReportHeadEditor().create帳票共通ヘッダー();
        pageCount = new OutputParameter<>();
        List<JuminShubetsu> 住民種別 = new ArrayList<>();
        住民種別.add(JuminShubetsu.日本人);
        ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.未定義);
        build.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        build.set基準日(parameter.get基準日());
        build.set住民種別(住民種別);
        build.set戸籍取得区分(KosekiShutokuKubun.戸籍情報を取得する);
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = build.build();
        mybatisParameter = parameter.toBatchMybatisParameter(shikibetsuTaishoPSMSearchKey, null);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(new RString(
                "jp.co.ndensan.reams.af.afa.persistence.db.mapper.kokumintohyoji.IAFABTG101Mapper.selectNigoShikakuChosahyoList"
        ), mybatisParameter);
    }

    @Override
    protected void createWriter() {
        create文字切れ一覧表に出力Writer();
        reportSouceWriter = new ReportSourceWriter<>(btchReportWriter);

    }

    @Override
    protected void process(MitorokushaMasshoTsuchiListEntity entity) {
        set転入先市区町村名();
        set転入前市区町村名(entity);
        NigoShikakuChosahyoKaitoParameter para = new NigoShikakuChosahyoKaitoParameter(entity,
                転入先郵便番号,
                転入先市区町村名,
                転入先市区町村区分名称,
                parameter.get発行番号の号_2号資格(),
                parameter.get発行番号の番号_2号資格(),
                parameter.get発行番号の第_2号資格(),
                転入前市区町村名区分名称,
                転入前市区町村名,
                parameter.get発行日_2号資格());
        NigoShikakuChosahyoKaitoReport report = new NigoShikakuChosahyoKaitoReport(para, 帳票共通ヘッダー);
        report.writeBy(reportSouceWriter);

    }

    @Override
    protected void afterExecute() {
        pageCount.setValue(btchReportWriter.getPageCount());
    }

    private void set転入先市区町村名() {
        LasdecCode 地方公共団体 = association.get地方公共団体コード();

        転入先市区町村名 = association.get都道府県名().concat(association.get市町村名());
        転入先市区町村区分名称 = association.get市町村名().substringReturnAsPossible(association.get市町村名().length() - 1, association.get市町村名().length());
        ShichosonAtesaki 市町村宛先 = cityAtesakiFinder.get市町村宛先(地方公共団体, SofusakiGroup.選挙人情報関連.getCode());
        if (市町村宛先 != null) {
            転入先郵便番号 = 市町村宛先.get郵便番号().value();
        }

    }

    private void set転入前市区町村名(MitorokushaMasshoTsuchiListEntity entity) {
        ZenkokuJushoCode 全国住所コード = ShikibetsuTaishoFactory.createKojin(entity.getShikibetsuTaishoEntity()).get転入前().get全国住所コード();
        if (null != 全国住所コード && !全国住所コード.isEmpty()) {
            ZenkokuJushoItem zenkokuJushoItem = zenkokuJushoFinder.get全国住所By全国住所コード(全国住所コード);
            if (zenkokuJushoItem != null) {
                転入前市区町村名 = zenkokuJushoItem.get都道府県名().concat(zenkokuJushoItem.get市町村名());
                転入前市区町村名区分名称 = zenkokuJushoItem.get市町村名()
                        .substringReturnAsPossible(zenkokuJushoItem.get市町村名().length() - 1, zenkokuJushoItem.get市町村名().length());
            }
        } else {
            転入前市区町村名 = RString.EMPTY;
            転入前市区町村名区分名称 = RString.EMPTY;
        }
    }

    private void create文字切れ一覧表に出力Writer() {
        CheckListLineItemSet pairs = CheckListLineItemSet.of(
                NigoShikakuChosahyoKaitoProcess.特定項目.class,
                NigoShikakuChosahyoKaitoProcess.チェック項目.class);
        ICheckListInfo info = CheckListInfoFactory.createInstance(
                SubGyomuCode.AFA選挙本体,
                AssociationFinderFactory.createInstance().getAssociation());

        btchReportWriter = BatchWriters
                .batchReportWriterWithCheckList(NigoShikakuChosahyoKaitoSource.class)
                .checkListInfo(info)
                .checkListLineItemSet(pairs)
                .reportId(ReportIdKeys.AFAPRG114_2号資格調査票_回答.value())
                .addBreak(new BreakerCatalog<NigoShikakuChosahyoKaitoSource>().simplePageBreaker(PAGE_BREAK_KEYS))
                .build();
    }

    private enum 特定項目 implements ISpecificKey {

        識別コード("shikibetsuCode1", "識別コード");

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

        氏名("shimei", "氏名", CheckShubetsu.文字切れ);

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
