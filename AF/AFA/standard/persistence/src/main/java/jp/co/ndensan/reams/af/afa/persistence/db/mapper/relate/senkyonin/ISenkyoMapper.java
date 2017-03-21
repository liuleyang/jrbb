/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.senkyonin;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.senkyonin.senkyo.SenkyoMapperParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyonin.senkyo.SenkyoEntity;

/**
 * 選挙のマッパーインタフェースです。
 */
public interface ISenkyoMapper {

    /**
     * 選挙情報をキー検索で１件取得します。
     *
     * @param 選挙検索条件 選挙検索条件
     * @return SenkyoEntity
     */
    SenkyoEntity select選挙ByKey(SenkyoMapperParameter 選挙検索条件);

    /**
     * 主キー1に合致する選挙のリストを取得します。
     *
     * @param 選挙検索条件 選挙検索条件
     * @return SenkyoEntityの{@code list}
     */
    List<SenkyoEntity> select選挙リストBy主キー1(SenkyoMapperParameter 選挙検索条件);
}
