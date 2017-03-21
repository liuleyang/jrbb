/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM2040;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2040.TohyoRelateMaintenanceDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 投票区投票所対応保守
 *
 * @reamsid_L AF-0740-010 lis2
 */
public enum TohyoRelateMaintenanceSpec implements IPredicate<TohyoRelateMaintenanceDiv> {

    /**
     * 投票所必須チェック
     */
    投票所必須チェック {
                @Override
                public boolean apply(TohyoRelateMaintenanceDiv div) {
                    return false;
                }
            },
    /**
     * 他ユーザ使用チェック
     */
    他ユーザ使用チェック {
                @Override
                public boolean apply(TohyoRelateMaintenanceDiv div) {
                    return false;
                }
            };
}
