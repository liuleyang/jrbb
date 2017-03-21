package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2020;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Sep 07 18:58:30 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxTime;


/**
 * dgTohyojoList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgTohyojoList_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

    private RString txtCode;
    private RString txtName;
    private RString txtKanaName;
    private TextBoxTime txtTimeFrom;
    private TextBoxTime txtTimeTo;
    private Boolean chkZaigaiTohyo;
    private RString txtYubinNo;
    private RString txtJusho;
    private RString txtAtena;
    private RString txtTel;
    private RString txtFax;
    private RString txtFileName;
    private RString hidMotoData;

    public dgTohyojoList_Row() {
        super();
        this.txtCode = RString.EMPTY;
        this.txtName = RString.EMPTY;
        this.txtKanaName = RString.EMPTY;
        this.txtTimeFrom = new TextBoxTime();
        this.txtTimeTo = new TextBoxTime();
        this.chkZaigaiTohyo = false;
        this.txtYubinNo = RString.EMPTY;
        this.txtJusho = RString.EMPTY;
        this.txtAtena = RString.EMPTY;
        this.txtTel = RString.EMPTY;
        this.txtFax = RString.EMPTY;
        this.txtFileName = RString.EMPTY;
        this.hidMotoData = RString.EMPTY;
        this.setOriginalData("txtCode", txtCode);
        this.setOriginalData("txtName", txtName);
        this.setOriginalData("txtKanaName", txtKanaName);
        this.setOriginalData("txtTimeFrom", txtTimeFrom);
        this.setOriginalData("txtTimeTo", txtTimeTo);
        this.setOriginalData("chkZaigaiTohyo", chkZaigaiTohyo);
        this.setOriginalData("txtYubinNo", txtYubinNo);
        this.setOriginalData("txtJusho", txtJusho);
        this.setOriginalData("txtAtena", txtAtena);
        this.setOriginalData("txtTel", txtTel);
        this.setOriginalData("txtFax", txtFax);
        this.setOriginalData("txtFileName", txtFileName);
        this.setOriginalData("hidMotoData", hidMotoData);
    }

    public dgTohyojoList_Row(RString txtCode, RString txtName, RString txtKanaName, TextBoxTime txtTimeFrom, TextBoxTime txtTimeTo, Boolean chkZaigaiTohyo, RString txtYubinNo, RString txtJusho, RString txtAtena, RString txtTel, RString txtFax, RString txtFileName, RString hidMotoData) {
        super();
        this.setOriginalData("txtCode", txtCode);
        this.setOriginalData("txtName", txtName);
        this.setOriginalData("txtKanaName", txtKanaName);
        this.setOriginalData("txtTimeFrom", txtTimeFrom);
        this.setOriginalData("txtTimeTo", txtTimeTo);
        this.setOriginalData("chkZaigaiTohyo", chkZaigaiTohyo);
        this.setOriginalData("txtYubinNo", txtYubinNo);
        this.setOriginalData("txtJusho", txtJusho);
        this.setOriginalData("txtAtena", txtAtena);
        this.setOriginalData("txtTel", txtTel);
        this.setOriginalData("txtFax", txtFax);
        this.setOriginalData("txtFileName", txtFileName);
        this.setOriginalData("hidMotoData", hidMotoData);
        this.txtCode = txtCode;
        this.txtName = txtName;
        this.txtKanaName = txtKanaName;
        this.txtTimeFrom = txtTimeFrom;
        this.txtTimeTo = txtTimeTo;
        this.chkZaigaiTohyo = chkZaigaiTohyo;
        this.txtYubinNo = txtYubinNo;
        this.txtJusho = txtJusho;
        this.txtAtena = txtAtena;
        this.txtTel = txtTel;
        this.txtFax = txtFax;
        this.txtFileName = txtFileName;
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

    public TextBoxTime getTxtTimeFrom() {
        return txtTimeFrom;
    }

    public TextBoxTime getTxtTimeTo() {
        return txtTimeTo;
    }

    public Boolean getChkZaigaiTohyo() {
        return chkZaigaiTohyo;
    }

    public RString getTxtYubinNo() {
        return txtYubinNo;
    }

    public RString getTxtJusho() {
        return txtJusho;
    }

    public RString getTxtAtena() {
        return txtAtena;
    }

    public RString getTxtTel() {
        return txtTel;
    }

    public RString getTxtFax() {
        return txtFax;
    }

    public RString getTxtFileName() {
        return txtFileName;
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

    public void setTxtTimeFrom(TextBoxTime txtTimeFrom) {
        this.setOriginalData("txtTimeFrom", txtTimeFrom);
        this.txtTimeFrom = txtTimeFrom;
    }

    public void setTxtTimeTo(TextBoxTime txtTimeTo) {
        this.setOriginalData("txtTimeTo", txtTimeTo);
        this.txtTimeTo = txtTimeTo;
    }

    public void setChkZaigaiTohyo(Boolean chkZaigaiTohyo) {
        this.setOriginalData("chkZaigaiTohyo", chkZaigaiTohyo);
        this.chkZaigaiTohyo = chkZaigaiTohyo;
    }

    public void setTxtYubinNo(RString txtYubinNo) {
        this.setOriginalData("txtYubinNo", txtYubinNo);
        this.txtYubinNo = txtYubinNo;
    }

    public void setTxtJusho(RString txtJusho) {
        this.setOriginalData("txtJusho", txtJusho);
        this.txtJusho = txtJusho;
    }

    public void setTxtAtena(RString txtAtena) {
        this.setOriginalData("txtAtena", txtAtena);
        this.txtAtena = txtAtena;
    }

    public void setTxtTel(RString txtTel) {
        this.setOriginalData("txtTel", txtTel);
        this.txtTel = txtTel;
    }

    public void setTxtFax(RString txtFax) {
        this.setOriginalData("txtFax", txtFax);
        this.txtFax = txtFax;
    }

    public void setTxtFileName(RString txtFileName) {
        this.setOriginalData("txtFileName", txtFileName);
        this.txtFileName = txtFileName;
    }

    public void setHidMotoData(RString hidMotoData) {
        this.setOriginalData("hidMotoData", hidMotoData);
        this.hidMotoData = hidMotoData;
    }

    // </editor-fold>
}
