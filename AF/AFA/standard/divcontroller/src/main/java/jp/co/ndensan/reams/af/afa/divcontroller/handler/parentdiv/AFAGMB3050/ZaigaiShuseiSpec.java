/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB3050;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.HyojiJiyuCodeZaigai;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.MasshoJiyuCodeZaigai;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.JiyuNameList.IJiyuNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB3050.ZaigaiShuseiDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * 在外選挙人名簿修正のチェック操作を担当するクラスです。
 *
 * @reamsid_L AF-0325-034 guancy
 */
public enum ZaigaiShuseiSpec implements IPredicate<ZaigaiShuseiDiv> {

    /**
     * 在外選挙人名簿情報の表示日_表示事由のチェック_表示日未入力をチェックします。
     */
    在外選挙人名簿情報の表示日_表示事由のチェック_表示日未入力 {
                @Override
                public boolean apply(ZaigaiShuseiDiv div) {

                    RString 表示事由 = div.getZaigaiShuseiShikakuJoho().getCcdZaigaiMeiboJoho().get在外名簿情報().getCcdHyojiJiyu().getSelectJiyuCode();
                    TextBoxDate 在外選挙人名簿情報の表示日 = div.getZaigaiShuseiShikakuJoho().getCcdZaigaiMeiboJoho().get在外名簿情報().getTxtHyojiYMD();
                    if (在外選挙人名簿情報の表示日.isDisabled() || 在外選挙人名簿情報の表示日.isReadOnly() || !在外選挙人名簿情報の表示日.isVisible()) {
                        return true;
                    }
                    RDate 表示日 = 在外選挙人名簿情報の表示日.getValue();
                    return !(表示日 == null && (表示事由 != null && !表示事由.isEmpty()));
                }
            },
    /**
     * 在外選挙人名簿情報の表示日_表示事由のチェック_表示事由未入力をチェックします。
     */
    在外選挙人名簿情報の表示日_表示事由のチェック_表示事由未入力 {
                @Override
                public boolean apply(ZaigaiShuseiDiv div) {

                    RString 表示事由 = div.getZaigaiShuseiShikakuJoho().getCcdZaigaiMeiboJoho().get在外名簿情報().getCcdHyojiJiyu().getSelectJiyuCode();
                    TextBoxDate 在外選挙人名簿情報の表示日 = div.getZaigaiShuseiShikakuJoho().getCcdZaigaiMeiboJoho().get在外名簿情報().getTxtHyojiYMD();
                    if (在外選挙人名簿情報の表示日.isDisabled() || 在外選挙人名簿情報の表示日.isReadOnly() || !在外選挙人名簿情報の表示日.isVisible()) {
                        return true;
                    }
                    RDate 表示日 = 在外選挙人名簿情報の表示日.getValue();
                    return !(表示日 != null && (表示事由 == null || 表示事由.isEmpty()));
                }
            },
    /**
     * 在外選挙人名簿情報の表示日関連のチェックをチェックします。
     */
    在外選挙人名簿情報の表示日関連のチェック_未来日 {
                @Override
                public boolean apply(ZaigaiShuseiDiv div) {
                    TextBoxDate 在外選挙人名簿情報の表示日 = div.getZaigaiShuseiShikakuJoho().getCcdZaigaiMeiboJoho().get在外名簿情報().getTxtHyojiYMD();
                    if (在外選挙人名簿情報の表示日.isDisabled() || 在外選挙人名簿情報の表示日.isReadOnly() || !在外選挙人名簿情報の表示日.isVisible()) {
                        return true;
                    }
                    RDate 表示日 = 在外選挙人名簿情報の表示日.getValue();
                    if (表示日 == null) {
                        return true;
                    }
                    return 表示日.isBeforeOrEquals(RDate.getNowDate());
                }
            },
    /**
     * 在外選挙人名簿情報の表示日関連のチェックをチェックします。
     */
    在外選挙人名簿情報の表示日関連のチェック_登録日以降 {
                @Override
                public boolean apply(ZaigaiShuseiDiv div) {
                    TextBoxDate 在外選挙人名簿情報の表示日 = div.getZaigaiShuseiShikakuJoho().getCcdZaigaiMeiboJoho().get在外名簿情報().getTxtHyojiYMD();
                    if (在外選挙人名簿情報の表示日.isDisabled() || 在外選挙人名簿情報の表示日.isReadOnly() || !在外選挙人名簿情報の表示日.isVisible()) {
                        return true;
                    }
                    RDate 表示日 = 在外選挙人名簿情報の表示日.getValue();
                    TextBoxDate 在外選挙人名簿情報の表示日関連のチェック_登録日 = div.getZaigaiShuseiShikakuJoho().getCcdZaigaiMeiboJoho().get在外名簿情報().getTxtTorokuYMD();
                    RDate 登録日 = 在外選挙人名簿情報の表示日関連のチェック_登録日.getValue();
                    if (表示日 == null || 登録日 == null) {
                        return true;
                    }
                    return !表示日.isBefore(登録日);
                }
            },
    /**
     * 在外選挙人名簿情報の国内転入日関連のチェックをチェックします。
     */
    在外選挙人名簿情報の国内転入日関連のチェック_表示事由 {
                @Override
                public boolean apply(ZaigaiShuseiDiv div) {
                    TextBoxDate 在外選挙人名簿情報の国内転入日 = div.getZaigaiShuseiShikakuJoho().getCcdZaigaiMeiboJoho().get在外名簿情報().getTxtKokunaiTennyuYMD();
                    if (在外選挙人名簿情報の国内転入日.isDisabled() || 在外選挙人名簿情報の国内転入日.isReadOnly()
                    || !在外選挙人名簿情報の国内転入日.isVisible()) {
                        return true;
                    }
                    RDate 国内転入日 = 在外選挙人名簿情報の国内転入日.getValue();
                    IJiyuNameListDiv 表示事由 = div.getZaigaiShuseiShikakuJoho().getCcdZaigaiMeiboJoho().get在外名簿情報().getCcdHyojiJiyu();
                    RString 事由コード = 表示事由.getSelectJiyuCode();
                    return null != 国内転入日 || !HyojiJiyuCodeZaigai.国内転入.getKey().equals(事由コード);
                }
            },
    /**
     * 在外選挙人名簿情報の国内転入日関連のチェックをチェックします。
     */
    在外選挙人名簿情報の国内転入日関連のチェック_抹消事由 {
                @Override
                public boolean apply(ZaigaiShuseiDiv div) {
                    TextBoxDate 在外選挙人名簿情報_国内転入日 = div.getZaigaiShuseiShikakuJoho().getCcdZaigaiMeiboJoho().get在外名簿情報().getTxtKokunaiTennyuYMD();
                    if (在外選挙人名簿情報_国内転入日.isDisabled() || 在外選挙人名簿情報_国内転入日.isReadOnly()
                    || !在外選挙人名簿情報_国内転入日.isVisible()) {
                        return true;
                    }
                    RDate 国内転入日 = 在外選挙人名簿情報_国内転入日.getValue();
                    IJiyuNameListDiv 抹消事由 = div.getZaigaiShuseiShikakuJoho().getCcdZaigaiMeiboJoho().get在外名簿情報().getCcdMasshoJiyu();
                    RString 抹消事由コード = 抹消事由.getSelectJiyuCode();
                    return null != 国内転入日 || !MasshoJiyuCodeZaigai.国内転入4カ月経過抹消.getKey().equals(抹消事由コード);
                }
            },
    /**
     * 在外選挙人名簿情報の修正日関連のチェックをチェックします。
     */
    在外選挙人名簿情報の修正日関連のチェック_未来日 {
                @Override
                public boolean apply(ZaigaiShuseiDiv div) {
                    TextBoxDate 在外選挙人名簿情報の修正日 = div.getZaigaiShuseiShikakuJoho().getCcdZaigaiMeiboJoho().get在外名簿情報().getTxtShuseiYMD();
                    if (在外選挙人名簿情報の修正日.isDisabled() || 在外選挙人名簿情報の修正日.isReadOnly()
                    || !在外選挙人名簿情報の修正日.isVisible()) {
                        return true;
                    }
                    RDate 修正日 = 在外選挙人名簿情報の修正日.getValue();
                    if (null == 修正日) {
                        return true;
                    }
                    return 修正日.isBeforeOrEquals(RDate.getNowDate());
                }
            },
    /**
     * 在外選挙人名簿情報の修正日関連のチェックをチェックします。
     */
    在外選挙人名簿情報の修正日関連のチェック_登録日以降 {
                @Override
                public boolean apply(ZaigaiShuseiDiv div) {
                    TextBoxDate 在外選挙人名簿情報_修正日 = div.getZaigaiShuseiShikakuJoho().getCcdZaigaiMeiboJoho().get在外名簿情報().getTxtShuseiYMD();
                    if (在外選挙人名簿情報_修正日.isDisabled() || 在外選挙人名簿情報_修正日.isReadOnly()
                    || !在外選挙人名簿情報_修正日.isVisible()) {
                        return true;
                    }
                    RDate 修正日 = 在外選挙人名簿情報_修正日.getValue();
                    TextBoxDate 在外選挙人名簿情報の修正日関連のチェック_登録日 = div.getZaigaiShuseiShikakuJoho().getCcdZaigaiMeiboJoho().get在外名簿情報().getTxtTorokuYMD();
                    RDate 登録日 = 在外選挙人名簿情報の修正日関連のチェック_登録日.getValue();
                    if (null == 修正日 || null == 登録日) {
                        return true;
                    }
                    return !修正日.isBefore(登録日);
                }
            };
}
