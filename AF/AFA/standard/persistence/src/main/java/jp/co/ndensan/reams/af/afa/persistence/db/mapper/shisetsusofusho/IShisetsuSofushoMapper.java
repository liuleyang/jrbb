/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.shisetsusofusho;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.processprm.shisetsusofusho.AFABTE205SelectProcessMyBatisParameter;
import jp.co.ndensan.reams.af.afa.definition.processprm.shisetsusofusho.AFABTE205SelectProcessParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.shisetsusofusho.ShisetsusofushoEntity;

/**
 * 施設送付書発行のマッパクラスのインタフェースです。
 *
 * @reamsid_L AF-0250-020 zhangl
 *
 */
public interface IShisetsuSofushoMapper {

    /**
     * 検索条件により、施設送付書情報を取得します。
     *
     * @param parameter AFABTE205SelectProcessMyBatisParameter
     * @return 施設送付書情報リスト List<ShisetsusofushoEntity>
     */
    List<ShisetsusofushoEntity> getShisetsuSofushoList(AFABTE205SelectProcessMyBatisParameter parameter);

    /**
     * 検索条件により、選挙情報を取得します。
     *
     * @param parameter AFABTE205SelectProcessParameter
     * @return 選挙情報 ShisetsusofushoEntity
     */
    ShisetsusofushoEntity select選挙の一番未来の日(AFABTE205SelectProcessParameter parameter);

}
