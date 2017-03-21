/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.tohyoshikaku;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT114FuzaishaTohyoShikakuEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import org.apache.ibatis.annotations.Param;

/**
 * 不在者投票資格情報を管理するクラス。
 *
 * @reamsid_L AF-0210-020 liuj
 */
public interface ITohyoShikakuMapper {

    /**
     * 不在者投票資格情報を取得します。
     *
     * @param shikibetsuCode ShikibetsuCode
     * @param tohyoShikakuShurui Code
     * @return AfT114FuzaishaTohyoShikakuEntity
     */
    AfT114FuzaishaTohyoShikakuEntity selectFuzaishaTohyoShikaku(@Param("shikibetsuCode") ShikibetsuCode shikibetsuCode,
            @Param("tohyoShikakuShurui") Code tohyoShikakuShurui);
}
