package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.RyojikanSelectDialog;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Jun 13 16:53:40 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgRyojikanSelect_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgRyojikanSelect_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">

    private RString txtRyojikanCode;
    private RString txtRyojikanName;
    private RString txtKanaRyojikanName;
    private RString txtHyojijun;

    public dgRyojikanSelect_Row() {
        super();
        this.txtRyojikanCode = RString.EMPTY;
        this.txtRyojikanName = RString.EMPTY;
        this.txtKanaRyojikanName = RString.EMPTY;
        this.txtHyojijun = RString.EMPTY;
        this.setOriginalData("txtRyojikanCode", txtRyojikanCode);
        this.setOriginalData("txtRyojikanName", txtRyojikanName);
        this.setOriginalData("txtKanaRyojikanName", txtKanaRyojikanName);
        this.setOriginalData("txtHyojijun", txtHyojijun);
    }

    public dgRyojikanSelect_Row(RString txtRyojikanCode, RString txtRyojikanName, RString txtKanaRyojikanName, RString txtHyojijun) {
        super();
        this.setOriginalData("txtRyojikanCode", txtRyojikanCode);
        this.setOriginalData("txtRyojikanName", txtRyojikanName);
        this.setOriginalData("txtKanaRyojikanName", txtKanaRyojikanName);
        this.setOriginalData("txtHyojijun", txtHyojijun);
        this.txtRyojikanCode = txtRyojikanCode;
        this.txtRyojikanName = txtRyojikanName;
        this.txtKanaRyojikanName = txtKanaRyojikanName;
        this.txtHyojijun = txtHyojijun;
    }

    public RString getTxtRyojikanCode() {
        return txtRyojikanCode;
    }

    public RString getTxtRyojikanName() {
        return txtRyojikanName;
    }

    public RString getTxtKanaRyojikanName() {
        return txtKanaRyojikanName;
    }

    public RString getTxtHyojijun() {
        return txtHyojijun;
    }

    public void setTxtRyojikanCode(RString txtRyojikanCode) {
        this.setOriginalData("txtRyojikanCode", txtRyojikanCode);
        this.txtRyojikanCode = txtRyojikanCode;
    }

    public void setTxtRyojikanName(RString txtRyojikanName) {
        this.setOriginalData("txtRyojikanName", txtRyojikanName);
        this.txtRyojikanName = txtRyojikanName;
    }

    public void setTxtKanaRyojikanName(RString txtKanaRyojikanName) {
        this.setOriginalData("txtKanaRyojikanName", txtKanaRyojikanName);
        this.txtKanaRyojikanName = txtKanaRyojikanName;
    }

    public void setTxtHyojijun(RString txtHyojijun) {
        this.setOriginalData("txtHyojijun", txtHyojijun);
        this.txtHyojijun = txtHyojijun;
    }

    // </editor-fold>
}
