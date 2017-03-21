package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SenkyokuTanmatsuInputDialog;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SenkyoShuruiSelect.ISenkyoShuruiSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SenkyoShuruiSelect.SenkyoShuruiSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SenkyokuCodeSelect.ISenkyokuCodeSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SenkyokuCodeSelect.SenkyokuCodeSelectDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SenkyokuTanmatsuInputDialog のクラスファイル 
 * 
 * @author 自動生成
 */
public class SenkyokuTanmatsuInputDialogDiv extends Panel implements ISenkyokuTanmatsuInputDialogDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdSenkyoShurui")
    private SenkyoShuruiSelectDiv ccdSenkyoShurui;
    @JsonProperty("ccdSenkyokuCode")
    private SenkyokuCodeSelectDiv ccdSenkyokuCode;
    @JsonProperty("btnAddRow")
    private Button btnAddRow;
    @JsonProperty("dgSenkyokuTanmatsuInput")
    private DataGrid<dgSenkyokuTanmatsuInput_Row> dgSenkyokuTanmatsuInput;
    @JsonProperty("btnUpdate")
    private Button btnUpdate;
    @JsonProperty("btnCancel")
    private Button btnCancel;
    @JsonProperty("HidTanmatsuNo")
    private RString HidTanmatsuNo;
    @JsonProperty("MotoDataList")
    private RString MotoDataList;

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
     * getccdSenkyokuCode
     * @return ccdSenkyokuCode
     */
    @JsonProperty("ccdSenkyokuCode")
    public ISenkyokuCodeSelectDiv getCcdSenkyokuCode() {
        return ccdSenkyokuCode;
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
     * getdgSenkyokuTanmatsuInput
     * @return dgSenkyokuTanmatsuInput
     */
    @JsonProperty("dgSenkyokuTanmatsuInput")
    public DataGrid<dgSenkyokuTanmatsuInput_Row> getDgSenkyokuTanmatsuInput() {
        return dgSenkyokuTanmatsuInput;
    }

    /*
     * setdgSenkyokuTanmatsuInput
     * @param dgSenkyokuTanmatsuInput dgSenkyokuTanmatsuInput
     */
    @JsonProperty("dgSenkyokuTanmatsuInput")
    public void setDgSenkyokuTanmatsuInput(DataGrid<dgSenkyokuTanmatsuInput_Row> dgSenkyokuTanmatsuInput) {
        this.dgSenkyokuTanmatsuInput = dgSenkyokuTanmatsuInput;
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
     * getHidTanmatsuNo
     * @return HidTanmatsuNo
     */
    @JsonProperty("HidTanmatsuNo")
    public RString getHidTanmatsuNo() {
        return HidTanmatsuNo;
    }

    /*
     * setHidTanmatsuNo
     * @param HidTanmatsuNo HidTanmatsuNo
     */
    @JsonProperty("HidTanmatsuNo")
    public void setHidTanmatsuNo(RString HidTanmatsuNo) {
        this.HidTanmatsuNo = HidTanmatsuNo;
    }

    /*
     * getMotoDataList
     * @return MotoDataList
     */
    @JsonProperty("MotoDataList")
    public RString getMotoDataList() {
        return MotoDataList;
    }

    /*
     * setMotoDataList
     * @param MotoDataList MotoDataList
     */
    @JsonProperty("MotoDataList")
    public void setMotoDataList(RString MotoDataList) {
        this.MotoDataList = MotoDataList;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
