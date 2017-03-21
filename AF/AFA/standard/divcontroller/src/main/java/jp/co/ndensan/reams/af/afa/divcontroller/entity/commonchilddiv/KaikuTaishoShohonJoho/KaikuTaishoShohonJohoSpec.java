/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KaikuTaishoShohonJoho;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 海区対象抄本情報共有子Divのチェック操作を担当するクラスです。
 *
 * @reamsid_L AF-0470-020 jihb
 */
public enum KaikuTaishoShohonJohoSpec implements IPredicate<KaikuTaishoShohonJohoDiv> {

    /**
     * 基準日投票日大小チェック。
     */
    基準日投票日大小チェック {
                @Override
                public boolean apply(KaikuTaishoShohonJohoDiv div) {
                    RDate 基準日 = div.getTxtKijunYMD().getValue();
                    RDate 投票日 = div.getTxtTohyoYMD().getValue();
                    return !(投票日.isBeforeOrEquals(基準日));
                }
            },
    /**
     * 基準日受付開始日大小チェック。
     */
    基準日受付開始日大小チェック {
                @Override
                public boolean apply(KaikuTaishoShohonJohoDiv div) {
                    RDate 基準日 = div.getTxtKijunYMD().getValue();
                    RDate 受付開始日 = div.getTxtTohyoUketsukeYMD().getValue();
                    return !(受付開始日.isBeforeOrEquals(基準日));
                }
            },
    /**
     * 受付開始日投票日大小チェック。
     */
    受付開始日投票日大小チェック {
                @Override
                public boolean apply(KaikuTaishoShohonJohoDiv div) {
                    RDate 投票日 = div.getTxtTohyoYMD().getValue();
                    RDate 受付開始日 = div.getTxtTohyoUketsukeYMD().getValue();
                    return !(投票日.isBeforeOrEquals(受付開始日));
                }
            };
}
