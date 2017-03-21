/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE2050;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.ShisetsuSofushoGamenJoho;
import jp.co.ndensan.reams.af.afa.business.core.ShisetsuSofushoParam;
import jp.co.ndensan.reams.af.afa.business.core.shisetsusofusho.ShisetsuSofushoBusinessEditor;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE205.ShisetsuSofushoReport;
import jp.co.ndensan.reams.af.afa.definition.batchprm.shisetsusofusho.AFABTE205BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.configkeys.AFAConfigKeysValue;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.processprm.shisetsusofusho.AFABTE205SelectProcessMyBatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.shisetsusofusho.AFABTE205SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.shisetsusofusho.ShisetsusofushoEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE205.LayoutBreakItems;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE205.ShisetsuSofushoSource;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.shisetsusofusho.IShisetsuSofushoMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.af.afa.service.nyujokenikkatsu.NyujokenIkkatsuFinder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
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
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 施設送付書発行のクラスです。
 *
 * @reamsid_L AF-0250-020 zhangl
 */
public class ShisetsuSofushoReportProcess extends BatchKeyBreakBase<ShisetsusofushoEntity> {

    private AFABTE205BatchParameter parameter;
    private AFABTE205SelectProcessMyBatisParameter mybatisParam;
    private AFABTE205SelectProcessParameter mybatisParam1;
    private IShisetsuSofushoMapper mapper;
    private NyujokenIkkatsuFinder finder;
    private AfaMapperProvider mapperProvider;
    private ShisetsuSofushoGamenJoho 画面情報;
    private Association 地方公共団体;
    private int itemCount;
    private int page;
    private Decimal 人数を集計;
    private List<Decimal> 人数を集計List;
    private int 改ページIndex;
    private List<RString> pageBreakKeys;
    private List<RString> breakKeys;
    private static final int 一頁目最大ページ数 = 20;
    private static final int 二頁目最大ページ数 = 25;
    private static final RString 出力内容_連絡符号１ = new RString("-");
    private static final RString 期日前不在者区分_不在者投票 = new RString("2");
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.shisetsusofusho.IShisetsuSofushoMapper.getShisetsuSofushoList");

    private static final RString 交付施設コード_コード = new RString("0510");
    private static final RString 選挙番号_コード = new RString("0500");

    @BatchWriter
    private IBatchReportWriterWithCheckList<ShisetsuSofushoSource> batchReportWriter;
    private ReportSourceWriter<ShisetsuSofushoSource> reportSourceWriter;

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
        改ページIndex = 0;
        page = 1;
        itemCount = 0;
        人数を集計 = Decimal.ZERO;
        人数を集計List = parameter.get人数リスト();
        pageBreakKeys = new ArrayList<>();
        地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.住登外優先);
        RString 住基連動_氏名 = BusinessConfig.get(ConfigKeysAFA.抄本_住基連動_氏名, SubGyomuCode.AFA選挙本体);
        mybatisParam1 = parameter.toAFABTE205SelectProcessParameter();
        finder = NyujokenIkkatsuFinder.createInstance();
        AfT100ShohonEntity 抄本 = finder.get抄本情報(new ShohonNo(parameter.get抄本番号()));
        if (抄本 == null) {
            mybatisParam1.set処理年月日(FlexibleDate.EMPTY);
        } else if (抄本.getShoriYMD() == null) {
            mybatisParam1.set処理年月日(FlexibleDate.EMPTY);
        } else {
            mybatisParam1.set処理年月日(抄本.getShoriYMD());
        }
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
        mapper = mapperProvider.create(IShisetsuSofushoMapper.class);
        mybatisParam1.set抄本番号(new ShohonNo(parameter.get抄本番号()));
        mybatisParam1.set基準年月日(new FlexibleDate(RDate.getNowDate().toDateString()));
        ShisetsusofushoEntity 選挙 = mapper.select選挙の一番未来の日(mybatisParam1);
        if (選挙 == null) {
            mybatisParam1.set基準年月日(FlexibleDate.EMPTY);
        } else if (選挙.get名簿基準年月日() == null) {
            mybatisParam1.set基準年月日(FlexibleDate.EMPTY);
        } else {
            mybatisParam1.set基準年月日(選挙.get名簿基準年月日());
        }
        if (AFAConfigKeysValue.抄本_住基連動_氏名_抄本作成時.configKeyValue().equals(住基連動_氏名)) {
            build.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
            build.set基準日(mybatisParam1.get処理年月日());
        } else if (AFAConfigKeysValue.抄本_住基連動_氏名_基準日時点.configKeyValue().equals(住基連動_氏名)) {
            build.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
            build.set基準日(mybatisParam1.get基準年月日());
        } else if (AFAConfigKeysValue.抄本_住基連動_氏名_最新.configKeyValue().equals(住基連動_氏名)) {
            build.setデータ取得区分(DataShutokuKubun.直近レコード);
        }
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = build.build();
        mybatisParam = new AFABTE205SelectProcessMyBatisParameter(shikibetsuTaishoPSMSearchKey,
                parameter.get施設コード開始(),
                parameter.get施設コード終了(),
                parameter.get交付日開始(),
                parameter.get交付日終了(),
                new ShohonNo(parameter.get抄本番号()),
                RString.EMPTY,
                parameter.is無投票選挙も出力する());
        mybatisParam.set期日前不在者区分(期日前不在者区分_不在者投票);
        mybatisParam.setOrder順(parameter.getOrder順());
        pageCount = new OutputParameter<>();
        画面情報 = new ShisetsuSofushoGamenJoho();
        画面情報.set発行番号(parameter.get発行番号());
        画面情報.set発行日(!parameter.get発行日().isValid() ? null : new RDate(parameter.get発行日().toString()));
        画面情報.set交付日開始(!parameter.get交付日開始().isValid() ? null : new RDate(parameter.get交付日開始().toString()));
        画面情報.set交付日終了(!parameter.get交付日終了().isValid() ? null : new RDate(parameter.get交付日終了().toString()));
        pageBreakKeys.add(new RString(ShisetsuSofushoSource.ReportSourceFields.shisetsuCode.name()));
        pageBreakKeys.add(new RString(ShisetsuSofushoSource.ReportSourceFields.senkyoNo.name()));
        breakKeys = Collections.unmodifiableList(pageBreakKeys);
        List<RString> 改ページキーリスト = new ArrayList<>();
        改ページキーリスト.add(交付施設コード_コード);
        改ページキーリスト.add(選挙番号_コード);
        parameter.set改ページキーリスト(改ページキーリスト);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParam);
    }

    @Override
    protected void createWriter() {
        create文字切れ一覧表に出力Writer();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void keyBreakProcess(ShisetsusofushoEntity entity) {
        ShisetsuSofushoBusinessEditor editor = new ShisetsuSofushoBusinessEditor();
        if (editor.hasBreak(parameter.get改ページキーリスト(), getBefore(), entity) && itemCount != 0) {
            page = 1;
            itemCount = 0;
            改ページIndex++;
        }
    }

    @Override
    protected void usualProcess(ShisetsusofushoEntity entity) {
        if (page == 1 && itemCount == 0) {
            人数を集計 = 人数を集計List.get(改ページIndex);
        }
        entity.set名簿番号(entity.get投票区コード().
                concat(出力内容_連絡符号１).
                concat(new RString(entity.get頁())).
                concat(出力内容_連絡符号１).
                concat(new RString(entity.get行())));
        ShisetsuSofushoParam param = new ShisetsuSofushoParam(画面情報,
                entity, new RString(page),
                new RString(get総ページ数(人数を集計)),
                new RString(人数を集計.intValue()),
                entity.get識別コード());
        param.set施設コード(entity.get施設コード());
        param.set選挙番号(entity.get選挙番号() == null ? RString.EMPTY : new RString(entity.get選挙番号().getColumnValue()));
        param.set地方公共団体情報(地方公共団体);
        ShisetsuSofushoReport report = new ShisetsuSofushoReport(param);
        report.writeBy(reportSourceWriter);
        itemCount++;
        if (page == 1 && itemCount == 一頁目最大ページ数) {
            page++;
            itemCount = 0;
        } else if (page > 1 && itemCount == 二頁目最大ページ数) {
            page++;
            itemCount = 0;
        }
    }

    @Override
    protected void afterExecute() {
        pageCount.setValue(batchReportWriter.getPageCount());
    }

    private int get総ページ数(Decimal 人数を集計) {
        if (new Decimal(一頁目最大ページ数).compareTo(人数を集計) >= 0) {
            return 1;
        } else {
            Decimal 二頁目以降の人数 = 人数を集計.subtract(new Decimal(一頁目最大ページ数));
            Decimal 商 = 二頁目以降の人数.divideAndRemainder(new Decimal(二頁目最大ページ数))[0];
//TODO divideAndRemainderのFWの不具合が修正されたら、元に戻す。
//            Decimal 余数 = 二頁目以降の人数.divideAndRemainder(new Decimal(二頁目最大ページ数))[1];
            Decimal 余数 = 二頁目以降の人数.remainder(new Decimal(二頁目最大ページ数));
            if (Decimal.ZERO.equals(余数)) {
                return 商.add(1).intValue();
            } else {
                return 商.add(2).intValue();
            }
        }
    }

    private void create文字切れ一覧表に出力Writer() {
        CheckListLineItemSet pairs = CheckListLineItemSet.of(
                ShisetsuSofushoReportProcess.特定項目.class,
                ShisetsuSofushoReportProcess.チェック項目.class);
        ICheckListInfo info = CheckListInfoFactory.createInstance(
                SubGyomuCode.AFA選挙本体,
                AssociationFinderFactory.createInstance().getAssociation());

        batchReportWriter = BatchWriters
                .batchReportWriterWithCheckList(ShisetsuSofushoSource.class)
                .checkListInfo(info)
                .checkListLineItemSet(pairs)
                .reportId(ReportIdKeys.AFAPRE205_施設送付書.value())
                .addBreak(new BreakerCatalog<ShisetsuSofushoSource>().simplePageBreaker(breakKeys))
                .addBreak(new BreakerCatalog<ShisetsuSofushoSource>().new SimpleLayoutBreaker(




                    ShisetsuSofushoSource.LAYOUT_BREAK_KEYS) {
                @Override
                    public ReportLineRecord<ShisetsuSofushoSource> occuredBreak(ReportLineRecord<ShisetsuSofushoSource> currentRecord,
                            ReportLineRecord<ShisetsuSofushoSource> nextRecord, ReportDynamicChart dynamicChart) {
                        if (nextRecord.equals(ReportLineRecord.LAST_RECORD)) {
                            return currentRecord;
                        }
                        LayoutBreakItems layout = nextRecord.getSource().layoutBreakItem;
                        nextRecord.setFormGroupIndex(layout.index());
                        return currentRecord;
                    }
                }).build();
    }

    private enum 特定項目 implements ISpecificKey {

        識別コード("shikibetsuCode_1", "識別コード");

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

        target1("jusho", "住所", CheckShubetsu.文字切れ),
        target2("shimei", "氏名", CheckShubetsu.文字切れ);

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
