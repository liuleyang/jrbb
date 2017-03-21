/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME5010;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5010.TachiaishoSakuseiDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;

/**
 * AFAGME5010 立会人引継書のチェックロジックです。
 *
 * @reamsid_L AF-0120-010 xul
 */
public enum TachiaishoSakuseiSpec implements IPredicate<TachiaishoSakuseiDiv> {

    /**
     * 抄本データドロップダウン未入力。
     */
    抄本データドロップダウン未入力 {
                @Override
                public boolean apply(TachiaishoSakuseiDiv div) {
                    RString 抄本 = div.getCcdShohonNameList().getSelectedShohonNo();
                    return !RString.isNullOrEmpty(抄本);
                }
            },
    /**
     * 期日前投票日未入力。
     */
    期日前投票日未入力 {
                @Override
                public boolean apply(TachiaishoSakuseiDiv div) {
                    RDate 期日前投票日 = div.getTxtTohyoYMDJoken().getValue();
                    return null != 期日前投票日;
                }
            },
    /**
     * 選挙名未入力
     */
    選挙名未入力 {
                @Override
                public boolean apply(TachiaishoSakuseiDiv div) {
                    RString 選挙名 = div.getDdlSenkyoName().getSelectedKey();
                    return !RString.isNullOrEmpty(選挙名);
                }
            },
    /**
     * 期日前投票所未入力。
     */
    期日前投票所未入力 {
                @Override
                public boolean apply(TachiaishoSakuseiDiv div) {
                    RString 期日前投票所 = div.getDdlShisetsu().getSelectedKey();
                    return !RString.isNullOrEmpty(期日前投票所);
                }
            },
    /**
     * 立会人氏名。
     */
    立会人氏名 {
                @Override
                public boolean apply(TachiaishoSakuseiDiv div) {
                    RString 立会人氏名 = div.getTxtTachiaininShimei().getDomain().getColumnValue();
                    return !RString.isNullOrEmpty(立会人氏名);
                }
            },
    /**
     * 立会時間。
     */
    立会時間 {
                @Override
                public boolean apply(TachiaishoSakuseiDiv div) {
                    RTime 立会時間_FROM = div.getTxtTachiaiTimeRange().getFromValue();
                    RTime 立会時間_TO = div.getTxtTachiaiTimeRange().getToValue();
                    return null != 立会時間_FROM && null != 立会時間_TO;
                }
            };
}
