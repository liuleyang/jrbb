package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyorokuKyohiNyuryoku;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Oct 20 14:29:38 CST 2015 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;


/**
 * dgTohyorokuKyohiNyuryoku_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgTohyorokuKyohiNyuryoku_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-57">

    private RString txtShimei;
    private RString txtJiyu;
    private Boolean chkKariTohyo;

    public dgTohyorokuKyohiNyuryoku_Row() {
        super();
        this.txtShimei = RString.EMPTY;
        this.txtJiyu = RString.EMPTY;
        this.chkKariTohyo = false;
        this.setOriginalData("txtShimei", txtShimei);
        this.setOriginalData("txtJiyu", txtJiyu);
        this.setOriginalData("chkKariTohyo", chkKariTohyo);
    }

    public dgTohyorokuKyohiNyuryoku_Row(RString txtShimei, RString txtJiyu, Boolean chkKariTohyo) {
        super();
        this.setOriginalData("txtShimei", txtShimei);
        this.setOriginalData("txtJiyu", txtJiyu);
        this.setOriginalData("chkKariTohyo", chkKariTohyo);
        this.txtShimei = txtShimei;
        this.txtJiyu = txtJiyu;
        this.chkKariTohyo = chkKariTohyo;
    }

    public RString getTxtShimei() {
        return txtShimei;
    }

    public RString getTxtJiyu() {
        return txtJiyu;
    }

    public Boolean getChkKariTohyo() {
        return chkKariTohyo;
    }

    public void setTxtShimei(RString txtShimei) {
        this.setOriginalData("txtShimei", txtShimei);
        this.txtShimei = txtShimei;
    }

    public void setTxtJiyu(RString txtJiyu) {
        this.setOriginalData("txtJiyu", txtJiyu);
        this.txtJiyu = txtJiyu;
    }

    public void setChkKariTohyo(Boolean chkKariTohyo) {
        this.setOriginalData("chkKariTohyo", chkKariTohyo);
        this.chkKariTohyo = chkKariTohyo;
    }

    // </editor-fold>
}
