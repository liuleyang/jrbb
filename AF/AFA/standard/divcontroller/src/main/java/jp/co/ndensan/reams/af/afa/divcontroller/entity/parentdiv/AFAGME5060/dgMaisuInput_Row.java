package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME5060;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Sep 21 16:31:11 CST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;


/**
 * dgMaisuInput_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgMaisuInput_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">

    private RString txtTohyokuCode;
    private TextBoxNum txtTohyoYoshiMaisu;
    private TextBoxNum txtTenjiYoshiMaisu;
    private TextBoxNum txtKariFutoMaisu;
    private RString hidMotoData;

    public dgMaisuInput_Row() {
        super();
        this.txtTohyokuCode = RString.EMPTY;
        this.txtTohyoYoshiMaisu = new TextBoxNum();
        this.txtTenjiYoshiMaisu = new TextBoxNum();
        this.txtKariFutoMaisu = new TextBoxNum();
        this.hidMotoData = RString.EMPTY;
        this.setOriginalData("txtTohyokuCode", txtTohyokuCode);
        this.setOriginalData("txtTohyoYoshiMaisu", txtTohyoYoshiMaisu);
        this.setOriginalData("txtTenjiYoshiMaisu", txtTenjiYoshiMaisu);
        this.setOriginalData("txtKariFutoMaisu", txtKariFutoMaisu);
        this.setOriginalData("hidMotoData", hidMotoData);
    }

    public dgMaisuInput_Row(RString txtTohyokuCode, TextBoxNum txtTohyoYoshiMaisu, TextBoxNum txtTenjiYoshiMaisu, TextBoxNum txtKariFutoMaisu, RString hidMotoData) {
        super();
        this.setOriginalData("txtTohyokuCode", txtTohyokuCode);
        this.setOriginalData("txtTohyoYoshiMaisu", txtTohyoYoshiMaisu);
        this.setOriginalData("txtTenjiYoshiMaisu", txtTenjiYoshiMaisu);
        this.setOriginalData("txtKariFutoMaisu", txtKariFutoMaisu);
        this.setOriginalData("hidMotoData", hidMotoData);
        this.txtTohyokuCode = txtTohyokuCode;
        this.txtTohyoYoshiMaisu = txtTohyoYoshiMaisu;
        this.txtTenjiYoshiMaisu = txtTenjiYoshiMaisu;
        this.txtKariFutoMaisu = txtKariFutoMaisu;
        this.hidMotoData = hidMotoData;
    }

    public RString getTxtTohyokuCode() {
        return txtTohyokuCode;
    }

    public TextBoxNum getTxtTohyoYoshiMaisu() {
        return txtTohyoYoshiMaisu;
    }

    public TextBoxNum getTxtTenjiYoshiMaisu() {
        return txtTenjiYoshiMaisu;
    }

    public TextBoxNum getTxtKariFutoMaisu() {
        return txtKariFutoMaisu;
    }

    public RString getHidMotoData() {
        return hidMotoData;
    }

    public void setTxtTohyokuCode(RString txtTohyokuCode) {
        this.setOriginalData("txtTohyokuCode", txtTohyokuCode);
        this.txtTohyokuCode = txtTohyokuCode;
    }

    public void setTxtTohyoYoshiMaisu(TextBoxNum txtTohyoYoshiMaisu) {
        this.setOriginalData("txtTohyoYoshiMaisu", txtTohyoYoshiMaisu);
        this.txtTohyoYoshiMaisu = txtTohyoYoshiMaisu;
    }

    public void setTxtTenjiYoshiMaisu(TextBoxNum txtTenjiYoshiMaisu) {
        this.setOriginalData("txtTenjiYoshiMaisu", txtTenjiYoshiMaisu);
        this.txtTenjiYoshiMaisu = txtTenjiYoshiMaisu;
    }

    public void setTxtKariFutoMaisu(TextBoxNum txtKariFutoMaisu) {
        this.setOriginalData("txtKariFutoMaisu", txtKariFutoMaisu);
        this.txtKariFutoMaisu = txtKariFutoMaisu;
    }

    public void setHidMotoData(RString hidMotoData) {
        this.setOriginalData("hidMotoData", hidMotoData);
        this.hidMotoData = hidMotoData;
    }

    // </editor-fold>
}
