/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminTaishoShohonJoho;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 国民投票抄本情報共有子DIVのチェックを実行する。
 *
 * @reamsid_L AF-0360-011 lis
 */
public enum KokuminTaishoSpec implements IPredicate<KokuminTaishoShohonJohoDiv> {

    /**
     * 基準日と特定期限日間の妥当性チェック
     */
    基準日と特定期限日間の妥当性チェック {
                @Override
                public boolean apply(KokuminTaishoShohonJohoDiv div) {
                    boolean 妥当性チェック = true;
                    RDate 基準日 = div.getTxtKijunYMD().getValue();
                    RDate 特定期限日 = div.getTxtTokuteiKigenYMD().getValue();
                    if (基準日 != null && 特定期限日 != null && 特定期限日.isBeforeOrEquals(基準日)) {
                        妥当性チェック = false;
                    }
                    return 妥当性チェック;
                }
            },
    /**
     * 受付開始日と投票日の関係性チェック
     */
    受付開始日と投票日の関係性チェック {
                @Override
                public boolean apply(KokuminTaishoShohonJohoDiv div) {
                    boolean 妥当性チェック = true;
                    RDate 投票日 = div.getTxtTohyoYMD().getValue();
                    RDate 受付開始日 = div.getTxtTokuteiKigenYMD().getValue();
                    if (投票日 != null && 受付開始日 != null && 投票日.isBeforeOrEquals(受付開始日)) {
                        妥当性チェック = false;
                    }
                    return 妥当性チェック;
                }
            },
    /**
     * 基準日と受付開始日の関係性チェック
     */
    基準日と受付開始日の関係性チェック {
                @Override
                public boolean apply(KokuminTaishoShohonJohoDiv div) {
                    boolean 妥当性チェック = true;
                    RDate 基準日 = div.getTxtKijunYMD().getValue();
                    RDate 受付開始日 = div.getTxtTokuteiKigenYMD().getValue();
                    if (基準日 != null && 受付開始日 != null && 受付開始日.isBeforeOrEquals(基準日)) {
                        妥当性チェック = false;
                    }
                    return 妥当性チェック;
                }
            },
    /**
     * 基準日と投票日の関係性チェック
     */
    基準日と投票日の関係性チェック {
                @Override
                public boolean apply(KokuminTaishoShohonJohoDiv div) {
                    boolean 妥当性チェック = true;
                    RDate 基準日 = div.getTxtKijunYMD().getValue();
                    RDate 投票日 = div.getTxtTohyoYMD().getValue();
                    if (基準日 != null && 投票日 != null && 投票日.isBeforeOrEquals(基準日)) {
                        妥当性チェック = false;
                    }
                    return 妥当性チェック;
                }
            };

}
