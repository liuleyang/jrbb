package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyojoSelectDialog;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;

/**
 * TohyojoSelectDialog のクラスファイル
 *
 * @reamsid_L AF-0710-020 liuyj
 */
public class TohyojoSelectDialogDiv extends Panel implements ITohyojoSelectDialogDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgTohyojoSelect")
    private DataGrid<dgTohyojoSelect_Row> dgTohyojoSelect;
    @JsonProperty("btnCancel")
    private Button btnCancel;
    @JsonProperty("txtHdnSelectedCode")
    private RString txtHdnSelectedCode;
    @JsonProperty("txtHdnSelectedName")
    private RString txtHdnSelectedName;
    @JsonProperty("txtHdnSelectedKanaName")
    private RString txtHdnSelectedKanaName;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgTohyojoSelect
     * @return dgTohyojoSelect
     */
    @JsonProperty("dgTohyojoSelect")
    public DataGrid<dgTohyojoSelect_Row> getDgTohyojoSelect() {
        return dgTohyojoSelect;
    }

    /*
     * setdgTohyojoSelect
     * @param dgTohyojoSelect dgTohyojoSelect
     */
    @JsonProperty("dgTohyojoSelect")
    public void setDgTohyojoSelect(DataGrid<dgTohyojoSelect_Row> dgTohyojoSelect) {
        this.dgTohyojoSelect = dgTohyojoSelect;
    }

    /*
     * getbtnCancel
     * @return btnCancel
     */
    @JsonProperty("btnCancel")
    public Button getBtnCancel() {
        return btnCancel;
    }

    /*
     * setbtnCancel
     * @param btnCancel btnCancel
     */
    @JsonProperty("btnCancel")
    public void setBtnCancel(Button btnCancel) {
        this.btnCancel = btnCancel;
    }

    /*
     * gettxtHdnSelectedCode
     * @return txtHdnSelectedCode
     */
    @JsonProperty("txtHdnSelectedCode")
    public RString getTxtHdnSelectedCode() {
        return txtHdnSelectedCode;
    }

    /*
     * settxtHdnSelectedCode
     * @param txtHdnSelectedCode txtHdnSelectedCode
     */
    @JsonProperty("txtHdnSelectedCode")
    public void setTxtHdnSelectedCode(RString txtHdnSelectedCode) {
        this.txtHdnSelectedCode = txtHdnSelectedCode;
    }

    /*
     * gettxtHdnSelectedName
     * @return txtHdnSelectedName
     */
    @JsonProperty("txtHdnSelectedName")
    public RString getTxtHdnSelectedName() {
        return txtHdnSelectedName;
    }

    /*
     * settxtHdnSelectedName
     * @param txtHdnSelectedName txtHdnSelectedName
     */
    @JsonProperty("txtHdnSelectedName")
    public void setTxtHdnSelectedName(RString txtHdnSelectedName) {
        this.txtHdnSelectedName = txtHdnSelectedName;
    }

    /*
     * gettxtHdnSelectedKanaName
     * @return txtHdnSelectedKanaName
     */
    @JsonProperty("txtHdnSelectedKanaName")
    public RString getTxtHdnSelectedKanaName() {
        return txtHdnSelectedKanaName;
    }

    /*
     * settxtHdnSelectedKanaName
     * @param txtHdnSelectedKanaName txtHdnSelectedKanaName
     */
    @JsonProperty("txtHdnSelectedKanaName")
    public void setTxtHdnSelectedKanaName(RString txtHdnSelectedKanaName) {
        this.txtHdnSelectedKanaName = txtHdnSelectedKanaName;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @JsonIgnore
    public TohyojoSelectDialogHandler getHandler() {
        return new TohyojoSelectDialogHandler(this);
    }
}
