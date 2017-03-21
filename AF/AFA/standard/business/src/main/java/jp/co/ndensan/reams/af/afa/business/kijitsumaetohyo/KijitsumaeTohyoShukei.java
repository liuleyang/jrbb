/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.kijitsumaetohyo;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.entity.xml.kijitsumaetohyo.KijitsumaeTohyoShukeiEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 期日前投票情報の集計データクラスです。
 *
 * @reamsid_L AF-0070-010 liss
 */
public class KijitsumaeTohyoShukei implements Serializable {

    private final KijitsumaeTohyoShukeiEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity コンストラクタです。
     */
    public KijitsumaeTohyoShukei(KijitsumaeTohyoShukeiEntity entity) {
        this.entity = entity;
    }

    /**
     * 施設コードのgetメソッドです。
     *
     * @return 施設コード
     */
    public RString getShisetsuCode() {
        return entity.getShisetsuCode();
    }

    /**
     * 施設名称のgetメソッドです。
     *
     * @return 施設名称
     */
    public RString getShisetsuMeisho() {
        return entity.getShisetsuMeisho();
    }

    /**
     * 当日投票数女のgetメソッドです。
     *
     * @return 当日投票数女
     */
    public int getHonjitsuTohyoSuFemale() {
        return entity.getHonjitsuTohyoSuFemale();
    }

    /**
     * 当日投票数男のgetメソッドです。
     *
     * @return 当日投票数男
     */
    public int getHonjitsuTohyoSuMale() {
        return entity.getHonjitsuTohyoSuMale();
    }

    /**
     * 累積投票数女のgetメソッドです。
     *
     * @return 累積投票数女
     */
    public int getIzenTohyoSuFemale() {
        return entity.getIzenTohyoSuFemale();
    }

    /**
     * 累積投票数男のgetメソッドです。
     *
     * @return 累積投票数男
     */
    public int getIzenTohyoSuMale() {
        return entity.getIzenTohyoSuMale();
    }
}
