/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.tohyokytohyojo;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT504TohyokuRelationEntity;

/**
 * 投票区投票所情報です
 *
 * @reamsid_L AF-0720-010 liuyj
 */
public class TohyokuRelation {

    private static final long serialVersionUID = -6967514159611800361L;
    private AfT504TohyokuRelationEntity entity;

    /**
     * コンストラクタです。
     */
    public TohyokuRelation() {
        entity = new AfT504TohyokuRelationEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity AfT504TohyokuRelationEntity
     */
    public TohyokuRelation(AfT504TohyokuRelationEntity entity) {
        this.entity = entity;
    }

    /**
     * entityを設定します。
     *
     * @param entity AfT504TohyokuRelationEntity
     */
    public void setEntity(AfT504TohyokuRelationEntity entity) {
        this.entity = entity;
    }

    /**
     * entityを返します。
     *
     * @return entity AfT504TohyokuRelationEntity
     */
    public AfT504TohyokuRelationEntity getEntity() {
        return this.entity;
    }
}
