/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SakuseiChohyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.definition.configkeys.ConfigKeysAFA;
import jp.co.ndensan.reams.af.afa.definition.core.AFACodeShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AFAMenuId;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.InnjiFlg;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv.SakuseiChohyoIdoKikaMeibo;
import jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv.SakuseiChohyoIdoMasshoshaMeibo;
import jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv.SakuseiChohyoNijuChosahyo;
import jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv.SakuseiChohyoNijuTorokuTsuchi;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.CodeMasterHelper;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.af.afa.service.core.teijitouroku.TeijiTourokuCyohyoSeitei;
import jp.co.ndensan.reams.af.afa.service.senkyojitouroku.SenkyojiTourokuFinder;
import jp.co.ndensan.reams.af.afa.service.teijitouroku.TeijiTourokuFinder;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * SakuseiChohyoDiv の操作を担当するクラスです。
 * <p>
 * このクラスを通してSakuseiChohyoDivの入力可否、表示・非表示の制御を行ったり、情報を受け取ったりすることができます。
 * </p>
 *
 * @author N1823 有澤 礼恵
 */
public class SakuseiChohyoHandler {

    private final SakuseiChohyoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 作成帳票Div
     */
    public SakuseiChohyoHandler(SakuseiChohyoDiv div) {
        this.div = div;
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param senkyoShurui SenkyoShurui
     */
    public void initialize(SenkyoShurui senkyoShurui) {

        if (senkyoShurui == SenkyoShurui.定時登録) {
            div.getSakuseiChohyoNijuChosahyo().setDisplayNone(Boolean.TRUE);
            div.getSakuseiChohyoIdoMasshoYoteishaMeibo().setDisplayNone(Boolean.TRUE);
            div.getSakuseiChohyoIdoShikkenshaMeibo().setDisplayNone(Boolean.TRUE);
            div.getSakuseiChohyoIdoHyojiShojoYoteishaMeibo().setDisplayNone(Boolean.TRUE);
            div.getSakuseiChohyoZaigai().getSakuseiChohyoZaigaiTohyoKanrihyo().setDisplayNone(Boolean.TRUE);
        } else {
            div.getSakuseiChohyoIdo19saishaMeibo().setDisplayNone(Boolean.TRUE);
        }
        this.initialize_ChildDiv(senkyoShurui);
        this.set共通制御();
    }

    /**
     * 帳票再作成（定時）で、抄本が選択された時のメソッドです。
     *
     * @param senkyoShurui SenkyoShurui
     * @param shohonNo RString
     */
    public void initialize(SenkyoShurui senkyoShurui, RString shohonNo) {
//        HashMap targetData = get抄本情報(senkyoShurui, shohonNo);
//
//        clearData();
//        SakuseiChohyoNijuTorokuTsuchi.setData(div.getSakuseiChohyoNijuTorokuTsuchi(), targetData.get("転入期限年月日").toString());
//        SakuseiChohyoNijuChosahyo.setData(div.getSakuseiChohyoNijuChosahyo(), targetData.get("転出期限年月日").toString());
//        SakuseiChohyoIdoMasshoshaMeibo.setData(div.getSakuseiChohyoIdoMasshoshaMeibo(), targetData.get("処理年月日").toString());
//        SakuseiChohyoIdoKikaMeibo.setData(div.getSakuseiChohyoIdoKikaMeibo());

    }

    /**
     * 定時登録、選挙時登録画面で、帳票条件設定ボタンクリック時に呼ばれるメソッドです。<br />
     * 帳票再作成（選挙時）で、抄本が選択された時のメソッドです。
     *
     * @param tennyuKigenYmd RDate
     * @param tenshutsuKigenYmd RDate
     * @param kijunKigenYmd RDate
     * @param shoriYmd RDate
     */
    public void initialize(RDate tennyuKigenYmd, RDate tenshutsuKigenYmd, RDate kijunKigenYmd, RDate shoriYmd) {
        this.clearYmd();
        RString menuID = ViewState.getメニューID();
        TeijiTourokuCyohyoSeitei seiTei;
        if (AFAMenuId.AFAMNA1010_定時登録.menuId().equals(menuID) || AFAMenuId.AFAMNA1030_帳票再発行.menuId().equals(menuID)) {
            TeijiTourokuFinder teijiFinder = TeijiTourokuFinder.createInstance();
            seiTei = teijiFinder.cyouhyouJyoukenSet(this.getRDateToFlexibleDate(kijunKigenYmd),
                    this.getRDateToFlexibleDate(tennyuKigenYmd));
        } else {
            SenkyojiTourokuFinder senkyojiFinder = SenkyojiTourokuFinder.createInstance();
            if (null != kijunKigenYmd && null != tennyuKigenYmd && null != tenshutsuKigenYmd) {
                seiTei = senkyojiFinder.calcChouhyoDateInfo(kijunKigenYmd, tennyuKigenYmd, tenshutsuKigenYmd);
            } else {
                seiTei = null;
            }
        }
        if (null == seiTei) {
            return;
        }
        if (null != seiTei.get転入期間From() && !seiTei.get転入期間From().isEmpty()) {
            div.getSakuseiChohyoNijuTorokuTsuchi().getTxtTennyuKikan().setFromValue(
                    this.getFlexibleDateToRDate(seiTei.get転入期間From()));
        }
        if (null != seiTei.get転入期間To() && !seiTei.get転入期間To().isEmpty()) {
            div.getSakuseiChohyoNijuTorokuTsuchi().getTxtTennyuKikan().setToValue(
                    this.getFlexibleDateToRDate(seiTei.get転入期間To()));
        }
        if (null != seiTei.get帰化期間From() && !seiTei.get帰化期間From().isEmpty()) {
            div.getSakuseiChohyoIdoKikaMeibo().getTxtKikaKikan().setFromValue(
                    this.getFlexibleDateToRDate(seiTei.get帰化期間From()));
        }
        if (null != seiTei.get帰化期間To() && !seiTei.get帰化期間To().isEmpty()) {
            div.getSakuseiChohyoIdoKikaMeibo().getTxtKikaKikan().setToValue(
                    this.getFlexibleDateToRDate(seiTei.get帰化期間To()));
        }
        if (!div.getSakuseiChohyoNijuChosahyo().isDisplayNone() && null != tenshutsuKigenYmd && null != tennyuKigenYmd) {
            div.getSakuseiChohyoNijuChosahyo().getTxtTenshutsuKikan().setFromValue(
                    new RDate(tenshutsuKigenYmd.wareki().toDateString().toString()));
            div.getSakuseiChohyoNijuChosahyo().getTxtTenshutsuKikan().setToValue(new RDate(tennyuKigenYmd.wareki().toDateString().toString()));
        }

    }

    private RDate getFlexibleDateToRDate(FlexibleDate date) {
        return new RDate(date.getYearValue(), date.getMonthValue(), date.getDayValue());
    }

    private FlexibleDate getRDateToFlexibleDate(RDate date) {
        if (null != date) {
            return new FlexibleDate(date.getYearValue(), date.getMonthValue(), date.getDayValue());
        } else {
            return FlexibleDate.EMPTY;
        }
    }

    private void set共通制御() {
        div.getSakuseiChohyoZaigai().setDisplayNone(InnjiFlg.印字しない.value().equals(this.getConfigValue(ConfigKeysAFA.在外_関連帳票表示有無)));
        List<PanelPublish> list = this.getAllPanelPublish();
        for (PanelPublish panel : list) {
            if (!panel.isDisplayNone()) {
                this.setPanelPublish(panel, ConfigKeysAFA.toValue(new RString("帳票出力初期値_").concat(panel.getTitle()).concat(this.getメニュー())));
            }
        }

    }

    private List<PanelPublish> getAllPanelPublish() {
        List<PanelPublish> list = new ArrayList<>();
        list.add(div.getSakuseiChohyoSenkyoninMeiboShohon());
        list.add(div.getSakuseiChohyoEikyuSenkyoninMeibo());
        list.add(div.getSakuseiChohyoSenkyoninMeiboSakuinbo());
        list.add(div.getSakuseiChohyoTorokushasuList());
        list.add(div.getSakuseiChohyoYukenshasuList());
        list.add(div.getSakuseiChohyoNijuTorokuTsuchi());
        list.add(div.getSakuseiChohyoNijuChosahyo());
        list.add(div.getSakuseiChohyoIdoTorokushaMeibo());
        list.add(div.getSakuseiChohyoIdoKikaMeibo());
        list.add(div.getSakuseiChohyoIdoMasshoshaMeibo());
        list.add(div.getSakuseiChohyoIdoGakuseiMasshoshaMeibo());
        list.add(div.getSakuseiChohyoIdoMasshoYoteishaMeibo());
        list.add(div.getSakuseiChohyoIdoShikkenshaMeibo());
        list.add(div.getSakuseiChohyoIdoHyojishaMeibo());
        list.add(div.getSakuseiChohyoIdoHyojiShojoshaMeibo());
        list.add(div.getSakuseiChohyoIdoHyojiShojoYoteishaMeibo());
        list.add(div.getSakuseiChohyoIdo19saishaMeibo());
        list.add(div.getSakuseiChohyoIdoMiseinenshaMeibo());
        list.add(div.getSakuseiChohyoIdoSaiTennyushaMeibo());
        list.add(div.getSakuseiChohyoIdoTeiseishaMeibo());
        list.add(div.getSakuseiChohyoIdoTenshutsushaMeibo());
        list.add(div.getSakuseiChohyoIdoTeishishaMeibo());
        list.add(div.getSakuseiChohyoZaigai().getSakuseiChohyoZaigaiSenkyoninMeiboShohon());
        list.add(div.getSakuseiChohyoZaigai().getSakuseiChohyoZaigaiShikakushaMeibo());
        list.add(div.getSakuseiChohyoZaigai().getSakuseiChohyoZaigaiTohyoKanrihyo());
        return list;
    }

    private void setPanelPublish(PanelPublish div, ConfigKeysAFA key) {
        div.setIsPublish(InnjiFlg.印字する.value().equals(this.getConfigValue(key)));
        div.setIsOpen(false);
    }

    private RString getConfigValue(ConfigKeysAFA key) {
        return BusinessConfig.get(key, SubGyomuCode.AFA選挙本体);
    }

    private void initialize_ChildDiv(SenkyoShurui senkyoShurui) {
        div.getSakuseiChohyoNijuTorokuTsuchi().getCcdPrintNaiyoNijuTsuchi().initialize(new RString("二重登録通知"));
        div.getSakuseiChohyoNijuChosahyo().getCcdPrintNaiyoNijuChosa().initialize(new RString("二重登録調査"));
        div.getSakuseiChohyoEikyuSenkyoninMeibo().getDdlEikyuMeiboIdoJiyu()
                .setDataSource(CodeMasterHelper.createDataSource(AFACodeShubetsu.永久選挙人名簿異動条件指定.getCodeShubetsu(), Boolean.TRUE));
        div.getSakuseiChohyoEikyuSenkyoninMeibo().getDdlEikyuMeiboIdoJiyu().setSelectedIndex(0);
        div.getSakuseiChohyoSenkyoninMeiboShohon().getCcdTohyokuCodeRange().initialize(senkyoShurui);
    }

    public ValidationMessageControlPairs get入力チェック() {
        ValidationMessageControlPairs pairs = new SakuseiChohyoValidationHandler(div).validate必須項目();
        if (div.getSakuseiChohyoSenkyoninMeiboShohon().isIsPublish()) {
            pairs.add(div.getSakuseiChohyoSenkyoninMeiboShohon().getCcdTohyokuCodeRange().関係チェック());
        }
        return pairs;
    }

    private void clearYmd() {
        div.getSakuseiChohyoNijuTorokuTsuchi().getTxtTennyuKikan().clearFromValue();
        div.getSakuseiChohyoNijuTorokuTsuchi().getTxtTennyuKikan().clearToValue();
        div.getSakuseiChohyoNijuChosahyo().getTxtTenshutsuKikan().clearFromValue();
        div.getSakuseiChohyoNijuChosahyo().getTxtTenshutsuKikan().clearToValue();
        div.getSakuseiChohyoIdoKikaMeibo().getTxtKikaKikan().clearFromValue();
        div.getSakuseiChohyoIdoKikaMeibo().getTxtKikaKikan().clearToValue();
    }

    /**
     * 各パネルの条件をクリアします。
     *
     */
    public void clearData() {
        SakuseiChohyoNijuTorokuTsuchi.clearData(div.getSakuseiChohyoNijuTorokuTsuchi());
        SakuseiChohyoNijuChosahyo.clearData(div.getSakuseiChohyoNijuChosahyo());
        SakuseiChohyoIdoMasshoshaMeibo.clearData(div.getSakuseiChohyoIdoMasshoshaMeibo());
        SakuseiChohyoIdoKikaMeibo.clearData(div.getSakuseiChohyoIdoKikaMeibo());
    }

    private RString getメニュー() {
        RString メニューID = ViewState.getメニューID();
        if (AFAMenuId.AFAMNA1010_定時登録.menuId().equals(メニューID) || AFAMenuId.AFAMNA2010_定時登録.menuId().equals(メニューID)) {
            return new RString("_定時");
        } else if (AFAMenuId.AFAMNA1030_帳票再発行.menuId().equals(メニューID)) {
            return new RString("_定時_再発行");
        } else if (AFAMenuId.AFAMNB1010_選挙時登録.menuId().equals(メニューID) || AFAMenuId.AFAMNB4010_選挙時登録.menuId().equals(メニューID)) {
            return new RString("_選挙時");
        } else {
            return new RString("_選挙時_再発行");
        }
    }

    /**
     * 出力条件のonChange処理です。
     */
    public void onChange_出力条件() {
        RString selectedValue = div.getSakuseiChohyoEikyuSenkyoninMeibo().getRadEikyuMeiboShoriKubun().getSelectedValue();
        if (selectedValue.equals(new RString("全ページ出力する"))) {
            div.getSakuseiChohyoEikyuSenkyoninMeibo().getTxtEikyuMeiboShikibetsuCode().setDisabled(Boolean.TRUE);
            div.getSakuseiChohyoEikyuSenkyoninMeibo().getTxtEikyuMeiboShiteiYmdRange().setDisabled(Boolean.TRUE);
            div.getSakuseiChohyoEikyuSenkyoninMeibo().getDdlEikyuMeiboIdoJiyu().setDisabled(Boolean.TRUE);
        } else if (selectedValue.equals(new RString("識別コード指定で出力する"))) {
            div.getSakuseiChohyoEikyuSenkyoninMeibo().getTxtEikyuMeiboShiteiYmdRange().setDisabled(Boolean.TRUE);
            div.getSakuseiChohyoEikyuSenkyoninMeibo().getDdlEikyuMeiboIdoJiyu().setDisabled(Boolean.TRUE);
            div.getSakuseiChohyoEikyuSenkyoninMeibo().getTxtEikyuMeiboShikibetsuCode().setDisabled(Boolean.FALSE);
            div.getSakuseiChohyoEikyuSenkyoninMeibo().getTxtEikyuMeiboShikibetsuCode().setRequired(Boolean.TRUE);
        } else {
            div.getSakuseiChohyoEikyuSenkyoninMeibo().getTxtEikyuMeiboShikibetsuCode().setDisabled(Boolean.TRUE);
            div.getSakuseiChohyoEikyuSenkyoninMeibo().getTxtEikyuMeiboShiteiYmdRange().setDisabled(Boolean.FALSE);
            div.getSakuseiChohyoEikyuSenkyoninMeibo().getDdlEikyuMeiboIdoJiyu().setDisabled(Boolean.FALSE);
        }
    }
}
