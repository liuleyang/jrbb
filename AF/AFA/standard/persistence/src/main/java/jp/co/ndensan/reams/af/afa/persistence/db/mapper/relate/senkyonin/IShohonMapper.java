/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.senkyonin;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.senkyonin.shohon.ShohonMapperParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyonin.shohon.ShohonEntity;

/**
 * 抄本のマッパーインタフェースです。
 */
public interface IShohonMapper {

    /**
     * 抄本情報をキー検索で１件取得します。
     *
     * @param 抄本検索条件 抄本検索条件
     * @return ShohonEntity
     */
    ShohonEntity select抄本ByKey(ShohonMapperParameter 抄本検索条件);

    /**
     * 主キー1に合致する抄本のリストを取得します。
     *
     * @param 抄本検索条件 抄本検索条件
     * @return ShohonEntityの{@code list}
     */
    List<ShohonEntity> select抄本リストBy主キー1(ShohonMapperParameter 抄本検索条件);
}
