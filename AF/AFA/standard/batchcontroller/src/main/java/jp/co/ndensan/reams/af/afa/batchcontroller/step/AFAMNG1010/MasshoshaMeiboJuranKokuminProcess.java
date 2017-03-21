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
import jp.co.ndensan.reams.af.afa.business.report.AFAPRA106.ShinkiTorokushaMeiboJuranParameter;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRA106.ShinkiTorokushaMeiboJuranReport;
import jp.co.ndensan.reams.af.afa.business.teijitouroku.TeijiCommonJohoItem;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.CautionshaSearchKubun;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ToriatsukaiChuishaShutsurokuHoshikiConfig;
import static jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ToriatsukaiChuishaShutsurokuHoshikiConfig.行を詰める;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.kokumintohyoji.KokuminTohyojiMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.kokumintohyoji.AFABTG101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101.TorokushaMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRA106.ShinkiTorokushaMeiboJuranSource;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.KosekiShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.cautionsha.UaFt400FindeCautionShaMapperEntity;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.IBatchReportWriterWithCheckList;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.CheckListInfoFactory;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.CheckListLineItemSet;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.CheckShubetsu;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.ICheckListInfo;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.ICheckTarget;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.ISpecificKey;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender.FEMALE;
import static jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.Gender.MALE;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
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
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 抹消者名簿（縦覧）のプロセスクラスです。
 *
 * @reamsid_L AF-0360-052 qiuxy
 */
public class MasshoshaMeiboJuranKokuminProcess extends BatchKeyBreakBase<TorokushaMeiboEntity> {

    private static final RString 出力区分_空白行 = new RString("空白行");
    private static final RString 出力区分_データ = new RString("データ");
    private static final RString 出力区分_集計行 = new RString("集計行");
    private AFABTG101SelectProcessParameter parameter;
    private KokuminTohyojiMybatisParameter mybatisParameter;
    private RString 取扱注意者の出力方式;
    private TorokushaMeiboEntity beforeEntity;
    private TeijiCommonJohoItem 帳票共通ヘッダー;
    private Decimal 男性の計;
    private Decimal 女性の計;

    @BatchWriter
    private IBatchReportWriterWithCheckList<ShinkiTorokushaMeiboJuranSource> batchReportWriter;
    private ReportSourceWriter<ShinkiTorokushaMeiboJuranSource> reportSourceWriter;

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
        住民種別.add(JuminShubetsu.日本人);
        ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.未定義);
        build.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        build.set基準日(parameter.get基準日());
        build.set住民種別(住民種別);
        build.set戸籍取得区分(KosekiShutokuKubun.戸籍情報を取得する);
        IShikibetsuTaishoPSMSearchKey searchKey = build.build();
        mybatisParameter = parameter.toBatchMybatisParameter(searchKey, searchKey);
        mybatisParameter.setRiyoKubun(CautionshaSearchKubun.利用区分.getCode());
        mybatisParameter.setChushutsuKubun(CautionshaSearchKubun.抽出区分.getCode());
        FlexibleDate kijunbi = parameter.get基準日();
        RDateTime 基準日 = RDateTime.of(kijunbi.getYearValue(), kijunbi.getMonthValue(), kijunbi.getDayValue(), 01, 01);
        mybatisParameter.set基準日(kijunbi.plusDay(1));
        mybatisParameter.setKonkaiChushutsu(基準日);
        mybatisParameter.setZenkaiChushutsu(基準日);
        mybatisParameter.setChuiShuruiCode(CautionshaSearchKubun.注意種類コード.getCode());
        mybatisParameter.setYukoKigenKubun(CautionshaSearchKubun.有効期限.getCode());
        帳票共通ヘッダー = new ReportHeadEditor().create帳票共通ヘッダー();
        帳票共通ヘッダー.set帳票ID(ReportIdKeys.抹消者名簿縦覧国民.value());
        pageCount = new OutputParameter<>();
        取扱注意者の出力方式 = BusinessConfig.get(
                ToriatsukaiChuishaShutsurokuHoshikiConfig.取扱注意者_出力方式, RDate.getNowDate(), SubGyomuCode.AFA選挙本体);
        男性の計 = Decimal.ZERO;
        女性の計 = Decimal.ZERO;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(new RString(
                "jp.co.ndensan.reams.af.afa.persistence.db.mapper.kokumintohyoji.IAFABTG101Mapper.selectMasshoshaMeibo"),
                mybatisParameter);
    }

    @Override
    protected void createWriter() {
        create文字切れ一覧表に出力Writer();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void usualProcess(TorokushaMeiboEntity entity) {
        set空白行判断(entity);
        set取扱い注意者判断(entity);
    }

    @Override
    protected void keyBreakProcess(TorokushaMeiboEntity entity) {
    }

    @Override
    protected void afterExecute() {
        if (男性の計 != Decimal.ZERO || 女性の計 != Decimal.ZERO) {
            add空白行();
            ShinkiTorokushaMeiboJuranParameter 集計行 = new ShinkiTorokushaMeiboJuranParameter(beforeEntity,
                    出力区分_集計行, 帳票共通ヘッダー, RString.EMPTY);

            RStringBuilder 集計 = new RStringBuilder();
            集計.append("** 誤載 **［男").append(DecimalFormatter.toコンマ区切りRString(男性の計, 0))
                    .append("人］［女").append(DecimalFormatter.toRString(女性の計, 0)).append("人］" + "［計")
                    .append(DecimalFormatter.toコンマ区切りRString(男性の計.add(女性の計), 0)).append("人］");
            集計行.set集計(集計.toRString());
            ShinkiTorokushaMeiboJuranReport report = new ShinkiTorokushaMeiboJuranReport(集計行);
            report.writeBy(reportSourceWriter);
            pageCount.setValue(batchReportWriter.getPageCount());
        } else {
            pageCount.setValue(0);
        }
    }

    private void add空白行() {
        ShinkiTorokushaMeiboJuranParameter param = new ShinkiTorokushaMeiboJuranParameter(beforeEntity, 出力区分_空白行, 帳票共通ヘッダー, RString.EMPTY);
        ShinkiTorokushaMeiboJuranReport report = new ShinkiTorokushaMeiboJuranReport(param);
        report.writeBy(reportSourceWriter);
    }

    private void set取扱い注意者判断(TorokushaMeiboEntity entity) {
        UaFt400FindeCautionShaMapperEntity findeCautionShaMapperEntity = entity.getFindeCautionShaMapperEntity();
        if (findeCautionShaMapperEntity != null && findeCautionShaMapperEntity.isGaitoKubun()) {
            if (行を詰める.getValue().equals(取扱注意者の出力方式)) {
                return;
            }
            set集計行(entity);
            ShinkiTorokushaMeiboJuranParameter param = new ShinkiTorokushaMeiboJuranParameter(entity,
                    取扱注意者の出力方式, 帳票共通ヘッダー, RString.EMPTY);
            ShinkiTorokushaMeiboJuranReport report = new ShinkiTorokushaMeiboJuranReport(param);
            report.writeBy(reportSourceWriter);
            beforeEntity = entity;
        } else {
            set集計行(entity);
            ShinkiTorokushaMeiboJuranParameter param = new ShinkiTorokushaMeiboJuranParameter(entity,
                    出力区分_データ, 帳票共通ヘッダー, RString.EMPTY);
            ShinkiTorokushaMeiboJuranReport report = new ShinkiTorokushaMeiboJuranReport(param);
            report.writeBy(reportSourceWriter);
            beforeEntity = entity;
        }
    }

    private void set集計行(TorokushaMeiboEntity entity) {
        RString 性別 = entity.getShikibetsuTaishoEntity().getSeibetsuCode();
        if (FEMALE.getCode().equals(性別)) {
            女性の計 = 女性の計.add(1);
        } else if (MALE.getCode().equals(性別)) {
            男性の計 = 男性の計.add(1);
        }
    }

    private List<RString> get改頁キーリスト() {
        return Collections.unmodifiableList(Arrays.asList(new RString(ShinkiTorokushaMeiboJuranSource.ReportSourceFields.subTitle.name())));
    }

    private void set空白行判断(TorokushaMeiboEntity entity) {
        if (null == beforeEntity) {
            return;
        }
        RString 投票区コード = entity.getSenkyoninMeiboEntity().getTohyokuCode();
        if (!投票区コード.equals(beforeEntity.getSenkyoninMeiboEntity().getTohyokuCode())) {
            add空白行();
        }
    }

    private void create文字切れ一覧表に出力Writer() {
        CheckListLineItemSet pairs = CheckListLineItemSet.of(
                MasshoshaMeiboJuranKokuminProcess.特定項目.class,
                MasshoshaMeiboJuranKokuminProcess.チェック項目.class);
        ICheckListInfo info = CheckListInfoFactory.createInstance(
                SubGyomuCode.AFA選挙本体,
                AssociationFinderFactory.createInstance().getAssociation());

        batchReportWriter = BatchWriters
                .batchReportWriterWithCheckList(ShinkiTorokushaMeiboJuranSource.class)
                .checkListInfo(info)
                .checkListLineItemSet(pairs)
                .reportId(ReportIdKeys.抹消者名簿縦覧国民.value())
                .addBreak(new BreakerCatalog<ShinkiTorokushaMeiboJuranSource>().simplePageBreaker(get改頁キーリスト()))
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

        target1("listMeisai1_3", "住所", CheckShubetsu.文字切れ),
        target2("listMeisai1_4", "氏名", CheckShubetsu.文字切れ);

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
