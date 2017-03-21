package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.MeiboSakuseiKijun;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Oct 25 19:22:51 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridSetting;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;


/**
 * dgSenkyojiSenkyoNyuryoku_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgSenkyojiSenkyoNyuryoku_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">

    private Button btnDelete;
    private RString txtNo;
    private DropDownList ddlLevel;
    private TextBox txtSenkyoName;
    private TextBox txtSenkyoRyakusho;
    private TextBox txtSenkyoMark;
    private TextBoxDate txtKijunYMD;
    private TextBoxDate txtTohyoUketsukeYMD;
    private TextBoxDate txtKokujiYMD;
    private TextBoxDate txtMeiboTorokuYMD;
    private TextBoxDate txtTenshutsuKigenYMD;
    private TextBoxDate txtTennyuKigenYMD;

    public dgSenkyojiSenkyoNyuryoku_Row() {
        super();
        this.btnDelete = new Button();
        this.txtNo = RString.EMPTY;
        this.ddlLevel = new DropDownList();
        this.txtSenkyoName = new TextBox();
        this.txtSenkyoRyakusho = new TextBox();
        this.txtSenkyoMark = new TextBox();
        this.txtKijunYMD = new TextBoxDate();
        this.txtTohyoUketsukeYMD = new TextBoxDate();
        this.txtKokujiYMD = new TextBoxDate();
        this.txtMeiboTorokuYMD = new TextBoxDate();
        this.txtTenshutsuKigenYMD = new TextBoxDate();
        this.txtTennyuKigenYMD = new TextBoxDate();
        this.setOriginalData("btnDelete", btnDelete);
        this.setOriginalData("txtNo", txtNo);
        this.setOriginalData("ddlLevel", ddlLevel);
        this.setOriginalData("txtSenkyoName", txtSenkyoName);
        this.setOriginalData("txtSenkyoRyakusho", txtSenkyoRyakusho);
        this.setOriginalData("txtSenkyoMark", txtSenkyoMark);
        this.setOriginalData("txtKijunYMD", txtKijunYMD);
        this.setOriginalData("txtTohyoUketsukeYMD", txtTohyoUketsukeYMD);
        this.setOriginalData("txtKokujiYMD", txtKokujiYMD);
        this.setOriginalData("txtMeiboTorokuYMD", txtMeiboTorokuYMD);
        this.setOriginalData("txtTenshutsuKigenYMD", txtTenshutsuKigenYMD);
        this.setOriginalData("txtTennyuKigenYMD", txtTennyuKigenYMD);
    }

    public dgSenkyojiSenkyoNyuryoku_Row(Button btnDelete, RString txtNo, DropDownList ddlLevel, TextBox txtSenkyoName, TextBox txtSenkyoRyakusho, TextBox txtSenkyoMark, TextBoxDate txtKijunYMD, TextBoxDate txtTohyoUketsukeYMD, TextBoxDate txtKokujiYMD, TextBoxDate txtMeiboTorokuYMD, TextBoxDate txtTenshutsuKigenYMD, TextBoxDate txtTennyuKigenYMD) {
        super();
        this.setOriginalData("btnDelete", btnDelete);
        this.setOriginalData("txtNo", txtNo);
        this.setOriginalData("ddlLevel", ddlLevel);
        this.setOriginalData("txtSenkyoName", txtSenkyoName);
        this.setOriginalData("txtSenkyoRyakusho", txtSenkyoRyakusho);
        this.setOriginalData("txtSenkyoMark", txtSenkyoMark);
        this.setOriginalData("txtKijunYMD", txtKijunYMD);
        this.setOriginalData("txtTohyoUketsukeYMD", txtTohyoUketsukeYMD);
        this.setOriginalData("txtKokujiYMD", txtKokujiYMD);
        this.setOriginalData("txtMeiboTorokuYMD", txtMeiboTorokuYMD);
        this.setOriginalData("txtTenshutsuKigenYMD", txtTenshutsuKigenYMD);
        this.setOriginalData("txtTennyuKigenYMD", txtTennyuKigenYMD);
        this.btnDelete = btnDelete;
        this.txtNo = txtNo;
        this.ddlLevel = ddlLevel;
        this.txtSenkyoName = txtSenkyoName;
        this.txtSenkyoRyakusho = txtSenkyoRyakusho;
        this.txtSenkyoMark = txtSenkyoMark;
        this.txtKijunYMD = txtKijunYMD;
        this.txtTohyoUketsukeYMD = txtTohyoUketsukeYMD;
        this.txtKokujiYMD = txtKokujiYMD;
        this.txtMeiboTorokuYMD = txtMeiboTorokuYMD;
        this.txtTenshutsuKigenYMD = txtTenshutsuKigenYMD;
        this.txtTennyuKigenYMD = txtTennyuKigenYMD;
    }

    public dgSenkyojiSenkyoNyuryoku_Row(DataGridSetting gridSetting) {
        super();
        this.btnDelete = new Button();
        this.txtNo = RString.EMPTY;
        this.ddlLevel = DropDownList.createInstance(gridSetting.getColumn("ddlLevel").getCellDetails());
        this.txtSenkyoName = new TextBox();
        this.txtSenkyoRyakusho = new TextBox();
        this.txtSenkyoMark = new TextBox();
        this.txtKijunYMD = new TextBoxDate();
        this.txtTohyoUketsukeYMD = new TextBoxDate();
        this.txtKokujiYMD = new TextBoxDate();
        this.txtMeiboTorokuYMD = new TextBoxDate();
        this.txtTenshutsuKigenYMD = new TextBoxDate();
        this.txtTennyuKigenYMD = new TextBoxDate();
        this.setOriginalData("btnDelete", btnDelete);
        this.setOriginalData("txtNo", txtNo);
        this.setOriginalData("ddlLevel", ddlLevel);
        this.setOriginalData("txtSenkyoName", txtSenkyoName);
        this.setOriginalData("txtSenkyoRyakusho", txtSenkyoRyakusho);
        this.setOriginalData("txtSenkyoMark", txtSenkyoMark);
        this.setOriginalData("txtKijunYMD", txtKijunYMD);
        this.setOriginalData("txtTohyoUketsukeYMD", txtTohyoUketsukeYMD);
        this.setOriginalData("txtKokujiYMD", txtKokujiYMD);
        this.setOriginalData("txtMeiboTorokuYMD", txtMeiboTorokuYMD);
        this.setOriginalData("txtTenshutsuKigenYMD", txtTenshutsuKigenYMD);
        this.setOriginalData("txtTennyuKigenYMD", txtTennyuKigenYMD);
    }

    public Button getBtnDelete() {
        return btnDelete;
    }

    public RString getTxtNo() {
        return txtNo;
    }

    public DropDownList getDdlLevel() {
        return ddlLevel;
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

    public TextBoxDate getTxtKijunYMD() {
        return txtKijunYMD;
    }

    public TextBoxDate getTxtTohyoUketsukeYMD() {
        return txtTohyoUketsukeYMD;
    }

    public TextBoxDate getTxtKokujiYMD() {
        return txtKokujiYMD;
    }

    public TextBoxDate getTxtMeiboTorokuYMD() {
        return txtMeiboTorokuYMD;
    }

    public TextBoxDate getTxtTenshutsuKigenYMD() {
        return txtTenshutsuKigenYMD;
    }

    public TextBoxDate getTxtTennyuKigenYMD() {
        return txtTennyuKigenYMD;
    }

    public void setBtnDelete(Button btnDelete) {
        this.setOriginalData("btnDelete", btnDelete);
        this.btnDelete = btnDelete;
    }

    public void setTxtNo(RString txtNo) {
        this.setOriginalData("txtNo", txtNo);
        this.txtNo = txtNo;
    }

    public void setDdlLevel(DropDownList ddlLevel) {
        this.setOriginalData("ddlLevel", ddlLevel);
        this.ddlLevel = ddlLevel;
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

    public void setTxtKijunYMD(TextBoxDate txtKijunYMD) {
        this.setOriginalData("txtKijunYMD", txtKijunYMD);
        this.txtKijunYMD = txtKijunYMD;
    }

    public void setTxtTohyoUketsukeYMD(TextBoxDate txtTohyoUketsukeYMD) {
        this.setOriginalData("txtTohyoUketsukeYMD", txtTohyoUketsukeYMD);
        this.txtTohyoUketsukeYMD = txtTohyoUketsukeYMD;
    }

    public void setTxtKokujiYMD(TextBoxDate txtKokujiYMD) {
        this.setOriginalData("txtKokujiYMD", txtKokujiYMD);
        this.txtKokujiYMD = txtKokujiYMD;
    }

    public void setTxtMeiboTorokuYMD(TextBoxDate txtMeiboTorokuYMD) {
        this.setOriginalData("txtMeiboTorokuYMD", txtMeiboTorokuYMD);
        this.txtMeiboTorokuYMD = txtMeiboTorokuYMD;
    }

    public void setTxtTenshutsuKigenYMD(TextBoxDate txtTenshutsuKigenYMD) {
        this.setOriginalData("txtTenshutsuKigenYMD", txtTenshutsuKigenYMD);
        this.txtTenshutsuKigenYMD = txtTenshutsuKigenYMD;
    }

    public void setTxtTennyuKigenYMD(TextBoxDate txtTennyuKigenYMD) {
        this.setOriginalData("txtTennyuKigenYMD", txtTennyuKigenYMD);
        this.txtTennyuKigenYMD = txtTennyuKigenYMD;
    }

    // </editor-fold>
}
