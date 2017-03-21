package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM1030;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Sep 06 11:22:25 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgPrintSortTaishoChohyo_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgPrintSortTaishoChohyo_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

    private RString txtChohyoID;
    private RString txtChohyoName;

    public dgPrintSortTaishoChohyo_Row() {
        super();
        this.txtChohyoID = RString.EMPTY;
        this.txtChohyoName = RString.EMPTY;
        this.setOriginalData("txtChohyoID", txtChohyoID);
        this.setOriginalData("txtChohyoName", txtChohyoName);
    }

    public dgPrintSortTaishoChohyo_Row(RString txtChohyoID, RString txtChohyoName) {
        super();
        this.setOriginalData("txtChohyoID", txtChohyoID);
        this.setOriginalData("txtChohyoName", txtChohyoName);
        this.txtChohyoID = txtChohyoID;
        this.txtChohyoName = txtChohyoName;
    }

    public RString getTxtChohyoID() {
        return txtChohyoID;
    }

    public RString getTxtChohyoName() {
        return txtChohyoName;
    }

    public void setTxtChohyoID(RString txtChohyoID) {
        this.setOriginalData("txtChohyoID", txtChohyoID);
        this.txtChohyoID = txtChohyoID;
    }

    public void setTxtChohyoName(RString txtChohyoName) {
        this.setOriginalData("txtChohyoName", txtChohyoName);
        this.txtChohyoName = txtChohyoName;
    }

    // </editor-fold>
}
