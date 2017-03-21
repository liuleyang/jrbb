/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME6010;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME6010.SealSenkyoninDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.AtenaSealPositionGuide.AtenaSealPositionGuideDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * AFAGME6010 選挙人宛名シール
 *
 * @reamsid_L AF-0620-012 liuj
 */
public enum SealSenkyoninSpec implements IPredicate<SealSenkyoninDiv> {

    /**
     * 開始印字位置チェック
     */
    開始印字位置チェック {
                @Override
                public boolean apply(SealSenkyoninDiv div) {
                    boolean チェック結果 = true;
                    if (((AtenaSealPositionGuideDiv) div.getCcdSealPosition()).getTxtPosition().getValue().isEmpty()) {
                        チェック結果 = false;
                    }
                    return チェック結果;
                }
            };
}
