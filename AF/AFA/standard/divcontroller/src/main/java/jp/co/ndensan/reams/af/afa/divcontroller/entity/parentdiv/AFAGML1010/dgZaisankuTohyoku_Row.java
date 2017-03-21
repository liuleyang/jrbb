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
 * dgZaisankuTohyoku_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgZaisankuTohyoku_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

    private RString txtTohyokuCode;
    private RString txtTohyokuName;

    public dgZaisankuTohyoku_Row() {
        super();
        this.txtTohyokuCode = RString.EMPTY;
        this.txtTohyokuName = RString.EMPTY;
        this.setOriginalData("txtTohyokuCode", txtTohyokuCode);
        this.setOriginalData("txtTohyokuName", txtTohyokuName);
    }

    public dgZaisankuTohyoku_Row(RString txtTohyokuCode, RString txtTohyokuName) {
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
