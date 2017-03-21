/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.entity.db.relate.tojitsutohyo;

import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 当日投票情報の集計entityクラスです。
 *
 * @reamsid_L AF-0260-010 liuj
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class TojitsuTohyoShukeiEntity {

    private UaFt200FindShikibetsuTaishoEntity shikibetsuTaisho;
    private int honjitsuTohyoSuMale;
    private int honjitsuTohyoSuFemale;
    private RTime tohyoStartTime;
    private RTime tohyoStopTime;
    private RString tohyokuCode;

    /**
     * コンストラクタです。
     */
    public TojitsuTohyoShukeiEntity() {
    }

}
