/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMC2010;

import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMC2010.YubinShikakuTorokuDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 郵便等投票資格登録
 *
 * @reamsid_L AF-0200-010 liuj2
 */
public enum YubinShikakuTorokuSpec implements IPredicate<YubinShikakuTorokuDiv> {

    /**
     * 資格条件を選択しない
     */
    資格条件を選択です {
                @Override
                public boolean apply(YubinShikakuTorokuDiv div) {
                    return !div.getCcdYubinShikakuJoho().get郵便等投票資格情報().getChkShikakuJoken().getSelectedItems().isEmpty();
                }
            },
    /**
     * 登録日必須
     */
    登録日必須 {
                @Override
                public boolean apply(YubinShikakuTorokuDiv div) {
                    int 資格区分index = div.getCcdYubinShikakuJoho().get郵便等投票資格情報().getRadShikakuKubun().getSelectedIndex();
                    RDate 登録日 = div.getCcdYubinShikakuJoho().get郵便等投票資格情報().getTxtShikakuTorokuYMD().getValue();
                    return !(資格区分index == 0
                    && (null == 登録日 || 登録日.toDateString().isEmpty()));
                }
            },
    /**
     * 交付日必須
     */
    交付日必須 {
                @Override
                public boolean apply(YubinShikakuTorokuDiv div) {
                    int 資格区分index = div.getCcdYubinShikakuJoho().get郵便等投票資格情報().getRadShikakuKubun().getSelectedIndex();
                    RDate 交付日 = div.getCcdYubinShikakuJoho().get郵便等投票資格情報().getTxtKofuYMD().getValue();
                    return !(資格区分index == 0
                    && (null == 交付日 || 交付日.toDateString().isEmpty()));
                }
            },
    /**
     * 満了日必須
     */
    満了日必須 {
                @Override
                public boolean apply(YubinShikakuTorokuDiv div) {
                    int 資格区分index = div.getCcdYubinShikakuJoho().get郵便等投票資格情報().getRadShikakuKubun().getSelectedIndex();
                    RDate 満了日 = div.getCcdYubinShikakuJoho().get郵便等投票資格情報().getTxtManryoYMD().getValue();
                    return !(資格区分index == 0
                    && (null == 満了日 || 満了日.toDateString().isEmpty()));
                }
            },
    /**
     * 抹消日必須
     */
    抹消日必須 {
                @Override
                public boolean apply(YubinShikakuTorokuDiv div) {
                    int 資格区分index = div.getCcdYubinShikakuJoho().get郵便等投票資格情報().getRadShikakuKubun().getSelectedIndex();
                    RDate 抹消日 = div.getCcdYubinShikakuJoho().get郵便等投票資格情報().getTxtMasshoYMD().getValue();
                    return !(資格区分index == 1
                    && (null == 抹消日 || 抹消日.toDateString().isEmpty()));
                }
            },
    /**
     * 事由を選択です
     */
    事由を選択です {
                @Override
                public boolean apply(YubinShikakuTorokuDiv div) {
                    int 資格区分index = div.getCcdYubinShikakuJoho().get郵便等投票資格情報().getRadShikakuKubun().getSelectedIndex();
                    boolean 事由Code = div.getCcdYubinShikakuJoho().get郵便等投票資格情報().getCcdMasshoJiyu().getSelectJiyuCode().isNullOrEmpty();
                    return !(資格区分index == 1 && 事由Code);
                }
            },
    /**
     * 登録日が未入力
     */
    登録日未入力 {
                @Override
                public boolean apply(YubinShikakuTorokuDiv div
                ) {
                    boolean チェック結果 = true;
                    RDate 登録日 = div.getCcdYubinShikakuJoho().get郵便等投票資格情報().getTxtShikakuTorokuYMD().getValue();
                    if (null == 登録日 || 登録日.toDateString().isEmpty()) {
                        チェック結果 = false;
                    }
                    return チェック結果;
                }
            };

}
