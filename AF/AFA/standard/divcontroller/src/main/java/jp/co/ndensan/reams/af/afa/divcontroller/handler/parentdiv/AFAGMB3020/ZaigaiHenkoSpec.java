/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMB3020;

import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.HyojiJiyuCodeZaigai;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.MasshoJiyuCodeZaigai;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.JiyuNameList.IJiyuNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB3020.ZaigaiHenkoDiv;
import jp.co.ndensan.reams.af.afa.service.zaigaimeibotoroku.ZaigaiMeiboTorokuManager;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 証明書記載事項変更のチェック操作を担当するクラスです。
 *
 * @reamsid_L AF-0330-010 guancy
 */
public enum ZaigaiHenkoSpec implements IPredicate<ZaigaiHenkoDiv> {

    /**
     * 在住情報の住定日関連のチェックをチェックします。
     */
    在住情報の住定日関連のチェック_未来日 {
                @Override
                public boolean apply(ZaigaiHenkoDiv div) {
                    TextBoxDate 在住情報の住定日 = div.getCcdZaigaiHenkoSenkyoninJoho().getZaigaiZaijuJoho().getTxtJuteiYMD();
                    if (在住情報の住定日.isDisabled() || 在住情報の住定日.isReadOnly() || !在住情報の住定日.isVisible()) {
                        return true;
                    }
                    RDate 住定日 = 在住情報の住定日.getValue();
                    if (null == 住定日) {
                        return true;
                    }
                    return 住定日.isBeforeOrEquals(RDate.getNowDate());
                }
            },
    /**
     * 在住情報の住定日関連のチェックをチェックします。
     */
    在住情報の住定日関連のチェック_転出日以降 {
                @Override
                public boolean apply(ZaigaiHenkoDiv div) {
                    TextBoxDate 在住情報_住定日 = div.getCcdZaigaiHenkoSenkyoninJoho().getZaigaiZaijuJoho().getTxtJuteiYMD();
                    if (在住情報_住定日.isDisabled() || 在住情報_住定日.isReadOnly() || !在住情報_住定日.isVisible()) {
                        return true;
                    }
                    RDate 住定日 = 在住情報_住定日.getValue();
                    TextBoxDate 在住情報の住定日関連のチェック = div.getCcdZaigaiHenkoSenkyoninJoho().getZaigaiHonninJoho().getTxtTenshutsuYMD();
                    RDate 転出日 = 在住情報の住定日関連のチェック.getValue();
                    if (住定日 == null || 転出日 == null) {
                        return true;
                    }
                    return !住定日.isBefore(転出日);
                }
            },
    /**
     * 本人情報の最終住所エリアの転出日関連のチェックをチェックします。
     */
    本人情報の最終住所エリアの転出日関連のチェック {
                @Override
                public boolean apply(ZaigaiHenkoDiv div) {
                    TextBoxDate 本人情報の最終住所エリアの転出日 = div.getCcdZaigaiHenkoSenkyoninJoho().getZaigaiHonninJoho().getTxtTenshutsuYMD();
                    if (本人情報の最終住所エリアの転出日.isDisabled() || 本人情報の最終住所エリアの転出日.isReadOnly() || !本人情報の最終住所エリアの転出日.isVisible()) {
                        return true;
                    }
                    RDate 転出日 = 本人情報の最終住所エリアの転出日.getValue();
                    if (転出日 == null) {
                        return true;
                    }
                    return 転出日.isBeforeOrEquals(RDate.getNowDate());
                }
            },
    /**
     * 申請情報の申請日関連のチェックをチェックします。
     */
    申請情報の申請日関連のチェック_未来日 {
                @Override
                public boolean apply(ZaigaiHenkoDiv div) {
                    TextBoxDate 申請情報の申請日 = div.getCcdZaigaiHenkoSenkyoninJoho().getZaigaiShinseiJoho().getTxtShinseiYMD();
                    if (申請情報の申請日.isDisabled() || 申請情報の申請日.isReadOnly() || !申請情報の申請日.isVisible()) {
                        return true;
                    }
                    RDate 申請日 = 申請情報の申請日.getValue();
                    if (申請日 == null) {
                        return true;
                    }
                    return 申請日.isBeforeOrEquals(RDate.getNowDate());
                }
            },
    /**
     * 申請情報の申請日関連のチェックをチェックします。
     */
    申請情報の申請日関連のチェック_住定日以降 {
                @Override
                public boolean apply(ZaigaiHenkoDiv div) {
                    TextBoxDate 申請情報_申請日 = div.getCcdZaigaiHenkoSenkyoninJoho().getZaigaiShinseiJoho().getTxtShinseiYMD();
                    if (申請情報_申請日.isDisabled() || 申請情報_申請日.isReadOnly() || !申請情報_申請日.isVisible()) {
                        return true;
                    }
                    RDate 申請日 = 申請情報_申請日.getValue();
                    TextBoxDate 申請情報の申請日関連のチェック_住定日 = div.getCcdZaigaiHenkoSenkyoninJoho().getZaigaiZaijuJoho().getTxtJuteiYMD();
                    RDate 住定日 = 申請情報の申請日関連のチェック_住定日.getValue();
                    if (申請日 == null || 住定日 == null) {
                        return true;
                    }
                    return !申請日.isBefore(住定日);
                }
            },
    /**
     * 申請情報の申請取下げ日関連のチェックをチェックします。
     */
    申請情報の申請取下げ日関連のチェック_未来日 {
                @Override
                public boolean apply(ZaigaiHenkoDiv div) {
                    TextBoxDate 申請情報の申請取下げ日 = div.getCcdZaigaiHenkoSenkyoninJoho().getZaigaiShinseiJoho().getTxtTorisageYMD();
                    if (申請情報の申請取下げ日.isDisabled() || 申請情報の申請取下げ日.isReadOnly() || !申請情報の申請取下げ日.isVisible()) {
                        return true;
                    }
                    RDate 申請取下げ日 = 申請情報の申請取下げ日.getValue();
                    if (申請取下げ日 == null) {
                        return true;
                    }
                    return 申請取下げ日.isBeforeOrEquals(RDate.getNowDate());
                }
            },
    /**
     * 申請情報の申請取下げ日関連のチェックをチェックします。
     */
    申請情報の申請取下げ日関連のチェック_申請日以降 {
                @Override
                public boolean apply(ZaigaiHenkoDiv div) {
                    TextBoxDate 申請情報の申請取下げ日 = div.getCcdZaigaiHenkoSenkyoninJoho().getZaigaiShinseiJoho().getTxtTorisageYMD();
                    if (申請情報の申請取下げ日.isDisabled() || 申請情報の申請取下げ日.isReadOnly() || !申請情報の申請取下げ日.isVisible()) {
                        return true;
                    }
                    RDate 申請取下げ日 = 申請情報の申請取下げ日.getValue();
                    TextBoxDate 申請情報の申請取下げ日関連のチェック_申請日 = div.getCcdZaigaiHenkoSenkyoninJoho().getZaigaiShinseiJoho().getTxtShinseiYMD();
                    RDate 申請日 = 申請情報の申請取下げ日関連のチェック_申請日.getValue();
                    if (申請取下げ日 == null || 申請日 == null) {
                        return true;
                    }
                    return !申請取下げ日.isBefore(申請日);
                }
            },
    /**
     * 在外選挙人名簿情報の登録日関連のチェックをチェックします。
     */
    在外選挙人名簿情報の登録日関連のチェック_未来日 {
                @Override
                public boolean apply(ZaigaiHenkoDiv div) {
                    TextBoxDate 在外選挙人名簿情報の登録日 = div.getCcdZaigaiHenkoJoho().get在外名簿情報().getTxtTorokuYMD();
                    if (在外選挙人名簿情報の登録日.isDisabled() || 在外選挙人名簿情報の登録日.isReadOnly() || !在外選挙人名簿情報の登録日.isVisible()) {
                        return true;
                    }
                    RDate 登録日 = 在外選挙人名簿情報の登録日.getValue();
                    if (登録日 == null) {
                        return true;
                    }
                    return 登録日.isBeforeOrEquals(RDate.getNowDate());
                }
            },
    /**
     * 在外選挙人名簿情報の登録日関連のチェックをチェックします。
     */
    在外選挙人名簿情報の登録日関連のチェック_申請日以降 {
                @Override
                public boolean apply(ZaigaiHenkoDiv div) {
                    TextBoxDate 在外選挙人名簿情報_登録日 = div.getCcdZaigaiHenkoJoho().get在外名簿情報().getTxtTorokuYMD();
                    if (在外選挙人名簿情報_登録日.isDisabled() || 在外選挙人名簿情報_登録日.isReadOnly() || !在外選挙人名簿情報_登録日.isVisible()) {
                        return true;
                    }
                    RDate 登録日 = 在外選挙人名簿情報_登録日.getValue();
                    TextBoxDate 在外選挙人名簿情報の登録日関連のチェック_申請日 = div.getCcdZaigaiHenkoSenkyoninJoho().getZaigaiShinseiJoho().getTxtShinseiYMD();
                    RDate 申請日 = 在外選挙人名簿情報の登録日関連のチェック_申請日.getValue();
                    if (登録日 == null || 申請日 == null) {
                        return true;
                    }
                    return !登録日.isBefore(申請日);
                }
            },
    /**
     * 在外選挙人名簿情報の登録日関連のチェックをチェックします。
     */
    在外選挙人名簿情報の登録日関連のチェック_規定年齢到達日 {
                @Override
                public boolean apply(ZaigaiHenkoDiv div) {
                    TextBoxDate 名簿情報の登録日 = div.getCcdZaigaiHenkoJoho().get在外名簿情報().getTxtTorokuYMD();
                    if (名簿情報の登録日.isDisabled() || 名簿情報の登録日.isReadOnly() || !名簿情報の登録日.isVisible()) {
                        return true;
                    }
                    RDate 登録日 = 名簿情報の登録日.getValue();
                    TextBoxFlexibleDate 在外選挙人名簿情報の登録日関連のチェック_生年月日 = div.getCcdZaigaiHenkoSenkyoninJoho().getZaigaiHonninJoho().getTxtSeinengappiYMD();
                    FlexibleDate 生年月日 = 在外選挙人名簿情報の登録日関連のチェック_生年月日.getValue();
                    if (null == 登録日 || null == 生年月日 || 生年月日.isEmpty()) {
                        return true;
                    }
                    int 選挙資格到達年齢 = Integer.valueOf(BusinessConfig.get(ConfigKeysAFA.選挙資格到達年齢_国民投票, SubGyomuCode.AFA選挙本体).toString());
                    return !登録日.isBefore(new RDate(生年月日.minusYear(選挙資格到達年齢).toString()));
                }
            },
    /**
     * 在外選挙人名簿情報の登録日関連のチェックをチェックします。
     */
    在外選挙人名簿情報の登録日関連のチェック_転入3か月経過 {
                @Override
                public boolean apply(ZaigaiHenkoDiv div) {
                    TextBoxDate 在外選挙人名簿情報の登録日 = div.getCcdZaigaiHenkoJoho().get在外名簿情報().getTxtTorokuYMD();
                    if (在外選挙人名簿情報の登録日.isDisabled() || 在外選挙人名簿情報の登録日.isReadOnly() || !在外選挙人名簿情報の登録日.isVisible()) {
                        return true;
                    }
                    RDate 登録日 = div.getCcdZaigaiHenkoJoho().get在外名簿情報().getTxtTorokuYMD().getValue();

                    TextBoxDate 在外選挙人名簿情報の登録日関連のチェック_住定日 = div.getCcdZaigaiHenkoSenkyoninJoho().getZaigaiZaijuJoho().getTxtJuteiYMD();
                    RDate 住定日 = 在外選挙人名簿情報の登録日関連のチェック_住定日.getValue();
                    if (null == 登録日 || null == 住定日) {
                        return true;
                    }
                    return !登録日.isBefore(住定日.minusMonth(1 + 1 + 1));
                }
            },
    /**
     * 申請情報の選挙人証交付日関連のチェックをチェックします。
     */
    申請情報の選挙人証交付日関連のチェック_未来日 {
                @Override
                public boolean apply(ZaigaiHenkoDiv div) {
                    TextBoxDate 申請情報の選挙人証交付日 = div.getCcdZaigaiHenkoSenkyoninJoho().getZaigaiShinseiJoho().getTxtKofuYMD();
                    if (申請情報の選挙人証交付日.isDisabled() || 申請情報の選挙人証交付日.isReadOnly() || !申請情報の選挙人証交付日.isVisible()) {
                        return true;
                    }
                    RDate 選挙人証交付日 = 申請情報の選挙人証交付日.getValue();
                    if (選挙人証交付日 == null) {
                        return true;
                    }
                    return 選挙人証交付日.isBeforeOrEquals(RDate.getNowDate());
                }
            },
    /**
     * 申請情報の選挙人証交付日関連のチェックをチェックします。
     */
    申請情報の選挙人証交付日関連のチェック_登録日以降 {
                @Override
                public boolean apply(ZaigaiHenkoDiv div) {
                    TextBoxDate 申請情報_選挙人証交付日 = div.getCcdZaigaiHenkoSenkyoninJoho().getZaigaiShinseiJoho().getTxtKofuYMD();
                    if (申請情報_選挙人証交付日.isDisabled() || 申請情報_選挙人証交付日.isReadOnly() || !申請情報_選挙人証交付日.isVisible()) {
                        return true;
                    }
                    RDate 選挙人証交付日 = 申請情報_選挙人証交付日.getValue();
                    TextBoxDate 申請情報の選挙人証交付日関連のチェック_登録日 = div.getCcdZaigaiHenkoJoho().get在外名簿情報().getTxtTorokuYMD();
                    RDate 登録日 = 申請情報の選挙人証交付日関連のチェック_登録日.getValue();
                    if (選挙人証交付日 == null || 登録日 == null) {
                        return true;
                    }
                    return !選挙人証交付日.isBefore(登録日);
                }
            },
    /**
     * 申請情報の選挙人証交付日関連のチェックをチェックします。
     */
    申請情報の選挙人証交付日関連のチェック_交付履歴 {
                @Override
                public boolean apply(ZaigaiHenkoDiv div) {
                    TextBoxDate 選挙人証交付日 = div.getCcdZaigaiHenkoSenkyoninJoho().getZaigaiShinseiJoho().getTxtKofuYMD();
                    if (選挙人証交付日.isDisabled() || 選挙人証交付日.isReadOnly() || !選挙人証交付日.isVisible()) {
                        return true;
                    }
                    RDate 交付日 = 選挙人証交付日.getValue();
                    if (null == 交付日) {
                        return true;
                    }
                    ZaigaiMeiboTorokuManager manager = ZaigaiMeiboTorokuManager.createInstance();
                    ShikibetsuCode 識別コード = div.getCcdZaigaiHenkoKojinJoho().getCcdKojinJohoUR().getAtenaShokaiSimpleData()
                    .getShikibetsuTaishoHisory().get直近().get識別コード();
                    return 0 == manager.select前回在外選挙資格件数(識別コード, new FlexibleDate(交付日.toDateString()));
                }
            },
    /**
     * 在外選挙人名簿情報の表示日関連のチェックをチェックします。
     */
    在外選挙人名簿情報の表示日関連のチェック_未来日 {
                @Override
                public boolean apply(ZaigaiHenkoDiv div) {
                    TextBoxDate 在外選挙人名簿情報の表示日 = div.getCcdZaigaiHenkoJoho().get在外名簿情報().getTxtHyojiYMD();
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
                public boolean apply(ZaigaiHenkoDiv div) {
                    TextBoxDate 在外選挙人名簿情報の表示日 = div.getCcdZaigaiHenkoJoho().get在外名簿情報().getTxtHyojiYMD();
                    if (在外選挙人名簿情報の表示日.isDisabled() || 在外選挙人名簿情報の表示日.isReadOnly() || !在外選挙人名簿情報の表示日.isVisible()) {
                        return true;
                    }
                    RDate 表示日 = 在外選挙人名簿情報の表示日.getValue();
                    TextBoxDate 在外選挙人名簿情報の表示日関連のチェック_登録日 = div.getCcdZaigaiHenkoJoho().get在外名簿情報().getTxtTorokuYMD();
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
                public boolean apply(ZaigaiHenkoDiv div) {
                    TextBoxDate 在外選挙人名簿情報の国内転入日 = div.getCcdZaigaiHenkoJoho().get在外名簿情報().getTxtKokunaiTennyuYMD();
                    if (在外選挙人名簿情報の国内転入日.isDisabled() || 在外選挙人名簿情報の国内転入日.isReadOnly()
                    || !在外選挙人名簿情報の国内転入日.isVisible()) {
                        return true;
                    }
                    RDate 国内転入日 = 在外選挙人名簿情報の国内転入日.getValue();
                    IJiyuNameListDiv 表示事由 = div.getCcdZaigaiHenkoJoho().get在外名簿情報().getCcdHyojiJiyu();
                    RString 事由コード = 表示事由.getSelectJiyuCode();
                    return null != 国内転入日 || !HyojiJiyuCodeZaigai.国内転入.getKey().equals(事由コード);
                }
            },
    /**
     * 在外選挙人名簿情報の国内転入日関連のチェックをチェックします。
     */
    在外選挙人名簿情報の国内転入日関連のチェック_抹消事由 {
                @Override
                public boolean apply(ZaigaiHenkoDiv div) {
                    TextBoxDate 在外選挙人名簿情報_国内転入日 = div.getCcdZaigaiHenkoJoho().get在外名簿情報().getTxtKokunaiTennyuYMD();
                    if (在外選挙人名簿情報_国内転入日.isDisabled() || 在外選挙人名簿情報_国内転入日.isReadOnly()
                    || !在外選挙人名簿情報_国内転入日.isVisible()) {
                        return true;
                    }
                    RDate 国内転入日 = 在外選挙人名簿情報_国内転入日.getValue();
                    IJiyuNameListDiv 抹消事由 = div.getCcdZaigaiHenkoJoho().get在外名簿情報().getCcdMasshoJiyu();
                    RString 抹消事由コード = 抹消事由.getSelectJiyuCode();
                    return null != 国内転入日 || !MasshoJiyuCodeZaigai.国内転入4カ月経過抹消.getKey().equals(抹消事由コード);
                }
            },
    /**
     * 在外選挙人名簿情報の修正日関連のチェックをチェックします。
     */
    在外選挙人名簿情報の修正日関連のチェック_未来日 {
                @Override
                public boolean apply(ZaigaiHenkoDiv div) {
                    TextBoxDate 在外選挙人名簿情報の修正日 = div.getCcdZaigaiHenkoJoho().get在外名簿情報().getTxtShuseiYMD();
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
                public boolean apply(ZaigaiHenkoDiv div) {
                    TextBoxDate 在外選挙人名簿情報_修正日 = div.getCcdZaigaiHenkoJoho().get在外名簿情報().getTxtShuseiYMD();
                    if (在外選挙人名簿情報_修正日.isDisabled() || 在外選挙人名簿情報_修正日.isReadOnly()
                    || !在外選挙人名簿情報_修正日.isVisible()) {
                        return true;
                    }
                    RDate 修正日 = 在外選挙人名簿情報_修正日.getValue();
                    TextBoxDate 在外選挙人名簿情報の修正日関連のチェック_登録日 = div.getCcdZaigaiHenkoJoho().get在外名簿情報().getTxtTorokuYMD();
                    RDate 登録日 = 在外選挙人名簿情報の修正日関連のチェック_登録日.getValue();
                    if (null == 修正日 || null == 登録日) {
                        return true;
                    }
                    return !修正日.isBefore(登録日);
                }
            },
    /**
     * 申請取下げ日取下げ事由のチェック_申請取下げ日未入力をチェックします。
     */
    申請取下げ日取下げ事由のチェック_申請取下げ日未入力 {
                @Override
                public boolean apply(ZaigaiHenkoDiv div) {
                    TextBoxDate 申請取下げ日 = div.getCcdZaigaiHenkoSenkyoninJoho().getZaigaiShinseiJoho().getTxtTorisageYMD();
                    IJiyuNameListDiv 取下げ事由 = div.getCcdZaigaiHenkoSenkyoninJoho().getZaigaiShinseiJoho().getCcdTorisageJiyu();
                    if (申請取下げ日.isDisabled() || 取下げ事由.isDisabled()) {
                        return true;
                    }
                    return !(!RString.isNullOrEmpty(取下げ事由.getSelectJiyuCode()) && null == 申請取下げ日.getValue());
                }
            },
    /**
     * 申請取下げ日取下げ事由のチェック_取下げ事由未入力をチェックします。
     */
    申請取下げ日取下げ事由のチェック_取下げ事由未入力 {
                @Override
                public boolean apply(ZaigaiHenkoDiv div) {
                    TextBoxDate 取下げ日 = div.getCcdZaigaiHenkoSenkyoninJoho().getZaigaiShinseiJoho().getTxtTorisageYMD();
                    IJiyuNameListDiv 取下げ事由 = div.getCcdZaigaiHenkoSenkyoninJoho().getZaigaiShinseiJoho().getCcdTorisageJiyu();
                    if (取下げ日.isDisabled() || 取下げ事由.isDisabled()) {
                        return true;
                    }
                    return !(RString.isNullOrEmpty(取下げ事由.getSelectJiyuCode()) && null != 取下げ日.getValue());
                }
            },
    /**
     * 却下日却下事由のチェック_却下日未入力をチェックします。
     */
    却下日却下事由のチェック_却下日未入力 {
                @Override
                public boolean apply(ZaigaiHenkoDiv div) {
                    TextBoxDate 却下日 = div.getCcdZaigaiHenkoSenkyoninJoho().getZaigaiShinseiJoho().getTxtKyakkaYMD();
                    IJiyuNameListDiv 却下事由 = div.getCcdZaigaiHenkoSenkyoninJoho().getZaigaiShinseiJoho().getCcdKyakkaJiyu();
                    if (却下日.isDisabled() || 却下事由.isDisabled()) {
                        return true;
                    }
                    return !(!RString.isNullOrEmpty(却下事由.getSelectJiyuCode()) && null == 却下日.getValue());
                }
            },
    /**
     * 却下日却下事由のチェック_却下事由未入力をチェックします。
     */
    却下日却下事由のチェック_却下事由未入力 {
                @Override
                public boolean apply(ZaigaiHenkoDiv div) {
                    TextBoxDate 却下日 = div.getCcdZaigaiHenkoSenkyoninJoho().getZaigaiShinseiJoho().getTxtKyakkaYMD();
                    IJiyuNameListDiv 事由 = div.getCcdZaigaiHenkoSenkyoninJoho().getZaigaiShinseiJoho().getCcdKyakkaJiyu();
                    if (却下日.isDisabled() || 事由.isDisabled()) {
                        return true;
                    }
                    return !(RString.isNullOrEmpty(事由.getSelectJiyuCode()) && null != 却下日.getValue());
                }
            },
    /**
     * 表示日表示事由のチェック_表示日未入力をチェックします。
     */
    表示日表示事由のチェック_表示日未入力 {
                @Override
                public boolean apply(ZaigaiHenkoDiv div) {
                    TextBoxDate 表示日 = div.getCcdZaigaiHenkoJoho().get在外名簿情報().getTxtHyojiYMD();
                    IJiyuNameListDiv 表示事由 = div.getCcdZaigaiHenkoJoho().get在外名簿情報().getCcdHyojiJiyu();
                    if (表示日.isDisabled() || 表示事由.isDisabled()) {
                        return true;
                    }
                    return !(!RString.isNullOrEmpty(表示事由.getSelectJiyuCode()) && null == 表示日.getValue());
                }
            },
    /**
     * 表示日表示事由のチェック_表示事由未入力をチェックします。
     */
    表示日表示事由のチェック_表示事由未入力 {
                @Override
                public boolean apply(ZaigaiHenkoDiv div) {
                    TextBoxDate 表示日 = div.getCcdZaigaiHenkoJoho().get在外名簿情報().getTxtHyojiYMD();
                    IJiyuNameListDiv 事由 = div.getCcdZaigaiHenkoJoho().get在外名簿情報().getCcdHyojiJiyu();
                    if (表示日.isDisabled() || 事由.isDisabled()) {
                        return true;
                    }
                    return !(RString.isNullOrEmpty(事由.getSelectJiyuCode()) && null != 表示日.getValue());
                }
            },
    /**
     * 抹消日抹消事由のチェック_抹消日未入力をチェックします。
     */
    抹消日抹消事由のチェック_抹消日未入力 {
                @Override
                public boolean apply(ZaigaiHenkoDiv div) {
                    TextBoxDate 抹消日 = div.getCcdZaigaiHenkoJoho().get在外名簿情報().getTxtMasshoYMD();
                    IJiyuNameListDiv 抹消事由 = div.getCcdZaigaiHenkoJoho().get在外名簿情報().getCcdMasshoJiyu();
                    if (抹消日.isDisabled() || 抹消事由.isDisabled()) {
                        return true;
                    }
                    return !(!RString.isNullOrEmpty(抹消事由.getSelectJiyuCode()) && null == 抹消日.getValue());
                }
            },
    /**
     * 抹消日抹消事由のチェック_抹消事由未入力をチェックします。
     */
    抹消日抹消事由のチェック_抹消事由未入力 {
                @Override
                public boolean apply(ZaigaiHenkoDiv div) {
                    TextBoxDate 抹消日 = div.getCcdZaigaiHenkoJoho().get在外名簿情報().getTxtMasshoYMD();
                    IJiyuNameListDiv 事由 = div.getCcdZaigaiHenkoJoho().get在外名簿情報().getCcdMasshoJiyu();
                    if (抹消日.isDisabled() || 事由.isDisabled()) {
                        return true;
                    }
                    return !(RString.isNullOrEmpty(事由.getSelectJiyuCode()) && null != 抹消日.getValue());
                }

            };
}
