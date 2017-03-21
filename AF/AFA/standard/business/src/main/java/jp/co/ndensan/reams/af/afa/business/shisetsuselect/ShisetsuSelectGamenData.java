/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.shisetsuselect;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT507ShisetsuEntity;

/**
 * 不在者投票管理施設の画面表示用データクラスです。
 *
 * @reamsid_L AF-0730-010 liuj
 */
public class ShisetsuSelectGamenData implements Serializable {

    private static final long serialVersionUID = -6967514159611800360L;

    private final AfT507ShisetsuEntity entity;

    /**
     * コンストラクタです。
     */
    public ShisetsuSelectGamenData() {
        entity = new AfT507ShisetsuEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DBより取得した{@link AfT507ShisetsuEntity}
     */
    public ShisetsuSelectGamenData(AfT507ShisetsuEntity entity) {
        this.entity = requireNonNull(entity);
    }

    /**
     * 施設を返します。
     *
     * @return 施設 AfT507ShisetsuEntity
     */
    public AfT507ShisetsuEntity getEntity() {
        return entity;
    }

}
