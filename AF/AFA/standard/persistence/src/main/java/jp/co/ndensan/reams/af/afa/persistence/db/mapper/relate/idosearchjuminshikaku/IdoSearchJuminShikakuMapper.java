/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.idosearchjuminshikaku;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.idosearchjuminshikaku.IdoSearchJuminShikakuParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.IdoSearchJuminShikakuEntity;

/**
 * 住民検索のマッパーインタフェースです。
 *
 * @reamsid_L AF-0180-013 liuyj
 */
public interface IdoSearchJuminShikakuMapper {

    /**
     * 検索結果一覧を取得します。
     *
     * @param 住民検索条件 IdoSearchJuminShikakuParameter
     * @return List<IdoSearchJuminShikakuEntity>
     */
    List<IdoSearchJuminShikakuEntity> select検索結果一覧(IdoSearchJuminShikakuParameter 住民検索条件);
}
