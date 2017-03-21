/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.fuzaishatohyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.fuzaishatohyo.SenkyoninSearchResult;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.fuzaishatohyo.SenkyoninMybatisParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.fuzaishatohyo.SenkyoninEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.fuzaishatohyo.IAFABTE201Mapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 選挙人Finder
 *
 * @reamsid_L AF-0080-010 lit
 */
public class SenkyoninFinder {

    private final AfaMapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    SenkyoninFinder() {
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider BaaMapperProvider
     */
    SenkyoninFinder(AfaMapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SenkyoninFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link SenkyoninFinder}のインスタンス
     */
    public static SenkyoninFinder createInstance() {
        return InstanceProvider.create(SenkyoninFinder.class);
    }

    /**
     * 選挙人リストを返す。
     *
     * @param param SenkyoninMybatisParameter
     * @return List<SenkyoninTohyoJokyoSearchResult>
     */
    @Transaction
    public List<SenkyoninSearchResult> getSenkyoninList(SenkyoninMybatisParameter param) {
        IAFABTE201Mapper mapper = mapperProvider.create(IAFABTE201Mapper.class);
        List<SenkyoninEntity> entities = mapper.selectSenkyoninList(param);

        List<SenkyoninSearchResult> searchResult = new ArrayList<>();
        for (SenkyoninEntity entity : entities) {
            searchResult.add(new SenkyoninSearchResult(entity));
        }
        return searchResult;
    }

    /**
     * 選挙人リストを返す。
     *
     * @param param SenkyoninMybatisParameter
     * @return List<SenkyoninTohyoJokyoSearchResult>
     */
    @Transaction
    public List<SenkyoninSearchResult> getSenkyoninListByShikibetsuCode(SenkyoninMybatisParameter param) {
        IAFABTE201Mapper mapper = mapperProvider.create(IAFABTE201Mapper.class);
        List<SenkyoninEntity> entities = mapper.selectSenkyoninListByShikibetsuCode(param);

        List<SenkyoninSearchResult> searchResult = new ArrayList<>();
        for (SenkyoninEntity entity : entities) {
            searchResult.add(new SenkyoninSearchResult(entity));
        }
        return searchResult;
    }

    /**
     * 選挙情報リストを返す。
     *
     * @param param SenkyoninMybatisParameter
     * @return List<SenkyoninTohyoJokyoSearchResult>
     */
    @Transaction
    public List<SenkyoninSearchResult> getSenkyoJoho(SenkyoninMybatisParameter param) {
        IAFABTE201Mapper mapper = mapperProvider.create(IAFABTE201Mapper.class);
        List<SenkyoninEntity> entities = mapper.selectSenkyoJoho(param);

        List<SenkyoninSearchResult> searchResult = new ArrayList<>();
        for (SenkyoninEntity entity : entities) {
            searchResult.add(new SenkyoninSearchResult(entity));
        }
        return searchResult;
    }
}
