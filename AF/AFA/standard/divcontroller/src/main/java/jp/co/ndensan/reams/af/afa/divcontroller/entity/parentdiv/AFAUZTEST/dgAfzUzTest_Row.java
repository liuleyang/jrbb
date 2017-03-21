package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAUZTEST;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Oct 07 11:12:01 CST 2015 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridSetting;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;


/**
 * dgAfzUzTest_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgAfzUzTest_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-57">

    private TextBox txtTest0;
    private RString txtTest1;
    private DropDownList txtTest2;

    public dgAfzUzTest_Row() {
        super();
        this.txtTest0 = new TextBox();
        this.txtTest1 = RString.EMPTY;
        this.txtTest2 = new DropDownList();
        this.setOriginalData("txtTest0", txtTest0);
        this.setOriginalData("txtTest1", txtTest1);
        this.setOriginalData("txtTest2", txtTest2);
    }

    public dgAfzUzTest_Row(TextBox txtTest0, RString txtTest1, DropDownList txtTest2) {
        super();
        this.setOriginalData("txtTest0", txtTest0);
        this.setOriginalData("txtTest1", txtTest1);
        this.setOriginalData("txtTest2", txtTest2);
        this.txtTest0 = txtTest0;
        this.txtTest1 = txtTest1;
        this.txtTest2 = txtTest2;
    }

    public dgAfzUzTest_Row(DataGridSetting gridSetting) {
        super();
        this.txtTest0 = new TextBox();
        this.txtTest1 = RString.EMPTY;
        this.txtTest2 = DropDownList.createInstance(gridSetting.getColumn("txtTest2").getCellDetails());
        this.setOriginalData("txtTest0", txtTest0);
        this.setOriginalData("txtTest1", txtTest1);
        this.setOriginalData("txtTest2", txtTest2);
    }

    public TextBox getTxtTest0() {
        return txtTest0;
    }

    public RString getTxtTest1() {
        return txtTest1;
    }

    public DropDownList getTxtTest2() {
        return txtTest2;
    }

    public void setTxtTest0(TextBox txtTest0) {
        this.setOriginalData("txtTest0", txtTest0);
        this.txtTest0 = txtTest0;
    }

    public void setTxtTest1(RString txtTest1) {
        this.setOriginalData("txtTest1", txtTest1);
        this.txtTest1 = txtTest1;
    }

    public void setTxtTest2(DropDownList txtTest2) {
        this.setOriginalData("txtTest2", txtTest2);
        this.txtTest2 = txtTest2;
    }

    // </editor-fold>
}
