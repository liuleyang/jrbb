/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.senkyonin.tohyojokyo;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.business.core.senkyonin.tohyojokyo.TohyojokyoDairishaSerachResult;
import jp.co.ndensan.reams.af.afa.business.kijitsumaetohyo.KijitsumaeSenkyoShikaku;
import jp.co.ndensan.reams.af.afa.business.kijitsumaetohyo.KijitsumaeTohyoJokyo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.SenkyoNo;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.senkyonin.tohyojokyo.TohyojokyoMapperParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyonin.tohyojokyo.TohyojokyoDairishaEntity;
import jp.co.ndensan.reams.af.afa.entity.xml.kijitsumaetohyo.KijitsumaeSenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.xml.kijitsumaetohyo.KijitsumaeTohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT201TohyoJokyoDac;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT505SenkyokuTanmatsuKanriDac;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.senkyonin.ITohyoJokyoMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.KosekiShutokuKubun;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 投票状況を管理するクラスです。
 *
 */
public class TohyoJokyoManager {

    private final AfT201TohyoJokyoDac dac;
    private final AfT505SenkyokuTanmatsuKanriDac aft505Dac;
    private final AfaMapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public TohyoJokyoManager() {
        mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
        dac = InstanceProvider.create(AfT201TohyoJokyoDac.class);
        aft505Dac = InstanceProvider.create(AfT505SenkyokuTanmatsuKanriDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link AfT201TohyoJokyoDac}
     * @param mapperProvider mapperProvider
     * @param aft505Dac {@link AfT505SenkyokuTanmatsuKanriDac}
     */
    TohyoJokyoManager(AfT201TohyoJokyoDac dac, AfaMapperProvider mapperProvider, AfT505SenkyokuTanmatsuKanriDac aft505Dac) {
        this.dac = dac;
        this.aft505Dac = aft505Dac;
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TohyoJokyoManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link TohyoJokyoManager}のインスタンス
     */
    public static TohyoJokyoManager createInstance() {
        return InstanceProvider.create(TohyoJokyoManager.class);
    }

    /**
     * 主キーに合致する投票状況を返します。
     *
     * @param 抄本番号 抄本番号
     * @param 識別コード 識別コード
     * @param 選挙番号 選挙番号
     * @return TohyoJokyo
     */
    @Transaction
    public TohyoJokyo get投票状況(
            ShohonNo 抄本番号,
            ShikibetsuCode 識別コード,
            SenkyoNo 選挙番号) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本番号"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(選挙番号, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙番号"));

        AfT201TohyoJokyoEntity entity = dac.selectByKey(
                抄本番号,
                識別コード,
                選挙番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new TohyoJokyo(entity);
    }

    /**
     * 投票状況を全件返します。
     *
     * @return TohyoJokyoの{@code list}
     */
    @Transaction
    public List<TohyoJokyo> get投票状況一覧() {
        List<TohyoJokyo> businessList = new ArrayList<>();

        for (AfT201TohyoJokyoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new TohyoJokyo(entity));
        }

        return businessList;
    }

    /**
     * 投票状況{@link TohyoJokyo}を保存します。
     *
     * @param 投票状況 {@link TohyoJokyo}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save投票状況(TohyoJokyo 投票状況) {
        requireNonNull(投票状況, UrSystemErrorMessages.値がnull.getReplacedMessage("投票状況"));
        return 1 == dac.save(投票状況.toEntity());
    }

    /**
     * 投票状況{@link TohyoJokyo}を保存します。
     *
     * @param 投票状況リスト List<TohyoJokyo>
     */
    @Transaction
    public void save投票状況(List<TohyoJokyo> 投票状況リスト) {
        for (TohyoJokyo 投票状況 : 投票状況リスト) {
            dac.save(投票状況.toEntity());
        }
    }

    /**
     * 代理投票者状況一覧を全件返します。
     *
     * @param parameter parameter
     * @return TohyojokyoDairishaの{@code list}
     */
    @Transaction
    public List<TohyojokyoDairishaSerachResult> get代理投票者状況一覧(TohyojokyoMapperParameter parameter) {
        ITohyoJokyoMapper mapper = mapperProvider.create(ITohyoJokyoMapper.class);
        return convertEntityToSearchResult(mapper.select代理投票者(parameter));
    }

    /**
     * 投票拒否者状況一覧を全件返します。
     *
     * @param parameter parameter
     * @return TohyojokyoDairishaの{@code list}
     */
    @Transaction
    public List<TohyojokyoDairishaSerachResult> get投票拒否者状況一覧(TohyojokyoMapperParameter parameter) {
        ITohyoJokyoMapper mapper = mapperProvider.create(ITohyoJokyoMapper.class);
        return convertEntityToSearchResult(mapper.select投票拒否者(parameter));
    }

    /**
     * 用紙返還投票者状況一覧を全件返します。
     *
     * @param parameter parameter
     * @return TohyojokyoDairishaの{@code list}
     */
    @Transaction
    public List<TohyojokyoDairishaSerachResult> get用紙返還投票者状況一覧(TohyojokyoMapperParameter parameter) {
        ITohyoJokyoMapper mapper = mapperProvider.create(ITohyoJokyoMapper.class);
        return convertEntityToSearchResult(mapper.select用紙返還投票者(parameter));
    }

    /**
     * 点字により投票者状況一覧を全件返します。
     *
     * @param parameter parameter
     * @return TohyojokyoDairishaの{@code list}
     */
    @Transaction
    public List<TohyojokyoDairishaSerachResult> get点字により投票者状況一覧(TohyojokyoMapperParameter parameter) {
        ITohyoJokyoMapper mapper = mapperProvider.create(ITohyoJokyoMapper.class);
        return convertEntityToSearchResult(mapper.select点字により投票者(parameter));
    }

    /**
     * 投票者数を返します。
     *
     * @param parameter parameter
     * @return 投票者数
     */
    @Transaction
    public int get投票者数(TohyojokyoMapperParameter parameter) {
        ITohyoJokyoMapper mapper = mapperProvider.create(ITohyoJokyoMapper.class);
        return mapper.select投票者数(parameter);
    }

    /**
     * 点字により投票者数を返します。
     *
     * @param parameter parameter
     * @return 点字により投票者数
     */
    @Transaction
    public int get点字により投票者数(TohyojokyoMapperParameter parameter) {
        ITohyoJokyoMapper mapper = mapperProvider.create(ITohyoJokyoMapper.class);
        return mapper.select点字により投票者数(parameter);
    }

    /**
     * 指定選挙番号、選挙番号AfT201TohyoJokyoEntityを削除します。
     *
     * @param 抄本番号 ShohonNo
     * @param 選挙番号 List<SenkyoNo>
     * @return 削除件数
     */
    @Transaction
    public int delete投票状況By抄本選挙番号(ShohonNo 抄本番号, List<SenkyoNo> 選挙番号) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本番号"));
        requireNonNull(選挙番号, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙番号"));

        List<AfT201TohyoJokyoEntity> 投票状況リスト = dac.selectByShohonSenkyoNo(抄本番号, 選挙番号);
        int 削除件数 = 0;
        for (AfT201TohyoJokyoEntity entity : 投票状況リスト) {
            削除件数 = dac.deletePhysical(entity) + 削除件数;
        }

        return 削除件数;
    }

    /**
     * 指定選挙番号、選挙番号AfT201TohyoJokyoEntityを削除します。
     *
     * @param 抄本番号 ShohonNo
     * @param 識別コード ShikibetsuCode
     * @param 選挙番号 SenkyoNo
     * @return 削除件数
     */
    @Transaction
    public int delete投票状況ByKey(ShohonNo 抄本番号, ShikibetsuCode 識別コード, SenkyoNo 選挙番号) {
        requireNonNull(抄本番号, UrSystemErrorMessages.値がnull.getReplacedMessage("抄本番号"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(選挙番号, UrSystemErrorMessages.値がnull.getReplacedMessage("選挙番号"));

        AfT201TohyoJokyoEntity 投票状況 = dac.selectByKey(抄本番号, 識別コード, 選挙番号);
        return dac.deletePhysical(投票状況);
    }

    private List<TohyojokyoDairishaSerachResult> convertEntityToSearchResult(List<TohyojokyoDairishaEntity> entityList) {
        List<TohyojokyoDairishaSerachResult> resultList = new ArrayList();
        if (null == entityList || entityList.isEmpty()) {
            return resultList;
        }

        for (TohyojokyoDairishaEntity entity : entityList) {
            resultList.add(new TohyojokyoDairishaSerachResult(entity.get投票状況Entity(), entity.get宛名情報Entity()));
        }
        return resultList;
    }

    /**
     * 投票状況情報を返します。
     *
     * @param shohonNo ShohonNo
     * @param shikibetsuCode ShikibetsuCode
     * @param tanmatsuID 端末ID
     * @return 投票状況情報
     */
    @Transaction
    public List<KijitsumaeTohyoJokyo> get投票状況情報(ShohonNo shohonNo, ShikibetsuCode shikibetsuCode, RString tanmatsuID) {
        ITohyoJokyoMapper mapper = mapperProvider.create(ITohyoJokyoMapper.class);
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(ShikibetsuTaishoGyomuHanteiKeyFactory.
                createInstance(GyomuCode.AF選挙, KensakuYusenKubun.住登外優先));

        key.set識別コード(shikibetsuCode);
        List<KijitsumaeTohyoJokyoEntity> relateEntityList = mapper.select投票状況情報(
                TohyojokyoMapperParameter.createParam(shohonNo,
                        shikibetsuCode,
                        tanmatsuID,
                        key.getPSM検索キー()));

        List<KijitsumaeTohyoJokyo> 投票状況情報List = new ArrayList<>();
        for (KijitsumaeTohyoJokyoEntity relateEntity : relateEntityList) {
            投票状況情報List.add(new KijitsumaeTohyoJokyo(relateEntity));
        }
        return 投票状況情報List;
    }

    /**
     * 投票資格情報を返します。
     *
     * @param shohonNo ShohonNo
     * @param shikibetsuCode ShikibetsuCode
     * @param tanmatsuID 端末ID
     * @return 投票資格情報
     */
    @Transaction
    public KijitsumaeSenkyoShikaku get投票資格情報(ShohonNo shohonNo, ShikibetsuCode shikibetsuCode, RString tanmatsuID) {
        ITohyoJokyoMapper mapper = mapperProvider.create(ITohyoJokyoMapper.class);

        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(ShikibetsuTaishoGyomuHanteiKeyFactory.
                createInstance(GyomuCode.AF選挙, KensakuYusenKubun.住登外優先));

        key.set識別コード(shikibetsuCode);
        key.set戸籍取得区分(KosekiShutokuKubun.戸籍情報を取得する);

        KijitsumaeSenkyoShikakuEntity relateEntityList = mapper.select投票資格情報(
                TohyojokyoMapperParameter.createParam(shohonNo,
                        shikibetsuCode,
                        tanmatsuID,
                        key.getPSM検索キー()));

        if (relateEntityList != null) {
            int aft505Count = aft505Dac.countBy選挙種類(relateEntityList.getAft113().getSenkyoShurui());
            KijitsumaeSenkyoShikaku rslt = new KijitsumaeSenkyoShikaku(relateEntityList, aft505Count);

            return rslt;
        } else {
            return null;
        }

    }

    /**
     * 指定選挙番号、選挙番号AfT201TohyoJokyoEntityを削除します。
     *
     * @param 削除用リスト List<TohyoJokyo>
     * @param 更新用リスト List<TohyoJokyo>
     * @return 削除件数+更新件数
     */
    @Transaction
    public List<ShikibetsuCode> deleteUpdate投票状況(List<TohyoJokyo> 削除用リスト, List<TohyoJokyo> 更新用リスト) {
        requireNonNull(削除用リスト, UrSystemErrorMessages.値がnull.getReplacedMessage("削除用リスト"));
        requireNonNull(更新用リスト, UrSystemErrorMessages.値がnull.getReplacedMessage("更新用リスト"));

        List<ShikibetsuCode> 更新対象リスト = new ArrayList<>();
        for (TohyoJokyo 投票状況 : 削除用リスト) {
            if (dac.deletePhysical(投票状況.toEntity()) > 0 && !更新対象リスト.contains(投票状況.get識別コード())) {
                更新対象リスト.add(投票状況.get識別コード());
            }
        }

        for (TohyoJokyo 投票状況 : 更新用リスト) {
            dac.save(投票状況.toEntity());
            if (!更新対象リスト.contains(投票状況.get識別コード())) {
                更新対象リスト.add(投票状況.get識別コード());
            }
        }
        return 更新対象リスト;
    }

    /**
     * 最新投票状況情報を返します。
     *
     * @param 抄本番号 ShohonNo
     * @param 端末ID RString
     * @param 投票状況 RString
     *
     * @return AfT201TohyoJokyoEntity
     */
    @Transaction
    public AfT201TohyoJokyoEntity getLast投票状況情報(ShohonNo 抄本番号, RString 端末ID, RString 投票状況) {

        List<AfT201TohyoJokyoEntity> entitys = dac.selectByClientId(抄本番号, 端末ID, 投票状況);
        if (null != entitys && !entitys.isEmpty()) {
            return entitys.get(0);
        }
        return null;

    }
}
