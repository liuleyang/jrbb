/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.yubinshikaku;

import jp.co.ndensan.reams.af.afa.entity.db.relate.yubinshikaku.YubinShikakuEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import org.apache.ibatis.annotations.Param;

/**
 * 立会人引継情報を管理するクラス。
 *
 * @reamsid_L AF-0200-020 liuj2
 */
public interface IYubinShikakuMapper {

    /**
     * 引数.識別コードによって、郵便等投票資格情報を取得します。
     *
     * @param shikibetsuCode ShikibetsuCode
     * @return YubinShikakuEntity
     */
    YubinShikakuEntity select郵便等投票資格情報(@Param("shikibetsuCode") ShikibetsuCode shikibetsuCode);
}
