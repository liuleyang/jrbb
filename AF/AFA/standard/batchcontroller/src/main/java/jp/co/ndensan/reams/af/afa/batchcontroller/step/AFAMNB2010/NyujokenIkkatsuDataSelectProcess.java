/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB2010;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.af.afa.business.taishodatecommon.TaishoDateCommon;
import jp.co.ndensan.reams.af.afa.business.util.shikakuhantei.ShikakuHantei;
import jp.co.ndensan.reams.af.afa.definition.batchprm.nyujokenikkatsu.TohyokuJyohou;
import jp.co.ndensan.reams.af.afa.definition.configkeys.AFAConfigKeysValue;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.MasshoJiyuCodeEnum;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ShutsuryokuShuryohiEnum;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.nyujokenikkatsu.AFABTB201SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.nyujokenikkatsu.NyujokenIkkatsuMybatisParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.nyujokenkobetsu.NyujokenKobetsuJouhou;
import jp.co.ndensan.reams.af.afa.entity.xml.nyujokenikkatsu.AFABTB201SenkyoninMeiciJyohouEntity;
import jp.co.ndensan.reams.af.afa.entity.xml.nyujokenikkatsu.AFABTB201SoufusakiJouhouEntity;
import jp.co.ndensan.reams.af.afa.entity.xml.nyujokenikkatsu.NyujokenIkkatsuEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.nyujokenikkatsu.INyujokenIkkatsuMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.af.afa.service.nyujokenikkatsu.NyujokenIkkatsuFinder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TohyokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 入場券発行（一括）のデータ取得のクラスです。
 *
 * @reamsid_L AF-0160-020 guyq
 */
public class NyujokenIkkatsuDataSelectProcess extends BatchKeyBreakBase<NyujokenIkkatsuEntity> {

    private NyujokenIkkatsuMybatisParameter mybatisParameter;
    private AFABTB201SelectProcessParameter parameter;
    private ShikakuHantei shikakuhantei;
    private OutputParameter<RString> outTempTableName;
    private OutputParameter<RString> meiciJyohouTableName;
    private INyujokenIkkatsuMapper mapper;
    private NyujokenIkkatsuFinder finder;
    private AfaMapperProvider mapperProvider;
    private TaishoDateCommon taishoDateCommon;
    private static final RString TEMP_TABLE_SOUFUSAKIJOUHOU = new RString("AFABTB201_SoufusakiJouhou");
    private static final RString TEMP_TABLE_ICIJYOHOU = new RString("AFABTB201_SenkyoninMeiciJyohou");
    private static final int ZENKOKUJUSHOCODE_LENGTH = 11;
    private static final RString ZENKOKUJUSHOCODE_PADDING = new RString("0");
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.nyujokenikkatsu.INyujokenIkkatsuMapper.select選挙人明細情報リスト");
    private int flag;
    private static final RString 有権者分 = new RString("1");
    private static final RString 表示者分 = new RString("2");
    private static final RString 再転入者分 = new RString("3");
    private Map<SetaiCode, Set<ShikibetsuCode>> 入場券_世帯員最大人数;
    private SetaiCode 世帯員最大人数_世帯コード;
    private Integer 世帯員最大人数_人数;
    private static SetaiCode 有権者分_世帯コード;
    private static SetaiCode 表示者分_世帯コード;

    static boolean is有権者分hasBreak = Boolean.TRUE;
    private static boolean is表示者分hasBreak = Boolean.TRUE;
    /**
     * 送付先情報_temp取得。
     *
     */
    public static final RString OUT_TEMP_TABLE_NAME;
    /**
     * 入場券発行明細情報_temp取得。
     *
     */
    public static final RString MEICI_JYOHOU_TABLE_NAME;

    static {
        OUT_TEMP_TABLE_NAME = new RString("outTempTableName");
        MEICI_JYOHOU_TABLE_NAME = new RString("meiciJyohouTableName");
    }
    /**
     * ページ数Parameterです。
     */
    public static final RString SETAI_CODE;

    static {
        SETAI_CODE = new RString("setaiCode");
    }

    OutputParameter<SetaiCode> setaiCode;
    /**
     * ページ数Parameterです。
     */
    public static final RString SETAI_CODE_COUNT;

    static {
        SETAI_CODE_COUNT = new RString("setaiCodeCount");
    }

    OutputParameter<Integer> setaiCodeCount;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter soufusakiJouhouDbWriter;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter senkyoninMeiciJyohouDbWriter;

    @Override
    protected void initialize() {
        shikakuhantei = new ShikakuHantei();
        有権者分_世帯コード = SetaiCode.EMPTY;
        表示者分_世帯コード = SetaiCode.EMPTY;
        flag = 0;
        ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.住登外優先);
        FlexibleDate 投票日 = parameter.get投票日();
        if (null != 投票日) {
            build.set基準日(投票日);
        } else {
            build.set基準日(FlexibleDate.getNowDate());
        }
        build.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        List<JuminShubetsu> 住民種別 = new ArrayList<>();
        住民種別.add(JuminShubetsu.日本人);
        住民種別.add(JuminShubetsu.住登外個人_日本人);
        build.set住民種別(住民種別);
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = build.build();
        IAssociationFinder associationFinder = AssociationFinderFactory.createInstance();
        Association 地方公共団体情報 = associationFinder.getAssociation();
        LasdecCode 地方公共団体コード = 地方公共団体情報.get地方公共団体コード();
        int 連番 = 地方公共団体情報.get連番();
        FlexibleDate システム日付 = FlexibleDate.getNowDate();
        parameter.setKey(shikibetsuTaishoPSMSearchKey);
        mybatisParameter = parameter.toNyujokenIkkatsuMybatisParameter();
        mybatisParameter.setシステム日付(システム日付);
        mybatisParameter.set地方公共団体コード(地方公共団体コード);
        mybatisParameter.set連番(連番);

        finder = NyujokenIkkatsuFinder.createInstance();
        AfT100ShohonEntity entity = finder.get抄本情報(parameter.get抄本番号());
        if (entity != null) {
            parameter.set年齢到達期限日(entity.getKiteiNenreiTotatsuYMD());
        } else {
            parameter.set年齢到達期限日(FlexibleDate.EMPTY);
        }
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
        mapper = mapperProvider.create(INyujokenIkkatsuMapper.class);
        mybatisParameter.setKijunYMD(parameter.get投票日());
        NyujokenKobetsuJouhou 前回基準日entity = mapper.select抄本の前回基準日(mybatisParameter);
        if (前回基準日entity != null) {
            parameter.set前回基準日(前回基準日entity.get前回基準日());
        } else {
            parameter.set前回基準日(FlexibleDate.EMPTY);
        }
        NyujokenKobetsuJouhou 選挙 = mapper.select選挙の転入期限日(mybatisParameter);
        if (選挙 != null) {
            parameter.set転入期限日(選挙.get転入期限日());
            parameter.set転出日From(選挙.get転出期限日());
        } else {
            parameter.set転入期限日(FlexibleDate.EMPTY);
            parameter.set転出日From(FlexibleDate.EMPTY);
        }
        入場券_世帯員最大人数 = new HashMap<>();
        世帯員最大人数_世帯コード = SetaiCode.EMPTY;
        世帯員最大人数_人数 = 0;
        setaiCode = new OutputParameter<>();
        setaiCodeCount = new OutputParameter<>();
        taishoDateCommon = new TaishoDateCommon();
    }

    @Override
    protected void beforeExecute() {
        outTempTableName = new OutputParameter<>();
        meiciJyohouTableName = new OutputParameter<>();
    }

    @Override
    protected void createWriter() {
        this.soufusakiJouhouDbWriter
                = new BatchEntityCreatedTempTableWriter(TEMP_TABLE_SOUFUSAKIJOUHOU, AFABTB201SoufusakiJouhouEntity.class);
        this.senkyoninMeiciJyohouDbWriter
                = new BatchEntityCreatedTempTableWriter(TEMP_TABLE_ICIJYOHOU, AFABTB201SenkyoninMeiciJyohouEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParameter);
    }

    @Override
    protected void keyBreakProcess(NyujokenIkkatsuEntity senkyoEntity) {
        //TODO QA#94926
        get有権者分対象情報(senkyoEntity);
        get表示者分対象情報(senkyoEntity);
        SetaiCode 世帯コードcurrent = SetaiCode.EMPTY;
        if (senkyoEntity.get宛名PSM情報() != null) {
            世帯コードcurrent = senkyoEntity.get宛名PSM情報().getSetaiCode();
        }
        if (flag == 1
                && !有権者分_世帯コード.equals(世帯コードcurrent)) {
            is有権者分hasBreak = Boolean.TRUE;
        } else if (flag == 1
                && 有権者分_世帯コード.equals(世帯コードcurrent)) {
            is有権者分hasBreak = Boolean.FALSE;
        } else if (flag == 2
                && !表示者分_世帯コード.equals(世帯コードcurrent)) {
            is表示者分hasBreak = Boolean.TRUE;
        } else if (flag == 2
                && 表示者分_世帯コード.equals(世帯コードcurrent)) {
            is表示者分hasBreak = Boolean.FALSE;
        }
    }

    @Override
    protected void usualProcess(NyujokenIkkatsuEntity senkyoEntity) {
        flag = 0;
        //TODO QA#94926
        get有権者分対象情報(senkyoEntity);
        get表示者分対象情報(senkyoEntity);
        if (flag == 1) {
            AFABTB201SenkyoninMeiciJyohouEntity senkyoninMeiciJyohouEntity = new AFABTB201SenkyoninMeiciJyohouEntity();
            set入場券発行明細情報ToTempTbl(senkyoEntity, senkyoninMeiciJyohouEntity, 有権者分);

            senkyoninMeiciJyohouDbWriter.insert(senkyoninMeiciJyohouEntity);
            if (is有権者分hasBreak) {
                AFABTB201SoufusakiJouhouEntity tempTblInsertEntity = new AFABTB201SoufusakiJouhouEntity();
                setDataToTempTblFor有権者(senkyoEntity, tempTblInsertEntity);
                soufusakiJouhouDbWriter.insert(tempTblInsertEntity);
                有権者分_世帯コード = senkyoEntity.get宛名PSM情報() == null
                        ? SetaiCode.EMPTY : senkyoEntity.get宛名PSM情報().getSetaiCode();
                is有権者分hasBreak = Boolean.FALSE;
            }

        } else if (flag == 2) {
            AFABTB201SenkyoninMeiciJyohouEntity senkyoninMeiciJyohouEntity = new AFABTB201SenkyoninMeiciJyohouEntity();
            set入場券発行明細情報ToTempTbl(senkyoEntity, senkyoninMeiciJyohouEntity, 表示者分);
            if (is再転入者(senkyoEntity)) {
                set入場券発行明細情報ToTempTbl(senkyoEntity, senkyoninMeiciJyohouEntity, 再転入者分);
            }
            senkyoninMeiciJyohouDbWriter.insert(senkyoninMeiciJyohouEntity);
            if (is表示者分hasBreak) {
                AFABTB201SoufusakiJouhouEntity tempTblInsertEntity = new AFABTB201SoufusakiJouhouEntity();
                setDataToTempTblFor表示者分(senkyoEntity, tempTblInsertEntity);
                soufusakiJouhouDbWriter.insert(tempTblInsertEntity);
                表示者分_世帯コード = senkyoEntity.get宛名PSM情報() == null
                        ? SetaiCode.EMPTY : senkyoEntity.get宛名PSM情報().getSetaiCode();
                is表示者分hasBreak = Boolean.FALSE;
            }
        }
    }

    @Override
    protected void afterExecute() {
        for (SetaiCode key : 入場券_世帯員最大人数.keySet()) {
            if (世帯員最大人数_人数 < 入場券_世帯員最大人数.get(key).size()) {
                世帯員最大人数_世帯コード = key;
                世帯員最大人数_人数 = 入場券_世帯員最大人数.get(key).size();
            }
        }
        setaiCode.setValue(世帯員最大人数_世帯コード);
        setaiCodeCount.setValue(世帯員最大人数_人数);
        outTempTableName.setValue(TEMP_TABLE_SOUFUSAKIJOUHOU);
        meiciJyohouTableName.setValue(TEMP_TABLE_ICIJYOHOU);
    }

    private void get有権者分対象情報(NyujokenIkkatsuEntity entity) {
        for (TohyokuJyohou 投票区 : parameter.get投票区リスト()) {
            if ((RString.isNullOrEmpty(投票区.get投票区コード())
                    && RString.isNullOrEmpty(get投票区コード(entity)))
                    || (投票区.get投票区コード().equals(get投票区コード(entity))
                    && (is有権者(entity) || (is表示者(entity) && 有権者分対象_抽出終了日判定(entity))))) {
                flag = 1;
                break;
            }

        }
    }

    private RString get投票区コード(NyujokenIkkatsuEntity entity) {
        if ((SenkyoShurui.国政選挙_地方選挙.getCode().equals(parameter.get選挙種類())
                || SenkyoShurui.定時登録.getCode().equals(parameter.get選挙種類()))) {
            if (entity.getUr投票区情報() != null) {
                return entity.getUr投票区情報().getTohyokuCode().value();
            }
        } else {
            if (entity.get投票区情報() != null) {
                return entity.get投票区情報().getTohyokuCode();
            }
        }
        return RString.EMPTY;
    }

    private void get表示者分対象情報(NyujokenIkkatsuEntity entity) {
        RString 表示者用入場券出力区分 = BusinessConfig.get(ConfigKeysAFA.入場券_表示者用入場券出力区分, SubGyomuCode.AFA選挙本体);
        if (!AFAConfigKeysValue.入場券_表示者用入場券出力区分_出力しない.configKeyValue()
                .equals(表示者用入場券出力区分)) {
            if (is表示者(entity)
                    && 表示者分対象_抽出終了日判定(entity)) {
                flag = 2;
            }
            if (is抹消者(entity)
                    && is二重登録抹消(entity)) {
                flag = 2;
            }
        }
    }

    private boolean is有権者(NyujokenIkkatsuEntity senkyoEntity) {
        return shikakuhantei.is有権者(senkyoEntity.get宛名PSM情報(),
                parameter.get転入期限日(), parameter.get年齢到達期限日(), parameter.get投票日(),
                SenkyoShurui.toValue(parameter.get選挙種類()), senkyoEntity.get選挙資格情報());
    }

    private boolean is表示者(NyujokenIkkatsuEntity senkyoEntity) {
        return shikakuhantei.is表示者(senkyoEntity.get宛名PSM情報(),
                parameter.get転出日From(), parameter.get年齢到達期限日(), parameter.get投票日(), parameter.get前回基準日(),
                SenkyoShurui.toValue(parameter.get選挙種類()));
    }

    private boolean is抹消者(NyujokenIkkatsuEntity senkyoEntity) {
        return shikakuhantei.is抹消者(senkyoEntity.get宛名PSM情報(),
                parameter.get転出日From(), parameter.get年齢到達期限日());
    }

    private boolean is再転入者(NyujokenIkkatsuEntity senkyoEntity) {
        List<UaFt200FindShikibetsuTaishoEntity> entityList = new ArrayList<>();
        entityList.add(senkyoEntity.get宛名PSM情報());
        return shikakuhantei.is再転入者(entityList,
                parameter.get転出日From(), parameter.get転入期限日(), parameter.get年齢到達期限日());
    }

    private boolean 有権者分対象_抽出終了日判定(NyujokenIkkatsuEntity senkyoEntity) {
        RString 抽出終了日設定 = BusinessConfig.get(ConfigKeysAFA.転出者はがき_抽出終了日設定, SubGyomuCode.AFA選挙本体);
        FlexibleDate 転出日 = get転出日(senkyoEntity);
        if (ShutsuryokuShuryohiEnum.投票日を含めない.getValue().equals(抽出終了日設定)) {
            return !転出日.isBeforeOrEquals(parameter.get投票日().minusDay(1));
        } else if (ShutsuryokuShuryohiEnum.投票日を含める.getValue().equals(抽出終了日設定)) {
            return !転出日.isBeforeOrEquals(parameter.get投票日());
        } else if (ShutsuryokuShuryohiEnum.入場券発行処理日の前日まで.getValue().equals(抽出終了日設定)) {
            return !転出日.isBeforeOrEquals(new FlexibleDate(RDate.getNowDate().minusDay(1).toDateString()));
        } else if (ShutsuryokuShuryohiEnum.入場券発行処理日まで.getValue().equals(抽出終了日設定)) {
            return !転出日.isBeforeOrEquals(new FlexibleDate(RDate.getNowDate().toDateString()));
        }
        return Boolean.FALSE;

    }

    private boolean 表示者分対象_抽出終了日判定(NyujokenIkkatsuEntity senkyoEntity) {
        RString 抽出終了日設定 = BusinessConfig.get(ConfigKeysAFA.転出者はがき_抽出終了日設定, SubGyomuCode.AFA選挙本体);
        FlexibleDate 転出日 = get転出日(senkyoEntity);
        boolean isBlank = Boolean.TRUE;
        if (!FlexibleDate.EMPTY.equals(parameter.get転出日From())
                && FlexibleDate.EMPTY.equals(parameter.get転出日To())) {
            isBlank = parameter.get転出日From().isBeforeOrEquals(転出日)
                    && !parameter.get転出日To().isBefore(転出日);
        }
        if (ShutsuryokuShuryohiEnum.投票日を含めない.getValue().equals(抽出終了日設定)) {
            return 転出日.isBeforeOrEquals(parameter.get投票日().minusDay(1)) && isBlank;
        } else if (ShutsuryokuShuryohiEnum.投票日を含める.getValue().equals(抽出終了日設定)) {
            return 転出日.isBeforeOrEquals(parameter.get投票日()) && isBlank;
        } else if (ShutsuryokuShuryohiEnum.入場券発行処理日の前日まで.getValue().equals(抽出終了日設定)) {
            return 転出日.isBeforeOrEquals(new FlexibleDate(RDate.getNowDate().minusDay(1).toDateString())) && isBlank;
        } else if (ShutsuryokuShuryohiEnum.入場券発行処理日まで.getValue().equals(抽出終了日設定)) {
            return 転出日.isBeforeOrEquals(new FlexibleDate(RDate.getNowDate().toDateString())) && isBlank;
        }
        return Boolean.FALSE;

    }

    private FlexibleDate get転出日(NyujokenIkkatsuEntity senkyoEntity) {
        return taishoDateCommon.get共通化对象日付(senkyoEntity.get宛名PSM情報());
    }

    private boolean is二重登録抹消(NyujokenIkkatsuEntity senkyoEntity) {
        if (MasshoJiyuCodeEnum.二重登録抹消.getCode()
                .equals(senkyoEntity.get選挙資格情報().getMasshoJiyuCode())) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private void setDataToTempTblFor有権者(NyujokenIkkatsuEntity fromData, AFABTB201SoufusakiJouhouEntity toDataFor有権者) {
        if (fromData.get宛名PSM情報() != null) {
            toDataFor有権者.setShikibetsuCode(fromData.get宛名PSM情報().getShikibetsuCode());
            toDataFor有権者.setYubinNo(fromData.get宛名PSM情報().getJutonaiYubinNo());
            toDataFor有権者.setGyoseikuCode(fromData.get宛名PSM情報().getGyoseikuCode());
            ChoikiCode 住登内町域コード = fromData.get宛名PSM情報().getJutonaiChoikiCode();
            toDataFor有権者.setZenkokuJushoCode(住登内町域コード == null ? ZenkokuJushoCode.EMPTY
                    : new ZenkokuJushoCode(住登内町域コード.value().padLeft(ZENKOKUJUSHOCODE_PADDING, ZENKOKUJUSHOCODE_LENGTH)));
            toDataFor有権者.setChikuCode1(fromData.get宛名PSM情報().getChikuCode1());
            toDataFor有権者.setChikuName1(fromData.get宛名PSM情報().getChikuName1());
            toDataFor有権者.setSetaiCode(fromData.get宛名PSM情報().getSetaiCode());

            AtenaMeisho 世帯主名 = fromData.get宛名PSM情報().getSetainushiMei();
            toDataFor有権者.setSetaiName(世帯主名 == null ? AtenaMeisho.EMPTY : 世帯主名);

            RString 住登内番地 = fromData.get宛名PSM情報().getJutonaiJusho();
            toDataFor有権者.setJusho(RString.isNullOrEmpty(住登内番地) ? AtenaJusho.EMPTY : new AtenaJusho(住登内番地));

            toDataFor有権者.setBanchi(fromData.get宛名PSM情報().getJutonaiBanchi());

            Katagaki 方書 = fromData.get宛名PSM情報().getKatagaki();
            toDataFor有権者.setKatagaki(方書 == null ? Katagaki.EMPTY : 方書);

            toDataFor有権者.setGyoseikuName(fromData.get宛名PSM情報().getGyoseikuName());

            AtenaMeisho 名称 = fromData.get宛名PSM情報().getMeisho();
            toDataFor有権者.setMeisho(名称 == null ? RString.EMPTY : 名称.getColumnValue());

            TohyokuCode 投票区コード = fromData.get宛名PSM情報().getTohyokuCode();
            toDataFor有権者.setTohyokuCode(投票区コード == null ? RString.EMPTY : 投票区コード.getColumnValue());
        }
        if (fromData.get選挙人名簿情報() != null) {
            toDataFor有権者.setSatsu(fromData.get選挙人名簿情報().getSatsu());

            toDataFor有権者.setPage(fromData.get選挙人名簿情報().getPage());
            toDataFor有権者.setGyo(fromData.get選挙人名簿情報().getGyo());
        }

        toDataFor有権者.setGroupKubun(有権者分);
    }

    private void setDataToTempTblFor表示者分(NyujokenIkkatsuEntity fromData, AFABTB201SoufusakiJouhouEntity toDataFor表示者分) {
        if (fromData.get宛名PSM情報() != null) {
            toDataFor表示者分.setShikibetsuCode(fromData.get宛名PSM情報().getShikibetsuCode());
            toDataFor表示者分.setYubinNo(fromData.get宛名PSM情報().getYubinNo());
            toDataFor表示者分.setGyoseikuCode(fromData.get宛名PSM情報().getGyoseikuCode());
            toDataFor表示者分.setZenkokuJushoCode(fromData.get宛名PSM情報().getZenkokuJushoCode());
            toDataFor表示者分.setChikuCode1(fromData.get宛名PSM情報().getChikuCode1());
            toDataFor表示者分.setChikuName1(fromData.get宛名PSM情報().getChikuName1());
            toDataFor表示者分.setSetaiCode(fromData.get宛名PSM情報().getSetaiCode());
            toDataFor表示者分.setSetaiName(fromData.get宛名PSM情報().getSetainushiMei());
            toDataFor表示者分.setJusho(fromData.get宛名PSM情報().getJusho());
            toDataFor表示者分.setBanchi(fromData.get宛名PSM情報().getBanchi());
            toDataFor表示者分.setKatagaki(fromData.get宛名PSM情報().getKatagaki());
            toDataFor表示者分.setGyoseikuName(fromData.get宛名PSM情報().getGyoseikuName());
            AtenaMeisho 名称 = fromData.get宛名PSM情報().getMeisho();
            toDataFor表示者分.setMeisho(名称 == null ? RString.EMPTY : 名称.getColumnValue());
            TohyokuCode 投票区コード = fromData.get宛名PSM情報().getTohyokuCode();
            toDataFor表示者分.setTohyokuCode(投票区コード == null ? RString.EMPTY : 投票区コード.getColumnValue());
        }

        if (fromData.get選挙人名簿情報() != null) {
            toDataFor表示者分.setSatsu(fromData.get選挙人名簿情報().getSatsu());
            toDataFor表示者分.setPage(fromData.get選挙人名簿情報().getPage());
            toDataFor表示者分.setGyo(fromData.get選挙人名簿情報().getGyo());
        }
        toDataFor表示者分.setGroupKubun(表示者分);
    }

    private void set入場券発行明細情報ToTempTbl(NyujokenIkkatsuEntity fromData,
            AFABTB201SenkyoninMeiciJyohouEntity toData, RString flag) {
        if (fromData.get宛名PSM情報() != null) {
            toData.setJutonaiJusho(fromData.get宛名PSM情報().getJutonaiJusho());
            AtenaMeisho 名称 = fromData.get宛名PSM情報().getMeisho();
            toData.setMeisho(名称 == null ? RString.EMPTY : 名称.getColumnValue());
            toData.setKanaMeisho(fromData.get宛名PSM情報().getKanaName());
            toData.setSeinengappiYMD(fromData.get宛名PSM情報().getSeinengappiYMD());
            toData.setSeibetsuCode(fromData.get宛名PSM情報().getSeibetsuCode());
            toData.setShikibetsuCode(fromData.get宛名PSM情報().getShikibetsuCode());
            toData.setGyoseikuCode(fromData.get宛名PSM情報().getGyoseikuCode());
            toData.setGyoseikuName(fromData.get宛名PSM情報().getGyoseikuName());
            toData.setChikuCode1(fromData.get宛名PSM情報().getChikuCode1());
            toData.setChikuCode2(fromData.get宛名PSM情報().getChikuCode2());
            toData.setChikuCode3(fromData.get宛名PSM情報().getChikuCode3());
            toData.setChikuName1(fromData.get宛名PSM情報().getChikuName1());
            toData.setChikuName2(fromData.get宛名PSM情報().getChikuName2());
            toData.setChikuName3(fromData.get宛名PSM情報().getChikuName3());
            toData.setSetaiCode(fromData.get宛名PSM情報().getSetaiCode());
            toData.setSetaiName(fromData.get宛名PSM情報().getSetainushiMei());
            toData.setTsuzukigaraCode(fromData.get宛名PSM情報().getTsuzukigaraCode());
            toData.setZenkokuJushoCode(fromData.get宛名PSM情報().getZenkokuJushoCode());
            toData.setJutonaiChoikiCode(fromData.get宛名PSM情報().getJutonaiChoikiCode());
            toData.setJutonaiBanchi(fromData.get宛名PSM情報().getJutonaiBanchi());
            toData.setJutonaiKatagaki(fromData.get宛名PSM情報().getJutonaiKatagaki());
            toData.setJuminShubetsuCode(fromData.get宛名PSM情報().getJuminShubetsuCode());
            toData.setJuminhyoHyojijun(fromData.get宛名PSM情報().getJuminhyoHyojijun());
            toData.setPsmJusho(fromData.get宛名PSM情報().getJusho());
            toData.setBanchi(fromData.get宛名PSM情報().getBanchi());
            toData.setKatagaki(fromData.get宛名PSM情報().getKatagaki());
            toData.setTeshuYubinNo(fromData.get宛名PSM情報().getJutonaiYubinNo());
            toData.setTorokuTodokedeYMD(fromData.get宛名PSM情報().getTorokuTodokedeYMD());
            toData.setSetainushiMei(fromData.get宛名PSM情報().getSetainushiMei());
            toData.setYubinNo(fromData.get宛名PSM情報().getYubinNo());
        }
        if ((SenkyoShurui.国政選挙_地方選挙.getCode().equals(parameter.get選挙種類())
                || SenkyoShurui.定時登録.getCode().equals(parameter.get選挙種類()))) {
            if (fromData.getUr投票区情報() != null) {
                toData.setTohyokuCode(fromData.getUr投票区情報().getTohyokuCode().value());
                toData.setTohyokuName(fromData.getUr投票区情報().getName());
            }
        } else {
            if (fromData.get投票区情報() != null) {
                toData.setTohyokuCode(fromData.get投票区情報().getTohyokuCode());
                toData.setTohyokuName(fromData.get投票区情報().getTohyokuName());
            }
        }
        if (fromData.get投票所情報() != null) {
            toData.setTohyojoCode(fromData.get投票所情報().getTohyojoCode());
            toData.setTohyojoName(fromData.get投票所情報().getTohyojoName());
            toData.setTohyoStartTime(fromData.get投票所情報().getTohyoStartTime());
            toData.setTohyoStopTime(fromData.get投票所情報().getTohyoStopTime());
            toData.setJusho(fromData.get投票所情報().getJusho());
        }
        if (fromData.get選挙人名簿情報() != null) {
            toData.setSatsu(fromData.get選挙人名簿情報().getSatsu());
            toData.setPage(fromData.get選挙人名簿情報().getPage());
            toData.setGyo(fromData.get選挙人名簿情報().getGyo());
        }
        toData.setGroupKubun(flag);

        if (入場券_世帯員最大人数.containsKey(fromData.get宛名PSM情報().getSetaiCode())) {
            入場券_世帯員最大人数.get(fromData.get宛名PSM情報().getSetaiCode()).add(fromData.get宛名PSM情報().getShikibetsuCode());
        } else {
            Set<ShikibetsuCode> 識別コード = new HashSet<>();
            識別コード.add(fromData.get宛名PSM情報().getShikibetsuCode());
            入場券_世帯員最大人数.put(fromData.get宛名PSM情報().getSetaiCode(), 識別コード);
        }
    }
}
