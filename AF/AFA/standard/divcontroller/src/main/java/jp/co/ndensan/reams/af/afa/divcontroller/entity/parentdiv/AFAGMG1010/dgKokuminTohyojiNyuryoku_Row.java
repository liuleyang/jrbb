package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMG1010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Oct 06 15:55:47 CST 2015 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;


/**
 * dgKokuminTohyojiNyuryoku_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgKokuminTohyojiNyuryoku_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-57">

    private Button btnDelete;
    private RString txtNo;
    private TextBox txtKaiseianName;
    private TextBox txtRyakusho;

    public dgKokuminTohyojiNyuryoku_Row() {
        super();
        this.btnDelete = new Button();
        this.txtNo = RString.EMPTY;
        this.txtKaiseianName = new TextBox();
        this.txtRyakusho = new TextBox();
        this.setOriginalData("btnDelete", btnDelete);
        this.setOriginalData("txtNo", txtNo);
        this.setOriginalData("txtKaiseianName", txtKaiseianName);
        this.setOriginalData("txtRyakusho", txtRyakusho);
    }

    public dgKokuminTohyojiNyuryoku_Row(Button btnDelete, RString txtNo, TextBox txtKaiseianName, TextBox txtRyakusho) {
        super();
        this.setOriginalData("btnDelete", btnDelete);
        this.setOriginalData("txtNo", txtNo);
        this.setOriginalData("txtKaiseianName", txtKaiseianName);
        this.setOriginalData("txtRyakusho", txtRyakusho);
        this.btnDelete = btnDelete;
        this.txtNo = txtNo;
        this.txtKaiseianName = txtKaiseianName;
        this.txtRyakusho = txtRyakusho;
    }

    public Button getBtnDelete() {
        return btnDelete;
    }

    public RString getTxtNo() {
        return txtNo;
    }

    public TextBox getTxtKaiseianName() {
        return txtKaiseianName;
    }

    public TextBox getTxtRyakusho() {
        return txtRyakusho;
    }

    public void setBtnDelete(Button btnDelete) {
        this.setOriginalData("btnDelete", btnDelete);
        this.btnDelete = btnDelete;
    }

    public void setTxtNo(RString txtNo) {
        this.setOriginalData("txtNo", txtNo);
        this.txtNo = txtNo;
    }

    public void setTxtKaiseianName(TextBox txtKaiseianName) {
        this.setOriginalData("txtKaiseianName", txtKaiseianName);
        this.txtKaiseianName = txtKaiseianName;
    }

    public void setTxtRyakusho(TextBox txtRyakusho) {
        this.setOriginalData("txtRyakusho", txtRyakusho);
        this.txtRyakusho = txtRyakusho;
    }

    // </editor-fold>
}
