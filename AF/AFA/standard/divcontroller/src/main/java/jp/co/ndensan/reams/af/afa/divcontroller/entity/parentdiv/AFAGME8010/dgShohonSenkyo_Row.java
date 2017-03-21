package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME8010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Sep 21 17:30:55 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgShohonSenkyo_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShohonSenkyo_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

    private RString txtShohonName;
    private RString txtSenkyoName;
    private RString txtShohonNo;

    public dgShohonSenkyo_Row() {
        super();
        this.txtShohonName = RString.EMPTY;
        this.txtSenkyoName = RString.EMPTY;
        this.txtShohonNo = RString.EMPTY;
        this.setOriginalData("txtShohonName", txtShohonName);
        this.setOriginalData("txtSenkyoName", txtSenkyoName);
        this.setOriginalData("txtShohonNo", txtShohonNo);
    }

    public dgShohonSenkyo_Row(RString txtShohonName, RString txtSenkyoName, RString txtShohonNo) {
        super();
        this.setOriginalData("txtShohonName", txtShohonName);
        this.setOriginalData("txtSenkyoName", txtSenkyoName);
        this.setOriginalData("txtShohonNo", txtShohonNo);
        this.txtShohonName = txtShohonName;
        this.txtSenkyoName = txtSenkyoName;
        this.txtShohonNo = txtShohonNo;
    }

    public RString getTxtShohonName() {
        return txtShohonName;
    }

    public RString getTxtSenkyoName() {
        return txtSenkyoName;
    }

    public RString getTxtShohonNo() {
        return txtShohonNo;
    }

    public void setTxtShohonName(RString txtShohonName) {
        this.setOriginalData("txtShohonName", txtShohonName);
        this.txtShohonName = txtShohonName;
    }

    public void setTxtSenkyoName(RString txtSenkyoName) {
        this.setOriginalData("txtSenkyoName", txtSenkyoName);
        this.txtSenkyoName = txtSenkyoName;
    }

    public void setTxtShohonNo(RString txtShohonNo) {
        this.setOriginalData("txtShohonNo", txtShohonNo);
        this.txtShohonNo = txtShohonNo;
    }

    // </editor-fold>
}
