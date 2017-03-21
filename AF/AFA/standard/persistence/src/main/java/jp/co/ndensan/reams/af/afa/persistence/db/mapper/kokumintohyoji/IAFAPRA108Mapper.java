/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.af.afa.persistence.db.mapper.kokumintohyoji;

import java.util.List;
import jp.co.ndensan.reams.af.afa.entity.db.relate.afabta101.TeiseishaMeiboEntity;

/**
 * 訂正者名簿データのマッパクラスのインタフェースです。
 *
 * @reamsid_L AF-0360-053 caiij2
 */
public interface IAFAPRA108Mapper {

    /**
     * 訂正者名簿用情報を取得します。
     *
     * @return 訂正者名簿情報 List<TeiseishaMeiboEntity>
     */
    List<TeiseishaMeiboEntity> selectTeiseishaList();

}
