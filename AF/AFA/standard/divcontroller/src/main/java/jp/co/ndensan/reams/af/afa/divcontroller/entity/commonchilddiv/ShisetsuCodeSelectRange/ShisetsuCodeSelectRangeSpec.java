/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShisetsuCodeSelectRange;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * ShisetsuCodeSelectRangeDivのチェックロジックです。
 *
 * @reamsid_L AF-0270-012 xul
 */
public enum ShisetsuCodeSelectRangeSpec implements IPredicate<ShisetsuCodeSelectRangeDiv> {

    /**
     * 施設コード開始と終了の大小関係チェック。
     */
    施設コード開始と終了の大小関係チェック {
                @Override
                public boolean apply(ShisetsuCodeSelectRangeDiv div) {
                    return SpecHelper.is施設コード範囲(div);
                }
            },
    /**
     * 施設コード開始の入力関係チェック
     */
    施設コード開始の入力関係チェック {
                @Override
                public boolean apply(ShisetsuCodeSelectRangeDiv div) {
                    return SpecHelper.is施設コード開始入力(div);
                }
            },
    /**
     * 施設コード終了の入力関係チェック
     */
    施設コード終了の入力関係チェック {
                @Override
                public boolean apply(ShisetsuCodeSelectRangeDiv div) {
                    return SpecHelper.is施設コード終了入力(div);
                }
            };

    private static class SpecHelper {

        public static boolean is施設コード範囲(ShisetsuCodeSelectRangeDiv div) {
            return !(!div.get施設コードFROM().isEmpty() && !div.get施設コードTO().isEmpty()
                    && div.get施設コードTO().compareTo(div.get施設コードFROM()) < 0);
        }

        public static boolean is施設コード開始入力(ShisetsuCodeSelectRangeDiv div) {
            return !(div.get施設コードFROM().isEmpty() && !div.get施設コードTO().isEmpty());
        }

        public static boolean is施設コード終了入力(ShisetsuCodeSelectRangeDiv div) {
            return !(!div.get施設コードFROM().isEmpty() && div.get施設コードTO().isEmpty());
        }
    }
}
