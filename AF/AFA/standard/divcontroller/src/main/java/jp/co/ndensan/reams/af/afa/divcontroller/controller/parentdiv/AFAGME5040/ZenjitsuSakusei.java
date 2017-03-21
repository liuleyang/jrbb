/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGME5040;

import jp.co.ndensan.reams.af.afa.definition.batchprm.zenjitsuprint.AFABTE504BatchParameter;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5040.AFAGME5040TransitionEventName;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5040.ZenjitsuSakuseiDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME5040.ZenjitsuSakuseiHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGME5040.ZenjitsuSakuseiValidationHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * AFAGME5040 投票日前日関連帳票 <br />
 * ZenjitsuSakuseiDivに対応するコントローラです。
 *
 * @reamsid_L AF-0280-010 lit
 */
public class ZenjitsuSakusei {

    private static final RString 抄本件数エラー_処理可能な = new RString("処理可能な");

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div ZenjitsuSakuseiDiv
     * @return ResponseData<ZenjitsuSakuseiDiv>
     */
    public ResponseData<ZenjitsuSakuseiDiv> onLoad(ZenjitsuSakuseiDiv div) {
        if (ResponseHolder.isReRequest()) {
            return ResponseData.of(div).forwardWithEventName(AFAGME5040TransitionEventName.メニューへ戻る).respond();
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
     * @param div ZenjitsuSakuseiDiv
     * @return ResponseData<ZenjitsuSakuseiDiv>
     */
    public ResponseData<ZenjitsuSakuseiDiv> onChange_ccdShohonNameList(ZenjitsuSakuseiDiv div) {
        getHandler(div).changeShohonName();
        return ResponseData.of(div).respond();
    }

    /**
     * 発行ボタンクリック時のチェックです。
     *
     * @param div ZenjitsuSakuseiDiv
     * @return ResponseData<ZenjitsuSakuseiDiv>
     */
    public ResponseData<ZenjitsuSakuseiDiv> onPrint_check(ZenjitsuSakuseiDiv div) {

        ValidationMessageControlPairs controlPairs = getValidationHandler(div).validate();
        if (controlPairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(controlPairs).respond();
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 発行ボタンクリック時のイベントメソッドです。
     *
     * @param div ZenjitsuSakuseiDiv
     * @return ResponseData<ZenjitsuSakuseiDiv>
     */
    public ResponseData<AFABTE504BatchParameter> onClick_btnPrint(ZenjitsuSakuseiDiv div) {
        return ResponseData.of(getHandler(div).createParameter()).respond();
    }

    private ZenjitsuSakuseiHandler getHandler(ZenjitsuSakuseiDiv div) {
        return new ZenjitsuSakuseiHandler(div);
    }

    private ZenjitsuSakuseiValidationHandler getValidationHandler(ZenjitsuSakuseiDiv div) {
        return new ZenjitsuSakuseiValidationHandler(div);
    }
}
