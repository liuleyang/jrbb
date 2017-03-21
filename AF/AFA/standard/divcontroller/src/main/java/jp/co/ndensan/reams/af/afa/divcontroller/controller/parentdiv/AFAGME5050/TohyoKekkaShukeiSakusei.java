/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGME5050;

import jp.co.ndensan.reams.af.afa.definition.batchprm.tohyokekkaprint.AFABTE505BatchParameter;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5050.AFAGME5050TransitionEventName;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5050.TohyoKekkaShukeiSakuseiDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME5050.TohyoKekkaShukeiSakuseiHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME5050.TohyoKekkaShukeiSakuseiValidationHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * AFAGME5050 投票結果集計表 <br />
 * TohyoKekkaShukeiSakuseiDivに対応するコントローラです。
 *
 * @reamsid_L AF-0290-010 lit
 */
public class TohyoKekkaShukeiSakusei {

    private static final RString 抄本件数エラー_処理可能な = new RString("処理可能な");

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div TohyoKekkaShukeiSakuseiDiv
     * @return ResponseData<TohyoKekkaShukeiSakuseiDiv>
     */
    public ResponseData<TohyoKekkaShukeiSakuseiDiv> onLoad(TohyoKekkaShukeiSakuseiDiv div) {
        if (ResponseHolder.isReRequest()) {
            return ResponseData.of(div).forwardWithEventName(AFAGME5050TransitionEventName.メニューへ戻る).respond();
        }
        if (!getHandler(div).initialize()) {
            return ResponseData.of(div).addMessage(
                    UrInformationMessages.該当データなし_データ内容.getMessage().replace(抄本件数エラー_処理可能な.toString())).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 抄本ドロップダウンリストを選択時のイベントメソッドです。
     *
     * @param div TohyoKekkaShukeiSakuseiDiv
     * @return ResponseData<TohyoKekkaShukeiSakuseiDiv>
     */
    public ResponseData<TohyoKekkaShukeiSakuseiDiv> onChange_ccdShohonNameList(TohyoKekkaShukeiSakuseiDiv div) {
        getHandler(div).changeShohonName();
        return ResponseData.of(div).respond();
    }

    /**
     * 発行ボタンクリック時のチェックです。
     *
     * @param div TohyoKekkaShukeiSakuseiDiv
     * @return ResponseData<TohyoKekkaShukeiSakuseiDiv>
     */
    public ResponseData<TohyoKekkaShukeiSakuseiDiv> onPrint_check(TohyoKekkaShukeiSakuseiDiv div) {

        ValidationMessageControlPairs controlPairs = getValidationHandler(div).validate();
        if (controlPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(controlPairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 発行ボタンクリック時のイベントメソッドです。
     *
     * @param div TohyoKekkaShukeiSakuseiDiv
     * @return ResponseData<TohyoKekkaShukeiSakuseiDiv>
     */
    public ResponseData<AFABTE505BatchParameter> onClick_btnPrint(TohyoKekkaShukeiSakuseiDiv div) {
        return ResponseData.of(getHandler(div).createBatchParameter()).respond();
    }

    private TohyoKekkaShukeiSakuseiHandler getHandler(TohyoKekkaShukeiSakuseiDiv div) {
        return new TohyoKekkaShukeiSakuseiHandler(div);
    }

    private TohyoKekkaShukeiSakuseiValidationHandler getValidationHandler(TohyoKekkaShukeiSakuseiDiv div) {
        return new TohyoKekkaShukeiSakuseiValidationHandler(div);
    }
}
