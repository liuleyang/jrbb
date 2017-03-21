package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMB2020;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NyujokenKobetsuSentaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class NyujokenKobetsuSentakuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
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
    @JsonProperty("btnSearchSimple")
    private ButtonDialog btnSearchSimple;
    @JsonProperty("dgNyujokenKobetsuTaishosha")
    private DataGrid<dgNyujokenKobetsuTaishosha_Row> dgNyujokenKobetsuTaishosha;
    @JsonProperty("txtNyujokenType")
    private TextBox txtNyujokenType;
    @JsonProperty("txtPrintNinzutxtNyujokenType")
    private TextBoxNum txtPrintNinzutxtNyujokenType;
    @JsonProperty("radHakkoTani")
    private RadioButton radHakkoTani;

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
     * getbtnSearchSimple
     * @return btnSearchSimple
     */
    @JsonProperty("btnSearchSimple")
    public ButtonDialog getBtnSearchSimple() {
        return btnSearchSimple;
    }

    /*
     * setbtnSearchSimple
     * @param btnSearchSimple btnSearchSimple
     */
    @JsonProperty("btnSearchSimple")
    public void setBtnSearchSimple(ButtonDialog btnSearchSimple) {
        this.btnSearchSimple = btnSearchSimple;
    }

    /*
     * getdgNyujokenKobetsuTaishosha
     * @return dgNyujokenKobetsuTaishosha
     */
    @JsonProperty("dgNyujokenKobetsuTaishosha")
    public DataGrid<dgNyujokenKobetsuTaishosha_Row> getDgNyujokenKobetsuTaishosha() {
        return dgNyujokenKobetsuTaishosha;
    }

    /*
     * setdgNyujokenKobetsuTaishosha
     * @param dgNyujokenKobetsuTaishosha dgNyujokenKobetsuTaishosha
     */
    @JsonProperty("dgNyujokenKobetsuTaishosha")
    public void setDgNyujokenKobetsuTaishosha(DataGrid<dgNyujokenKobetsuTaishosha_Row> dgNyujokenKobetsuTaishosha) {
        this.dgNyujokenKobetsuTaishosha = dgNyujokenKobetsuTaishosha;
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
     * getradHakkoTani
     * @return radHakkoTani
     */
    @JsonProperty("radHakkoTani")
    public RadioButton getRadHakkoTani() {
        return radHakkoTani;
    }

    /*
     * setradHakkoTani
     * @param radHakkoTani radHakkoTani
     */
    @JsonProperty("radHakkoTani")
    public void setRadHakkoTani(RadioButton radHakkoTani) {
        this.radHakkoTani = radHakkoTani;
    }

    // </editor-fold>
}
