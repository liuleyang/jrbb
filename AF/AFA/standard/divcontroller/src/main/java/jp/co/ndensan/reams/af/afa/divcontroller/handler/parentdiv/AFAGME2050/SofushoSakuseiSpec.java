/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME2050;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2050.SofushoSakuseiDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 施設送付書発行のチェックロジックです。
 *
 * @reamsid_L AF-0250-010 jihb
 */
public enum SofushoSakuseiSpec implements IPredicate<SofushoSakuseiDiv> {

    /**
     * 交付日開始～終了入力チェック。
     *
     */
    交付日開始と終了入力チェック_開始は未入力 {
                @Override
                public boolean apply(SofushoSakuseiDiv div) {
                    RDate 交付日From = div.getSofushoSakuseiJoken().getTxtKofuYMD().getFromValue();
                    RDate 交付日To = div.getSofushoSakuseiJoken().getTxtKofuYMD().getToValue();
                    if (交付日From == null && 交付日To != null) {
                        return Boolean.FALSE;
                    }
                    return Boolean.TRUE;
                }
            },
    /**
     * 交付日開始～終了入力チェック。
     *
     */
    交付日開始と終了入力チェック_終了は未入力 {
                @Override
                public boolean apply(SofushoSakuseiDiv div) {
                    RDate 交付日From = div.getSofushoSakuseiJoken().getTxtKofuYMD().getFromValue();
                    RDate 交付日To = div.getSofushoSakuseiJoken().getTxtKofuYMD().getToValue();
                    if (交付日From != null && 交付日To == null) {
                        return Boolean.FALSE;
                    }
                    return Boolean.TRUE;
                }
            },
    /**
     * 交付日開始～終了の大小チェック
     */
    交付日開始と終了大小チェック {
                @Override
                public boolean apply(SofushoSakuseiDiv div) {
                    RDate 交付日From = div.getSofushoSakuseiJoken().getTxtKofuYMD().getFromValue();
                    RDate 交付日To = div.getSofushoSakuseiJoken().getTxtKofuYMD().getToValue();
                    if (交付日From == null && 交付日To == null) {
                        return Boolean.TRUE;
                    } else if (交付日From != null && 交付日To != null && 交付日To.isBefore(交付日From)) {
                        return Boolean.FALSE;
                    }
                    return Boolean.TRUE;
                }
            };
}
