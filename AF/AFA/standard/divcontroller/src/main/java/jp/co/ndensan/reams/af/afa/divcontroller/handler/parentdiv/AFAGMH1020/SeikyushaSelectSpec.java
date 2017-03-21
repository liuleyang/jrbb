/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMH1020;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMH1020.SeikyushaSelectDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 請求代表者選択のチェック操作を担当するクラスです。
 *
 * @reamsid_L AF-0140-020 wangh
 */
public enum SeikyushaSelectSpec implements IPredicate<SeikyushaSelectDiv> {

    /**
     * 提出期限日 ＜ システム日付のチェック。
     */
    提出期限日チェック {
                @Override
                public boolean apply(SeikyushaSelectDiv div) {
                    RDate システム日付 = RDate.getNowDate();
                    RDate 提出期限日;
                    if (!div.getHdnTeishutsuKigenYMD().isNullOrEmpty()) {
                        提出期限日 = new RDate(div.getHdnTeishutsuKigenYMD().toString());
                        return !(提出期限日.isBefore(システム日付));
                    } else {
                        return false;
                    }
                }
            };
}
