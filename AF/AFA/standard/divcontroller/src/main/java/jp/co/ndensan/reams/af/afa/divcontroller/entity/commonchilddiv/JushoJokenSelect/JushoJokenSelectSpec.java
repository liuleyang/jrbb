/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.JushoJokenSelect;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住所条件選択
 *
 * @reamsid_L AF-0450-011 jihb
 */
public enum JushoJokenSelectSpec implements IPredicate<JushoJokenSelectDiv> {

    /**
     * グリッド未選択
     */
    グリッド未選択 {
                @Override
                public boolean apply(JushoJokenSelectDiv div
                ) {
                    boolean チェック結果 = true;
                    if (!RString.isNullOrEmpty(div.getRadioButtonName())) {
                        チェック結果 = false;
                    }
                    return チェック結果;
                }
            };

}
