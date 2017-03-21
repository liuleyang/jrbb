/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv;

import jp.co.ndensan.reams.af.afa.business.mutohyonyuryoku.JotaiHenkoModel;
import jp.co.ndensan.reams.af.afa.definition.core.JotaiHenkoDialogGamenData;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.ViewStateKeys;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.JotaiHenkoDialog.JotaiHenkoDialogDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.JotaiHenkoDialog.JotaiHenkoDialogHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * JotaiHenkoDialog_状態変更ダイアログのコントローラクラスです。
 *
 * @reamsid_L AF-0110-020 wangxt2
 */
public class JotaiHenkoDialog {

    /**
     * 初期表示のイベントメソッドです。
     *
     * @param div JotaiHenkoDialogDiv
     * @return ResponseData<JotaiHenkoDialogDiv>
     */
    public ResponseData<JotaiHenkoDialogDiv> onLoad(JotaiHenkoDialogDiv div) {
        JotaiHenkoModel model = DataPassingConverter.deserialize(div.getJotaiHenkoModel(), JotaiHenkoModel.class);
        getHandler(div).initialize(model);
        JotaiHenkoDialogGamenData gamenData = new JotaiHenkoDialogGamenData(getHandler(div).get投票状況リストFromDDL());
        ViewStateHolder.put(ViewStateKeys.状態変更ダイアログ画面パラメータ, gamenData);
        AccessLogger.log(AccessLogType.照会, PersonalData.of(model.getShikibetsuCode()));
        return ResponseData.of(div).respond();
    }

    /**
     * 「確定する」ボタンをクリックするイベントです。
     *
     * @param div JotaiHenkoDialogDiv
     * @return ResponseData<JotaiHenkoDialogDiv>
     */
    public ResponseData<JotaiHenkoDialogDiv> onClick_btnOk(JotaiHenkoDialogDiv div) {
        JotaiHenkoDialogGamenData gamenData = ViewStateHolder.get(ViewStateKeys.状態変更ダイアログ画面パラメータ, JotaiHenkoDialogGamenData.class);
        if (!ResponseHolder.isReRequest() && !gamenData.get投票状況リスト().equals(getHandler(div).get投票状況リストFromDDL())) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            getHandler(div).save();
            AccessLogger.log(AccessLogType.更新, PersonalData.of(div.getTxtShikibetsuCode().getDomain()));
            return ResponseData.of(div).dialogOKClose();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「取消」ボタンを押した時のイベントメソッドです。
     *
     * @param div JotaiHenkoDialogDiv
     * @return ResponseData<JotaiHenkoDialogDiv>
     */
    public ResponseData<JotaiHenkoDialogDiv> onClick_btnCancel(JotaiHenkoDialogDiv div) {
        return ResponseData.of(div).dialogNGClose();
    }

    private JotaiHenkoDialogHandler getHandler(JotaiHenkoDialogDiv div) {
        return new JotaiHenkoDialogHandler(div);
    }

}
