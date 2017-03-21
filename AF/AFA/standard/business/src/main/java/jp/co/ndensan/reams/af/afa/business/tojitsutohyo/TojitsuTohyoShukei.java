/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.business.tojitsutohyo;

import java.io.Serializable;
import jp.co.ndensan.reams.af.afa.entity.db.relate.tojitsutohyo.TojitsuTohyoShukeiEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;

/**
 * 当日投票情報の集計データクラスです。
 *
 * @reamsid_L AF-0260-010 liuj
 */
public class TojitsuTohyoShukei implements Serializable {

    private final TojitsuTohyoShukeiEntity tojitsuTohyoShukeiEntity;

    /**
     * コンストラクタです。
     *
     * @param tojitsuTohyoShukeiEntity コンストラクタです。
     */
    public TojitsuTohyoShukei(TojitsuTohyoShukeiEntity tojitsuTohyoShukeiEntity) {
        this.tojitsuTohyoShukeiEntity = tojitsuTohyoShukeiEntity;

    }

    /**
     * 投票開始時間のgetメソッドです。
     *
     * @return 投票開始時間
     */
    public RTime get投票開始時間() {
        return tojitsuTohyoShukeiEntity.getTohyoStartTime();
    }

    /**
     * 投票終了時間のgetメソッドです。
     *
     * @return 投票終了時間
     */
    public RTime get投票終了時間() {
        return tojitsuTohyoShukeiEntity.getTohyoStopTime();
    }

    /**
     * 投票終了時間のgetメソッドです。
     *
     * @return 投票終了時間
     */
    public RString get投票区コード() {
        return tojitsuTohyoShukeiEntity.getTohyokuCode();
    }

    /**
     * 当日投票数女のgetメソッドです。
     *
     * @return 当日投票数女
     */
    public int getHonjitsuTohyoSuFemale() {
        return tojitsuTohyoShukeiEntity.getHonjitsuTohyoSuFemale();
    }

    /**
     * 当日投票数男のgetメソッドです。
     *
     * @return 当日投票数男
     */
    public int getHonjitsuTohyoSuMale() {
        return tojitsuTohyoShukeiEntity.getHonjitsuTohyoSuMale();
    }

    /**
     * 宛名PSMを返します。
     *
     * @return 宛名PSM
     */
    public UaFt200FindShikibetsuTaishoEntity get宛名PSM() {
        return tojitsuTohyoShukeiEntity.getShikibetsuTaisho();
    }
}
