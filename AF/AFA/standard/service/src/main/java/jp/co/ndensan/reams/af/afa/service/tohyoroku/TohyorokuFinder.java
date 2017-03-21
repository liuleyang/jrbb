/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.tohyoroku;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.tohyoroku.SenkyoninTohyoJokyoSearchResult;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.tohyoroku.TohyorokuMapperParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.tohyoroku.IAFABTE502Mapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * ビジネスクラス
 *
 * @reamsid_L AF-0130-010 lit
 */
public class TohyorokuFinder {

    private final AfaMapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    TohyorokuFinder() {
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider BaaMapperProvider
     */
    TohyorokuFinder(AfaMapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TohyorokuManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link TohyorokuManager}のインスタンス
     */
    public static TohyorokuFinder createInstance() {
        return InstanceProvider.create(TohyorokuFinder.class);
    }

    /**
     * 集計用リストを返す。
     *
     * @param param param
     * @return List<SenkyoninTohyoJokyoSearchResult>
     */
    @Transaction
    public List<SenkyoninTohyoJokyoSearchResult> getSenkyoninTohyoJokyoList(TohyorokuMapperParameter param) {
        IAFABTE502Mapper mapper = mapperProvider.create(IAFABTE502Mapper.class);
        List<SenkyoninTohyoJokyoEntity> entities = mapper.selectSenkyoninTohyoJokyoList(param);

        List<SenkyoninTohyoJokyoSearchResult> searchResult = new ArrayList<>();
        for (SenkyoninTohyoJokyoEntity entity : entities) {
            searchResult.add(new SenkyoninTohyoJokyoSearchResult(entity));
        }
        return searchResult;
    }
}
