/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT502TohyojoEntity;

/**
 * 投票所を管理するクラスです。
 *
 * @reamsid_L AF-0710-010 liuyj
 */
public class TohyojoForCtrl implements Serializable {

    private static final long serialVersionUID = -6967514159611800361L;

    private final AfT502TohyojoEntity entity;

    /**
     * コンストラクタです。
     */
    public TohyojoForCtrl() {
        entity = new AfT502TohyojoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DBより取得した{@link AfT502TohyojoEntity}
     */
    public TohyojoForCtrl(AfT502TohyojoEntity entity) {
        this.entity = requireNonNull(entity);
    }

    /**
     * 投票所を返します。
     *
     * @return 投票所 AfT502TohyojoEntity
     */
    public AfT502TohyojoEntity getEntity() {
        return entity;
    }
}
