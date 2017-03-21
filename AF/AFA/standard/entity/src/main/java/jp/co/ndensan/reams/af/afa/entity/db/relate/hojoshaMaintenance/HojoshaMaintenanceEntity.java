/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.hojoshamaintenance;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT502TohyojoEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT508HojoshaEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * AFAGMM2060 投票補助者保守
 *
 * @reamsid_L AF-0750-010 lis2
 */
@lombok.Getter
@lombok.Setter
public class HojoshaMaintenanceEntity implements Serializable {

    private static final long serialVersionUID = -6967514159611800351L;
    private UaFt200FindShikibetsuTaishoEntity 宛名PSM情報;
    private AfT508HojoshaEntity 補助者情報;
    private AfT502TohyojoEntity 投票所情報;

    /**
     * コンストラクタです
     *
     */
    public HojoshaMaintenanceEntity() {
        this.宛名PSM情報 = new UaFt200FindShikibetsuTaishoEntity();
        this.補助者情報 = new AfT508HojoshaEntity();
        this.投票所情報 = new AfT502TohyojoEntity();
    }
}
