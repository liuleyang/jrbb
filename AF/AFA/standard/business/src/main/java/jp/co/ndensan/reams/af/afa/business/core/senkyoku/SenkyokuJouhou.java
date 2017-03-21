/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.senkyoku;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT503SenkyokuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT505SenkyokuTanmatsuKanriEntity;

/**
 * 選挙区を管理するクラスです。
 *
 * @reamsid_L AF-0720-030 zhanggs
 */
public class SenkyokuJouhou implements Serializable {

    private static final long serialVersionUID = -6967514159611800360L;

    private AfT503SenkyokuEntity entity;
    private AfT505SenkyokuTanmatsuKanriEntity afT505Entity;

    /**
     * entityを設定します。
     *
     * @param entity AfT503SenkyokuEntity
     */
    public void setEntity(AfT503SenkyokuEntity entity) {
        this.entity = entity;
    }

    /**
     * afT505Entityを設定します。
     *
     * @param afT505Entity AfT505SenkyokuTanmatsuKanriEntity
     */
    public void setAfT505SenkyokuTanmatsuKanriEntity(AfT505SenkyokuTanmatsuKanriEntity afT505Entity) {
        this.afT505Entity = afT505Entity;
    }

    /**
     * entityを返します。
     *
     * @return entity AfT503SenkyokuEntity
     */
    public AfT503SenkyokuEntity getEntity() {
        return this.entity;
    }

    /**
     * afT505Entityを返します。
     *
     * @return afT505Entity AfT505SenkyokuTanmatsuKanriEntity
     */
    public AfT505SenkyokuTanmatsuKanriEntity getAfT505SenkyokuTanmatsuKanriEntity() {
        return this.afT505Entity;
    }

}
