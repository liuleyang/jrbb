/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.shikakushokai;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.shikakushokai.FuzaishaTohyoShikakuMapperParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.shikakushokai.FuzaishaTohyoShikakuEntity;

/**
 * 不在者投票資格のマッパーインタフェースです。
 *
 * @reamsid_L AF-0190-010 guancy
 */
public interface IShikakuShokaiMapper {

    /**
     * 主キー1に合致する不在者投票資格のリストを取得します。
     *
     * @param 不在者投票資格検索条件 不在者投票資格検索条件
     * @return FuzaishaTohyoShikakuEntityの{@code list}
     */
    List<FuzaishaTohyoShikakuEntity> select不在者投票資格リストByKey1(FuzaishaTohyoShikakuMapperParameter 不在者投票資格検索条件);
}
