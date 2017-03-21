package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGML1010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Sep 13 19:46:46 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgZaisankuJusho_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgZaisankuJusho_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

    private RString txtChoikiCode;
    private RString txtChoikiName;

    public dgZaisankuJusho_Row() {
        super();
        this.txtChoikiCode = RString.EMPTY;
        this.txtChoikiName = RString.EMPTY;
        this.setOriginalData("txtChoikiCode", txtChoikiCode);
        this.setOriginalData("txtChoikiName", txtChoikiName);
    }

    public dgZaisankuJusho_Row(RString txtChoikiCode, RString txtChoikiName) {
        super();
        this.setOriginalData("txtChoikiCode", txtChoikiCode);
        this.setOriginalData("txtChoikiName", txtChoikiName);
        this.txtChoikiCode = txtChoikiCode;
        this.txtChoikiName = txtChoikiName;
    }

    public RString getTxtChoikiCode() {
        return txtChoikiCode;
    }

    public RString getTxtChoikiName() {
        return txtChoikiName;
    }

    public void setTxtChoikiCode(RString txtChoikiCode) {
        this.setOriginalData("txtChoikiCode", txtChoikiCode);
        this.txtChoikiCode = txtChoikiCode;
    }

    public void setTxtChoikiName(RString txtChoikiName) {
        this.setOriginalData("txtChoikiName", txtChoikiName);
        this.txtChoikiName = txtChoikiName;
    }

    // </editor-fold>
}
