/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM2020;

import java.util.List;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2020.TohyojoMaintenanceDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2020.dgTohyojoList_Row;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @reamsid_L AF-0710-010 liuyj
 */
public enum TohyojoMaintenanceSpec implements IPredicate<TohyojoMaintenanceDiv> {

    /**
     * コード重複チェック
     */
    コード重複チェック {
                @Override
                public boolean apply(TohyojoMaintenanceDiv div) {
                    RString tohyojoCode = div.getTohyojoInput().getTxtCode().getValue();
                    List<dgTohyojoList_Row> rowList = div.getDgTohyojoList().getDataSource();
                    if (!rowList.isEmpty()) {
                        for (dgTohyojoList_Row row : rowList) {
                            if (row.getTxtCode().equals(tohyojoCode)) {
                                return false;
                            }
                        }
                    }
                    return true;
                }
            };
}
