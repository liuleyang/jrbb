/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME6030;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME6030.SealShisetsuDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaSealPositionGuide.AtenaSealPositionGuideDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 施設宛名シールのSpecクラスです。
 *
 * @reamsid_L AF-0620-010 xul
 */
public enum SealShisetsuSpec implements IPredicate<SealShisetsuDiv> {

    /**
     * 選開始印字位置選択チェック。
     *
     */
    開始印字位置選択チェック {
                @Override
                public boolean apply(SealShisetsuDiv div) {
                    return div.getCcdSealPosition().isDisplayNone()
                    || !((AtenaSealPositionGuideDiv) div.getCcdSealPosition()).getTxtPosition().getValue().isNullOrEmpty();
                }
            };
}
