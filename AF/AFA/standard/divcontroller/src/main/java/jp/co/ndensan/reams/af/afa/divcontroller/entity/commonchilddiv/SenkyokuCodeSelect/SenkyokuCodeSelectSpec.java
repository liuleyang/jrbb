/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SenkyokuCodeSelect;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * SenkyokuCodeSelectDiv のチェックロジックです。
 *
 * @reamsid_L AF-0720-030 zhanggs
 */
public enum SenkyokuCodeSelectSpec implements IPredicate<SenkyokuCodeSelectDiv> {

    /**
     * 選挙区コードチェック。
     */
    選挙区コード {

                @Override
                public boolean apply(SenkyokuCodeSelectDiv div) {

                    return false;
                }
            };
}
