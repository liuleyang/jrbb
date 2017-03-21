/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.senkyokutanmatsukanri;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT505SenkyokuTanmatsuKanriEntity;

/**
 * 選挙区端末管理を管理するクラスです。
 *
 * @reamsid_L AF-0720-030 zhanggs
 */
public class SenkyokuTanmatsuKanriJoho implements Serializable {

    private static final long serialVersionUID = -6967514159611800360L;

    private AfT505SenkyokuTanmatsuKanriEntity entity;

    /**
     * コンストラクタです。
     */
    public SenkyokuTanmatsuKanriJoho() {
        entity = new AfT505SenkyokuTanmatsuKanriEntity();
    }

    /**
     * entity
     *
     * @return AfT505SenkyokuTanmatsuKanriEntity
     */
    public AfT505SenkyokuTanmatsuKanriEntity getEntity() {
        return entity;
    }

    /**
     * entity
     *
     * @param entity AfT505SenkyokuTanmatsuKanriEntity
     */
    public void setEntity(AfT505SenkyokuTanmatsuKanriEntity entity) {
        this.entity = entity;
    }

}
