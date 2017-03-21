/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMK1030;

import jp.co.ndensan.reams.af.afa.definition.batchprm.senkyojikaiku.AFABTK103BatchParameter;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.KaikuSenkyojiTorokuEnum;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMK1030.AFAGMK1030TransitionEventName;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMK1030.KaikuSenkyojiTorokuDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMK1030.KaikuSenkyojiTorokuHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * AFAGMK1030 海区漁業調整委員会委員選挙時登録作成 <br />
 * KaikuSenkyojiTorokuに対応するコントローラです。
 *
 * @reamsid_L AF-0470-010 jihb
 */
public class KaikuSenkyojiToroku {

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param mainPanel KaikuSenkyojiTorokuDiv
     * @return ResponseData<KaikuSenkyojiTorokuDiv>
     */
    public ResponseData<KaikuSenkyojiTorokuDiv> onLoad(KaikuSenkyojiTorokuDiv mainPanel) {

        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(mainPanel).forwardWithEventName(AFAGMK1030TransitionEventName.メニューへ戻る).respond();
        }

        if (!ResponseHolder.isReRequest()) {
            if (mainPanel.getCcdKaikuSenkyojiSenkyoNyuryoku().initialize()) {
                return ResponseData.of(mainPanel).addMessage(
                        UrInformationMessages.該当データなし_データ内容.getMessage().replace(KaikuSenkyojiTorokuEnum.当初登録.toString())).respond();
            }
            mainPanel.getCcdKaikuSenkyojiSakuseiChohyo().initialize();
        }

        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 「実行する」ボタン押下時のチェックメソッドです。
     *
     * @param mainPanel KaikuSenkyojiTorokuDiv
     * @return ResponseData<KaikuSenkyojiTorokuDiv>
     */
    public ResponseData<KaikuSenkyojiTorokuDiv> onClick_btnBatchCheck(KaikuSenkyojiTorokuDiv mainPanel) {
        ValidationMessageControlPairs controlErrorPairs = mainPanel.getCcdKaikuSenkyojiSenkyoNyuryoku().入力日付のチェック();
        if (controlErrorPairs.iterator().hasNext()) {
            return ResponseData.of(mainPanel).addValidationMessages(controlErrorPairs).respond();
        }
        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 実行ボタン押下時のイベントメソッドです。
     *
     * @param mainPanel KaikuSenkyojiTorokuDiv
     * @return ResponseData<AFABTK103BatchParameter>
     */
    public ResponseData<AFABTK103BatchParameter> onClick_btnExecute(KaikuSenkyojiTorokuDiv mainPanel) {

        return ResponseData.of(getHandler(mainPanel).setバッチパラメータ()).respond();
    }

    private KaikuSenkyojiTorokuHandler getHandler(KaikuSenkyojiTorokuDiv div) {
        return new KaikuSenkyojiTorokuHandler(div);
    }
}
