/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.jumintohyojitoroku;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.entity.db.relate.jumintohyojitoroku.ShohonJohoEntity;

/**
 * 抄本情報のマッパーインタフェースです。
 *
 * @reamsid_L AF-0450-010 jihb
 */
public interface IJuminTohyojiTorokuMapper {

    /**
     * 抄本番号に合致する抄本情報を取得します。
     *
     * @param 抄本番号 ShohonNo
     * @return ShohonJohoEntity{@code list}
     */
    ShohonJohoEntity select抄本情報By抄本番号(ShohonNo 抄本番号);
}
