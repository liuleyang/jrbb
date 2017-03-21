package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2070;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Sat Sep 10 11:11:35 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgKumiaiList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgKumiaiList_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

    private RString txtCode;
    private RString txtName;
    private RString txtKanaName;
    private RString txtJusho;
    private RString hidMotoData;

    public dgKumiaiList_Row() {
        super();
        this.txtCode = RString.EMPTY;
        this.txtName = RString.EMPTY;
        this.txtKanaName = RString.EMPTY;
        this.txtJusho = RString.EMPTY;
        this.hidMotoData = RString.EMPTY;
        this.setOriginalData("txtCode", txtCode);
        this.setOriginalData("txtName", txtName);
        this.setOriginalData("txtKanaName", txtKanaName);
        this.setOriginalData("txtJusho", txtJusho);
        this.setOriginalData("hidMotoData", hidMotoData);
    }

    public dgKumiaiList_Row(RString txtCode, RString txtName, RString txtKanaName, RString txtJusho, RString hidMotoData) {
        super();
        this.setOriginalData("txtCode", txtCode);
        this.setOriginalData("txtName", txtName);
        this.setOriginalData("txtKanaName", txtKanaName);
        this.setOriginalData("txtJusho", txtJusho);
        this.setOriginalData("hidMotoData", hidMotoData);
        this.txtCode = txtCode;
        this.txtName = txtName;
        this.txtKanaName = txtKanaName;
        this.txtJusho = txtJusho;
        this.hidMotoData = hidMotoData;
    }

    public RString getTxtCode() {
        return txtCode;
    }

    public RString getTxtName() {
        return txtName;
    }

    public RString getTxtKanaName() {
        return txtKanaName;
    }

    public RString getTxtJusho() {
        return txtJusho;
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

    public void setTxtKanaName(RString txtKanaName) {
        this.setOriginalData("txtKanaName", txtKanaName);
        this.txtKanaName = txtKanaName;
    }

    public void setTxtJusho(RString txtJusho) {
        this.setOriginalData("txtJusho", txtJusho);
        this.txtJusho = txtJusho;
    }

    public void setHidMotoData(RString hidMotoData) {
        this.setOriginalData("hidMotoData", hidMotoData);
        this.hidMotoData = hidMotoData;
    }

    // </editor-fold>
}
