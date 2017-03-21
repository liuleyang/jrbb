/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.senkyonin;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.senkyonin.senkyoshikaku.SenkyoShikakuMapperParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyonin.senkyoshikaku.SenkyoShikakuEntity;

/**
 * 選挙資格のマッパーインタフェースです。
 */
public interface ISenkyoShikakuMapper {

    /**
     * 選挙資格情報をキー検索で１件取得します。
     *
     * @param 選挙資格検索条件 選挙資格検索条件
     * @return SenkyoShikakuEntity
     */
    SenkyoShikakuEntity select選挙資格ByKey(SenkyoShikakuMapperParameter 選挙資格検索条件);

    /**
     * 主キー1に合致する選挙資格のリストを取得します。
     *
     * @param 選挙資格検索条件 選挙資格検索条件
     * @return SenkyoShikakuEntityの{@code list}
     */
    List<SenkyoShikakuEntity> select選挙資格リストBy主キー1(SenkyoShikakuMapperParameter 選挙資格検索条件);
}
