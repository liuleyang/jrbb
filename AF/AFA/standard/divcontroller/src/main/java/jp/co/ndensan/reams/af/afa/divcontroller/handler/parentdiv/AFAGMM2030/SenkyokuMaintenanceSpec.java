/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM2030;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2030.SenkyokuMaintenanceDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 選挙区
 *
 * @reamsid_L AF-0720-010 liuyj
 */
public enum SenkyokuMaintenanceSpec implements IPredicate<SenkyokuMaintenanceDiv> {

    /**
     * コード重複チェック
     */
    コード重複チェック {
                @Override
                public boolean apply(SenkyokuMaintenanceDiv div) {
                    return false;
                }
            },
    /**
     * 他ユーザ使用チェック
     */
    他ユーザ使用チェック {
                @Override
                public boolean apply(SenkyokuMaintenanceDiv div) {
                    return false;
                }
            };

}
