package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.TohyokuSelectDialog;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SenkyoShuruiSelect.ISenkyoShuruiSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SenkyoShuruiSelect.SenkyoShuruiSelectDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TohyokuSelectDialog のクラスファイル 
 * 
 * @author 自動生成
 */
public class TohyokuSelectDialogDiv extends Panel implements ITohyokuSelectDialogDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdSenkyoShurui")
    private SenkyoShuruiSelectDiv ccdSenkyoShurui;
    @JsonProperty("dgTohyokuSelect")
    private DataGrid<dgTohyokuSelect_Row> dgTohyokuSelect;
    @JsonProperty("btnCancel")
    private Button btnCancel;
    @JsonProperty("txtHdnSelectedCode")
    private RString txtHdnSelectedCode;
    @JsonProperty("txtHdnSelectedName")
    private RString txtHdnSelectedName;
    @JsonProperty("tohyokuCodeSelectModel")
    private RString tohyokuCodeSelectModel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdSenkyoShurui
     * @return ccdSenkyoShurui
     */
    @JsonProperty("ccdSenkyoShurui")
    public ISenkyoShuruiSelectDiv getCcdSenkyoShurui() {
        return ccdSenkyoShurui;
    }

    /*
     * getdgTohyokuSelect
     * @return dgTohyokuSelect
     */
    @JsonProperty("dgTohyokuSelect")
    public DataGrid<dgTohyokuSelect_Row> getDgTohyokuSelect() {
        return dgTohyokuSelect;
    }

    /*
     * setdgTohyokuSelect
     * @param dgTohyokuSelect dgTohyokuSelect
     */
    @JsonProperty("dgTohyokuSelect")
    public void setDgTohyokuSelect(DataGrid<dgTohyokuSelect_Row> dgTohyokuSelect) {
        this.dgTohyokuSelect = dgTohyokuSelect;
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
     * gettohyokuCodeSelectModel
     * @return tohyokuCodeSelectModel
     */
    @JsonProperty("tohyokuCodeSelectModel")
    public RString getTohyokuCodeSelectModel() {
        return tohyokuCodeSelectModel;
    }

    /*
     * settohyokuCodeSelectModel
     * @param tohyokuCodeSelectModel tohyokuCodeSelectModel
     */
    @JsonProperty("tohyokuCodeSelectModel")
    public void setTohyokuCodeSelectModel(RString tohyokuCodeSelectModel) {
        this.tohyokuCodeSelectModel = tohyokuCodeSelectModel;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
