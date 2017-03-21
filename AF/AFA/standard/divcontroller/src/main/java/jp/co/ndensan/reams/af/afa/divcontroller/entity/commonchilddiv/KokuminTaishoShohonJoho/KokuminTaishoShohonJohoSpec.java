/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminTaishoShohonJoho;

import jp.co.ndensan.reams.af.afa.definition.core.ShoriShubetsu;
import jp.co.ndensan.reams.af.afa.service.core.senkyojitoroku.SenkyojiTourokuValidationService;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 国民投票抄本情報共有子DIVのSpecクラスです。
 *
 * @reamsid_L AF-0360-010 fulc
 */
public enum KokuminTaishoShohonJohoSpec implements IPredicate<KokuminTaishoShohonJohoDiv> {

    /**
     * 抄本の入場券発行済チェック
     */
    対象の抄本の入場券が発行済の場合 {
                @Override
                public boolean apply(KokuminTaishoShohonJohoDiv div) {
                    return KokuminTaishoShohonJohoSpec.SpeckHelper.対象の抄本の入場券が発行済の場合(div);
                }
            },
    /**
     * 基準日と投票日の関係性チェック
     */
    基準日と投票日の大小関係が不正 {
                @Override
                public boolean apply(KokuminTaishoShohonJohoDiv div) {
                    return KokuminTaishoShohonJohoSpec.SpeckHelper.基準日と投票日の大小関係が不正(div);
                }
            },
    /**
     * 基準日と受付開始日の関係性チェック
     */
    基準日と受付開始日の大小関係が不正 {
                @Override
                public boolean apply(KokuminTaishoShohonJohoDiv div) {
                    return KokuminTaishoShohonJohoSpec.SpeckHelper.基準日と受付開始日の大小関係が不正(div);
                }
            },
    /**
     * 受付開始日と投票日の関係性チェック
     */
    受付開始日と投票日の大小関係が不正 {
                @Override
                public boolean apply(KokuminTaishoShohonJohoDiv div) {
                    return KokuminTaishoShohonJohoSpec.SpeckHelper.受付開始日と投票日の大小関係が不正(div);
                }
            },
    /**
     * 基準日と特定期限日間の妥当性チェック
     */
    基準日と特定期限日間の大小関係が不正 {
                @Override
                public boolean apply(KokuminTaishoShohonJohoDiv div) {
                    return KokuminTaishoShohonJohoSpec.SpeckHelper.基準日と特定期限日間の大小関係が不正(div);
                }
            },
    /**
     * 同一投票日存在性チェック
     */
    同一投票日で既に抄本が存在しています {
                @Override
                public boolean apply(KokuminTaishoShohonJohoDiv div) {
                    return KokuminTaishoShohonJohoSpec.SpeckHelper.同一投票日で既に抄本が存在しています(div);
                }
            };

    private static class SpeckHelper {

        static boolean 対象の抄本の入場券が発行済の場合(KokuminTaishoShohonJohoDiv div) {
            if (ShoriShubetsu.再処理.getShoriShubetsu().equals(div.getShoriMode())) {
                RString 抄本番号 = div.getCcdShohonNameList().getSelectedShohonNo();
                return SenkyojiTourokuValidationService.createInstance().validate入場券発行済(抄本番号);
            }
            return true;
        }

        static boolean 基準日と投票日の大小関係が不正(KokuminTaishoShohonJohoDiv div) {
            RDate 基準日 = div.getTxtKijunYMD().getValue();
            RDate 投票日 = div.getTxtTohyoYMD().getValue();
            return (基準日 == null || 投票日 == null || 基準日.isBefore(投票日));
        }

        static boolean 基準日と受付開始日の大小関係が不正(KokuminTaishoShohonJohoDiv div) {
            RDate 基準日 = div.getTxtKijunYMD().getValue();
            RDate 受付開始日 = div.getTxtTohyoUketsukeYMD().getValue();
            return (基準日 == null || 受付開始日 == null || 基準日.isBefore(受付開始日));
        }

        static boolean 受付開始日と投票日の大小関係が不正(KokuminTaishoShohonJohoDiv div) {
            RDate 投票日 = div.getTxtTohyoYMD().getValue();
            RDate 受付開始日 = div.getTxtTohyoUketsukeYMD().getValue();
            return (投票日 == null || 受付開始日 == null || 受付開始日.isBefore(投票日));
        }

        static boolean 基準日と特定期限日間の大小関係が不正(KokuminTaishoShohonJohoDiv div) {
            RDate 基準日 = div.getTxtKijunYMD().getValue();
            RDate 特定期限日間 = div.getTxtTokuteiKigenYMD().getValue();
            return (基準日 == null || 特定期限日間 == null || 基準日.isBefore(特定期限日間));
        }

        static boolean 同一投票日で既に抄本が存在しています(KokuminTaishoShohonJohoDiv div) {
            RString 投票日 = div.getTxtTohyoYMD().getText();
            return SenkyojiTourokuValidationService.createInstance().validate同じ抄本(投票日);
        }
    }
}
