/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShikakuJoho;

import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuKubun;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ShikakuJohoEnum;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.validation.IPredicate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * ShikakuJohoDiv のチェックロジックです。
 *
 * @reamsid_L AF-0180-015 lis2
 */
public enum ShikakuJohoSpec implements IPredicate<ShikakuJohoDiv> {

    /**
     * 3ヶ月経過日チェック。
     */
    経過日3ヶ月チェック {
                private final static int MONTH = 3;

                @Override
                public boolean apply(ShikakuJohoDiv div) {
                    boolean flag = true;
                    RDate 名簿登録日 = div.getTxtMeiboTorokuYMD().getValue();
                    RString Hdn登録日 = div.getTxtHdnTorokuYMD();
                    if (!Hdn登録日.isNullOrEmpty()) {
                        RDate 登録届出年月日 = new RDate(Hdn登録日.toString());

                        if (名簿登録日 != null && 名簿登録日.isBefore(登録届出年月日.plusMonth(MONTH))) {
                            flag = false;
                        }
                    }
                    return flag;
                }
            },
    /**
     * 表示日・表示事由のチェック。
     */
    表示日と表示事由のチェック1 {

                @Override
                public boolean apply(ShikakuJohoDiv div) {
                    boolean flag = true;
                    RDate 表示日 = div.getTxtHyojiYMD().getValue();
                    boolean 表示事由状態1 = div.getCcdHyojiJiyu().isDisabled();
                    boolean 表示日の状態1 = div.getTxtHyojiYMD().isDisabled();
                    RString 選挙資格 = div.getRadSenkyoShikaku().getSelectedKey();
                    if (選挙資格.equals(SennkyoSikakuKubun.表示者.value()) || 選挙資格.equals(SennkyoSikakuKubun.公民権停止.value())) {
                        if (!表示事由状態1 && !表示日の状態1 && 表示日 == null && !div.getCcdHyojiJiyu().getDdlJiyuNameList().getSelectedValue().isNullOrEmpty()) {
                            flag = false;
                        } else if (!表示事由状態1 && !表示日の状態1 && 表示日 == null && div.getCcdHyojiJiyu().getDdlJiyuNameList().getSelectedValue().isNullOrEmpty()) {
                            flag = false;
                        }
                    }
                    return flag;
                }
            },
    /**
     * 表示日・表示事由のチェック。
     */
    表示日と表示事由のチェック2 {

                @Override
                public boolean apply(ShikakuJohoDiv div) {
                    boolean flag = true;
                    RDate 表示日 = div.getTxtHyojiYMD().getValue();
                    boolean 表示事由状態 = div.getCcdHyojiJiyu().isDisplayNone();
                    boolean 表示日の状態 = div.getTxtHyojiYMD().isDisplayNone();
                    RString 選挙資格 = div.getRadSenkyoShikaku().getSelectedKey();
                    if ((選挙資格.equals(SennkyoSikakuKubun.表示者.value()) || 選挙資格.equals(SennkyoSikakuKubun.公民権停止.value()))
                    && !表示事由状態 && !表示日の状態 && 表示日 != null && div.getCcdHyojiJiyu().getDdlJiyuNameList().getSelectedValue().isNullOrEmpty()) {
                        flag = false;
                    }

                    return flag;
                }
            },
    /**
     * 登録停止日・登録停止事由のチェック。
     */
    登録停止者変更時のチェック {

                @Override
                public boolean apply(ShikakuJohoDiv div) {
                    boolean flag = true;
                    RDate 登録停止日 = div.getTxtTorokuTeishiYMD().getValue();
                    RString 選挙資格 = div.getRadSenkyoShikaku().getSelectedValue();
                    boolean 登録停止日の状態1 = div.getTxtTorokuTeishiYMD().isDisplayNone();

                    if (!登録停止日の状態1 && (登録停止日 != null || !div.getCcdTorokuTeishiJiyu().getDdlJiyuNameList().getSelectedValue().isNullOrEmpty())
                    && (選挙資格.equals(ShikakuJohoEnum.有権者.toRString()) || 選挙資格.equals(ShikakuJohoEnum.表示者.toRString()))) {
                        flag = false;
                    }

                    return flag;
                }
            },
    /**
     * 登録停止日・登録停止事由のチェック。
     */
    登録停止日と登録停止事由のチェック1 {

                @Override
                public boolean apply(ShikakuJohoDiv div) {
                    boolean flag = true;
                    RDate 登録停止日 = div.getTxtTorokuTeishiYMD().getValue();
                    boolean 登録停止日の状態2 = div.getTxtTorokuTeishiYMD().isDisplayNone();

                    if (!登録停止日の状態2 && 登録停止日 == null && !div.getCcdTorokuTeishiJiyu().getDdlJiyuNameList().getSelectedValue().isNullOrEmpty()) {
                        flag = false;
                    }
                    return flag;
                }
            },
    /**
     * 登録停止日・登録停止事由のチェック。
     */
    登録停止日と登録停止事由のチェック2 {

                @Override
                public boolean apply(ShikakuJohoDiv div) {
                    boolean flag = true;
                    RDate 登録停止日 = div.getTxtTorokuTeishiYMD().getValue();
                    boolean 登録停止日の状態3 = div.getTxtTorokuTeishiYMD().isDisplayNone();

                    if (!登録停止日の状態3 && 登録停止日 != null && div.getCcdTorokuTeishiJiyu().getDdlJiyuNameList().getSelectedValue().isNullOrEmpty()) {
                        flag = false;
                    }

                    return flag;
                }
            },
    /**
     * 登録停止事由と表示事由のチェック。
     */
    登録停止事由と表示事由のチェック {

                @Override
                public boolean apply(ShikakuJohoDiv div) {
                    boolean flag = true;
                    boolean 表示事由の状態1 = div.getCcdHyojiJiyu().isDisplayNone();
                    boolean 登録停止事由1 = div.getCcdTorokuTeishiJiyu().isDisplayNone();

                    if (!表示事由の状態1 && !登録停止事由1 && !div.getCcdHyojiJiyu().getDdlJiyuNameList().getSelectedValue().isNullOrEmpty()
                    && !div.getCcdTorokuTeishiJiyu().getDdlJiyuNameList().getSelectedValue().isNullOrEmpty()) {
                        flag = false;
                    }
                    return flag;
                }
            },
    /**
     * 表示消除予定日と表示日のチェック。
     */
    表示消除予定日と表示日のチェック {

                @Override
                public boolean apply(ShikakuJohoDiv div) {
                    boolean flag = true;
                    RDate 消除予定日 = div.getTxtHyojiShojoYoteiYMD().getValue();
                    RDate 表示日 = div.getTxtHyojiYMD().getValue();
                    boolean 消除予定日の状態 = div.getTxtHyojiShojoYoteiYMD().isDisplayNone();
                    boolean 表示日の状態1 = div.getTxtHyojiYMD().isDisplayNone();

                    if (!消除予定日の状態 && !表示日の状態1 && 消除予定日 != null && 表示日 != null && 消除予定日.isBefore(表示日)) {
                        flag = false;
                    }
                    return flag;
                }
            },
    /**
     * 表示消除予定日・表示事由のチェック１。
     */
    表示消除予定日と表示事由のチェック１ {

                @Override
                public boolean apply(ShikakuJohoDiv div) {
                    boolean flag = true;
                    RDate 消除予定日 = div.getTxtHyojiShojoYoteiYMD().getValue();
                    RString 表示事由 = div.getCcdHyojiJiyu().getDdlJiyuNameList().getSelectedValue();
                    boolean 消除予定日の状態1 = div.getTxtHyojiShojoYoteiYMD().isDisplayNone();
                    boolean 表示事由の状態1 = div.getCcdHyojiJiyu().isDisplayNone();

                    if (!消除予定日の状態1 && !表示事由の状態1 && 消除予定日 != null && 表示事由.isNullOrEmpty()) {
                        flag = false;
                    }
                    return flag;
                }
            },
    /**
     * 表示消除予定日・表示事由のチェック２。
     */
    表示消除予定日と表示事由のチェック２ {
                private final RString RST_12 = new RString("12");
                private final RString RST_13 = new RString("13");
                private final RString RST_14 = new RString("14");
                private final RString RST_15 = new RString("15");
                private final RString RST_20 = new RString("20");

                @Override
                public boolean apply(ShikakuJohoDiv div) {

                    boolean flag = true;
                    RDate 消除予定日 = div.getTxtHyojiShojoYoteiYMD().getValue();
                    RString 表示事由 = div.getCcdHyojiJiyu().getDdlJiyuNameList().getSelectedKey();
                    boolean 消除予定日の状態2 = div.getTxtHyojiShojoYoteiYMD().isDisplayNone();
                    boolean 表示事由の状態2 = div.getCcdHyojiJiyu().isDisplayNoneMode();

                    if (!消除予定日の状態2 && !表示事由の状態2 && !表示事由.equals(RST_12) && !表示事由.equals(RST_13) && !表示事由.equals(RST_14)
                    && !表示事由.equals(RST_15) && !表示事由.equals(RST_20) && 消除予定日 != null) {
                        flag = false;
                    }

                    return flag;
                }
            },
    /**
     * 表示消除予定日・名簿登録日のチェック。
     */
    表示消除予定日と名簿登録日のチェック {

                @Override
                public boolean apply(ShikakuJohoDiv div) {
                    boolean flag = true;
                    RDate 消除予定日 = div.getTxtHyojiShojoYoteiYMD().getValue();
                    RDate 名簿登録日 = div.getTxtMeiboTorokuYMD().getValue();
                    boolean 消除予定日の状態3 = div.getTxtHyojiShojoYoteiYMD().isDisplayNone();
                    boolean 名簿登録日の状態 = div.getTxtMeiboTorokuYMD().isDisplayNone();

                    if (!名簿登録日の状態 && !消除予定日の状態3 && 消除予定日 != null && 名簿登録日 != null && 消除予定日.isBefore(名簿登録日)) {
                        flag = false;
                    }
                    return flag;
                }
            },
    /**
     * 表示消除日・表示日のチェック。
     */
    表示消除日と表示日のチェック {

                @Override
                public boolean apply(ShikakuJohoDiv div) {
                    boolean flag = true;
                    RDate 表示消除日 = div.getTxtHyojiShojoYMD().getValue();
                    RDate 表示日 = div.getTxtHyojiYMD().getValue();
                    boolean 表示消除日の状態4 = div.getTxtHyojiShojoYMD().isDisplayNone();
                    boolean 表示日の状態4 = div.getTxtHyojiYMD().isDisplayNone();

                    if (!表示消除日の状態4 && !表示日の状態4 && 表示消除日 != null && 表示日 != null && 表示消除日.isBefore(表示日)) {
                        flag = false;
                    }
                    return flag;
                }
            },
    /**
     * 表示消除日・表示事由のチェック１。
     */
    表示消除日と表示事由のチェック１ {

                @Override
                public boolean apply(ShikakuJohoDiv div) {
                    boolean flag = true;
                    RDate 表示消除日 = div.getTxtHyojiShojoYMD().getValue();
                    RString 表示事由 = div.getCcdHyojiJiyu().getDdlJiyuNameList().getSelectedValue();
                    boolean 表示消除日の状態5 = div.getTxtHyojiShojoYMD().isDisplayNone();
                    boolean 表示事由の状態5 = div.getCcdHyojiJiyu().isDisplayNone();

                    if (!表示消除日の状態5 && !表示事由の状態5 && 表示消除日 != null && 表示事由.isNullOrEmpty()) {
                        flag = false;
                    }
                    return flag;
                }
            },
    /**
     * 表示消除日・表示事由のチェック２。
     */
    表示消除日と表示事由のチェック２ {

                private final RString RST_12 = new RString("12");
                private final RString RST_13 = new RString("13");
                private final RString RST_14 = new RString("14");
                private final RString RST_15 = new RString("15");
                private final RString RST_20 = new RString("20");

                @Override
                public boolean apply(ShikakuJohoDiv div) {
                    boolean flag = true;
                    RDate 表示消除日 = div.getTxtHyojiShojoYMD().getValue();
                    RString 事由Key = div.getCcdHyojiJiyu().getDdlJiyuNameList().getSelectedKey();

                    boolean 表示消除日の状態6 = div.getTxtHyojiShojoYMD().isDisplayNone();
                    boolean 表示事由の状態6 = div.getCcdHyojiJiyu().isDisplayNone();

                    if (!表示消除日の状態6 && !表示事由の状態6 && !事由Key.equals(RST_12) && !事由Key.equals(RST_13) && !事由Key.equals(RST_14)
                    && !事由Key.equals(RST_15) && !事由Key.equals(RST_20) && 表示消除日 != null) {
                        flag = false;
                    }

                    return flag;
                }
            },
    /**
     * 表示消除日・名簿登録日のチェック。
     */
    表示消除日と名簿登録日のチェック {

                @Override
                public boolean apply(ShikakuJohoDiv div) {
                    boolean flag = true;
                    RDate 表示消除日 = div.getTxtHyojiShojoYMD().getValue();
                    RDate 名簿登録日 = div.getTxtMeiboTorokuYMD().getValue();

                    boolean 表示消除日の状態7 = div.getTxtHyojiShojoYMD().isDisplayNone();
                    boolean 名簿登録日の状態7 = div.getTxtMeiboTorokuYMD().isDisplayNone();

                    if (!表示消除日の状態7 && !名簿登録日の状態7 && 表示消除日 != null && 名簿登録日 != null && 表示消除日.isBefore(名簿登録日)) {
                        flag = false;
                    }

                    return flag;
                }
            },
    /**
     * 「転出時」の住民種別チェック 、表示日の未来日チェック
     */
    表示日の未来日チェック {

                @Override
                public boolean apply(ShikakuJohoDiv div) {
                    boolean flag = true;
                    RDate 表示日 = div.getTxtHyojiYMD().getValue();
                    RString 表示事由1 = div.getCcdHyojiJiyu().getDdlJiyuNameList().getSelectedValue();

                    boolean 表示日の状態8 = div.getTxtHyojiYMD().isDisplayNone();
                    boolean 表示事由の状態8 = div.getCcdHyojiJiyu().isDisplayNone();

                    if (!表示日の状態8 && !表示事由の状態8 && 表示事由1 != null && 表示事由1.equals(ShikakuJohoEnum.転出.toRString())
                    && 表示日 != null && RDate.getNowDate().isBefore(表示日)) {
                        flag = false;
                    }

                    return flag;
                }
            },
    /**
     * 「転出時」の住民種別チェック 、登録停止日の未来日チェック
     */
    登録停止日の未来日チェック {

                @Override
                public boolean apply(ShikakuJohoDiv div) {
                    boolean flag = true;
                    RDate 登録停止日 = div.getTxtTorokuTeishiYMD().getValue();
                    RString 表示事由 = div.getCcdHyojiJiyu().getDdlJiyuNameList().getSelectedValue();

                    boolean 登録停止日の状態9 = div.getTxtTorokuTeishiYMD().isDisplayNone();
                    boolean 表示事由の状態9 = div.getCcdHyojiJiyu().isDisplayNone();

                    if (!登録停止日の状態9 && !表示事由の状態9 && 表示事由 != null && 表示事由.equals(ShikakuJohoEnum.転出.toRString()) && 登録停止日 != null
                    && RDate.getNowDate().isBefore(登録停止日)) {
                        flag = false;
                    }

                    return flag;
                }
            },
    /**
     * 「転出時」の住民種別チェック 、転出時の住民種別・状態チェック１
     */
    転出時の住民種別と状態チェック１ {

                private final RString RST_1 = new RString("1");
                private final RString RST_3 = new RString("3");
                private final RString RST_9 = new RString("9");

                @Override
                public boolean apply(ShikakuJohoDiv div) {
                    boolean flag = true;
                    RString 表示事由 = div.getCcdHyojiJiyu().getDdlJiyuNameList().getSelectedValue();
                    RString 住民種別コード = div.getTxtHdnjuminShubetsuCode();
                    RString 住民状態コード = div.getTxtHdnjuminJotaiCode();

                    boolean 表示事由の状態10 = div.getCcdHyojiJiyu().isDisplayNone();

                    if (!表示事由の状態10 && 表示事由 != null && 表示事由.equals(ShikakuJohoEnum.転出.toRString())
                    && 住民種別コード != null && 住民種別コード.equals(RST_1) && 住民状態コード != null
                    && !住民状態コード.equals(RST_3) && !住民状態コード.equals(RST_9)) {
                        flag = false;
                    }

                    return flag;
                }
            },
    /**
     * 同一日チェック 、転出の表示日と消除異動年月日同一日チェック
     */
    転出の表示日と消除異動年月日同一日チェック {

                @Override
                public boolean apply(ShikakuJohoDiv div) {
                    boolean flag = true;
                    RDate 表示日 = div.getTxtHyojiYMD().getValue();
                    RString 表示事由 = div.getCcdHyojiJiyu().getDdlJiyuNameList().getSelectedValue();

                    boolean 表示日の状態11 = div.getTxtHyojiYMD().isDisplayNone();
                    boolean 表示事由の状態11 = div.getCcdHyojiJiyu().isDisplayNone();
                    RDate 消除異動年月日 = null;
                    RDate 消除届出年月日 = null;
                    if (!div.getTxtHdnShojoIdoYMD().isNullOrEmpty()) {
                        消除異動年月日 = new RDate(div.getTxtHdnShojoIdoYMD().toString());
                    }
                    if (!div.getTxtHdnShojoTodokedeYMD().isNullOrEmpty()) {
                        消除届出年月日 = new RDate(div.getTxtHdnShojoTodokedeYMD().toString());
                    }

                    if (!表示日の状態11 && !表示事由の状態11 && 表示日 != null && 表示事由 != null && 表示事由.equals(ShikakuJohoEnum.転出.toRString())
                    && 消除異動年月日 != null && 消除届出年月日 != null && 表示日.compareTo(消除異動年月日) != 0
                    && 消除届出年月日.isBefore(消除異動年月日)) {
                        flag = false;
                    }

                    return flag;
                }
            },
    /**
     * 同一日チェック 、転出の表示日と消除届出年月日同一日チェック
     */
    転出の表示日と消除届出年月日同一日チェック {

                @Override
                public boolean apply(ShikakuJohoDiv div) {
                    boolean flag = true;
                    RDate 表示日 = div.getTxtHyojiYMD().getValue();
                    RString 表示事由 = div.getCcdHyojiJiyu().getDdlJiyuNameList().getSelectedValue();

                    boolean 表示日の状態12 = div.getTxtHyojiYMD().isDisplayNone();
                    boolean 表示事由の状態12 = div.getCcdHyojiJiyu().isDisplayNone();
                    RDate 消除異動年月日 = null;
                    RDate 消除届出年月日 = null;

                    if (!div.getTxtHdnShojoIdoYMD().isNullOrEmpty()) {
                        消除異動年月日 = new RDate(div.getTxtHdnShojoIdoYMD().toString());
                    }
                    if (!div.getTxtHdnShojoTodokedeYMD().isNullOrEmpty()) {
                        消除届出年月日 = new RDate(div.getTxtHdnShojoTodokedeYMD().toString());
                    }

                    if (!表示事由の状態12 && !表示日の状態12 && 表示日 != null && 表示事由 != null && 表示事由.equals(ShikakuJohoEnum.転出.toRString())
                    && 消除異動年月日 != null && 消除届出年月日 != null && 表示日.compareTo(消除届出年月日) != 0
                    && 消除異動年月日.isBeforeOrEquals(消除届出年月日)) {
                        flag = false;
                    }

                    return flag;
                }
            },
    /**
     * 関連チェック 、表示年月日・登録日チェック
     */
    表示年月日と登録日チェック {

                @Override
                public boolean apply(ShikakuJohoDiv div) {
                    boolean flag = true;
                    RDate 表示日 = div.getTxtHyojiYMD().getValue();
                    RDate 名簿登録日 = div.getTxtMeiboTorokuYMD().getValue();

                    boolean 表示日の状態13 = div.getTxtHyojiYMD().isDisplayNone();
                    boolean 名簿登録日の状態13 = div.getTxtMeiboTorokuYMD().isDisplayNone();

                    if (!表示日の状態13 && !名簿登録日の状態13 && 表示日 != null && 名簿登録日 != null && 表示日.isBefore(名簿登録日)) {
                        flag = false;
                    }

                    return flag;
                }
            },
    /**
     * 関連チェック 、登録停止日・登録日チェック
     */
    登録停止日と登録日チェック {

                @Override
                public boolean apply(ShikakuJohoDiv div) {
                    boolean flag = true;
                    RDate 登録停止日 = div.getTxtTorokuTeishiYMD().getValue();
                    RDate 名簿登録日 = div.getTxtMeiboTorokuYMD().getValue();

                    boolean 登録停止日の状態14 = div.getTxtTorokuTeishiYMD().isDisplayNone();
                    boolean 名簿登録日の状態14 = div.getTxtMeiboTorokuYMD().isDisplayNone();

                    if (!登録停止日の状態14 && !名簿登録日の状態14 && 登録停止日 != null && 名簿登録日 != null && 登録停止日.isBefore(名簿登録日)) {
                        flag = false;
                    }

                    return flag;
                }
            },
    /**
     * 関連チェック 、登録停止日・登録日チェック
     */
    名簿登録日と抹消年月日チェック {

                @Override
                public boolean apply(ShikakuJohoDiv div) {
                    boolean flag = true;
                    RDate 抹消日 = div.getTxtMasshoYMD().getValue();
                    RDate 名簿登録日 = div.getTxtMeiboTorokuYMD().getValue();
                    RString 選挙資格 = div.getRadSenkyoShikaku().getSelectedValue();

                    boolean 抹消日の状態15 = div.getTxtMasshoYMD().isDisplayNone();
                    boolean 名簿登録日の状態15 = div.getTxtMeiboTorokuYMD().isDisplayNone();

                    if (!抹消日の状態15 && !名簿登録日の状態15 && 抹消日 != null && 名簿登録日 != null && 名簿登録日.isBefore(抹消日)
                    && (選挙資格.equals(ShikakuJohoEnum.有権者.toRString()) || 選挙資格.equals(ShikakuJohoEnum.表示者.toRString()))) {
                        flag = false;
                    }

                    return flag;
                }
            },
    /**
     * 関連チェック 、抹消事由/抹消年月日入力チェック
     */
    抹消事由と抹消年月日入力チェック1 {

                @Override
                public boolean apply(ShikakuJohoDiv div) {
                    boolean flag = true;
                    RDate 抹消日 = div.getTxtMasshoYMD().getValue();
                    RString 抹消事由 = div.getCcdMasshoJiyu().getDdlJiyuNameList().getSelectedValue();

                    boolean 抹消日の状態15 = div.getTxtTorokuTeishiYMD().isDisplayNone();
                    boolean 抹消事由の状態15 = div.getCcdMasshoJiyu().isDisplayNone();

                    if (!抹消日の状態15 && !抹消事由の状態15 && 抹消日 != null && 抹消事由.isNullOrEmpty()) {
                        flag = false;
                    }

                    return flag;
                }
            },
    /**
     * 関連チェック 、抹消事由/抹消年月日入力チェック
     */
    抹消事由と抹消年月日入力チェック2 {

                @Override
                public boolean apply(ShikakuJohoDiv div) {
                    boolean flag = true;
                    RDate 抹消日 = div.getTxtMasshoYMD().getValue();

                    boolean 抹消日の状態16 = div.getTxtMasshoYMD().isDisplayNone();

                    if (!抹消日の状態16 && 抹消日 == null) {
                        flag = false;
                    }

                    return flag;
                }
            },
    /**
     * 関連チェック 、抹消事由/抹消年月日入力チェック
     */
    抹消事由と抹消年月日入力チェック3 {

                @Override
                public boolean apply(ShikakuJohoDiv div) {
                    boolean flag = true;
                    RDate 抹消日 = div.getTxtMasshoYMD().getValue();
                    RString 抹消事由 = div.getCcdMasshoJiyu().getDdlJiyuNameList().getSelectedValue();
                    RString 選挙資格 = div.getRadSenkyoShikaku().getSelectedValue();

                    boolean 抹消日の状態16 = div.getTxtMasshoYMD().isDisplayNone();
                    boolean 抹消事由の状態16 = div.getCcdMasshoJiyu().isDisplayNone();
                    if (選挙資格.equals(SennkyoSikakuKubun.抹消者.value())) {
                        if (!抹消日の状態16 && !抹消事由の状態16 && 抹消日 == null && !抹消事由.isNullOrEmpty()) {
                            flag = false;
                        } else if (!抹消日の状態16 && !抹消事由の状態16 && 抹消日 == null && 抹消事由.isNullOrEmpty()) {
                            flag = false;
                        }
                    }

                    return flag;
                }
            },
    /**
     * 関連チェック 、抹消事由/抹消年月日入力チェック
     */
    抹消事由と抹消年月日入力チェック4 {

                @Override
                public boolean apply(ShikakuJohoDiv div) {
                    boolean flag = true;
                    RDate 抹消日 = div.getTxtMasshoYMD().getValue();
                    RString 抹消事由 = div.getCcdMasshoJiyu().getDdlJiyuNameList().getSelectedValue();
                    RString 選挙資格 = div.getRadSenkyoShikaku().getSelectedValue();

                    boolean 抹消日の状態16 = div.getTxtMasshoYMD().isDisplayNone();
                    boolean 抹消事由の状態16 = div.getCcdMasshoJiyu().isDisplayNone();
                    if (選挙資格.equals(SennkyoSikakuKubun.抹消者.value())
                    && !抹消日の状態16 && !抹消事由の状態16 && 抹消日 != null && 抹消事由.isNullOrEmpty()) {
                        flag = false;
                    }
                    return flag;
                }
            },
    /**
     * 関連チェック 、抹消事由と住民種別・状態チェック１
     */
    抹消事由と住民種別と状態チェック１ {
                private final RString RST_4 = new RString("4");
                private final RString RST_1 = new RString("1");

                @Override
                public boolean apply(ShikakuJohoDiv div) {
                    boolean flag = true;
                    RString 抹消事由 = div.getCcdMasshoJiyu().getDdlJiyuNameList().getSelectedValue();
                    RString 住民種別コード = div.getTxtHdnjuminShubetsuCode();
                    RString 住民状態コード = div.getTxtHdnjuminJotaiCode();

                    boolean 抹消事由の状態17 = div.getCcdMasshoJiyu().isDisplayNone();

                    if (!抹消事由の状態17 && 抹消事由.equals(ShikakuJohoEnum.死亡.toRString()) && 住民種別コード.equals(RST_1)
                    && !住民状態コード.equals(RST_4)) {
                        flag = false;
                    }
                    return flag;
                }
            },
    /**
     * 関連チェック 、抹消事由と住民種別・状態チェック２
     */
    抹消事由と住民種別と状態チェック２ {
                private final RString RST_3 = new RString("3");
                private final RString RST_1 = new RString("1");

                @Override
                public boolean apply(ShikakuJohoDiv div) {
                    boolean flag = true;
                    RString 抹消事由 = div.getCcdMasshoJiyu().getDdlJiyuNameList().getSelectedValue();
                    RString 住民種別コード = div.getTxtHdnjuminShubetsuCode();
                    RString 住民状態コード = div.getTxtHdnjuminJotaiCode();

                    boolean 抹消事由の状態18 = div.getCcdMasshoJiyu().isDisplayNone();

                    if (!抹消事由の状態18 && 抹消事由.equals(ShikakuJohoEnum.転出4カ月経過抹消.toRString()) && 住民種別コード.equals(RST_1)
                    && !住民状態コード.equals(RST_3)) {
                        flag = false;
                    }
                    return flag;
                }
            },
    /**
     * 入力日付のチェック 、入力日付チェック５
     */
    入力日付チェック５ {

                @Override
                public boolean apply(ShikakuJohoDiv div) {
                    boolean flag = true;
                    RDate 抹消日 = div.getTxtMasshoYMD().getValue();

                    boolean 抹消日の状態19 = div.getTxtMasshoYMD().isDisplayNone();

                    if (!抹消日の状態19 && 抹消日 != null && RDate.getNowDate().isBefore(抹消日)) {
                        flag = false;
                    }
                    return flag;
                }
            },
    /**
     * 入力日付のチェック 、入力日付チェック６
     */
    入力日付チェック６ {

                @Override
                public boolean apply(ShikakuJohoDiv div) {
                    boolean flag = true;
                    RDate 抹消日 = div.getTxtMasshoYMD().getValue();
                    RDate 名簿登録日 = div.getTxtMeiboTorokuYMD().getValue();

                    boolean 抹消日の状態20 = div.getTxtMasshoYMD().isDisplayNone();
                    boolean 名簿登録日の状態20 = div.getTxtMeiboTorokuYMD().isDisplayNone();

                    if (!抹消日の状態20 && !名簿登録日の状態20 && 抹消日 != null && 名簿登録日 != null && 抹消日.isBefore(名簿登録日)) {
                        flag = false;
                    }
                    return flag;
                }
            },
    /**
     * 入力日付のチェック 、入力日付チェック７
     */
    入力日付チェック７ {

                @Override
                public boolean apply(ShikakuJohoDiv div) {
                    boolean flag = true;
                    RDate 抹消日 = div.getTxtMasshoYMD().getValue();
                    RDate 登録停止年月日 = div.getTxtTorokuTeishiYMD().getValue();

                    boolean 抹消日の状態21 = div.getTxtMasshoYMD().isDisplayNone();
                    boolean 登録停止年月日の状態21 = div.getTxtTorokuTeishiYMD().isDisplayNone();

                    if (!抹消日の状態21 && !登録停止年月日の状態21 && 抹消日 != null && 登録停止年月日 != null && 抹消日.isBefore(登録停止年月日)) {
                        flag = false;
                    }
                    return flag;
                }
            },
    /**
     * 入力日付のチェック 、入力日付チェック８
     */
    入力日付チェック８ {

                @Override
                public boolean apply(ShikakuJohoDiv div) {
                    boolean flag = true;
                    RDate 抹消日 = div.getTxtMasshoYMD().getValue();
                    RDate 表示年月日 = div.getTxtHyojiYMD().getValue();

                    boolean 抹消日の状態22 = div.getTxtMasshoYMD().isDisplayNone();
                    boolean 表示年月日の状態22 = div.getTxtHyojiYMD().isDisplayNone();

                    if (!抹消日の状態22 && !表示年月日の状態22 && 抹消日 != null && 表示年月日 != null && 抹消日.isBefore(表示年月日)) {
                        flag = false;
                    }
                    return flag;
                }
            },
    /**
     * 抹消異動日関連チェック 、抹消異動日関連チェック１
     */
    抹消異動日関連チェック１ {

                @Override
                public boolean apply(ShikakuJohoDiv div) {
                    boolean flag = true;
                    RDate 抹消日 = div.getTxtMasshoYMD().getValue();

                    RDate 消除異動年月日 = null;
                    if (!div.getTxtHdnShojoIdoYMD().isNullOrEmpty()) {
                        消除異動年月日 = new RDate(div.getTxtHdnShojoIdoYMD().toString());
                    }
                    RDate 消除届出年月日 = null;
                    if (!div.getTxtHdnShojoTodokedeYMD().isNullOrEmpty()) {
                        消除届出年月日 = new RDate(div.getTxtHdnShojoTodokedeYMD().toString());
                    }

                    RString 抹消事由 = div.getCcdMasshoJiyu().getDdlJiyuNameList().getSelectedValue();

                    boolean 抹消日の状態23 = div.getTxtMasshoYMD().isDisplayNone();
                    boolean 抹消事由の状態23 = div.getCcdMasshoJiyu().isDisplayNone();

                    if (!抹消日の状態23 && !抹消事由の状態23 && 抹消事由 != null && 抹消事由.equals(ShikakuJohoEnum.死亡.toRString()) && 消除異動年月日 != null && 消除届出年月日 != null
                    && 消除異動年月日.plusDay(1).isBefore(消除届出年月日) && 抹消日.compareTo(消除届出年月日) != 0) {
                        flag = false;
                    }
                    return flag;
                }
            },
    /**
     * 抹消異動日関連チェック 、抹消異動日関連チェック２
     */
    抹消異動日関連チェック２ {

                @Override
                public boolean apply(ShikakuJohoDiv div) {
                    boolean flag = true;
                    RDate 抹消日 = div.getTxtMasshoYMD().getValue();
                    RDate 消除異動年月日 = null;
                    if (!div.getTxtHdnShojoIdoYMD().isNullOrEmpty()) {
                        消除異動年月日 = new RDate(div.getTxtHdnShojoIdoYMD().toString());
                    }
                    RDate 消除届出年月日 = null;
                    if (!div.getTxtHdnShojoTodokedeYMD().isNullOrEmpty()) {
                        消除届出年月日 = new RDate(div.getTxtHdnShojoTodokedeYMD().toString());
                    }

                    RString 抹消事由 = div.getCcdMasshoJiyu().getDdlJiyuNameList().getSelectedValue();

                    boolean 抹消日の状態24 = div.getTxtMasshoYMD().isDisplayNone();
                    boolean 抹消事由の状態24 = div.getCcdMasshoJiyu().isDisplayNone();

                    if (!抹消日の状態24 && !抹消事由の状態24 && 抹消事由 != null && 抹消事由.equals(ShikakuJohoEnum.死亡.toRString()) && 消除異動年月日 != null && 消除届出年月日 != null
                    && 消除届出年月日.isBeforeOrEquals(消除異動年月日.plusDay(1)) && 抹消日.compareTo(消除届出年月日.plusDay(1)) != 0) {
                        flag = false;
                    }
                    return flag;
                }
            },
    /**
     * 抹消異動日関連チェック 、抹消異動日関連チェック３
     */
    抹消異動日関連チェック３ {

                @Override
                public boolean apply(ShikakuJohoDiv div) {
                    boolean flag = true;
                    RDate 抹消日 = div.getTxtMasshoYMD().getValue();
                    RDate 消除異動年月日 = null;
                    if (!div.getTxtHdnShojoIdoYMD().isNullOrEmpty()) {
                        消除異動年月日 = new RDate(div.getTxtHdnShojoIdoYMD().toString());
                    }
                    RDate 消除届出年月日 = null;
                    if (!div.getTxtHdnShojoTodokedeYMD().isNullOrEmpty()) {
                        消除届出年月日 = new RDate(div.getTxtHdnShojoTodokedeYMD().toString());
                    }

                    RString 抹消事由 = div.getCcdMasshoJiyu().getDdlJiyuNameList().getSelectedValue();

                    boolean 抹消日の状態25 = div.getTxtMasshoYMD().isDisplayNone();
                    boolean 抹消事由の状態25 = div.getCcdMasshoJiyu().isDisplayNone();

                    if (!抹消日の状態25 && !抹消事由の状態25 && 抹消事由 != null && 抹消事由.equals(ShikakuJohoEnum.死亡.toRString()) && 消除異動年月日 == null && 消除届出年月日 != null
                    && 抹消日.compareTo(消除届出年月日.plusDay(1)) != 0) {
                        flag = false;
                    }
                    return flag;
                }
            },
    /**
     * 抹消異動日関連チェック 、抹消異動日関連チェック４
     */
    抹消異動日関連チェック４ {

                @Override
                public boolean apply(ShikakuJohoDiv div) {
                    boolean flag = true;
                    RDate 抹消日 = div.getTxtMasshoYMD().getValue();
                    RDate 消除異動年月日 = null;
                    if (!div.getTxtHdnShojoIdoYMD().isNullOrEmpty()) {
                        消除異動年月日 = new RDate(div.getTxtHdnShojoIdoYMD().toString());
                    }

                    RString 抹消事由 = div.getCcdMasshoJiyu().getDdlJiyuNameList().getSelectedValue();

                    boolean 抹消日の状態26 = div.getTxtMasshoYMD().isDisplayNone();
                    boolean 抹消事由の状態26 = div.getCcdMasshoJiyu().isDisplayNone();

                    if (!抹消日の状態26 && !抹消事由の状態26 && 抹消事由 != null && 抹消事由.equals(ShikakuJohoEnum.国籍喪失.toRString()) && 消除異動年月日 != null
                    && 抹消日 != null && 抹消日.compareTo(消除異動年月日.plusDay(1)) != 0) {
                        flag = false;
                    }
                    return flag;
                }
            },
    /**
     * 抹消異動日関連チェック 、抹消異動日関連チェック５
     */
    抹消異動日関連チェック５ {

                @Override
                public boolean apply(ShikakuJohoDiv div) {
                    boolean flag = true;
                    RDate 抹消日 = div.getTxtMasshoYMD().getValue();
                    RDate 消除異動年月日 = null;
                    if (!div.getTxtHdnShojoIdoYMD().isNullOrEmpty()) {
                        消除異動年月日 = new RDate(div.getTxtHdnShojoIdoYMD().toString());
                    }

                    RString 抹消事由 = div.getCcdMasshoJiyu().getDdlJiyuNameList().getSelectedValue();

                    boolean 抹消日の状態27 = div.getTxtMasshoYMD().isDisplayNone();
                    boolean 抹消事由の状態27 = div.getCcdMasshoJiyu().isDisplayNone();

                    if (!抹消日の状態27 && !抹消事由の状態27 && 抹消事由 != null && 抹消事由.equals(ShikakuJohoEnum.転出4カ月経過抹消.toRString()) && 消除異動年月日 != null
                    && 抹消日 != null && 抹消日.compareTo(消除異動年月日.plusMonth(4).plusDay(1)) != 0) {
                        flag = false;
                    }
                    return flag;
                }
            },
    /**
     * 年齢未満チェック
     */
    年齢未満チェック {

                @Override
                public boolean apply(ShikakuJohoDiv div) {
                    RDate 生年月日 = new RDate(div.getTxtHdnSeinengappiYMD().isNullOrEmpty() ? null
                            : div.getTxtHdnSeinengappiYMD().toString());
                    if (div.getTxtHdnSeinengappiYMD().isNullOrEmpty()) {
                        return false;
                    }
                    RString 選挙資格到達年齢 = BusinessConfig.get(ConfigKeysAFA.選挙資格到達年齢, RDate.getNowDate(), SubGyomuCode.AFA選挙本体);
                    return !RDate.getNowDate().isBefore(生年月日.minusDay(1).plusYear(Integer.valueOf(選挙資格到達年齢.toString())));
                }
            },
    /**
     * 外国人チェック
     */
    外国人チェック {

                private final RString RST_2 = new RString("2");

                @Override
                public boolean apply(ShikakuJohoDiv div) {
                    RString 住民種別コード = div.getTxtHdnjuminShubetsuCode();
                    return !(null != 住民種別コード && 住民種別コード.equals(RST_2));
                }
            },
    /**
     * 住登外チェック
     */
    住登外チェック {
                private final RString RST_1 = new RString("1");
                private final RString RST_2 = new RString("2");

                @Override
                public boolean apply(ShikakuJohoDiv div) {
                    RString 住民種別コード = div.getTxtHdnjuminShubetsuCode();
                    return !(null != 住民種別コード && (!住民種別コード.equals(RST_1) && !住民種別コード.equals(RST_2)));
                }
            };
}
