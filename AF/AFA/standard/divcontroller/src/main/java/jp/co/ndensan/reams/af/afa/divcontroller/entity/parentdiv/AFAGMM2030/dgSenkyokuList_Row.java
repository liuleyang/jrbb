package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2030;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Sep 08 21:09:53 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;


/**
 * dgSenkyokuList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgSenkyokuList_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

    private RString txtCode;
    private RString txtName;
    private RString txtTanmatsuSu;
    private ButtonDialog btnTanmatsuInputDialog;
    private RString hidMotoData;

    public dgSenkyokuList_Row() {
        super();
        this.txtCode = RString.EMPTY;
        this.txtName = RString.EMPTY;
        this.txtTanmatsuSu = RString.EMPTY;
        this.btnTanmatsuInputDialog = new ButtonDialog();
        this.hidMotoData = RString.EMPTY;
        this.setOriginalData("txtCode", txtCode);
        this.setOriginalData("txtName", txtName);
        this.setOriginalData("txtTanmatsuSu", txtTanmatsuSu);
        this.setOriginalData("btnTanmatsuInputDialog", btnTanmatsuInputDialog);
        this.setOriginalData("hidMotoData", hidMotoData);
    }

    public dgSenkyokuList_Row(RString txtCode, RString txtName, RString txtTanmatsuSu, ButtonDialog btnTanmatsuInputDialog, RString hidMotoData) {
        super();
        this.setOriginalData("txtCode", txtCode);
        this.setOriginalData("txtName", txtName);
        this.setOriginalData("txtTanmatsuSu", txtTanmatsuSu);
        this.setOriginalData("btnTanmatsuInputDialog", btnTanmatsuInputDialog);
        this.setOriginalData("hidMotoData", hidMotoData);
        this.txtCode = txtCode;
        this.txtName = txtName;
        this.txtTanmatsuSu = txtTanmatsuSu;
        this.btnTanmatsuInputDialog = btnTanmatsuInputDialog;
        this.hidMotoData = hidMotoData;
    }

    public RString getTxtCode() {
        return txtCode;
    }

    public RString getTxtName() {
        return txtName;
    }

    public RString getTxtTanmatsuSu() {
        return txtTanmatsuSu;
    }

    public ButtonDialog getBtnTanmatsuInputDialog() {
        return btnTanmatsuInputDialog;
    }

    public RString getHidMotoData() {
        return hidMotoData;
    }

    public void setTxtCode(RString txtCode) {
        this.setOriginalData("txtCode", txtCode);
        this.txtCode = txtCode;
    }

    public void setTxtName(RString txtName) {
        this.setOriginalData("txtName", txtName);
        this.txtName = txtName;
    }

    public void setTxtTanmatsuSu(RString txtTanmatsuSu) {
        this.setOriginalData("txtTanmatsuSu", txtTanmatsuSu);
        this.txtTanmatsuSu = txtTanmatsuSu;
    }

    public void setBtnTanmatsuInputDialog(ButtonDialog btnTanmatsuInputDialog) {
        this.setOriginalData("btnTanmatsuInputDialog", btnTanmatsuInputDialog);
        this.btnTanmatsuInputDialog = btnTanmatsuInputDialog;
    }

    public void setHidMotoData(RString hidMotoData) {
        this.setOriginalData("hidMotoData", hidMotoData);
        this.hidMotoData = hidMotoData;
    }

    // </editor-fold>
}
