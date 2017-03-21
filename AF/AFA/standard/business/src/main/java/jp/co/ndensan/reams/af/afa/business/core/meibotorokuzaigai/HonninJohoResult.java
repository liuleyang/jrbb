/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core.meibotorokuzaigai;

import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;

/**
 * 本人情報初期情報のBusiness
 *
 * @reamsid_L AF-0320-020 zhanggs
 */
public class HonninJohoResult {

    private final UaFt200FindShikibetsuTaishoEntity 宛名PSM;
    private final YubinNo 本籍郵便番号;

    /**
     * コンストラクタです。<br/>
     *
     * @param 宛名PSM UaFt200FindShikibetsuTaishoEntity
     * @param 本籍郵便番号 YubinNo
     */
    public HonninJohoResult(
            UaFt200FindShikibetsuTaishoEntity 宛名PSM,
            YubinNo 本籍郵便番号) {
        this.宛名PSM = 宛名PSM;
        this.本籍郵便番号 = 本籍郵便番号;
    }

    /**
     * 宛名PSMを返します。
     *
     * @return 宛名PSM
     */
    public UaFt200FindShikibetsuTaishoEntity get宛名PSM() {
        return 宛名PSM;
    }

    /**
     * 本籍郵便番号を返します。
     *
     * @return 本籍郵便番号
     */
    public YubinNo get本籍郵便番号() {
        return 本籍郵便番号;
    }

}
