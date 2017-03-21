/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SenkyokuTanmatsuInputDialog;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jp.co.ndensan.reams.af.afa.business.core.senkyokutanmatsukanri.SenkyokuTanmatsuKanriJoho;
import jp.co.ndensan.reams.af.afa.business.core.senkyokutanmatsukanri.SenkyokuTanmatsuKanriJohoList;
import jp.co.ndensan.reams.af.afa.definition.core.enumeratedtype.SenkyoShurui;
import jp.co.ndensan.reams.af.afa.service.senkyokutanmatsukanri.SenkyokuTanmatsuKanriManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.serialization.Base64Serializer;

/**
 * SenkyokuTanmatsuInputDialogDiv の操作を担当するクラスです。
 *
 * @reamsid_L AF-0720-020 liuyj
 */
public class SenkyokuTanmatsuInputDialogHandler {

    private final SenkyokuTanmatsuInputDialogDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 選挙区端末管理Div
     */
    public SenkyokuTanmatsuInputDialogHandler(SenkyokuTanmatsuInputDialogDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ
     *
     * @param div 選挙区端末Div
     * @return SenkyokuTanmatsuInputDialogHandler
     */
    public static SenkyokuTanmatsuInputDialogHandler of(SenkyokuTanmatsuInputDialogDiv div) {
        return new SenkyokuTanmatsuInputDialogHandler(div);
    }

    /**
     * 初期化
     *
     * @param 選挙種類 RString
     * @param 選挙区コード RString
     */
    public void onLoad(SenkyoShurui 選挙種類, RString 選挙区コード) {
        初期化状態();
        Code senkyoShurui = null == 選挙種類 ? Code.EMPTY : new Code(選挙種類.getCode());
        SenkyokuTanmatsuKanriManager finder = SenkyokuTanmatsuKanriManager.createInstance();
        List<SenkyokuTanmatsuKanriJoho> 選挙区リスト = finder.get選挙区端末情報リスト(senkyoShurui, 選挙区コード);
        List<dgSenkyokuTanmatsuInput_Row> rowList = new ArrayList();
        if (null != 選挙区リスト) {
            for (SenkyokuTanmatsuKanriJoho 選挙区 : 選挙区リスト) {
                dgSenkyokuTanmatsuInput_Row row = new dgSenkyokuTanmatsuInput_Row();
                row.getTxtTanmatsuID().setValue(選挙区.getEntity().getTanmatsuID());
                row.setHidMotoData(new RString(Base64Serializer.serialize(選挙区)));
                rowList.add(row);
            }
        }
        SenkyokuTanmatsuKanriJohoList list = new SenkyokuTanmatsuKanriJohoList();
        list.set選挙区リスト(選挙区リスト);
        div.setMotoDataList(new RString(Base64Serializer.serialize(list)));
        div.getDgSenkyokuTanmatsuInput().setDataSource(rowList);
        div.setHidTanmatsuNo(new RString(rowList.size()));
    }

    /**
     * 「端末を追加する」ボタン
     *
     */
    public void onClick_btnAddTanmatsu() {
        List<dgSenkyokuTanmatsuInput_Row> rowList = div.getDgSenkyokuTanmatsuInput().getDataSource();
        dgSenkyokuTanmatsuInput_Row row = new dgSenkyokuTanmatsuInput_Row();
        row.getTxtTanmatsuID().setValue(RString.EMPTY);
        rowList.add(row);
        div.getDgSenkyokuTanmatsuInput().setDataSource(rowList);
        div.setHidTanmatsuNo(new RString(rowList.size()));
    }

    /**
     * グリッド内の削除ボタン
     *
     * @return ResponseData
     */
    public ResponseData onClick_btnSakujo() {
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.削除の確認.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            div.getDgSenkyokuTanmatsuInput().getDataSource().remove(div.getDgSenkyokuTanmatsuInput().getClickedRowId());
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 取消ボタン
     *
     * @return ResponseData
     */
    public ResponseData onClick_btnTorikeshi() {
        int number = 0;
        List<dgSenkyokuTanmatsuInput_Row> dataSource = div.getDgSenkyokuTanmatsuInput().getDataSource();
        if (null != dataSource && Integer.parseInt(div.getHidTanmatsuNo().toString()) == dataSource.size()) {
            for (int i = 0; i < dataSource.size(); i++) {
                SenkyokuTanmatsuKanriJoho 選挙区情報 = Base64Serializer.deSerialize(div.getDgSenkyokuTanmatsuInput().getDataSource().get(i).getHidMotoData().toString(), SenkyokuTanmatsuKanriJoho.class);
                dgSenkyokuTanmatsuInput_Row row = div.getDgSenkyokuTanmatsuInput().getDataSource().get(i);
                if (null != 選挙区情報 && 選挙区情報.getEntity().getTanmatsuID().equals(row.getTxtTanmatsuID().getValue())) {
                    number = number + 1;
                }
            }
        }
        if (number == Integer.parseInt(div.getHidTanmatsuNo().toString())) {
            return ResponseData.of(div).dialogOKClose();
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.入力内容の破棄.getMessage()).respond();
        }
        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {
            return ResponseData.of(div).dialogOKClose();
        } else if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }

        return ResponseData.of(div).dialogOKClose();
    }

    /**
     * 更新ボタン
     *
     * @return ResponseData
     */
    public ResponseData onClick_btnKoshi() {
        List<dgSenkyokuTanmatsuInput_Row> rowList = div.getDgSenkyokuTanmatsuInput().getDataSource();
        Set<RString> 端末IdList = new HashSet();
        boolean flag = Boolean.FALSE;
        if (null != rowList) {
            for (dgSenkyokuTanmatsuInput_Row row : rowList) {
                if (row.getTxtTanmatsuID().getValue().isNullOrEmpty()) {
                    flag = Boolean.TRUE;
                } else {
                    端末IdList.add(row.getTxtTanmatsuID().getValue());
                }
            }
        }
        if (flag) {
            ValidationMessageControlPairs controlErrorPairs = SenkyokuTanmatsuInputDialogValidationHandler.of(div).validate空白行の確認();
            if (controlErrorPairs.existsError()) {
                return ResponseData.of(div).addValidationMessages(controlErrorPairs).respond();
            }
        }
        if (null != rowList && !rowList.isEmpty() && 端末IdList.size() != rowList.size()) {
            ValidationMessageControlPairs controlErrorPairs = SenkyokuTanmatsuInputDialogValidationHandler.of(div).validate二重登録チェック();
            if (controlErrorPairs.existsError()) {
                return ResponseData.of(div).addValidationMessages(controlErrorPairs).respond();
            }
        }
        if (!ResponseHolder.isReRequest()) {
            return ResponseData.of(div).addMessage(UrQuestionMessages.保存の確認.getMessage()).respond();
        }

        if (ResponseHolder.getButtonType() == MessageDialogSelectedResult.No) {
            return ResponseData.of(div).respond();
        }
        SenkyokuTanmatsuKanriManager finder = SenkyokuTanmatsuKanriManager.createInstance();

        RString 選挙種類 = div.getCcdSenkyoShurui().getSelectedSenkyoShurui().getCode();
        Code senkyoShurui = null == 選挙種類 ? Code.EMPTY : new Code(選挙種類);
        RString 選挙区Code = div.getCcdSenkyokuCode().get選挙区コード();
        SenkyokuTanmatsuKanriJohoList 選挙区情報 = Base64Serializer.deSerialize(div.getMotoDataList().toString(), SenkyokuTanmatsuKanriJohoList.class);
        finder.insertAll選挙区端末情報(選挙区情報, senkyoShurui, 選挙区Code, 端末IdList);
        return ResponseData.of(div).dialogOKClose();
    }

    private void 初期化状態() {
        div.getCcdSenkyoShurui().setDisabled(Boolean.TRUE);
        div.getCcdSenkyokuCode().setDisabled(Boolean.TRUE);
        div.getBtnAddRow().setDisabled(Boolean.FALSE);
        div.getDgSenkyokuTanmatsuInput().getDataSource().clear();
        div.getDgSenkyokuTanmatsuInput().getGridSetting().setIsShowRowState(Boolean.TRUE);
        div.getDgSenkyokuTanmatsuInput().getGridSetting().setIsShowDeleteButtonColumn(Boolean.TRUE);
        div.getBtnCancel().setDisabled(Boolean.FALSE);
        div.getBtnUpdate().setDisabled(Boolean.FALSE);
    }
}
