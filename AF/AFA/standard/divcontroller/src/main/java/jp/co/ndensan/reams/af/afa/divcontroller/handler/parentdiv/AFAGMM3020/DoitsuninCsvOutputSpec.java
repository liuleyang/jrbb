/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM3020;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM3020.DoitsuninCsvOutputDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 *
 * 同一人物調査のSpecです。
 *
 * @reamsid_L AF-0690-010 wanghj
 */
public enum DoitsuninCsvOutputSpec implements IPredicate<DoitsuninCsvOutputDiv> {

    /**
     * グリッドの選択をチェックします。
     */
    判断条件の選択チェック {
                @Override
                public boolean apply(DoitsuninCsvOutputDiv div) {
                    return div.getChkBanchiCode().isAllSelected()
                    || div.getChkJusho().isAllSelected()
                    || div.getChkJushoCode().isAllSelected()
                    || div.getChkSeibetsu().isAllSelected()
                    || div.getChkSeinengappi().isAllSelected()
                    || div.getChkShimei().isAllSelected();
                }
            };
}
