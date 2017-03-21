/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyoJokyoNyuryoku;

import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.TohyoJokyo;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyoJiyuCode.ITohyoJiyuCodeDiv;
import jp.co.ndensan.reams.af.afa.service.core.shohon.shohon.ShohonManager;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * TohyoJokyoNyuryokuDiv のチェック操作を担当するクラスです。
 *
 * @reamsid_L AF-0070-014 liss
 *
 */
public enum TohyoJokyoNyuryokuSpec implements IPredicate<TohyoJokyoNyuryokuDiv> {

    /**
     * グリッドが選択されていることかをチェックします。
     */
    グリッドが選択されていること {
                @Override
                public boolean apply(TohyoJokyoNyuryokuDiv div) {
                    return SpecHelper.isグリッドが選択(div);
                }
            },
    /**
     * 投票事由コードが存在されていることかをチェックします。
     */
    投票事由コードが存在されていること {
                @Override
                public boolean apply(TohyoJokyoNyuryokuDiv div) {
                    return SpecHelper.is投票事由コード存在(div);
                }
            },
    /**
     * 投票日付が正確に入力されていることかをチェックします。
     */
    投票日付が正確 {
                @Override
                public boolean apply(TohyoJokyoNyuryokuDiv div) {
                    return SpecHelper.is投票日付が正確(div);
                }
            },
    /**
     * 拒否事由が入力されていることかをチェックします。
     */
    拒否事由が入力されていること {
                @Override
                public boolean apply(TohyoJokyoNyuryokuDiv div) {
                    return SpecHelper.is拒否事由が入力(div);
                }
            };

    private static class SpecHelper {

        public static boolean isグリッドが選択(TohyoJokyoNyuryokuDiv div) {
            return !div.getDgTohyoJokyo().getSelectedItems().isEmpty();
        }

        public static boolean is投票事由コード存在(TohyoJokyoNyuryokuDiv div) {
            ITohyoJiyuCodeDiv tohyoJiyuCodeDiv = div.getCcdTohyoJiyu();
            return tohyoJiyuCodeDiv.checkTohyoJiyuCode();
        }

        public static boolean is投票日付が正確(TohyoJokyoNyuryokuDiv div) {
            RString R投票日 = div.getTxtTohyoYMD().getText();
            if (!RString.isNullOrEmpty(R投票日)) {
                RString R投票日DateString = div.getTxtTohyoYMD().getValue().toDateString();
                FlexibleDate 投票日 = new FlexibleDate(R投票日DateString);
                FlexibleDate 投票受付開始日 = null;
                FlexibleDate 投票年月日 = ShohonManager.createInstance().get抄本(new ShohonNo(div.getTxtHdnShohonNo())).get投票年月日();
                for (dgTohyoJokyo_Row row : div.getDgTohyoJokyo().getSelectedItems()) {
                    RString uketsukeYMD = row.getTxtTohyoUketsukeYMD().getText();
                    if (!RString.isNullOrEmpty(uketsukeYMD) && (投票受付開始日 == null || !投票受付開始日.isBefore(row.getTxtTohyoUketsukeYMD().getValue()))) {
                        投票受付開始日 = row.getTxtTohyoUketsukeYMD().getValue();
                    }
                }

                return (投票受付開始日 == null || 投票受付開始日.isBeforeOrEquals(投票日)) && 投票日.isBefore(投票年月日);
            }
            return true;
        }

        public static boolean is拒否事由が入力(TohyoJokyoNyuryokuDiv div) {
            RString 拒否事由定型文 = div.getCcdKyohiJiyuNyuryoku().get拒否事由定型文();
            return !TohyoJokyo.受付拒否.getCode().equals(div.getTohyoJokyoSelect().getRadTohyoJokyo().getSelectedKey())
                    || !RString.isNullOrEmpty(拒否事由定型文);
        }
    }
}
