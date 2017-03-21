/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.entity.db.relate.hojoshamaintenance.HojoshaMaintenanceEntity;

/**
 * AFAGMM2060 投票補助者保守
 *
 * @reamsid_L AF-0750-010 lis2
 */
public class HojoshaMaintenanceInfo implements Serializable {

    private HojoshaMaintenanceEntity entity;

    /**
     * コンストラクタです
     *
     */
    public HojoshaMaintenanceInfo() {
        this.entity = new HojoshaMaintenanceEntity();

    }

    /**
     * コンストラクタです。
     *
     * @param entity HojoshaMaintenanceEntity
     */
    public HojoshaMaintenanceInfo(HojoshaMaintenanceEntity entity) {
        this.entity = entity;
    }

    /**
     * entityを返します。
     *
     * @return entity HojoshaMaintenanceEntity
     */
    public HojoshaMaintenanceEntity getHojoshaMaintenanceEntity() {
        return this.entity;
    }

    /**
     * entityを設定します 。
     *
     * @param entity HojoshaMaintenanceEntity
     */
    public void setHojoshaMaintenanceEntity(HojoshaMaintenanceEntity entity) {
        this.entity = entity;
    }
}
