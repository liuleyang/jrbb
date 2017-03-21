/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.meibosaishinkakokumin;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT112SenkyoninMeiboEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT113SenkyoShikakuEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 *
 * 投票人名簿最新化
 *
 * @reamsid_L AF-0390-030 jihb
 */
public class MeiboSaishinkaKokuminEntity {

    private UaFt200FindShikibetsuTaishoEntity 宛名PSM情報;
    private AfT112SenkyoninMeiboEntity 選挙人名簿情報;
    private AfT113SenkyoShikakuEntity 選挙資格情報;

    /**
     * 宛名PSM情報を返します。
     *
     * @return 宛名PSM情報
     */
    public UaFt200FindShikibetsuTaishoEntity get宛名PSM情報() {
        return 宛名PSM情報;
    }

    /**
     * 選挙人名簿情報を返します。
     *
     * @return 選挙人名簿情報
     */
    public AfT112SenkyoninMeiboEntity get選挙人名簿情報() {
        return 選挙人名簿情報;
    }

    /**
     * 選挙資格情報を返します。
     *
     * @return 選挙資格情報
     */
    public AfT113SenkyoShikakuEntity get選挙資格情報() {
        return 選挙資格情報;
    }

    /**
     * 宛名PSM情報を設定します。
     *
     * @param 宛名PSM情報 UaFt200FindShikibetsuTaishoEntity
     */
    public void set宛名PSM情報(UaFt200FindShikibetsuTaishoEntity 宛名PSM情報) {
        this.宛名PSM情報 = 宛名PSM情報;
    }

    /**
     * 選挙人名簿情報を設定します。
     *
     * @param 選挙人名簿情報 AfT112SenkyoninMeiboEntity
     */
    public void set選挙人名簿情報(AfT112SenkyoninMeiboEntity 選挙人名簿情報) {
        this.選挙人名簿情報 = 選挙人名簿情報;
    }

    /**
     * 選挙資格情報を設定します。
     *
     * @param 選挙資格情報 AfT113SenkyoShikakuEntity
     */
    public void set選挙資格情報(AfT113SenkyoShikakuEntity 選挙資格情報) {
        this.選挙資格情報 = 選挙資格情報;
    }

}
