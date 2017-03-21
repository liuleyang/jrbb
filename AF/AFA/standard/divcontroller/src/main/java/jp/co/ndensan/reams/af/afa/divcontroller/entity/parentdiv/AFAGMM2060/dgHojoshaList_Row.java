package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2060;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Sat Sep 10 11:42:04 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgHojoshaList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgHojoshaList_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

    private RString txtCode;
    private RString txtName;
    private RString txtTohyojoName;
    private RString txtTohyojoCode;
    private RString hidMotoData;

    public dgHojoshaList_Row() {
        super();
        this.txtCode = RString.EMPTY;
        this.txtName = RString.EMPTY;
        this.txtTohyojoName = RString.EMPTY;
        this.txtTohyojoCode = RString.EMPTY;
        this.hidMotoData = RString.EMPTY;
        this.setOriginalData("txtCode", txtCode);
        this.setOriginalData("txtName", txtName);
        this.setOriginalData("txtTohyojoName", txtTohyojoName);
        this.setOriginalData("txtTohyojoCode", txtTohyojoCode);
        this.setOriginalData("hidMotoData", hidMotoData);
    }

    public dgHojoshaList_Row(RString txtCode, RString txtName, RString txtTohyojoName, RString txtTohyojoCode, RString hidMotoData) {
        super();
        this.setOriginalData("txtCode", txtCode);
        this.setOriginalData("txtName", txtName);
        this.setOriginalData("txtTohyojoName", txtTohyojoName);
        this.setOriginalData("txtTohyojoCode", txtTohyojoCode);
        this.setOriginalData("hidMotoData", hidMotoData);
        this.txtCode = txtCode;
        this.txtName = txtName;
        this.txtTohyojoName = txtTohyojoName;
        this.txtTohyojoCode = txtTohyojoCode;
        this.hidMotoData = hidMotoData;
    }

    public RString getTxtCode() {
        return txtCode;
    }

    public RString getTxtName() {
        return txtName;
    }

    public RString getTxtTohyojoName() {
        return txtTohyojoName;
    }

    public RString getTxtTohyojoCode() {
        return txtTohyojoCode;
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

    public void setTxtTohyojoName(RString txtTohyojoName) {
        this.setOriginalData("txtTohyojoName", txtTohyojoName);
        this.txtTohyojoName = txtTohyojoName;
    }

    public void setTxtTohyojoCode(RString txtTohyojoCode) {
        this.setOriginalData("txtTohyojoCode", txtTohyojoCode);
        this.txtTohyojoCode = txtTohyojoCode;
    }

    public void setHidMotoData(RString hidMotoData) {
        this.setOriginalData("hidMotoData", hidMotoData);
        this.hidMotoData = hidMotoData;
    }

    // </editor-fold>
}
