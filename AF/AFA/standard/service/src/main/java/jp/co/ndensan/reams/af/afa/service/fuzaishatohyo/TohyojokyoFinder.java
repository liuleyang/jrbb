/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.fuzaishatohyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.fuzaishatohyo.TohyoJokyoSearchResult;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.fuzaishatohyo.TohyoJokyoMybatisParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.fuzaishatohyo.TohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.fuzaishatohyo.IAFABTE201Mapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 投票状況Finder
 *
 * @reamsid_L AF-0080-010 lit
 */
public class TohyojokyoFinder {

    private final AfaMapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    TohyojokyoFinder() {
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider BaaMapperProvider
     */
    TohyojokyoFinder(AfaMapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TohyojokyoFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link TohyojokyoFinder}のインスタンス
     */
    public static TohyojokyoFinder createInstance() {
        return InstanceProvider.create(TohyojokyoFinder.class);
    }

    /**
     * 投票状況リストを返す。
     *
     * @param param TohyoJokyoMybatisParameter
     * @return List<TohyoJokyoSearchResult>
     */
    @Transaction
    public List<TohyoJokyoSearchResult> getTohyoJokyoList(TohyoJokyoMybatisParameter param) {
        IAFABTE201Mapper mapper = mapperProvider.create(IAFABTE201Mapper.class);
        List<TohyoJokyoEntity> entities = mapper.selectTohyoJokyoList(param);

        List<TohyoJokyoSearchResult> searchResult = new ArrayList<>();
        for (TohyoJokyoEntity entity : entities) {
            if (null != entity.get投票状況Entity()) {
                entity.get投票状況Entity().initializeMd5();
            }
            searchResult.add(new TohyoJokyoSearchResult(entity));
        }
        return searchResult;
    }
}
