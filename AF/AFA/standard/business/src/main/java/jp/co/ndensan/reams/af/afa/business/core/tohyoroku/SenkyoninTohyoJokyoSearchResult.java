/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.tohyoroku;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.entity.db.relate.SenkyoninTohyoJokyoEntity;

/**
 * 選挙人資格の情報用ビジネスです。
 *
 * @reamsid_L AF-0130-010 lit
 */
public class SenkyoninTohyoJokyoSearchResult implements Serializable {

    private final SenkyoninTohyoJokyoEntity entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link SenkyoninTohyoJokyoEntity}を生成します。
     *
     * @param entity DBより取得した{@link SenkyoninTohyoJokyoEntity}
     */
    public SenkyoninTohyoJokyoSearchResult(SenkyoninTohyoJokyoEntity entity) {
        this.entity = requireNonNull(entity);
    }

    /**
     * entityを返します。
     *
     * @return entity SenkyoninTohyoJokyoEntity
     */
    public SenkyoninTohyoJokyoEntity getEntity() {
        return this.entity;
    }
}
