package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB1040;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Apr 13 15:40:58 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgRePrintSenkyojiShohonSelect_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgRePrintSenkyojiShohonSelect_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-02-19_14-33-39">

    private RString txtShohonName;
    private TextBoxFlexibleDate txtTohyoYMD;
    private TextBoxFlexibleDate txtNenreiTotatsuYMD;
    private TextBoxFlexibleDate txtShoriYMD;
    private RString txtShohonNo;

    public dgRePrintSenkyojiShohonSelect_Row() {
        super();
        this.txtShohonName = RString.EMPTY;
        this.txtTohyoYMD = new TextBoxFlexibleDate();
        this.txtNenreiTotatsuYMD = new TextBoxFlexibleDate();
        this.txtShoriYMD = new TextBoxFlexibleDate();
        this.txtShohonNo = RString.EMPTY;
        this.setOriginalData("txtShohonName", txtShohonName);
        this.setOriginalData("txtTohyoYMD", txtTohyoYMD);
        this.setOriginalData("txtNenreiTotatsuYMD", txtNenreiTotatsuYMD);
        this.setOriginalData("txtShoriYMD", txtShoriYMD);
        this.setOriginalData("txtShohonNo", txtShohonNo);
    }

    public dgRePrintSenkyojiShohonSelect_Row(RString txtShohonName, TextBoxFlexibleDate txtTohyoYMD, TextBoxFlexibleDate txtNenreiTotatsuYMD, TextBoxFlexibleDate txtShoriYMD, RString txtShohonNo) {
        super();
        this.setOriginalData("txtShohonName", txtShohonName);
        this.setOriginalData("txtTohyoYMD", txtTohyoYMD);
        this.setOriginalData("txtNenreiTotatsuYMD", txtNenreiTotatsuYMD);
        this.setOriginalData("txtShoriYMD", txtShoriYMD);
        this.setOriginalData("txtShohonNo", txtShohonNo);
        this.txtShohonName = txtShohonName;
        this.txtTohyoYMD = txtTohyoYMD;
        this.txtNenreiTotatsuYMD = txtNenreiTotatsuYMD;
        this.txtShoriYMD = txtShoriYMD;
        this.txtShohonNo = txtShohonNo;
    }

    public RString getTxtShohonName() {
        return txtShohonName;
    }

    public TextBoxFlexibleDate getTxtTohyoYMD() {
        return txtTohyoYMD;
    }

    public TextBoxFlexibleDate getTxtNenreiTotatsuYMD() {
        return txtNenreiTotatsuYMD;
    }

    public TextBoxFlexibleDate getTxtShoriYMD() {
        return txtShoriYMD;
    }

    public RString getTxtShohonNo() {
        return txtShohonNo;
    }

    public void setTxtShohonName(RString txtShohonName) {
        this.setOriginalData("txtShohonName", txtShohonName);
        this.txtShohonName = txtShohonName;
    }

    public void setTxtTohyoYMD(TextBoxFlexibleDate txtTohyoYMD) {
        this.setOriginalData("txtTohyoYMD", txtTohyoYMD);
        this.txtTohyoYMD = txtTohyoYMD;
    }

    public void setTxtNenreiTotatsuYMD(TextBoxFlexibleDate txtNenreiTotatsuYMD) {
        this.setOriginalData("txtNenreiTotatsuYMD", txtNenreiTotatsuYMD);
        this.txtNenreiTotatsuYMD = txtNenreiTotatsuYMD;
    }

    public void setTxtShoriYMD(TextBoxFlexibleDate txtShoriYMD) {
        this.setOriginalData("txtShoriYMD", txtShoriYMD);
        this.txtShoriYMD = txtShoriYMD;
    }

    public void setTxtShohonNo(RString txtShohonNo) {
        this.setOriginalData("txtShohonNo", txtShohonNo);
        this.txtShohonNo = txtShohonNo;
    }

    // </editor-fold>
}
