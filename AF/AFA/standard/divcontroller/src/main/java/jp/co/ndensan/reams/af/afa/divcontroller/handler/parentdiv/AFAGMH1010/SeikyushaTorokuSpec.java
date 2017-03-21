/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMH1010;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMH1010.SeikyushaTorokuDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 請求代表者証明書交付のチェック操作を担当するクラスです。
 *
 * @reamsid_L AF-0140-010 wangh
 */
public enum SeikyushaTorokuSpec implements IPredicate<SeikyushaTorokuDiv> {

    /**
     * 請求日と交付日の大小チェック。
     */
    請求日交付日大小チェック {
                @Override
                public boolean apply(SeikyushaTorokuDiv div) {
                    RDate 請求日 = div.getSeikyushaTorokuNaiyoNyuryoku().getTxtSeikyuYMD().getValue();
                    RDate 交付日 = div.getSeikyushaTorokuNaiyoNyuryoku().getTxtKofuYMD().getValue();
                    return !(交付日.isBefore(請求日));
                }
            },
    /**
     * 交付日と提出期限日の大小チェック。
     */
    交付日提出期限日大小チェック {
                @Override
                public boolean apply(SeikyushaTorokuDiv div) {
                    RDate 提出期限日 = div.getSeikyushaTorokuNaiyoNyuryoku().getTxtTeishutsuKigenYMD().getValue();
                    RDate 交付日 = div.getSeikyushaTorokuNaiyoNyuryoku().getTxtKofuYMD().getValue();
                    return !(提出期限日.isBefore(交付日));
                }
            },
    /**
     * 請求代表者一覧が0件だった場合、エラーとする。
     */
    請求代表者選択チェック {
                @Override
                public boolean apply(SeikyushaTorokuDiv div) {
                    return !div.getDgSeikyushaTorokuDaihyoshaIchiran().getDataSource().isEmpty();
                }
            };
}
