/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuCodeSelectRange;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * TohyokuCodeSelectRangeDivのチェックロジックです。
 *
 * @reamsid_L AF-0280-010 lit
 */
public enum TohyokuCodeSelectRangeSpec implements IPredicate<TohyokuCodeSelectRangeDiv> {

    /**
     * 投票区コード開始と終了の大小関係チェック。
     */
    投票区コード開始と終了の大小関係チェック {
                @Override
                public boolean apply(TohyokuCodeSelectRangeDiv div) {
                    return SpecHelper.is投票区コード範囲(div);
                }
            },
    /**
     * 投票区コード開始の入力関係チェック
     */
    投票区コード開始の入力関係チェック {
                @Override
                public boolean apply(TohyokuCodeSelectRangeDiv div) {
                    return SpecHelper.is投票区コード開始入力(div);
                }
            },
    /**
     * 投票区コード終了の入力関係チェック
     */
    投票区コード終了の入力関係チェック {
                @Override
                public boolean apply(TohyokuCodeSelectRangeDiv div) {
                    return SpecHelper.is投票区コード終了入力(div);
                }
            };

    private static class SpecHelper {

        public static boolean is投票区コード範囲(TohyokuCodeSelectRangeDiv div) {
            return !(!div.get投票区コードFROM().isEmpty() && !div.get投票区コードTO().isEmpty()
                    && div.get投票区コードTO().compareTo(div.get投票区コードFROM()) < 0);
        }

        public static boolean is投票区コード開始入力(TohyokuCodeSelectRangeDiv div) {
            return !(div.get投票区コードFROM().isEmpty() && !div.get投票区コードTO().isEmpty());
        }

        public static boolean is投票区コード終了入力(TohyokuCodeSelectRangeDiv div) {
            return !(!div.get投票区コードFROM().isEmpty() && div.get投票区コードTO().isEmpty());
        }
    }
}
