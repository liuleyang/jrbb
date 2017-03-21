/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.meiboshokai;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.mybatis.param.meiboshokai.MeiboShokaiMapperParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.meiboshokai.MeiboShokaiEntity;

/**
 * 名簿照会用マッパーインタフェースです。
 *
 * @reamsid_L AF-0230-010 qiuxy
 */
public interface IMeiboShokaiMapper {

    /**
     * 投票状況一覧を取得します。
     *
     * @param 名簿照会検索条件 MeiboShokaiMapperParameter
     * @return 投票状況一覧 List<MeiboShokaiEntity>
     */
    List<MeiboShokaiEntity> selectTohyoJokyoIchiran(MeiboShokaiMapperParameter 名簿照会検索条件);
}
