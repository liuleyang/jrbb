/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.batchcontroller.common.ReportHeadEditor;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRG111.IchigoShikakuTorokuTsuchiParameter;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRG111.IchigoShikakuTorokuTsuchiReport;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.NullHandler;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.configkeys.AFAConfigKeysValue;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.kokumintohyoji.KokuminTohyojiMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.kokumintohyoji.AFABTG101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.kokumintohyoji.IchigoShikakuTorokuTsuchiListEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRG111.IchigoShikakuTorokuTsuchiSource;
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
 * 1号資格登録通知（様式1）のクラスです。
 *
 * @reamsid_L AF-0360-055 caijj2
 */
public class IchigoShikakuTorokuTsuchiReportProcess extends BatchKeyBreakBase<IchigoShikakuTorokuTsuchiListEntity> {

    private AFABTG101SelectProcessParameter parameter;
    private KokuminTohyojiMybatisParameter mybatisparameter;

    private Association 地方公共団体;
    private int page;
    private int itemCout;
    private static final RString 帳票固定ID = new RString("AFAPRG111");
    private RString 発行番号_第;
    private RString 発行番号_番号;
    private RString 発行番号_号;
    private FlexibleDate 発行日;
    private FlexibleDate 登録基準日;
    private RString 都道府県名;
    private RString 市区町村名;
    private ShichosonAtesaki 他市町村送付先;

    private IZenkokuJushoFinder zenkokuJushoFinder;
    private ICityAtesakiFinder cityAtesakiFinder;
    private boolean 郵便番号印字有無;

    @BatchWriter
    private IBatchReportWriterWithCheckList<IchigoShikakuTorokuTsuchiSource> batchReportWriter;
    private ReportSourceWriter<IchigoShikakuTorokuTsuchiSource> reportSourceWriter;

    /**
     * ページ数Parameterです。
     */
    public static final RString PAGE_COUNT;

    static {
        PAGE_COUNT = new RString("pageCount");
    }
    private OutputParameter<Integer> pageCount;

    private static final int FIRST_PAGE_COUNT = 15;
    private static final int AFTER_SECOND_PAGE = 20;

    @Override
    protected void initialize() {
        ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.未定義);
        build.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        build.set基準日(parameter.get基準日());
        build.set戸籍取得区分(KosekiShutokuKubun.戸籍情報を取得する);
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = build.build();
        mybatisparameter = parameter.toBatchMybatisParameter(shikibetsuTaishoPSMSearchKey, shikibetsuTaishoPSMSearchKey);
        mybatisparameter.set基準日(parameter.get基準日());

        発行番号_第 = parameter.get発行番号の第_1号資格();
        発行番号_番号 = parameter.get発行番号の番号_1号資格();
        発行番号_号 = parameter.get発行番号の号_1号資格();
        発行日 = parameter.get発行日_1号資格登録();
        登録基準日 = parameter.get基準日();
        都道府県名 = RString.EMPTY;
        市区町村名 = RString.EMPTY;
        page = 1;
        itemCout = 0;
        他市町村送付先 = null;
        zenkokuJushoFinder = ZenkokuJushoFinderFactory.createInstance();
        cityAtesakiFinder = CityAtesakiService.createCityAtesakiFinder();
        pageCount = new OutputParameter<>();

        郵便番号印字有無 = AFAConfigKeysValue.印字有無_印字する.isEqual(ConfigKeysAFA.国民_印字有無_カスタマーバーコード);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(new RString(
                "jp.co.ndensan.reams.af.afa.persistence.db.mapper.kokumintohyoji.IAFABTG101Mapper.ichigoShikakuTorokuTsuchiList"),
                mybatisparameter);
    }

    @Override
    protected void createWriter() {
        create文字切れ一覧表に出力Writer();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);

    }

    @Override
    protected void usualProcess(IchigoShikakuTorokuTsuchiListEntity entity) {
        set共通項目(entity);

        itemCout++;
        if (page == 1 && itemCout == FIRST_PAGE_COUNT) {
            page++;
            itemCout = 0;
        } else if (page > 1 && itemCout == AFTER_SECOND_PAGE) {
            page++;
            itemCout = 0;
        }

        TeijiCommonJohoItem 帳票共通ヘッダー = new ReportHeadEditor().create帳票共通ヘッダー();
        帳票共通ヘッダー.set帳票ID(帳票固定ID);

        IchigoShikakuTorokuTsuchiParameter param = new IchigoShikakuTorokuTsuchiParameter(entity,
                発行番号_第, 発行番号_番号, 発行番号_号, new RString(page),
                発行日, 地方公共団体, 都道府県名, 市区町村名, 他市町村送付先, 郵便番号印字有無, 登録基準日);
        IchigoShikakuTorokuTsuchiReport report = new IchigoShikakuTorokuTsuchiReport(param);
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void keyBreakProcess(IchigoShikakuTorokuTsuchiListEntity current) {
        if (hasBreak(getBefore(), current)) {
            page++;
            itemCout = 0;
        }
    }

    @Override
    protected void afterExecute() {
        pageCount.setValue(batchReportWriter.getPageCount());
    }

    private void set共通項目(IchigoShikakuTorokuTsuchiListEntity entity) {
        ZenkokuJushoCode 全国住所コード = ShikibetsuTaishoFactory.createKojin(entity.getShikibetsuTaishoEntity()).get転入前().get全国住所コード();
        if (null != 全国住所コード && !全国住所コード.isEmpty()) {
            ZenkokuJushoItem zenkokuJushoItem = zenkokuJushoFinder.get全国住所By全国住所コード(全国住所コード);
            if (zenkokuJushoItem != null) {
                都道府県名 = zenkokuJushoItem.get都道府県名();
                市区町村名 = zenkokuJushoItem.get市町村名();
            }

            他市町村送付先 = cityAtesakiFinder.get市町村宛先(
                    new LasdecCode(全国住所コード.getShichosonCode6()), SofusakiGroup.選挙人情報関連.getCode());

        }
        LasdecCode 現全国地方公共団体コード = entity.getShikibetsuTaishoEntity().getGenLasdecCode();
        if (null != 現全国地方公共団体コード && !現全国地方公共団体コード.isEmpty()) {
            地方公共団体 = AssociationFinderFactory.createInstance().getAssociation(現全国地方公共団体コード);
        }
    }

    private SenkyoninTohyoJokyoEntity toSenkyoninTohyoJokyoEntity(IchigoShikakuTorokuTsuchiListEntity entity) {
        SenkyoninTohyoJokyoEntity targetEntity = new SenkyoninTohyoJokyoEntity();
        targetEntity.setAtenaPSMEntity(entity.getShikibetsuTaishoEntity());
        return targetEntity;
    }

    private boolean hasBreak(IchigoShikakuTorokuTsuchiListEntity before, IchigoShikakuTorokuTsuchiListEntity current) {
        return !NullHandler.get転入前全国住所コード上5桁(toSenkyoninTohyoJokyoEntity(before))
                .equals(NullHandler.get転入前全国住所コード上5桁(toSenkyoninTohyoJokyoEntity(current)));
    }

    private void create文字切れ一覧表に出力Writer() {
        CheckListLineItemSet pairs = CheckListLineItemSet.of(
                IchigoShikakuTorokuTsuchiReportProcess.特定項目.class,
                IchigoShikakuTorokuTsuchiReportProcess.チェック項目.class);
        ICheckListInfo info = CheckListInfoFactory.createInstance(
                SubGyomuCode.AFA選挙本体,
                AssociationFinderFactory.createInstance().getAssociation());

        batchReportWriter = BatchWriters
                .batchReportWriterWithCheckList(IchigoShikakuTorokuTsuchiSource.class)
                .checkListInfo(info)
                .checkListLineItemSet(pairs)
                .reportId(ReportIdKeys.AFAPRG111_1号資格登録通知_様式1.value())
                .addBreak(new BreakerCatalog<IchigoShikakuTorokuTsuchiSource>().simplePageBreaker(get改頁キーリスト()))
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

        当住所1("listJusho1_1", "当住所1", CheckShubetsu.文字切れ),
        当住所2("listJusho2_1", "当住所2", CheckShubetsu.文字切れ),
        転出元住所1("listJusho1_2", "転出元住所1", CheckShubetsu.文字切れ),
        転出元住所2("listJusho2_2", "転出元住所2", CheckShubetsu.文字切れ),
        氏名("shiMei", "氏名", CheckShubetsu.文字切れ);

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

    private List<RString> get改頁キーリスト() {
        return Collections.unmodifiableList(Arrays.asList(new RString(IchigoShikakuTorokuTsuchiSource.ReportSourceFields.tennyuZanTop5.name())));
    }
}
