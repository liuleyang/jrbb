package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB2010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Thu Aug 18 15:25:28 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgNyujokenTohyokuSelect_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgNyujokenTohyokuSelect_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

    private RString txtTohyokuCode;
    private RString txtTohyokuName;

    public dgNyujokenTohyokuSelect_Row() {
        super();
        this.txtTohyokuCode = RString.EMPTY;
        this.txtTohyokuName = RString.EMPTY;
        this.setOriginalData("txtTohyokuCode", txtTohyokuCode);
        this.setOriginalData("txtTohyokuName", txtTohyokuName);
    }

    public dgNyujokenTohyokuSelect_Row(RString txtTohyokuCode, RString txtTohyokuName) {
        super();
        this.setOriginalData("txtTohyokuCode", txtTohyokuCode);
        this.setOriginalData("txtTohyokuName", txtTohyokuName);
        this.txtTohyokuCode = txtTohyokuCode;
        this.txtTohyokuName = txtTohyokuName;
    }

    public RString getTxtTohyokuCode() {
        return txtTohyokuCode;
    }

    public RString getTxtTohyokuName() {
        return txtTohyokuName;
    }

    public void setTxtTohyokuCode(RString txtTohyokuCode) {
        this.setOriginalData("txtTohyokuCode", txtTohyokuCode);
        this.txtTohyokuCode = txtTohyokuCode;
    }

    public void setTxtTohyokuName(RString txtTohyokuName) {
        this.setOriginalData("txtTohyokuName", txtTohyokuName);
        this.txtTohyokuName = txtTohyokuName;
    }

    // </editor-fold>
}
