/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM3010;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM3010.MasterCsvOutputDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * 住民投票時登録
 *
 * @reamsid_L AF-0450-010 jihb
 */
public enum MasterCsvOutputSpec implements IPredicate<MasterCsvOutputDiv> {

    /**
     * 出力対象マスタ未選択
     */
    出力対象マスタ未選択 {
                @Override
                public boolean apply(MasterCsvOutputDiv div
                ) {
                    boolean チェック結果 = false;
                    if (div.getChkTohyoku().isAllSelected()
                    || div.getChkTohyojo().isAllSelected()
                    || div.getChkSenkyoku().isAllSelected()
                    || div.getChkShisetsu().isAllSelected()
                    || div.getChkHojosha().isAllSelected()
                    || div.getChkKumiai().isAllSelected()
                    || div.getChkRyojikan().isAllSelected()
                    || div.getChkCode().isAllSelected()
                    || div.getChkConfig().isAllSelected()) {
                        チェック結果 = true;
                    }
                    return チェック結果;
                }
            },
    /**
     * 投票区必須
     */
    投票区必須 {
                @Override
                public boolean apply(MasterCsvOutputDiv div
                ) {
                    boolean チェック結果 = true;
                    if (div.getChkTohyoku().isAllSelected()
                    && !div.getCcdSenkyoShuruiTohyoku().isコード入力済み()) {
                        チェック結果 = false;
                    }
                    return チェック結果;
                }
            };

}
