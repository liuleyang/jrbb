package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyojoSelectDialog;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Mon Sep 19 13:49:11 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgTohyojoSelect_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgTohyojoSelect_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

    private RString txtTohyojoCode;
    private RString txtTohyojoName;
    private RString txtKanaTohyojoName;

    public dgTohyojoSelect_Row() {
        super();
        this.txtTohyojoCode = RString.EMPTY;
        this.txtTohyojoName = RString.EMPTY;
        this.txtKanaTohyojoName = RString.EMPTY;
        this.setOriginalData("txtTohyojoCode", txtTohyojoCode);
        this.setOriginalData("txtTohyojoName", txtTohyojoName);
        this.setOriginalData("txtKanaTohyojoName", txtKanaTohyojoName);
    }

    public dgTohyojoSelect_Row(RString txtTohyojoCode, RString txtTohyojoName, RString txtKanaTohyojoName) {
        super();
        this.setOriginalData("txtTohyojoCode", txtTohyojoCode);
        this.setOriginalData("txtTohyojoName", txtTohyojoName);
        this.setOriginalData("txtKanaTohyojoName", txtKanaTohyojoName);
        this.txtTohyojoCode = txtTohyojoCode;
        this.txtTohyojoName = txtTohyojoName;
        this.txtKanaTohyojoName = txtKanaTohyojoName;
    }

    public RString getTxtTohyojoCode() {
        return txtTohyojoCode;
    }

    public RString getTxtTohyojoName() {
        return txtTohyojoName;
    }

    public RString getTxtKanaTohyojoName() {
        return txtKanaTohyojoName;
    }

    public void setTxtTohyojoCode(RString txtTohyojoCode) {
        this.setOriginalData("txtTohyojoCode", txtTohyojoCode);
        this.txtTohyojoCode = txtTohyojoCode;
    }

    public void setTxtTohyojoName(RString txtTohyojoName) {
        this.setOriginalData("txtTohyojoName", txtTohyojoName);
        this.txtTohyojoName = txtTohyojoName;
    }

    public void setTxtKanaTohyojoName(RString txtKanaTohyojoName) {
        this.setOriginalData("txtKanaTohyojoName", txtKanaTohyojoName);
        this.txtKanaTohyojoName = txtKanaTohyojoName;
    }

    // </editor-fold>
}
