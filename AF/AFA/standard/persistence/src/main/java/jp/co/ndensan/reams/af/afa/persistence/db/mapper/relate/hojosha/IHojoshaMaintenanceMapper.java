/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.persistence.db.mapper.relate.hojosha;

import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.mybatisprm.hojoshamaintenance.HojoshaMaintenanceMybatisParameter;
import jp.co.ndensan.reams.af.afa.entity.db.relate.hojoshamaintenance.HojoshaMaintenanceEntity;

/**
 * 投票補助者保守のマッパーインタフェースです。
 *
 * @reamsid_L AF-0750-010 lis2
 */
public interface IHojoshaMaintenanceMapper {

    /**
     * 補助者情報を取得する。
     *
     * @param param HojoshaMaintenanceMybatisParameter
     * @return 補助者情報 List<HojoshaMaintenanceEntity>
     */
    List<HojoshaMaintenanceEntity> select補助者情報By抄本番号(HojoshaMaintenanceMybatisParameter param);

    /**
     * 宛名情報を取得する。
     *
     * @param param HojoshaMaintenanceMybatisParameter
     * @return int
     */
    int select宛名情報By識別コード(HojoshaMaintenanceMybatisParameter param);
}
