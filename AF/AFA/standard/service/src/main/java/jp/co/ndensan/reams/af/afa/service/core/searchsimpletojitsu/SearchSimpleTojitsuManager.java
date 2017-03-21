/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.searchsimpletojitsu;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.idosearchjumin.IdoSearchJumin;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.searchsimpletojitsu.SearchSimpleTojitsuMapperParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.IdoSearchJuminShikakuEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.searchsimpletojitsu.ISearchSimpleTojitsuMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 住民検索を管理するクラスです。
 *
 * @reamsid_L AF-0260-020 lis
 */
public class SearchSimpleTojitsuManager {

    private final AfaMapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public SearchSimpleTojitsuManager() {
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SearchSimpleTojitsuManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link SearchSimpleTojitsuManager}のインスタンス
     */
    public static SearchSimpleTojitsuManager createInstance() {
        return InstanceProvider.create(SearchSimpleTojitsuManager.class);
    }

    /**
     * 検索結果一覧を取得します。
     *
     * @param 検索条件 SearchSimpleTojitsuMapperParameter
     * @return List<JuminKensaku>
     */
    @Transaction
    public List<IdoSearchJumin> get検索結果一覧(SearchSimpleTojitsuMapperParameter 検索条件) {
        ISearchSimpleTojitsuMapper mapper = mapperProvider.create(ISearchSimpleTojitsuMapper.class);

        List<IdoSearchJuminShikakuEntity> entitys = mapper.select検索結果一覧(検索条件);
        List<IdoSearchJumin> juminKensakuList = new ArrayList<>();

        for (IdoSearchJuminShikakuEntity entity : entitys) {
            juminKensakuList.add(new IdoSearchJumin(entity));
        }

        return juminKensakuList;
    }
}
