/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMG1010;

import jp.co.ndensan.reams.af.afa.definition.batchprm.kokuminTohyoji.AFABTG101BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.core.ShoriShubetsu;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMG1010.KokuminTohyojiTorokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMG1010.KokuminTohyojiTorokuHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMG1010.KokuminTohyojiTorokuValidationHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.ur.urz.definition.core.view.DisplayMode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * AFAGMG1010　国民投票時登録 <br />
 * KokuminTohyojiTorokuDivに対応するコントローラです。
 *
 * @author N1823 有澤 礼恵
 * @reamsid_L AF-0360-010 fulc
 */
public class KokuminTohyojiToroku {

    private static final RString 再処理可能な = new RString("再処理可能な");

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param mainPanel KokuminTohyojiTorokuDiv
     * @return ResponseData<KokuminTohyojiTorokuDiv>
     */
    public ResponseData<KokuminTohyojiTorokuDiv> onLoad(KokuminTohyojiTorokuDiv mainPanel) {
        ViewState.setメニューID(ResponseHolder.getMenuID());
        mainPanel.getCcdKokuminTohyojiMeiboKijun().initialize(DisplayMode.新規);
        KokuminTohyojiNyuryoku.setData(mainPanel, RString.EMPTY);
        mainPanel.getCcdKokuminTohyojiSakuseiChohyo().initialize();

        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 抄本ドロップダウンリストを選択時のイベントメソッドです。
     *
     * @param mainPanel KokuminTohyojiTorokuDiv
     * @return ResponseData<KokuminTohyojiTorokuDiv>
     */
    public ResponseData<KokuminTohyojiTorokuDiv> onChange_ccdShohonNameList(KokuminTohyojiTorokuDiv mainPanel) {

        mainPanel.getCcdKokuminTohyojiMeiboKijun().initialSetting();

        KokuminTohyojiNyuryoku.setData(mainPanel,
                mainPanel.getCcdKokuminTohyojiMeiboKijun().getCcdShohonNameList().getSelectedShohonNo());

        if (mainPanel.getCcdKokuminTohyojiMeiboKijun().getCcdShohonNameList().getSelectedShohonNo().isEmpty()) {
            mainPanel.getCcdKokuminTohyojiSakuseiChohyo().clearData();
        } else {
            mainPanel.getCcdKokuminTohyojiSakuseiChohyo().initialize();
        }
        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 新規処理と再処理のラジオボタンクリック時のイベントメソッドです。
     *
     * @param mainPanel KokuminTohyojiTorokuDiv
     * @return ResponseData<KokuminTohyojiTorokuDiv>
     */
    public ResponseData<KokuminTohyojiTorokuDiv> onClick_radShori(KokuminTohyojiTorokuDiv mainPanel) {

        if (!ResponseHolder.isReRequest()) {
            mainPanel.getCcdKokuminTohyojiMeiboKijun().clickRadShori();
            if (!ShoriShubetsu.新規登録.getShoriShubetsu().equals(mainPanel.getCcdKokuminTohyojiMeiboKijun().getShoriMode()) && mainPanel.getCcdKokuminTohyojiMeiboKijun().getCcdShohonNameList().getShohonListSize() == 0) {
                return ResponseData.of(mainPanel).addMessage(
                        UrInformationMessages.該当データなし_データ内容.getMessage().replace(再処理可能な.toString())).respond();
            }
        }

        KokuminTohyojiNyuryoku.setData(mainPanel,
                mainPanel.getCcdKokuminTohyojiMeiboKijun().getCcdShohonNameList().getSelectedShohonNo());

        if (mainPanel.getCcdKokuminTohyojiMeiboKijun().getCcdShohonNameList().getSelectedShohonNo().isEmpty()) {
            mainPanel.getCcdKokuminTohyojiSakuseiChohyo().clearData();
        } else {
            mainPanel.getCcdKokuminTohyojiSakuseiChohyo().initialize();
        }
        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 帳票条件設定ボタンクリック時のイベントメソッドです。
     *
     * @param mainPanel KokuminTohyojiTorokuDiv
     * @return ResponseData<KokuminTohyojiTorokuDiv>
     */
    public ResponseData<KokuminTohyojiTorokuDiv> onClick_btnSetChohyoYmd(KokuminTohyojiTorokuDiv mainPanel) {
        ValidationMessageControlPairs controlErrorPairs_div = mainPanel.getCcdKokuminTohyojiMeiboKijun().setChohyoYmdチェックです();
        if (controlErrorPairs_div.existsError()) {
            return ResponseData.of(mainPanel).addValidationMessages(controlErrorPairs_div).respond();
        }
        KokuminTohyojiTorokuHandler.of(mainPanel).set画面状態();
        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 実行ボタン押下時のイベントメソッドです。
     *
     * @param mainPanel KokuminTohyojiTorokuDiv
     * @return ResponseData<AFABTG101BatchParameter>
     */
    public ResponseData<AFABTG101BatchParameter> onClick_btnExecute(KokuminTohyojiTorokuDiv mainPanel) {
        AFABTG101BatchParameter parm = KokuminTohyojiTorokuHandler.of(mainPanel).setBatchParameter();
        return ResponseData.of(parm).respond();
    }

    /**
     * 実行ボタン押下時のイベントメソッドです 。
     *
     * @param mainPanel KokuminTohyojiTorokuDiv
     * @return ResponseData<KokuminTohyojiTorokuDiv>
     */
    public ResponseData<KokuminTohyojiTorokuDiv> onClick_btnBatchCheck(KokuminTohyojiTorokuDiv mainPanel) {
        ValidationMessageControlPairs controlErrorPairs = new KokuminTohyojiTorokuValidationHandler(mainPanel).validateエラーチェックです();
        ValidationMessageControlPairs controlErrorPairs_div = mainPanel.getCcdKokuminTohyojiMeiboKijun().エラーチェックです();
        controlErrorPairs.add(mainPanel.getCcdKokuminTohyojiSakuseiChohyo().validate時点日());
        controlErrorPairs.add(controlErrorPairs_div);
        if (controlErrorPairs.existsError()) {
            return ResponseData.of(mainPanel).addValidationMessages(controlErrorPairs).respond();
        }
        if (!ResponseHolder.isWarningIgnoredRequest()) {

            ValidationMessageControlPairs controlWarningPairs = new KokuminTohyojiTorokuValidationHandler(mainPanel).validateウォーニングチェックです();
            ValidationMessageControlPairs controlWarningPairs_div = mainPanel.getCcdKokuminTohyojiMeiboKijun().ウォーニングチェックです();
            controlWarningPairs.add(controlWarningPairs_div);
            if (controlWarningPairs.existsError()) {
                return ResponseData.of(mainPanel).addValidationMessages(controlWarningPairs).respond();
            }
        }

        return ResponseData.of(mainPanel).respond();
    }
}
