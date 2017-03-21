package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME2040;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Tue Jul 05 20:51:56 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridSetting;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;


/**
 * dgBarCodeJuriTaishosha_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgBarCodeJuriTaishosha_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">

    private Button btnDelete;
    private RString txtUketsukeNo;
    private RString txtShimei;
    private RString txtSenkyoRyakusho;
    private DropDownList ddlTohyoJokyo;
    private ButtonDialog btnDairiNyuryoku;
    private RString txtTohyojokyo;
    private RString txtSeibetsu;
    private RString txtSeinengappiYMD;
    private RString txtShisetsuName;
    private RString txtShikibetsuCode;
    private RString txtSetaiCode;
    private RString txtTohyokuCode;
    private Boolean chkDairiTohyo;
    private RString txtHojoshaShimei1;
    private RString txtHojoshaShimei2;
    private RString txtHojoshaShikibetsuCode1;
    private RString txtHojoshaShikibetsuCode2;
    private TextBoxDate txtTohyoYMD;
    private TextBoxDate txtTohyoUketsukeYMD;
    private TextBoxDate txtKofuYMD;
    private RString txtKofuHoho;
    private RString txtShisetsuCode;
    private RString txtShohonNo;
    private RString txtTohyoJokyoEntity;
    private RString txtSenkyoNo;
    private RString txtBarCode;

    public dgBarCodeJuriTaishosha_Row() {
        super();
        this.btnDelete = new Button();
        this.txtUketsukeNo = RString.EMPTY;
        this.txtShimei = RString.EMPTY;
        this.txtSenkyoRyakusho = RString.EMPTY;
        this.ddlTohyoJokyo = new DropDownList();
        this.btnDairiNyuryoku = new ButtonDialog();
        this.txtTohyojokyo = RString.EMPTY;
        this.txtSeibetsu = RString.EMPTY;
        this.txtSeinengappiYMD = RString.EMPTY;
        this.txtShisetsuName = RString.EMPTY;
        this.txtShikibetsuCode = RString.EMPTY;
        this.txtSetaiCode = RString.EMPTY;
        this.txtTohyokuCode = RString.EMPTY;
        this.chkDairiTohyo = false;
        this.txtHojoshaShimei1 = RString.EMPTY;
        this.txtHojoshaShimei2 = RString.EMPTY;
        this.txtHojoshaShikibetsuCode1 = RString.EMPTY;
        this.txtHojoshaShikibetsuCode2 = RString.EMPTY;
        this.txtTohyoYMD = new TextBoxDate();
        this.txtTohyoUketsukeYMD = new TextBoxDate();
        this.txtKofuYMD = new TextBoxDate();
        this.txtKofuHoho = RString.EMPTY;
        this.txtShisetsuCode = RString.EMPTY;
        this.txtShohonNo = RString.EMPTY;
        this.txtTohyoJokyoEntity = RString.EMPTY;
        this.txtSenkyoNo = RString.EMPTY;
        this.txtBarCode = RString.EMPTY;
        this.setOriginalData("btnDelete", btnDelete);
        this.setOriginalData("txtUketsukeNo", txtUketsukeNo);
        this.setOriginalData("txtShimei", txtShimei);
        this.setOriginalData("txtSenkyoRyakusho", txtSenkyoRyakusho);
        this.setOriginalData("ddlTohyoJokyo", ddlTohyoJokyo);
        this.setOriginalData("btnDairiNyuryoku", btnDairiNyuryoku);
        this.setOriginalData("txtTohyojokyo", txtTohyojokyo);
        this.setOriginalData("txtSeibetsu", txtSeibetsu);
        this.setOriginalData("txtSeinengappiYMD", txtSeinengappiYMD);
        this.setOriginalData("txtShisetsuName", txtShisetsuName);
        this.setOriginalData("txtShikibetsuCode", txtShikibetsuCode);
        this.setOriginalData("txtSetaiCode", txtSetaiCode);
        this.setOriginalData("txtTohyokuCode", txtTohyokuCode);
        this.setOriginalData("chkDairiTohyo", chkDairiTohyo);
        this.setOriginalData("txtHojoshaShimei1", txtHojoshaShimei1);
        this.setOriginalData("txtHojoshaShimei2", txtHojoshaShimei2);
        this.setOriginalData("txtHojoshaShikibetsuCode1", txtHojoshaShikibetsuCode1);
        this.setOriginalData("txtHojoshaShikibetsuCode2", txtHojoshaShikibetsuCode2);
        this.setOriginalData("txtTohyoYMD", txtTohyoYMD);
        this.setOriginalData("txtTohyoUketsukeYMD", txtTohyoUketsukeYMD);
        this.setOriginalData("txtKofuYMD", txtKofuYMD);
        this.setOriginalData("txtKofuHoho", txtKofuHoho);
        this.setOriginalData("txtShisetsuCode", txtShisetsuCode);
        this.setOriginalData("txtShohonNo", txtShohonNo);
        this.setOriginalData("txtTohyoJokyoEntity", txtTohyoJokyoEntity);
        this.setOriginalData("txtSenkyoNo", txtSenkyoNo);
        this.setOriginalData("txtBarCode", txtBarCode);
    }

    public dgBarCodeJuriTaishosha_Row(Button btnDelete, RString txtUketsukeNo, RString txtShimei, RString txtSenkyoRyakusho, DropDownList ddlTohyoJokyo, ButtonDialog btnDairiNyuryoku, RString txtTohyojokyo, RString txtSeibetsu, RString txtSeinengappiYMD, RString txtShisetsuName, RString txtShikibetsuCode, RString txtSetaiCode, RString txtTohyokuCode, Boolean chkDairiTohyo, RString txtHojoshaShimei1, RString txtHojoshaShimei2, RString txtHojoshaShikibetsuCode1, RString txtHojoshaShikibetsuCode2, TextBoxDate txtTohyoYMD, TextBoxDate txtTohyoUketsukeYMD, TextBoxDate txtKofuYMD, RString txtKofuHoho, RString txtShisetsuCode, RString txtShohonNo, RString txtTohyoJokyoEntity, RString txtSenkyoNo, RString txtBarCode) {
        super();
        this.setOriginalData("btnDelete", btnDelete);
        this.setOriginalData("txtUketsukeNo", txtUketsukeNo);
        this.setOriginalData("txtShimei", txtShimei);
        this.setOriginalData("txtSenkyoRyakusho", txtSenkyoRyakusho);
        this.setOriginalData("ddlTohyoJokyo", ddlTohyoJokyo);
        this.setOriginalData("btnDairiNyuryoku", btnDairiNyuryoku);
        this.setOriginalData("txtTohyojokyo", txtTohyojokyo);
        this.setOriginalData("txtSeibetsu", txtSeibetsu);
        this.setOriginalData("txtSeinengappiYMD", txtSeinengappiYMD);
        this.setOriginalData("txtShisetsuName", txtShisetsuName);
        this.setOriginalData("txtShikibetsuCode", txtShikibetsuCode);
        this.setOriginalData("txtSetaiCode", txtSetaiCode);
        this.setOriginalData("txtTohyokuCode", txtTohyokuCode);
        this.setOriginalData("chkDairiTohyo", chkDairiTohyo);
        this.setOriginalData("txtHojoshaShimei1", txtHojoshaShimei1);
        this.setOriginalData("txtHojoshaShimei2", txtHojoshaShimei2);
        this.setOriginalData("txtHojoshaShikibetsuCode1", txtHojoshaShikibetsuCode1);
        this.setOriginalData("txtHojoshaShikibetsuCode2", txtHojoshaShikibetsuCode2);
        this.setOriginalData("txtTohyoYMD", txtTohyoYMD);
        this.setOriginalData("txtTohyoUketsukeYMD", txtTohyoUketsukeYMD);
        this.setOriginalData("txtKofuYMD", txtKofuYMD);
        this.setOriginalData("txtKofuHoho", txtKofuHoho);
        this.setOriginalData("txtShisetsuCode", txtShisetsuCode);
        this.setOriginalData("txtShohonNo", txtShohonNo);
        this.setOriginalData("txtTohyoJokyoEntity", txtTohyoJokyoEntity);
        this.setOriginalData("txtSenkyoNo", txtSenkyoNo);
        this.setOriginalData("txtBarCode", txtBarCode);
        this.btnDelete = btnDelete;
        this.txtUketsukeNo = txtUketsukeNo;
        this.txtShimei = txtShimei;
        this.txtSenkyoRyakusho = txtSenkyoRyakusho;
        this.ddlTohyoJokyo = ddlTohyoJokyo;
        this.btnDairiNyuryoku = btnDairiNyuryoku;
        this.txtTohyojokyo = txtTohyojokyo;
        this.txtSeibetsu = txtSeibetsu;
        this.txtSeinengappiYMD = txtSeinengappiYMD;
        this.txtShisetsuName = txtShisetsuName;
        this.txtShikibetsuCode = txtShikibetsuCode;
        this.txtSetaiCode = txtSetaiCode;
        this.txtTohyokuCode = txtTohyokuCode;
        this.chkDairiTohyo = chkDairiTohyo;
        this.txtHojoshaShimei1 = txtHojoshaShimei1;
        this.txtHojoshaShimei2 = txtHojoshaShimei2;
        this.txtHojoshaShikibetsuCode1 = txtHojoshaShikibetsuCode1;
        this.txtHojoshaShikibetsuCode2 = txtHojoshaShikibetsuCode2;
        this.txtTohyoYMD = txtTohyoYMD;
        this.txtTohyoUketsukeYMD = txtTohyoUketsukeYMD;
        this.txtKofuYMD = txtKofuYMD;
        this.txtKofuHoho = txtKofuHoho;
        this.txtShisetsuCode = txtShisetsuCode;
        this.txtShohonNo = txtShohonNo;
        this.txtTohyoJokyoEntity = txtTohyoJokyoEntity;
        this.txtSenkyoNo = txtSenkyoNo;
        this.txtBarCode = txtBarCode;
    }

    public dgBarCodeJuriTaishosha_Row(DataGridSetting gridSetting) {
        super();
        this.btnDelete = new Button();
        this.txtUketsukeNo = RString.EMPTY;
        this.txtShimei = RString.EMPTY;
        this.txtSenkyoRyakusho = RString.EMPTY;
        this.ddlTohyoJokyo = DropDownList.createInstance(gridSetting.getColumn("ddlTohyoJokyo").getCellDetails());
        this.btnDairiNyuryoku = new ButtonDialog();
        this.txtTohyojokyo = RString.EMPTY;
        this.txtSeibetsu = RString.EMPTY;
        this.txtSeinengappiYMD = RString.EMPTY;
        this.txtShisetsuName = RString.EMPTY;
        this.txtShikibetsuCode = RString.EMPTY;
        this.txtSetaiCode = RString.EMPTY;
        this.txtTohyokuCode = RString.EMPTY;
        this.chkDairiTohyo = false;
        this.txtHojoshaShimei1 = RString.EMPTY;
        this.txtHojoshaShimei2 = RString.EMPTY;
        this.txtHojoshaShikibetsuCode1 = RString.EMPTY;
        this.txtHojoshaShikibetsuCode2 = RString.EMPTY;
        this.txtTohyoYMD = new TextBoxDate();
        this.txtTohyoUketsukeYMD = new TextBoxDate();
        this.txtKofuYMD = new TextBoxDate();
        this.txtKofuHoho = RString.EMPTY;
        this.txtShisetsuCode = RString.EMPTY;
        this.txtShohonNo = RString.EMPTY;
        this.txtTohyoJokyoEntity = RString.EMPTY;
        this.txtSenkyoNo = RString.EMPTY;
        this.txtBarCode = RString.EMPTY;
        this.setOriginalData("btnDelete", btnDelete);
        this.setOriginalData("txtUketsukeNo", txtUketsukeNo);
        this.setOriginalData("txtShimei", txtShimei);
        this.setOriginalData("txtSenkyoRyakusho", txtSenkyoRyakusho);
        this.setOriginalData("ddlTohyoJokyo", ddlTohyoJokyo);
        this.setOriginalData("btnDairiNyuryoku", btnDairiNyuryoku);
        this.setOriginalData("txtTohyojokyo", txtTohyojokyo);
        this.setOriginalData("txtSeibetsu", txtSeibetsu);
        this.setOriginalData("txtSeinengappiYMD", txtSeinengappiYMD);
        this.setOriginalData("txtShisetsuName", txtShisetsuName);
        this.setOriginalData("txtShikibetsuCode", txtShikibetsuCode);
        this.setOriginalData("txtSetaiCode", txtSetaiCode);
        this.setOriginalData("txtTohyokuCode", txtTohyokuCode);
        this.setOriginalData("chkDairiTohyo", chkDairiTohyo);
        this.setOriginalData("txtHojoshaShimei1", txtHojoshaShimei1);
        this.setOriginalData("txtHojoshaShimei2", txtHojoshaShimei2);
        this.setOriginalData("txtHojoshaShikibetsuCode1", txtHojoshaShikibetsuCode1);
        this.setOriginalData("txtHojoshaShikibetsuCode2", txtHojoshaShikibetsuCode2);
        this.setOriginalData("txtTohyoYMD", txtTohyoYMD);
        this.setOriginalData("txtTohyoUketsukeYMD", txtTohyoUketsukeYMD);
        this.setOriginalData("txtKofuYMD", txtKofuYMD);
        this.setOriginalData("txtKofuHoho", txtKofuHoho);
        this.setOriginalData("txtShisetsuCode", txtShisetsuCode);
        this.setOriginalData("txtShohonNo", txtShohonNo);
        this.setOriginalData("txtTohyoJokyoEntity", txtTohyoJokyoEntity);
        this.setOriginalData("txtSenkyoNo", txtSenkyoNo);
        this.setOriginalData("txtBarCode", txtBarCode);
    }

    public Button getBtnDelete() {
        return btnDelete;
    }

    public RString getTxtUketsukeNo() {
        return txtUketsukeNo;
    }

    public RString getTxtShimei() {
        return txtShimei;
    }

    public RString getTxtSenkyoRyakusho() {
        return txtSenkyoRyakusho;
    }

    public DropDownList getDdlTohyoJokyo() {
        return ddlTohyoJokyo;
    }

    public ButtonDialog getBtnDairiNyuryoku() {
        return btnDairiNyuryoku;
    }

    public RString getTxtTohyojokyo() {
        return txtTohyojokyo;
    }

    public RString getTxtSeibetsu() {
        return txtSeibetsu;
    }

    public RString getTxtSeinengappiYMD() {
        return txtSeinengappiYMD;
    }

    public RString getTxtShisetsuName() {
        return txtShisetsuName;
    }

    public RString getTxtShikibetsuCode() {
        return txtShikibetsuCode;
    }

    public RString getTxtSetaiCode() {
        return txtSetaiCode;
    }

    public RString getTxtTohyokuCode() {
        return txtTohyokuCode;
    }

    public Boolean getChkDairiTohyo() {
        return chkDairiTohyo;
    }

    public RString getTxtHojoshaShimei1() {
        return txtHojoshaShimei1;
    }

    public RString getTxtHojoshaShimei2() {
        return txtHojoshaShimei2;
    }

    public RString getTxtHojoshaShikibetsuCode1() {
        return txtHojoshaShikibetsuCode1;
    }

    public RString getTxtHojoshaShikibetsuCode2() {
        return txtHojoshaShikibetsuCode2;
    }

    public TextBoxDate getTxtTohyoYMD() {
        return txtTohyoYMD;
    }

    public TextBoxDate getTxtTohyoUketsukeYMD() {
        return txtTohyoUketsukeYMD;
    }

    public TextBoxDate getTxtKofuYMD() {
        return txtKofuYMD;
    }

    public RString getTxtKofuHoho() {
        return txtKofuHoho;
    }

    public RString getTxtShisetsuCode() {
        return txtShisetsuCode;
    }

    public RString getTxtShohonNo() {
        return txtShohonNo;
    }

    public RString getTxtTohyoJokyoEntity() {
        return txtTohyoJokyoEntity;
    }

    public RString getTxtSenkyoNo() {
        return txtSenkyoNo;
    }

    public RString getTxtBarCode() {
        return txtBarCode;
    }

    public void setBtnDelete(Button btnDelete) {
        this.setOriginalData("btnDelete", btnDelete);
        this.btnDelete = btnDelete;
    }

    public void setTxtUketsukeNo(RString txtUketsukeNo) {
        this.setOriginalData("txtUketsukeNo", txtUketsukeNo);
        this.txtUketsukeNo = txtUketsukeNo;
    }

    public void setTxtShimei(RString txtShimei) {
        this.setOriginalData("txtShimei", txtShimei);
        this.txtShimei = txtShimei;
    }

    public void setTxtSenkyoRyakusho(RString txtSenkyoRyakusho) {
        this.setOriginalData("txtSenkyoRyakusho", txtSenkyoRyakusho);
        this.txtSenkyoRyakusho = txtSenkyoRyakusho;
    }

    public void setDdlTohyoJokyo(DropDownList ddlTohyoJokyo) {
        this.setOriginalData("ddlTohyoJokyo", ddlTohyoJokyo);
        this.ddlTohyoJokyo = ddlTohyoJokyo;
    }

    public void setBtnDairiNyuryoku(ButtonDialog btnDairiNyuryoku) {
        this.setOriginalData("btnDairiNyuryoku", btnDairiNyuryoku);
        this.btnDairiNyuryoku = btnDairiNyuryoku;
    }

    public void setTxtTohyojokyo(RString txtTohyojokyo) {
        this.setOriginalData("txtTohyojokyo", txtTohyojokyo);
        this.txtTohyojokyo = txtTohyojokyo;
    }

    public void setTxtSeibetsu(RString txtSeibetsu) {
        this.setOriginalData("txtSeibetsu", txtSeibetsu);
        this.txtSeibetsu = txtSeibetsu;
    }

    public void setTxtSeinengappiYMD(RString txtSeinengappiYMD) {
        this.setOriginalData("txtSeinengappiYMD", txtSeinengappiYMD);
        this.txtSeinengappiYMD = txtSeinengappiYMD;
    }

    public void setTxtShisetsuName(RString txtShisetsuName) {
        this.setOriginalData("txtShisetsuName", txtShisetsuName);
        this.txtShisetsuName = txtShisetsuName;
    }

    public void setTxtShikibetsuCode(RString txtShikibetsuCode) {
        this.setOriginalData("txtShikibetsuCode", txtShikibetsuCode);
        this.txtShikibetsuCode = txtShikibetsuCode;
    }

    public void setTxtSetaiCode(RString txtSetaiCode) {
        this.setOriginalData("txtSetaiCode", txtSetaiCode);
        this.txtSetaiCode = txtSetaiCode;
    }

    public void setTxtTohyokuCode(RString txtTohyokuCode) {
        this.setOriginalData("txtTohyokuCode", txtTohyokuCode);
        this.txtTohyokuCode = txtTohyokuCode;
    }

    public void setChkDairiTohyo(Boolean chkDairiTohyo) {
        this.setOriginalData("chkDairiTohyo", chkDairiTohyo);
        this.chkDairiTohyo = chkDairiTohyo;
    }

    public void setTxtHojoshaShimei1(RString txtHojoshaShimei1) {
        this.setOriginalData("txtHojoshaShimei1", txtHojoshaShimei1);
        this.txtHojoshaShimei1 = txtHojoshaShimei1;
    }

    public void setTxtHojoshaShimei2(RString txtHojoshaShimei2) {
        this.setOriginalData("txtHojoshaShimei2", txtHojoshaShimei2);
        this.txtHojoshaShimei2 = txtHojoshaShimei2;
    }

    public void setTxtHojoshaShikibetsuCode1(RString txtHojoshaShikibetsuCode1) {
        this.setOriginalData("txtHojoshaShikibetsuCode1", txtHojoshaShikibetsuCode1);
        this.txtHojoshaShikibetsuCode1 = txtHojoshaShikibetsuCode1;
    }

    public void setTxtHojoshaShikibetsuCode2(RString txtHojoshaShikibetsuCode2) {
        this.setOriginalData("txtHojoshaShikibetsuCode2", txtHojoshaShikibetsuCode2);
        this.txtHojoshaShikibetsuCode2 = txtHojoshaShikibetsuCode2;
    }

    public void setTxtTohyoYMD(TextBoxDate txtTohyoYMD) {
        this.setOriginalData("txtTohyoYMD", txtTohyoYMD);
        this.txtTohyoYMD = txtTohyoYMD;
    }

    public void setTxtTohyoUketsukeYMD(TextBoxDate txtTohyoUketsukeYMD) {
        this.setOriginalData("txtTohyoUketsukeYMD", txtTohyoUketsukeYMD);
        this.txtTohyoUketsukeYMD = txtTohyoUketsukeYMD;
    }

    public void setTxtKofuYMD(TextBoxDate txtKofuYMD) {
        this.setOriginalData("txtKofuYMD", txtKofuYMD);
        this.txtKofuYMD = txtKofuYMD;
    }

    public void setTxtKofuHoho(RString txtKofuHoho) {
        this.setOriginalData("txtKofuHoho", txtKofuHoho);
        this.txtKofuHoho = txtKofuHoho;
    }

    public void setTxtShisetsuCode(RString txtShisetsuCode) {
        this.setOriginalData("txtShisetsuCode", txtShisetsuCode);
        this.txtShisetsuCode = txtShisetsuCode;
    }

    public void setTxtShohonNo(RString txtShohonNo) {
        this.setOriginalData("txtShohonNo", txtShohonNo);
        this.txtShohonNo = txtShohonNo;
    }

    public void setTxtTohyoJokyoEntity(RString txtTohyoJokyoEntity) {
        this.setOriginalData("txtTohyoJokyoEntity", txtTohyoJokyoEntity);
        this.txtTohyoJokyoEntity = txtTohyoJokyoEntity;
    }

    public void setTxtSenkyoNo(RString txtSenkyoNo) {
        this.setOriginalData("txtSenkyoNo", txtSenkyoNo);
        this.txtSenkyoNo = txtSenkyoNo;
    }

    public void setTxtBarCode(RString txtBarCode) {
        this.setOriginalData("txtBarCode", txtBarCode);
        this.txtBarCode = txtBarCode;
    }

    // </editor-fold>
}
