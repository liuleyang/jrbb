/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.commonchilddiv;

import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SennkyoSikakuShurui;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SenkyokuTanmatsuInputDialog.SenkyokuTanmatsuInputDialogDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SenkyokuTanmatsuInputDialog.SenkyokuTanmatsuInputDialogHandler;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 選挙区端末管理入力ダイアログ
 *
 * @reamsid_L AF-0720-010 liuyj
 */
public class SenkyokuTanmatsuInputDialog {

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param mainPanel KaikuSenkyoJohoShuseiDiv
     * @return ResponseData<KaikuSenkyoJohoShuseiDiv>
     */
    public ResponseData<SenkyokuTanmatsuInputDialogDiv> onLoad(SenkyokuTanmatsuInputDialogDiv mainPanel) {

        SenkyoShurui senkyoshurui = mainPanel.getCcdSenkyoShurui().getSelectedSenkyoShurui();
        RString senkyoCode = mainPanel.getCcdSenkyokuCode().get選挙区コード();
        mainPanel.getCcdSenkyoShurui().initialize(SennkyoSikakuShurui.toValue(senkyoshurui.getCode()));
        SenkyokuTanmatsuInputDialogHandler.of(mainPanel).onLoad(senkyoshurui, senkyoCode);
        mainPanel.getCcdSenkyokuCode().initialize(new Code(senkyoshurui.getCode()), senkyoCode);

        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 「端末を追加する」ボタン
     *
     * @param mainPanel KaikuSenkyoJohoShuseiDiv
     * @return ResponseData<KaikuSenkyoJohoShuseiDiv>
     */
    public ResponseData<SenkyokuTanmatsuInputDialogDiv> onClick_btnAddTanmatsu(SenkyokuTanmatsuInputDialogDiv mainPanel) {
        SenkyokuTanmatsuInputDialogHandler.of(mainPanel).onClick_btnAddTanmatsu();

        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 「グリッド内の削除ボタン
     *
     * @param mainPanel KaikuSenkyoJohoShuseiDiv
     * @return ResponseData<KaikuSenkyoJohoShuseiDiv>
     */
    public ResponseData<SenkyokuTanmatsuInputDialogDiv> onClick_btnSakujo(SenkyokuTanmatsuInputDialogDiv mainPanel) {

        return SenkyokuTanmatsuInputDialogHandler.of(mainPanel).onClick_btnSakujo();
    }

    /**
     * 取消ボタン
     *
     * @param mainPanel KaikuSenkyoJohoShuseiDiv
     * @return ResponseData<KaikuSenkyoJohoShuseiDiv>
     */
    public ResponseData<SenkyokuTanmatsuInputDialogDiv> onClick_btnTorikeshi(SenkyokuTanmatsuInputDialogDiv mainPanel) {

        return SenkyokuTanmatsuInputDialogHandler.of(mainPanel).onClick_btnTorikeshi();
    }

    /**
     * 更新ボタン
     *
     * @param mainPanel KaikuSenkyoJohoShuseiDiv
     * @return ResponseData<KaikuSenkyoJohoShuseiDiv>
     */
    public ResponseData<SenkyokuTanmatsuInputDialogDiv> onClick_btnKoshi(SenkyokuTanmatsuInputDialogDiv mainPanel) {

        return SenkyokuTanmatsuInputDialogHandler.of(mainPanel).onClick_btnKoshi();
    }
}
