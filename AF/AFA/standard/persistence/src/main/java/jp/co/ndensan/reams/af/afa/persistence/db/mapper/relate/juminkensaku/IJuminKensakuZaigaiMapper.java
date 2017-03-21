/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.juminkensaku;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.juminkensaku.JuminKensakuMapperParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.JuminKensakuEntity;

/**
 * 住民検索のマッパーインタフェースです。
 *
 * @reamsid_L AF-0230-020 qiuxy
 */
public interface IJuminKensakuZaigaiMapper {

    /**
     * 検索結果一覧を取得します。
     *
     * @param 住民検索条件 JuminKensakuMapperParameter
     * @return List<FuzaishaTohyoShikakuEntity>
     */
    List<JuminKensakuEntity> select検索結果一覧(JuminKensakuMapperParameter 住民検索条件);

    /**
     * 総件数を取得します。
     *
     * @param 住民検索条件 JuminKensakuMapperParameter
     * @return 総件数 int
     */
    int select総件数(JuminKensakuMapperParameter 住民検索条件);
}
