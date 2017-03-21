/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.meibotorokuzaigai;

import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 *
 * @reamsid_L AF-0170-020 lis
 */
public class FindShikibetsuTaishoResult {

    private final UaFt200FindShikibetsuTaishoEntity 宛名PSM;

    /**
     * コンストラクタです。<br/>
     *
     * @param 宛名PSM UaFt200FindShikibetsuTaishoEntity
     */
    public FindShikibetsuTaishoResult(
            UaFt200FindShikibetsuTaishoEntity 宛名PSM) {
        this.宛名PSM = 宛名PSM;
    }

    /**
     * 宛名PSMを返します。
     *
     * @return 宛名PSM
     */
    public UaFt200FindShikibetsuTaishoEntity get宛名PSM() {
        return 宛名PSM;
    }

}
