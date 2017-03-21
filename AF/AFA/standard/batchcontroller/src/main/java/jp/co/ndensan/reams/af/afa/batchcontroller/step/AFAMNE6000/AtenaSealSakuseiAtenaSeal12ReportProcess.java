/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE6000;

import jp.co.ndensan.reams.af.afa.business.core.AtenaSeal12Param;
import jp.co.ndensan.reams.af.afa.business.core.AtenaSealPartParam;
import jp.co.ndensan.reams.af.afa.business.core.atenasealsakusei.AtenaSealSakuseiEditor;
import jp.co.ndensan.reams.af.afa.business.core.shohonselect.ShohonResult;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE213.AtenaSeal12Report;
import jp.co.ndensan.reams.af.afa.business.util.shikakuhantei.ShikakuHantei;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ReportIdKeys;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.atenasealsakusei.AtenaSealSakuseiMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.nyujokenikkatsu.NyujokenIkkatsuMybatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.atenasealsakusei.AFABTE601SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.atenasealsakusei.AtenaSealSakuseiJyohouEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.nyujokenkobetsu.NyujokenKobetsuJouhou;
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE213.AtenaSeal12Source;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.nyujokenikkatsu.INyujokenIkkatsuMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.af.afa.service.core.shohonselect.ShohonSelectFinder;
import jp.co.ndensan.reams.af.afa.service.nyujokenikkatsu.NyujokenIkkatsuFinder;
import jp.co.ndensan.reams.af.afa.service.report.AFAPRE213.AtenaSeal12PrintEditor;
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
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 宛名シール（12面）のクラスです。
 *
 * @reamsid_L AF-0620-020 guancy
 */
public class AtenaSealSakuseiAtenaSeal12ReportProcess extends BatchProcessBase<AtenaSealSakuseiJyohouEntity> {

    private AtenaSealSakuseiMybatisParameter mybatisParameter;
    private NyujokenIkkatsuMybatisParameter mybatisParameter1;
    private AFABTE601SelectProcessParameter parameter;
    private ShohonSelectFinder finder;
    private INyujokenIkkatsuMapper mapper;
    private NyujokenIkkatsuFinder finder1;
    private AfaMapperProvider mapperProvider;
    private AtenaSeal12PrintEditor atenaSeal21PrintEditor;
    private RString 選挙種類;
    private static final RString 選挙人宛名シール_画面ID = new RString("AFAGME6010");
    private static final RString 転出者宛名シール_画面ID = new RString("AFAGME6020");
    private static final RString 施設宛名シール_画面ID = new RString("AFAGME6030");
    private static final RString 対象選挙の選挙レベル_県レベル = new RString("2");
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
    private RString 自市町村の県コード;
    private RString 起動画面ID;
    private RString selectId;
    private int indexCount;
    private int indexPage;
    private static final RString MYBATIS_SELECT_ID1 = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.atenasealsakusei.IAtenaSealSakuseiMapper.select選挙人宛名シール情報");
    private static final RString MYBATIS_SELECT_ID2 = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.atenasealsakusei.IAtenaSealSakuseiMapper.select転出者宛名シール情報");
    private static final RString MYBATIS_SELECT_ID3 = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.atenasealsakusei.IAtenaSealSakuseiMapper.select施設宛名シール情報");
    @BatchWriter
    private IBatchReportWriterWithCheckList<AtenaSeal12Source> batchReportWCLWriter;
    private ReportSourceWriter<AtenaSeal12Source> reportSourceWCLWriter;

    /**
     * ページ数Parameterです。
     */
    public static final RString PAGE_COUNT;

    static {
        PAGE_COUNT = new RString("pageCount");
    }
    OutputParameter<Integer> pageCount;
    private int itemCount;
    private AtenaSeal12Param param;
    private Association 地方公共団体情報;
    private boolean isFirstItem;

    @Override
    protected void initialize() {
        起動画面ID = parameter.get起動画面ID();
        finder = ShohonSelectFinder.createInstance();
        ShohonResult result = new ShohonResult();
        if (null != parameter.get抄本番号()) {
            result = finder.getByShohonNo(new ShohonNo(parameter.get抄本番号()));
        }
        if (null == result) {
            選挙種類 = RString.EMPTY;
        } else if (null == result.get選挙種類()) {
            選挙種類 = RString.EMPTY;
        } else {
            選挙種類 = result.get選挙種類().getColumnValue();
        }
        if (選挙人宛名シール_画面ID.equals(起動画面ID)) {
            selectId = MYBATIS_SELECT_ID1;
        } else if (転出者宛名シール_画面ID.equals(起動画面ID)) {
            selectId = MYBATIS_SELECT_ID2;
            finder1 = NyujokenIkkatsuFinder.createInstance();
            AfT100ShohonEntity entity = finder1.get抄本情報(new ShohonNo(parameter.get抄本番号()));
            if (null != entity) {
                parameter.set年齢到達期限日(entity.getKiteiNenreiTotatsuYMD());
                parameter.set投票年月日(entity.getTohyoYMD());
            } else {
                parameter.set年齢到達期限日(FlexibleDate.EMPTY);
                parameter.set投票年月日(FlexibleDate.MAX);
            }
            this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
            mapper = mapperProvider.create(INyujokenIkkatsuMapper.class);
            ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.住登外優先);
            build.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
            IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = build.build();
            mybatisParameter1 = new NyujokenIkkatsuMybatisParameter(shikibetsuTaishoPSMSearchKey, new ShohonNo(parameter.get抄本番号()), 選挙種類,
                    null, null, 0, null);
            mybatisParameter1.setKijunYMD(parameter.get投票年月日());
            NyujokenKobetsuJouhou 前回基準日entity = mapper.select抄本の前回基準日(mybatisParameter1);
            if (null != 前回基準日entity) {
                parameter.set前回基準日(前回基準日entity.get前回基準日());
            } else {
                parameter.set前回基準日(FlexibleDate.EMPTY);
            }
        } else if (施設宛名シール_画面ID.equals(起動画面ID)) {
            selectId = MYBATIS_SELECT_ID3;
        }

        ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.住登外優先);
        build.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = build.build();
        parameter.setShikibetsutaishoParam(shikibetsuTaishoPSMSearchKey);
        mybatisParameter = parameter.toAtenaSealSakuseiMybatisParameter();
        mybatisParameter.set出力順(parameter.getOrder順());
        itemCount = 0;
        indexCount = 0;
        indexPage = 1;
        isFirstItem = Boolean.TRUE;
        pageCount = new OutputParameter<>();
        IAssociationFinder associationFinder = AssociationFinderFactory.createInstance();
        地方公共団体情報 = associationFinder.getAssociation();
        LasdecCode 地方公共団体コード = 地方公共団体情報.get地方公共団体コード();
        if (null != 地方公共団体コード) {
            自市町村の県コード = 地方公共団体コード.getColumnValue();
        }
        自市町村の県コード = 自市町村の県コード == null ? RString.EMPTY : 自市町村の県コード;
        param = new AtenaSeal12Param(地方公共団体情報, parameter.get起動画面ID());
        if (null == mybatisParameter.get対象期間FROM() || mybatisParameter.get対象期間FROM().toString().isEmpty()) {
            mybatisParameter.set対象期間FROM(null);
        }
        if (null == mybatisParameter.get対象期間TO() || mybatisParameter.get対象期間TO().toString().isEmpty()) {
            mybatisParameter.set対象期間TO(null);
        }

        RString 転出期限日検索基準 = BusinessConfig.get(ConfigKeysAFA.転出期限日検索基準, SubGyomuCode.AFA選挙本体);
        mybatisParameter.set転出期限日検索基準(転出期限日検索基準);
        atenaSeal21PrintEditor = new AtenaSeal12PrintEditor();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(selectId, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        create文字切れ一覧表に出力Writer();
        reportSourceWCLWriter = new ReportSourceWriter<>(batchReportWCLWriter);

    }

    @Override
    protected void process(AtenaSealSakuseiJyohouEntity 宛名シール12面) {
        if (選挙人宛名シール_画面ID.equals(起動画面ID)) {
            get宛名シール情報(宛名シール12面);
        } else if (転出者宛名シール_画面ID.equals(起動画面ID)) {
            RString 転出先全国住所コード = RString.EMPTY;
            Boolean isHasData = Boolean.FALSE;
            ZenkokuJushoCode 全国住所コード = 宛名シール12面.get宛名PSM情報().getZenkokuJushoCode();
            if (null != 全国住所コード) {
                転出先全国住所コード = 全国住所コード.getColumnValue();
                isHasData = Boolean.TRUE;
            }
            if (is表示者(宛名シール12面)
                    && !(対象選挙の選挙レベル_県レベル.equals(parameter.get選挙レベル())
                    && isHasData
                    && 転出先全国住所コード.length() >= 2
                    && 自市町村の県コード.length() >= 2
                    && !転出先全国住所コード.substring(0, 2).equals(自市町村の県コード.substring(0, 2)))) {
                get宛名シール情報(宛名シール12面);
            }
        } else if (施設宛名シール_画面ID.equals(起動画面ID)) {
            get宛名シール情報(宛名シール12面);
        }

    }

    private void get宛名シール情報(AtenaSealSakuseiJyohouEntity 宛名シール12面) {
        indexCount++;
        int 開始印字位置番号 = RString.isNullOrEmpty(parameter.get開始印字位置番号())
                ? 0 : Integer.parseInt(parameter.get開始印字位置番号().toString());
        if (isFirstItem && 開始印字位置番号 != 0) {
            itemCount = itemCount + 開始印字位置番号 - 1;
            isFirstItem = Boolean.FALSE;
        }
        AtenaSealSakuseiEditor editor = new AtenaSealSakuseiEditor();
        if (itemCount != ページ件数12面_TWELVE) {
            get宛名シール12面情報(宛名シール12面, editor);
        } else if (itemCount == ページ件数12面_TWELVE) {

            AtenaSeal12Report report = new AtenaSeal12Report(param);
            report.writeBy(reportSourceWCLWriter);
            param = new AtenaSeal12Param(地方公共団体情報, parameter.get起動画面ID());
            itemCount = 0;
            indexPage++;
            get宛名シール12面情報(宛名シール12面, editor);
        }
    }

    private void get宛名シール12面情報(
            AtenaSealSakuseiJyohouEntity 宛名シール12面,
            AtenaSealSakuseiEditor editor) {
        if (itemCount == 0) {
            AtenaSealPartParam 宛名シール12面_1 = new AtenaSealPartParam();
            宛名シール12面_1.set画面情報(editor.get宛名シール画面情報(parameter));
            宛名シール12面_1.set通し番号(new RString(indexCount));
            宛名シール12面_1.set投票資格情報(editor.get投票資格情報(宛名シール12面));
            宛名シール12面_1.set施設情報(宛名シール12面.get施設情報());
            宛名シール12面_1
                    = atenaSeal21PrintEditor.eidtAtenaSealPartParam(宛名シール12面_1, 宛名シール12面, 起動画面ID);
            param.set頁番号(indexPage);
            param.setParam1(宛名シール12面_1);
            itemCount++;
        } else if (itemCount == 1) {
            AtenaSealPartParam 宛名シール12面_2 = new AtenaSealPartParam();
            宛名シール12面_2.set画面情報(editor.get宛名シール画面情報(parameter));
            宛名シール12面_2.set通し番号(new RString(indexCount));
            宛名シール12面_2.set投票資格情報(editor.get投票資格情報(宛名シール12面));
            宛名シール12面_2.set施設情報(宛名シール12面.get施設情報());
            宛名シール12面_2
                    = atenaSeal21PrintEditor.eidtAtenaSealPartParam(宛名シール12面_2, 宛名シール12面, 起動画面ID);
            param.set頁番号(indexPage);
            param.setParam2(宛名シール12面_2);
            itemCount++;
        } else if (itemCount == 2) {
            AtenaSealPartParam 宛名シール12面_3 = new AtenaSealPartParam();
            宛名シール12面_3.set画面情報(editor.get宛名シール画面情報(parameter));
            宛名シール12面_3.set通し番号(new RString(indexCount));
            宛名シール12面_3.set投票資格情報(editor.get投票資格情報(宛名シール12面));
            宛名シール12面_3.set施設情報(宛名シール12面.get施設情報());
            宛名シール12面_3
                    = atenaSeal21PrintEditor.eidtAtenaSealPartParam(宛名シール12面_3, 宛名シール12面, 起動画面ID);
            param.set頁番号(indexPage);
            param.setParam3(宛名シール12面_3);
            itemCount++;
        } else if (itemCount == ページ件数12面_THREE) {
            AtenaSealPartParam 宛名シール12面_4 = new AtenaSealPartParam();
            宛名シール12面_4.set画面情報(editor.get宛名シール画面情報(parameter));
            宛名シール12面_4.set通し番号(new RString(indexCount));
            宛名シール12面_4.set投票資格情報(editor.get投票資格情報(宛名シール12面));
            宛名シール12面_4.set施設情報(宛名シール12面.get施設情報());
            宛名シール12面_4
                    = atenaSeal21PrintEditor.eidtAtenaSealPartParam(宛名シール12面_4, 宛名シール12面, 起動画面ID);
            param.set頁番号(indexPage);
            param.setParam4(宛名シール12面_4);
            itemCount++;
        } else if (itemCount == ページ件数12面_FOUR) {
            AtenaSealPartParam 宛名シール12面_5 = new AtenaSealPartParam();
            宛名シール12面_5.set画面情報(editor.get宛名シール画面情報(parameter));
            宛名シール12面_5.set通し番号(new RString(indexCount));
            宛名シール12面_5.set投票資格情報(editor.get投票資格情報(宛名シール12面));
            宛名シール12面_5.set施設情報(宛名シール12面.get施設情報());
            宛名シール12面_5
                    = atenaSeal21PrintEditor.eidtAtenaSealPartParam(宛名シール12面_5, 宛名シール12面, 起動画面ID);
            param.set頁番号(indexPage);
            param.setParam5(宛名シール12面_5);
            itemCount++;
        } else if (itemCount == ページ件数12面_FIVE) {
            AtenaSealPartParam 宛名シール12面_6 = new AtenaSealPartParam();
            宛名シール12面_6.set画面情報(editor.get宛名シール画面情報(parameter));
            宛名シール12面_6.set通し番号(new RString(indexCount));
            宛名シール12面_6.set投票資格情報(editor.get投票資格情報(宛名シール12面));
            宛名シール12面_6.set施設情報(宛名シール12面.get施設情報());
            宛名シール12面_6
                    = atenaSeal21PrintEditor.eidtAtenaSealPartParam(宛名シール12面_6, 宛名シール12面, 起動画面ID);
            param.set頁番号(indexPage);
            param.setParam6(宛名シール12面_6);
            itemCount++;
        } else if (itemCount == ページ件数12面_SIX) {
            AtenaSealPartParam 宛名シール12面_7 = new AtenaSealPartParam();
            宛名シール12面_7.set画面情報(editor.get宛名シール画面情報(parameter));
            宛名シール12面_7.set通し番号(new RString(indexCount));
            宛名シール12面_7.set投票資格情報(editor.get投票資格情報(宛名シール12面));
            宛名シール12面_7.set施設情報(宛名シール12面.get施設情報());
            宛名シール12面_7
                    = atenaSeal21PrintEditor.eidtAtenaSealPartParam(宛名シール12面_7, 宛名シール12面, 起動画面ID);
            param.set頁番号(indexPage);
            param.setParam7(宛名シール12面_7);
            itemCount++;
        } else if (itemCount == ページ件数12面_SEVEN) {
            AtenaSealPartParam 宛名シール12面_8 = new AtenaSealPartParam();
            宛名シール12面_8.set画面情報(editor.get宛名シール画面情報(parameter));
            宛名シール12面_8.set通し番号(new RString(indexCount));
            宛名シール12面_8.set投票資格情報(editor.get投票資格情報(宛名シール12面));
            宛名シール12面_8.set施設情報(宛名シール12面.get施設情報());
            宛名シール12面_8
                    = atenaSeal21PrintEditor.eidtAtenaSealPartParam(宛名シール12面_8, 宛名シール12面, 起動画面ID);
            param.set頁番号(indexPage);
            param.setParam8(宛名シール12面_8);
            itemCount++;
        } else if (itemCount == ページ件数12面_EIGHT) {
            AtenaSealPartParam 宛名シール12面_9 = new AtenaSealPartParam();
            宛名シール12面_9.set画面情報(editor.get宛名シール画面情報(parameter));
            宛名シール12面_9.set通し番号(new RString(indexCount));
            宛名シール12面_9.set投票資格情報(editor.get投票資格情報(宛名シール12面));
            宛名シール12面_9.set施設情報(宛名シール12面.get施設情報());
            宛名シール12面_9
                    = atenaSeal21PrintEditor.eidtAtenaSealPartParam(宛名シール12面_9, 宛名シール12面, 起動画面ID);
            param.set頁番号(indexPage);
            param.setParam9(宛名シール12面_9);
            itemCount++;
        } else if (itemCount == ページ件数12面_NINE) {
            AtenaSealPartParam 宛名シール12面_10 = new AtenaSealPartParam();
            宛名シール12面_10.set画面情報(editor.get宛名シール画面情報(parameter));
            宛名シール12面_10.set通し番号(new RString(indexCount));
            宛名シール12面_10.set投票資格情報(editor.get投票資格情報(宛名シール12面));
            宛名シール12面_10.set施設情報(宛名シール12面.get施設情報());
            宛名シール12面_10
                    = atenaSeal21PrintEditor.eidtAtenaSealPartParam(宛名シール12面_10, 宛名シール12面, 起動画面ID);
            param.set頁番号(indexPage);
            param.setParam10(宛名シール12面_10);
            itemCount++;
        } else if (itemCount == ページ件数12面_TEN) {
            AtenaSealPartParam 宛名シール12面_11 = new AtenaSealPartParam();
            宛名シール12面_11.set画面情報(editor.get宛名シール画面情報(parameter));
            宛名シール12面_11.set通し番号(new RString(indexCount));
            宛名シール12面_11.set投票資格情報(editor.get投票資格情報(宛名シール12面));
            宛名シール12面_11.set施設情報(宛名シール12面.get施設情報());
            宛名シール12面_11
                    = atenaSeal21PrintEditor.eidtAtenaSealPartParam(宛名シール12面_11, 宛名シール12面, 起動画面ID);
            param.set頁番号(indexPage);
            param.setParam11(宛名シール12面_11);
            itemCount++;
        } else if (itemCount == ページ件数12面_ELEVEN) {
            AtenaSealPartParam 宛名シール12面_12 = new AtenaSealPartParam();
            宛名シール12面_12.set画面情報(editor.get宛名シール画面情報(parameter));
            宛名シール12面_12.set通し番号(new RString(indexCount));
            宛名シール12面_12.set投票資格情報(editor.get投票資格情報(宛名シール12面));
            宛名シール12面_12.set施設情報(宛名シール12面.get施設情報());
            宛名シール12面_12
                    = atenaSeal21PrintEditor.eidtAtenaSealPartParam(宛名シール12面_12, 宛名シール12面, 起動画面ID);
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
        pageCount.setValue(batchReportWCLWriter.getPageCount());
    }

    private Boolean isHasデータ(AtenaSeal12Param 宛名シール12面) {
        if (null != 宛名シール12面.getParam1()) {
            return Boolean.TRUE;
        }
        if (null != 宛名シール12面.getParam2()) {
            return Boolean.TRUE;
        }
        if (null != 宛名シール12面.getParam3()) {
            return Boolean.TRUE;
        }
        if (null != 宛名シール12面.getParam4()) {
            return Boolean.TRUE;
        }
        if (null != 宛名シール12面.getParam5()) {
            return Boolean.TRUE;
        }
        if (null != 宛名シール12面.getParam6()) {
            return Boolean.TRUE;
        }
        if (null != 宛名シール12面.getParam7()) {
            return Boolean.TRUE;
        }
        if (null != 宛名シール12面.getParam8()) {
            return Boolean.TRUE;
        }
        if (null != 宛名シール12面.getParam9()) {
            return Boolean.TRUE;
        }
        if (null != 宛名シール12面.getParam10()) {
            return Boolean.TRUE;
        }
        if (null != 宛名シール12面.getParam11()) {
            return Boolean.TRUE;
        }
        if (null != 宛名シール12面.getParam12()) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;

    }

    private void create文字切れ一覧表に出力Writer() {
        CheckListLineItemSet pairs = CheckListLineItemSet.of(
                AtenaSealSakuseiAtenaSeal12ReportProcess.特定項目.class,
                AtenaSealSakuseiAtenaSeal12ReportProcess.チェック項目.class
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

    private boolean is表示者(AtenaSealSakuseiJyohouEntity 宛名シール12面) {
        ShikakuHantei shikakuhantei = new ShikakuHantei();
        return shikakuhantei.is表示者(宛名シール12面.get宛名PSM情報(),
                宛名シール12面.get選挙情報().getTenshutsuKigenYMD(),
                parameter.get年齢到達期限日(),
                parameter.get投票年月日(),
                parameter.get前回基準日(),
                SenkyoShurui.toValue(選挙種類));
    }
}
