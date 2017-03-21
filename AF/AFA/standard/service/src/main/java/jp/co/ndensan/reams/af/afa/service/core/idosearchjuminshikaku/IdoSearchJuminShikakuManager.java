/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.service.core.idosearchjuminshikaku;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.business.core.idosearchjumin.IdoSearchJumin;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.idosearchjuminshikaku.IdoSearchJuminShikakuParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.IdoSearchJuminShikakuEntity;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.idosearchjuminshikaku.IdoSearchJuminShikakuMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.idosearchjuminshikaku.IdoSearchJuminShikakuZaigaiMapper;
import jp.co.ndensan.reams.af.afa.persistence.db.mapper.util.AfaMapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 住民検索（資格）を管理するクラスです。
 *
 * @reamsid_L AF-0180-013 liuyj
 */
public class IdoSearchJuminShikakuManager {

    private final AfaMapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public IdoSearchJuminShikakuManager() {
        this.mapperProvider = InstanceProvider.create(AfaMapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link IdoSearchJuminShikakuManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link IdoSearchJuminShikakuManager}のインスタンス
     */
    public static IdoSearchJuminShikakuManager createInstance() {
        return InstanceProvider.create(IdoSearchJuminShikakuManager.class);
    }

    /**
     * 検索結果一覧を取得します。
     *
     * @param 住民検索条件 IdoSearchJuminShikakuMapperParameter
     * @return List<IdoSearchJuminShikaku>
     */
    @Transaction
    public List<IdoSearchJumin> get検索結果一覧(IdoSearchJuminShikakuParameter 住民検索条件) {
        requireNonNull(住民検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("住民検索条件"));

        List<IdoSearchJuminShikakuEntity> entitys;
        if (住民検索条件.is在外()) {
            IdoSearchJuminShikakuZaigaiMapper mapper = mapperProvider.create(IdoSearchJuminShikakuZaigaiMapper.class);
            entitys = mapper.select検索結果一覧(住民検索条件);
        } else {
            IdoSearchJuminShikakuMapper mapper = mapperProvider.create(IdoSearchJuminShikakuMapper.class);
//        List<IdoSearchJuminShikakuEntity> entitys = mapper.select検索結果一覧(住民検索条件);
            entitys = mapper.select検索結果一覧(住民検索条件);
        }

        List<IdoSearchJumin> list = new ArrayList<>();
        for (IdoSearchJuminShikakuEntity entity : entitys) {
            list.add(new IdoSearchJumin(entity));
        }

        return list;
    }
}
