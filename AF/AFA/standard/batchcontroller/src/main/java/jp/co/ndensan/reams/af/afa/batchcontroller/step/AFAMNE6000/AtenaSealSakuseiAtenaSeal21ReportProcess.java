/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE6000;

import jp.co.ndensan.reams.af.afa.business.core.AtenaSeal21Param;
import jp.co.ndensan.reams.af.afa.business.core.AtenaSealPartParam;
import jp.co.ndensan.reams.af.afa.business.core.atenasealsakusei.AtenaSealSakuseiEditor;
import jp.co.ndensan.reams.af.afa.business.core.shohonselect.ShohonResult;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE214.AtenaSeal21Report;
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
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE214.AtenaSeal21Source;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.nyujokenikkatsu.INyujokenIkkatsuMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.af.afa.service.core.shohonselect.ShohonSelectFinder;
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
 * 宛名シール（21面）のクラスです。
 *
 * @reamsid_L AF-0620-020 guancy
 */
public class AtenaSealSakuseiAtenaSeal21ReportProcess extends BatchProcessBase<AtenaSealSakuseiJyohouEntity> {

    private AtenaSealSakuseiMybatisParameter mybatisParameter;
    private NyujokenIkkatsuMybatisParameter mybatisParameter1;
    private AFABTE601SelectProcessParameter parameter;
    private INyujokenIkkatsuMapper mapper;
    private ShohonSelectFinder finder;
    private NyujokenIkkatsuFinder finder1;
    private AfaMapperProvider mapperProvider;
    private static final RString 選挙人宛名シール_画面ID = new RString("AFAGME6010");
    private static final RString 転出者宛名シール_画面ID = new RString("AFAGME6020");
    private static final RString 施設宛名シール_画面ID = new RString("AFAGME6030");
    private static final RString 対象選挙の選挙レベル_県レベル = new RString("2");
    private static final int ページ件数21面_THREE = 3;
    private static final int ページ件数21面_FOUR = 4;
    private static final int ページ件数21面_FIVE = 5;
    private static final int ページ件数21面_SIX = 6;
    private static final int ページ件数21面_SEVEN = 7;
    private static final int ページ件数21面_EIGHT = 8;
    private static final int ページ件数21面_NINE = 9;
    private static final int ページ件数21面_TEN = 10;
    private static final int ページ件数21面_ELEVEN = 11;
    private static final int ページ件数21面_TWELVE = 12;
    private static final int ページ件数21面_THIRTEEN = 13;
    private static final int ページ件数21面_FOURTEEN = 14;
    private static final int ページ件数21面_FIFTEEN = 15;
    private static final int ページ件数21面_SIXTEEN = 16;
    private static final int ページ件数21面_SEVENTEEN = 17;
    private static final int ページ件数21面_EIGHTEEN = 18;
    private static final int ページ件数21面_NINETEEN = 19;
    private static final int ページ件数21面_TWENTY = 20;
    private static final int ページ件数21面_TWENTYONE = 21;
    private RString 自市町村の県コード;
    private RString selectId;
    private int indexCount;
    private int indexPage;
    private RString 選挙種類;
    RString 起動画面ID;
    private static final RString MYBATIS_SELECT_ID1 = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.atenasealsakusei.IAtenaSealSakuseiMapper.select選挙人宛名シール情報");
    private static final RString MYBATIS_SELECT_ID2 = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.atenasealsakusei.IAtenaSealSakuseiMapper.select転出者宛名シール情報");
    private static final RString MYBATIS_SELECT_ID3 = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.atenasealsakusei.IAtenaSealSakuseiMapper.select施設宛名シール情報");
    @BatchWriter
    private IBatchReportWriterWithCheckList<AtenaSeal21Source> batchReportWCLWriter;
    private ReportSourceWriter<AtenaSeal21Source> reportSourceWCLWriter;

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
        起動画面ID = parameter.get起動画面ID();
        finder = ShohonSelectFinder.createInstance();
        ShohonResult result = new ShohonResult();
        if (null != parameter.get抄本番号()) {
            result = finder.getByShohonNo(new ShohonNo(parameter.get抄本番号()));
        }
        if (result == null) {
            選挙種類 = RString.EMPTY;
        } else if (result.get選挙種類() == null) {
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
            if (entity != null) {
                parameter.set年齢到達期限日(entity.getKiteiNenreiTotatsuYMD());
                parameter.set投票年月日(entity.getTohyoYMD());
            } else {
                parameter.set年齢到達期限日(FlexibleDate.EMPTY);
                parameter.set投票年月日(FlexibleDate.MAX);
            }
            ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.住登外優先);
            build.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
            IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = build.build();

            this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
            mapper = mapperProvider.create(INyujokenIkkatsuMapper.class);
            mybatisParameter1 = new NyujokenIkkatsuMybatisParameter(shikibetsuTaishoPSMSearchKey, new ShohonNo(parameter.get抄本番号()), 選挙種類,
                    null, null, 0, null);
            mybatisParameter1.setKijunYMD(parameter.get投票年月日());
            NyujokenKobetsuJouhou 前回基準日entity = mapper.select抄本の前回基準日(mybatisParameter1);
            if (前回基準日entity != null) {
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
        if (地方公共団体コード != null) {
            自市町村の県コード = 地方公共団体コード.getColumnValue();
        }
        if (null == mybatisParameter.get対象期間FROM() || mybatisParameter.get対象期間FROM().toString().isEmpty()) {
            mybatisParameter.set対象期間FROM(null);
        }
        if (null == mybatisParameter.get対象期間TO() || mybatisParameter.get対象期間TO().toString().isEmpty()) {
            mybatisParameter.set対象期間TO(null);
        }
        自市町村の県コード = 自市町村の県コード == null ? RString.EMPTY : 自市町村の県コード;
        param = new AtenaSeal21Param(地方公共団体情報, parameter.get起動画面ID());
        RString 転出期限日検索基準 = BusinessConfig.get(ConfigKeysAFA.転出期限日検索基準, SubGyomuCode.AFA選挙本体);
        mybatisParameter.set転出期限日検索基準(転出期限日検索基準);
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
    protected void process(AtenaSealSakuseiJyohouEntity 宛名シール21面) {
        起動画面ID = parameter.get起動画面ID();
        if (選挙人宛名シール_画面ID.equals(起動画面ID)) {
            get宛名シール情報(宛名シール21面);
        } else if (転出者宛名シール_画面ID.equals(起動画面ID)) {
            RString 転出先全国住所コード = RString.EMPTY;
            Boolean isHasData = Boolean.FALSE;
            ZenkokuJushoCode 全国住所コード = 宛名シール21面.get宛名PSM情報().getZenkokuJushoCode();
            if (全国住所コード != null) {
                転出先全国住所コード = 全国住所コード.getColumnValue();
                isHasData = Boolean.TRUE;
            }
            if (is表示者(宛名シール21面)
                    && !(対象選挙の選挙レベル_県レベル.equals(parameter.get選挙レベル())
                    && isHasData
                    && 転出先全国住所コード.length() >= 2
                    && 自市町村の県コード.length() >= 2
                    && !転出先全国住所コード.substring(0, 2).equals(自市町村の県コード.substring(0, 2)))) {
                get宛名シール情報(宛名シール21面);
            }
        } else if (施設宛名シール_画面ID.equals(起動画面ID)) {
            get宛名シール情報(宛名シール21面);
        }

    }

    private void get宛名シール情報(AtenaSealSakuseiJyohouEntity 宛名シール21面) {
        indexCount++;
        int 開始印字位置番号 = RString.isNullOrEmpty(parameter.get開始印字位置番号())
                ? 0 : Integer.parseInt(parameter.get開始印字位置番号().toString());
        if (isFirstItem && 開始印字位置番号 != 0) {
            itemCount = itemCount + 開始印字位置番号 - 1;
            isFirstItem = Boolean.FALSE;
        }
        AtenaSealSakuseiEditor editor = new AtenaSealSakuseiEditor();
        if (itemCount <= ページ件数21面_NINE) {
            get宛名シール21面情報1(宛名シール21面, editor);
        } else if (itemCount < ページ件数21面_TWENTYONE) {
            get宛名シール21面情報2(宛名シール21面, editor);
        } else if (itemCount == ページ件数21面_TWENTYONE) {
            AtenaSeal21Report report = new AtenaSeal21Report(param);
            report.writeBy(reportSourceWCLWriter);
            param = new AtenaSeal21Param(地方公共団体情報, parameter.get起動画面ID());
            itemCount = 0;
            indexPage++;
            if (itemCount <= ページ件数21面_NINE) {
                get宛名シール21面情報1(宛名シール21面, editor);
            } else if (itemCount < ページ件数21面_TWENTYONE) {
                get宛名シール21面情報2(宛名シール21面, editor);
            }
        }
    }

    private void get宛名シール21面情報1(
            AtenaSealSakuseiJyohouEntity 宛名シール21面,
            AtenaSealSakuseiEditor editor) {
        if (itemCount == 0) {
            AtenaSealPartParam 宛名シール21面_1 = new AtenaSealPartParam();
            宛名シール21面_1.set画面情報(editor.get宛名シール画面情報(parameter));
            宛名シール21面_1.set通し番号(new RString(indexCount));
            宛名シール21面_1.set投票資格情報(editor.get投票資格情報(宛名シール21面));
            宛名シール21面_1.set施設情報(宛名シール21面.get施設情報());
            param.set頁番号(indexPage);
            param.setParam1(宛名シール21面_1);
            itemCount++;
        } else if (itemCount == 1) {
            AtenaSealPartParam 宛名シール21面_2 = new AtenaSealPartParam();
            宛名シール21面_2.set画面情報(editor.get宛名シール画面情報(parameter));
            宛名シール21面_2.set通し番号(new RString(indexCount));
            宛名シール21面_2.set投票資格情報(editor.get投票資格情報(宛名シール21面));
            宛名シール21面_2.set施設情報(宛名シール21面.get施設情報());
            param.set頁番号(indexPage);
            param.setParam2(宛名シール21面_2);
            itemCount++;
        } else if (itemCount == 2) {
            AtenaSealPartParam 宛名シール21面_3 = new AtenaSealPartParam();
            宛名シール21面_3.set画面情報(editor.get宛名シール画面情報(parameter));
            宛名シール21面_3.set通し番号(new RString(indexCount));
            宛名シール21面_3.set投票資格情報(editor.get投票資格情報(宛名シール21面));
            宛名シール21面_3.set施設情報(宛名シール21面.get施設情報());
            param.set頁番号(indexPage);
            param.setParam3(宛名シール21面_3);
            itemCount++;
        } else if (itemCount == ページ件数21面_THREE) {
            AtenaSealPartParam 宛名シール21面_4 = new AtenaSealPartParam();
            宛名シール21面_4.set画面情報(editor.get宛名シール画面情報(parameter));
            宛名シール21面_4.set通し番号(new RString(indexCount));
            宛名シール21面_4.set投票資格情報(editor.get投票資格情報(宛名シール21面));
            宛名シール21面_4.set施設情報(宛名シール21面.get施設情報());
            param.set頁番号(indexPage);
            param.setParam4(宛名シール21面_4);
            itemCount++;
        } else if (itemCount == ページ件数21面_FOUR) {
            AtenaSealPartParam 宛名シール21面_5 = new AtenaSealPartParam();
            宛名シール21面_5.set画面情報(editor.get宛名シール画面情報(parameter));
            宛名シール21面_5.set通し番号(new RString(indexCount));
            宛名シール21面_5.set投票資格情報(editor.get投票資格情報(宛名シール21面));
            宛名シール21面_5.set施設情報(宛名シール21面.get施設情報());
            param.set頁番号(indexPage);
            param.setParam5(宛名シール21面_5);
            itemCount++;
        } else if (itemCount == ページ件数21面_FIVE) {
            AtenaSealPartParam 宛名シール21面_6 = new AtenaSealPartParam();
            宛名シール21面_6.set画面情報(editor.get宛名シール画面情報(parameter));
            宛名シール21面_6.set通し番号(new RString(indexCount));
            宛名シール21面_6.set投票資格情報(editor.get投票資格情報(宛名シール21面));
            宛名シール21面_6.set施設情報(宛名シール21面.get施設情報());
            param.set頁番号(indexPage);
            param.setParam6(宛名シール21面_6);
            itemCount++;
        } else if (itemCount == ページ件数21面_SIX) {
            AtenaSealPartParam 宛名シール21面_7 = new AtenaSealPartParam();
            宛名シール21面_7.set画面情報(editor.get宛名シール画面情報(parameter));
            宛名シール21面_7.set通し番号(new RString(indexCount));
            宛名シール21面_7.set投票資格情報(editor.get投票資格情報(宛名シール21面));
            宛名シール21面_7.set施設情報(宛名シール21面.get施設情報());
            param.set頁番号(indexPage);
            param.setParam7(宛名シール21面_7);
            itemCount++;
        } else if (itemCount == ページ件数21面_SEVEN) {
            AtenaSealPartParam 宛名シール21面_8 = new AtenaSealPartParam();
            宛名シール21面_8.set画面情報(editor.get宛名シール画面情報(parameter));
            宛名シール21面_8.set通し番号(new RString(indexCount));
            宛名シール21面_8.set投票資格情報(editor.get投票資格情報(宛名シール21面));
            宛名シール21面_8.set施設情報(宛名シール21面.get施設情報());
            param.set頁番号(indexPage);
            param.setParam8(宛名シール21面_8);
            itemCount++;
        } else if (itemCount == ページ件数21面_EIGHT) {
            AtenaSealPartParam 宛名シール21面_9 = new AtenaSealPartParam();
            宛名シール21面_9.set画面情報(editor.get宛名シール画面情報(parameter));
            宛名シール21面_9.set通し番号(new RString(indexCount));
            宛名シール21面_9.set投票資格情報(editor.get投票資格情報(宛名シール21面));
            宛名シール21面_9.set施設情報(宛名シール21面.get施設情報());
            param.set頁番号(indexPage);
            param.setParam9(宛名シール21面_9);
            itemCount++;
        } else if (itemCount == ページ件数21面_NINE) {
            AtenaSealPartParam 宛名シール21面_10 = new AtenaSealPartParam();
            宛名シール21面_10.set画面情報(editor.get宛名シール画面情報(parameter));
            宛名シール21面_10.set通し番号(new RString(indexCount));
            宛名シール21面_10.set投票資格情報(editor.get投票資格情報(宛名シール21面));
            宛名シール21面_10.set施設情報(宛名シール21面.get施設情報());
            param.set頁番号(indexPage);
            param.setParam10(宛名シール21面_10);
            itemCount++;
        }
    }

    private void get宛名シール21面情報2(
            AtenaSealSakuseiJyohouEntity 宛名シール21面,
            AtenaSealSakuseiEditor editor) {
        if (itemCount == ページ件数21面_TEN) {
            AtenaSealPartParam 宛名シール21面_11 = new AtenaSealPartParam();
            宛名シール21面_11.set画面情報(editor.get宛名シール画面情報(parameter));
            宛名シール21面_11.set通し番号(new RString(indexCount));
            宛名シール21面_11.set投票資格情報(editor.get投票資格情報(宛名シール21面));
            宛名シール21面_11.set施設情報(宛名シール21面.get施設情報());
            param.set頁番号(indexPage);
            param.setParam11(宛名シール21面_11);
            itemCount++;
        } else if (itemCount == ページ件数21面_ELEVEN) {
            AtenaSealPartParam 宛名シール21面_12 = new AtenaSealPartParam();
            宛名シール21面_12.set画面情報(editor.get宛名シール画面情報(parameter));
            宛名シール21面_12.set通し番号(new RString(indexCount));
            宛名シール21面_12.set投票資格情報(editor.get投票資格情報(宛名シール21面));
            宛名シール21面_12.set施設情報(宛名シール21面.get施設情報());
            param.set頁番号(indexPage);
            param.setParam12(宛名シール21面_12);
            itemCount++;
        } else if (itemCount == ページ件数21面_TWELVE) {
            AtenaSealPartParam 宛名シール21面_13 = new AtenaSealPartParam();
            宛名シール21面_13.set画面情報(editor.get宛名シール画面情報(parameter));
            宛名シール21面_13.set通し番号(new RString(indexCount));
            宛名シール21面_13.set投票資格情報(editor.get投票資格情報(宛名シール21面));
            宛名シール21面_13.set施設情報(宛名シール21面.get施設情報());
            param.set頁番号(indexPage);
            param.setParam13(宛名シール21面_13);
            itemCount++;
        } else if (itemCount == ページ件数21面_THIRTEEN) {
            AtenaSealPartParam 宛名シール21面_14 = new AtenaSealPartParam();
            宛名シール21面_14.set画面情報(editor.get宛名シール画面情報(parameter));
            宛名シール21面_14.set通し番号(new RString(indexCount));
            宛名シール21面_14.set投票資格情報(editor.get投票資格情報(宛名シール21面));
            宛名シール21面_14.set施設情報(宛名シール21面.get施設情報());
            param.set頁番号(indexPage);
            param.setParam14(宛名シール21面_14);
            itemCount++;
        } else if (itemCount == ページ件数21面_FOURTEEN) {
            AtenaSealPartParam 宛名シール21面_15 = new AtenaSealPartParam();
            宛名シール21面_15.set画面情報(editor.get宛名シール画面情報(parameter));
            宛名シール21面_15.set通し番号(new RString(indexCount));
            宛名シール21面_15.set投票資格情報(editor.get投票資格情報(宛名シール21面));
            宛名シール21面_15.set施設情報(宛名シール21面.get施設情報());
            param.set頁番号(indexPage);
            param.setParam15(宛名シール21面_15);
            itemCount++;
        } else if (itemCount == ページ件数21面_FIFTEEN) {
            AtenaSealPartParam 宛名シール21面_16 = new AtenaSealPartParam();
            宛名シール21面_16.set画面情報(editor.get宛名シール画面情報(parameter));
            宛名シール21面_16.set通し番号(new RString(indexCount));
            宛名シール21面_16.set投票資格情報(editor.get投票資格情報(宛名シール21面));
            宛名シール21面_16.set施設情報(宛名シール21面.get施設情報());
            param.set頁番号(indexPage);
            param.setParam16(宛名シール21面_16);
            itemCount++;
        } else if (itemCount == ページ件数21面_SIXTEEN) {
            AtenaSealPartParam 宛名シール21面_17 = new AtenaSealPartParam();
            宛名シール21面_17.set画面情報(editor.get宛名シール画面情報(parameter));
            宛名シール21面_17.set通し番号(new RString(indexCount));
            宛名シール21面_17.set投票資格情報(editor.get投票資格情報(宛名シール21面));
            宛名シール21面_17.set施設情報(宛名シール21面.get施設情報());
            param.set頁番号(indexPage);
            param.setParam17(宛名シール21面_17);
            itemCount++;
        } else if (itemCount == ページ件数21面_SEVENTEEN) {
            AtenaSealPartParam 宛名シール21面_18 = new AtenaSealPartParam();
            宛名シール21面_18.set画面情報(editor.get宛名シール画面情報(parameter));
            宛名シール21面_18.set通し番号(new RString(indexCount));
            宛名シール21面_18.set投票資格情報(editor.get投票資格情報(宛名シール21面));
            宛名シール21面_18.set施設情報(宛名シール21面.get施設情報());
            param.set頁番号(indexPage);
            param.setParam18(宛名シール21面_18);
            itemCount++;
        } else if (itemCount == ページ件数21面_EIGHTEEN) {
            AtenaSealPartParam 宛名シール21面_19 = new AtenaSealPartParam();
            宛名シール21面_19.set画面情報(editor.get宛名シール画面情報(parameter));
            宛名シール21面_19.set通し番号(new RString(indexCount));
            宛名シール21面_19.set投票資格情報(editor.get投票資格情報(宛名シール21面));
            宛名シール21面_19.set施設情報(宛名シール21面.get施設情報());
            param.set頁番号(indexPage);
            param.setParam19(宛名シール21面_19);
            itemCount++;
        } else if (itemCount == ページ件数21面_NINETEEN) {
            AtenaSealPartParam 宛名シール21面_20 = new AtenaSealPartParam();
            宛名シール21面_20.set画面情報(editor.get宛名シール画面情報(parameter));
            宛名シール21面_20.set通し番号(new RString(indexCount));
            宛名シール21面_20.set投票資格情報(editor.get投票資格情報(宛名シール21面));
            宛名シール21面_20.set施設情報(宛名シール21面.get施設情報());
            param.set頁番号(indexPage);
            param.setParam20(宛名シール21面_20);
            itemCount++;
        } else if (itemCount == ページ件数21面_TWENTY) {
            AtenaSealPartParam 宛名シール21面_21 = new AtenaSealPartParam();
            宛名シール21面_21.set画面情報(editor.get宛名シール画面情報(parameter));
            宛名シール21面_21.set通し番号(new RString(indexCount));
            宛名シール21面_21.set投票資格情報(editor.get投票資格情報(宛名シール21面));
            宛名シール21面_21.set施設情報(宛名シール21面.get施設情報());
            param.set頁番号(indexPage);
            param.setParam21(宛名シール21面_21);
            itemCount++;
        }
    }

    @Override
    protected void afterExecute() {
        if (isHasデータ1(param) || isHasデータ2(param)) {
            AtenaSeal21Report report = new AtenaSeal21Report(param);
            report.writeBy(reportSourceWCLWriter);
        }
        pageCount.setValue(batchReportWCLWriter.getPageCount());
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

    private void create文字切れ一覧表に出力Writer() {
        CheckListLineItemSet pairs = CheckListLineItemSet.of(
                AtenaSealSakuseiAtenaSeal21ReportProcess.特定項目.class,
                AtenaSealSakuseiAtenaSeal21ReportProcess.チェック項目.class);
        ICheckListInfo info = CheckListInfoFactory.createInstance(
                SubGyomuCode.AFA選挙本体,
                AssociationFinderFactory.createInstance().getAssociation());

        batchReportWCLWriter = BatchWriters
                .batchReportWriterWithCheckList(AtenaSeal21Source.class)
                .checkListInfo(info)
                .checkListLineItemSet(pairs)
                .reportId(ReportIdKeys.AFAPRE214_宛名シール21面.value())
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

    private boolean is表示者(AtenaSealSakuseiJyohouEntity 宛名シール21面) {
        ShikakuHantei shikakuhantei = new ShikakuHantei();
        return shikakuhantei.is表示者(宛名シール21面.get宛名PSM情報(),
                宛名シール21面.get選挙情報().getTenshutsuKigenYMD(),
                parameter.get年齢到達期限日(),
                parameter.get投票年月日(),
                parameter.get前回基準日(),
                SenkyoShurui.toValue(選挙種類));
    }
}
