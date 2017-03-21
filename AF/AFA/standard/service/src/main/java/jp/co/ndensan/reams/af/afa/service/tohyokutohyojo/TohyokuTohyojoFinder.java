/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.tohyokutohyojo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.tohyokytohyojo.TohyokuRelation;
import jp.co.ndensan.reams.af.afa.business.tohyokytohyojo.TohyokuTohyojo;
import jp.co.ndensan.reams.af.afa.business.tohyokytohyojo.TohyokuTohyojoZero;
import jp.co.ndensan.reams.af.afa.entity.db.relate.tohyokutohyojo.TohyokuTohyojoForMap;
import jp.co.ndensan.reams.af.afa.entity.db.relate.tohyokutohyojo.TohyokuTohyojoZeroForMap;
import jp.co.ndensan.reams.af.afa.persistence.db.basic.AfT504TohyokuRelationDac;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.tohyokutohyojo.ITohyokuTohyojoMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * AFAGMM2040 投票区投票所対応保守Finder
 *
 * @reamsid_L AF-0740-010 lis2
 */
public class TohyokuTohyojoFinder {

    private final AfT504TohyokuRelationDac afT504TohyokuRelationDac;
    private final AfaMapperProvider mapperProvider;

    TohyokuTohyojoFinder() {
        afT504TohyokuRelationDac = InstanceProvider.create(AfT504TohyokuRelationDac.class);
        mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
    }

    /**
     * インスタンスを作成します。
     *
     * @return インスタンス
     */
    public static TohyokuTohyojoFinder createInstance() {
        return InstanceProvider.create(TohyokuTohyojoFinder.class);
    }

    /**
     * 選挙区情報リストを取得します。
     *
     * @param 選挙種類 RString
     * @param 導入団体コード LasdecCode
     * @param 導入団体コード連番 int
     * @param システム日付 FlexibleDate
     * @return 投票区投票所対応情報 List<TohyokuTohyojoZero>
     */
    @Transaction
    public List<TohyokuTohyojoZero> select投票区投票所対応情報By選挙種類がゼロ(RString 選挙種類, LasdecCode 導入団体コード,
            int 導入団体コード連番, FlexibleDate システム日付) {
        ITohyokuTohyojoMapper mapper = mapperProvider.create(ITohyokuTohyojoMapper.class);
        List<TohyokuTohyojoZeroForMap> 投票区投票所ゼロマップリスト
                = mapper.select投票区投票所対応情報By選挙種類がゼロ(選挙種類, 導入団体コード, 導入団体コード連番, システム日付);
        List<TohyokuTohyojoZero> 投票区投票所リスト = new ArrayList();
        for (TohyokuTohyojoZeroForMap 投票区投票所ゼロマップ : 投票区投票所ゼロマップリスト) {
            TohyokuTohyojoZero 投票区投票所 = new TohyokuTohyojoZero();

            投票区投票所.setTohyokuTohyojoZeroForMap(投票区投票所ゼロマップ);
            投票区投票所リスト.add(投票区投票所);
        }
        return 投票区投票所リスト;

    }

    /**
     * 選挙区情報リストを取得します。
     *
     * @param 選挙種類 選挙種類
     * @return 投票区投票所対応情報 List<SenkyokuJoho>
     */
    @Transaction
    public List<TohyokuTohyojo> select投票区投票所対応情報(RString 選挙種類) {
        ITohyokuTohyojoMapper mapper = mapperProvider.create(ITohyokuTohyojoMapper.class);
        List<TohyokuTohyojoForMap> 投票区投票所マップリスト = mapper.select投票区投票所対応情報(選挙種類);
        List<TohyokuTohyojo> 投票区投票所リスト = new ArrayList();
        for (TohyokuTohyojoForMap 投票区投票所マップ : 投票区投票所マップリスト) {
            TohyokuTohyojo 投票区投票所 = new TohyokuTohyojo();
            投票区投票所.setTohyokuTohyojoForMap(投票区投票所マップ);
            投票区投票所リスト.add(投票区投票所);
        }
        return 投票区投票所リスト;
    }

    /**
     * エンティティを登録します。
     *
     * @param 投票区投票所 TohyokuRelation
     * @return int
     */
    @Transaction
    public int save投票区投票所(TohyokuRelation 投票区投票所) {
        return afT504TohyokuRelationDac.save(投票区投票所.getEntity());
    }
}
