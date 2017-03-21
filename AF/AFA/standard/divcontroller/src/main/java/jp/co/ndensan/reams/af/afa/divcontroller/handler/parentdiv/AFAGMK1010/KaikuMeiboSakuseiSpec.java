/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMK1010;

import jp.co.ndensan.reams.af.afa.business.MeiboSakuseiKaiku;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMK1010.KaikuMeiboSakuseiDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 *
 * @reamsid_L AF-0460-010 liuyj
 */
public enum KaikuMeiboSakuseiSpec implements IPredicate<KaikuMeiboSakuseiDiv> {

    /**
     * 名簿確定日非自動算出日付
     */
    名簿確定日非自動算出日付 {
                @Override
                public boolean apply(KaikuMeiboSakuseiDiv div
                ) {
                    boolean チェック結果 = true;
                    MeiboSakuseiKaiku meiboSakuseiKaiku = new MeiboSakuseiKaiku();
                    RDate 基準日 = div.getKaikuMeiboKoshinKijun().getTxtKijunYMD().getValue();
                    RDate 名簿確定日 = div.getKaikuMeiboKoshinKijun().getTxtKakuteiYMD().getValue();
                    if (!名簿確定日.equals(meiboSakuseiKaiku.get日付(基準日).get名簿確定日())) {
                        チェック結果 = false;
                    }
                    return チェック結果;
                }
            },
    /**
     * 年齢到達日非自動算出日付
     */
    年齢到達日非自動算出日付 {
                @Override
                public boolean apply(KaikuMeiboSakuseiDiv div
                ) {
                    boolean チェック結果 = true;
                    MeiboSakuseiKaiku meiboSakuseiKaiku = new MeiboSakuseiKaiku();
                    RDate 基準日 = div.getKaikuMeiboKoshinKijun().getTxtKijunYMD().getValue();
                    RDate 年齢到達日 = div.getKaikuMeiboKoshinKijun().getTxtNenreiTotatsuYMD().getValue();
                    if (!年齢到達日.equals(meiboSakuseiKaiku.get日付(基準日).get年齢到達日())) {
                        チェック結果 = false;
                    }
                    return チェック結果;
                }
            };
}
