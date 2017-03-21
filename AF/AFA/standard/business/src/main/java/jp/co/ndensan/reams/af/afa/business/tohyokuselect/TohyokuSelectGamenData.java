/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.tohyokuselect;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT501TohyokuEntity;

/**
 * 投票区保守の画面表示用データクラスです。
 *
 * @reamsid_L AF-0700-010 liuyj
 */
public class TohyokuSelectGamenData implements Serializable {

    private static final long serialVersionUID = -6967514159611800360L;

    private final AfT501TohyokuEntity entity;

    /**
     * コンストラクタです。
     */
    public TohyokuSelectGamenData() {
        entity = new AfT501TohyokuEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DBより取得した{@link AfT501TohyokuEntity}
     */
    public TohyokuSelectGamenData(AfT501TohyokuEntity entity) {
        this.entity = requireNonNull(entity);
    }

    /**
     * 投票区を返します。
     *
     * @return 投票区 AfT501TohyokuEntity
     */
    public AfT501TohyokuEntity getEntity() {
        return entity;
    }

}
