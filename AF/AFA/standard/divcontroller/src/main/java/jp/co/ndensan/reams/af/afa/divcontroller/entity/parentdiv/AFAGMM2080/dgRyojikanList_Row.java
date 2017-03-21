package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2080;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Sep 09 18:20:04 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgRyojikanList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgRyojikanList_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

    private RString txtCode;
    private RString txtName;
    private RString txtKanaName;
    private RString txtHyojiJun;
    private RString hidMotoData;

    public dgRyojikanList_Row() {
        super();
        this.txtCode = RString.EMPTY;
        this.txtName = RString.EMPTY;
        this.txtKanaName = RString.EMPTY;
        this.txtHyojiJun = RString.EMPTY;
        this.hidMotoData = RString.EMPTY;
        this.setOriginalData("txtCode", txtCode);
        this.setOriginalData("txtName", txtName);
        this.setOriginalData("txtKanaName", txtKanaName);
        this.setOriginalData("txtHyojiJun", txtHyojiJun);
        this.setOriginalData("hidMotoData", hidMotoData);
    }

    public dgRyojikanList_Row(RString txtCode, RString txtName, RString txtKanaName, RString txtHyojiJun, RString hidMotoData) {
        super();
        this.setOriginalData("txtCode", txtCode);
        this.setOriginalData("txtName", txtName);
        this.setOriginalData("txtKanaName", txtKanaName);
        this.setOriginalData("txtHyojiJun", txtHyojiJun);
        this.setOriginalData("hidMotoData", hidMotoData);
        this.txtCode = txtCode;
        this.txtName = txtName;
        this.txtKanaName = txtKanaName;
        this.txtHyojiJun = txtHyojiJun;
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

    public RString getTxtHyojiJun() {
        return txtHyojiJun;
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

    public void setTxtHyojiJun(RString txtHyojiJun) {
        this.setOriginalData("txtHyojiJun", txtHyojiJun);
        this.txtHyojiJun = txtHyojiJun;
    }

    public void setHidMotoData(RString hidMotoData) {
        this.setOriginalData("hidMotoData", hidMotoData);
        this.hidMotoData = hidMotoData;
    }

    // </editor-fold>
}
