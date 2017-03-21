package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGML1010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.IShohonNameListDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.ShohonNameList.ShohonNameListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ZaisankuMeiboKoshinKijun のクラスファイル 
 * 
 * @author 自動生成
 */
public class ZaisankuMeiboKoshinKijunDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radShori")
    private RadioButton radShori;
    @JsonProperty("txtShohonName")
    private TextBox txtShohonName;
    @JsonProperty("txtTohyoYMD")
    private TextBoxDate txtTohyoYMD;
    @JsonProperty("txtKijunYMD")
    private TextBoxDate txtKijunYMD;
    @JsonProperty("txtMeiboTorokuYMD")
    private TextBoxDate txtMeiboTorokuYMD;
    @JsonProperty("txtTenshutsuYMD")
    private TextBoxDate txtTenshutsuYMD;
    @JsonProperty("lblTenshutsuYmd")
    private Label lblTenshutsuYmd;
    @JsonProperty("txtTennyuYMD")
    private TextBoxDate txtTennyuYMD;
    @JsonProperty("lblTennyuYmd")
    private Label lblTennyuYmd;
    @JsonProperty("txtNenreiTotatsuYMD")
    private TextBoxDate txtNenreiTotatsuYMD;
    @JsonProperty("lblNenreiKigenYmd")
    private Label lblNenreiKigenYmd;
    @JsonProperty("txtKyojuNensu")
    private TextBoxNum txtKyojuNensu;
    @JsonProperty("txtTohyoKaishiYMD")
    private TextBoxDate txtTohyoKaishiYMD;
    @JsonProperty("ccdShohonNameList")
    private ShohonNameListDiv ccdShohonNameList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradShori
     * @return radShori
     */
    @JsonProperty("radShori")
    public RadioButton getRadShori() {
        return radShori;
    }

    /*
     * setradShori
     * @param radShori radShori
     */
    @JsonProperty("radShori")
    public void setRadShori(RadioButton radShori) {
        this.radShori = radShori;
    }

    /*
     * gettxtShohonName
     * @return txtShohonName
     */
    @JsonProperty("txtShohonName")
    public TextBox getTxtShohonName() {
        return txtShohonName;
    }

    /*
     * settxtShohonName
     * @param txtShohonName txtShohonName
     */
    @JsonProperty("txtShohonName")
    public void setTxtShohonName(TextBox txtShohonName) {
        this.txtShohonName = txtShohonName;
    }

    /*
     * gettxtTohyoYMD
     * @return txtTohyoYMD
     */
    @JsonProperty("txtTohyoYMD")
    public TextBoxDate getTxtTohyoYMD() {
        return txtTohyoYMD;
    }

    /*
     * settxtTohyoYMD
     * @param txtTohyoYMD txtTohyoYMD
     */
    @JsonProperty("txtTohyoYMD")
    public void setTxtTohyoYMD(TextBoxDate txtTohyoYMD) {
        this.txtTohyoYMD = txtTohyoYMD;
    }

    /*
     * gettxtKijunYMD
     * @return txtKijunYMD
     */
    @JsonProperty("txtKijunYMD")
    public TextBoxDate getTxtKijunYMD() {
        return txtKijunYMD;
    }

    /*
     * settxtKijunYMD
     * @param txtKijunYMD txtKijunYMD
     */
    @JsonProperty("txtKijunYMD")
    public void setTxtKijunYMD(TextBoxDate txtKijunYMD) {
        this.txtKijunYMD = txtKijunYMD;
    }

    /*
     * gettxtMeiboTorokuYMD
     * @return txtMeiboTorokuYMD
     */
    @JsonProperty("txtMeiboTorokuYMD")
    public TextBoxDate getTxtMeiboTorokuYMD() {
        return txtMeiboTorokuYMD;
    }

    /*
     * settxtMeiboTorokuYMD
     * @param txtMeiboTorokuYMD txtMeiboTorokuYMD
     */
    @JsonProperty("txtMeiboTorokuYMD")
    public void setTxtMeiboTorokuYMD(TextBoxDate txtMeiboTorokuYMD) {
        this.txtMeiboTorokuYMD = txtMeiboTorokuYMD;
    }

    /*
     * gettxtTenshutsuYMD
     * @return txtTenshutsuYMD
     */
    @JsonProperty("txtTenshutsuYMD")
    public TextBoxDate getTxtTenshutsuYMD() {
        return txtTenshutsuYMD;
    }

    /*
     * settxtTenshutsuYMD
     * @param txtTenshutsuYMD txtTenshutsuYMD
     */
    @JsonProperty("txtTenshutsuYMD")
    public void setTxtTenshutsuYMD(TextBoxDate txtTenshutsuYMD) {
        this.txtTenshutsuYMD = txtTenshutsuYMD;
    }

    /*
     * getlblTenshutsuYmd
     * @return lblTenshutsuYmd
     */
    @JsonProperty("lblTenshutsuYmd")
    public Label getLblTenshutsuYmd() {
        return lblTenshutsuYmd;
    }

    /*
     * setlblTenshutsuYmd
     * @param lblTenshutsuYmd lblTenshutsuYmd
     */
    @JsonProperty("lblTenshutsuYmd")
    public void setLblTenshutsuYmd(Label lblTenshutsuYmd) {
        this.lblTenshutsuYmd = lblTenshutsuYmd;
    }

    /*
     * gettxtTennyuYMD
     * @return txtTennyuYMD
     */
    @JsonProperty("txtTennyuYMD")
    public TextBoxDate getTxtTennyuYMD() {
        return txtTennyuYMD;
    }

    /*
     * settxtTennyuYMD
     * @param txtTennyuYMD txtTennyuYMD
     */
    @JsonProperty("txtTennyuYMD")
    public void setTxtTennyuYMD(TextBoxDate txtTennyuYMD) {
        this.txtTennyuYMD = txtTennyuYMD;
    }

    /*
     * getlblTennyuYmd
     * @return lblTennyuYmd
     */
    @JsonProperty("lblTennyuYmd")
    public Label getLblTennyuYmd() {
        return lblTennyuYmd;
    }

    /*
     * setlblTennyuYmd
     * @param lblTennyuYmd lblTennyuYmd
     */
    @JsonProperty("lblTennyuYmd")
    public void setLblTennyuYmd(Label lblTennyuYmd) {
        this.lblTennyuYmd = lblTennyuYmd;
    }

    /*
     * gettxtNenreiTotatsuYMD
     * @return txtNenreiTotatsuYMD
     */
    @JsonProperty("txtNenreiTotatsuYMD")
    public TextBoxDate getTxtNenreiTotatsuYMD() {
        return txtNenreiTotatsuYMD;
    }

    /*
     * settxtNenreiTotatsuYMD
     * @param txtNenreiTotatsuYMD txtNenreiTotatsuYMD
     */
    @JsonProperty("txtNenreiTotatsuYMD")
    public void setTxtNenreiTotatsuYMD(TextBoxDate txtNenreiTotatsuYMD) {
        this.txtNenreiTotatsuYMD = txtNenreiTotatsuYMD;
    }

    /*
     * getlblNenreiKigenYmd
     * @return lblNenreiKigenYmd
     */
    @JsonProperty("lblNenreiKigenYmd")
    public Label getLblNenreiKigenYmd() {
        return lblNenreiKigenYmd;
    }

    /*
     * setlblNenreiKigenYmd
     * @param lblNenreiKigenYmd lblNenreiKigenYmd
     */
    @JsonProperty("lblNenreiKigenYmd")
    public void setLblNenreiKigenYmd(Label lblNenreiKigenYmd) {
        this.lblNenreiKigenYmd = lblNenreiKigenYmd;
    }

    /*
     * gettxtKyojuNensu
     * @return txtKyojuNensu
     */
    @JsonProperty("txtKyojuNensu")
    public TextBoxNum getTxtKyojuNensu() {
        return txtKyojuNensu;
    }

    /*
     * settxtKyojuNensu
     * @param txtKyojuNensu txtKyojuNensu
     */
    @JsonProperty("txtKyojuNensu")
    public void setTxtKyojuNensu(TextBoxNum txtKyojuNensu) {
        this.txtKyojuNensu = txtKyojuNensu;
    }

    /*
     * gettxtTohyoKaishiYMD
     * @return txtTohyoKaishiYMD
     */
    @JsonProperty("txtTohyoKaishiYMD")
    public TextBoxDate getTxtTohyoKaishiYMD() {
        return txtTohyoKaishiYMD;
    }

    /*
     * settxtTohyoKaishiYMD
     * @param txtTohyoKaishiYMD txtTohyoKaishiYMD
     */
    @JsonProperty("txtTohyoKaishiYMD")
    public void setTxtTohyoKaishiYMD(TextBoxDate txtTohyoKaishiYMD) {
        this.txtTohyoKaishiYMD = txtTohyoKaishiYMD;
    }

    /*
     * getccdShohonNameList
     * @return ccdShohonNameList
     */
    @JsonProperty("ccdShohonNameList")
    public IShohonNameListDiv getCcdShohonNameList() {
        return ccdShohonNameList;
    }

    // </editor-fold>
}
