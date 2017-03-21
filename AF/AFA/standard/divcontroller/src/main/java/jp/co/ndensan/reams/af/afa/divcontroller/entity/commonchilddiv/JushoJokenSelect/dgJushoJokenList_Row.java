package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.JushoJokenSelect;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Jul 26 17:38:14 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgJushoJokenList_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgJushoJokenList_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">

    private RString txtJushoJokenCode;
    private RString txtJushoJokenName;

    public dgJushoJokenList_Row() {
        super();
        this.txtJushoJokenCode = RString.EMPTY;
        this.txtJushoJokenName = RString.EMPTY;
        this.setOriginalData("txtJushoJokenCode", txtJushoJokenCode);
        this.setOriginalData("txtJushoJokenName", txtJushoJokenName);
    }

    public dgJushoJokenList_Row(RString txtJushoJokenCode, RString txtJushoJokenName) {
        super();
        this.setOriginalData("txtJushoJokenCode", txtJushoJokenCode);
        this.setOriginalData("txtJushoJokenName", txtJushoJokenName);
        this.txtJushoJokenCode = txtJushoJokenCode;
        this.txtJushoJokenName = txtJushoJokenName;
    }

    public RString getTxtJushoJokenCode() {
        return txtJushoJokenCode;
    }

    public RString getTxtJushoJokenName() {
        return txtJushoJokenName;
    }

    public void setTxtJushoJokenCode(RString txtJushoJokenCode) {
        this.setOriginalData("txtJushoJokenCode", txtJushoJokenCode);
        this.txtJushoJokenCode = txtJushoJokenCode;
    }

    public void setTxtJushoJokenName(RString txtJushoJokenName) {
        this.setOriginalData("txtJushoJokenName", txtJushoJokenName);
        this.txtJushoJokenName = txtJushoJokenName;
    }

    // </editor-fold>
}
