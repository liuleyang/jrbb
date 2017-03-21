/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.labelsealreprint;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT201TohyoJokyoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * ラベルシール再印刷の画面表示用データクラスです。
 *
 * @reamsid_L AF-0620-014 jihb
 */
public class LabelSealRePrintGamenData implements Serializable {

    private final UaFt200FindShikibetsuTaishoEntity atenaPSMEntity;
    private final AfT201TohyoJokyoEntity tohyoJokyoEntity;

    /**
     * コンストラクタです。
     *
     * @param atenaPSMEntity DBより取得した{@link UaFt200FindShikibetsuTaishoEntity}
     * @param tohyoJokyoEntity DBより取得した{@link AfT201TohyoJokyoEntity}
     */
    public LabelSealRePrintGamenData(UaFt200FindShikibetsuTaishoEntity atenaPSMEntity,
            AfT201TohyoJokyoEntity tohyoJokyoEntity) {
        this.atenaPSMEntity = requireNonNull(atenaPSMEntity);
        this.tohyoJokyoEntity = requireNonNull(tohyoJokyoEntity);
    }

    /**
     * 宛名PSMを返します。
     *
     * @return 宛名PSM UaFt200FindShikibetsuTaishoEntity
     */
    public UaFt200FindShikibetsuTaishoEntity getAtenaPSMEntity() {
        return this.atenaPSMEntity;
    }

    /**
     * 投票状況を返します。
     *
     * @return 投票状況 AfT201TohyoJokyoEntity
     */
    public AfT201TohyoJokyoEntity getTohyoJokyoEntity() {
        return this.tohyoJokyoEntity;
    }

}
