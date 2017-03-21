package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMD1010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Fri Oct 07 13:55:25 JST 2016 
 */



import jp.co.ndensan.reams.uz.uza.ui.binding.DataRow;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;


/**
 * dgShikakuShokai_Row のクラスファイル 
 * 
 * @author 自動生成
 */

public class dgShikakuShokai_Row extends DataRow {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">

    private RString txtRirekiNo;
    private RString txtSenkyoShikaku;
    private RString txtTohyokuCode;
    private TextBoxFlexibleDate txtMeiboTorokuYMD;
    private RString txtTorokuJiyu;
    private TextBoxFlexibleDate txtTorokuTeshiYMD;
    private RString txtTorokuTeishiJiyu;
    private TextBoxFlexibleDate txtHyojiYMD;
    private RString txtHyojiJiyu;
    private TextBoxFlexibleDate txtHyojiShojoYMD;
    private TextBoxFlexibleDate txtHyojiShojoYoteiYMD;
    private TextBoxFlexibleDate txtMasshoYMD;
    private RString txtMasshoJiyu;
    private TextBoxFlexibleDate txtKeikiShuryoYMD;
    private Boolean chkNikeiMochi;
    private RString txtKokuminTohyoKubun;
    private RString txtKokuminShohonNo;
    private RString txtHonsekiTorokuKubun;
    private RString txtKofuNo;
    private TextBoxFlexibleDate txtKofuYMD;
    private RString txtShuseiKubun;
    private TextBoxFlexibleDate txtShuseiYMD;
    private RString txtSaiKofuJiyu;
    private RString txtHenkoJiyu;
    private RString txtTokkiJiko;

    public dgShikakuShokai_Row() {
        super();
        this.txtRirekiNo = RString.EMPTY;
        this.txtSenkyoShikaku = RString.EMPTY;
        this.txtTohyokuCode = RString.EMPTY;
        this.txtMeiboTorokuYMD = new TextBoxFlexibleDate();
        this.txtTorokuJiyu = RString.EMPTY;
        this.txtTorokuTeshiYMD = new TextBoxFlexibleDate();
        this.txtTorokuTeishiJiyu = RString.EMPTY;
        this.txtHyojiYMD = new TextBoxFlexibleDate();
        this.txtHyojiJiyu = RString.EMPTY;
        this.txtHyojiShojoYMD = new TextBoxFlexibleDate();
        this.txtHyojiShojoYoteiYMD = new TextBoxFlexibleDate();
        this.txtMasshoYMD = new TextBoxFlexibleDate();
        this.txtMasshoJiyu = RString.EMPTY;
        this.txtKeikiShuryoYMD = new TextBoxFlexibleDate();
        this.chkNikeiMochi = false;
        this.txtKokuminTohyoKubun = RString.EMPTY;
        this.txtKokuminShohonNo = RString.EMPTY;
        this.txtHonsekiTorokuKubun = RString.EMPTY;
        this.txtKofuNo = RString.EMPTY;
        this.txtKofuYMD = new TextBoxFlexibleDate();
        this.txtShuseiKubun = RString.EMPTY;
        this.txtShuseiYMD = new TextBoxFlexibleDate();
        this.txtSaiKofuJiyu = RString.EMPTY;
        this.txtHenkoJiyu = RString.EMPTY;
        this.txtTokkiJiko = RString.EMPTY;
        this.setOriginalData("txtRirekiNo", txtRirekiNo);
        this.setOriginalData("txtSenkyoShikaku", txtSenkyoShikaku);
        this.setOriginalData("txtTohyokuCode", txtTohyokuCode);
        this.setOriginalData("txtMeiboTorokuYMD", txtMeiboTorokuYMD);
        this.setOriginalData("txtTorokuJiyu", txtTorokuJiyu);
        this.setOriginalData("txtTorokuTeshiYMD", txtTorokuTeshiYMD);
        this.setOriginalData("txtTorokuTeishiJiyu", txtTorokuTeishiJiyu);
        this.setOriginalData("txtHyojiYMD", txtHyojiYMD);
        this.setOriginalData("txtHyojiJiyu", txtHyojiJiyu);
        this.setOriginalData("txtHyojiShojoYMD", txtHyojiShojoYMD);
        this.setOriginalData("txtHyojiShojoYoteiYMD", txtHyojiShojoYoteiYMD);
        this.setOriginalData("txtMasshoYMD", txtMasshoYMD);
        this.setOriginalData("txtMasshoJiyu", txtMasshoJiyu);
        this.setOriginalData("txtKeikiShuryoYMD", txtKeikiShuryoYMD);
        this.setOriginalData("chkNikeiMochi", chkNikeiMochi);
        this.setOriginalData("txtKokuminTohyoKubun", txtKokuminTohyoKubun);
        this.setOriginalData("txtKokuminShohonNo", txtKokuminShohonNo);
        this.setOriginalData("txtHonsekiTorokuKubun", txtHonsekiTorokuKubun);
        this.setOriginalData("txtKofuNo", txtKofuNo);
        this.setOriginalData("txtKofuYMD", txtKofuYMD);
        this.setOriginalData("txtShuseiKubun", txtShuseiKubun);
        this.setOriginalData("txtShuseiYMD", txtShuseiYMD);
        this.setOriginalData("txtSaiKofuJiyu", txtSaiKofuJiyu);
        this.setOriginalData("txtHenkoJiyu", txtHenkoJiyu);
        this.setOriginalData("txtTokkiJiko", txtTokkiJiko);
    }

    public dgShikakuShokai_Row(RString txtRirekiNo, RString txtSenkyoShikaku, RString txtTohyokuCode, TextBoxFlexibleDate txtMeiboTorokuYMD, RString txtTorokuJiyu, TextBoxFlexibleDate txtTorokuTeshiYMD, RString txtTorokuTeishiJiyu, TextBoxFlexibleDate txtHyojiYMD, RString txtHyojiJiyu, TextBoxFlexibleDate txtHyojiShojoYMD, TextBoxFlexibleDate txtHyojiShojoYoteiYMD, TextBoxFlexibleDate txtMasshoYMD, RString txtMasshoJiyu, TextBoxFlexibleDate txtKeikiShuryoYMD, Boolean chkNikeiMochi, RString txtKokuminTohyoKubun, RString txtKokuminShohonNo, RString txtHonsekiTorokuKubun, RString txtKofuNo, TextBoxFlexibleDate txtKofuYMD, RString txtShuseiKubun, TextBoxFlexibleDate txtShuseiYMD, RString txtSaiKofuJiyu, RString txtHenkoJiyu, RString txtTokkiJiko) {
        super();
        this.setOriginalData("txtRirekiNo", txtRirekiNo);
        this.setOriginalData("txtSenkyoShikaku", txtSenkyoShikaku);
        this.setOriginalData("txtTohyokuCode", txtTohyokuCode);
        this.setOriginalData("txtMeiboTorokuYMD", txtMeiboTorokuYMD);
        this.setOriginalData("txtTorokuJiyu", txtTorokuJiyu);
        this.setOriginalData("txtTorokuTeshiYMD", txtTorokuTeshiYMD);
        this.setOriginalData("txtTorokuTeishiJiyu", txtTorokuTeishiJiyu);
        this.setOriginalData("txtHyojiYMD", txtHyojiYMD);
        this.setOriginalData("txtHyojiJiyu", txtHyojiJiyu);
        this.setOriginalData("txtHyojiShojoYMD", txtHyojiShojoYMD);
        this.setOriginalData("txtHyojiShojoYoteiYMD", txtHyojiShojoYoteiYMD);
        this.setOriginalData("txtMasshoYMD", txtMasshoYMD);
        this.setOriginalData("txtMasshoJiyu", txtMasshoJiyu);
        this.setOriginalData("txtKeikiShuryoYMD", txtKeikiShuryoYMD);
        this.setOriginalData("chkNikeiMochi", chkNikeiMochi);
        this.setOriginalData("txtKokuminTohyoKubun", txtKokuminTohyoKubun);
        this.setOriginalData("txtKokuminShohonNo", txtKokuminShohonNo);
        this.setOriginalData("txtHonsekiTorokuKubun", txtHonsekiTorokuKubun);
        this.setOriginalData("txtKofuNo", txtKofuNo);
        this.setOriginalData("txtKofuYMD", txtKofuYMD);
        this.setOriginalData("txtShuseiKubun", txtShuseiKubun);
        this.setOriginalData("txtShuseiYMD", txtShuseiYMD);
        this.setOriginalData("txtSaiKofuJiyu", txtSaiKofuJiyu);
        this.setOriginalData("txtHenkoJiyu", txtHenkoJiyu);
        this.setOriginalData("txtTokkiJiko", txtTokkiJiko);
        this.txtRirekiNo = txtRirekiNo;
        this.txtSenkyoShikaku = txtSenkyoShikaku;
        this.txtTohyokuCode = txtTohyokuCode;
        this.txtMeiboTorokuYMD = txtMeiboTorokuYMD;
        this.txtTorokuJiyu = txtTorokuJiyu;
        this.txtTorokuTeshiYMD = txtTorokuTeshiYMD;
        this.txtTorokuTeishiJiyu = txtTorokuTeishiJiyu;
        this.txtHyojiYMD = txtHyojiYMD;
        this.txtHyojiJiyu = txtHyojiJiyu;
        this.txtHyojiShojoYMD = txtHyojiShojoYMD;
        this.txtHyojiShojoYoteiYMD = txtHyojiShojoYoteiYMD;
        this.txtMasshoYMD = txtMasshoYMD;
        this.txtMasshoJiyu = txtMasshoJiyu;
        this.txtKeikiShuryoYMD = txtKeikiShuryoYMD;
        this.chkNikeiMochi = chkNikeiMochi;
        this.txtKokuminTohyoKubun = txtKokuminTohyoKubun;
        this.txtKokuminShohonNo = txtKokuminShohonNo;
        this.txtHonsekiTorokuKubun = txtHonsekiTorokuKubun;
        this.txtKofuNo = txtKofuNo;
        this.txtKofuYMD = txtKofuYMD;
        this.txtShuseiKubun = txtShuseiKubun;
        this.txtShuseiYMD = txtShuseiYMD;
        this.txtSaiKofuJiyu = txtSaiKofuJiyu;
        this.txtHenkoJiyu = txtHenkoJiyu;
        this.txtTokkiJiko = txtTokkiJiko;
    }

    public RString getTxtRirekiNo() {
        return txtRirekiNo;
    }

    public RString getTxtSenkyoShikaku() {
        return txtSenkyoShikaku;
    }

    public RString getTxtTohyokuCode() {
        return txtTohyokuCode;
    }

    public TextBoxFlexibleDate getTxtMeiboTorokuYMD() {
        return txtMeiboTorokuYMD;
    }

    public RString getTxtTorokuJiyu() {
        return txtTorokuJiyu;
    }

    public TextBoxFlexibleDate getTxtTorokuTeshiYMD() {
        return txtTorokuTeshiYMD;
    }

    public RString getTxtTorokuTeishiJiyu() {
        return txtTorokuTeishiJiyu;
    }

    public TextBoxFlexibleDate getTxtHyojiYMD() {
        return txtHyojiYMD;
    }

    public RString getTxtHyojiJiyu() {
        return txtHyojiJiyu;
    }

    public TextBoxFlexibleDate getTxtHyojiShojoYMD() {
        return txtHyojiShojoYMD;
    }

    public TextBoxFlexibleDate getTxtHyojiShojoYoteiYMD() {
        return txtHyojiShojoYoteiYMD;
    }

    public TextBoxFlexibleDate getTxtMasshoYMD() {
        return txtMasshoYMD;
    }

    public RString getTxtMasshoJiyu() {
        return txtMasshoJiyu;
    }

    public TextBoxFlexibleDate getTxtKeikiShuryoYMD() {
        return txtKeikiShuryoYMD;
    }

    public Boolean getChkNikeiMochi() {
        return chkNikeiMochi;
    }

    public RString getTxtKokuminTohyoKubun() {
        return txtKokuminTohyoKubun;
    }

    public RString getTxtKokuminShohonNo() {
        return txtKokuminShohonNo;
    }

    public RString getTxtHonsekiTorokuKubun() {
        return txtHonsekiTorokuKubun;
    }

    public RString getTxtKofuNo() {
        return txtKofuNo;
    }

    public TextBoxFlexibleDate getTxtKofuYMD() {
        return txtKofuYMD;
    }

    public RString getTxtShuseiKubun() {
        return txtShuseiKubun;
    }

    public TextBoxFlexibleDate getTxtShuseiYMD() {
        return txtShuseiYMD;
    }

    public RString getTxtSaiKofuJiyu() {
        return txtSaiKofuJiyu;
    }

    public RString getTxtHenkoJiyu() {
        return txtHenkoJiyu;
    }

    public RString getTxtTokkiJiko() {
        return txtTokkiJiko;
    }

    public void setTxtRirekiNo(RString txtRirekiNo) {
        this.setOriginalData("txtRirekiNo", txtRirekiNo);
        this.txtRirekiNo = txtRirekiNo;
    }

    public void setTxtSenkyoShikaku(RString txtSenkyoShikaku) {
        this.setOriginalData("txtSenkyoShikaku", txtSenkyoShikaku);
        this.txtSenkyoShikaku = txtSenkyoShikaku;
    }

    public void setTxtTohyokuCode(RString txtTohyokuCode) {
        this.setOriginalData("txtTohyokuCode", txtTohyokuCode);
        this.txtTohyokuCode = txtTohyokuCode;
    }

    public void setTxtMeiboTorokuYMD(TextBoxFlexibleDate txtMeiboTorokuYMD) {
        this.setOriginalData("txtMeiboTorokuYMD", txtMeiboTorokuYMD);
        this.txtMeiboTorokuYMD = txtMeiboTorokuYMD;
    }

    public void setTxtTorokuJiyu(RString txtTorokuJiyu) {
        this.setOriginalData("txtTorokuJiyu", txtTorokuJiyu);
        this.txtTorokuJiyu = txtTorokuJiyu;
    }

    public void setTxtTorokuTeshiYMD(TextBoxFlexibleDate txtTorokuTeshiYMD) {
        this.setOriginalData("txtTorokuTeshiYMD", txtTorokuTeshiYMD);
        this.txtTorokuTeshiYMD = txtTorokuTeshiYMD;
    }

    public void setTxtTorokuTeishiJiyu(RString txtTorokuTeishiJiyu) {
        this.setOriginalData("txtTorokuTeishiJiyu", txtTorokuTeishiJiyu);
        this.txtTorokuTeishiJiyu = txtTorokuTeishiJiyu;
    }

    public void setTxtHyojiYMD(TextBoxFlexibleDate txtHyojiYMD) {
        this.setOriginalData("txtHyojiYMD", txtHyojiYMD);
        this.txtHyojiYMD = txtHyojiYMD;
    }

    public void setTxtHyojiJiyu(RString txtHyojiJiyu) {
        this.setOriginalData("txtHyojiJiyu", txtHyojiJiyu);
        this.txtHyojiJiyu = txtHyojiJiyu;
    }

    public void setTxtHyojiShojoYMD(TextBoxFlexibleDate txtHyojiShojoYMD) {
        this.setOriginalData("txtHyojiShojoYMD", txtHyojiShojoYMD);
        this.txtHyojiShojoYMD = txtHyojiShojoYMD;
    }

    public void setTxtHyojiShojoYoteiYMD(TextBoxFlexibleDate txtHyojiShojoYoteiYMD) {
        this.setOriginalData("txtHyojiShojoYoteiYMD", txtHyojiShojoYoteiYMD);
        this.txtHyojiShojoYoteiYMD = txtHyojiShojoYoteiYMD;
    }

    public void setTxtMasshoYMD(TextBoxFlexibleDate txtMasshoYMD) {
        this.setOriginalData("txtMasshoYMD", txtMasshoYMD);
        this.txtMasshoYMD = txtMasshoYMD;
    }

    public void setTxtMasshoJiyu(RString txtMasshoJiyu) {
        this.setOriginalData("txtMasshoJiyu", txtMasshoJiyu);
        this.txtMasshoJiyu = txtMasshoJiyu;
    }

    public void setTxtKeikiShuryoYMD(TextBoxFlexibleDate txtKeikiShuryoYMD) {
        this.setOriginalData("txtKeikiShuryoYMD", txtKeikiShuryoYMD);
        this.txtKeikiShuryoYMD = txtKeikiShuryoYMD;
    }

    public void setChkNikeiMochi(Boolean chkNikeiMochi) {
        this.setOriginalData("chkNikeiMochi", chkNikeiMochi);
        this.chkNikeiMochi = chkNikeiMochi;
    }

    public void setTxtKokuminTohyoKubun(RString txtKokuminTohyoKubun) {
        this.setOriginalData("txtKokuminTohyoKubun", txtKokuminTohyoKubun);
        this.txtKokuminTohyoKubun = txtKokuminTohyoKubun;
    }

    public void setTxtKokuminShohonNo(RString txtKokuminShohonNo) {
        this.setOriginalData("txtKokuminShohonNo", txtKokuminShohonNo);
        this.txtKokuminShohonNo = txtKokuminShohonNo;
    }

    public void setTxtHonsekiTorokuKubun(RString txtHonsekiTorokuKubun) {
        this.setOriginalData("txtHonsekiTorokuKubun", txtHonsekiTorokuKubun);
        this.txtHonsekiTorokuKubun = txtHonsekiTorokuKubun;
    }

    public void setTxtKofuNo(RString txtKofuNo) {
        this.setOriginalData("txtKofuNo", txtKofuNo);
        this.txtKofuNo = txtKofuNo;
    }

    public void setTxtKofuYMD(TextBoxFlexibleDate txtKofuYMD) {
        this.setOriginalData("txtKofuYMD", txtKofuYMD);
        this.txtKofuYMD = txtKofuYMD;
    }

    public void setTxtShuseiKubun(RString txtShuseiKubun) {
        this.setOriginalData("txtShuseiKubun", txtShuseiKubun);
        this.txtShuseiKubun = txtShuseiKubun;
    }

    public void setTxtShuseiYMD(TextBoxFlexibleDate txtShuseiYMD) {
        this.setOriginalData("txtShuseiYMD", txtShuseiYMD);
        this.txtShuseiYMD = txtShuseiYMD;
    }

    public void setTxtSaiKofuJiyu(RString txtSaiKofuJiyu) {
        this.setOriginalData("txtSaiKofuJiyu", txtSaiKofuJiyu);
        this.txtSaiKofuJiyu = txtSaiKofuJiyu;
    }

    public void setTxtHenkoJiyu(RString txtHenkoJiyu) {
        this.setOriginalData("txtHenkoJiyu", txtHenkoJiyu);
        this.txtHenkoJiyu = txtHenkoJiyu;
    }

    public void setTxtTokkiJiko(RString txtTokkiJiko) {
        this.setOriginalData("txtTokkiJiko", txtTokkiJiko);
        this.txtTokkiJiko = txtTokkiJiko;
    }

    // </editor-fold>
}
