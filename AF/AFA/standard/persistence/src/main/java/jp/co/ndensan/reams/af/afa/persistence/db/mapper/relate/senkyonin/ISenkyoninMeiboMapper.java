/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.senkyonin;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.senkyonin.senkyoninmeibo.SenkyoninMeiboMapperParameter;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.senkyonin.senkyoninmeibo.SenkyoninMeiboPsmMapperParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyonin.senkyoninmeibo.SenkyoninMeiboEntity;

/**
 * 選挙人名簿のマッパーインタフェースです。
 */
public interface ISenkyoninMeiboMapper {

    /**
     * 選挙人名簿情報をキー検索で１件取得します。
     *
     * @param 選挙人名簿検索条件 選挙人名簿検索条件
     * @return SenkyoninMeiboEntity
     */
    SenkyoninMeiboEntity select選挙人名簿ByKey(SenkyoninMeiboMapperParameter 選挙人名簿検索条件);

    /**
     * 主キー1に合致する選挙人名簿のリストを取得します。
     *
     * @param 選挙人名簿検索条件 選挙人名簿検索条件
     * @return SenkyoninMeiboEntityの{@code list}
     */
    List<SenkyoninMeiboEntity> select選挙人名簿リストBy主キー1(SenkyoninMeiboMapperParameter 選挙人名簿検索条件);

    /**
     * 選挙人名簿人数を取得します。
     *
     * @param 選挙人名簿検索条件 選挙人名簿検索条件
     * @return 選挙人名簿人数
     */
    int selectSenkyoninMeiboCount(SenkyoninMeiboPsmMapperParameter 選挙人名簿検索条件);
}
