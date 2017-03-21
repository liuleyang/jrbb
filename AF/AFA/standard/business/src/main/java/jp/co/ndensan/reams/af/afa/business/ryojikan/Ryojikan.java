/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.ryojikan;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT510RyojikanEntity;

/**
 * 領事官保守の検索結果のクラスです。
 *
 * @reamsid_L AF-0770-010 lis2
 */
public class Ryojikan implements Serializable {

    private static final long serialVersionUID = -6967514159611800361L;
    private AfT510RyojikanEntity entity;

    /**
     * コンストラクタです。
     */
    public Ryojikan() {
        entity = new AfT510RyojikanEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity AfT510RyojikanEntity
     */
    public Ryojikan(AfT510RyojikanEntity entity) {
        this.entity = entity;
    }

    /**
     * entityを設定します。
     *
     * @param entity AfT510RyojikanEntity
     */
    public void setEntity(AfT510RyojikanEntity entity) {
        this.entity = entity;
    }

    /**
     * entityを返します。
     *
     * @return entity AfT510RyojikanEntity
     */
    public AfT510RyojikanEntity getEntity() {
        return this.entity;
    }

}
