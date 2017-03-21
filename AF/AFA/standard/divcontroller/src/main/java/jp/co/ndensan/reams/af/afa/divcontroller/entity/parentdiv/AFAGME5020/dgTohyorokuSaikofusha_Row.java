package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5020;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Oct 19 21:48:08 CST 2015 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;


/**
 * dgTohyorokuSaikofusha_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgTohyorokuSaikofusha_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-57">

    private TextBox txtShimei;
    private TextBox txtJiyu;

    public dgTohyorokuSaikofusha_Row() {
        super();
        this.txtShimei = new TextBox();
        this.txtJiyu = new TextBox();
        this.setOriginalData("txtShimei", txtShimei);
        this.setOriginalData("txtJiyu", txtJiyu);
    }

    public dgTohyorokuSaikofusha_Row(TextBox txtShimei, TextBox txtJiyu) {
        super();
        this.setOriginalData("txtShimei", txtShimei);
        this.setOriginalData("txtJiyu", txtJiyu);
        this.txtShimei = txtShimei;
        this.txtJiyu = txtJiyu;
    }

    public TextBox getTxtShimei() {
        return txtShimei;
    }

    public TextBox getTxtJiyu() {
        return txtJiyu;
    }

    public void setTxtShimei(TextBox txtShimei) {
        this.setOriginalData("txtShimei", txtShimei);
        this.txtShimei = txtShimei;
    }

    public void setTxtJiyu(TextBox txtJiyu) {
        this.setOriginalData("txtJiyu", txtJiyu);
        this.txtJiyu = txtJiyu;
    }

    // </editor-fold>
}
