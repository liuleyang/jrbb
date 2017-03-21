/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.basic;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.shikakushokai.SenkyoShikakuMapperParameter;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;

/**
 *
 * @reamsid_L AF-0190-010 guancy
 */
public interface IAfT113SenkyoShikakuMapper {

    /**
     * 主キーに合致する選挙資格のリストを取得します。
     *
     * @param 選挙資格検索条件 選挙資格検索条件
     * @return AfT113SenkyoShikakuEntity{@code list}
     */
    List<AfT113SenkyoShikakuEntity> select選挙資格リストByKey(SenkyoShikakuMapperParameter 選挙資格検索条件);

}
