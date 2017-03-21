/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNG1010;

import jp.co.ndensan.reams.af.afa.business.core.AtenaSeal12Param;
import jp.co.ndensan.reams.af.afa.business.core.AtenaSealParamBuilder;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE213.AtenaSeal12Report;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.kokumintohyoji.KokuminTohyojiMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.kokumintohyoji.AFABTG101SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101.TorokushaMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE213.AtenaSeal12Source;
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
public class ShinkiTorokushaMeiboKokuminAtenaSeal12Process extends BatchProcessBase<TorokushaMeiboEntity> {

    private KokuminTohyojiMybatisParameter mybatisParameter;
    private AFABTG101SelectProcessParameter parameter;

    private AtenaSealParamBuilder builder;

    private static final RString 画面ID = new RString("AFAGMG1010");
    @BatchWriter
    private IBatchReportWriterWithCheckList<AtenaSeal12Source> btchReportWriter;
    private ReportSourceWriter<AtenaSeal12Source> reportSouceWriter;
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
        ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.未定義);
        build.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        build.set基準日(parameter.get基準日());
        build.set戸籍取得区分(KosekiShutokuKubun.戸籍情報を取得する);
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = build.build();
        mybatisParameter = parameter.toBatchMybatisParameter(shikibetsuTaishoPSMSearchKey, shikibetsuTaishoPSMSearchKey);
        mybatisParameter.set基準日(parameter.get基準日().plusDay(2));
        pageCount = new OutputParameter<>();
        builder = new AtenaSealParamBuilder(AssociationFinderFactory.createInstance().getAssociation(), 画面ID);
    }

    @Override
    protected void process(TorokushaMeiboEntity entity) {
        AtenaSeal12Param param = builder.addDataForAtenaSeal12Param(entity.getSenkyoninMeiboEntity(), entity.getShikibetsuTaishoEntity());
        if (param != null) {
            AtenaSeal12Report atenaSealReport = new AtenaSeal12Report(param);
            atenaSealReport.writeBy(reportSouceWriter);
        }
    }

    @Override
    protected void afterExecute() {
        AtenaSeal12Param param = builder.lastForAtenaSeal12Param();
        if (param != null) {
            AtenaSeal12Report atenaSealReport = new AtenaSeal12Report(param);
            atenaSealReport.writeBy(reportSouceWriter);
        }
        pageCount.setValue(btchReportWriter.getPageCount());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(new RString(
                "jp.co.ndensan.reams.af.afa.persistence.db.mapper.kokumintohyoji.IAFABTG101Mapper.selectHoseiTorokushaMeiboKokumin"),
                mybatisParameter);
    }

    @Override
    protected void createWriter() {
        create文字切れ一覧表に出力Writer();
        reportSouceWriter = new ReportSourceWriter<>(btchReportWriter);

    }

    private void create文字切れ一覧表に出力Writer() {
        CheckListLineItemSet pairs = CheckListLineItemSet.of(
                特定項目宛名シール12面.class,
                チェック項目宛名シール12面.class
        );
        ICheckListInfo info = CheckListInfoFactory.createInstance(
                SubGyomuCode.AFA選挙本体,
                AssociationFinderFactory.createInstance().getAssociation());

        btchReportWriter = BatchWriters
                .batchReportWriterWithCheckList(AtenaSeal12Source.class)
                .checkListInfo(info)
                .checkListLineItemSet(pairs)
                .reportId(ReportIdKeys.AFAPRE213_補正登録者宛名シール.value())
                .build();
    }

    private enum 特定項目宛名シール12面 implements ISpecificKey {

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
        識別コード12("shikibetsuCode_12", "識別コード12");

        private final RString itemName;
        private final RString printName;

        private 特定項目宛名シール12面(String itemName, String printName) {
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

    private enum チェック項目宛名シール12面 implements ICheckTarget {

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
        target13("meishoList1", "氏名1", CheckShubetsu.文字切れ),
        target14("meishoList2", "氏名2", CheckShubetsu.文字切れ),
        target15("meishoList3", "氏名3", CheckShubetsu.文字切れ),
        target16("meishoList4", "氏名4", CheckShubetsu.文字切れ),
        target17("meishoList5", "氏名5", CheckShubetsu.文字切れ),
        target18("meishoList6", "氏名6", CheckShubetsu.文字切れ),
        target19("meishoList7", "氏名7", CheckShubetsu.文字切れ),
        target20("meishoList8", "氏名8", CheckShubetsu.文字切れ),
        target21("meishoList9", "氏名9", CheckShubetsu.文字切れ),
        target22("meishoList10", "氏名10", CheckShubetsu.文字切れ),
        target23("meishoList11", "氏名11", CheckShubetsu.文字切れ),
        target24("meishoList12", "氏名12", CheckShubetsu.文字切れ);

        private final RString itemName;
        private final RString printName;
        private final CheckShubetsu checkShubetsu;

        private チェック項目宛名シール12面(String itemName, String printName, CheckShubetsu checkShubetsu) {
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
