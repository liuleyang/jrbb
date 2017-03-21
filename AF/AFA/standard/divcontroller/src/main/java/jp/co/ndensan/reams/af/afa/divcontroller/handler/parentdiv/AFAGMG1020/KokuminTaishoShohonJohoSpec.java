/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMG1020;

import java.util.List;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMG1020.KokuminTohyoJohoShuseiDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMG1020.dgKokuminShusei_Row;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 国民投票情報修正のSpecクラスです。
 *
 * @reamsid_L AF-0370-010 lis
 */
public enum KokuminTaishoShohonJohoSpec implements IPredicate<KokuminTohyoJohoShuseiDiv> {

    /**
     * 選挙追加の改正案必須チェック。
     *
     */
    選挙追加の改正案必須チェック {
                @Override
                public boolean apply(KokuminTohyoJohoShuseiDiv div) {
                    return SpecHelper.isNotEmptyKaiseianNameName(div);
                }
            },
    /**
     * 選挙追加の選挙略称必須チェック。
     *
     */
    選挙追加の選挙略称必須チェック {
                @Override
                public boolean apply(KokuminTohyoJohoShuseiDiv div) {
                    return SpecHelper.isNotEmptyRyakusho(div);
                }
            };

    private static class SpecHelper {

        public static boolean isNotEmptyKaiseianNameName(KokuminTohyoJohoShuseiDiv div) {
            List<dgKokuminShusei_Row> listRows = div.getKokuminShusei().getDgKokuminShusei().getDataSource();
            Boolean chkFlg = Boolean.TRUE;
            for (dgKokuminShusei_Row row : listRows) {
                if (RString.isNullOrEmpty(row.getTxtKaiseianName().getValue())) {
                    chkFlg = Boolean.FALSE;
                    break;
                }
            }
            return chkFlg;
        }

        public static boolean isNotEmptyRyakusho(KokuminTohyoJohoShuseiDiv div) {
            List<dgKokuminShusei_Row> listRows = div.getKokuminShusei().getDgKokuminShusei().getDataSource();
            Boolean chkFlg = Boolean.TRUE;
            for (dgKokuminShusei_Row row : listRows) {
                if (RString.isNullOrEmpty(row.getTxtRyakusho().getValue())) {
                    chkFlg = Boolean.FALSE;
                    break;
                }
            }
            return chkFlg;
        }
    }
}
