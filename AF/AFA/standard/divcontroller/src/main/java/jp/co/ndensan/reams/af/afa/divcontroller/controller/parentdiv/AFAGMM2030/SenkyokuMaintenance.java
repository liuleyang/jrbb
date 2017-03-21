/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.controller.parentdiv.AFAGMM2030;

import jp.co.ndensan.reams.af.afa.business.core.senkyoku.Senkyokuhoshu;
import jp.co.ndensan.reams.af.afa.definition.core.senkyoku.enumeratedtype.SenkyokuRStringEnum;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2030.SenkyokuMaintenanceDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM2030.SenkyokuMaintenanceHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.serialization.Base64Serializer;

/**
 * 選挙区保守
 *
 * @reamsid_L AF-0720-010 liuyj
 */
public class SenkyokuMaintenance {

    /**
     * 画面ロード時のイベントメソッドです。
     *
     * @param mainPanel KaikuSenkyoJohoShuseiDiv
     * @return ResponseData<KaikuSenkyoJohoShuseiDiv>
     */
    public ResponseData<SenkyokuMaintenanceDiv> onLoad(SenkyokuMaintenanceDiv mainPanel) {
        SenkyokuMaintenanceHandler.of(mainPanel).set初期化状態1();
        SenkyokuMaintenanceHandler.of(mainPanel).set選挙区初期化画面();
        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 選挙種類ドロップダウン。
     *
     * @param mainPanel SenkyokuMaintenanceDiv
     * @return ResponseData<SenkyokuMaintenanceDiv>
     */
    public ResponseData<SenkyokuMaintenanceDiv> onChange_senkyoShirui(SenkyokuMaintenanceDiv mainPanel) {

        SenkyokuMaintenanceHandler.of(mainPanel).set選挙区初期化画面();
        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 選挙区選択エリア内の「コードを追加する」ボタン。
     *
     * @param mainPanel SenkyokuMaintenanceDiv
     * @return ResponseData<SenkyokuMaintenanceDiv>
     */
    public ResponseData<SenkyokuMaintenanceDiv> onClick_btnAddSenkyo(SenkyokuMaintenanceDiv mainPanel) {
        SenkyokuMaintenanceHandler.of(mainPanel).setコードを追加する();
        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 選挙区選択エリア内のグリッド内の修正ボタン
     *
     * @param mainPanel SenkyokuMaintenanceDiv
     * @return ResponseData<SenkyokuMaintenanceDiv>
     */
    public ResponseData<SenkyokuMaintenanceDiv> onClick_btnModifySenkyo(SenkyokuMaintenanceDiv mainPanel) {

        SenkyokuMaintenanceHandler.of(mainPanel).setコードを修正();
        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 選挙区選択エリア内のグリッド内の削除ボタン
     *
     * @param mainPanel SenkyokuMaintenanceDiv
     * @return ResponseData<SenkyokuMaintenanceDiv>
     */
    public ResponseData<SenkyokuMaintenanceDiv> onClick_btnDeleteSenkyo(SenkyokuMaintenanceDiv mainPanel) {

        SenkyokuMaintenanceHandler.of(mainPanel).setコードを削除();
        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 選挙区詳細エリア内のコードの追加をやめるボタンと修正をやめるボタンと削除をやめるボタン
     *
     * @param mainPanel SenkyokuMaintenanceDiv
     * @return ResponseData<SenkyokuMaintenanceDiv>
     */
    public ResponseData<SenkyokuMaintenanceDiv> onClick_btnAllSenkyo(SenkyokuMaintenanceDiv mainPanel) {

        if (SenkyokuRStringEnum.追加.getKey().equals(mainPanel.getHiddenFlag())) {
            RString 選挙区コード = mainPanel.getSenkyokuInput().getTxtCode().getValue();
            RString 選挙区名 = mainPanel.getSenkyokuInput().getTxtName().getValue();
            if (選挙区コード.isEmpty() && 選挙区名.isEmpty()) {
                SenkyokuMaintenanceHandler.of(mainPanel).set初期化状態1();
                SenkyokuMaintenanceHandler.of(mainPanel).set選挙区初期化画面();
            } else {
                return edit入力内容の破棄(mainPanel);
            }
        }
        if (SenkyokuRStringEnum.修正.getKey().equals(mainPanel.getHiddenFlag())) {
            Senkyokuhoshu 選挙区情報 = Base64Serializer.deSerialize(mainPanel.getDgSenkyokuList().getClickedItem().getHidMotoData().toString(), Senkyokuhoshu.class);
            RString 選挙区コード = mainPanel.getSenkyokuInput().getTxtCode().getValue();
            RString 選挙区名 = mainPanel.getSenkyokuInput().getTxtName().getValue();
            if (選挙区コード.equals(選挙区情報.get選挙区コード()) && 選挙区名.equals(選挙区情報.get選挙名())) {
                SenkyokuMaintenanceHandler.of(mainPanel).set初期化状態1();
                SenkyokuMaintenanceHandler.of(mainPanel).set選挙区初期化画面();
            } else {
                return edit入力内容の破棄(mainPanel);
            }
        }
        if (SenkyokuRStringEnum.削除.getKey().equals(mainPanel.getHiddenFlag())) {
            SenkyokuMaintenanceHandler.of(mainPanel).set初期化状態1();
            SenkyokuMaintenanceHandler.of(mainPanel).set選挙区初期化画面();
        }
        return ResponseData.of(mainPanel).respond();
    }

    private ResponseData edit入力内容の破棄(SenkyokuMaintenanceDiv mainPanel) {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(mainPanel).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            SenkyokuMaintenanceHandler.of(mainPanel).set初期化状態1();
            SenkyokuMaintenanceHandler.of(mainPanel).set選挙区初期化画面();
        }
        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 選挙区詳細エリア内のコードを追加するボタン
     *
     * @param mainPanel SenkyokuMaintenanceDiv
     * @return ResponseData<SenkyokuMaintenanceDiv>
     */
    public ResponseData<SenkyokuMaintenanceDiv> onClick_btnAddSenkyoku(SenkyokuMaintenanceDiv mainPanel) {
        if (SenkyokuRStringEnum.追加.getKey().equals(mainPanel.getHiddenFlag())) {
            return btnAddSenkyoku(mainPanel);
        }
        if (SenkyokuRStringEnum.修正.getKey().equals(mainPanel.getHiddenFlag())) {
            return btnUpdateSenkyoku(mainPanel);
        }
        if (SenkyokuRStringEnum.削除.getKey().equals(mainPanel.getHiddenFlag())) {
            return btnDeleteSenkyoku(mainPanel);
        }
        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 選挙区端末管理入力ダイアログボタンクリック時処理
     *
     * @param mainPanel SenkyokuMaintenanceDiv
     * @return ResponseData<SenkyokuMaintenanceDiv>
     */
    public ResponseData<SenkyokuMaintenanceDiv> onBeforeClick_btnSenkyokuTanmatsu(SenkyokuMaintenanceDiv mainPanel) {
        return ResponseData.of(mainPanel).respond();
    }

    /**
     * 選挙区端末管理入力ダイアログボタンクリック時処理
     *
     * @param mainPanel SenkyokuMaintenanceDiv
     * @return ResponseData<SenkyokuMaintenanceDiv>
     */
    public ResponseData<SenkyokuMaintenanceDiv> onClick_btnSenkyokuTanmatsu(SenkyokuMaintenanceDiv mainPanel) {
        SenkyokuMaintenanceHandler.of(mainPanel).set選挙区初期化画面();
        return ResponseData.of(mainPanel).respond();
    }

    private ResponseData<SenkyokuMaintenanceDiv> btnAddSenkyoku(SenkyokuMaintenanceDiv mainPanel) {
        Senkyokuhoshu 選挙区情報 = new Senkyokuhoshu();
        選挙区情報.set選挙種類(mainPanel.getSenkyokuSelect().getCcdSenkyoShurui().getSelectedSenkyoShurui().getCode());
        選挙区情報.set選挙名(mainPanel.getSenkyokuInput().getTxtName().getValue());
        選挙区情報.set選挙区コード(mainPanel.getSenkyokuInput().getTxtCode().getValue());
        RString 選挙種類 = mainPanel.getSenkyokuSelect().getCcdSenkyoShurui().getSelectedSenkyoShurui().getCode();
        RString 選挙区コード = mainPanel.getSenkyokuInput().getTxtCode().getValue();
        boolean 選挙区件数フラグ = SenkyokuMaintenanceHandler.of(mainPanel).set選挙区重複チェック(選挙種類, 選挙区コード);
        if (選挙区件数フラグ) {
            return SenkyokuMaintenanceHandler.of(mainPanel).checkコード重複チェック();
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(mainPanel).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            int number = SenkyokuMaintenanceHandler.of(mainPanel).set選挙区詳細コードを追加と保存する(選挙区情報);
            if (number > 0) {
                SenkyokuMaintenanceHandler.of(mainPanel).set初期化状態1();
                SenkyokuMaintenanceHandler.of(mainPanel).set選挙区初期化画面();
            }
        }

        return ResponseData.of(mainPanel).respond();
    }

    private ResponseData<SenkyokuMaintenanceDiv> btnUpdateSenkyoku(SenkyokuMaintenanceDiv mainPanel) {
        Senkyokuhoshu 選挙区情報 = Base64Serializer.deSerialize(mainPanel.getDgSenkyokuList().getClickedItem().getHidMotoData().toString(), Senkyokuhoshu.class);

        選挙区情報.getAfT503SenkyokuEntity().setSenkyoShurui(new Code(mainPanel.getSenkyokuSelect().getCcdSenkyoShurui().getSelectedSenkyoShurui().getCode()));
        選挙区情報.getAfT503SenkyokuEntity().setSenkyokuCode(mainPanel.getSenkyokuInput().getTxtCode().getValue());
        選挙区情報.getAfT503SenkyokuEntity().setSenkyokuName(mainPanel.getSenkyokuInput().getTxtName().getValue());
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(mainPanel).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            int number = SenkyokuMaintenanceHandler.of(mainPanel).set選挙区詳細コード保存する(選挙区情報);
            if (number > 0) {
                SenkyokuMaintenanceHandler.of(mainPanel).set初期化状態1();
                SenkyokuMaintenanceHandler.of(mainPanel).set選挙区初期化画面();
            } else {
                return SenkyokuMaintenanceHandler.of(mainPanel).check他ユーザ使用チェック();
            }
        }

        return ResponseData.of(mainPanel).respond();
    }

    private ResponseData<SenkyokuMaintenanceDiv> btnDeleteSenkyoku(SenkyokuMaintenanceDiv mainPanel) {
        Senkyokuhoshu 選挙区情報 = Base64Serializer.deSerialize(mainPanel.getDgSenkyokuList().getClickedItem().getHidMotoData().toString(), Senkyokuhoshu.class);
        選挙区情報.getAfT503SenkyokuEntity().setSenkyoShurui(new Code(mainPanel.getSenkyokuSelect().getCcdSenkyoShurui().getSelectedSenkyoShurui().getCode()));
        選挙区情報.getAfT503SenkyokuEntity().setSenkyokuCode(mainPanel.getSenkyokuInput().getTxtCode().getValue());

        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(mainPanel).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            boolean deleteFlag = SenkyokuMaintenanceHandler.of(mainPanel).set選挙区詳細コードを削除する(選挙区情報);
            if (deleteFlag) {
                SenkyokuMaintenanceHandler.of(mainPanel).set初期化状態1();
                SenkyokuMaintenanceHandler.of(mainPanel).set選挙区初期化画面();
            } else {
                return SenkyokuMaintenanceHandler.of(mainPanel).check他ユーザ使用チェック();
            }
        }

        return ResponseData.of(mainPanel).respond();
    }

}
