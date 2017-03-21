/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGML1010;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ZaisankuSenkyojiTorokuEnum;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGML1010.ZaisankuSenkyojiTorokuDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 財産区議会議員選挙時登録のチェック操作を担当するクラスです。
 *
 * @reamsid_L AF-0600-010 lis
 */
public enum ZaisankuSenkyojiTorokuSpec implements IPredicate<ZaisankuSenkyojiTorokuDiv> {

    /**
     * 基準日≧登録日の時エラー
     */
    基準日登録日大小チェック {
                @Override
                public boolean apply(ZaisankuSenkyojiTorokuDiv div) {
                    RDate 基準日 = div.getZaisankuMeiboKoshinKijun().getTxtKijunYMD().getValue();
                    RDate 登録日 = div.getZaisankuMeiboKoshinKijun().getTxtMeiboTorokuYMD().getValue();

                    return !登録日.isBeforeOrEquals(基準日);
                }
            },
    /**
     * 年齢期限日 ≠ 基準日＋1日の時エラー
     */
    年齢期限日基準日大小チェック {
                @Override
                public boolean apply(ZaisankuSenkyojiTorokuDiv div) {
                    RDate 基準日 = div.getZaisankuMeiboKoshinKijun().getTxtKijunYMD().getValue();
                    RDate 年齢期限日 = div.getZaisankuMeiboKoshinKijun().getTxtNenreiTotatsuYMD().getValue();

                    return ZaisankuSenkyojiTorokuEnum.ZERO.getIntValue() == 年齢期限日.compareTo(
                            基準日.plusDay(ZaisankuSenkyojiTorokuEnum.ONE.getIntValue()));
                }
            },
    /**
     * 転出期限日＞基準日の時エラー
     */
    転出期限日基準日大小チェック {
                @Override
                public boolean apply(ZaisankuSenkyojiTorokuDiv div) {
                    RDate 基準日 = div.getZaisankuMeiboKoshinKijun().getTxtKijunYMD().getValue();
                    RDate 転出期限日 = div.getZaisankuMeiboKoshinKijun().getTxtTenshutsuYMD().getValue();

                    return !基準日.isBefore(転出期限日);
                }
            },
    /**
     * 転入期限日＞基準日の時エラー
     */
    転入期限日基準日大小チェック {
                @Override
                public boolean apply(ZaisankuSenkyojiTorokuDiv div) {
                    RDate 基準日 = div.getZaisankuMeiboKoshinKijun().getTxtKijunYMD().getValue();
                    RDate 転入期限日 = div.getZaisankuMeiboKoshinKijun().getTxtTennyuYMD().getValue();

                    return !基準日.isBefore(転入期限日);
                }
            },
    /**
     * 転出期限日＞転入期限日の時エラー
     */
    転出期限日転入期限日大小チェック {
                @Override
                public boolean apply(ZaisankuSenkyojiTorokuDiv div) {
                    RDate 転入期限日 = div.getZaisankuMeiboKoshinKijun().getTxtTennyuYMD().getValue();
                    RDate 転出期限日 = div.getZaisankuMeiboKoshinKijun().getTxtTenshutsuYMD().getValue();

                    return !転入期限日.isBefore(転出期限日);
                }
            },
    /**
     * 投票開始日＞基準日の時エラー
     */
    投票開始日基準日大小チェック {
                @Override
                public boolean apply(ZaisankuSenkyojiTorokuDiv div) {
                    RDate 基準日 = div.getZaisankuMeiboKoshinKijun().getTxtKijunYMD().getValue();
                    RDate 投票開始日 = div.getZaisankuMeiboKoshinKijun().getTxtTohyoKaishiYMD().getValue();

                    return !基準日.isBefore(投票開始日);
                }
            };
}
