/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME5050;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5050.TohyoKekkaSakuseiChohyoDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5050.TohyoKekkaShukeiSakuseiDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 投票結果集計表のチェックロジックです。
 *
 * @reamsid_L AF-0290-010 lit
 */
public enum TohyoKekkaShukeiSakuseiSpec implements IPredicate<TohyoKekkaShukeiSakuseiDiv> {

    /**
     * 作成帳票が選択されていることかをチェックします。
     */
    作成帳票が選択されていること {
                @Override
                public boolean apply(TohyoKekkaShukeiSakuseiDiv div) {
                    return SpecHelper.is作成帳票が選択(div);
                }
            };

    private static class SpecHelper {

        public static boolean is作成帳票が選択(TohyoKekkaShukeiSakuseiDiv div) {
            TohyoKekkaSakuseiChohyoDiv chohyoDiv = div.getTohyoKekkaSakuseiChohyo();
            if (chohyoDiv.getTohyoKekkaSakuseiChohyoNenreibetsu().isIsPublish()) {
                return true;
            }
            if (chohyoDiv.getTohyoKekkaSakuseiChohyoNendaibetsu().isIsPublish()) {
                return true;
            }
            return chohyoDiv.getTohyoKekkaSakuseiChohyoJikanbetsu().isIsPublish();
        }
    }
}
