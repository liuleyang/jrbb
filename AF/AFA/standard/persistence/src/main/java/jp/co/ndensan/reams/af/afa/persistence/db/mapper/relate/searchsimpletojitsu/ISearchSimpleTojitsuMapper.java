/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.searchsimpletojitsu;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.searchsimpletojitsu.SearchSimpleTojitsuMapperParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.IdoSearchJuminShikakuEntity;

/**
 * 当日投票住民検索ダイアログのマッパーインタフェースです。
 *
 * @reamsid_L AF-0260-020 lis
 */
public interface ISearchSimpleTojitsuMapper {

    /**
     * 検索結果一覧を取得します。
     *
     * @param 検索条件 SearchSimpleTojitsuMapperParameter
     * @return List<IdoSearchJuminShikakuEntity>
     */
    List<IdoSearchJuminShikakuEntity> select検索結果一覧(SearchSimpleTojitsuMapperParameter 検索条件);
}
