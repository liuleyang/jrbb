/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB2010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.AtenaSeal12Param;
import jp.co.ndensan.reams.af.afa.business.core.AtenaSealPartParam;
import jp.co.ndensan.reams.af.afa.business.core.nyujokenikkatsu.NyujokenIkkatsuEditor;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE213.AtenaSeal12Report;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.nyujokenikkatsu.AFABTB201SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.nyujokenikkatsu.NyujokenIkkatsuMybatisParameter;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE213.AtenaSeal12Source;
import jp.co.ndensan.reams.af.afa.entity.xml.nyujokenikkatsu.AFABTB201MeiciJyohouSoufusakiEntity;
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
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 宛名シール（12面）のクラスです。
 *
 * @reamsid_L AF-0620-020 guancy
 */
public class NyujokenIkkatsuAtenaSeal12ReportProcess extends BatchProcessBase<AFABTB201MeiciJyohouSoufusakiEntity> {

    private NyujokenIkkatsuMybatisParameter mybatisParameter;
    private AFABTB201SelectProcessParameter parameter;
    private static final RString 入場券発行一括_画面ID = new RString("AFAGMB2010");
    private static final int ページ件数12面_THREE = 3;
    private static final int ページ件数12面_FOUR = 4;
    private static final int ページ件数12面_FIVE = 5;
    private static final int ページ件数12面_SIX = 6;
    private static final int ページ件数12面_SEVEN = 7;
    private static final int ページ件数12面_EIGHT = 8;
    private static final int ページ件数12面_NINE = 9;
    private static final int ページ件数12面_TEN = 10;
    private static final int ページ件数12面_ELEVEN = 11;
    private static final int ページ件数12面_TWELVE = 12;
    private int indexCount;
    private int indexPage;
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.nyujokenikkatsu.INyujokenIkkatsuMapper.selectMeiciJyohouSoufusakiTempTable");
    @BatchWriter
    private IBatchReportWriterWithCheckList<AtenaSeal12Source> batchReportWCLWriter;
    private ReportSourceWriter<AtenaSeal12Source> reportSourceWCLWriter;
    /**
     * 地図情報イメージファイル取得。
     *
     */
    public static final RString IMAGE_FOLDER_PATH;

    static {
        IMAGE_FOLDER_PATH = new RString("imageFolderPath");
    }
    private OutputParameter<List<RString>> imageFolderPath;
    /**
     * ページ数Parameterです。
     */
    public static final RString NYUJOKEN_REPORT_INDEX;

    static {
        NYUJOKEN_REPORT_INDEX = new RString("nyujokenReportIndex");
    }
    /**
     * ページ数Parameterです。
     */
    public static final RString PAGE_COUNT;

    static {
        PAGE_COUNT = new RString("pageCount");
    }
    OutputParameter<Integer> pageCount;
    OutputParameter<Decimal> nyujokenReportIndex;
    private int itemCount;
    private AtenaSeal12Param param;
    private Association 地方公共団体情報;
    private boolean isFirstItem;

    @Override
    protected void initialize() {
        ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.住登外優先);
        build.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = build.build();
        parameter.setKey(shikibetsuTaishoPSMSearchKey);
        mybatisParameter = parameter.toNyujokenIkkatsuMybatisParameter();
        mybatisParameter.setTable(parameter.getTable());
        mybatisParameter.setTable1(parameter.getSoufusakiJouhoutable());
        mybatisParameter.setGroupKubun(parameter.getGroupKubun());
        itemCount = 0;
        indexCount = 0;
        indexPage = 1;
        isFirstItem = Boolean.TRUE;
        pageCount = new OutputParameter<>();
        nyujokenReportIndex = new OutputParameter<>();
        imageFolderPath = new OutputParameter<>();
        IAssociationFinder associationFinder = AssociationFinderFactory.createInstance();
        地方公共団体情報 = associationFinder.getAssociation();
        param = new AtenaSeal12Param(地方公共団体情報, 入場券発行一括_画面ID);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        create文字切れ一覧表に出力Writer();
        reportSourceWCLWriter = new ReportSourceWriter<>(batchReportWCLWriter);

    }

    @Override
    protected void process(AFABTB201MeiciJyohouSoufusakiEntity 宛名シール12面) {
        get宛名シール情報(宛名シール12面);

    }

    private void get宛名シール情報(AFABTB201MeiciJyohouSoufusakiEntity 宛名シール12面) {
        indexCount++;
        int 開始印字位置番号 = 0;
        if (isFirstItem && 開始印字位置番号 != 0) {
            itemCount = itemCount + 開始印字位置番号 - 1;
            isFirstItem = Boolean.FALSE;
        }
        NyujokenIkkatsuEditor editor = new NyujokenIkkatsuEditor();
        if (itemCount != ページ件数12面_TWELVE) {
            get宛名シール12面情報(宛名シール12面, editor);
        } else if (itemCount == ページ件数12面_TWELVE) {
            AtenaSeal12Report report = new AtenaSeal12Report(param);
            report.writeBy(reportSourceWCLWriter);
            param = new AtenaSeal12Param(地方公共団体情報, 入場券発行一括_画面ID);
            itemCount = 0;
            indexPage++;
            if (開始印字位置番号 != 0) {
                itemCount = itemCount + 開始印字位置番号 - 1;
            }
            get宛名シール12面情報(宛名シール12面, editor);
        }
    }

    private void get宛名シール12面情報(
            AFABTB201MeiciJyohouSoufusakiEntity 宛名シール12面情報,
            NyujokenIkkatsuEditor editor) {
        if (itemCount == 0) {
            AtenaSealPartParam 宛名シール12面_1 = new AtenaSealPartParam();
            宛名シール12面_1.set通し番号(new RString(indexCount));
            宛名シール12面_1.set投票資格情報(editor.get投票資格情報(宛名シール12面情報));
            param.set頁番号(indexPage);
            param.setParam1(宛名シール12面_1);
            itemCount++;
        } else if (itemCount == 1) {
            AtenaSealPartParam 宛名シール12面_2 = new AtenaSealPartParam();
            宛名シール12面_2.set通し番号(new RString(indexCount));
            宛名シール12面_2.set投票資格情報(editor.get投票資格情報(宛名シール12面情報));
            param.set頁番号(indexPage);
            param.setParam2(宛名シール12面_2);
            itemCount++;
        } else if (itemCount == 2) {
            AtenaSealPartParam 宛名シール12面_3 = new AtenaSealPartParam();
            宛名シール12面_3.set通し番号(new RString(indexCount));
            宛名シール12面_3.set投票資格情報(editor.get投票資格情報(宛名シール12面情報));
            param.set頁番号(indexPage);
            param.setParam3(宛名シール12面_3);
            itemCount++;
        } else if (itemCount == ページ件数12面_THREE) {
            AtenaSealPartParam 宛名シール12面_4 = new AtenaSealPartParam();
            宛名シール12面_4.set通し番号(new RString(indexCount));
            宛名シール12面_4.set投票資格情報(editor.get投票資格情報(宛名シール12面情報));
            param.set頁番号(indexPage);
            param.setParam4(宛名シール12面_4);
            itemCount++;
        } else if (itemCount == ページ件数12面_FOUR) {
            AtenaSealPartParam 宛名シール12面_5 = new AtenaSealPartParam();
            宛名シール12面_5.set通し番号(new RString(indexCount));
            宛名シール12面_5.set投票資格情報(editor.get投票資格情報(宛名シール12面情報));
            param.set頁番号(indexPage);
            param.setParam5(宛名シール12面_5);
            itemCount++;
        } else if (itemCount == ページ件数12面_FIVE) {
            AtenaSealPartParam 宛名シール12面_6 = new AtenaSealPartParam();
            宛名シール12面_6.set通し番号(new RString(indexCount));
            宛名シール12面_6.set投票資格情報(editor.get投票資格情報(宛名シール12面情報));
            param.set頁番号(indexPage);
            param.setParam6(宛名シール12面_6);
            itemCount++;
        } else if (itemCount == ページ件数12面_SIX) {
            AtenaSealPartParam 宛名シール12面_7 = new AtenaSealPartParam();
            宛名シール12面_7.set通し番号(new RString(indexCount));
            宛名シール12面_7.set投票資格情報(editor.get投票資格情報(宛名シール12面情報));
            param.set頁番号(indexPage);
            param.setParam7(宛名シール12面_7);
            itemCount++;
        } else if (itemCount == ページ件数12面_SEVEN) {
            AtenaSealPartParam 宛名シール12面_8 = new AtenaSealPartParam();
            宛名シール12面_8.set通し番号(new RString(indexCount));
            宛名シール12面_8.set投票資格情報(editor.get投票資格情報(宛名シール12面情報));
            param.set頁番号(indexPage);
            param.setParam8(宛名シール12面_8);
            itemCount++;
        } else if (itemCount == ページ件数12面_EIGHT) {
            AtenaSealPartParam 宛名シール12面_9 = new AtenaSealPartParam();
            宛名シール12面_9.set通し番号(new RString(indexCount));
            宛名シール12面_9.set投票資格情報(editor.get投票資格情報(宛名シール12面情報));
            param.set頁番号(indexPage);
            param.setParam9(宛名シール12面_9);
            itemCount++;
        } else if (itemCount == ページ件数12面_NINE) {
            AtenaSealPartParam 宛名シール12面_10 = new AtenaSealPartParam();
            宛名シール12面_10.set通し番号(new RString(indexCount));
            宛名シール12面_10.set投票資格情報(editor.get投票資格情報(宛名シール12面情報));
            param.set頁番号(indexPage);
            param.setParam10(宛名シール12面_10);
            itemCount++;
        } else if (itemCount == ページ件数12面_TEN) {
            AtenaSealPartParam 宛名シール12面_11 = new AtenaSealPartParam();
            宛名シール12面_11.set通し番号(new RString(indexCount));
            宛名シール12面_11.set投票資格情報(editor.get投票資格情報(宛名シール12面情報));
            param.set頁番号(indexPage);
            param.setParam11(宛名シール12面_11);
            itemCount++;
        } else if (itemCount == ページ件数12面_ELEVEN) {
            AtenaSealPartParam 宛名シール12面_12 = new AtenaSealPartParam();
            宛名シール12面_12.set通し番号(new RString(indexCount));
            宛名シール12面_12.set投票資格情報(editor.get投票資格情報(宛名シール12面情報));
            param.set頁番号(indexPage);
            param.setParam12(宛名シール12面_12);
            itemCount++;
        }
    }

    @Override
    protected void afterExecute() {
        if (isHasデータ(param)) {
            AtenaSeal12Report report = new AtenaSeal12Report(param);
            report.writeBy(reportSourceWCLWriter);
        }
        RString コピー元パースチェックリスト = batchReportWCLWriter.getImageFolderPath();

        List<RString> イメージファイルパース = new ArrayList<>();

        if (!RString.isNullOrEmpty(コピー元パースチェックリスト)) {
            イメージファイルパース.add(コピー元パースチェックリスト);
        }
        imageFolderPath.setValue(イメージファイルパース);
        Decimal 入場券発行固有連番_チェック = batchReportWCLWriter.getReportIndex().getReportIndex();
        nyujokenReportIndex.setValue(入場券発行固有連番_チェック);
        pageCount.setValue(batchReportWCLWriter.getPageCount());
    }

    private Boolean isHasデータ(AtenaSeal12Param 宛名シール12面) {
        if (宛名シール12面.getParam1() != null) {
            return Boolean.TRUE;
        }
        if (宛名シール12面.getParam2() != null) {
            return Boolean.TRUE;
        }
        if (宛名シール12面.getParam3() != null) {
            return Boolean.TRUE;
        }
        if (宛名シール12面.getParam4() != null) {
            return Boolean.TRUE;
        }
        if (宛名シール12面.getParam5() != null) {
            return Boolean.TRUE;
        }
        if (宛名シール12面.getParam6() != null) {
            return Boolean.TRUE;
        }
        if (宛名シール12面.getParam7() != null) {
            return Boolean.TRUE;
        }
        if (宛名シール12面.getParam8() != null) {
            return Boolean.TRUE;
        }
        if (宛名シール12面.getParam9() != null) {
            return Boolean.TRUE;
        }
        if (宛名シール12面.getParam10() != null) {
            return Boolean.TRUE;
        }
        if (宛名シール12面.getParam11() != null) {
            return Boolean.TRUE;
        }
        if (宛名シール12面.getParam12() != null) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;

    }

    private void create文字切れ一覧表に出力Writer() {
        CheckListLineItemSet pairs = CheckListLineItemSet.of(
                NyujokenIkkatsuAtenaSeal12ReportProcess.特定項目.class,
                NyujokenIkkatsuAtenaSeal12ReportProcess.チェック項目.class
        );
        ICheckListInfo info = CheckListInfoFactory.createInstance(
                SubGyomuCode.AFA選挙本体,
                AssociationFinderFactory.createInstance().getAssociation());

        batchReportWCLWriter = BatchWriters
                .batchReportWriterWithCheckList(AtenaSeal12Source.class)
                .checkListInfo(info)
                .checkListLineItemSet(pairs)
                .reportId(ReportIdKeys.AFAPRE213_宛名シール12面.value())
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

        target1("jushoList", "住所", CheckShubetsu.文字切れ),
        target2("meishoList", "氏名", CheckShubetsu.文字切れ);

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
