/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.BarCodeNyuryoku;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 【共有子Div】BarCodeNyuryokuDivに対するSpecクラスです。
 *
 * @reamsid_L AF-0080-020 qiuxy
 */
public enum BarCodeNyuryokuSpec implements IPredicate<BarCodeNyuryokuDiv> {

    /**
     * is１９桁チェック
     */
    is１９桁チェック {
                @Override
                public boolean apply(BarCodeNyuryokuDiv div) {
                    return SpecHelper.is19桁(div);
                }
            },
    /**
     * is２０桁チェック
     */
    is２０桁チェック {
                @Override
                public boolean apply(BarCodeNyuryokuDiv div) {
                    return SpecHelper.is20桁(div);
                }
            };

    private static class SpecHelper {

        static int 桁数_19 = 19;
        static int 桁数_20 = 20;

        static boolean is19桁(BarCodeNyuryokuDiv div) {
            return div.getTxtBarCode().getMaxLength() != 桁数_19 || RString.isNullOrEmpty(div.getBarCode()) || div.getBarCode().length() >= 桁数_19;
        }

        static boolean is20桁(BarCodeNyuryokuDiv div) {
            return div.getTxtBarCode().getMaxLength() != 桁数_20 || RString.isNullOrEmpty(div.getBarCode()) || div.getBarCode().length() >= 桁数_20;
        }
    }
}
