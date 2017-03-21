/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMG1050;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ViewStateKeys;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMG1050.KokuminNewMeiboSaishinkaDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 投票人名簿最新化のクラス
 *
 * @reamsid_L AF-0390-010 jihb
 */
public enum KokuminNewMeiboSaishinkaSpec implements IPredicate<KokuminNewMeiboSaishinkaDiv> {

    /**
     * 抄本選択チェックをチェックします。
     */
    抄本選択チェック {
                @Override
                public boolean apply(KokuminNewMeiboSaishinkaDiv div) {
                    return null != div.getKokuminNewShohonSelect().getCcdKokuminShohonSelect().getDgKokuminShohon().getClickedItem();
                }
            },
    /**
     * 投票状況存在チェックをチェックします。
     */
    投票状況存在チェック {
                @Override
                public boolean apply(KokuminNewMeiboSaishinkaDiv div) {
                    return !ViewStateHolder.get(ViewStateKeys.is投票状況存在, boolean.class);
                }

            };
}
