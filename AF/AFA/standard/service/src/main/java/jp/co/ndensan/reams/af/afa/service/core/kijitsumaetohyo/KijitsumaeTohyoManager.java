/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.kijitsumaetohyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo.TohyoJokyoBuilder;
import jp.co.ndensan.reams.af.afa.business.kijitsumaetohyo.KijitsumaeTohyoChohyoData;
import jp.co.ndensan.reams.af.afa.business.kijitsumaetohyo.KijitsumaeTohyoShukei;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.kijitsumaetohyo.KijitsumaeTohyoMybatisParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT250UketsukeNoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.xml.kijitsumaetohyo.KijitsumaeTohyoShukeiEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT201TohyoJokyoDac;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT250UketsukeNoDac;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.kijitsumaetohyo.IKijitsumaeTohyoShukeiMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 選挙時登録のDB操作クラスです。
 *
 * @reamsid_L AF-0070-010 liss
 */
public class KijitsumaeTohyoManager {

    private final AfT250UketsukeNoDac afT250UketsukeNoDac;
    private final AfT201TohyoJokyoDac afT201TohyoJokyoDac;
    private final AfaMapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public KijitsumaeTohyoManager() {
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
        afT250UketsukeNoDac = InstanceProvider.create(AfT250UketsukeNoDac.class);
        afT201TohyoJokyoDac = InstanceProvider.create(AfT201TohyoJokyoDac.class);
    }

    KijitsumaeTohyoManager(AfaMapperProvider mapperProvider, AfT250UketsukeNoDac afT250UketsukeNoDac, AfT201TohyoJokyoDac afT201TohyoJokyoDac) {
        this.mapperProvider = mapperProvider;
        this.afT250UketsukeNoDac = afT250UketsukeNoDac;
        this.afT201TohyoJokyoDac = afT201TohyoJokyoDac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KijitsumaeTohyoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KijitsumaeTohyoManager}のインスタンス
     */
    public static KijitsumaeTohyoManager createInstance() {
        return InstanceProvider.create(KijitsumaeTohyoManager.class);
    }

    /**
     * 指定されたキーに該当する、受付番号を取得します。
     *
     * @param shohonNo 抄本番号
     * @param shisetsuShubetsu 施設種別
     * @param code 施設コード or 投票区コード
     * @param kijitsuFuzaiKubun 期日前不在者区分
     * @return 該当した受付番号採番管理エンティティ
     */
    @Transaction
    public RString getUketsukeNo(ShohonNo shohonNo, Code shisetsuShubetsu,
            RString code, Code kijitsuFuzaiKubun) {

        AfT250UketsukeNoEntity entity = afT250UketsukeNoDac.select(shohonNo, shisetsuShubetsu, code, kijitsuFuzaiKubun);
        AfT250UketsukeNoEntity uketsukeNoEntity = new AfT250UketsukeNoEntity();
        long uketsukeNo = 0L;
        if (entity == null) {
            uketsukeNoEntity.setCode(code);
            uketsukeNoEntity.setKijitsuFuzaiKubun(kijitsuFuzaiKubun);
            uketsukeNoEntity.setShohonNo(shohonNo);
            uketsukeNoEntity.setShisetsuShubetsu(shisetsuShubetsu);
            uketsukeNoEntity.setCurrentNumber(1);
            afT250UketsukeNoDac.insertOrUpdate(uketsukeNoEntity);
            uketsukeNo = uketsukeNoEntity.getCurrentNumber();
            uketsukeNoEntity.setCurrentNumber(uketsukeNo + 1);
            afT250UketsukeNoDac.insertOrUpdate(uketsukeNoEntity);
        } else {
            uketsukeNo = entity.getCurrentNumber();
            entity.setCurrentNumber(uketsukeNo + 1);
            afT250UketsukeNoDac.insertOrUpdate(entity);
        }

        return new RString(Long.toString(uketsukeNo));
    }

    /**
     * 指定されたキーに該当する、期日前投票情報の集計を取得します。
     *
     * @param shohonNo 抄本番号
     * @param kijunDate 基準日
     * @param senkyoNo 選挙番号
     * @param tanmatsuID 端末ID
     * @return 期日前投票情報の集計
     */
    @Transaction
    public List<KijitsumaeTohyoShukei> getKijitsumaeTohyoShukei(ShohonNo shohonNo, FlexibleDate kijunDate, SenkyoNo senkyoNo,
            RString tanmatsuID) {

        IKijitsumaeTohyoShukeiMapper mapper = mapperProvider.create(IKijitsumaeTohyoShukeiMapper.class);
        ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.住登内優先);
        build.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        build.set基準日(kijunDate);
        List<JuminShubetsu> list = new ArrayList<>();
        list.add(JuminShubetsu.日本人);
        list.add(JuminShubetsu.外国人);
        build.set住民種別(list);
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = build.build();
        KijitsumaeTohyoMybatisParameter param = new KijitsumaeTohyoMybatisParameter(
                shikibetsuTaishoPSMSearchKey, shohonNo, kijunDate, senkyoNo, ShikibetsuCode.EMPTY, null, null, tanmatsuID);
        List<KijitsumaeTohyoShukeiEntity> shukeiEntitylist = mapper.selectKijitsumaeTohyoShukei(param);
        if (shukeiEntitylist.isEmpty()) {
            return null;
        }
        List<KijitsumaeTohyoShukei> kijitsumaeTohyoShukeiList = new ArrayList<>();
        for (KijitsumaeTohyoShukeiEntity entity : shukeiEntitylist) {
            kijitsumaeTohyoShukeiList.add(new KijitsumaeTohyoShukei(entity));
        }
        return kijitsumaeTohyoShukeiList;
    }

    /**
     * 指定されたキーに該当する、期日前投票情報の帳票作成用データを取得します。
     *
     * @param senkyoSyurui 選挙種類
     * @param shohonNo 抄本番号
     * @param shikibetsuCode ShikibetsuCode
     * @param senkyoNoLst List<SenkyoNo>
     * @param tanmatsuID 端末ID
     * @return 期日前投票情報の集計
     */
    @Transaction
    public List<KijitsumaeTohyoChohyoData> getKijitsumaeTohyoChohyoData(Code senkyoSyurui,
            ShohonNo shohonNo, ShikibetsuCode shikibetsuCode, List<SenkyoNo> senkyoNoLst, RString tanmatsuID) {

        IKijitsumaeTohyoShukeiMapper mapper = mapperProvider.create(IKijitsumaeTohyoShukeiMapper.class);
        ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.住登内優先);
        build.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        build.set基準日(FlexibleDate.getNowDate());
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = build.build();
        KijitsumaeTohyoMybatisParameter param = new KijitsumaeTohyoMybatisParameter(
                shikibetsuTaishoPSMSearchKey, shohonNo, null, null, shikibetsuCode, senkyoNoLst, senkyoSyurui, tanmatsuID);
        List<SenkyoninTohyoJokyoEntity> chohyoEntitylist = mapper.selectChohyoData(param);
        if (chohyoEntitylist.isEmpty()) {
            return null;
        }
        List<KijitsumaeTohyoChohyoData> kijitsumaeTohyoChohyolist = new ArrayList<>();
        for (SenkyoninTohyoJokyoEntity entity : chohyoEntitylist) {
            kijitsumaeTohyoChohyolist.add(new KijitsumaeTohyoChohyoData(entity));
        }
        return kijitsumaeTohyoChohyolist;
    }

    /**
     * 指定されたキーに該当する、不在者投票情報の帳票作成用データを取得します。
     *
     * @param senkyoSyurui 選挙種類
     * @param shohonNo 抄本番号
     * @param shikibetsuCodeList List<RString>
     * @return 不在者投票情報の集計
     */
    @Transaction
    public List<KijitsumaeTohyoChohyoData> getFuzaishaTohyoChohyoData(Code senkyoSyurui,
            ShohonNo shohonNo, List<RString> shikibetsuCodeList) {
        IKijitsumaeTohyoShukeiMapper mapper = mapperProvider.create(IKijitsumaeTohyoShukeiMapper.class);
        ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.住登内優先);
        build.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);
        build.set基準日(FlexibleDate.getNowDate());
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = build.build();
        KijitsumaeTohyoMybatisParameter param = new KijitsumaeTohyoMybatisParameter(
                shikibetsuTaishoPSMSearchKey, shohonNo, null, null, null, null, senkyoSyurui,
                ControlDataHolder.getClientId());
        param.setShikibetsuCodeList(shikibetsuCodeList);
        List<SenkyoninTohyoJokyoEntity> chohyoEntitylist = mapper.selectChohyoData(param);
        if (chohyoEntitylist.isEmpty()) {
            return null;
        }
        List<KijitsumaeTohyoChohyoData> kijitsumaeTohyoChohyolist = new ArrayList<>();
        for (SenkyoninTohyoJokyoEntity entity : chohyoEntitylist) {
            kijitsumaeTohyoChohyolist.add(new KijitsumaeTohyoChohyoData(entity));
        }
        return kijitsumaeTohyoChohyolist;
    }

    /**
     * 指定されたキーに該当する、不在者投票情報の帳票作成用データを取得します。
     *
     * @param builderList List<TohyoJokyoBuilder>
     */
    @Transaction
    public void deleteData(List<TohyoJokyoBuilder> builderList) {

        for (TohyoJokyoBuilder builder : builderList) {
            afT201TohyoJokyoDac.deletePhysical(builder.build().toEntity());
        }
    }

    /**
     * 指定されたキーに該当する、不在者投票情報の帳票作成用データを取得します。
     *
     * @param builderList List<TohyoJokyoBuilder>
     * @param 抄本番号 ShohonNo
     * @param 施設種別 Code
     * @param コード RString
     * @param 期日前不在者区分 Code
     */
    @Transaction
    public void saveData投票(List<TohyoJokyoBuilder> builderList,
            ShohonNo 抄本番号, Code 施設種別, RString コード, Code 期日前不在者区分) {
        for (TohyoJokyoBuilder builder : builderList) {
            RString 受付NO = getUketsukeNo(抄本番号, 施設種別, コード, 期日前不在者区分);
            if (!受付NO.isNullOrEmpty() && builder.need設定受付番号()) {
                builder.set受付番号(Integer.parseInt(受付NO.toString()) + 1);
            }
            afT201TohyoJokyoDac.save(builder.build().toEntity());
        }
    }

    /**
     * 指定されたキーに該当する、不在者投票情報の帳票作成用データを取得します。
     *
     * @param builderList List<TohyoJokyoBuilder>
     * @param 抄本番号 ShohonNo
     * @param 施設種別 Code
     * @param コード RString
     * @param 期日前不在者区分 Code
     */
    @Transaction
    public void saveData棄権受取拒否(List<TohyoJokyoBuilder> builderList,
            ShohonNo 抄本番号, Code 施設種別, RString コード, Code 期日前不在者区分) {
        for (TohyoJokyoBuilder builder : builderList) {
            builder.set受付番号(0);
            AfT201TohyoJokyoEntity entity = builder.build().toEntity();
            afT201TohyoJokyoDac.save(entity);
        }
    }

    /**
     * 指定されたキーに該当する、不在者投票情報の帳票作成用データを取得します。
     *
     * @param builderList List<TohyoJokyoBuilder>
     * @param 抄本番号 ShohonNo
     * @param 施設種別 Code
     * @param コード RString
     * @param 期日前不在者区分 Code
     */
    @Transaction
    public void saveData受取拒否仮投票(List<TohyoJokyoBuilder> builderList,
            ShohonNo 抄本番号, Code 施設種別, RString コード, Code 期日前不在者区分) {
        for (TohyoJokyoBuilder builder : builderList) {
            if (builder.need設定受付番号()) {
                RString 受付NO = getUketsukeNo(抄本番号, 施設種別, コード, 期日前不在者区分);
                builder.set受付番号(Integer.parseInt(受付NO.toString()) + 1);
            }
            afT201TohyoJokyoDac.save(builder.build().toEntity());
        }
    }

}
