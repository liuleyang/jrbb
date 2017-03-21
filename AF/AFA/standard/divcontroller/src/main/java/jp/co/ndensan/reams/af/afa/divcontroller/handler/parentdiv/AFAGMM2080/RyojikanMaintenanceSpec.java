/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM2080;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2080.RyojikanMaintenanceDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 領事官
 *
 * @reamsid_L AF-0770-010 lis2
 */
public enum RyojikanMaintenanceSpec implements IPredicate<RyojikanMaintenanceDiv> {

    /**
     * コード重複チェック
     */
    コード重複チェック {
                @Override
                public boolean apply(RyojikanMaintenanceDiv div) {
                    return false;
                }
            };
}
