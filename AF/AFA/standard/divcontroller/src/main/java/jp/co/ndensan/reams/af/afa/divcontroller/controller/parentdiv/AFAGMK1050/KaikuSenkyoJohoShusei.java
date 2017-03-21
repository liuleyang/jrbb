/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMK1050;

import jp.co.ndensan.reams.af.afa.business.core.KaikuTaishoShohonJohoData;
import jp.co.ndensan.reams.af.afa.business.kanryokakunin.KanryoKakuninParameter;
import jp.co.ndensan.reams.af.afa.definition.core.domain.ShohonNo;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.KaikuSenkyojiTorokuEnum;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ViewStateKeys;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMK1050.AFAGMK1050TransitionEventName;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMK1050.KaikuSenkyoJohoShuseiDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMK1050.KaikuSenkyoJohoShuseiHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.Base64Serializer;

/**
 * AFAGMK1050 海区漁業調整委員会委員選挙選挙情報修正 <br />
 * KaikuSenkyoJohoShuseiDivに対応するコントローラです。
 *
 * @reamsid_L AF-0490-010 lis
 */
public class KaikuSenkyoJohoShusei {

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param mainPanel KaikuSenkyoJohoShuseiDiv
     * @return ResponseData<KaikuSenkyoJohoShuseiDiv>
     */
    public ResponseData<KaikuSenkyoJohoShuseiDiv> onLoad(KaikuSenkyoJohoShuseiDiv mainPanel) {

        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(mainPanel).forwardWithEventName(AFAGMK1050TransitionEventName.メニューへ戻る).respond();
        }

        if (!ResponseHolder.isReRequest()) {
            if (mainPanel.getCcdKaikuShusei().initialize()) {
                return ResponseData.of(mainPanel).addMessage(
                        UrInformationMessages.該当データなし_データ内容.getMessage().replace(KaikuSenkyojiTorokuEnum.当初登録.getValue().toString())).respond();
            }
            mainPanel.getCcdKaikuShusei().initialize();
        }

        ResponseData<KaikuSenkyoJohoShuseiDiv> response = new ResponseData<>();
        response.data = mainPanel;
        return response;
    }

    /**
     * 実行ボタン押下時のイベントメソッドです。
     *
     * @param mainPanel KaikuSenkyoJohoShuseiDiv
     * @return ResponseData<KaikuSenkyoJohoShuseiDiv>
     */
    public ResponseData<KaikuSenkyoJohoShuseiDiv> onClick_btnUpdate(KaikuSenkyoJohoShuseiDiv mainPanel) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(mainPanel).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(mainPanel).respond();
        }
        ValidationMessageControlPairs controlErrorPairs = mainPanel.getCcdKaikuShusei().入力日付のチェック();
        if (controlErrorPairs.iterator().hasNext()) {
            return ResponseData.of(mainPanel).addValidationMessages(controlErrorPairs).respond();
        }
        KaikuTaishoShohonJohoData 抄本選挙情報 = Base64Serializer.deSerialize(mainPanel.getCcdKaikuShusei().getHidMotoData().toString(), KaikuTaishoShohonJohoData.class);

        抄本選挙情報 = getKaikuSenkyoJohoShuseiHandler(mainPanel).edit抄本選挙情報(抄本選挙情報);
        boolean 抄本選挙情報更新結果 = getKaikuSenkyoJohoShuseiHandler(mainPanel).update抄本選挙情報(抄本選挙情報);
        ViewStateHolder.put(ViewStateKeys.完了確認, edit画面引数(mainPanel, 抄本選挙情報更新結果));

        return ResponseData.of(mainPanel)
                .forwardWithEventName(AFAGMK1050TransitionEventName.更新).respond();
    }

    private KanryoKakuninParameter edit画面引数(KaikuSenkyoJohoShuseiDiv div, boolean 保存結果) {
        KanryoKakuninParameter 画面引数 = new KanryoKakuninParameter();
        画面引数.set投票区コード(RString.EMPTY);
        画面引数.set冊(RString.EMPTY);
        画面引数.set頁(0);
        画面引数.set行(0);
        画面引数.set抄本番号(new ShohonNo(div.getCcdKaikuShusei().getCcdShohonNameList().getSelectedShohonNo()));
        画面引数.set抄本名(div.getCcdKaikuShusei().getCcdShohonNameList().getSelectedShohonName());
        画面引数.setメニューID(ResponseHolder.getMenuID());
        画面引数.set処理結果(保存結果);
        画面引数.set氏名(RString.EMPTY);
        return 画面引数;
    }

    private KaikuSenkyoJohoShuseiHandler getKaikuSenkyoJohoShuseiHandler(KaikuSenkyoJohoShuseiDiv div) {
        return new KaikuSenkyoJohoShuseiHandler(div);
    }
}
