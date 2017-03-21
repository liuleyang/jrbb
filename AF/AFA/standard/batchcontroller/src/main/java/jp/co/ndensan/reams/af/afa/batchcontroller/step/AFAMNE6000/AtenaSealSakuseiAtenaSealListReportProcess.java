/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNE6000;

import jp.co.ndensan.reams.af.afa.business.core.AtenaSealListParam;
import jp.co.ndensan.reams.af.afa.business.core.atenasealsakusei.AtenaSealSakuseiEditor;
import jp.co.ndensan.reams.af.afa.business.core.shohonselect.ShohonResult;
import jp.co.ndensan.reams.af.afa.business.report.AFAPRE215.AtenaSealListReport;
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
import jp.co.ndensan.reams.af.afa.entity.report.AFAPRE215.AtenaSealListSource;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.nyujokenikkatsu.INyujokenIkkatsuMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.af.afa.service.core.shohonselect.ShohonSelectFinder;
import jp.co.ndensan.reams.af.afa.service.nyujokenikkatsu.NyujokenIkkatsuFinder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
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
 * 宛名シール出力対象者一覧のクラスです。
 *
 * @reamsid_L AF-0620-020 guancy
 */
public class AtenaSealSakuseiAtenaSealListReportProcess extends BatchProcessBase<AtenaSealSakuseiJyohouEntity> {

    private AtenaSealSakuseiMybatisParameter mybatisParameter;
    private NyujokenIkkatsuMybatisParameter mybatisParameter1;
    private AFABTE601SelectProcessParameter parameter;
    private ShohonSelectFinder finder;
    private INyujokenIkkatsuMapper mapper;
    private NyujokenIkkatsuFinder finder1;
    private AfaMapperProvider mapperProvider;
    private RString 選挙種類;
    private RString 自市町村の県コード;
    RString 起動画面ID;
    private static final RString 対象選挙の選挙レベル_県レベル = new RString("2");
    private static final RString 選挙人宛名シール_画面ID = new RString("AFAGME6010");
    private static final RString 転出者宛名シール_画面ID = new RString("AFAGME6020");
    private static final RString 施設宛名シール_画面ID = new RString("AFAGME6030");
    private RString selectId;
    private static final RString MYBATIS_SELECT_ID1 = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.atenasealsakusei.IAtenaSealSakuseiMapper.select選挙人宛名シール情報");
    private static final RString MYBATIS_SELECT_ID2 = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.atenasealsakusei.IAtenaSealSakuseiMapper.select転出者宛名シール情報");
    private static final RString MYBATIS_SELECT_ID3 = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.atenasealsakusei.IAtenaSealSakuseiMapper.select施設宛名シール情報");
    @BatchWriter
    private BatchReportWriter<AtenaSealListSource> batchReportWriter;
    private ReportSourceWriter<AtenaSealListSource> reportSourceWriter;
    /**
     * ページ数Parameterです。
     */
    public static final RString PAGE_COUNT;

    static {
        PAGE_COUNT = new RString("pageCount");
    }
    OutputParameter<Integer> pageCount;
    private Association 地方公共団体情報;

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
        RString 転出期限日検索基準 = BusinessConfig.get(ConfigKeysAFA.転出期限日検索基準, SubGyomuCode.AFA選挙本体);
        mybatisParameter.set転出期限日検索基準(転出期限日検索基準);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(selectId, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdKeys.AFAPRE215_宛名シール出力対象者一覧.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);

    }

    @Override
    protected void process(AtenaSealSakuseiJyohouEntity 施設宛名シール出力対象者一覧情報) {
        if (選挙人宛名シール_画面ID.equals(起動画面ID)) {
            get宛名シール情報(施設宛名シール出力対象者一覧情報);
        } else if (転出者宛名シール_画面ID.equals(起動画面ID)) {
            RString 転出先全国住所コード = RString.EMPTY;
            Boolean isHasData = Boolean.FALSE;
            ZenkokuJushoCode 全国住所コード = 施設宛名シール出力対象者一覧情報.get宛名PSM情報().getZenkokuJushoCode();
            if (全国住所コード != null) {
                転出先全国住所コード = 全国住所コード.getColumnValue();
                isHasData = Boolean.TRUE;
            }
            if (is表示者(施設宛名シール出力対象者一覧情報)
                    && !(対象選挙の選挙レベル_県レベル.equals(parameter.get選挙レベル())
                    && isHasData
                    && 転出先全国住所コード.length() >= 2
                    && 自市町村の県コード.length() >= 2
                    && !転出先全国住所コード.substring(0, 2).equals(自市町村の県コード.substring(0, 2)))) {
                get宛名シール情報(施設宛名シール出力対象者一覧情報);
            }
        } else if (施設宛名シール_画面ID.equals(起動画面ID)) {
            get宛名シール情報(施設宛名シール出力対象者一覧情報);
        }

    }

    private void get宛名シール情報(AtenaSealSakuseiJyohouEntity 施設宛名シール出力対象者一覧情報) {
        AtenaSealListParam param = new AtenaSealListParam(null, parameter.get起動画面ID(), 地方公共団体情報, null, null);
        AtenaSealSakuseiEditor editor = new AtenaSealSakuseiEditor();
        param.set画面情報(editor.get宛名シール出力対象者一覧画面情報(parameter));
        param.set投票資格情報(
                editor.get出力対象者一覧投票資格情報(施設宛名シール出力対象者一覧情報,
                        parameter.get起動画面ID()));
        AtenaSealListReport report = new AtenaSealListReport(param);
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void afterExecute() {
        pageCount.setValue(batchReportWriter.getPageCount());
    }

    private boolean is表示者(AtenaSealSakuseiJyohouEntity 宛名シール) {
        ShikakuHantei shikakuhantei = new ShikakuHantei();
        return shikakuhantei.is表示者(宛名シール.get宛名PSM情報(),
                宛名シール.get選挙情報().getTenshutsuKigenYMD(),
                parameter.get年齢到達期限日(),
                parameter.get投票年月日(),
                parameter.get前回基準日(),
                SenkyoShurui.toValue(選挙種類));
    }
}
