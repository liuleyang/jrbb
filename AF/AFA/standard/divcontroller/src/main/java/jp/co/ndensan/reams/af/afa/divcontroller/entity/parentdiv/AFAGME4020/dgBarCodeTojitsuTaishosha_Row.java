package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME4020;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Sep 28 17:42:34 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridSetting;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgBarCodeTojitsuTaishosha_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgBarCodeTojitsuTaishosha_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

    private Button btnDelete;
    private RString txtShimei;
    private RString txtSeibetsu;
    private RString txtJusho;
    private RString txtTohyokuCode;
    private RString txtPage;
    private RString txtGyo;
    private CheckBoxList chkAll;
    private CheckBoxList chkSenkyo1;
    private CheckBoxList chkSenkyo2;
    private CheckBoxList chkSenkyo3;
    private CheckBoxList chkSenkyo4;
    private CheckBoxList chkSenkyo5;
    private CheckBoxList chkSenkyo6;
    private CheckBoxList chkSenkyo7;
    private CheckBoxList chkSenkyo8;
    private CheckBoxList chkSenkyo9;
    private TextBoxDate txtSeinengappi;
    private RString txtJuminShubetsu;
    private RString txtShikibetsuCode;
    private RString txtSeitaiCode;
    private RString txtGyoseikuCode;
    private RString txtSenkyoShikaku;
    private TextBoxFlexibleDate txtHyojiYmd;
    private TextBoxFlexibleDate txtMassyoYmd;
    private RString hdnShohonNo;
    private RString hdnShikibetsuCode;
    private RString hdnSenkyoNo;
    private RString hdnBarCode;

    public dgBarCodeTojitsuTaishosha_Row() {
        super();
        this.btnDelete = new Button();
        this.txtShimei = RString.EMPTY;
        this.txtSeibetsu = RString.EMPTY;
        this.txtJusho = RString.EMPTY;
        this.txtTohyokuCode = RString.EMPTY;
        this.txtPage = RString.EMPTY;
        this.txtGyo = RString.EMPTY;
        this.chkAll = new CheckBoxList();
        this.chkSenkyo1 = new CheckBoxList();
        this.chkSenkyo2 = new CheckBoxList();
        this.chkSenkyo3 = new CheckBoxList();
        this.chkSenkyo4 = new CheckBoxList();
        this.chkSenkyo5 = new CheckBoxList();
        this.chkSenkyo6 = new CheckBoxList();
        this.chkSenkyo7 = new CheckBoxList();
        this.chkSenkyo8 = new CheckBoxList();
        this.chkSenkyo9 = new CheckBoxList();
        this.txtSeinengappi = new TextBoxDate();
        this.txtJuminShubetsu = RString.EMPTY;
        this.txtShikibetsuCode = RString.EMPTY;
        this.txtSeitaiCode = RString.EMPTY;
        this.txtGyoseikuCode = RString.EMPTY;
        this.txtSenkyoShikaku = RString.EMPTY;
        this.txtHyojiYmd = new TextBoxFlexibleDate();
        this.txtMassyoYmd = new TextBoxFlexibleDate();
        this.hdnShohonNo = RString.EMPTY;
        this.hdnShikibetsuCode = RString.EMPTY;
        this.hdnSenkyoNo = RString.EMPTY;
        this.hdnBarCode = RString.EMPTY;
        this.setOriginalData("btnDelete", btnDelete);
        this.setOriginalData("txtShimei", txtShimei);
        this.setOriginalData("txtSeibetsu", txtSeibetsu);
        this.setOriginalData("txtJusho", txtJusho);
        this.setOriginalData("txtTohyokuCode", txtTohyokuCode);
        this.setOriginalData("txtPage", txtPage);
        this.setOriginalData("txtGyo", txtGyo);
        this.setOriginalData("chkAll", chkAll);
        this.setOriginalData("chkSenkyo1", chkSenkyo1);
        this.setOriginalData("chkSenkyo2", chkSenkyo2);
        this.setOriginalData("chkSenkyo3", chkSenkyo3);
        this.setOriginalData("chkSenkyo4", chkSenkyo4);
        this.setOriginalData("chkSenkyo5", chkSenkyo5);
        this.setOriginalData("chkSenkyo6", chkSenkyo6);
        this.setOriginalData("chkSenkyo7", chkSenkyo7);
        this.setOriginalData("chkSenkyo8", chkSenkyo8);
        this.setOriginalData("chkSenkyo9", chkSenkyo9);
        this.setOriginalData("txtSeinengappi", txtSeinengappi);
        this.setOriginalData("txtJuminShubetsu", txtJuminShubetsu);
        this.setOriginalData("txtShikibetsuCode", txtShikibetsuCode);
        this.setOriginalData("txtSeitaiCode", txtSeitaiCode);
        this.setOriginalData("txtGyoseikuCode", txtGyoseikuCode);
        this.setOriginalData("txtSenkyoShikaku", txtSenkyoShikaku);
        this.setOriginalData("txtHyojiYmd", txtHyojiYmd);
        this.setOriginalData("txtMassyoYmd", txtMassyoYmd);
        this.setOriginalData("hdnShohonNo", hdnShohonNo);
        this.setOriginalData("hdnShikibetsuCode", hdnShikibetsuCode);
        this.setOriginalData("hdnSenkyoNo", hdnSenkyoNo);
        this.setOriginalData("hdnBarCode", hdnBarCode);
    }

    public dgBarCodeTojitsuTaishosha_Row(Button btnDelete, RString txtShimei, RString txtSeibetsu, RString txtJusho, RString txtTohyokuCode, RString txtPage, RString txtGyo, CheckBoxList chkAll, CheckBoxList chkSenkyo1, CheckBoxList chkSenkyo2, CheckBoxList chkSenkyo3, CheckBoxList chkSenkyo4, CheckBoxList chkSenkyo5, CheckBoxList chkSenkyo6, CheckBoxList chkSenkyo7, CheckBoxList chkSenkyo8, CheckBoxList chkSenkyo9, TextBoxDate txtSeinengappi, RString txtJuminShubetsu, RString txtShikibetsuCode, RString txtSeitaiCode, RString txtGyoseikuCode, RString txtSenkyoShikaku, TextBoxFlexibleDate txtHyojiYmd, TextBoxFlexibleDate txtMassyoYmd, RString hdnShohonNo, RString hdnShikibetsuCode, RString hdnSenkyoNo, RString hdnBarCode) {
        super();
        this.setOriginalData("btnDelete", btnDelete);
        this.setOriginalData("txtShimei", txtShimei);
        this.setOriginalData("txtSeibetsu", txtSeibetsu);
        this.setOriginalData("txtJusho", txtJusho);
        this.setOriginalData("txtTohyokuCode", txtTohyokuCode);
        this.setOriginalData("txtPage", txtPage);
        this.setOriginalData("txtGyo", txtGyo);
        this.setOriginalData("chkAll", chkAll);
        this.setOriginalData("chkSenkyo1", chkSenkyo1);
        this.setOriginalData("chkSenkyo2", chkSenkyo2);
        this.setOriginalData("chkSenkyo3", chkSenkyo3);
        this.setOriginalData("chkSenkyo4", chkSenkyo4);
        this.setOriginalData("chkSenkyo5", chkSenkyo5);
        this.setOriginalData("chkSenkyo6", chkSenkyo6);
        this.setOriginalData("chkSenkyo7", chkSenkyo7);
        this.setOriginalData("chkSenkyo8", chkSenkyo8);
        this.setOriginalData("chkSenkyo9", chkSenkyo9);
        this.setOriginalData("txtSeinengappi", txtSeinengappi);
        this.setOriginalData("txtJuminShubetsu", txtJuminShubetsu);
        this.setOriginalData("txtShikibetsuCode", txtShikibetsuCode);
        this.setOriginalData("txtSeitaiCode", txtSeitaiCode);
        this.setOriginalData("txtGyoseikuCode", txtGyoseikuCode);
        this.setOriginalData("txtSenkyoShikaku", txtSenkyoShikaku);
        this.setOriginalData("txtHyojiYmd", txtHyojiYmd);
        this.setOriginalData("txtMassyoYmd", txtMassyoYmd);
        this.setOriginalData("hdnShohonNo", hdnShohonNo);
        this.setOriginalData("hdnShikibetsuCode", hdnShikibetsuCode);
        this.setOriginalData("hdnSenkyoNo", hdnSenkyoNo);
        this.setOriginalData("hdnBarCode", hdnBarCode);
        this.btnDelete = btnDelete;
        this.txtShimei = txtShimei;
        this.txtSeibetsu = txtSeibetsu;
        this.txtJusho = txtJusho;
        this.txtTohyokuCode = txtTohyokuCode;
        this.txtPage = txtPage;
        this.txtGyo = txtGyo;
        this.chkAll = chkAll;
        this.chkSenkyo1 = chkSenkyo1;
        this.chkSenkyo2 = chkSenkyo2;
        this.chkSenkyo3 = chkSenkyo3;
        this.chkSenkyo4 = chkSenkyo4;
        this.chkSenkyo5 = chkSenkyo5;
        this.chkSenkyo6 = chkSenkyo6;
        this.chkSenkyo7 = chkSenkyo7;
        this.chkSenkyo8 = chkSenkyo8;
        this.chkSenkyo9 = chkSenkyo9;
        this.txtSeinengappi = txtSeinengappi;
        this.txtJuminShubetsu = txtJuminShubetsu;
        this.txtShikibetsuCode = txtShikibetsuCode;
        this.txtSeitaiCode = txtSeitaiCode;
        this.txtGyoseikuCode = txtGyoseikuCode;
        this.txtSenkyoShikaku = txtSenkyoShikaku;
        this.txtHyojiYmd = txtHyojiYmd;
        this.txtMassyoYmd = txtMassyoYmd;
        this.hdnShohonNo = hdnShohonNo;
        this.hdnShikibetsuCode = hdnShikibetsuCode;
        this.hdnSenkyoNo = hdnSenkyoNo;
        this.hdnBarCode = hdnBarCode;
    }

    public dgBarCodeTojitsuTaishosha_Row(DataGridSetting gridSetting) {
        super();
        this.btnDelete = new Button();
        this.txtShimei = RString.EMPTY;
        this.txtSeibetsu = RString.EMPTY;
        this.txtJusho = RString.EMPTY;
        this.txtTohyokuCode = RString.EMPTY;
        this.txtPage = RString.EMPTY;
        this.txtGyo = RString.EMPTY;
        this.chkAll = CheckBoxList.createInstance(gridSetting.getColumn("chkAll").getCellDetails());
        this.chkSenkyo1 = CheckBoxList.createInstance(gridSetting.getColumn("chkSenkyo1").getCellDetails());
        this.chkSenkyo2 = CheckBoxList.createInstance(gridSetting.getColumn("chkSenkyo2").getCellDetails());
        this.chkSenkyo3 = CheckBoxList.createInstance(gridSetting.getColumn("chkSenkyo3").getCellDetails());
        this.chkSenkyo4 = CheckBoxList.createInstance(gridSetting.getColumn("chkSenkyo4").getCellDetails());
        this.chkSenkyo5 = CheckBoxList.createInstance(gridSetting.getColumn("chkSenkyo5").getCellDetails());
        this.chkSenkyo6 = CheckBoxList.createInstance(gridSetting.getColumn("chkSenkyo6").getCellDetails());
        this.chkSenkyo7 = CheckBoxList.createInstance(gridSetting.getColumn("chkSenkyo7").getCellDetails());
        this.chkSenkyo8 = CheckBoxList.createInstance(gridSetting.getColumn("chkSenkyo8").getCellDetails());
        this.chkSenkyo9 = CheckBoxList.createInstance(gridSetting.getColumn("chkSenkyo9").getCellDetails());
        this.txtSeinengappi = new TextBoxDate();
        this.txtJuminShubetsu = RString.EMPTY;
        this.txtShikibetsuCode = RString.EMPTY;
        this.txtSeitaiCode = RString.EMPTY;
        this.txtGyoseikuCode = RString.EMPTY;
        this.txtSenkyoShikaku = RString.EMPTY;
        this.txtHyojiYmd = new TextBoxFlexibleDate();
        this.txtMassyoYmd = new TextBoxFlexibleDate();
        this.hdnShohonNo = RString.EMPTY;
        this.hdnShikibetsuCode = RString.EMPTY;
        this.hdnSenkyoNo = RString.EMPTY;
        this.hdnBarCode = RString.EMPTY;
        this.setOriginalData("btnDelete", btnDelete);
        this.setOriginalData("txtShimei", txtShimei);
        this.setOriginalData("txtSeibetsu", txtSeibetsu);
        this.setOriginalData("txtJusho", txtJusho);
        this.setOriginalData("txtTohyokuCode", txtTohyokuCode);
        this.setOriginalData("txtPage", txtPage);
        this.setOriginalData("txtGyo", txtGyo);
        this.setOriginalData("chkAll", chkAll);
        this.setOriginalData("chkSenkyo1", chkSenkyo1);
        this.setOriginalData("chkSenkyo2", chkSenkyo2);
        this.setOriginalData("chkSenkyo3", chkSenkyo3);
        this.setOriginalData("chkSenkyo4", chkSenkyo4);
        this.setOriginalData("chkSenkyo5", chkSenkyo5);
        this.setOriginalData("chkSenkyo6", chkSenkyo6);
        this.setOriginalData("chkSenkyo7", chkSenkyo7);
        this.setOriginalData("chkSenkyo8", chkSenkyo8);
        this.setOriginalData("chkSenkyo9", chkSenkyo9);
        this.setOriginalData("txtSeinengappi", txtSeinengappi);
        this.setOriginalData("txtJuminShubetsu", txtJuminShubetsu);
        this.setOriginalData("txtShikibetsuCode", txtShikibetsuCode);
        this.setOriginalData("txtSeitaiCode", txtSeitaiCode);
        this.setOriginalData("txtGyoseikuCode", txtGyoseikuCode);
        this.setOriginalData("txtSenkyoShikaku", txtSenkyoShikaku);
        this.setOriginalData("txtHyojiYmd", txtHyojiYmd);
        this.setOriginalData("txtMassyoYmd", txtMassyoYmd);
        this.setOriginalData("hdnShohonNo", hdnShohonNo);
        this.setOriginalData("hdnShikibetsuCode", hdnShikibetsuCode);
        this.setOriginalData("hdnSenkyoNo", hdnSenkyoNo);
        this.setOriginalData("hdnBarCode", hdnBarCode);
    }

    public Button getBtnDelete() {
        return btnDelete;
    }

    public RString getTxtShimei() {
        return txtShimei;
    }

    public RString getTxtSeibetsu() {
        return txtSeibetsu;
    }

    public RString getTxtJusho() {
        return txtJusho;
    }

    public RString getTxtTohyokuCode() {
        return txtTohyokuCode;
    }

    public RString getTxtPage() {
        return txtPage;
    }

    public RString getTxtGyo() {
        return txtGyo;
    }

    public CheckBoxList getChkAll() {
        return chkAll;
    }

    public CheckBoxList getChkSenkyo1() {
        return chkSenkyo1;
    }

    public CheckBoxList getChkSenkyo2() {
        return chkSenkyo2;
    }

    public CheckBoxList getChkSenkyo3() {
        return chkSenkyo3;
    }

    public CheckBoxList getChkSenkyo4() {
        return chkSenkyo4;
    }

    public CheckBoxList getChkSenkyo5() {
        return chkSenkyo5;
    }

    public CheckBoxList getChkSenkyo6() {
        return chkSenkyo6;
    }

    public CheckBoxList getChkSenkyo7() {
        return chkSenkyo7;
    }

    public CheckBoxList getChkSenkyo8() {
        return chkSenkyo8;
    }

    public CheckBoxList getChkSenkyo9() {
        return chkSenkyo9;
    }

    public TextBoxDate getTxtSeinengappi() {
        return txtSeinengappi;
    }

    public RString getTxtJuminShubetsu() {
        return txtJuminShubetsu;
    }

    public RString getTxtShikibetsuCode() {
        return txtShikibetsuCode;
    }

    public RString getTxtSeitaiCode() {
        return txtSeitaiCode;
    }

    public RString getTxtGyoseikuCode() {
        return txtGyoseikuCode;
    }

    public RString getTxtSenkyoShikaku() {
        return txtSenkyoShikaku;
    }

    public TextBoxFlexibleDate getTxtHyojiYmd() {
        return txtHyojiYmd;
    }

    public TextBoxFlexibleDate getTxtMassyoYmd() {
        return txtMassyoYmd;
    }

    public RString getHdnShohonNo() {
        return hdnShohonNo;
    }

    public RString getHdnShikibetsuCode() {
        return hdnShikibetsuCode;
    }

    public RString getHdnSenkyoNo() {
        return hdnSenkyoNo;
    }

    public RString getHdnBarCode() {
        return hdnBarCode;
    }

    public void setBtnDelete(Button btnDelete) {
        this.setOriginalData("btnDelete", btnDelete);
        this.btnDelete = btnDelete;
    }

    public void setTxtShimei(RString txtShimei) {
        this.setOriginalData("txtShimei", txtShimei);
        this.txtShimei = txtShimei;
    }

    public void setTxtSeibetsu(RString txtSeibetsu) {
        this.setOriginalData("txtSeibetsu", txtSeibetsu);
        this.txtSeibetsu = txtSeibetsu;
    }

    public void setTxtJusho(RString txtJusho) {
        this.setOriginalData("txtJusho", txtJusho);
        this.txtJusho = txtJusho;
    }

    public void setTxtTohyokuCode(RString txtTohyokuCode) {
        this.setOriginalData("txtTohyokuCode", txtTohyokuCode);
        this.txtTohyokuCode = txtTohyokuCode;
    }

    public void setTxtPage(RString txtPage) {
        this.setOriginalData("txtPage", txtPage);
        this.txtPage = txtPage;
    }

    public void setTxtGyo(RString txtGyo) {
        this.setOriginalData("txtGyo", txtGyo);
        this.txtGyo = txtGyo;
    }

    public void setChkAll(CheckBoxList chkAll) {
        this.setOriginalData("chkAll", chkAll);
        this.chkAll = chkAll;
    }

    public void setChkSenkyo1(CheckBoxList chkSenkyo1) {
        this.setOriginalData("chkSenkyo1", chkSenkyo1);
        this.chkSenkyo1 = chkSenkyo1;
    }

    public void setChkSenkyo2(CheckBoxList chkSenkyo2) {
        this.setOriginalData("chkSenkyo2", chkSenkyo2);
        this.chkSenkyo2 = chkSenkyo2;
    }

    public void setChkSenkyo3(CheckBoxList chkSenkyo3) {
        this.setOriginalData("chkSenkyo3", chkSenkyo3);
        this.chkSenkyo3 = chkSenkyo3;
    }

    public void setChkSenkyo4(CheckBoxList chkSenkyo4) {
        this.setOriginalData("chkSenkyo4", chkSenkyo4);
        this.chkSenkyo4 = chkSenkyo4;
    }

    public void setChkSenkyo5(CheckBoxList chkSenkyo5) {
        this.setOriginalData("chkSenkyo5", chkSenkyo5);
        this.chkSenkyo5 = chkSenkyo5;
    }

    public void setChkSenkyo6(CheckBoxList chkSenkyo6) {
        this.setOriginalData("chkSenkyo6", chkSenkyo6);
        this.chkSenkyo6 = chkSenkyo6;
    }

    public void setChkSenkyo7(CheckBoxList chkSenkyo7) {
        this.setOriginalData("chkSenkyo7", chkSenkyo7);
        this.chkSenkyo7 = chkSenkyo7;
    }

    public void setChkSenkyo8(CheckBoxList chkSenkyo8) {
        this.setOriginalData("chkSenkyo8", chkSenkyo8);
        this.chkSenkyo8 = chkSenkyo8;
    }

    public void setChkSenkyo9(CheckBoxList chkSenkyo9) {
        this.setOriginalData("chkSenkyo9", chkSenkyo9);
        this.chkSenkyo9 = chkSenkyo9;
    }

    public void setTxtSeinengappi(TextBoxDate txtSeinengappi) {
        this.setOriginalData("txtSeinengappi", txtSeinengappi);
        this.txtSeinengappi = txtSeinengappi;
    }

    public void setTxtJuminShubetsu(RString txtJuminShubetsu) {
        this.setOriginalData("txtJuminShubetsu", txtJuminShubetsu);
        this.txtJuminShubetsu = txtJuminShubetsu;
    }

    public void setTxtShikibetsuCode(RString txtShikibetsuCode) {
        this.setOriginalData("txtShikibetsuCode", txtShikibetsuCode);
        this.txtShikibetsuCode = txtShikibetsuCode;
    }

    public void setTxtSeitaiCode(RString txtSeitaiCode) {
        this.setOriginalData("txtSeitaiCode", txtSeitaiCode);
        this.txtSeitaiCode = txtSeitaiCode;
    }

    public void setTxtGyoseikuCode(RString txtGyoseikuCode) {
        this.setOriginalData("txtGyoseikuCode", txtGyoseikuCode);
        this.txtGyoseikuCode = txtGyoseikuCode;
    }

    public void setTxtSenkyoShikaku(RString txtSenkyoShikaku) {
        this.setOriginalData("txtSenkyoShikaku", txtSenkyoShikaku);
        this.txtSenkyoShikaku = txtSenkyoShikaku;
    }

    public void setTxtHyojiYmd(TextBoxFlexibleDate txtHyojiYmd) {
        this.setOriginalData("txtHyojiYmd", txtHyojiYmd);
        this.txtHyojiYmd = txtHyojiYmd;
    }

    public void setTxtMassyoYmd(TextBoxFlexibleDate txtMassyoYmd) {
        this.setOriginalData("txtMassyoYmd", txtMassyoYmd);
        this.txtMassyoYmd = txtMassyoYmd;
    }

    public void setHdnShohonNo(RString hdnShohonNo) {
        this.setOriginalData("hdnShohonNo", hdnShohonNo);
        this.hdnShohonNo = hdnShohonNo;
    }

    public void setHdnShikibetsuCode(RString hdnShikibetsuCode) {
        this.setOriginalData("hdnShikibetsuCode", hdnShikibetsuCode);
        this.hdnShikibetsuCode = hdnShikibetsuCode;
    }

    public void setHdnSenkyoNo(RString hdnSenkyoNo) {
        this.setOriginalData("hdnSenkyoNo", hdnSenkyoNo);
        this.hdnSenkyoNo = hdnSenkyoNo;
    }

    public void setHdnBarCode(RString hdnBarCode) {
        this.setOriginalData("hdnBarCode", hdnBarCode);
        this.hdnBarCode = hdnBarCode;
    }

    // </editor-fold>
}
