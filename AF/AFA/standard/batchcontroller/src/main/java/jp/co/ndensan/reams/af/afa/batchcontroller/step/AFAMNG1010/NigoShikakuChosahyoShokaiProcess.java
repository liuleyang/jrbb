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
import jp.co.ndensan.reams.af.afa.business.report.AFAPRG113.NigoShikakuChosahyoShokaiParameter;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRG113.NigoShikakuChosahyoShokaiReport;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.NullHandler;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.kokumintohyoji.KokuminTohyojiMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.kokumintohyoji.AFABTG101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabtg101.NigoShikakuChosahyoEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRG113.NigoShikakuChosahyoShokaiSource;
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
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
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
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 2号資格調査票（照会）のプロセスクラスです。
 *
 * @reamsid_L AF-0360-061 qiuxy
 */
public class NigoShikakuChosahyoShokaiProcess extends BatchKeyBreakBase<NigoShikakuChosahyoEntity> {

    private AFABTG101SelectProcessParameter parameter;
    private KokuminTohyojiMybatisParameter mybatisparameter;
    private Association 地方公共団体;
    private RString 都道府県名;
    private RString 市区町村名;
    private RString 転入元郵便番号;
    private int page;
    private int itemCout;
    private RString 発行番号_第;
    private RString 発行番号_番号;
    private RString 発行番号_号;
    private FlexibleDate 発行年月日;
    private IZenkokuJushoFinder zenkokuJushoFinder;
    private ICityAtesakiFinder cityAtesakiFinder;
    private static final int FIRST_PAGE_COUNT = 10;

    @BatchWriter
    private IBatchReportWriterWithCheckList<NigoShikakuChosahyoShokaiSource> batchReportWriter;
    private ReportSourceWriter<NigoShikakuChosahyoShokaiSource> reportSourceWriter;

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
        List<JuminShubetsu> 住民種別 = new ArrayList<>();
        List<JuminJotai> 住民状態 = new ArrayList<>();
        住民種別.add(JuminShubetsu.日本人);
        住民状態.add(JuminJotai.住民);
        ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.未定義);
        build.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        build.set基準日(parameter.get基準日());
        build.set住民種別(住民種別);
        build.set住民状態(住民状態);
        build.set戸籍取得区分(KosekiShutokuKubun.戸籍情報を取得する);
        IShikibetsuTaishoPSMSearchKey searchKey = build.build();
        //TODO 下記暫定対応
        mybatisparameter = parameter.toBatchMybatisParameter(searchKey, searchKey);
        pageCount = new OutputParameter<>();
        zenkokuJushoFinder = ZenkokuJushoFinderFactory.createInstance();
        cityAtesakiFinder = CityAtesakiService.createCityAtesakiFinder();
        地方公共団体 = null;
        都道府県名 = RString.EMPTY;
        市区町村名 = RString.EMPTY;
        転入元郵便番号 = RString.EMPTY;
        発行番号_第 = parameter.get発行番号の第_2号資格();
        発行番号_番号 = parameter.get発行番号の番号_2号資格();
        発行番号_号 = parameter.get発行番号の号_2号資格();
        発行年月日 = parameter.get発行日_2号資格();
        page = 1;
        itemCout = 0;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(new RString(
                "jp.co.ndensan.reams.af.afa.persistence.db.mapper.kokumintohyoji.IAFABTG101Mapper.selectNigoShikakuChosahyo"),
                mybatisparameter);
    }

    @Override
    protected void createWriter() {
        create文字切れ一覧表に出力Writer();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void usualProcess(NigoShikakuChosahyoEntity entity) {
        if (page == 1) {
            set共通項目(entity);
        }

        NigoShikakuChosahyoShokaiParameter param = new NigoShikakuChosahyoShokaiParameter(entity, 転入元郵便番号,
                都道府県名, 市区町村名, 地方公共団体, 発行番号_第, 発行番号_番号, 発行番号_号, 発行年月日, page);
        NigoShikakuChosahyoShokaiReport report = new NigoShikakuChosahyoShokaiReport(param);
        report.writeBy(reportSourceWriter);
        itemCout++;
        if (itemCout == FIRST_PAGE_COUNT) {
            page++;
            itemCout = 0;
        }
    }

    @Override
    protected void keyBreakProcess(NigoShikakuChosahyoEntity current) {
        if (hasBreak(getBefore(), current)) {
            page = 1;
        }
    }

    @Override
    protected void afterExecute() {
        pageCount.setValue(batchReportWriter.getPageCount());
    }

    private List<RString> get改頁キーリスト() {
        return Collections.unmodifiableList(Arrays.asList(new RString(NigoShikakuChosahyoShokaiSource.ReportSourceFields.page.name())));
    }

    private void set共通項目(NigoShikakuChosahyoEntity entity) {
        ZenkokuJushoCode 全国住所コード = ShikibetsuTaishoFactory.createKojin(entity.getShikibetsuTaishoEntity()).get転入前().get全国住所コード();
        if (null != 全国住所コード && !全国住所コード.isEmpty()) {
            ZenkokuJushoItem zenkokuJushoItem = zenkokuJushoFinder.get全国住所By全国住所コード(全国住所コード);
            if (zenkokuJushoItem != null) {
                都道府県名 = zenkokuJushoItem.get都道府県名();
                市区町村名 = zenkokuJushoItem.get市町村名();
            }
            ShichosonAtesaki 市町村宛先 = cityAtesakiFinder.get市町村宛先(
                    new LasdecCode(全国住所コード.getShichosonCode6()), SofusakiGroup.選挙人情報関連.getCode());
            if (市町村宛先 != null) {
                転入元郵便番号 = 市町村宛先.get郵便番号().value();
            }
        }
        LasdecCode 現全国地方公共団体コード = entity.getShikibetsuTaishoEntity().getGenLasdecCode();
        if (null != 現全国地方公共団体コード && !現全国地方公共団体コード.isEmpty()) {
            地方公共団体 = AssociationFinderFactory.createInstance().getAssociation(現全国地方公共団体コード);
        }
    }

    private boolean hasBreak(NigoShikakuChosahyoEntity before, NigoShikakuChosahyoEntity current) {
        return !NullHandler.get転入前全国住所コード上5桁(toSenkyoninTohyoJokyoEntity(before))
                .equals(NullHandler.get転入前全国住所コード上5桁(toSenkyoninTohyoJokyoEntity(current)));
    }

    private SenkyoninTohyoJokyoEntity toSenkyoninTohyoJokyoEntity(NigoShikakuChosahyoEntity entity) {
        SenkyoninTohyoJokyoEntity targetEntity = new SenkyoninTohyoJokyoEntity();
        targetEntity.setAtenaPSMEntity(entity.getShikibetsuTaishoEntity());
        return targetEntity;
    }

    private void create文字切れ一覧表に出力Writer() {
        CheckListLineItemSet pairs = CheckListLineItemSet.of(
                NigoShikakuChosahyoShokaiProcess.特定項目.class,
                NigoShikakuChosahyoShokaiProcess.チェック項目.class);
        ICheckListInfo info = CheckListInfoFactory.createInstance(
                SubGyomuCode.AFA選挙本体,
                AssociationFinderFactory.createInstance().getAssociation());

        batchReportWriter = BatchWriters
                .batchReportWriterWithCheckList(NigoShikakuChosahyoShokaiSource.class)
                .checkListInfo(info)
                .checkListLineItemSet(pairs)
                .reportId(ReportIdKeys.AFAPRG113_2号資格調査票_照会.value())
                .addBreak(new BreakerCatalog<NigoShikakuChosahyoShokaiSource>().simplePageBreaker(get改頁キーリスト()))
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

        target1("toJuSho", "当住所", CheckShubetsu.文字切れ),
        target2("shiMei", "氏名", CheckShubetsu.文字切れ),
        target3("tenshutsuMotoJusho", "転出元住所", CheckShubetsu.文字切れ);

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
