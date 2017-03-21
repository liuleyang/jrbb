package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB2010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NyujokenSentaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class NyujokenSentakuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtFreeText1")
    private TextBox txtFreeText1;
    @JsonProperty("txtFreeText2")
    private TextBox txtFreeText2;
    @JsonProperty("txtFreeText3")
    private TextBox txtFreeText3;
    @JsonProperty("chkTaisho")
    private CheckBoxList chkTaisho;
    @JsonProperty("lblWarning")
    private Label lblWarning;
    @JsonProperty("dgNyujokenTohyokuSelect")
    private DataGrid<dgNyujokenTohyokuSelect_Row> dgNyujokenTohyokuSelect;
    @JsonProperty("txtNyujokenType")
    private TextBox txtNyujokenType;
    @JsonProperty("txtPrintNinzutxtNyujokenType")
    private TextBoxNum txtPrintNinzutxtNyujokenType;
    @JsonProperty("chkSetaiIchiran")
    private CheckBoxList chkSetaiIchiran;
    @JsonProperty("txtSetaiNinzu")
    private TextBox txtSetaiNinzu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtFreeText1
     * @return txtFreeText1
     */
    @JsonProperty("txtFreeText1")
    public TextBox getTxtFreeText1() {
        return txtFreeText1;
    }

    /*
     * settxtFreeText1
     * @param txtFreeText1 txtFreeText1
     */
    @JsonProperty("txtFreeText1")
    public void setTxtFreeText1(TextBox txtFreeText1) {
        this.txtFreeText1 = txtFreeText1;
    }

    /*
     * gettxtFreeText2
     * @return txtFreeText2
     */
    @JsonProperty("txtFreeText2")
    public TextBox getTxtFreeText2() {
        return txtFreeText2;
    }

    /*
     * settxtFreeText2
     * @param txtFreeText2 txtFreeText2
     */
    @JsonProperty("txtFreeText2")
    public void setTxtFreeText2(TextBox txtFreeText2) {
        this.txtFreeText2 = txtFreeText2;
    }

    /*
     * gettxtFreeText3
     * @return txtFreeText3
     */
    @JsonProperty("txtFreeText3")
    public TextBox getTxtFreeText3() {
        return txtFreeText3;
    }

    /*
     * settxtFreeText3
     * @param txtFreeText3 txtFreeText3
     */
    @JsonProperty("txtFreeText3")
    public void setTxtFreeText3(TextBox txtFreeText3) {
        this.txtFreeText3 = txtFreeText3;
    }

    /*
     * getchkTaisho
     * @return chkTaisho
     */
    @JsonProperty("chkTaisho")
    public CheckBoxList getChkTaisho() {
        return chkTaisho;
    }

    /*
     * setchkTaisho
     * @param chkTaisho chkTaisho
     */
    @JsonProperty("chkTaisho")
    public void setChkTaisho(CheckBoxList chkTaisho) {
        this.chkTaisho = chkTaisho;
    }

    /*
     * getlblWarning
     * @return lblWarning
     */
    @JsonProperty("lblWarning")
    public Label getLblWarning() {
        return lblWarning;
    }

    /*
     * setlblWarning
     * @param lblWarning lblWarning
     */
    @JsonProperty("lblWarning")
    public void setLblWarning(Label lblWarning) {
        this.lblWarning = lblWarning;
    }

    /*
     * getdgNyujokenTohyokuSelect
     * @return dgNyujokenTohyokuSelect
     */
    @JsonProperty("dgNyujokenTohyokuSelect")
    public DataGrid<dgNyujokenTohyokuSelect_Row> getDgNyujokenTohyokuSelect() {
        return dgNyujokenTohyokuSelect;
    }

    /*
     * setdgNyujokenTohyokuSelect
     * @param dgNyujokenTohyokuSelect dgNyujokenTohyokuSelect
     */
    @JsonProperty("dgNyujokenTohyokuSelect")
    public void setDgNyujokenTohyokuSelect(DataGrid<dgNyujokenTohyokuSelect_Row> dgNyujokenTohyokuSelect) {
        this.dgNyujokenTohyokuSelect = dgNyujokenTohyokuSelect;
    }

    /*
     * gettxtNyujokenType
     * @return txtNyujokenType
     */
    @JsonProperty("txtNyujokenType")
    public TextBox getTxtNyujokenType() {
        return txtNyujokenType;
    }

    /*
     * settxtNyujokenType
     * @param txtNyujokenType txtNyujokenType
     */
    @JsonProperty("txtNyujokenType")
    public void setTxtNyujokenType(TextBox txtNyujokenType) {
        this.txtNyujokenType = txtNyujokenType;
    }

    /*
     * gettxtPrintNinzutxtNyujokenType
     * @return txtPrintNinzutxtNyujokenType
     */
    @JsonProperty("txtPrintNinzutxtNyujokenType")
    public TextBoxNum getTxtPrintNinzutxtNyujokenType() {
        return txtPrintNinzutxtNyujokenType;
    }

    /*
     * settxtPrintNinzutxtNyujokenType
     * @param txtPrintNinzutxtNyujokenType txtPrintNinzutxtNyujokenType
     */
    @JsonProperty("txtPrintNinzutxtNyujokenType")
    public void setTxtPrintNinzutxtNyujokenType(TextBoxNum txtPrintNinzutxtNyujokenType) {
        this.txtPrintNinzutxtNyujokenType = txtPrintNinzutxtNyujokenType;
    }

    /*
     * getchkSetaiIchiran
     * @return chkSetaiIchiran
     */
    @JsonProperty("chkSetaiIchiran")
    public CheckBoxList getChkSetaiIchiran() {
        return chkSetaiIchiran;
    }

    /*
     * setchkSetaiIchiran
     * @param chkSetaiIchiran chkSetaiIchiran
     */
    @JsonProperty("chkSetaiIchiran")
    public void setChkSetaiIchiran(CheckBoxList chkSetaiIchiran) {
        this.chkSetaiIchiran = chkSetaiIchiran;
    }

    /*
     * gettxtSetaiNinzu
     * @return txtSetaiNinzu
     */
    @JsonProperty("txtSetaiNinzu")
    public TextBox getTxtSetaiNinzu() {
        return txtSetaiNinzu;
    }

    /*
     * settxtSetaiNinzu
     * @param txtSetaiNinzu txtSetaiNinzu
     */
    @JsonProperty("txtSetaiNinzu")
    public void setTxtSetaiNinzu(TextBox txtSetaiNinzu) {
        this.txtSetaiNinzu = txtSetaiNinzu;
    }

    // </editor-fold>
}
