/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KokuminTaishoShohonJoho;

import jp.co.ndensan.reams.af.afa.business.Hitsuki;
import jp.co.ndensan.reams.af.afa.business.KokuminTohyoji;
import jp.co.ndensan.reams.af.afa.definition.core.ShoriShubetsu;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AfaSeniKey;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.AfaViewStateHolderKey;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.ur.urz.definition.core.view.DisplayMode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * KokuminTaishoShohonJoho の操作を担当するクラスです。
 * <p>
 * このクラスを通してKokuminTaishoShohonJohoの表示の制御を行ったり、情報を受け取ったりすることができます。
 * </p>
 *
 * @reamsid_L AF-0360-011 lis
 */
public class KokuminTaishoShohonJohoHandler {

    private final KokuminTaishoShohonJohoDiv div;
    private final KokuminTohyoji kokuminTohyoji;

    /**
     * コンストラクタです。
     *
     * @param div 国民投票対象抄本情報Div
     */
    public KokuminTaishoShohonJohoHandler(KokuminTaishoShohonJohoDiv div) {
        this.kokuminTohyoji = new KokuminTohyoji();
        this.div = div;
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param senkyoShurui SenkyoShurui
     */
    public void initialize(SenkyoShurui senkyoShurui) {
        clearThisPanel();
        ViewState.setメニューID(ResponseHolder.getMenuID());
        div.getCcdShohonNameList().initialize(senkyoShurui);
        div.setTxtHidShohonNo(div.getCcdShohonNameList().getSelectedShohonNo());
        set修正状態();
        if (AfaSeniKey.国民投票時登録.equals(
                ViewStateHolder.get(AfaViewStateHolderKey.遷移元画面Key, AfaSeniKey.class))) {
            div.getRadShori().setDisabled(Boolean.FALSE);
            div.getCcdShohonNameList().setDisabled(Boolean.TRUE);
            div.getCcdShohonNameList().setChkKakoShohonDisplayNoneMode(Boolean.TRUE);
            div.getTxtShohonName().setDisabled(Boolean.FALSE);
            div.getTxtTohyoYMD().setDisabled(Boolean.FALSE);
            div.getBtnSetYmd().setDisabled(Boolean.FALSE);
            div.getTxtKijunYMD().setDisabled(Boolean.FALSE);
            div.getTxtMeiboTorokuYMD().setDisabled(Boolean.FALSE);
            div.getTxtNenreiTotatsuYMD().setDisabled(Boolean.FALSE);
            div.getTxtTokuteiKigenYMD().setDisabled(Boolean.FALSE);
            div.getTxtTohyoUketsukeYMD().setDisabled(Boolean.FALSE);
            div.getBtnSetChohyoYmd().setDisabled(Boolean.FALSE);
            div.getBtnHdnChangeShohon().setDisplayNone(Boolean.TRUE);
        } else {
            div.getRadShori().setDisplayNone(Boolean.TRUE);
            div.getCcdShohonNameList().setDisabled(Boolean.FALSE);
            div.getCcdShohonNameList().setChkKakoShohonDisplayNoneMode(Boolean.TRUE);
            div.getTxtShohonName().setDisabled(Boolean.FALSE);
            div.getTxtTohyoYMD().setDisabled(Boolean.TRUE);
            div.getBtnSetYmd().setDisabled(Boolean.TRUE);
            div.getTxtKijunYMD().setDisabled(Boolean.TRUE);
            div.getTxtMeiboTorokuYMD().setDisabled(Boolean.TRUE);
            div.getTxtNenreiTotatsuYMD().setDisabled(Boolean.TRUE);
            div.getTxtTokuteiKigenYMD().setDisabled(Boolean.TRUE);
            div.getTxtTohyoUketsukeYMD().setDisabled(Boolean.TRUE);
            div.getBtnSetChohyoYmd().setDisplayNone(Boolean.TRUE);
            div.getBtnHdnChangeShohon().setDisplayNone(Boolean.TRUE);
        }
    }

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param displayMode DisplayMode
     */
    public void initialize(DisplayMode displayMode) {
        if (displayMode == DisplayMode.新規) {
            return;
        }
        if (displayMode == DisplayMode.修正) {
            div.getCcdShohonNameList().initialize(SenkyoShurui.憲法改正国民投票);
            set修正状態();
        } else {
            div.getCcdShohonNameList().initialize(SenkyoShurui.憲法改正国民投票, Boolean.FALSE);
        }

        initialSetting();
    }

    public void set修正状態() {
        div.getRadShori().setSelectedKey(ShoriShubetsu.新規登録.getShoriShubetsu());
    }

    public void set選択抄本情報() {
        RString 抄本名 = div.getCcdShohonNameList().getSelectedShohonName();
        div.getTxtShohonName().setValue(抄本名);
        RDate 投票年月日 = div.getCcdShohonNameList().getSelectedTohyoYMD();
        div.getTxtTohyoYMD().setValue(投票年月日);
        Hitsuki hitsuki = kokuminTohyoji.get日付項目_自動算出処理(投票年月日);
        div.setTxtHidShohonNo(div.getCcdShohonNameList().getSelectedShohonNo());
        if (hitsuki != null) {
            div.getTxtKijunYMD().setValue(hitsuki.get基準日());
            div.getTxtMeiboTorokuYMD().setValue(hitsuki.get名簿登録日());
            div.getTxtNenreiTotatsuYMD().setValue(hitsuki.get年齢到達日());
            div.getTxtTokuteiKigenYMD().setValue(hitsuki.get特定期限日());
            div.getTxtTohyoUketsukeYMD().setValue(hitsuki.get受付開始日());
        }
    }

    /**
     * ドロップダウンリストに抄本情報をセットするメソッドです。
     *
     */
    public void initialSetting() {

        div.getCcdShohonNameList().changeDdlShohon();
        RString selectedKey = div.getCcdShohonNameList().getSelectedShohonNo();
        div.setTxtHidShohonNo(selectedKey);
        div.setTxtHidShohonNo(selectedKey);
        if (selectedKey.equals(RString.EMPTY)) {
            clearThisPanel();
        } else {
            set選択抄本情報();
        }
    }

    /**
     * 新規処理と再処理のラジオボタン切り替え時の処理をするメソッドです。
     *
     */
    public void clickRadShori() {
        clearThisPanel();
        div.getCcdShohonNameList().setReadOnlyMode(false);
        if (ShoriShubetsu.新規登録.getShoriShubetsu().equals(div.getRadShori().getSelectedKey())) {
            div.getCcdShohonNameList().setReadOnlyMode(true);
        } else {
            div.getCcdShohonNameList().initialize(SenkyoShurui.憲法改正国民投票, Boolean.FALSE);
            if (div.getCcdShohonNameList().getShohonListSize() != 0) {
                div.getCcdShohonNameList().initialSetting();
            }
            initialSetting();
        }
    }

    /**
     * 各項目をクリアします。
     */
    public void clearThisPanel() {
        div.getCcdShohonNameList().clear();
        div.getTxtShohonName().clearValue();
        div.getTxtTohyoYMD().clearValue();
        div.getTxtKijunYMD().clearValue();
        div.getTxtMeiboTorokuYMD().clearValue();
        div.getTxtNenreiTotatsuYMD().clearValue();
        div.getTxtTokuteiKigenYMD().clearValue();
        div.getTxtTohyoUketsukeYMD().clearValue();
        div.setTxtHidShohonNo(RString.EMPTY);
    }

    /**
     * 現在の処理モードを取得します
     *
     * @return 処理モード（ラジオボタンのキー値）
     */
    public RString getShoriMode() {
        return div.getRadShori().getSelectedKey();
    }

    /**
     * エラーチェックです。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs エラーチェックです() {
        return KokuminTaishoShohonJohoValidationHandler.of(div).validateエラーチェックです();
    }

    /**
     * ウォーニングチェックです。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs ウォーニングチェックです() {
        return KokuminTaishoShohonJohoValidationHandler.of(div).validateウォーニングチェックです();
    }

    /**
     * setChohyoYmdチェックです。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs setChohyoYmdチェックです() {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        if (null == div.getTxtKijunYMD().getValue()) {
            pairs.add(new ValidationMessageControlPair(KokuminTaishoShohonJohoValidationMessage.基準日が空白, div.getTxtKijunYMD()));
        }
        if (null == div.getTxtTohyoYMD().getValue()) {
            pairs.add(new ValidationMessageControlPair(KokuminTaishoShohonJohoValidationMessage.投票日が空白, div.getTxtTohyoYMD()));
        }
        return pairs;
    }
}
