/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMC2020;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMC2020.SeninShikakuTorokuDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 洋上投票資格登録
 *
 * @reamsid_L AF-0210-010 liuj2
 */
public enum SeninShikakuTorokuSpec implements IPredicate<SeninShikakuTorokuDiv> {

    /**
     * 登録日必須
     */
    登録日必須 {
                @Override
                public boolean apply(SeninShikakuTorokuDiv div) {
                    int 資格区分index = div.getCcdSeninShikakuJoho().get不在者資格情報().getRadShikakuKubun().getSelectedIndex();
                    RDate 登録日 = div.getCcdSeninShikakuJoho().get不在者資格情報().getTxtShikakuTorokuYMD().getValue();
                    return !(資格区分index == 0
                    && (null == 登録日 || 登録日.toDateString().isEmpty()));
                }
            },
    /**
     * 交付日必須
     */
    交付日必須 {
                @Override
                public boolean apply(SeninShikakuTorokuDiv div) {
                    int 資格区分index = div.getCcdSeninShikakuJoho().get不在者資格情報().getRadShikakuKubun().getSelectedIndex();
                    RDate 交付日 = div.getCcdSeninShikakuJoho().get不在者資格情報().getTxtKofuYMD().getValue();
                    return !(資格区分index == 0
                    && (null == 交付日 || 交付日.toDateString().isEmpty()));
                }
            },
    /**
     * 満了日必須
     */
    有効期限日必須 {
                @Override
                public boolean apply(SeninShikakuTorokuDiv div) {
                    int 資格区分index = div.getCcdSeninShikakuJoho().get不在者資格情報().getRadShikakuKubun().getSelectedIndex();
                    RDate 有効期限日 = div.getCcdSeninShikakuJoho().get不在者資格情報().getTxtManryoYMD().getValue();
                    return !(資格区分index == 0
                    && (null == 有効期限日 || 有効期限日.toDateString().isEmpty()));
                }
            },
    /**
     * 抹消日必須
     */
    抹消日必須 {
                @Override
                public boolean apply(SeninShikakuTorokuDiv div) {
                    int 資格区分index = div.getCcdSeninShikakuJoho().get不在者資格情報().getRadShikakuKubun().getSelectedIndex();
                    RDate 抹消日 = div.getCcdSeninShikakuJoho().get不在者資格情報().getTxtMasshoYMD().getValue();
                    return !(資格区分index == 1
                    && (null == 抹消日 || 抹消日.toDateString().isEmpty()));
                }
            },
    /**
     * 事由を選択です
     */
    事由を選択です {
                @Override
                public boolean apply(SeninShikakuTorokuDiv div) {
                    int 資格区分index = div.getCcdSeninShikakuJoho().get不在者資格情報().getRadShikakuKubun().getSelectedIndex();
                    boolean 事由Code = div.getCcdSeninShikakuJoho().get不在者資格情報().getCcdMasshoJiyu().getSelectJiyuCode().isNullOrEmpty();
                    return !(資格区分index == 1 && 事由Code);
                }
            };
}
