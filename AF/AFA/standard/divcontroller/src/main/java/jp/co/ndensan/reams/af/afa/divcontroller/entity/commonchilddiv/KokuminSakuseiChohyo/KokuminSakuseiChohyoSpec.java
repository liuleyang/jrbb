/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminSakuseiChohyo;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 【共有子Div】KokuminSakuseiChohyoDivに対応するSpecクラスです
 *
 * @reamsid_L AF-0360-012 liwul
 */
public enum KokuminSakuseiChohyoSpec implements IPredicate<KokuminSakuseiChohyoDiv> {

    /**
     * 時点日必須入力チェック
     */
    時点日必須入力チェック {
                @Override
                public boolean apply(KokuminSakuseiChohyoDiv div) {
                    return SpecHelper.時点日必須入力チェック(div);
                }
            };

    private static class SpecHelper {

        static boolean 時点日必須入力チェック(KokuminSakuseiChohyoDiv div) {
            RDate ymd = div.getKokuminSakuseiChohyoTorokushasuList().getTxtTorokushasuListKijunYmd().getValue();
            return !div.getKokuminSakuseiChohyoTorokushasuList().isIsPublish() || ymd != null;
        }
    }
}
