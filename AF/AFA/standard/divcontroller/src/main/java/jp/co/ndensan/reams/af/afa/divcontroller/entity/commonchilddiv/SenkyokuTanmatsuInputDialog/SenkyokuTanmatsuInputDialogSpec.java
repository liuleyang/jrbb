/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SenkyokuTanmatsuInputDialog;

import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;

/**
 * SenkyokuTanmatsuInputDialogDiv のチェックロジックです。
 *
 * @reamsid_L AF-0720-020 liuyj
 */
public enum SenkyokuTanmatsuInputDialogSpec implements IPredicate<SenkyokuTanmatsuInputDialogDiv> {

    二重登録チェック {
                @Override
                public boolean apply(SenkyokuTanmatsuInputDialogDiv div) {
                    return false;
                }
            },
    /**
     * 他ユーザ使用チェック。
     */
    他ユーザ使用チェック {
                @Override
                public boolean apply(SenkyokuTanmatsuInputDialogDiv div) {
                    return false;
                }
            },
    /**
     * 空白行の確認チェック。
     */
    空白行の確認チェック {
                @Override
                public boolean apply(SenkyokuTanmatsuInputDialogDiv div) {
                    return false;
                }
            };
}
