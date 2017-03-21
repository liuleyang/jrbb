/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.senkyonin;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.senkyonin.fuzaishatohyoshikaku.FuzaishaTohyoShikakuMapperParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.senkyonin.fuzaishatohyoshikaku.FuzaishaTohyoShikakuEntity;

/**
 * 不在者投票資格のマッパーインタフェースです。
 */
public interface IFuzaishaTohyoShikakuMapper {

    /**
     * 不在者投票資格情報をキー検索で１件取得します。
     *
     * @param 不在者投票資格検索条件 不在者投票資格検索条件
     * @return FuzaishaTohyoShikakuEntity
     */
    FuzaishaTohyoShikakuEntity select不在者投票資格ByKey(FuzaishaTohyoShikakuMapperParameter 不在者投票資格検索条件);

    /**
     * 主キー1に合致する不在者投票資格のリストを取得します。
     *
     * @param 不在者投票資格検索条件 不在者投票資格検索条件
     * @return FuzaishaTohyoShikakuEntityの{@code list}
     */
    List<FuzaishaTohyoShikakuEntity> select不在者投票資格リストBy主キー1(FuzaishaTohyoShikakuMapperParameter 不在者投票資格検索条件);
}
