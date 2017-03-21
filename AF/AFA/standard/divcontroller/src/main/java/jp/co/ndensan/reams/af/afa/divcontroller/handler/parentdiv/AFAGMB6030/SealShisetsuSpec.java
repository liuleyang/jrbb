/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB6030;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME6030.SealShisetsuDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 開始印字位置未入力のチェック
 *
 * @reamsid_L AF-0620-010 xul
 */
public enum SealShisetsuSpec implements IPredicate<SealShisetsuDiv> {

    /**
     * 開始印字位置未入力をチェックします。
     */
    開始印字位置未入力 {
                @Override
                public boolean apply(SealShisetsuDiv div) {
                    if (div.getCcdSealPosition().getFocusPositionID().isEmpty()) {
                        return false;
                    }
                    return true;
                }
            };

}
