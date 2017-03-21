package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SenkyokuSelectDialog;
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
 * SenkyokuSelectDialog のクラスファイル 
 * 
 * @author 自動生成
 */
public class SenkyokuSelectDialogDiv extends Panel implements ISenkyokuSelectDialogDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdSenkyoShurui")
    private SenkyoShuruiSelectDiv ccdSenkyoShurui;
    @JsonProperty("dgSenkyokuSelect")
    private DataGrid<dgSenkyokuSelect_Row> dgSenkyokuSelect;
    @JsonProperty("btnCancel")
    private Button btnCancel;
    @JsonProperty("SenkyokuSelectDialogModel")
    private RString SenkyokuSelectDialogModel;
    @JsonProperty("txtHdnSelectedCode")
    private RString txtHdnSelectedCode;
    @JsonProperty("txtHdnSelectedName")
    private RString txtHdnSelectedName;
    @JsonProperty("txtHdnSelectedSenkyoShurui")
    private RString txtHdnSelectedSenkyoShurui;

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
     * getdgSenkyokuSelect
     * @return dgSenkyokuSelect
     */
    @JsonProperty("dgSenkyokuSelect")
    public DataGrid<dgSenkyokuSelect_Row> getDgSenkyokuSelect() {
        return dgSenkyokuSelect;
    }

    /*
     * setdgSenkyokuSelect
     * @param dgSenkyokuSelect dgSenkyokuSelect
     */
    @JsonProperty("dgSenkyokuSelect")
    public void setDgSenkyokuSelect(DataGrid<dgSenkyokuSelect_Row> dgSenkyokuSelect) {
        this.dgSenkyokuSelect = dgSenkyokuSelect;
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
     * getSenkyokuSelectDialogModel
     * @return SenkyokuSelectDialogModel
     */
    @JsonProperty("SenkyokuSelectDialogModel")
    public RString getSenkyokuSelectDialogModel() {
        return SenkyokuSelectDialogModel;
    }

    /*
     * setSenkyokuSelectDialogModel
     * @param SenkyokuSelectDialogModel SenkyokuSelectDialogModel
     */
    @JsonProperty("SenkyokuSelectDialogModel")
    public void setSenkyokuSelectDialogModel(RString SenkyokuSelectDialogModel) {
        this.SenkyokuSelectDialogModel = SenkyokuSelectDialogModel;
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
     * gettxtHdnSelectedSenkyoShurui
     * @return txtHdnSelectedSenkyoShurui
     */
    @JsonProperty("txtHdnSelectedSenkyoShurui")
    public RString getTxtHdnSelectedSenkyoShurui() {
        return txtHdnSelectedSenkyoShurui;
    }

    /*
     * settxtHdnSelectedSenkyoShurui
     * @param txtHdnSelectedSenkyoShurui txtHdnSelectedSenkyoShurui
     */
    @JsonProperty("txtHdnSelectedSenkyoShurui")
    public void setTxtHdnSelectedSenkyoShurui(RString txtHdnSelectedSenkyoShurui) {
        this.txtHdnSelectedSenkyoShurui = txtHdnSelectedSenkyoShurui;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
