/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMK1040;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMK1040.KaikuNewMeiboSaishinkaDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMK1040.dgKaikuShohonSelect_Row;
import jp.co.ndensan.reams.af.afa.service.core.kaikukewkeibokaishinka.KaikuNewMeiBoSenkyoManager;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * AFAGMK1040 海区漁業調整委員会委員選挙人名簿最新化Spec <br />
 *
 * @reamsid_L AF-0480-010 liuj
 */
public enum KaikuNewMeiboSaishinkaSpec implements IPredicate<KaikuNewMeiboSaishinkaDiv> {

    /**
     * 抄本選択チェック
     */
    抄本選択チェック {
                @Override
                public boolean apply(KaikuNewMeiboSaishinkaDiv div) {
                    boolean チェック結果 = true;
                    if (div.getDgKaikuShohonSelect().getSelectedItems().isEmpty()) {
                        チェック結果 = false;
                    }
                    return チェック結果;
                }
            },
    /**
     * 投票状況存在チェック
     */
    投票状況存在チェック {

                @Override
                public boolean apply(KaikuNewMeiboSaishinkaDiv div) {
                    dgKaikuShohonSelect_Row selectRow = div.getDgKaikuShohonSelect().getClickedItem();
                    if (null != selectRow) {
                        return !KaikuNewMeiBoSenkyoManager.createInstance().get投票状況有無(selectRow.getTxtShohonNo());
                    }
                    return true;
                }
            };
}
