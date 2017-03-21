package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMH1010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SeikyushaTorokuNaiyoNyuryoku のクラスファイル 
 * 
 * @author 自動生成
 */
public class SeikyushaTorokuNaiyoNyuryokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSeikyuYMD")
    private TextBoxDate txtSeikyuYMD;
    @JsonProperty("txtSeikyuName")
    private TextBox txtSeikyuName;
    @JsonProperty("txtSeikyuNaiyo")
    private TextBoxMultiLine txtSeikyuNaiyo;
    @JsonProperty("txtKofuYMD")
    private TextBoxDate txtKofuYMD;
    @JsonProperty("txtTeishutsuKigenYMD")
    private TextBoxDate txtTeishutsuKigenYMD;
    @JsonProperty("ddlKofuSoshiki")
    private DropDownList ddlKofuSoshiki;
    @JsonProperty("txtKofushaName")
    private TextBox txtKofushaName;
    @JsonProperty("btnAddNew")
    private Button btnAddNew;
    @JsonProperty("btnStop")
    private Button btnStop;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtSeikyuYMD
     * @return txtSeikyuYMD
     */
    @JsonProperty("txtSeikyuYMD")
    public TextBoxDate getTxtSeikyuYMD() {
        return txtSeikyuYMD;
    }

    /*
     * settxtSeikyuYMD
     * @param txtSeikyuYMD txtSeikyuYMD
     */
    @JsonProperty("txtSeikyuYMD")
    public void setTxtSeikyuYMD(TextBoxDate txtSeikyuYMD) {
        this.txtSeikyuYMD = txtSeikyuYMD;
    }

    /*
     * gettxtSeikyuName
     * @return txtSeikyuName
     */
    @JsonProperty("txtSeikyuName")
    public TextBox getTxtSeikyuName() {
        return txtSeikyuName;
    }

    /*
     * settxtSeikyuName
     * @param txtSeikyuName txtSeikyuName
     */
    @JsonProperty("txtSeikyuName")
    public void setTxtSeikyuName(TextBox txtSeikyuName) {
        this.txtSeikyuName = txtSeikyuName;
    }

    /*
     * gettxtSeikyuNaiyo
     * @return txtSeikyuNaiyo
     */
    @JsonProperty("txtSeikyuNaiyo")
    public TextBoxMultiLine getTxtSeikyuNaiyo() {
        return txtSeikyuNaiyo;
    }

    /*
     * settxtSeikyuNaiyo
     * @param txtSeikyuNaiyo txtSeikyuNaiyo
     */
    @JsonProperty("txtSeikyuNaiyo")
    public void setTxtSeikyuNaiyo(TextBoxMultiLine txtSeikyuNaiyo) {
        this.txtSeikyuNaiyo = txtSeikyuNaiyo;
    }

    /*
     * gettxtKofuYMD
     * @return txtKofuYMD
     */
    @JsonProperty("txtKofuYMD")
    public TextBoxDate getTxtKofuYMD() {
        return txtKofuYMD;
    }

    /*
     * settxtKofuYMD
     * @param txtKofuYMD txtKofuYMD
     */
    @JsonProperty("txtKofuYMD")
    public void setTxtKofuYMD(TextBoxDate txtKofuYMD) {
        this.txtKofuYMD = txtKofuYMD;
    }

    /*
     * gettxtTeishutsuKigenYMD
     * @return txtTeishutsuKigenYMD
     */
    @JsonProperty("txtTeishutsuKigenYMD")
    public TextBoxDate getTxtTeishutsuKigenYMD() {
        return txtTeishutsuKigenYMD;
    }

    /*
     * settxtTeishutsuKigenYMD
     * @param txtTeishutsuKigenYMD txtTeishutsuKigenYMD
     */
    @JsonProperty("txtTeishutsuKigenYMD")
    public void setTxtTeishutsuKigenYMD(TextBoxDate txtTeishutsuKigenYMD) {
        this.txtTeishutsuKigenYMD = txtTeishutsuKigenYMD;
    }

    /*
     * getddlKofuSoshiki
     * @return ddlKofuSoshiki
     */
    @JsonProperty("ddlKofuSoshiki")
    public DropDownList getDdlKofuSoshiki() {
        return ddlKofuSoshiki;
    }

    /*
     * setddlKofuSoshiki
     * @param ddlKofuSoshiki ddlKofuSoshiki
     */
    @JsonProperty("ddlKofuSoshiki")
    public void setDdlKofuSoshiki(DropDownList ddlKofuSoshiki) {
        this.ddlKofuSoshiki = ddlKofuSoshiki;
    }

    /*
     * gettxtKofushaName
     * @return txtKofushaName
     */
    @JsonProperty("txtKofushaName")
    public TextBox getTxtKofushaName() {
        return txtKofushaName;
    }

    /*
     * settxtKofushaName
     * @param txtKofushaName txtKofushaName
     */
    @JsonProperty("txtKofushaName")
    public void setTxtKofushaName(TextBox txtKofushaName) {
        this.txtKofushaName = txtKofushaName;
    }

    /*
     * getbtnAddNew
     * @return btnAddNew
     */
    @JsonProperty("btnAddNew")
    public Button getBtnAddNew() {
        return btnAddNew;
    }

    /*
     * setbtnAddNew
     * @param btnAddNew btnAddNew
     */
    @JsonProperty("btnAddNew")
    public void setBtnAddNew(Button btnAddNew) {
        this.btnAddNew = btnAddNew;
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
