package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMH1030;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Sep 20 16:07:10 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridSetting;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;


/**
 * dgSeikyuShomeiboShomeishaIchiran_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgSeikyuShomeiboShomeishaIchiran_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

    private TextBox txtShimei;
    private TextBox txtKanaShimei;
    private TextBoxFlexibleDate txtSeinengappiYMD;
    private DropDownList txtSeibetsu;
    private RString txtShikibetsuCode;
    private TextBox txtJusho;
    private RString txtSenkyoShikaku;
    private DropDownList ddlShomeiJokyo;
    private DropDownList txtMukoJiyu;
    private TextBoxFlexibleDate txtShomeiYMD;
    private ButtonDialog btnDaihitsusha;
    private TextBox txtDaihitsushaShimei;
    private TextBoxFlexibleDate txtDaihitsushaSeinengappiYMD;
    private DropDownList ddlDaihitsushaSeibetsu;
    private TextBox txtDaihitsushaJusho;
    private RString txtDaihitsushaShikibetsuCode;
    private RString mukoJiyuselectedkey;

    public dgSeikyuShomeiboShomeishaIchiran_Row() {
        super();
        this.txtShimei = new TextBox();
        this.txtKanaShimei = new TextBox();
        this.txtSeinengappiYMD = new TextBoxFlexibleDate();
        this.txtSeibetsu = new DropDownList();
        this.txtShikibetsuCode = RString.EMPTY;
        this.txtJusho = new TextBox();
        this.txtSenkyoShikaku = RString.EMPTY;
        this.ddlShomeiJokyo = new DropDownList();
        this.txtMukoJiyu = new DropDownList();
        this.txtShomeiYMD = new TextBoxFlexibleDate();
        this.btnDaihitsusha = new ButtonDialog();
        this.txtDaihitsushaShimei = new TextBox();
        this.txtDaihitsushaSeinengappiYMD = new TextBoxFlexibleDate();
        this.ddlDaihitsushaSeibetsu = new DropDownList();
        this.txtDaihitsushaJusho = new TextBox();
        this.txtDaihitsushaShikibetsuCode = RString.EMPTY;
        this.mukoJiyuselectedkey = RString.EMPTY;
        this.setOriginalData("txtShimei", txtShimei);
        this.setOriginalData("txtKanaShimei", txtKanaShimei);
        this.setOriginalData("txtSeinengappiYMD", txtSeinengappiYMD);
        this.setOriginalData("txtSeibetsu", txtSeibetsu);
        this.setOriginalData("txtShikibetsuCode", txtShikibetsuCode);
        this.setOriginalData("txtJusho", txtJusho);
        this.setOriginalData("txtSenkyoShikaku", txtSenkyoShikaku);
        this.setOriginalData("ddlShomeiJokyo", ddlShomeiJokyo);
        this.setOriginalData("txtMukoJiyu", txtMukoJiyu);
        this.setOriginalData("txtShomeiYMD", txtShomeiYMD);
        this.setOriginalData("btnDaihitsusha", btnDaihitsusha);
        this.setOriginalData("txtDaihitsushaShimei", txtDaihitsushaShimei);
        this.setOriginalData("txtDaihitsushaSeinengappiYMD", txtDaihitsushaSeinengappiYMD);
        this.setOriginalData("ddlDaihitsushaSeibetsu", ddlDaihitsushaSeibetsu);
        this.setOriginalData("txtDaihitsushaJusho", txtDaihitsushaJusho);
        this.setOriginalData("txtDaihitsushaShikibetsuCode", txtDaihitsushaShikibetsuCode);
        this.setOriginalData("mukoJiyuselectedkey", mukoJiyuselectedkey);
    }

    public dgSeikyuShomeiboShomeishaIchiran_Row(TextBox txtShimei, TextBox txtKanaShimei, TextBoxFlexibleDate txtSeinengappiYMD, DropDownList txtSeibetsu, RString txtShikibetsuCode, TextBox txtJusho, RString txtSenkyoShikaku, DropDownList ddlShomeiJokyo, DropDownList txtMukoJiyu, TextBoxFlexibleDate txtShomeiYMD, ButtonDialog btnDaihitsusha, TextBox txtDaihitsushaShimei, TextBoxFlexibleDate txtDaihitsushaSeinengappiYMD, DropDownList ddlDaihitsushaSeibetsu, TextBox txtDaihitsushaJusho, RString txtDaihitsushaShikibetsuCode, RString mukoJiyuselectedkey) {
        super();
        this.setOriginalData("txtShimei", txtShimei);
        this.setOriginalData("txtKanaShimei", txtKanaShimei);
        this.setOriginalData("txtSeinengappiYMD", txtSeinengappiYMD);
        this.setOriginalData("txtSeibetsu", txtSeibetsu);
        this.setOriginalData("txtShikibetsuCode", txtShikibetsuCode);
        this.setOriginalData("txtJusho", txtJusho);
        this.setOriginalData("txtSenkyoShikaku", txtSenkyoShikaku);
        this.setOriginalData("ddlShomeiJokyo", ddlShomeiJokyo);
        this.setOriginalData("txtMukoJiyu", txtMukoJiyu);
        this.setOriginalData("txtShomeiYMD", txtShomeiYMD);
        this.setOriginalData("btnDaihitsusha", btnDaihitsusha);
        this.setOriginalData("txtDaihitsushaShimei", txtDaihitsushaShimei);
        this.setOriginalData("txtDaihitsushaSeinengappiYMD", txtDaihitsushaSeinengappiYMD);
        this.setOriginalData("ddlDaihitsushaSeibetsu", ddlDaihitsushaSeibetsu);
        this.setOriginalData("txtDaihitsushaJusho", txtDaihitsushaJusho);
        this.setOriginalData("txtDaihitsushaShikibetsuCode", txtDaihitsushaShikibetsuCode);
        this.setOriginalData("mukoJiyuselectedkey", mukoJiyuselectedkey);
        this.txtShimei = txtShimei;
        this.txtKanaShimei = txtKanaShimei;
        this.txtSeinengappiYMD = txtSeinengappiYMD;
        this.txtSeibetsu = txtSeibetsu;
        this.txtShikibetsuCode = txtShikibetsuCode;
        this.txtJusho = txtJusho;
        this.txtSenkyoShikaku = txtSenkyoShikaku;
        this.ddlShomeiJokyo = ddlShomeiJokyo;
        this.txtMukoJiyu = txtMukoJiyu;
        this.txtShomeiYMD = txtShomeiYMD;
        this.btnDaihitsusha = btnDaihitsusha;
        this.txtDaihitsushaShimei = txtDaihitsushaShimei;
        this.txtDaihitsushaSeinengappiYMD = txtDaihitsushaSeinengappiYMD;
        this.ddlDaihitsushaSeibetsu = ddlDaihitsushaSeibetsu;
        this.txtDaihitsushaJusho = txtDaihitsushaJusho;
        this.txtDaihitsushaShikibetsuCode = txtDaihitsushaShikibetsuCode;
        this.mukoJiyuselectedkey = mukoJiyuselectedkey;
    }

    public dgSeikyuShomeiboShomeishaIchiran_Row(DataGridSetting gridSetting) {
        super();
        this.txtShimei = new TextBox();
        this.txtKanaShimei = new TextBox();
        this.txtSeinengappiYMD = new TextBoxFlexibleDate();
        this.txtSeibetsu = DropDownList.createInstance(gridSetting.getColumn("txtSeibetsu").getCellDetails());
        this.txtShikibetsuCode = RString.EMPTY;
        this.txtJusho = new TextBox();
        this.txtSenkyoShikaku = RString.EMPTY;
        this.ddlShomeiJokyo = DropDownList.createInstance(gridSetting.getColumn("ddlShomeiJokyo").getCellDetails());
        this.txtMukoJiyu = DropDownList.createInstance(gridSetting.getColumn("txtMukoJiyu").getCellDetails());
        this.txtShomeiYMD = new TextBoxFlexibleDate();
        this.btnDaihitsusha = new ButtonDialog();
        this.txtDaihitsushaShimei = new TextBox();
        this.txtDaihitsushaSeinengappiYMD = new TextBoxFlexibleDate();
        this.ddlDaihitsushaSeibetsu = DropDownList.createInstance(gridSetting.getColumn("ddlDaihitsushaSeibetsu").getCellDetails());
        this.txtDaihitsushaJusho = new TextBox();
        this.txtDaihitsushaShikibetsuCode = RString.EMPTY;
        this.mukoJiyuselectedkey = RString.EMPTY;
        this.setOriginalData("txtShimei", txtShimei);
        this.setOriginalData("txtKanaShimei", txtKanaShimei);
        this.setOriginalData("txtSeinengappiYMD", txtSeinengappiYMD);
        this.setOriginalData("txtSeibetsu", txtSeibetsu);
        this.setOriginalData("txtShikibetsuCode", txtShikibetsuCode);
        this.setOriginalData("txtJusho", txtJusho);
        this.setOriginalData("txtSenkyoShikaku", txtSenkyoShikaku);
        this.setOriginalData("ddlShomeiJokyo", ddlShomeiJokyo);
        this.setOriginalData("txtMukoJiyu", txtMukoJiyu);
        this.setOriginalData("txtShomeiYMD", txtShomeiYMD);
        this.setOriginalData("btnDaihitsusha", btnDaihitsusha);
        this.setOriginalData("txtDaihitsushaShimei", txtDaihitsushaShimei);
        this.setOriginalData("txtDaihitsushaSeinengappiYMD", txtDaihitsushaSeinengappiYMD);
        this.setOriginalData("ddlDaihitsushaSeibetsu", ddlDaihitsushaSeibetsu);
        this.setOriginalData("txtDaihitsushaJusho", txtDaihitsushaJusho);
        this.setOriginalData("txtDaihitsushaShikibetsuCode", txtDaihitsushaShikibetsuCode);
        this.setOriginalData("mukoJiyuselectedkey", mukoJiyuselectedkey);
    }

    public TextBox getTxtShimei() {
        return txtShimei;
    }

    public TextBox getTxtKanaShimei() {
        return txtKanaShimei;
    }

    public TextBoxFlexibleDate getTxtSeinengappiYMD() {
        return txtSeinengappiYMD;
    }

    public DropDownList getTxtSeibetsu() {
        return txtSeibetsu;
    }

    public RString getTxtShikibetsuCode() {
        return txtShikibetsuCode;
    }

    public TextBox getTxtJusho() {
        return txtJusho;
    }

    public RString getTxtSenkyoShikaku() {
        return txtSenkyoShikaku;
    }

    public DropDownList getDdlShomeiJokyo() {
        return ddlShomeiJokyo;
    }

    public DropDownList getTxtMukoJiyu() {
        return txtMukoJiyu;
    }

    public TextBoxFlexibleDate getTxtShomeiYMD() {
        return txtShomeiYMD;
    }

    public ButtonDialog getBtnDaihitsusha() {
        return btnDaihitsusha;
    }

    public TextBox getTxtDaihitsushaShimei() {
        return txtDaihitsushaShimei;
    }

    public TextBoxFlexibleDate getTxtDaihitsushaSeinengappiYMD() {
        return txtDaihitsushaSeinengappiYMD;
    }

    public DropDownList getDdlDaihitsushaSeibetsu() {
        return ddlDaihitsushaSeibetsu;
    }

    public TextBox getTxtDaihitsushaJusho() {
        return txtDaihitsushaJusho;
    }

    public RString getTxtDaihitsushaShikibetsuCode() {
        return txtDaihitsushaShikibetsuCode;
    }

    public RString getMukoJiyuselectedkey() {
        return mukoJiyuselectedkey;
    }

    public void setTxtShimei(TextBox txtShimei) {
        this.setOriginalData("txtShimei", txtShimei);
        this.txtShimei = txtShimei;
    }

    public void setTxtKanaShimei(TextBox txtKanaShimei) {
        this.setOriginalData("txtKanaShimei", txtKanaShimei);
        this.txtKanaShimei = txtKanaShimei;
    }

    public void setTxtSeinengappiYMD(TextBoxFlexibleDate txtSeinengappiYMD) {
        this.setOriginalData("txtSeinengappiYMD", txtSeinengappiYMD);
        this.txtSeinengappiYMD = txtSeinengappiYMD;
    }

    public void setTxtSeibetsu(DropDownList txtSeibetsu) {
        this.setOriginalData("txtSeibetsu", txtSeibetsu);
        this.txtSeibetsu = txtSeibetsu;
    }

    public void setTxtShikibetsuCode(RString txtShikibetsuCode) {
        this.setOriginalData("txtShikibetsuCode", txtShikibetsuCode);
        this.txtShikibetsuCode = txtShikibetsuCode;
    }

    public void setTxtJusho(TextBox txtJusho) {
        this.setOriginalData("txtJusho", txtJusho);
        this.txtJusho = txtJusho;
    }

    public void setTxtSenkyoShikaku(RString txtSenkyoShikaku) {
        this.setOriginalData("txtSenkyoShikaku", txtSenkyoShikaku);
        this.txtSenkyoShikaku = txtSenkyoShikaku;
    }

    public void setDdlShomeiJokyo(DropDownList ddlShomeiJokyo) {
        this.setOriginalData("ddlShomeiJokyo", ddlShomeiJokyo);
        this.ddlShomeiJokyo = ddlShomeiJokyo;
    }

    public void setTxtMukoJiyu(DropDownList txtMukoJiyu) {
        this.setOriginalData("txtMukoJiyu", txtMukoJiyu);
        this.txtMukoJiyu = txtMukoJiyu;
    }

    public void setTxtShomeiYMD(TextBoxFlexibleDate txtShomeiYMD) {
        this.setOriginalData("txtShomeiYMD", txtShomeiYMD);
        this.txtShomeiYMD = txtShomeiYMD;
    }

    public void setBtnDaihitsusha(ButtonDialog btnDaihitsusha) {
        this.setOriginalData("btnDaihitsusha", btnDaihitsusha);
        this.btnDaihitsusha = btnDaihitsusha;
    }

    public void setTxtDaihitsushaShimei(TextBox txtDaihitsushaShimei) {
        this.setOriginalData("txtDaihitsushaShimei", txtDaihitsushaShimei);
        this.txtDaihitsushaShimei = txtDaihitsushaShimei;
    }

    public void setTxtDaihitsushaSeinengappiYMD(TextBoxFlexibleDate txtDaihitsushaSeinengappiYMD) {
        this.setOriginalData("txtDaihitsushaSeinengappiYMD", txtDaihitsushaSeinengappiYMD);
        this.txtDaihitsushaSeinengappiYMD = txtDaihitsushaSeinengappiYMD;
    }

    public void setDdlDaihitsushaSeibetsu(DropDownList ddlDaihitsushaSeibetsu) {
        this.setOriginalData("ddlDaihitsushaSeibetsu", ddlDaihitsushaSeibetsu);
        this.ddlDaihitsushaSeibetsu = ddlDaihitsushaSeibetsu;
    }

    public void setTxtDaihitsushaJusho(TextBox txtDaihitsushaJusho) {
        this.setOriginalData("txtDaihitsushaJusho", txtDaihitsushaJusho);
        this.txtDaihitsushaJusho = txtDaihitsushaJusho;
    }

    public void setTxtDaihitsushaShikibetsuCode(RString txtDaihitsushaShikibetsuCode) {
        this.setOriginalData("txtDaihitsushaShikibetsuCode", txtDaihitsushaShikibetsuCode);
        this.txtDaihitsushaShikibetsuCode = txtDaihitsushaShikibetsuCode;
    }

    public void setMukoJiyuselectedkey(RString mukoJiyuselectedkey) {
        this.setOriginalData("mukoJiyuselectedkey", mukoJiyuselectedkey);
        this.mukoJiyuselectedkey = mukoJiyuselectedkey;
    }

    // </editor-fold>
}
