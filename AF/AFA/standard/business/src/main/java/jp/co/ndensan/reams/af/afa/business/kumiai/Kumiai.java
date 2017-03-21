/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.kumiai;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT509KumiaiEntity;

/**
 * AFAGMM2070_組合保守
 *
 * @reamsid_L AF-0760-010 lis2
 */
public class Kumiai implements Serializable {

    private static final long serialVersionUID = -6967514159611800361L;
    private AfT509KumiaiEntity entity;

    /**
     * コンストラクタです。
     */
    public Kumiai() {
        entity = new AfT509KumiaiEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity AfT509KumiaiEntity
     */
    public Kumiai(AfT509KumiaiEntity entity) {
        this.entity = entity;
    }

    /**
     * entityを設定します。
     *
     * @param entity AfT509KumiaiEntity
     */
    public void setEntity(AfT509KumiaiEntity entity) {
        this.entity = entity;
    }

    /**
     * entityを返します。
     *
     * @return entity AfT509KumiaiEntity
     */
    public AfT509KumiaiEntity getEntity() {
        return this.entity;
    }
}
