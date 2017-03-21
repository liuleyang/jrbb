package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5060;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Sep 21 16:31:11 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgMaisuSenkyoList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgMaisuSenkyoList_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

    private RString txtSenkyoNo;
    private RString txtSenkyoName;

    public dgMaisuSenkyoList_Row() {
        super();
        this.txtSenkyoNo = RString.EMPTY;
        this.txtSenkyoName = RString.EMPTY;
        this.setOriginalData("txtSenkyoNo", txtSenkyoNo);
        this.setOriginalData("txtSenkyoName", txtSenkyoName);
    }

    public dgMaisuSenkyoList_Row(RString txtSenkyoNo, RString txtSenkyoName) {
        super();
        this.setOriginalData("txtSenkyoNo", txtSenkyoNo);
        this.setOriginalData("txtSenkyoName", txtSenkyoName);
        this.txtSenkyoNo = txtSenkyoNo;
        this.txtSenkyoName = txtSenkyoName;
    }

    public RString getTxtSenkyoNo() {
        return txtSenkyoNo;
    }

    public RString getTxtSenkyoName() {
        return txtSenkyoName;
    }

    public void setTxtSenkyoNo(RString txtSenkyoNo) {
        this.setOriginalData("txtSenkyoNo", txtSenkyoNo);
        this.txtSenkyoNo = txtSenkyoNo;
    }

    public void setTxtSenkyoName(RString txtSenkyoName) {
        this.setOriginalData("txtSenkyoName", txtSenkyoName);
        this.txtSenkyoName = txtSenkyoName;
    }

    // </editor-fold>
}
