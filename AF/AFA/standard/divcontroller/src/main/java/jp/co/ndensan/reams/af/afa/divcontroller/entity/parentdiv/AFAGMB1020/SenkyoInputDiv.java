package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB1020;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SenkyoInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class SenkyoInputDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-02-19_14-33-39">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSenkyoNo")
    private TextBoxNum txtSenkyoNo;
    @JsonProperty("ddlSenkyoLevel")
    private DropDownList ddlSenkyoLevel;
    @JsonProperty("chkMutohyoFlag")
    private CheckBoxList chkMutohyoFlag;
    @JsonProperty("txtSenkyoName")
    private TextBox txtSenkyoName;
    @JsonProperty("txtSenkyoRyakusho")
    private TextBox txtSenkyoRyakusho;
    @JsonProperty("txtSenkyoMark")
    private TextBox txtSenkyoMark;
    @JsonProperty("txtKijunYMD")
    private TextBoxDate txtKijunYMD;
    @JsonProperty("txtUketsukeYMD")
    private TextBoxDate txtUketsukeYMD;
    @JsonProperty("txtKokujiYMD")
    private TextBoxDate txtKokujiYMD;
    @JsonProperty("txtTorokuYMD")
    private TextBoxDate txtTorokuYMD;
    @JsonProperty("txtTenshutsuKigenYMD")
    private TextBoxDate txtTenshutsuKigenYMD;
    @JsonProperty("txtTennyuKigenYMD")
    private TextBoxDate txtTennyuKigenYMD;
    @JsonProperty("btnInsert")
    private Button btnInsert;
    @JsonProperty("btnStop")
    private Button btnStop;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtSenkyoNo
     * @return txtSenkyoNo
     */
    @JsonProperty("txtSenkyoNo")
    public TextBoxNum getTxtSenkyoNo() {
        return txtSenkyoNo;
    }

    /*
     * settxtSenkyoNo
     * @param txtSenkyoNo txtSenkyoNo
     */
    @JsonProperty("txtSenkyoNo")
    public void setTxtSenkyoNo(TextBoxNum txtSenkyoNo) {
        this.txtSenkyoNo = txtSenkyoNo;
    }

    /*
     * getddlSenkyoLevel
     * @return ddlSenkyoLevel
     */
    @JsonProperty("ddlSenkyoLevel")
    public DropDownList getDdlSenkyoLevel() {
        return ddlSenkyoLevel;
    }

    /*
     * setddlSenkyoLevel
     * @param ddlSenkyoLevel ddlSenkyoLevel
     */
    @JsonProperty("ddlSenkyoLevel")
    public void setDdlSenkyoLevel(DropDownList ddlSenkyoLevel) {
        this.ddlSenkyoLevel = ddlSenkyoLevel;
    }

    /*
     * getchkMutohyoFlag
     * @return chkMutohyoFlag
     */
    @JsonProperty("chkMutohyoFlag")
    public CheckBoxList getChkMutohyoFlag() {
        return chkMutohyoFlag;
    }

    /*
     * setchkMutohyoFlag
     * @param chkMutohyoFlag chkMutohyoFlag
     */
    @JsonProperty("chkMutohyoFlag")
    public void setChkMutohyoFlag(CheckBoxList chkMutohyoFlag) {
        this.chkMutohyoFlag = chkMutohyoFlag;
    }

    /*
     * gettxtSenkyoName
     * @return txtSenkyoName
     */
    @JsonProperty("txtSenkyoName")
    public TextBox getTxtSenkyoName() {
        return txtSenkyoName;
    }

    /*
     * settxtSenkyoName
     * @param txtSenkyoName txtSenkyoName
     */
    @JsonProperty("txtSenkyoName")
    public void setTxtSenkyoName(TextBox txtSenkyoName) {
        this.txtSenkyoName = txtSenkyoName;
    }

    /*
     * gettxtSenkyoRyakusho
     * @return txtSenkyoRyakusho
     */
    @JsonProperty("txtSenkyoRyakusho")
    public TextBox getTxtSenkyoRyakusho() {
        return txtSenkyoRyakusho;
    }

    /*
     * settxtSenkyoRyakusho
     * @param txtSenkyoRyakusho txtSenkyoRyakusho
     */
    @JsonProperty("txtSenkyoRyakusho")
    public void setTxtSenkyoRyakusho(TextBox txtSenkyoRyakusho) {
        this.txtSenkyoRyakusho = txtSenkyoRyakusho;
    }

    /*
     * gettxtSenkyoMark
     * @return txtSenkyoMark
     */
    @JsonProperty("txtSenkyoMark")
    public TextBox getTxtSenkyoMark() {
        return txtSenkyoMark;
    }

    /*
     * settxtSenkyoMark
     * @param txtSenkyoMark txtSenkyoMark
     */
    @JsonProperty("txtSenkyoMark")
    public void setTxtSenkyoMark(TextBox txtSenkyoMark) {
        this.txtSenkyoMark = txtSenkyoMark;
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
     * gettxtUketsukeYMD
     * @return txtUketsukeYMD
     */
    @JsonProperty("txtUketsukeYMD")
    public TextBoxDate getTxtUketsukeYMD() {
        return txtUketsukeYMD;
    }

    /*
     * settxtUketsukeYMD
     * @param txtUketsukeYMD txtUketsukeYMD
     */
    @JsonProperty("txtUketsukeYMD")
    public void setTxtUketsukeYMD(TextBoxDate txtUketsukeYMD) {
        this.txtUketsukeYMD = txtUketsukeYMD;
    }

    /*
     * gettxtKokujiYMD
     * @return txtKokujiYMD
     */
    @JsonProperty("txtKokujiYMD")
    public TextBoxDate getTxtKokujiYMD() {
        return txtKokujiYMD;
    }

    /*
     * settxtKokujiYMD
     * @param txtKokujiYMD txtKokujiYMD
     */
    @JsonProperty("txtKokujiYMD")
    public void setTxtKokujiYMD(TextBoxDate txtKokujiYMD) {
        this.txtKokujiYMD = txtKokujiYMD;
    }

    /*
     * gettxtTorokuYMD
     * @return txtTorokuYMD
     */
    @JsonProperty("txtTorokuYMD")
    public TextBoxDate getTxtTorokuYMD() {
        return txtTorokuYMD;
    }

    /*
     * settxtTorokuYMD
     * @param txtTorokuYMD txtTorokuYMD
     */
    @JsonProperty("txtTorokuYMD")
    public void setTxtTorokuYMD(TextBoxDate txtTorokuYMD) {
        this.txtTorokuYMD = txtTorokuYMD;
    }

    /*
     * gettxtTenshutsuKigenYMD
     * @return txtTenshutsuKigenYMD
     */
    @JsonProperty("txtTenshutsuKigenYMD")
    public TextBoxDate getTxtTenshutsuKigenYMD() {
        return txtTenshutsuKigenYMD;
    }

    /*
     * settxtTenshutsuKigenYMD
     * @param txtTenshutsuKigenYMD txtTenshutsuKigenYMD
     */
    @JsonProperty("txtTenshutsuKigenYMD")
    public void setTxtTenshutsuKigenYMD(TextBoxDate txtTenshutsuKigenYMD) {
        this.txtTenshutsuKigenYMD = txtTenshutsuKigenYMD;
    }

    /*
     * gettxtTennyuKigenYMD
     * @return txtTennyuKigenYMD
     */
    @JsonProperty("txtTennyuKigenYMD")
    public TextBoxDate getTxtTennyuKigenYMD() {
        return txtTennyuKigenYMD;
    }

    /*
     * settxtTennyuKigenYMD
     * @param txtTennyuKigenYMD txtTennyuKigenYMD
     */
    @JsonProperty("txtTennyuKigenYMD")
    public void setTxtTennyuKigenYMD(TextBoxDate txtTennyuKigenYMD) {
        this.txtTennyuKigenYMD = txtTennyuKigenYMD;
    }

    /*
     * getbtnInsert
     * @return btnInsert
     */
    @JsonProperty("btnInsert")
    public Button getBtnInsert() {
        return btnInsert;
    }

    /*
     * setbtnInsert
     * @param btnInsert btnInsert
     */
    @JsonProperty("btnInsert")
    public void setBtnInsert(Button btnInsert) {
        this.btnInsert = btnInsert;
    }

    /*
     * getbtnStop
     * @return btnStop
     */
    @JsonProperty("btnStop")
    public Button getBtnStop() {
        return btnStop;
    }

    /*
     * setbtnStop
     * @param btnStop btnStop
     */
    @JsonProperty("btnStop")
    public void setBtnStop(Button btnStop) {
        this.btnStop = btnStop;
    }

    // </editor-fold>
}
