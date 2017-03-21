package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMG1020;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Jul 06 19:57:59 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;


/**
 * dgKokuminShusei_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgKokuminShusei_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">

    private RString txtNo;
    private TextBox txtKaiseianName;
    private TextBox txtRyakusho;
    private Boolean chkMutohyoSenkyoFlag;

    public dgKokuminShusei_Row() {
        super();
        this.txtNo = RString.EMPTY;
        this.txtKaiseianName = new TextBox();
        this.txtRyakusho = new TextBox();
        this.chkMutohyoSenkyoFlag = false;
        this.setOriginalData("txtNo", txtNo);
        this.setOriginalData("txtKaiseianName", txtKaiseianName);
        this.setOriginalData("txtRyakusho", txtRyakusho);
        this.setOriginalData("chkMutohyoSenkyoFlag", chkMutohyoSenkyoFlag);
    }

    public dgKokuminShusei_Row(RString txtNo, TextBox txtKaiseianName, TextBox txtRyakusho, Boolean chkMutohyoSenkyoFlag) {
        super();
        this.setOriginalData("txtNo", txtNo);
        this.setOriginalData("txtKaiseianName", txtKaiseianName);
        this.setOriginalData("txtRyakusho", txtRyakusho);
        this.setOriginalData("chkMutohyoSenkyoFlag", chkMutohyoSenkyoFlag);
        this.txtNo = txtNo;
        this.txtKaiseianName = txtKaiseianName;
        this.txtRyakusho = txtRyakusho;
        this.chkMutohyoSenkyoFlag = chkMutohyoSenkyoFlag;
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

    public Boolean getChkMutohyoSenkyoFlag() {
        return chkMutohyoSenkyoFlag;
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

    public void setChkMutohyoSenkyoFlag(Boolean chkMutohyoSenkyoFlag) {
        this.setOriginalData("chkMutohyoSenkyoFlag", chkMutohyoSenkyoFlag);
        this.chkMutohyoSenkyoFlag = chkMutohyoSenkyoFlag;
    }

    // </editor-fold>
}
