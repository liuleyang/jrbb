/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM2070;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2070.KumiaiMaintenanceDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * AFAGMM2070_組合保守
 *
 * @reamsid_L AF-0760-010 lis2
 */
public enum KumiaiMaintenanceSpec implements IPredicate<KumiaiMaintenanceDiv> {

    /**
     * コード重複チェック
     */
    コード重複チェック {
                @Override
                public boolean apply(KumiaiMaintenanceDiv div) {
                    return false;
                }
            };
}
