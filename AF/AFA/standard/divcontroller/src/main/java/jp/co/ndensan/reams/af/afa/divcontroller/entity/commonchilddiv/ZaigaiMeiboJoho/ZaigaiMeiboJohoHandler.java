/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ZaigaiMeiboJoho;

import java.util.ArrayList;
import jp.co.ndensan.reams.af.afa.business.core.meibotorokuzaigai.ZaigaiSenkyoninJohoResult;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuKubun;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT122ZaigaiSenkyoShikakuEntity;
import jp.co.ndensan.reams.af.afa.entity.db.basic.AfT123ZaigaiSenkyoninJushoEntity;
import jp.co.ndensan.reams.af.afa.service.core.MeibotorokuZaigai;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 在外名簿情報共有子DIVに対するコントローラです。
 *
 * @reamsid_L AF-0320-013 xul
 */
public class ZaigaiMeiboJohoHandler {

    private final ZaigaiMeiboJohoDiv div;
    private final RString 通常選挙のメニュー = new RString("AFAMNB3");
    private final RString 国民投票のメニュー = new RString("AFAMNG3");
    private final RString 在外選挙人名簿情報 = new RString("在外選挙人名簿情報");
    private final RString 在外投票人名簿情報 = new RString("在外投票人名簿情報");
    private final RString 表示事由_国内転入 = new RString("国内転入");
    private final RString インデックス_無 = new RString("0");
    private final RString インデックス_有 = new RString("1");

    /**
     * コンストラクタです。
     *
     * @param div 在外名簿情報共有子DIV
     */
    public ZaigaiMeiboJohoHandler(ZaigaiMeiboJohoDiv div) {
        this.div = div;
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param 申請番号 RString
     * @param 識別コード ShikibetsuCode
     */
    public void initialize(RString 申請番号, ShikibetsuCode 識別コード) {
        RString menuID = ResponseHolder.getMenuID();
        this.set画面制御(menuID);
        if (RString.isNullOrEmpty(申請番号)) {
            this.set全て項目空白();
        } else {
            ZaigaiSenkyoninJohoResult result = MeibotorokuZaigai.createInstance()
                    .get在外選挙人情報のデータ(Integer.valueOf(申請番号.toString()), 識別コード);
            edit画面表示(result);
        }
        if (!RString.isNullOrEmpty(menuID)) {
            if (menuID.startsWith(通常選挙のメニュー)) {
                div.setTitle(在外選挙人名簿情報);
            }
            if (menuID.startsWith(国民投票のメニュー)) {
                div.setTitle(在外投票人名簿情報);
            }
        }
    }

    /**
     * 表示事由ドロップダウンのclickのイベントメソッドです。
     *
     */
    public void onChange_ddlJiyuName() {
        set国内転入活性制御();
    }

    private void set画面制御(RString menuID) {
        set画面制御_非活性();
        if (!RString.isNullOrEmpty(menuID)) {
            if (menuID.startsWith(通常選挙のメニュー)) {
                div.getCcdShohonNameList().setDisplayNoneMode(Boolean.TRUE);
            }
            if (menuID.startsWith(国民投票のメニュー)) {
                div.getCcdShohonNameList().setDisplayNoneMode(Boolean.FALSE);
            }
        }
        if (AFAMenuId.AFAMNB3010_名簿登録.menuId().equals(menuID)
                || AFAMenuId.AFAMNG3010_名簿登録.menuId().equals(menuID)) {
            div.getRadZaigaiShikaku().setDisabled(Boolean.FALSE);
            div.getCcdTohyokuCode().getTxtTohyokuCode().setDisabled(Boolean.FALSE);
            div.getTxtTorokuYMD().setDisabled(Boolean.FALSE);
            div.getTxtHyojiYMD().setDisabled(Boolean.FALSE);
            div.getCcdHyojiJiyu().setDisabledMode(Boolean.FALSE);
        }
        if (AFAMenuId.AFAMNB3020_証明書記載事項変更.menuId().equals(menuID)
                || AFAMenuId.AFAMNG3020_証明書記載事項変更.menuId().equals(menuID)
                || AFAMenuId.AFAMNB3030_証明書再交付.menuId().equals(menuID)
                || AFAMenuId.AFAMNG3030_証明書再交付.menuId().equals(menuID)) {
            div.getTxtShuseiYMD().setDisabled(Boolean.FALSE);
            div.getCcdTohyokuCode().setReadOnlyMode(Boolean.TRUE);
        }
        if (AFAMenuId.AFAMNB3040_名簿抹消.menuId().equals(menuID)
                || AFAMenuId.AFAMNG3040_名簿抹消.menuId().equals(menuID)) {
            div.getRadZaigaiShikaku().setDisabled(Boolean.FALSE);
            div.getTxtMasshoYMD().setDisabled(Boolean.FALSE);
            div.getCcdMasshoJiyu().setDisabledMode(Boolean.FALSE);
            div.getCcdTohyokuCode().setReadOnlyMode(Boolean.TRUE);
        }
        if (AFAMenuId.AFAMNB3050_選挙人名簿修正.menuId().equals(menuID)
                || AFAMenuId.AFAMNG3050_投票人名簿修正.menuId().equals(menuID)) {
            div.getTxtHyojiYMD().setDisabled(Boolean.FALSE);
            div.getCcdHyojiJiyu().setDisabledMode(Boolean.FALSE);
            div.getCcdTohyokuCode().setReadOnlyMode(Boolean.TRUE);
        }
    }

    private void set画面制御_非活性() {
        div.getRadZaigaiShikaku().setDisabled(Boolean.TRUE);
        div.getCcdTohyokuCode().getTxtTohyokuCode().setDisabled(Boolean.TRUE);
        div.getTxtTorokuYMD().setDisabled(Boolean.TRUE);
        div.getTxtHyojiYMD().setDisabled(Boolean.TRUE);
        div.getCcdHyojiJiyu().setDisabledMode(Boolean.TRUE);
        div.getTxtMasshoYMD().setDisabled(Boolean.TRUE);
        div.getCcdMasshoJiyu().setDisabledMode(Boolean.TRUE);
        div.getTxtShuseiYMD().setDisabled(Boolean.TRUE);
    }

    private void set全て項目空白() {
        set画面項目_在外選挙人資格無し();
        set画面項目_在外選挙人住所情報無し();
    }

    private void set画面項目_在外選挙人資格無し() {
        div.getCcdShohonNameList().clear();
        div.getRadZaigaiShikaku().clearSelectedItem();
        div.getCcdTohyokuCode().clear();
        div.getTxtTorokuYMD().clearValue();
        div.getTxtHyojiYMD().clearValue();
        div.getTxtMasshoYMD().clearValue();
        div.getCcdMasshoJiyu().clear();
        div.getTxtShuseiYMD().clearValue();
        div.getCcdHyojiJiyu().getDdlJiyuNameList().setDataSource(new ArrayList<KeyValueDataSource>());
        div.getCcdMasshoJiyu().getDdlJiyuNameList().setDataSource(new ArrayList<KeyValueDataSource>());
        div.setHdnKokuminTohyoKubun(RString.EMPTY);
    }

    private void set画面項目_在外選挙人住所情報無し() {
        div.getCcdKokunaiTennyuJusho().clear();
        div.getCcdKokunaiTennyuBanchi().clear();
        div.getCcdKokunaiTennyuKatagaki().clear();
        div.getTxtKokunaiTennyuYMD().clearValue();
    }

    private void set画面項目_在外選挙人資格あり(AfT122ZaigaiSenkyoShikakuEntity 在外選挙資格) {
        Code 選挙資格区分 = 在外選挙資格.getShikakuKubun();
        if (null == 選挙資格区分) {
            div.getRadZaigaiShikaku().clearSelectedItem();
        } else if (SennkyoSikakuKubun.資格なし.value().equals(選挙資格区分.getColumnValue())
                || SennkyoSikakuKubun.抹消者.value().equals(選挙資格区分.getColumnValue())) {
            div.getRadZaigaiShikaku().setSelectedKey(インデックス_無);
        } else {
            div.getRadZaigaiShikaku().setSelectedKey(インデックス_有);
        }
        RString 投票区コード = 在外選挙資格.getTohyokuCode();
        div.getCcdTohyokuCode().initialize(投票区コード);
        FlexibleDate 名簿登録年月日 = 在外選挙資格.getMeiboTorokuYMD();
        div.getTxtTorokuYMD().setValue(null == 名簿登録年月日 || 名簿登録年月日.isEmpty() ? null : new RDate(名簿登録年月日.toString()));
        FlexibleDate 表示年月日 = 在外選挙資格.getHyojiYMD();
        div.getTxtHyojiYMD().setValue(null == 表示年月日 || 表示年月日.isEmpty() ? null : new RDate(表示年月日.toString()));
        Code 表示事由コード = 在外選挙資格.getHyojiJiyuCode();
        if (null == 表示事由コード) {
            表示事由コード = Code.EMPTY;
        }
        div.getCcdHyojiJiyu().initialize(AFACodeShubetsu.表示事由コード_在外.getCodeShubetsu(), true);
        div.getCcdHyojiJiyu().initialize(表示事由コード);
        FlexibleDate 抹消年月日 = 在外選挙資格.getMasshoYMD();
        div.getTxtMasshoYMD().setValue(null == 抹消年月日 || 抹消年月日.isEmpty() ? null : new RDate(抹消年月日.toString()));
        if (!div.getCcdShohonNameList().isDisplayNoneMode()) {
            div.getCcdMasshoJiyu().initialize(AFACodeShubetsu.抹消事由コード_国民.getCodeShubetsu(), true);
        } else {
            div.getCcdMasshoJiyu().initialize(AFACodeShubetsu.抹消事由コード_在外.getCodeShubetsu(), true);
        }
        Code 抹消事由コード = 在外選挙資格.getMasshoJiyuCode();
        if (null == 抹消事由コード) {
            抹消事由コード = Code.EMPTY;
        }
        div.getCcdMasshoJiyu().initialize(抹消事由コード);
        FlexibleDate 修正年月日 = 在外選挙資格.getShuseiYMD();
        div.getTxtShuseiYMD().setValue(null == 修正年月日 || 修正年月日.isEmpty() ? null : new RDate(修正年月日.toString()));
        div.getTxtBiko().setValue(在外選挙資格.getTokkiJiko());
        Code code = 在外選挙資格.getKokuminTohyoKubun();
        div.setHdnKokuminTohyoKubun(null == code || code.isEmpty()
                ? RString.EMPTY : code.getColumnValue());
    }

    private void set画面項目_在外選挙人住所情報あり(AfT123ZaigaiSenkyoninJushoEntity 在外選挙人住所情報_国内転入先住所) {
        div.getCcdKokunaiTennyuJusho().load(在外選挙人住所情報_国内転入先住所.getZenkokuJushoCode(),
                在外選挙人住所情報_国内転入先住所.getYubinNo());
        div.getCcdKokunaiTennyuBanchi().load(在外選挙人住所情報_国内転入先住所.getBanchi());
        div.getCcdKokunaiTennyuKatagaki().load(在外選挙人住所情報_国内転入先住所.getKatagaki());
        FlexibleDate 国内転入年月日 = 在外選挙人住所情報_国内転入先住所.getKokunaiTennyuYMD();
        div.getTxtKokunaiTennyuYMD().setValue(null == 国内転入年月日 || 国内転入年月日.isEmpty() ? null : new RDate(国内転入年月日.toString()));
    }

    private void edit画面表示(ZaigaiSenkyoninJohoResult result) {
        ViewState.setメニューID(ResponseHolder.getMenuID());
        div.getCcdShohonNameList().initialize(SenkyoShurui.憲法改正国民投票);
        set国内転入活性制御();
        if (null == result.get在外選挙資格()) {
            set画面項目_在外選挙人資格無し();
        } else {
            set画面項目_在外選挙人資格あり(result.get在外選挙資格());
        }
        if (null == result.get在外選挙人住所情報_国内転入先住所()) {
            set画面項目_在外選挙人住所情報無し();
        } else {
            set画面項目_在外選挙人住所情報あり(result.get在外選挙人住所情報_国内転入先住所());
        }
    }

    private void set国内転入活性制御() {
        if (表示事由_国内転入.equals(div.getCcdHyojiJiyu().getDdlJiyuNameList().getSelectedValue())
                && !div.getCcdHyojiJiyu().getDdlJiyuNameList().isDisabled()) {
            div.getCcdKokunaiTennyuJusho().setDisabled(false);
            div.getCcdKokunaiTennyuKatagaki().setDisabled(false);
            div.getCcdKokunaiTennyuBanchi().setDisabled(false);
            div.getTxtKokunaiTennyuYMD().setDisabled(false);
        } else {
            div.getCcdKokunaiTennyuJusho().setDisabled(true);
            div.getCcdKokunaiTennyuKatagaki().setDisabled(true);
            div.getCcdKokunaiTennyuBanchi().setDisabled(true);
            div.getTxtKokunaiTennyuYMD().setDisabled(true);
        }
    }

    /**
     * 共有子Divの表示状態（表示／非表示）モードを設定します。
     *
     * @param displayNoneSetMode 表示状態（表示／非表示）
     */
    public void setDisplayNoneMode(Boolean displayNoneSetMode) {
        div.setDisplayNone(displayNoneSetMode);
    }

    /**
     * 共有子Divの書込み状態モードを設定します。
     *
     * @param readOnlySetMode
     */
    public void setReadOnlyMode(Boolean readOnlySetMode) {
        div.setReadOnly(readOnlySetMode);
    }

    /**
     * 共有子Divの書込み状態モードを設定します。
     *
     * @param isOpenSetMode
     */
    public void setIsOpenMode(Boolean isOpenSetMode) {
        div.setIsOpen(isOpenSetMode);
    }
}
