/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM2050;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2050.ShisetsuMaintenanceDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 不在者投票管理施設保守Spec
 *
 * @reamsid_L AF-0730-010 liuj
 */
public enum ShisetsuMaintenanceSpec implements IPredicate<ShisetsuMaintenanceDiv> {

    /**
     * コード重複チェック
     */
    コード重複チェック {
                @Override
                public boolean apply(ShisetsuMaintenanceDiv div) {
                    return false;
                }
            };
}
