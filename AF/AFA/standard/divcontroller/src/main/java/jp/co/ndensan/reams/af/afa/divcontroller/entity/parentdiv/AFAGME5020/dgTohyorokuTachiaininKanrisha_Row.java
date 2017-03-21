package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5020;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Oct 19 21:48:08 CST 2015 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxTime;


/**
 * dgTohyorokuTachiaininKanrisha_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgTohyorokuTachiaininKanrisha_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-57">

    private TextBox txtToha;
    private TextBox txtShimei;
    private TextBoxTime txtSankaiTime;

    public dgTohyorokuTachiaininKanrisha_Row() {
        super();
        this.txtToha = new TextBox();
        this.txtShimei = new TextBox();
        this.txtSankaiTime = new TextBoxTime();
        this.setOriginalData("txtToha", txtToha);
        this.setOriginalData("txtShimei", txtShimei);
        this.setOriginalData("txtSankaiTime", txtSankaiTime);
    }

    public dgTohyorokuTachiaininKanrisha_Row(TextBox txtToha, TextBox txtShimei, TextBoxTime txtSankaiTime) {
        super();
        this.setOriginalData("txtToha", txtToha);
        this.setOriginalData("txtShimei", txtShimei);
        this.setOriginalData("txtSankaiTime", txtSankaiTime);
        this.txtToha = txtToha;
        this.txtShimei = txtShimei;
        this.txtSankaiTime = txtSankaiTime;
    }

    public TextBox getTxtToha() {
        return txtToha;
    }

    public TextBox getTxtShimei() {
        return txtShimei;
    }

    public TextBoxTime getTxtSankaiTime() {
        return txtSankaiTime;
    }

    public void setTxtToha(TextBox txtToha) {
        this.setOriginalData("txtToha", txtToha);
        this.txtToha = txtToha;
    }

    public void setTxtShimei(TextBox txtShimei) {
        this.setOriginalData("txtShimei", txtShimei);
        this.txtShimei = txtShimei;
    }

    public void setTxtSankaiTime(TextBoxTime txtSankaiTime) {
        this.setOriginalData("txtSankaiTime", txtSankaiTime);
        this.txtSankaiTime = txtSankaiTime;
    }

    // </editor-fold>
}
