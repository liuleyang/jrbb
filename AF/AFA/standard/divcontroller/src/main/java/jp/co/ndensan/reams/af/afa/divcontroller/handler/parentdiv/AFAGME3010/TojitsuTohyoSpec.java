/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME3010;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME3010.TojitsuTohyoJokyoDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * 当日投票。
 *
 * @reamsid_L AF-0260-010 liuyj
 */
public enum TojitsuTohyoSpec implements IPredicate<TojitsuTohyoJokyoDiv> {

    /**
     * グリッドの選択をチェックします。
     */
    集計時間必須入力 {
                @Override
                public boolean apply(TojitsuTohyoJokyoDiv div) {
                    if (div.getRadShukeiTani().getSelectedKey().equals(new RString("4"))) {
                        return div.getTxtTime().getText() != null
                        && !div.getTxtTime().getText().equals(RString.EMPTY)
                        && !new Decimal(div.getTxtTime().getValue().getHour())
                        .multiply(集計単位_60分).add(div.getTxtTime().getValue().getMinute()).equals(Decimal.ZERO);
                    }
                    return true;
                }
            };
    private static final int 集計単位_60分 = 60;
}
