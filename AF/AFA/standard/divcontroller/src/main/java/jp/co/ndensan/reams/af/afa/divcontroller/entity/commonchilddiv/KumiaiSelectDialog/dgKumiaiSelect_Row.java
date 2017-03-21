package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.KumiaiSelectDialog;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Jun 13 10:07:29 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgKumiaiSelect_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgKumiaiSelect_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">

    private RString txtKumiaiCode;
    private RString txtKumiaiName;
    private RString txtKanaKumiaiName;
    private RString txtJusho;

    public dgKumiaiSelect_Row() {
        super();
        this.txtKumiaiCode = RString.EMPTY;
        this.txtKumiaiName = RString.EMPTY;
        this.txtKanaKumiaiName = RString.EMPTY;
        this.txtJusho = RString.EMPTY;
        this.setOriginalData("txtKumiaiCode", txtKumiaiCode);
        this.setOriginalData("txtKumiaiName", txtKumiaiName);
        this.setOriginalData("txtKanaKumiaiName", txtKanaKumiaiName);
        this.setOriginalData("txtJusho", txtJusho);
    }

    public dgKumiaiSelect_Row(RString txtKumiaiCode, RString txtKumiaiName, RString txtKanaKumiaiName, RString txtJusho) {
        super();
        this.setOriginalData("txtKumiaiCode", txtKumiaiCode);
        this.setOriginalData("txtKumiaiName", txtKumiaiName);
        this.setOriginalData("txtKanaKumiaiName", txtKanaKumiaiName);
        this.setOriginalData("txtJusho", txtJusho);
        this.txtKumiaiCode = txtKumiaiCode;
        this.txtKumiaiName = txtKumiaiName;
        this.txtKanaKumiaiName = txtKanaKumiaiName;
        this.txtJusho = txtJusho;
    }

    public RString getTxtKumiaiCode() {
        return txtKumiaiCode;
    }

    public RString getTxtKumiaiName() {
        return txtKumiaiName;
    }

    public RString getTxtKanaKumiaiName() {
        return txtKanaKumiaiName;
    }

    public RString getTxtJusho() {
        return txtJusho;
    }

    public void setTxtKumiaiCode(RString txtKumiaiCode) {
        this.setOriginalData("txtKumiaiCode", txtKumiaiCode);
        this.txtKumiaiCode = txtKumiaiCode;
    }

    public void setTxtKumiaiName(RString txtKumiaiName) {
        this.setOriginalData("txtKumiaiName", txtKumiaiName);
        this.txtKumiaiName = txtKumiaiName;
    }

    public void setTxtKanaKumiaiName(RString txtKanaKumiaiName) {
        this.setOriginalData("txtKanaKumiaiName", txtKanaKumiaiName);
        this.txtKanaKumiaiName = txtKanaKumiaiName;
    }

    public void setTxtJusho(RString txtJusho) {
        this.setOriginalData("txtJusho", txtJusho);
        this.txtJusho = txtJusho;
    }

    // </editor-fold>
}
