/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM2060;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2060.HojoshaMaintenanceDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * AFAGMM2060 投票補助者保守
 *
 * @reamsid_L AF-0750-010 lis2
 */
public enum HojoshaMaintenanceSpec implements IPredicate<HojoshaMaintenanceDiv> {

    /**
     * コード重複のチェック
     */
    コード重複のチェック {
                @Override
                public boolean apply(HojoshaMaintenanceDiv div) {
                    return false;
                }
            },
    /**
     * 他ユーザ使用のチェック
     */
    他ユーザ使用のチェック {
                @Override
                public boolean apply(HojoshaMaintenanceDiv div) {
                    return false;
                }
            },
    /**
     * コード存在性のチェック
     */
    コード存在性のチェック {

                @Override
                public boolean apply(HojoshaMaintenanceDiv div) {
                    return false;
                }

            };
}
