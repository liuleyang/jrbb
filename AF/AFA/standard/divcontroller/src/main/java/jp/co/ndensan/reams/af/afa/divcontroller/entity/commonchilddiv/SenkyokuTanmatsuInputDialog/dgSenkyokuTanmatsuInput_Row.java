package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SenkyokuTanmatsuInputDialog;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Sep 20 20:24:29 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgSenkyokuTanmatsuInput_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgSenkyokuTanmatsuInput_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

    private TextBox txtTanmatsuID;
    private RString hidMotoData;

    public dgSenkyokuTanmatsuInput_Row() {
        super();
        this.txtTanmatsuID = new TextBox();
        this.hidMotoData = RString.EMPTY;
        this.setOriginalData("txtTanmatsuID", txtTanmatsuID);
        this.setOriginalData("hidMotoData", hidMotoData);
    }

    public dgSenkyokuTanmatsuInput_Row(TextBox txtTanmatsuID, RString hidMotoData) {
        super();
        this.setOriginalData("txtTanmatsuID", txtTanmatsuID);
        this.setOriginalData("hidMotoData", hidMotoData);
        this.txtTanmatsuID = txtTanmatsuID;
        this.hidMotoData = hidMotoData;
    }

    public TextBox getTxtTanmatsuID() {
        return txtTanmatsuID;
    }

    public RString getHidMotoData() {
        return hidMotoData;
    }

    public void setTxtTanmatsuID(TextBox txtTanmatsuID) {
        this.setOriginalData("txtTanmatsuID", txtTanmatsuID);
        this.txtTanmatsuID = txtTanmatsuID;
    }

    public void setHidMotoData(RString hidMotoData) {
        this.setOriginalData("hidMotoData", hidMotoData);
        this.hidMotoData = hidMotoData;
    }

    // </editor-fold>
}
