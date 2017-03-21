/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.kokumintaishoshohonjoho;

import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT100ShohonEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT111SenkyoEntity;

/**
 * 国民投票抄本情報のクラスです。
 *
 * @reamsid_L AF-0360-011 lis
 */
public class KokuminTaishoEntity {

    private AfT100ShohonEntity afT100Shohon;
    private AfT111SenkyoEntity afT111Senkyo;

    /**
     * AfT100ShohonEntityを取得します。
     *
     * @return AfT100ShohonEntity
     */
    public AfT100ShohonEntity getAfT100Shohon() {
        return afT100Shohon;
    }

    /**
     * AfT111SenkyoEntityを取得します。
     *
     * @return AfT111SenkyoEntity
     */
    public AfT111SenkyoEntity getAfT111Senkyo() {
        return afT111Senkyo;
    }

    /**
     * AfT100Shohonを設定します。
     *
     * @param afT100Shohon AfT100ShohonEntity
     */
    public void setAfT100Shohon(AfT100ShohonEntity afT100Shohon) {
        this.afT100Shohon = afT100Shohon;
    }

    /**
     * AfT111Senkyoを設定します。
     *
     * @param afT111Senkyo AfT111SenkyoEntity
     */
    public void setAfT111Senkyo(AfT111SenkyoEntity afT111Senkyo) {
        this.afT111Senkyo = afT111Senkyo;
    }

}
