package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.RyojikanSelectDialog;
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
 * RyojikanSelectDialog のクラスファイル 
 * 
 * @author 自動生成
 */
public class RyojikanSelectDialogDiv extends Panel implements IRyojikanSelectDialogDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgRyojikanSelect")
    private DataGrid<dgRyojikanSelect_Row> dgRyojikanSelect;
    @JsonProperty("btnCancel")
    private Button btnCancel;
    @JsonProperty("txtHdnSelectedCode")
    private RString txtHdnSelectedCode;
    @JsonProperty("txtHdnSelectedName")
    private RString txtHdnSelectedName;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgRyojikanSelect
     * @return dgRyojikanSelect
     */
    @JsonProperty("dgRyojikanSelect")
    public DataGrid<dgRyojikanSelect_Row> getDgRyojikanSelect() {
        return dgRyojikanSelect;
    }

    /*
     * setdgRyojikanSelect
     * @param dgRyojikanSelect dgRyojikanSelect
     */
    @JsonProperty("dgRyojikanSelect")
    public void setDgRyojikanSelect(DataGrid<dgRyojikanSelect_Row> dgRyojikanSelect) {
        this.dgRyojikanSelect = dgRyojikanSelect;
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

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
