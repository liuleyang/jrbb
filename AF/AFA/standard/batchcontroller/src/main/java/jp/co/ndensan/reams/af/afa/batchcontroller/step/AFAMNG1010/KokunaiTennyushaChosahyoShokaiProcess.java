/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRG301.KokugaiTennyushaChosahyoShokaiPageBreak;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRG301.KokugaiTennyushaChosahyoShokaiParameter;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRG301.KokugaiTennyushaChosahyoShokaiReport;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.kokumintohyoji.KokuminTohyojiMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.kokumintohyoji.AFABTG101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.kokumintohyoji.MitorokushaMasshoTsuchiListEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRG301.KokugaiTennyushaChosahyoShokaiSource;
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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 国内転入者調査票（照会）のバッチ処理クラスです。
 *
 * @reamsid_L AF-0360-066 b_caiyf
 */
public class KokunaiTennyushaChosahyoShokaiProcess extends BatchProcessBase<MitorokushaMasshoTsuchiListEntity> {

    private KokuminTohyojiMybatisParameter mybatisparameter;
    private AFABTG101SelectProcessParameter parameter;
    @BatchWriter
    private IBatchReportWriterWithCheckList<KokugaiTennyushaChosahyoShokaiSource> btchReportWriter;
    private ReportSourceWriter<KokugaiTennyushaChosahyoShokaiSource> reportSouceWriter;
    private RString 帳票ID;
    private IZenkokuJushoFinder zenkokuJushoFinder;
    private ICityAtesakiFinder cityAtesakiFinder;
    private Association 地方公共団体;
    private ShichosonAtesaki 他市町村送付先;
    private RString 全国住所都道府県名;
    private RString 全国住所市区町村名;
    private FlexibleDate 発行日;
    private RString 発行番号_第;
    private RString 発行番号_番号;
    private RString 発行番号_号;
    private FlexibleDate 名簿基準年月日;
    /**
     * ページ数Parameterです。
     */
    public static final RString PAGE_COUNT;

    static {
        PAGE_COUNT = new RString("pageCount");
    }
    private OutputParameter<Integer> pageCount;

    @Override
    protected void initialize() {

        List<JuminShubetsu> 住民種別 = new ArrayList<>();
        住民種別.add(JuminShubetsu.日本人);
        ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.未定義);
        build.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        build.set基準日(parameter.get基準日());
        build.set住民種別(住民種別);
        build.set戸籍取得区分(KosekiShutokuKubun.戸籍情報を取得する);
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = build.build();
        mybatisparameter = parameter.toBatchMybatisParameter(shikibetsuTaishoPSMSearchKey, shikibetsuTaishoPSMSearchKey);
        pageCount = new OutputParameter<>();
        発行番号_第 = parameter.get発行番号の第_国内転入者調査票();
        発行番号_番号 = parameter.get発行番号の番号_国内転入者調査票();
        発行番号_号 = parameter.get発行番号の号_国内転入者調査票();
        発行日 = parameter.get発行日_国内転入者調査票();
        名簿基準年月日 = parameter.get基準日();
        zenkokuJushoFinder = ZenkokuJushoFinderFactory.createInstance();
        cityAtesakiFinder = CityAtesakiService.createCityAtesakiFinder();
        帳票ID = ReportIdKeys.国内転入者調査票照会.value();

    }

    @Override
    protected void process(MitorokushaMasshoTsuchiListEntity entity) {
        set共通項目(entity);
        KokugaiTennyushaChosahyoShokaiParameter para = new KokugaiTennyushaChosahyoShokaiParameter(entity,
                発行日, 他市町村送付先, 発行番号_第, 発行番号_番号, 発行番号_号, 地方公共団体, 全国住所都道府県名,
                全国住所市区町村名, 帳票ID, 名簿基準年月日);
        KokugaiTennyushaChosahyoShokaiReport report = new KokugaiTennyushaChosahyoShokaiReport(para);
        report.writeBy(reportSouceWriter);
    }

    @Override
    protected void afterExecute() {
        pageCount.setValue(btchReportWriter.getPageCount());

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(new RString(
                "jp.co.ndensan.reams.af.afa.persistence.db.mapper.kokumintohyoji.IAFABTG101Mapper.selectKokunaiTennyushaChosahyoList"
        ), mybatisparameter);
    }

    @Override
    protected void createWriter() {
        create文字切れ一覧表に出力Writer();
        reportSouceWriter = new ReportSourceWriter<>(btchReportWriter);

    }

    private void set共通項目(MitorokushaMasshoTsuchiListEntity entity) {
        /*本籍全国住所コード*/
        ZenkokuJushoCode 全国住所コード = entity.getShikibetsuTaishoEntity().getHonsekiZenkokuJushoCode();
        if (null != 全国住所コード && !全国住所コード.isEmpty()) {
            ZenkokuJushoItem zenkokuJushoItem = zenkokuJushoFinder.get全国住所By全国住所コード(全国住所コード);

            if (zenkokuJushoItem != null) {
                全国住所都道府県名 = zenkokuJushoItem.get都道府県名();
                全国住所市区町村名 = zenkokuJushoItem.get市町村名();
            }

            他市町村送付先 = cityAtesakiFinder.get市町村宛先(
                    new LasdecCode(全国住所コード.getShichosonCode6()), SofusakiGroup.選挙人情報関連.getCode());

        }
        LasdecCode 現全国地方公共団体コード = entity.getShikibetsuTaishoEntity().getGenLasdecCode();
        if (null != 現全国地方公共団体コード && !現全国地方公共団体コード.isEmpty()) {
            地方公共団体 = AssociationFinderFactory.createInstance().getAssociation(現全国地方公共団体コード);
        }
    }

    private void create文字切れ一覧表に出力Writer() {
        CheckListLineItemSet pairs = CheckListLineItemSet.of(
                KokunaiTennyushaChosahyoShokaiProcess.特定項目.class,
                KokunaiTennyushaChosahyoShokaiProcess.チェック項目.class);
        ICheckListInfo info = CheckListInfoFactory.createInstance(
                SubGyomuCode.AFA選挙本体,
                AssociationFinderFactory.createInstance().getAssociation());

        btchReportWriter = BatchWriters
                .batchReportWriterWithCheckList(KokugaiTennyushaChosahyoShokaiSource.class)
                .checkListInfo(info)
                .checkListLineItemSet(pairs)
                .reportId(ReportIdKeys.国内転入者調査票照会.value())
                .addBreak(new KokugaiTennyushaChosahyoShokaiPageBreak())
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

        氏名１("listShimei1_1", "氏名１", CheckShubetsu.文字切れ),
        氏名２("listShimei2_1", "氏名２", CheckShubetsu.文字切れ),
        氏名３("listShimei3_1", "氏名３", CheckShubetsu.文字切れ),
        当住所１("listJusho1_1", "当住所１", CheckShubetsu.文字切れ),
        当住所２("listJusho2_1", "当住所２", CheckShubetsu.文字切れ),
        当住所３("listJusho3_1", "当住所３", CheckShubetsu.文字切れ),
        転出元住所１("listJusho1_2", "転出元住所１", CheckShubetsu.文字切れ),
        転出元住所２("listJusho2_2", "転出元住所２", CheckShubetsu.文字切れ),
        転出元住所３("listJusho3_2", "転出元住所３", CheckShubetsu.文字切れ),
        本籍住所1("listHonseki1_1", "本籍住所1", CheckShubetsu.文字切れ),
        本籍住所2("listHonseki2_1", "本籍住所2", CheckShubetsu.文字切れ),
        本籍住所3("listHonseki3_1", "本籍住所3", CheckShubetsu.文字切れ);

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
