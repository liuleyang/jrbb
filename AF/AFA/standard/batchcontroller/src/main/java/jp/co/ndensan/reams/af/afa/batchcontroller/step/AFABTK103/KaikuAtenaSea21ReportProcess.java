/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFABTK103;

import jp.co.ndensan.reams.af.afa.business.core.AtenaSeal21Param;
import jp.co.ndensan.reams.af.afa.business.core.AtenaSealPartParam;
import jp.co.ndensan.reams.af.afa.business.core.nyujokenikkatsu.NyujokenIkkatsuEditor;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE214.AtenaSeal21Report;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.kaiku.MeiboKaikuEdited;
import jp.co.ndensan.reams.af.afa.definition.kaiku.SenkyojiKaikuEdit;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.senkyojikaiku.SenkyojiKaikuMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.senkyojikaiku.AFABTK103SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyojikaiku.SenkyojiKaikuEntity;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE214.AtenaSeal21Source;
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
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 海区漁業調整委員会委員選挙時登録<br>
 * 新規登録者宛名シール21面作成。
 *
 * @reamsid_L AF-0470-030 jihb
 */
public class KaikuAtenaSea21ReportProcess extends BatchKeyBreakBase<SenkyojiKaikuEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.senkyojikaiku.ISenkyojiKaikuMapper.select登録者名簿データ");

    private AFABTK103SelectProcessParameter processParameter;
    private SenkyojiKaikuMybatisParameter mybatisParameter;

    private RString 画面ID;

    private int indexCount;
    private int indexPage;

    @BatchWriter
    private IBatchReportWriterWithCheckList<AtenaSeal21Source> 宛名シール21面Writer;
    private ReportSourceWriter<AtenaSeal21Source> 宛名シール21面SourceWCLWriter;

    /**
     * ページ数Parameterです。
     */
    public static final RString PAGE_COUNT;

    static {
        PAGE_COUNT = new RString("pageCount");
    }
    OutputParameter<Integer> pageCount;
    private int itemCount;
    private AtenaSeal21Param param;
    private Association 地方公共団体情報;
    private boolean isFirstItem;

    @Override
    protected void initialize() {
        mybatisParameter = processParameter.toSenkyojiKaikuMybatisParameter();
        mybatisParameter.set選挙種類(new Code(SenkyoShurui.海区漁業調整委員会委員選挙.getCode()));
        itemCount = 0;
        indexCount = 0;
        indexPage = 1;
        isFirstItem = Boolean.TRUE;
        pageCount = new OutputParameter<>();
        IAssociationFinder associationFinder = AssociationFinderFactory.createInstance();
        地方公共団体情報 = associationFinder.getAssociation();
        if (processParameter.get画面区分().equals(MeiboKaikuEdited.海区漁業調整委員会委員選挙時登録.getValue())) {
            画面ID = MeiboKaikuEdited.海区漁業調整委員会委員選挙時登録.getKey();
        } else {
            画面ID = MeiboKaikuEdited.海区漁業調整委員会委員選挙人名簿最新化.getKey();
        }
        param = new AtenaSeal21Param(地方公共団体情報, 画面ID);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        create文字切れ一覧表に出力Writer();
        宛名シール21面SourceWCLWriter = new ReportSourceWriter<>(宛名シール21面Writer);

    }

    @Override
    protected void keyBreakProcess(SenkyojiKaikuEntity t) {

    }

    @Override
    protected void usualProcess(SenkyojiKaikuEntity 宛名シール21面) {
        indexCount++;
        int 開始印字位置番号 = 0;
        if (isFirstItem && 開始印字位置番号 != 0) {
            itemCount = itemCount + 開始印字位置番号 - 1;
            isFirstItem = Boolean.FALSE;
        }
        NyujokenIkkatsuEditor editor = new NyujokenIkkatsuEditor();
        if (itemCount <= SenkyojiKaikuEdit.ページ件数21面_NINE) {
            get宛名シール21面情報1(宛名シール21面, editor);
        } else if (itemCount < SenkyojiKaikuEdit.ページ件数21面_TWENTYONE) {
            get宛名シール21面情報2(宛名シール21面, editor);
        } else if (itemCount == SenkyojiKaikuEdit.ページ件数21面_TWENTYONE) {
            AtenaSeal21Report report = new AtenaSeal21Report(param);
            report.writeBy(宛名シール21面SourceWCLWriter);
            param = new AtenaSeal21Param(地方公共団体情報, 画面ID);
            itemCount = 0;
            indexPage++;
            if (開始印字位置番号 != 0) {
                itemCount = itemCount + 開始印字位置番号 - 1;
            }
            if (itemCount <= SenkyojiKaikuEdit.ページ件数21面_NINE) {
                get宛名シール21面情報1(宛名シール21面, editor);
            } else if (itemCount < SenkyojiKaikuEdit.ページ件数21面_TWENTYONE) {
                get宛名シール21面情報2(宛名シール21面, editor);
            }
        }
    }

    private void get宛名シール21面情報1(
            SenkyojiKaikuEntity 宛名シール21面情報,
            NyujokenIkkatsuEditor editor) {
        if (itemCount == 0) {
            AtenaSealPartParam 宛名シール21面_1 = new AtenaSealPartParam();
            宛名シール21面_1.set通し番号(new RString(indexCount));
            宛名シール21面_1.set投票資格情報(editor.get投票資格情報(宛名シール21面情報));

            param.set頁番号(indexPage);
            param.setParam1(宛名シール21面_1);
            itemCount++;
        } else if (itemCount == 1) {
            AtenaSealPartParam 宛名シール21面_2 = new AtenaSealPartParam();
            宛名シール21面_2.set通し番号(new RString(indexCount));
            宛名シール21面_2.set投票資格情報(editor.get投票資格情報(宛名シール21面情報));
            param.set頁番号(indexPage);
            param.setParam2(宛名シール21面_2);
            itemCount++;
        } else if (itemCount == 2) {
            AtenaSealPartParam 宛名シール21面_3 = new AtenaSealPartParam();
            宛名シール21面_3.set通し番号(new RString(indexCount));
            宛名シール21面_3.set投票資格情報(editor.get投票資格情報(宛名シール21面情報));
            param.set頁番号(indexPage);
            param.setParam3(宛名シール21面_3);
            itemCount++;
        } else if (itemCount == SenkyojiKaikuEdit.ページ件数21面_THREE) {
            AtenaSealPartParam 宛名シール21面_4 = new AtenaSealPartParam();
            宛名シール21面_4.set通し番号(new RString(indexCount));
            宛名シール21面_4.set投票資格情報(editor.get投票資格情報(宛名シール21面情報));
            param.set頁番号(indexPage);
            param.setParam4(宛名シール21面_4);
            itemCount++;
        } else if (itemCount == SenkyojiKaikuEdit.ページ件数21面_FOUR) {
            AtenaSealPartParam 宛名シール21面_5 = new AtenaSealPartParam();
            宛名シール21面_5.set通し番号(new RString(indexCount));
            宛名シール21面_5.set投票資格情報(editor.get投票資格情報(宛名シール21面情報));
            param.set頁番号(indexPage);
            param.setParam5(宛名シール21面_5);
            itemCount++;
        } else if (itemCount == SenkyojiKaikuEdit.ページ件数21面_FIVE) {
            AtenaSealPartParam 宛名シール21面_6 = new AtenaSealPartParam();
            宛名シール21面_6.set通し番号(new RString(indexCount));
            宛名シール21面_6.set投票資格情報(editor.get投票資格情報(宛名シール21面情報));
            param.set頁番号(indexPage);
            param.setParam6(宛名シール21面_6);
            itemCount++;
        } else if (itemCount == SenkyojiKaikuEdit.ページ件数21面_SIX) {
            AtenaSealPartParam 宛名シール21面_7 = new AtenaSealPartParam();
            宛名シール21面_7.set通し番号(new RString(indexCount));
            宛名シール21面_7.set投票資格情報(editor.get投票資格情報(宛名シール21面情報));
            param.set頁番号(indexPage);
            param.setParam7(宛名シール21面_7);
            itemCount++;
        } else if (itemCount == SenkyojiKaikuEdit.ページ件数21面_SEVEN) {
            AtenaSealPartParam 宛名シール21面_8 = new AtenaSealPartParam();
            宛名シール21面_8.set通し番号(new RString(indexCount));
            宛名シール21面_8.set投票資格情報(editor.get投票資格情報(宛名シール21面情報));
            param.set頁番号(indexPage);
            param.setParam8(宛名シール21面_8);
            itemCount++;
        } else if (itemCount == SenkyojiKaikuEdit.ページ件数21面_EIGHT) {
            AtenaSealPartParam 宛名シール21面_9 = new AtenaSealPartParam();
            宛名シール21面_9.set通し番号(new RString(indexCount));
            宛名シール21面_9.set投票資格情報(editor.get投票資格情報(宛名シール21面情報));
            param.set頁番号(indexPage);
            param.setParam9(宛名シール21面_9);
            itemCount++;
        } else if (itemCount == SenkyojiKaikuEdit.ページ件数21面_NINE) {
            AtenaSealPartParam 宛名シール21面_10 = new AtenaSealPartParam();
            宛名シール21面_10.set通し番号(new RString(indexCount));
            宛名シール21面_10.set投票資格情報(editor.get投票資格情報(宛名シール21面情報));
            param.set頁番号(indexPage);
            param.setParam10(宛名シール21面_10);
            itemCount++;
        }
    }

    private void get宛名シール21面情報2(
            SenkyojiKaikuEntity 宛名シール21面情報,
            NyujokenIkkatsuEditor editor) {
        if (itemCount == SenkyojiKaikuEdit.ページ件数21面_TEN) {
            AtenaSealPartParam 宛名シール21面_11 = new AtenaSealPartParam();
            宛名シール21面_11.set通し番号(new RString(indexCount));
            宛名シール21面_11.set投票資格情報(editor.get投票資格情報(宛名シール21面情報));
            param.set頁番号(indexPage);
            param.setParam11(宛名シール21面_11);
            itemCount++;
        } else if (itemCount == SenkyojiKaikuEdit.ページ件数21面_ELEVEN) {
            AtenaSealPartParam 宛名シール21面_12 = new AtenaSealPartParam();
            宛名シール21面_12.set通し番号(new RString(indexCount));
            宛名シール21面_12.set投票資格情報(editor.get投票資格情報(宛名シール21面情報));
            param.set頁番号(indexPage);
            param.setParam12(宛名シール21面_12);
            itemCount++;
        } else if (itemCount == SenkyojiKaikuEdit.ページ件数21面_TWELVE) {
            AtenaSealPartParam 宛名シール21面_13 = new AtenaSealPartParam();
            宛名シール21面_13.set通し番号(new RString(indexCount));
            宛名シール21面_13.set投票資格情報(editor.get投票資格情報(宛名シール21面情報));
            param.set頁番号(indexPage);
            param.setParam13(宛名シール21面_13);
            itemCount++;
        } else if (itemCount == SenkyojiKaikuEdit.ページ件数21面_THIRTEEN) {
            AtenaSealPartParam 宛名シール21面_14 = new AtenaSealPartParam();
            宛名シール21面_14.set通し番号(new RString(indexCount));
            宛名シール21面_14.set投票資格情報(editor.get投票資格情報(宛名シール21面情報));
            param.set頁番号(indexPage);
            param.setParam14(宛名シール21面_14);
            itemCount++;
        } else if (itemCount == SenkyojiKaikuEdit.ページ件数21面_FOURTEEN) {
            AtenaSealPartParam 宛名シール21面_15 = new AtenaSealPartParam();
            宛名シール21面_15.set通し番号(new RString(indexCount));
            宛名シール21面_15.set投票資格情報(editor.get投票資格情報(宛名シール21面情報));
            param.set頁番号(indexPage);
            param.setParam15(宛名シール21面_15);
            itemCount++;
        } else if (itemCount == SenkyojiKaikuEdit.ページ件数21面_FIFTEEN) {
            AtenaSealPartParam 宛名シール21面_16 = new AtenaSealPartParam();
            宛名シール21面_16.set通し番号(new RString(indexCount));
            宛名シール21面_16.set投票資格情報(editor.get投票資格情報(宛名シール21面情報));
            param.set頁番号(indexPage);
            param.setParam16(宛名シール21面_16);
            itemCount++;
        } else if (itemCount == SenkyojiKaikuEdit.ページ件数21面_SIXTEEN) {
            AtenaSealPartParam 宛名シール21面_17 = new AtenaSealPartParam();
            宛名シール21面_17.set通し番号(new RString(indexCount));
            宛名シール21面_17.set投票資格情報(editor.get投票資格情報(宛名シール21面情報));
            param.set頁番号(indexPage);
            param.setParam17(宛名シール21面_17);
            itemCount++;
        } else if (itemCount == SenkyojiKaikuEdit.ページ件数21面_SEVENTEEN) {
            AtenaSealPartParam 宛名シール21面_18 = new AtenaSealPartParam();
            宛名シール21面_18.set通し番号(new RString(indexCount));
            宛名シール21面_18.set投票資格情報(editor.get投票資格情報(宛名シール21面情報));
            param.set頁番号(indexPage);
            param.setParam18(宛名シール21面_18);
            itemCount++;
        } else if (itemCount == SenkyojiKaikuEdit.ページ件数21面_EIGHTEEN) {
            AtenaSealPartParam 宛名シール21面_19 = new AtenaSealPartParam();
            宛名シール21面_19.set通し番号(new RString(indexCount));
            宛名シール21面_19.set投票資格情報(editor.get投票資格情報(宛名シール21面情報));
            param.set頁番号(indexPage);
            param.setParam19(宛名シール21面_19);
            itemCount++;
        } else if (itemCount == SenkyojiKaikuEdit.ページ件数21面_NINETEEN) {
            AtenaSealPartParam 宛名シール21面_20 = new AtenaSealPartParam();
            宛名シール21面_20.set通し番号(new RString(indexCount));
            宛名シール21面_20.set投票資格情報(editor.get投票資格情報(宛名シール21面情報));
            param.set頁番号(indexPage);
            param.setParam20(宛名シール21面_20);
            itemCount++;
        } else if (itemCount == SenkyojiKaikuEdit.ページ件数21面_TWENTY) {
            AtenaSealPartParam 宛名シール21面_21 = new AtenaSealPartParam();
            宛名シール21面_21.set通し番号(new RString(indexCount));
            宛名シール21面_21.set投票資格情報(editor.get投票資格情報(宛名シール21面情報));
            param.set頁番号(indexPage);
            param.setParam21(宛名シール21面_21);
            itemCount++;
        }
    }

    @Override
    protected void afterExecute() {
        if (isHasデータ1(param) || isHasデータ2(param)) {
            AtenaSeal21Report report = new AtenaSeal21Report(param);
            report.writeBy(宛名シール21面SourceWCLWriter);
        }

        pageCount.setValue(宛名シール21面Writer.getPageCount());
    }

    private Boolean isHasデータ2(AtenaSeal21Param 宛名シール21面情報) {
        if (宛名シール21面情報.getParam11() != null) {
            return Boolean.TRUE;
        }
        if (宛名シール21面情報.getParam12() != null) {
            return Boolean.TRUE;
        }
        if (宛名シール21面情報.getParam13() != null) {
            return Boolean.TRUE;
        }
        if (宛名シール21面情報.getParam14() != null) {
            return Boolean.TRUE;
        }
        if (宛名シール21面情報.getParam15() != null) {
            return Boolean.TRUE;
        }
        if (宛名シール21面情報.getParam16() != null) {
            return Boolean.TRUE;
        }
        if (宛名シール21面情報.getParam17() != null) {
            return Boolean.TRUE;
        }
        if (宛名シール21面情報.getParam18() != null) {
            return Boolean.TRUE;
        }
        if (宛名シール21面情報.getParam19() != null) {
            return Boolean.TRUE;
        }
        if (宛名シール21面情報.getParam20() != null) {
            return Boolean.TRUE;
        }
        if (宛名シール21面情報.getParam21() != null) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private Boolean isHasデータ1(AtenaSeal21Param 宛名シール21面情報) {
        if (宛名シール21面情報.getParam1() != null) {
            return Boolean.TRUE;
        }
        if (宛名シール21面情報.getParam2() != null) {
            return Boolean.TRUE;
        }
        if (宛名シール21面情報.getParam3() != null) {
            return Boolean.TRUE;
        }
        if (宛名シール21面情報.getParam4() != null) {
            return Boolean.TRUE;
        }
        if (宛名シール21面情報.getParam5() != null) {
            return Boolean.TRUE;
        }
        if (宛名シール21面情報.getParam6() != null) {
            return Boolean.TRUE;
        }
        if (宛名シール21面情報.getParam7() != null) {
            return Boolean.TRUE;
        }
        if (宛名シール21面情報.getParam8() != null) {
            return Boolean.TRUE;
        }
        if (宛名シール21面情報.getParam9() != null) {
            return Boolean.TRUE;
        }
        if (宛名シール21面情報.getParam10() != null) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    private void create文字切れ一覧表に出力Writer() {
        CheckListLineItemSet pairs = CheckListLineItemSet.of(
                KaikuAtenaSea21ReportProcess.特定項目.class,
                KaikuAtenaSea21ReportProcess.チェック項目.class
        );
        ICheckListInfo info = CheckListInfoFactory.createInstance(
                SubGyomuCode.AFA選挙本体,
                AssociationFinderFactory.createInstance().getAssociation());

        宛名シール21面Writer = BatchWriters
                .batchReportWriterWithCheckList(AtenaSeal21Source.class)
                .checkListInfo(info)
                .checkListLineItemSet(pairs)
                .reportId(ReportIdKeys.AFAPRE213_宛名シール12面.value())
                .build();
    }

    private enum 特定項目 implements ISpecificKey {

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
