/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.tohyokuhenko;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.shohon.shohon.Shohon;
import jp.co.ndensan.reams.af.afa.business.tohyokuhenko.SenkyoninMeiboJoho;
import jp.co.ndensan.reams.af.afa.business.tohyokuhenko.SenkyoninMeiboSearchResult;
import jp.co.ndensan.reams.af.afa.business.tohyokuhenko.ShikibetsuTaishoSearchResult;
import jp.co.ndensan.reams.af.afa.business.tohyokuhenko.TohyokuJohoSearchResult;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.tohyokuhenko.TohyokuHenkoMyBatisParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT501TohyokuEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT112SenkyoninMeiboDac;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT113SenkyoShikakuDac;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT501TohyokuDac;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.tohyokuhenko.ITohyokuHenkoMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.af.afa.service.core.shohon.shohon.ShohonManager;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.IShikibetsuTaishoFinder;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 投票区変更情報を管理するクラスです。
 *
 */
public class TohyokuHenkoManager {

    private final AfaMapperProvider mapperProvider;
    private final ITohyokuHenkoMapper mapper;
    private final AfT112SenkyoninMeiboDac afT112SenkyoninMeiboDac;
    private final AfT113SenkyoShikakuDac afT113SenkyoShikakuDac;
    private final AfT501TohyokuDac afT501TohyokuDac;
    private static final int MAX_履歴番号 = 0;

    /**
     * コンストラクタです。
     */
    public TohyokuHenkoManager() {
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
        mapper = mapperProvider.create(ITohyokuHenkoMapper.class);
        afT112SenkyoninMeiboDac = InstanceProvider.create(AfT112SenkyoninMeiboDac.class);
        afT113SenkyoShikakuDac = InstanceProvider.create(AfT113SenkyoShikakuDac.class);
        afT501TohyokuDac = InstanceProvider.create(AfT501TohyokuDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param afT112SenkyoninMeiboDac AfT112SenkyoninMeiboDac
     * @param afT113SenkyoShikakuDac AfT113SenkyoShikakuDac
     * @param afT501TohyokuDac AfT501TohyokuDac
     */
    TohyokuHenkoManager(
            AfaMapperProvider mapperProvider,
            ITohyokuHenkoMapper mapper,
            AfT112SenkyoninMeiboDac afT112SenkyoninMeiboDac,
            AfT113SenkyoShikakuDac afT113SenkyoShikakuDac,
            AfT501TohyokuDac afT501TohyokuDac
    ) {
        this.mapperProvider = mapperProvider;
        this.mapper = mapper;
        this.afT112SenkyoninMeiboDac = afT112SenkyoninMeiboDac;
        this.afT113SenkyoShikakuDac = afT113SenkyoShikakuDac;
        this.afT501TohyokuDac = afT501TohyokuDac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TohyokuHenkoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link HakkoSeiyakuManager}のインスタンス
     */
    public static TohyokuHenkoManager createInstance() {
        return InstanceProvider.create(TohyokuHenkoManager.class);
    }

    /**
     * 変更前名簿番号を取得します。
     *
     * @param 抄本番号 抄本番号
     * @param 識別コード 識別コード
     * @param massh massh
     * @return SenkyoninMeiboSearchResult
     */
    @Transaction
    public SenkyoninMeiboSearchResult get変更前名簿番号(ShohonNo 抄本番号, ShikibetsuCode 識別コード, boolean massh) {

        List<AfT112SenkyoninMeiboEntity> list = afT112SenkyoninMeiboDac.selectWithOrder(抄本番号, 識別コード, massh);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return new SenkyoninMeiboSearchResult(list.get(MAX_履歴番号));
    }

    /**
     * 変更後名簿番号を取得します。
     *
     * @param 抄本番号 抄本番号
     * @param 識別コード 識別コード
     * @param massh massh
     * @param 投票区コード 投票区コード
     * @return SenkyoninMeiboSearchResult
     */
    @Transaction
    public SenkyoninMeiboSearchResult get変更後名簿番号(ShohonNo 抄本番号, ShikibetsuCode 識別コード, boolean massh, RString 投票区コード) {
        List<AfT112SenkyoninMeiboEntity> list = afT112SenkyoninMeiboDac.selectByTohyokuCodeWithOrder(抄本番号, 識別コード, massh, 投票区コード);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return new SenkyoninMeiboSearchResult(list.get(MAX_履歴番号));

    }

    /**
     * 初期の変更後投票区を取得します。
     *
     * @param key TohyokuHenkoMyBatisParameter
     * @return TohyokuJohoSearchResult
     */
    @Transaction
    public RString get初期の変更後投票区(TohyokuHenkoMyBatisParameter key) {
        List<RString> tohyokuCodelist = mapper.getTohyokuCode(key);
        if (tohyokuCodelist == null) {
            return null;
        }
        return tohyokuCodelist.get(0);
    }

    /**
     * 選択した抄本内のMAX連番を取得します。
     *
     * @param 抄本番号 ShohonNo
     * @return 選択した抄本内のMAX連番 int
     */
    @Transaction
    public int get選択した抄本内のMAX連番(ShohonNo 抄本番号) {
        return afT112SenkyoninMeiboDac.selectMaxRenbanWithShohonNo(抄本番号);
    }

    /**
     * 投票区を取得します。
     *
     * @param senkyoShurui 選挙種類
     * @param tohyokuCode 投票区コード
     * @return AfT501TohyokuEntity 投票区
     */
    @Transaction
    public TohyokuJohoSearchResult get投票区(Code senkyoShurui, RString tohyokuCode) {
        TohyokuJohoSearchResult result;
        AfT501TohyokuEntity entity = afT501TohyokuDac.select(senkyoShurui, tohyokuCode);
        if (entity == null) {
            result = null;
        } else {
            result = new TohyokuJohoSearchResult(entity);
        }
        return result;
    }

    /**
     * 投票区リストを取得します。
     *
     * @param senkyoShurui 選挙種類
     * @return 投票区リスト
     */
    @Transaction
    public List<TohyokuJohoSearchResult> get投票区リスト(Code senkyoShurui) {
        List<TohyokuJohoSearchResult> resultList = new ArrayList();
        List<AfT501TohyokuEntity> entiyList = afT501TohyokuDac.select(senkyoShurui);
        for (AfT501TohyokuEntity entity : entiyList) {
            resultList.add(new TohyokuJohoSearchResult(entity));
        }
        return resultList;
    }

    /**
     * 選挙人名簿を登録します。
     *
     * @param 登録用選挙人名簿情報 SenkyoninMeiboJoho
     * @return int 登録件数
     */
    @Transaction
    public int 選挙人名簿登録(SenkyoninMeiboJoho 登録用選挙人名簿情報) {
        AfT112SenkyoninMeiboEntity 登録用選挙人名簿 = new AfT112SenkyoninMeiboEntity();
        登録用選挙人名簿.setShohonNo(登録用選挙人名簿情報.getShohonNo());
        登録用選挙人名簿.setGroupCode(登録用選挙人名簿情報.getGroupCode());
        登録用選挙人名簿.setTohyokuCode(登録用選挙人名簿情報.getTohyokuCode());
        登録用選挙人名簿.setSatsu(登録用選挙人名簿情報.getSatsu());
        登録用選挙人名簿.setPage(登録用選挙人名簿情報.getPage());
        登録用選挙人名簿.setGyo(登録用選挙人名簿情報.getGyo());
        登録用選挙人名簿.setShikibetsuCode(登録用選挙人名簿情報.getShikibetsuCode());
        登録用選挙人名簿.setTohyokuHenkoMasshoFlag(登録用選挙人名簿情報.isTohyokuHenkoMasshoFlag());
        登録用選挙人名簿.setRenban(登録用選挙人名簿情報.getRenban());
        登録用選挙人名簿.setEdaban(登録用選挙人名簿情報.getEdaban());
        登録用選挙人名簿.setSeq(登録用選挙人名簿情報.getSeq());
        return afT112SenkyoninMeiboDac.insert(登録用選挙人名簿);
    }

    /**
     * 選挙人名簿を更新します。
     *
     * @param meiboSearchResult SenkyoninMeiboSearchResult
     * @return 更新件数
     */
    @Transaction
    public int 選挙人名簿更新(SenkyoninMeiboSearchResult meiboSearchResult) {
        AfT112SenkyoninMeiboEntity entity = meiboSearchResult.getEntity();
        entity.setTohyokuHenkoMasshoFlag(true);
        return afT112SenkyoninMeiboDac.save(entity);

    }

    /**
     * 選挙資格を更新します。
     *
     * @param 更新用選挙人名簿情報 SenkyoninMeiboJoho
     * @return 更新件数
     */
    @Transaction
    public int 選挙資格更新(SenkyoninMeiboJoho 更新用選挙人名簿情報) {
        int update = 0;
        ShohonManager manager = ShohonManager.createInstance();
        Shohon shohon = manager.get抄本(更新用選挙人名簿情報.getShohonNo());
        Code senkyoShurui = shohon.get選挙種類();
        List<AfT113SenkyoShikakuEntity> list = afT113SenkyoShikakuDac.selectWithOrder(senkyoShurui, 更新用選挙人名簿情報.getShikibetsuCode());
        if (list != null && !list.isEmpty()) {
            AfT113SenkyoShikakuEntity entity = list.get(MAX_履歴番号);
            entity.setTohyokuCode(更新用選挙人名簿情報.getTohyokuCode());
            update = afT113SenkyoShikakuDac.save(entity);
        }
        return update;

    }

    /**
     * 直近宛名PSMを取得します。
     *
     * @param 識別コード ShikibetsuCode
     * @return 直近宛名PSM
     */
    @Transaction
    public ShikibetsuTaishoSearchResult 直近宛名PSM取得(ShikibetsuCode 識別コード) {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(ShikibetsuTaishoGyomuHanteiKeyFactory
                .createInstance(GyomuCode.AF選挙, KensakuYusenKubun.住登内優先));
        key.set識別コード(識別コード);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        IShikibetsuTaishoFinder finder = ShikibetsuTaishoService.getShikibetsuTaishoFinder();
        List<IShikibetsuTaisho> atenaList = finder.get識別対象s(key.build());
        return new ShikibetsuTaishoSearchResult(atenaList.get(0));

    }
}
