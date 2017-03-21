/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMM3020;

import jp.co.ndensan.reams.af.afa.definition.batchprm.doitsujinbutsuChosa.AFABTM107BatchParameter;
import static jp.co.ndensan.reams.af.afa.definition.core.takeoutpcdatacapture.enumeratedtype.TakeOutPcDataCaptureRStringEnum.処理可能な;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM3020.AFAGMM3020TransitionEventName;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM3020.DoitsuninCsvOutputDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM3020.DoitsuninCsvOutputHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM3020.DoitsuninCsvOutputValidationHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.helper.ViewState;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 同一人物調査のクラス
 *
 * @reamsid_L AF-0690-010 wanghj
 */
public class DoitsuninCsvOutput {

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div DoitsuninCsvOutputDiv
     * @return ResponseData<DoitsuninCsvOutputDiv>
     */
    public ResponseData<DoitsuninCsvOutputDiv> onLoad(DoitsuninCsvOutputDiv div) {
        if (ResponseHolder.isReRequest()) {
            return ResponseData.of(div).forwardWithEventName(AFAGMM3020TransitionEventName.メニューへ戻る).respond();
        }
        ViewState.setメニューID(ResponseHolder.getMenuID());
        div.getCcdShohonNameList().setChkKakoShohonCheckMode(Boolean.FALSE);
        div.getCcdShohonNameList().initialize();
        RString shohon未来 = div.getCcdShohonNameList().get一番近い未来抄本番号();
        int shohonListSize = div.getCcdShohonNameList().getShohonListSize();
        if (shohonListSize > 0 && shohon未来 != null) {
            div.getCcdShohonNameList().selectedShohon(shohon未来);
        } else {
            div.getCcdShohonNameList().setChkKakoShohonCheckMode(Boolean.TRUE);
            div.getCcdShohonNameList().initialize();
            RString shohon過去 = div.getCcdShohonNameList().get一番近い過去抄本番号();
            shohonListSize = div.getCcdShohonNameList().getShohonListSize();
            if (shohonListSize > 0 && shohon過去 != null) {
                div.getCcdShohonNameList().selectedShohon(shohon過去);
            } else {
                return ResponseData.of(div).addMessage(
                        UrInformationMessages.該当データなし_データ内容.getMessage().replace(処理可能な.getKey().toString())).respond();
            }
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 抄本ドロップダウンリストを選択時のイベントメソッドです。
     *
     * @param div DoitsuninCsvOutputDiv
     * @return ResponseData<DoitsuninCsvOutputDiv>
     */
    public ResponseData<DoitsuninCsvOutputDiv> onChange_ddlShohon(DoitsuninCsvOutputDiv div) {
        div.getCcdShohonNameList().changeDdlShohon();
        return ResponseData.of(div).respond();
    }

    /**
     * 「実行する」ボタン押下時のチェックメソッドです。
     *
     * @param mainPanel DoitsuninCsvOutputDiv
     * @return ResponseData<DoitsuninCsvOutputDiv>
     */
    public ResponseData<DoitsuninCsvOutputDiv> onClick_btnBatchCheck(DoitsuninCsvOutputDiv mainPanel) {
        ValidationMessageControlPairs controlErrorPairs = getValidationHandler(mainPanel).validate();
        if (controlErrorPairs.existsError()) {
            return ResponseData.of(mainPanel).addValidationMessages(controlErrorPairs).respond();
        }
        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 「実行する」ボタン押下時のイベントメソッドです。
     *
     * @param mainPanel DoitsuninCsvOutputDiv
     * @return ResponseData<DoitsuninCsvOutputDiv>
     */
    public ResponseData<AFABTM107BatchParameter> onClick_setBatchParameter(DoitsuninCsvOutputDiv mainPanel) {
        return ResponseData.of(getHandler(mainPanel).set画面入力内容()).respond();
    }

    private static DoitsuninCsvOutputHandler getHandler(DoitsuninCsvOutputDiv mainPanel) {
        return new DoitsuninCsvOutputHandler(mainPanel);
    }

    private static DoitsuninCsvOutputValidationHandler getValidationHandler(DoitsuninCsvOutputDiv mainPanel) {
        return new DoitsuninCsvOutputValidationHandler(mainPanel);
    }

}
