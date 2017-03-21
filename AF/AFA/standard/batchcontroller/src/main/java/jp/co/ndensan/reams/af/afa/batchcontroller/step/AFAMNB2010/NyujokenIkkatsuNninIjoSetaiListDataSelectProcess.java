/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.batchcontroller.step.AFAMNB2010;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.af.afa.business.util.shikakuhantei.ShikakuHantei;
import jp.co.ndensan.reams.af.afa.definition.batchprm.nyujokenikkatsu.TohyokuJyohou;
import jp.co.ndensan.reams.af.afa.definition.configkeys.AFAConfigKeysValue;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.MasshoJiyuCodeEnum;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ShutsuryokuShuryohiEnum;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.YMDKensakuKijunConfig;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.nyujokenikkatsu.AFABTB201SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.nyujokenikkatsu.NyujokenIkkatsuMybatisParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.IdoSearchJuminShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.nyujokenkobetsu.NyujokenKobetsuJouhou;
import jp.co.ndensan.reams.af.afa.entity.xml.nyujokenikkatsu.AFABTB201NninIjoSetaiListEntity;
import jp.co.ndensan.reams.af.afa.entity.xml.nyujokenikkatsu.AFABTB201SoufusakiJouhouEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.nyujokenikkatsu.INyujokenIkkatsuMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.af.afa.service.nyujokenikkatsu.NyujokenIkkatsuFinder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 入場券発行（一括）のN人以上世帯一覧表データ取得のクラスです。
 *
 * @reamsid_L AF-0160-020 guyq
 */
public class NyujokenIkkatsuNninIjoSetaiListDataSelectProcess extends BatchProcessBase<NyujokenKobetsuJouhou> {

    private NyujokenIkkatsuMybatisParameter mybatisParameter;
    private AFABTB201SelectProcessParameter parameter;
    private ShikakuHantei shikakuhantei;
    private OutputParameter<RString> outTempTableName;
    private INyujokenIkkatsuMapper mapper;
    private NyujokenIkkatsuFinder finder;
    private AfaMapperProvider mapperProvider;
    private static final RString TEMP_TABLE_SOUFUSAKIJOUHOU = new RString("AFABTB201_NninIjoSetaiList");
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.nyujokenikkatsu.INyujokenIkkatsuMapper.select選挙人情報リスト");
    private int flag;

    private static final RString 有権者分 = new RString("1");
    private static final RString 表示者分 = new RString("2");

    private Map<SetaiCode, Integer> 有権者分_同一世帯コード数;
    private Map<SetaiCode, Integer> 表示者分_同一世帯コード数;
    /**
     * 送付先情報_temp取得。
     *
     */
    public static final RString OUT_TEMP_TABLE_NAME;

    static {
        OUT_TEMP_TABLE_NAME = new RString("outTempTableName");
    }

    @BatchWriter
    private BatchEntityCreatedTempTableWriter soufusakiJouhouDbWriter;

    @Override
    protected void initialize() {
        shikakuhantei = new ShikakuHantei();
        flag = 0;
        ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.住登内優先);
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
        parameter.setKey(shikibetsuTaishoPSMSearchKey);
        IAssociationFinder associationFinder = AssociationFinderFactory.createInstance();
        Association 地方公共団体情報 = associationFinder.getAssociation();
        LasdecCode 地方公共団体コード = 地方公共団体情報.get地方公共団体コード();
        int 連番 = 地方公共団体情報.get連番();
        FlexibleDate システム日付 = FlexibleDate.getNowDate();

        mybatisParameter = parameter.toNyujokenIkkatsuMybatisParameter();
        mybatisParameter.setシステム日付(システム日付);
        mybatisParameter.set地方公共団体コード(地方公共団体コード);
        mybatisParameter.set連番(連番);

        finder = NyujokenIkkatsuFinder.createInstance();
        AfT100ShohonEntity n人以上世帯一覧表 = finder.get抄本情報(parameter.get抄本番号());
        if (n人以上世帯一覧表 != null) {
            parameter.set年齢到達期限日(n人以上世帯一覧表.getKiteiNenreiTotatsuYMD());
        } else {
            parameter.set年齢到達期限日(FlexibleDate.EMPTY);
        }
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
        mapper = mapperProvider.create(INyujokenIkkatsuMapper.class);
        mybatisParameter.setKijunYMD(parameter.get投票日());
        NyujokenKobetsuJouhou 前回基準日n人以上世帯一覧表 = mapper.select抄本の前回基準日(mybatisParameter);
        if (前回基準日n人以上世帯一覧表 != null) {
            parameter.set前回基準日(前回基準日n人以上世帯一覧表.get前回基準日());
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
        有権者分_同一世帯コード数 = new HashMap<>();
        表示者分_同一世帯コード数 = new HashMap<>();
    }

    @Override
    protected void beforeExecute() {
        outTempTableName = new OutputParameter<>();
    }

    @Override
    protected void createWriter() {
        this.soufusakiJouhouDbWriter
                = new BatchEntityCreatedTempTableWriter(TEMP_TABLE_SOUFUSAKIJOUHOU, AFABTB201SoufusakiJouhouEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParameter);
    }

    @Override
    protected void process(NyujokenKobetsuJouhou n人以上世帯一覧表) {
        flag = 0;
        get有権者分対象情報(n人以上世帯一覧表);
        get表示者分対象情報(n人以上世帯一覧表);
        if (flag == 1) {
            get有権者分_同一世帯コード数(n人以上世帯一覧表);
        } else if (flag == 2) {
            get表示者分_同一世帯コード数(n人以上世帯一覧表);
        }
    }

    @Override
    protected void afterExecute() {
        int 抽出対象世帯人数 = RString.isNullOrEmpty(parameter.get抽出対象世帯人数())
                ? 0 : Integer.parseInt(parameter.get抽出対象世帯人数().toString());
        for (SetaiCode key : 有権者分_同一世帯コード数.keySet()) {
            int 同一世帯コード数 = 有権者分_同一世帯コード数.get(key);
            if (同一世帯コード数 >= 抽出対象世帯人数) {
                AFABTB201NninIjoSetaiListEntity tempTblInsertEntity = new AFABTB201NninIjoSetaiListEntity();
                tempTblInsertEntity.setSetaiCode(key);
                tempTblInsertEntity.setGroupKubun(有権者分);
                tempTblInsertEntity.setSetaiSuji(new Decimal(同一世帯コード数));
                soufusakiJouhouDbWriter.insert(tempTblInsertEntity);
            }
        }
        for (SetaiCode key : 表示者分_同一世帯コード数.keySet()) {
            int 同一世帯コード数 = 表示者分_同一世帯コード数.get(key);
            if (同一世帯コード数 >= 抽出対象世帯人数) {
                AFABTB201NninIjoSetaiListEntity tempTblInsertEntity = new AFABTB201NninIjoSetaiListEntity();
                tempTblInsertEntity.setSetaiCode(key);
                tempTblInsertEntity.setGroupKubun(表示者分);
                tempTblInsertEntity.setSetaiSuji(new Decimal(同一世帯コード数));
                soufusakiJouhouDbWriter.insert(tempTblInsertEntity);
            }
        }
        outTempTableName.setValue(TEMP_TABLE_SOUFUSAKIJOUHOU);
    }

    private void get有権者分対象情報(NyujokenKobetsuJouhou n人以上世帯一覧表) {
        for (TohyokuJyohou 投票区 : parameter.get投票区リスト()) {
            if (投票区.get投票区コード().equals(n人以上世帯一覧表.get投票区コード())
                    && (is有権者(n人以上世帯一覧表) || (is表示者(n人以上世帯一覧表) && 有権者分対象_抽出終了日判定(n人以上世帯一覧表)))) {
                flag = 1;
                break;
            }
        }
    }

    private void get表示者分対象情報(NyujokenKobetsuJouhou n人以上世帯一覧表) {
        RString 表示者用入場券出力区分 = BusinessConfig.get(ConfigKeysAFA.入場券_表示者用入場券出力区分, SubGyomuCode.AFA選挙本体);
        if (!AFAConfigKeysValue.入場券_表示者用入場券出力区分_出力しない.configKeyValue()
                .equals(表示者用入場券出力区分)) {
            if (is表示者(n人以上世帯一覧表)
                    && 表示者分対象_抽出終了日判定(n人以上世帯一覧表)) {
                flag = 2;
            }
            if (is抹消者(n人以上世帯一覧表)
                    && is二重登録抹消(n人以上世帯一覧表)) {
                flag = 2;
            }
        }
    }

    private boolean is有権者(NyujokenKobetsuJouhou n人以上世帯一覧表) {
        mybatisParameter.set識別コード(n人以上世帯一覧表.get識別コード());
        IdoSearchJuminShikakuEntity 宛名識別対象 = mapper.select宛名識別対象(mybatisParameter);
        AfT113SenkyoShikakuEntity 選挙資格 = finder.get選挙資格情報(parameter.get選挙種類(), n人以上世帯一覧表.get識別コード());
        return shikakuhantei.is有権者(宛名識別対象.getShikibetsuTaisho(),
                parameter.get転入期限日(), parameter.get年齢到達期限日(), parameter.get投票日(),
                SenkyoShurui.toValue(parameter.get選挙種類()), 選挙資格);
    }

    private boolean is表示者(NyujokenKobetsuJouhou n人以上世帯一覧表) {
        mybatisParameter.set識別コード(n人以上世帯一覧表.get識別コード());
        IdoSearchJuminShikakuEntity 宛名識別対象 = mapper.select宛名識別対象(mybatisParameter);
        return shikakuhantei.is表示者(宛名識別対象.getShikibetsuTaisho(),
                parameter.get転出日From(), parameter.get年齢到達期限日(), parameter.get投票日(), parameter.get前回基準日(),
                SenkyoShurui.toValue(parameter.get選挙種類()));
    }

    private boolean is抹消者(NyujokenKobetsuJouhou n人以上世帯一覧表) {
        mybatisParameter.set識別コード(n人以上世帯一覧表.get識別コード());
        IdoSearchJuminShikakuEntity 宛名識別対象 = mapper.select宛名識別対象(mybatisParameter);
        return shikakuhantei.is抹消者(宛名識別対象.getShikibetsuTaisho(),
                parameter.get転出日From(), parameter.get年齢到達期限日());
    }

    private boolean 有権者分対象_抽出終了日判定(NyujokenKobetsuJouhou n人以上世帯一覧表) {
        RString 抽出終了日設定 = BusinessConfig.get(ConfigKeysAFA.転出者はがき_抽出終了日設定, SubGyomuCode.AFA選挙本体);
        FlexibleDate 転出日 = get転出日(n人以上世帯一覧表);
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

    private boolean 表示者分対象_抽出終了日判定(NyujokenKobetsuJouhou n人以上世帯一覧表) {
        RString 抽出終了日設定 = BusinessConfig.get(ConfigKeysAFA.転出者はがき_抽出終了日設定, SubGyomuCode.AFA選挙本体);
        FlexibleDate 転出日 = get転出日(n人以上世帯一覧表);
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

    private FlexibleDate get転出日(NyujokenKobetsuJouhou n人以上世帯一覧表) {
        FlexibleDate 転出日 = FlexibleDate.EMPTY;
        RString 転出期限日検索基準 = BusinessConfig.get(ConfigKeysAFA.転出期限日検索基準, SubGyomuCode.AFA選挙本体);
        if (YMDKensakuKijunConfig.消除届出年月日.getValue().equals(転出期限日検索基準)) {
            転出日 = n人以上世帯一覧表.get消除届出年月日();
        } else if (YMDKensakuKijunConfig.消除異動年月日.getValue().equals(転出期限日検索基準)) {
            転出日 = n人以上世帯一覧表.get消除異動年月日();
        }
        return 転出日;
    }

    private boolean is二重登録抹消(NyujokenKobetsuJouhou n人以上世帯一覧表) {
        AfT113SenkyoShikakuEntity 選挙資格 = finder.get選挙資格情報(parameter.get選挙種類(), n人以上世帯一覧表.get識別コード());
        if (選挙資格 != null && MasshoJiyuCodeEnum.二重登録抹消.getCode().equals(選挙資格.getMasshoJiyuCode())) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private void get有権者分_同一世帯コード数(NyujokenKobetsuJouhou n人以上世帯一覧表) {
        if (n人以上世帯一覧表.get世帯コード() == null) {
            return;
        }
        if (有権者分_同一世帯コード数.containsKey(n人以上世帯一覧表.get世帯コード())) {
            有権者分_同一世帯コード数.put(n人以上世帯一覧表.get世帯コード(),
                    有権者分_同一世帯コード数.get(n人以上世帯一覧表.get世帯コード()) + 1);
        } else {
            有権者分_同一世帯コード数.put(n人以上世帯一覧表.get世帯コード(), 1);
        }
    }

    private void get表示者分_同一世帯コード数(NyujokenKobetsuJouhou n人以上世帯一覧表) {
        if (n人以上世帯一覧表.get世帯コード() == null) {
            return;
        }
        if (表示者分_同一世帯コード数.containsKey(n人以上世帯一覧表.get世帯コード())) {
            表示者分_同一世帯コード数.put(n人以上世帯一覧表.get世帯コード(),
                    表示者分_同一世帯コード数.get(n人以上世帯一覧表.get世帯コード()) + 1);
        } else {
            表示者分_同一世帯コード数.put(n人以上世帯一覧表.get世帯コード(), 1);
        }
    }
}
