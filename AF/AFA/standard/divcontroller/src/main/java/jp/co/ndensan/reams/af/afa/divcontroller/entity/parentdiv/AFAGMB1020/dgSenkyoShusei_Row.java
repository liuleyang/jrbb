package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB1020;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Mar 25 18:53:25 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgSenkyoShusei_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgSenkyoShusei_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-02-19_14-33-39">

    private RString txtNo;
    private RString txtLevel;
    private TextBox txtSenkyoName;
    private TextBox txtSenkyoRyakusho;
    private TextBox txtSenkyoMark;
    private Boolean chkMutohyoSenkyoFlag;
    private TextBoxFlexibleDate txtKokujiYMD;
    private TextBoxFlexibleDate txtTohyoUketsukeYMD;
    private TextBoxFlexibleDate txtKijunYMD;
    private TextBoxFlexibleDate txtMeiboTorokuYMD;
    private TextBoxFlexibleDate txtTenshutsuKigenYMD;
    private TextBoxFlexibleDate txtTennyuKigenYMD;

    public dgSenkyoShusei_Row() {
        super();
        this.txtNo = RString.EMPTY;
        this.txtLevel = RString.EMPTY;
        this.txtSenkyoName = new TextBox();
        this.txtSenkyoRyakusho = new TextBox();
        this.txtSenkyoMark = new TextBox();
        this.chkMutohyoSenkyoFlag = false;
        this.txtKokujiYMD = new TextBoxFlexibleDate();
        this.txtTohyoUketsukeYMD = new TextBoxFlexibleDate();
        this.txtKijunYMD = new TextBoxFlexibleDate();
        this.txtMeiboTorokuYMD = new TextBoxFlexibleDate();
        this.txtTenshutsuKigenYMD = new TextBoxFlexibleDate();
        this.txtTennyuKigenYMD = new TextBoxFlexibleDate();
        this.setOriginalData("txtNo", txtNo);
        this.setOriginalData("txtLevel", txtLevel);
        this.setOriginalData("txtSenkyoName", txtSenkyoName);
        this.setOriginalData("txtSenkyoRyakusho", txtSenkyoRyakusho);
        this.setOriginalData("txtSenkyoMark", txtSenkyoMark);
        this.setOriginalData("chkMutohyoSenkyoFlag", chkMutohyoSenkyoFlag);
        this.setOriginalData("txtKokujiYMD", txtKokujiYMD);
        this.setOriginalData("txtTohyoUketsukeYMD", txtTohyoUketsukeYMD);
        this.setOriginalData("txtKijunYMD", txtKijunYMD);
        this.setOriginalData("txtMeiboTorokuYMD", txtMeiboTorokuYMD);
        this.setOriginalData("txtTenshutsuKigenYMD", txtTenshutsuKigenYMD);
        this.setOriginalData("txtTennyuKigenYMD", txtTennyuKigenYMD);
    }

    public dgSenkyoShusei_Row(RString txtNo, RString txtLevel, TextBox txtSenkyoName, TextBox txtSenkyoRyakusho, TextBox txtSenkyoMark, Boolean chkMutohyoSenkyoFlag, TextBoxFlexibleDate txtKokujiYMD, TextBoxFlexibleDate txtTohyoUketsukeYMD, TextBoxFlexibleDate txtKijunYMD, TextBoxFlexibleDate txtMeiboTorokuYMD, TextBoxFlexibleDate txtTenshutsuKigenYMD, TextBoxFlexibleDate txtTennyuKigenYMD) {
        super();
        this.setOriginalData("txtNo", txtNo);
        this.setOriginalData("txtLevel", txtLevel);
        this.setOriginalData("txtSenkyoName", txtSenkyoName);
        this.setOriginalData("txtSenkyoRyakusho", txtSenkyoRyakusho);
        this.setOriginalData("txtSenkyoMark", txtSenkyoMark);
        this.setOriginalData("chkMutohyoSenkyoFlag", chkMutohyoSenkyoFlag);
        this.setOriginalData("txtKokujiYMD", txtKokujiYMD);
        this.setOriginalData("txtTohyoUketsukeYMD", txtTohyoUketsukeYMD);
        this.setOriginalData("txtKijunYMD", txtKijunYMD);
        this.setOriginalData("txtMeiboTorokuYMD", txtMeiboTorokuYMD);
        this.setOriginalData("txtTenshutsuKigenYMD", txtTenshutsuKigenYMD);
        this.setOriginalData("txtTennyuKigenYMD", txtTennyuKigenYMD);
        this.txtNo = txtNo;
        this.txtLevel = txtLevel;
        this.txtSenkyoName = txtSenkyoName;
        this.txtSenkyoRyakusho = txtSenkyoRyakusho;
        this.txtSenkyoMark = txtSenkyoMark;
        this.chkMutohyoSenkyoFlag = chkMutohyoSenkyoFlag;
        this.txtKokujiYMD = txtKokujiYMD;
        this.txtTohyoUketsukeYMD = txtTohyoUketsukeYMD;
        this.txtKijunYMD = txtKijunYMD;
        this.txtMeiboTorokuYMD = txtMeiboTorokuYMD;
        this.txtTenshutsuKigenYMD = txtTenshutsuKigenYMD;
        this.txtTennyuKigenYMD = txtTennyuKigenYMD;
    }

    public RString getTxtNo() {
        return txtNo;
    }

    public RString getTxtLevel() {
        return txtLevel;
    }

    public TextBox getTxtSenkyoName() {
        return txtSenkyoName;
    }

    public TextBox getTxtSenkyoRyakusho() {
        return txtSenkyoRyakusho;
    }

    public TextBox getTxtSenkyoMark() {
        return txtSenkyoMark;
    }

    public Boolean getChkMutohyoSenkyoFlag() {
        return chkMutohyoSenkyoFlag;
    }

    public TextBoxFlexibleDate getTxtKokujiYMD() {
        return txtKokujiYMD;
    }

    public TextBoxFlexibleDate getTxtTohyoUketsukeYMD() {
        return txtTohyoUketsukeYMD;
    }

    public TextBoxFlexibleDate getTxtKijunYMD() {
        return txtKijunYMD;
    }

    public TextBoxFlexibleDate getTxtMeiboTorokuYMD() {
        return txtMeiboTorokuYMD;
    }

    public TextBoxFlexibleDate getTxtTenshutsuKigenYMD() {
        return txtTenshutsuKigenYMD;
    }

    public TextBoxFlexibleDate getTxtTennyuKigenYMD() {
        return txtTennyuKigenYMD;
    }

    public void setTxtNo(RString txtNo) {
        this.setOriginalData("txtNo", txtNo);
        this.txtNo = txtNo;
    }

    public void setTxtLevel(RString txtLevel) {
        this.setOriginalData("txtLevel", txtLevel);
        this.txtLevel = txtLevel;
    }

    public void setTxtSenkyoName(TextBox txtSenkyoName) {
        this.setOriginalData("txtSenkyoName", txtSenkyoName);
        this.txtSenkyoName = txtSenkyoName;
    }

    public void setTxtSenkyoRyakusho(TextBox txtSenkyoRyakusho) {
        this.setOriginalData("txtSenkyoRyakusho", txtSenkyoRyakusho);
        this.txtSenkyoRyakusho = txtSenkyoRyakusho;
    }

    public void setTxtSenkyoMark(TextBox txtSenkyoMark) {
        this.setOriginalData("txtSenkyoMark", txtSenkyoMark);
        this.txtSenkyoMark = txtSenkyoMark;
    }

    public void setChkMutohyoSenkyoFlag(Boolean chkMutohyoSenkyoFlag) {
        this.setOriginalData("chkMutohyoSenkyoFlag", chkMutohyoSenkyoFlag);
        this.chkMutohyoSenkyoFlag = chkMutohyoSenkyoFlag;
    }

    public void setTxtKokujiYMD(TextBoxFlexibleDate txtKokujiYMD) {
        this.setOriginalData("txtKokujiYMD", txtKokujiYMD);
        this.txtKokujiYMD = txtKokujiYMD;
    }

    public void setTxtTohyoUketsukeYMD(TextBoxFlexibleDate txtTohyoUketsukeYMD) {
        this.setOriginalData("txtTohyoUketsukeYMD", txtTohyoUketsukeYMD);
        this.txtTohyoUketsukeYMD = txtTohyoUketsukeYMD;
    }

    public void setTxtKijunYMD(TextBoxFlexibleDate txtKijunYMD) {
        this.setOriginalData("txtKijunYMD", txtKijunYMD);
        this.txtKijunYMD = txtKijunYMD;
    }

    public void setTxtMeiboTorokuYMD(TextBoxFlexibleDate txtMeiboTorokuYMD) {
        this.setOriginalData("txtMeiboTorokuYMD", txtMeiboTorokuYMD);
        this.txtMeiboTorokuYMD = txtMeiboTorokuYMD;
    }

    public void setTxtTenshutsuKigenYMD(TextBoxFlexibleDate txtTenshutsuKigenYMD) {
        this.setOriginalData("txtTenshutsuKigenYMD", txtTenshutsuKigenYMD);
        this.txtTenshutsuKigenYMD = txtTenshutsuKigenYMD;
    }

    public void setTxtTennyuKigenYMD(TextBoxFlexibleDate txtTennyuKigenYMD) {
        this.setOriginalData("txtTennyuKigenYMD", txtTennyuKigenYMD);
        this.txtTennyuKigenYMD = txtTennyuKigenYMD;
    }

    // </editor-fold>
}
