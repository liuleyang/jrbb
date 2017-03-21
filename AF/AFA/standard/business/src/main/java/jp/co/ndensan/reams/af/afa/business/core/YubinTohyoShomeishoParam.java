/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.core;

import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 郵便等投票証明書
 *
 * @reamsid_L AF-0200-030 lis2
 */
public class YubinTohyoShomeishoParam {

    private UaFt200FindShikibetsuTaishoEntity 宛名PSM;

    private RDate 交付年月日;

    private RDate 資格満了年月日;

    private Association 地方公共団体;

    /**
     * コンストラクタです。
     *
     * @param 宛名PSM UaFt200FindShikibetsuTaishoEntity
     * @param 交付年月日 RDate
     * @param 資格満了年月日 RDate
     */
    public YubinTohyoShomeishoParam(UaFt200FindShikibetsuTaishoEntity 宛名PSM, RDate 交付年月日, RDate 資格満了年月日) {
        this.宛名PSM = 宛名PSM;
        this.交付年月日 = 交付年月日;
        this.資格満了年月日 = 資格満了年月日;
    }

    /**
     * 宛名PSM
     *
     * @return 宛名PSM UaFt200FindShikibetsuTaishoEntity
     */
    public UaFt200FindShikibetsuTaishoEntity get宛名PSM() {
        return 宛名PSM;
    }

    /**
     * 交付年月日
     *
     * @return 交付年月日 RDate
     */
    public RDate get交付年月日() {
        return 交付年月日;
    }

    /**
     * 資格満了年月日
     *
     * @return 資格満了年月日 RDate
     */
    public RDate get資格満了年月日() {
        return 資格満了年月日;
    }

    /**
     * 宛名PSM
     *
     * @param 宛名PSM UaFt200FindShikibetsuTaishoEntity
     */
    public void set宛名PSM(UaFt200FindShikibetsuTaishoEntity 宛名PSM) {
        this.宛名PSM = 宛名PSM;
    }

    /**
     * 交付年月日
     *
     * @param 交付年月日 RDate
     */
    public void set交付年月日(RDate 交付年月日) {
        this.交付年月日 = 交付年月日;
    }

    /**
     * 資格満了年月日
     *
     * @param 資格満了年月日 RDate
     */
    public void set資格満了年月日(RDate 資格満了年月日) {
        this.資格満了年月日 = 資格満了年月日;
    }

    /**
     * 地方公共団体
     *
     * @return 地方公共団体 Association
     */
    public Association get地方公共団体() {
        return 地方公共団体;
    }

    /**
     * 地方公共団体
     *
     * @param 地方公共団体 Association
     */
    public void set地方公共団体(Association 地方公共団体) {
        this.地方公共団体 = 地方公共団体;
    }

}
