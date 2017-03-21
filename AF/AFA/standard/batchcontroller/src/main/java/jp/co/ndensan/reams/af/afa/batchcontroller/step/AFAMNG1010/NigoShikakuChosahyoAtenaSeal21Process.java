/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.AtenaSeal21Param;
import jp.co.ndensan.reams.af.afa.business.core.AtenaSealParamBuilder;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE214.AtenaSeal21Report;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.kokumintohyoji.KokuminTohyojiMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.kokumintohyoji.AFABTG101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.kokumintohyoji.MitorokushaMasshoTsuchiListEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE214.AtenaSeal21Source;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.KosekiShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.IBatchReportWriterWithCheckList;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.CheckListInfoFactory;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.CheckListLineItemSet;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.CheckShubetsu;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.ICheckListInfo;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.ICheckTarget;
import jp.co.ndensan.reams.ur.urz.business.report.checklist.ISpecificKey;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * @author zhoujie3
 */
public class NigoShikakuChosahyoAtenaSeal21Process extends BatchProcessBase<MitorokushaMasshoTsuchiListEntity> {

    private KokuminTohyojiMybatisParameter mybatisParameter;
    private AFABTG101SelectProcessParameter parameter;

    private AtenaSealParamBuilder builder;

    private static final RString 画面ID = new RString("AFAGMG1010");

    @BatchWriter
    private IBatchReportWriterWithCheckList<AtenaSeal21Source> btchReportWriter;
    private ReportSourceWriter<AtenaSeal21Source> reportSouceWriter;

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
        mybatisParameter = parameter.toBatchMybatisParameter(shikibetsuTaishoPSMSearchKey, null);
        pageCount = new OutputParameter<>();
        builder = new AtenaSealParamBuilder(AssociationFinderFactory.createInstance().getAssociation(), 画面ID);
    }

    @Override
    protected void process(MitorokushaMasshoTsuchiListEntity entity) {
        AtenaSeal21Param param = builder.addDataForAtenaSeal21Param(entity.getSenkyoninMeiboEntity(), entity.getShikibetsuTaishoEntity());
        if (param != null) {
            AtenaSeal21Report atenaSealReport = new AtenaSeal21Report(param);
            atenaSealReport.writeBy(reportSouceWriter);
        }
    }

    @Override
    protected void afterExecute() {
        AtenaSeal21Param param = builder.lastForAtenaSeal21Param();
        if (param != null) {
            AtenaSeal21Report atenaSealReport = new AtenaSeal21Report(param);
            atenaSealReport.writeBy(reportSouceWriter);
        }
        pageCount.setValue(btchReportWriter.getPageCount());
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

    private void create文字切れ一覧表に出力Writer() {
        CheckListLineItemSet pairs = CheckListLineItemSet.of(
                特定項目宛名シール21面.class,
                チェック項目宛名シール21面.class
        );
        ICheckListInfo info = CheckListInfoFactory.createInstance(
                SubGyomuCode.AFA選挙本体,
                AssociationFinderFactory.createInstance().getAssociation());

        btchReportWriter = BatchWriters
                .batchReportWriterWithCheckList(AtenaSeal21Source.class)
                .checkListInfo(info)
                .checkListLineItemSet(pairs)
                .reportId(ReportIdKeys.AFAPRE214_宛名シール2号資格調査票.value())
                .build();
    }

    private enum 特定項目宛名シール21面 implements ISpecificKey {

        識別コード1("shikibetsuCode_1", "識別コード1"),
        識別コード2("shikibetsuCode_2", "識別コード2"),
        識別コード3("shikibetsuCode_3", "識別コード3"),
        識別コード4("shikibetsuCode_4", "識別コード4"),
        識別コード5("shikibetsuCode_5", "識別コード5"),
        識別コード6("shikibetsuCode_6", "識別コード6"),
        識別コード7("shikibetsuCode_7", "識別コード7"),
        識別コード8("shikibetsuCode_8", "識別コード8"),
        識別コード9("shikibetsuCode_9", "識別コード9"),
        識別コード10("shikibetsuCode_10", "識別コード10"),
        識別コード11("shikibetsuCode_11", "識別コード11"),
        識別コード12("shikibetsuCode_12", "識別コード12"),
        識別コード13("shikibetsuCode_13", "識別コード13"),
        識別コード14("shikibetsuCode_14", "識別コード14"),
        識別コード15("shikibetsuCode_15", "識別コード15"),
        識別コード16("shikibetsuCode_16", "識別コード16"),
        識別コード17("shikibetsuCode_17", "識別コード17"),
        識別コード18("shikibetsuCode_18", "識別コード18"),
        識別コード19("shikibetsuCode_19", "識別コード19"),
        識別コード20("shikibetsuCode_20", "識別コード20"),
        識別コード21("shikibetsuCode_21", "識別コード21");

        private final RString itemName;
        private final RString printName;

        private 特定項目宛名シール21面(String itemName, String printName) {
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

    private enum チェック項目宛名シール21面 implements ICheckTarget {

        target1("jushoList1", "住所1", CheckShubetsu.文字切れ),
        target2("jushoList2", "住所2", CheckShubetsu.文字切れ),
        target3("jushoList3", "住所3", CheckShubetsu.文字切れ),
        target4("jushoList4", "住所4", CheckShubetsu.文字切れ),
        target5("jushoList5", "住所5", CheckShubetsu.文字切れ),
        target6("jushoList6", "住所6", CheckShubetsu.文字切れ),
        target7("jushoList7", "住所7", CheckShubetsu.文字切れ),
        target8("jushoList8", "住所8", CheckShubetsu.文字切れ),
        target9("jushoList9", "住所9", CheckShubetsu.文字切れ),
        target10("jushoList10", "住所10", CheckShubetsu.文字切れ),
        target11("jushoList11", "住所11", CheckShubetsu.文字切れ),
        target12("jushoList12", "住所12", CheckShubetsu.文字切れ),
        target13("jushoList13", "住所13", CheckShubetsu.文字切れ),
        target14("jushoList14", "住所14", CheckShubetsu.文字切れ),
        target15("jushoList15", "住所15", CheckShubetsu.文字切れ),
        target16("jushoList16", "住所16", CheckShubetsu.文字切れ),
        target17("jushoList17", "住所17", CheckShubetsu.文字切れ),
        target18("jushoList18", "住所18", CheckShubetsu.文字切れ),
        target19("jushoList19", "住所19", CheckShubetsu.文字切れ),
        target20("jushoList20", "住所20", CheckShubetsu.文字切れ),
        target21("jushoList21", "住所21", CheckShubetsu.文字切れ),
        target22("meishoList1", "氏名1", CheckShubetsu.文字切れ),
        target23("meishoList2", "氏名2", CheckShubetsu.文字切れ),
        target24("meishoList3", "氏名3", CheckShubetsu.文字切れ),
        target25("meishoList4", "氏名4", CheckShubetsu.文字切れ),
        target26("meishoList5", "氏名5", CheckShubetsu.文字切れ),
        target27("meishoList6", "氏名6", CheckShubetsu.文字切れ),
        target28("meishoList7", "氏名7", CheckShubetsu.文字切れ),
        target29("meishoList8", "氏名8", CheckShubetsu.文字切れ),
        target30("meishoList9", "氏名9", CheckShubetsu.文字切れ),
        target31("meishoList10", "氏名10", CheckShubetsu.文字切れ),
        target32("meishoList11", "氏名11", CheckShubetsu.文字切れ),
        target33("meishoList12", "氏名12", CheckShubetsu.文字切れ),
        target34("meishoList13", "氏名13", CheckShubetsu.文字切れ),
        target35("meishoList14", "氏名14", CheckShubetsu.文字切れ),
        target36("meishoList15", "氏名15", CheckShubetsu.文字切れ),
        target37("meishoList16", "氏名16", CheckShubetsu.文字切れ),
        target38("meishoList17", "氏名17", CheckShubetsu.文字切れ),
        target39("meishoList18", "氏名18", CheckShubetsu.文字切れ),
        target40("meishoList19", "氏名19", CheckShubetsu.文字切れ),
        target41("meishoList20", "氏名20", CheckShubetsu.文字切れ),
        target42("meishoList21", "氏名21", CheckShubetsu.文字切れ);

        private final RString itemName;
        private final RString printName;
        private final CheckShubetsu checkShubetsu;

        private チェック項目宛名シール21面(String itemName, String printName, CheckShubetsu checkShubetsu) {
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
