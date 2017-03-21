/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.tojitsutohyo;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.business.core.jumintohyojitoroku.ShohonJohoResult;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo.TohyoJokyoBuilder;
import jp.co.ndensan.reams.af.afa.business.kijitsumaetohyo.KijitsumaeTohyoChohyoData;
import jp.co.ndensan.reams.af.afa.business.tojitsutohyo.ShohonSearchResult;
import jp.co.ndensan.reams.af.afa.business.tojitsutohyo.TojitsuOnlinePcKanri;
import jp.co.ndensan.reams.af.afa.business.tojitsutohyo.TojitsuTohyoChohyoData;
import jp.co.ndensan.reams.af.afa.business.tojitsutohyo.TojitsuTohyoShukei;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.tojitsutohyo.TojitsuTohyoParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT250UketsukeNoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT253TojitsuOnlinePcKanriEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.jumintohyojitoroku.ShohonJohoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.tojitsutohyo.TojitsuTohyoShukeiEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT201TohyoJokyoDac;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT250UketsukeNoDac;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT253TojitsuOnlinePcKanriDac;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.jumintohyojitoroku.IJuminTohyojiTorokuMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.tojitsutohyo.ITojitsuTohyoMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 選挙時登録のDB操作クラスです。
 *
 * @reamsid_L AF-0260-010 liuyj
 */
public class TojitsuTohyoManager {

    private final AfT250UketsukeNoDac afT250UketsukeNoDac;
    private final AfT201TohyoJokyoDac afT201TohyoJokyoDac;
    private final AfT253TojitsuOnlinePcKanriDac afT253TojitsuOnlinePcKanriDac;

    private final AfaMapperProvider mapperProvider;
    private static final int DAY_1 = 1;

    /**
     * コンストラクタです。
     */
    public TojitsuTohyoManager() {
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
        afT250UketsukeNoDac = InstanceProvider.create(AfT250UketsukeNoDac.class);
        afT201TohyoJokyoDac = InstanceProvider.create(AfT201TohyoJokyoDac.class);
        afT253TojitsuOnlinePcKanriDac = InstanceProvider.create(AfT253TojitsuOnlinePcKanriDac.class);
    }

    TojitsuTohyoManager(AfaMapperProvider mapperProvider, AfT250UketsukeNoDac afT250UketsukeNoDac,
            AfT201TohyoJokyoDac afT201TohyoJokyoDac, AfT253TojitsuOnlinePcKanriDac afT253TojitsuOnlinePcKanriDac) {
        this.mapperProvider = mapperProvider;
        this.afT250UketsukeNoDac = afT250UketsukeNoDac;
        this.afT201TohyoJokyoDac = afT201TohyoJokyoDac;
        this.afT253TojitsuOnlinePcKanriDac = afT253TojitsuOnlinePcKanriDac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TojitsuTohyoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link TojitsuTohyoManager}のインスタンス
     */
    public static TojitsuTohyoManager createInstance() {
        return InstanceProvider.create(TojitsuTohyoManager.class);
    }

    /**
     * 指定されたキーに該当する、受付番号を取得します。
     *
     * @param 抄本番号 ShohonNo
     * @param 選挙番号 SenkyoNo
     * @return 該当した受付番号採番管理エンティティ
     */
    public ShohonSearchResult get選挙(ShohonNo 抄本番号, SenkyoNo 選挙番号) {
        ITojitsuTohyoMapper mapper = mapperProvider.create(ITojitsuTohyoMapper.class);
        return new ShohonSearchResult(mapper.selectShohon(抄本番号, 選挙番号));
    }

    /**
     * 指定されたキーに該当する、受付番号を取得します。
     *
     * @param 選挙種類 Code
     * @param 端末ID RString
     * @return 該当した受付番号採番管理エンティティ
     */
    public List<TojitsuOnlinePcKanri> get投票区コード(Code 選挙種類, RString 端末ID) {
        List<TojitsuOnlinePcKanri> list = new ArrayList<>();
        List<AfT253TojitsuOnlinePcKanriEntity> 投票区状況 = afT253TojitsuOnlinePcKanriDac.selectTohyokuCode(選挙種類, 端末ID);
        if (null == 投票区状況 || 投票区状況.isEmpty()) {
            return null;
        }
        for (AfT253TojitsuOnlinePcKanriEntity entity : 投票区状況) {
            list.add(new TojitsuOnlinePcKanri(entity));
        }
        return list;
    }

    /**
     * 指定されたキーに該当する、受付番号を取得します。
     *
     * @param 投票区コード RString
     * @param 選挙種類 SenkyoShurui
     * @return 該当した受付番号採番管理エンティティ
     */
    public TojitsuTohyoShukei
            get投票所状況(RString 投票区コード, SenkyoShurui 選挙種類) {
        ITojitsuTohyoMapper mapper = mapperProvider.create(ITojitsuTohyoMapper.class
        );
        TojitsuTohyoShukeiEntity 投票所状況 = mapper.selectAfT502Tohyojo(投票区コード, 選挙種類.getCode());
        if (null == 投票所状況) {
            return null;
        }

        return new TojitsuTohyoShukei(投票所状況);
    }

    /**
     * 抄本番号に合致する抄本情報を返します。
     *
     * @param 抄本番号 ShohonNo
     *
     * @return ShohonJohoResult nullが返る可能性があります。
     */
    @Transaction
    public ShohonJohoResult get抄本情報(ShohonNo 抄本番号) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本番号"));
        IJuminTohyojiTorokuMapper 抄本情報mapper = mapperProvider.create(IJuminTohyojiTorokuMapper.class
        );
        ShohonJohoEntity 抄本情報 = 抄本情報mapper.select抄本情報By抄本番号(抄本番号);
        if (null == 抄本情報) {
            return null;
        }

        return new ShohonJohoResult(抄本情報);
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
        if (entity == null) {
            return RString.EMPTY;
        }
        long uketsukeNo = entity.getCurrentNumber();
        entity.setCurrentNumber(uketsukeNo + 1);
        afT250UketsukeNoDac.insertOrUpdate(entity);
        return new RString(Long.toString(uketsukeNo));
    }

    /**
     * 指定されたキーに該当する、当日投票情報の集計を取得します。
     *
     * @param 投票年月日 FlexibleDate
     * @param 投票受付開始年月日 FlexibleDate
     * @param shohonNo ShohonNo
     * @param tohyoJokyolist List<RString>
     * @param senkyoNo SenkyoNo
     * @param tanmatsuID 端末ID
     * @return 期日前投票情報の集計
     */
    @Transaction
    public TojitsuTohyoShukei get投票状況1行と2行(FlexibleDate 投票年月日, FlexibleDate 投票受付開始年月日,
            ShohonNo shohonNo, List<RString> tohyoJokyolist, SenkyoNo senkyoNo, RString tanmatsuID) {
        FlexibleDate kijunDate = FlexibleDate.getNowDate();
        ITojitsuTohyoMapper mapper = mapperProvider.create(ITojitsuTohyoMapper.class
        );
        ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.住登内優先);

        build.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);

        build.set基準日(kijunDate);
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = build.build();
        TojitsuTohyoParameter param = new TojitsuTohyoParameter(
                shikibetsuTaishoPSMSearchKey, shohonNo, 投票年月日.minusDay(DAY_1),
                投票受付開始年月日, kijunDate, senkyoNo, tohyoJokyolist,
                ShikibetsuCode.EMPTY, null, null, tanmatsuID, null, null);
        TojitsuTohyoShukeiEntity shukeiEntity1行と2行 = mapper.selectTojitsuTohyoShukei1行と2行(param);
        if (null == shukeiEntity1行と2行) {
            return null;
        }

        return new TojitsuTohyoShukei(shukeiEntity1行と2行);
    }

    /**
     * 指定されたキーに該当する、当日投票情報の集計を取得します。
     *
     * @param shohonNo ShohonNo
     * @param senkyoSyurui Code
     * @return 期日前投票情報の集計
     */
    @Transaction
    public List<TojitsuTohyoChohyoData> get選挙人情報(
            ShohonNo shohonNo, Code senkyoSyurui) {
        FlexibleDate kijunDate = FlexibleDate.getNowDate();
        ITojitsuTohyoMapper mapper = mapperProvider.create(ITojitsuTohyoMapper.class
        );
        ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.住登内優先);

        build.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);

        build.set基準日(kijunDate);
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = build.build();
        TojitsuTohyoParameter param = new TojitsuTohyoParameter(
                shikibetsuTaishoPSMSearchKey, shohonNo, null,
                null, null, null, null,
                null, null, senkyoSyurui, null, null, null);
        List<SenkyoninTohyoJokyoEntity> shukeiEntitylist = mapper.select選挙人情報(param);
        if (null == shukeiEntitylist
                || shukeiEntitylist.isEmpty()) {
            return null;
        }
        List<TojitsuTohyoChohyoData> tojitsuTohyoShukeiList = new ArrayList<>();
        for (SenkyoninTohyoJokyoEntity entity : shukeiEntitylist) {
            tojitsuTohyoShukeiList.add(new TojitsuTohyoChohyoData(entity));
        }
        return tojitsuTohyoShukeiList;
    }

    /**
     * 指定されたキーに該当する、当日投票情報の集計を取得します。
     *
     * @param 集計単位 int
     * @param shohonNo ShohonNo
     * @param tohyoJokyolist List<RString>
     * @param senkyoNo SenkyoNo
     * @param tanmatsuID 端末ID
     * @param 投票開始時間 RTime
     * @param 投票終了時間 RTime
     * @return 期日前投票情報の集計
     */
    @Transaction
    public TojitsuTohyoShukei get投票状況3行目以降(int 集計単位, ShohonNo shohonNo,
            List<RString> tohyoJokyolist, SenkyoNo senkyoNo, RString tanmatsuID, RTime 投票開始時間, RTime 投票終了時間) {
        FlexibleDate kijunDate = FlexibleDate.getNowDate();
        ITojitsuTohyoMapper mapper = mapperProvider.create(ITojitsuTohyoMapper.class
        );
        ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.住登内優先);

        build.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);

        build.set基準日(kijunDate);
        IShikibetsuTaishoPSMSearchKey searchKey = build.build();
        TojitsuTohyoParameter param = new TojitsuTohyoParameter(
                searchKey, shohonNo, null,
                null, kijunDate, senkyoNo, tohyoJokyolist,
                ShikibetsuCode.EMPTY, null, null, tanmatsuID, 投票開始時間, 投票終了時間);
        TojitsuTohyoShukeiEntity shukeiEntity3行目以降 = mapper.selectTojitsuTohyoShukei(param);
        if (null == shukeiEntity3行目以降) {
            return null;
        }

        return new TojitsuTohyoShukei(shukeiEntity3行目以降);
    }

    /**
     * 指定されたキーに該当する、当日投票情報の集計を取得します。
     *
     * @param 集計単位 int
     * @param shohonNo ShohonNo
     * @param tohyoJokyolist List<RString>
     * @param senkyoNo SenkyoNo
     * @param tanmatsuID 端末ID
     * @param 投票開始時間 RTime
     * @param 投票終了時間 RTime
     * @return 期日前投票情報の集計
     */
    @Transaction
    public List<TojitsuTohyoShukei> get投票状況3行目以降の宛名PSM(int 集計単位, ShohonNo shohonNo,
            List<RString> tohyoJokyolist, SenkyoNo senkyoNo, RString tanmatsuID, RTime 投票開始時間, RTime 投票終了時間) {
        FlexibleDate kijunDate = FlexibleDate.getNowDate();
        ITojitsuTohyoMapper mapper = mapperProvider.create(ITojitsuTohyoMapper.class
        );
        ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.住登内優先);

        build.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);

        build.set基準日(kijunDate);
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = build.build();
        TojitsuTohyoParameter param = new TojitsuTohyoParameter(
                shikibetsuTaishoPSMSearchKey, shohonNo, null,
                null, kijunDate, senkyoNo, tohyoJokyolist,
                ShikibetsuCode.EMPTY, null, null, tanmatsuID, 投票開始時間, 投票終了時間);
        List<TojitsuTohyoShukeiEntity> shukeiEntitylist = mapper.selectTojitsuTohyoShukeiPSM(param);
        if (null == shukeiEntitylist
                || shukeiEntitylist.isEmpty()) {
            return null;
        }
        List<TojitsuTohyoShukei> tojitsuTohyoShukeiList = new ArrayList<>();
        for (TojitsuTohyoShukeiEntity entity : shukeiEntitylist) {
            tojitsuTohyoShukeiList.add(new TojitsuTohyoShukei(entity));
        }
        return tojitsuTohyoShukeiList;
    }

    /**
     * 指定されたキーに該当する、当日投票情報の帳票作成用データを取得します。
     *
     * @param senkyoSyurui 選挙種類
     * @param shohonNo 抄本番号
     * @param shikibetsuCode ShikibetsuCode
     * @param senkyoNoLst List<SenkyoNo>
     * @param tanmatsuID 端末ID
     * @return 期日前投票情報の集計
     */
    @Transaction
    public List<KijitsumaeTohyoChohyoData> getTojitsuTohyoChohyoData(Code senkyoSyurui,
            ShohonNo shohonNo, ShikibetsuCode shikibetsuCode, List<SenkyoNo> senkyoNoLst, RString tanmatsuID) {

        ITojitsuTohyoMapper mapper = mapperProvider.create(ITojitsuTohyoMapper.class
        );
        ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.住登内優先);

        build.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);

        build.set基準日(FlexibleDate.getNowDate());
        IShikibetsuTaishoPSMSearchKey searchKey = build.build();
        TojitsuTohyoParameter param = new TojitsuTohyoParameter(
                searchKey, shohonNo, null, null, null, null, null,
                shikibetsuCode, senkyoNoLst, senkyoSyurui, tanmatsuID, null, null);
        List<SenkyoninTohyoJokyoEntity> list = mapper.selectChohyoData(param);

        if (list.isEmpty()) {
            return null;
        }
        List<KijitsumaeTohyoChohyoData> chohyolist = new ArrayList<>();
        for (SenkyoninTohyoJokyoEntity entity : list) {
            chohyolist.add(new KijitsumaeTohyoChohyoData(entity));
        }
        return chohyolist;
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
        ITojitsuTohyoMapper mapper = mapperProvider.create(ITojitsuTohyoMapper.class
        );
        ShikibetsuTaishoPSMSearchKeyBuilder build = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.AF選挙, KensakuYusenKubun.住登内優先);

        build.setデータ取得区分(DataShutokuKubun.基準日時点の最新のレコード);

        build.set基準日(FlexibleDate.getNowDate());
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = build.build();
        TojitsuTohyoParameter param = new TojitsuTohyoParameter(
                shikibetsuTaishoPSMSearchKey, shohonNo, null, null, null, null, null, null, null, senkyoSyurui,
                ControlDataHolder.getClientId(), null, null);

        param.setShikibetsuCodeList(shikibetsuCodeList);
        List<SenkyoninTohyoJokyoEntity> senkyoninTohyoJokyolist = mapper.selectChohyoData(param);

        if (senkyoninTohyoJokyolist.isEmpty()) {
            return null;
        }
        List<KijitsumaeTohyoChohyoData> list = new ArrayList<>();
        for (SenkyoninTohyoJokyoEntity entity : senkyoninTohyoJokyolist) {
            list.add(new KijitsumaeTohyoChohyoData(entity));
        }
        return list;
    }

    /**
     * 指定されたキーに該当する、不在者投票情報の帳票作成用データを取得します。
     *
     * @param list List<TohyoJokyoBuilder>
     */
    @Transaction
    public void deleteData(List<TohyoJokyoBuilder> list) {

        for (TohyoJokyoBuilder builder : list) {
            afT201TohyoJokyoDac.deletePhysical(builder.build().toEntity());
        }
    }

    /**
     * 指定されたキーに該当する、不在者投票情報の帳票作成用データを取得します。
     *
     * @param 投票list List<TohyoJokyoBuilder>
     * @param 抄本番号 ShohonNo
     * @param 施設種別 Code
     * @param コード RString
     * @param 当日不在者区分 Code
     */
    @Transaction
    public void saveData投票(List<TohyoJokyoBuilder> 投票list,
            ShohonNo 抄本番号, Code 施設種別, RString コード, Code 当日不在者区分) {
        for (TohyoJokyoBuilder builder : 投票list) {
            RString 受付NO = getUketsukeNo(抄本番号, 施設種別, コード, 当日不在者区分);
            if (builder.need設定受付番号()
                    && null != 受付NO && !受付NO.isEmpty()) {
                builder.set受付番号(Integer.parseInt(受付NO.toString()) + 1);
            }
            afT201TohyoJokyoDac.save(builder.build().toEntity());
        }
    }

    /**
     * 指定されたキーに該当する、不在者投票情報の帳票作成用データを取得します。
     *
     * @param 棄権受取拒否list List<TohyoJokyoBuilder>
     * @param 抄本番号 ShohonNo
     * @param 施設種別 Code
     * @param コード RString
     * @param 当日不在者区分 Code
     */
    @Transaction
    public void saveData棄権受取拒否(List<TohyoJokyoBuilder> 棄権受取拒否list,
            ShohonNo 抄本番号, Code 施設種別, RString コード, Code 当日不在者区分) {
        for (TohyoJokyoBuilder builder : 棄権受取拒否list) {
            builder.set受付番号(0);
            AfT201TohyoJokyoEntity entity = builder.build().toEntity();
            afT201TohyoJokyoDac.save(entity);
        }
    }

    /**
     * 指定されたキーに該当する、不在者投票情報の帳票作成用データを取得します。
     *
     * @param 受取拒否仮投票list List<TohyoJokyoBuilder>
     * @param 抄本番号 ShohonNo
     * @param 施設種別 Code
     * @param コード RString
     * @param 当日不在者区分 Code
     */
    @Transaction
    public void saveData受取拒否仮投票(List<TohyoJokyoBuilder> 受取拒否仮投票list,
            ShohonNo 抄本番号, Code 施設種別, RString コード, Code 当日不在者区分) {
        for (TohyoJokyoBuilder builder : 受取拒否仮投票list) {
            RString 受付NO = getUketsukeNo(抄本番号, 施設種別, コード, 当日不在者区分);
            if (builder.need設定受付番号()
                    && null != 受付NO && !受付NO.isEmpty()) {
                builder.set受付番号(Integer.parseInt(受付NO.toString()) + 1);
            }
            afT201TohyoJokyoDac.save(builder.build().toEntity());
        }
    }

}
