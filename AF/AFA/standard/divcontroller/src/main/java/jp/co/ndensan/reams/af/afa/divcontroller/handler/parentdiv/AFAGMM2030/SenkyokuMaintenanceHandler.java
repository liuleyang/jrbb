/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.af.afa.divcontroller.handler.parentdiv.AFAGMM2030;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.af.afa.business.core.senkyoku.SenkyokuJouhou;
import jp.co.ndensan.reams.af.afa.business.core.senkyoku.Senkyokuhoshu;
import jp.co.ndensan.reams.af.afa.definition.core.senkyojizaisanku.enumeratedtype.SenkyojiZaisankuRStringEnum;
import jp.co.ndensan.reams.af.afa.definition.core.senkyoku.enumeratedtype.SenkyokuRStringEnum;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2030.SenkyokuMaintenanceDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2030.dgSenkyokuList_Row;
import jp.co.ndensan.reams.af.afa.service.senkyoku.SenkyokuFinder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.serialization.Base64Serializer;

/**
 *
 * 選挙区handler
 *
 * @reamsid_L AF-0720-010 liuyj
 */
public final class SenkyokuMaintenanceHandler {

    private final SenkyokuMaintenanceDiv div;

    private SenkyokuMaintenanceHandler(SenkyokuMaintenanceDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタ生成
     *
     * @param div 選挙区
     * @return 選挙区
     */
    public static SenkyokuMaintenanceHandler of(SenkyokuMaintenanceDiv div) {
        return new SenkyokuMaintenanceHandler(div);
    }

    /**
     * 選挙区保守画面のonLoadイベント
     *
     */
    public void set選挙区初期化画面() {
        RString 選挙種類 = div.getSenkyokuSelect().getCcdSenkyoShurui().getSelectedSenkyoShurui().getCode();
        SenkyokuFinder finder = SenkyokuFinder.createInstance();
        List<Senkyokuhoshu> 選挙区情報リスト = finder.select選挙区情報(選挙種類);
        div.getSenkyokuSelect().getDgSenkyokuList().getDataSource().clear();
        List<dgSenkyokuList_Row> rowList = new ArrayList();
        if (null != 選挙区情報リスト) {
            for (Senkyokuhoshu 選挙区情報 : 選挙区情報リスト) {
                dgSenkyokuList_Row row = new dgSenkyokuList_Row();
                row.setTxtCode(選挙区情報.getAfT503SenkyokuEntity().getSenkyokuCode());
                row.setTxtName(選挙区情報.getAfT503SenkyokuEntity().getSenkyokuName());
                row.setTxtTanmatsuSu(null == 選挙区情報.get端末Id()
                        ? SenkyojiZaisankuRStringEnum.ZERO.getKey().concat(SenkyokuRStringEnum.台.getKey())
                        : 選挙区情報.get端末Id().concat(SenkyokuRStringEnum.台.getKey()));
                row.setHidMotoData(new RString(Base64Serializer.serialize(選挙区情報)));
                rowList.add(row);
            }
        }
        div.getSenkyokuSelect().getDgSenkyokuList().setDataSource(rowList);
    }

    /**
     * 初期化状態1
     *
     */
    public void set初期化状態1() {
        div.getSenkyokuSelect().getCcdSenkyoShurui().initialize();
        div.getCcdSenkyoShurui().setDisabled(Boolean.FALSE);
        div.getDgSenkyokuList().setDisabled(Boolean.FALSE);

        div.getBtnAdd().setDisabled(Boolean.FALSE);
        div.getSenkyokuSelect().getDgSenkyokuList().getDataSource().clear();
        div.getDgSenkyokuList().getGridSetting().setIsShowModifyButtonColumn(Boolean.TRUE);
        div.getDgSenkyokuList().getGridSetting().setIsShowDeleteButtonColumn(Boolean.TRUE);
        div.getDgSenkyokuList().getGridSetting().setIsShowSelectButtonColumn(Boolean.TRUE);
        div.getSenkyokuInput().setDisplayNone(Boolean.TRUE);
    }

    /**
     * 選挙区選択エリア内の「コードを追加する」ボタンクリック時画面状態
     *
     */
    public void setコードを追加する() {
        div.getCcdSenkyoShurui().setDisabled(Boolean.TRUE);
        div.getBtnAdd().setDisabled(Boolean.TRUE);
        div.getSenkyokuInput().getTxtName().clearValue();
        div.getSenkyokuInput().getTxtCode().clearValue();
        div.getSenkyokuInput().setDisplayNone(Boolean.FALSE);

        div.setHiddenFlag(SenkyokuRStringEnum.追加.getKey());
        div.getDgSenkyokuList().setDisabled(Boolean.TRUE);
        div.getSenkyokuInput().getTxtName().setDisabled(Boolean.FALSE);
        div.getSenkyokuInput().getTxtCode().setDisabled(Boolean.FALSE);
        div.getSenkyokuInput().getBtnAddNew().setDisabled(Boolean.FALSE);
        div.getSenkyokuInput().getBtnStop().setDisabled(Boolean.FALSE);
        div.getSenkyokuInput().getBtnAddNew().setText(SenkyokuRStringEnum.コードを追加する.getKey());
        div.getSenkyokuInput().getBtnStop().setText(SenkyokuRStringEnum.コードの追加をやめる.getKey());
    }

    /**
     * 選挙区選択エリア内のグリッド内の修正ボタン
     *
     */
    public void setコードを修正() {
        div.getCcdSenkyoShurui().setDisabled(Boolean.TRUE);
        div.getBtnAdd().setDisabled(Boolean.TRUE);
        div.getSenkyokuInput().getTxtName().clearValue();
        div.getSenkyokuInput().getTxtCode().clearValue();
        div.getSenkyokuInput().setDisplayNone(Boolean.FALSE);
        div.setHiddenFlag(SenkyokuRStringEnum.修正.getKey());
        div.getDgSenkyokuList().setDisabled(Boolean.TRUE);
        div.getDgSenkyokuList().getActiveRow().getTxtCode();
        div.getSenkyokuInput().getTxtCode().setValue(div.getDgSenkyokuList().getActiveRow().getTxtCode());
        div.getSenkyokuInput().getTxtName().setValue(div.getDgSenkyokuList().getActiveRow().getTxtName());
        div.getSenkyokuInput().getTxtName().setDisabled(Boolean.FALSE);
        div.getSenkyokuInput().getTxtCode().setDisabled(Boolean.TRUE);
        div.getSenkyokuInput().getBtnAddNew().setDisabled(Boolean.FALSE);
        div.getSenkyokuInput().getBtnStop().setDisabled(Boolean.FALSE);
        div.getSenkyokuInput().getBtnAddNew().setText(SenkyokuRStringEnum.コードを保存する.getKey());
        div.getSenkyokuInput().getBtnStop().setText(SenkyokuRStringEnum.コードの修正をやめる.getKey());
    }

    /**
     * 選挙区選択エリア内のグリッド内の削除ボタンクリック時画面状態
     *
     */
    public void setコードを削除() {
        div.getCcdSenkyoShurui().setDisabled(Boolean.TRUE);
        div.getBtnAdd().setDisabled(Boolean.TRUE);
        div.getSenkyokuInput().setDisplayNone(Boolean.FALSE);
        div.setHiddenFlag(SenkyokuRStringEnum.削除.getKey());
        div.getDgSenkyokuList().setDisabled(Boolean.TRUE);
        div.getSenkyokuInput().getTxtCode().setValue(div.getDgSenkyokuList().getActiveRow().getTxtCode());
        div.getSenkyokuInput().getTxtName().setValue(div.getDgSenkyokuList().getActiveRow().getTxtName());
        div.getSenkyokuInput().getTxtName().setDisabled(Boolean.TRUE);
        div.getSenkyokuInput().getTxtCode().setDisabled(Boolean.TRUE);
        div.getSenkyokuInput().getBtnAddNew().setDisabled(Boolean.FALSE);
        div.getSenkyokuInput().getBtnStop().setDisabled(Boolean.FALSE);
        div.getSenkyokuInput().getBtnAddNew().setText(SenkyokuRStringEnum.コードを削除する.getKey());
        div.getSenkyokuInput().getBtnStop().setText(SenkyokuRStringEnum.コードの削除をやめる.getKey());
    }

    /**
     * 選挙区コードの重複チェック処理
     *
     * @param 選挙種類 RString
     * @param 選挙区コード RString
     * @return boolean
     */
    public boolean set選挙区重複チェック(RString 選挙種類, RString 選挙区コード) {
        Code senkyoshurui = null == 選挙種類 ? Code.EMPTY : new Code(選挙種類);
        SenkyokuFinder finder = SenkyokuFinder.createInstance();
        SenkyokuJouhou entity = finder.get選挙区情報(senkyoshurui, 選挙区コード);
        if (null != entity.getEntity()) {
            return true;
        }
        return false;
    }

    /**
     * 選挙区詳細エリア内の「コードを追加する」ボタンクリック時
     *
     * @param 選挙区情報 SenkyokuJouhou
     * @return int
     */
    public int set選挙区詳細コードを追加と保存する(Senkyokuhoshu 選挙区情報) {
        SenkyokuFinder finder = SenkyokuFinder.createInstance();
        return finder.insert選挙区(選挙区情報);
    }

    /**
     * 選挙区詳細エリア内の「コードを追加する」ボタンクリック時
     *
     * @param 選挙区情報 SenkyokuJouhou
     * @return int
     */
    public int set選挙区詳細コード保存する(Senkyokuhoshu 選挙区情報) {
        SenkyokuFinder finder = SenkyokuFinder.createInstance();
        return finder.insert選挙区情報(選挙区情報);
    }

    /**
     * 選挙区詳細エリア内の「コードを削除する」ボタンクリック時
     *
     * @param 選挙区情報 Senkyokuhoshu
     * @return boolean
     */
    public boolean set選挙区詳細コードを削除する(Senkyokuhoshu 選挙区情報) {
        SenkyokuFinder finder = SenkyokuFinder.createInstance();
        return finder.deltete選挙区情報(選挙区情報);
    }

    /**
     * 「選挙区詳細」ボタン押下のチェックする。
     *
     * @return ResponseData
     */
    public ResponseData checkコード重複チェック() {
        ValidationMessageControlPairs controlErrorPairs = new SenkyokuMaintenanceValidationHandler(div).validateコード重複チェック();
        if (controlErrorPairs.existsError()) {
            return ResponseData.of(div).addValidationMessages(controlErrorPairs).respond();
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 「選挙区詳細」ボタン押下のチェックする。
     *
     * @return ResponseData
     */
    public ResponseData check他ユーザ使用チェック() {
        if (!ResponseHolder.isReRequest()) {
            ValidationMessageControlPairs controlWarningPairs = new SenkyokuMaintenanceValidationHandler(div).validateコード重複チェック();
            if (controlWarningPairs.existsError()) {
                return ResponseData.of(div).addValidationMessages(controlWarningPairs).respond();
            }
        }

        return ResponseData.of(div).respond();
    }
}
