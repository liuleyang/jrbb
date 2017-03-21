package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMH1030;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SeikyuShomeiboShomeisha のクラスファイル 
 * 
 * @author 自動生成
 */
public class SeikyuShomeiboShomeishaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSeikyuName")
    private TextBox txtSeikyuName;
    @JsonProperty("btnSearchSimple")
    private ButtonDialog btnSearchSimple;
    @JsonProperty("btnAddRow")
    private Button btnAddRow;
    @JsonProperty("dgSeikyuShomeiboShomeishaIchiran")
    private DataGrid<dgSeikyuShomeiboShomeishaIchiran_Row> dgSeikyuShomeiboShomeishaIchiran;
    @JsonProperty("btnUpdate")
    private Button btnUpdate;
    @JsonProperty("txtHdnShikibetsuCode")
    private RString txtHdnShikibetsuCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
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
     * getbtnAddRow
     * @return btnAddRow
     */
    @JsonProperty("btnAddRow")
    public Button getBtnAddRow() {
        return btnAddRow;
    }

    /*
     * setbtnAddRow
     * @param btnAddRow btnAddRow
     */
    @JsonProperty("btnAddRow")
    public void setBtnAddRow(Button btnAddRow) {
        this.btnAddRow = btnAddRow;
    }

    /*
     * getdgSeikyuShomeiboShomeishaIchiran
     * @return dgSeikyuShomeiboShomeishaIchiran
     */
    @JsonProperty("dgSeikyuShomeiboShomeishaIchiran")
    public DataGrid<dgSeikyuShomeiboShomeishaIchiran_Row> getDgSeikyuShomeiboShomeishaIchiran() {
        return dgSeikyuShomeiboShomeishaIchiran;
    }

    /*
     * setdgSeikyuShomeiboShomeishaIchiran
     * @param dgSeikyuShomeiboShomeishaIchiran dgSeikyuShomeiboShomeishaIchiran
     */
    @JsonProperty("dgSeikyuShomeiboShomeishaIchiran")
    public void setDgSeikyuShomeiboShomeishaIchiran(DataGrid<dgSeikyuShomeiboShomeishaIchiran_Row> dgSeikyuShomeiboShomeishaIchiran) {
        this.dgSeikyuShomeiboShomeishaIchiran = dgSeikyuShomeiboShomeishaIchiran;
    }

    /*
     * getbtnUpdate
     * @return btnUpdate
     */
    @JsonProperty("btnUpdate")
    public Button getBtnUpdate() {
        return btnUpdate;
    }

    /*
     * setbtnUpdate
     * @param btnUpdate btnUpdate
     */
    @JsonProperty("btnUpdate")
    public void setBtnUpdate(Button btnUpdate) {
        this.btnUpdate = btnUpdate;
    }

    /*
     * gettxtHdnShikibetsuCode
     * @return txtHdnShikibetsuCode
     */
    @JsonProperty("txtHdnShikibetsuCode")
    public RString getTxtHdnShikibetsuCode() {
        return txtHdnShikibetsuCode;
    }

    /*
     * settxtHdnShikibetsuCode
     * @param txtHdnShikibetsuCode txtHdnShikibetsuCode
     */
    @JsonProperty("txtHdnShikibetsuCode")
    public void setTxtHdnShikibetsuCode(RString txtHdnShikibetsuCode) {
        this.txtHdnShikibetsuCode = txtHdnShikibetsuCode;
    }

    // </editor-fold>
}
