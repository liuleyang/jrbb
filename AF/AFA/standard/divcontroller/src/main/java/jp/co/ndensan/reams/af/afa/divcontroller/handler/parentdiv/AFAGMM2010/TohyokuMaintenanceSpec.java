/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM2010;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2010.TohyokuMaintenanceDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 投票区保守Spec
 *
 * @reamsid_L AF-0700-010 liuyj
 */
public enum TohyokuMaintenanceSpec implements IPredicate<TohyokuMaintenanceDiv> {

    /**
     * コード重複チェック
     */
    コード重複チェック {
                @Override
                public boolean apply(TohyokuMaintenanceDiv div) {
                    return false;
                }
            };
}
