/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuShurui;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SenkyokuSelectDialog.SenkyokuCodeSelectDialogHandler;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SenkyokuSelectDialog.SenkyokuSelectDialogDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 選挙区選択ダイアログに対するコントローラです。
 *
 * @reamsid_L AF-0720-030 zhanggs
 */
public class SenkyokuSelectDialog {

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param div SenkyokuSelectDialogDiv
     * @return ResponseData<SenkyokuSelectDialogDiv>
     */
    public ResponseData<SenkyokuSelectDialogDiv> onLoad(SenkyokuSelectDialogDiv div) {
        if (null != div.getCcdSenkyoShurui().getSelectedSenkyoShurui()) {
            div.getCcdSenkyoShurui().initialize(SennkyoSikakuShurui.toValue(div.getCcdSenkyoShurui().getSelectedSenkyoShurui().getCode()));
        } else {
            div.getCcdSenkyoShurui().initialize();
        }
        SenkyokuCodeSelectDialogHandler.of(div).createDataSource(div.getCcdSenkyoShurui().getSelectedSenkyoShurui().getCode());

        return ResponseData.of(div).respond();
    }

    /**
     * 選択ボタンクリック時のイベントメソッドです。 <br />
     * グリッド行ダブルクリック時のイベントメソッドです。
     *
     * @param div SenkyokuSelectDialogDiv
     * @return ResponseData<SenkyokuSelectDialogDiv>
     */
    public ResponseData<SenkyokuSelectDialogDiv> onSelectBySelectButton_closeOK(SenkyokuSelectDialogDiv div) {

        div.setTxtHdnSelectedCode(div.getDgSenkyokuSelect().getSelectedItems().get(0).getTxtSenkyokuCode());
        div.setTxtHdnSelectedName(div.getDgSenkyokuSelect().getSelectedItems().get(0).getTxtSenkyokuName());
        div.setTxtHdnSelectedSenkyoShurui(div.getCcdSenkyoShurui().getSelectedSenkyoShurui().getCode());

        return ResponseData.of(div).dialogOKClose();
    }

    /**
     * 選挙種類DDLを変更した時のイベントメソッドです。
     *
     * @param div SenkyokuSelectDialogDiv
     * @return ResponseData<SenkyokuSelectDialogDiv>
     */
    public ResponseData<SenkyokuSelectDialogDiv> onChange_ccdSenkyoShurui(SenkyokuSelectDialogDiv div) {

        SenkyokuCodeSelectDialogHandler.of(div).createDataSource(div.getCcdSenkyoShurui().getSelectedSenkyoShurui().getCode());
        return ResponseData.of(div).respond();
    }

    /**
     * 画面を閉じるのイベントメソッドです。
     *
     * @param div SenkyokuSelectDialogDiv
     * @return ResponseData<SenkyokuSelectDialogDiv>
     */
    public ResponseData<SenkyokuSelectDialogDiv> onClick_CloseCancel(SenkyokuSelectDialogDiv div) {
        div.setTxtHdnSelectedCode(div.getDgSenkyokuSelect().getActiveRow().getTxtSenkyokuCode());
        div.setTxtHdnSelectedName(div.getDgSenkyokuSelect().getActiveRow().getTxtSenkyokuName());
        div.setTxtHdnSelectedSenkyoShurui(div.getCcdSenkyoShurui().getSelectedSenkyoShurui().getCode());
        return ResponseData.of(div).dialogOKClose();
    }

}
