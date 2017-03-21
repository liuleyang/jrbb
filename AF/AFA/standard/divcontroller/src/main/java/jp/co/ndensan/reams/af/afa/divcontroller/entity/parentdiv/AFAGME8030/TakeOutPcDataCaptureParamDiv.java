package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME8030;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * TakeOutPcDataCaptureParam のクラスファイル 
 * 
 * @author 自動生成
 */
public class TakeOutPcDataCaptureParamDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblMsgDataImport1")
    private Label lblMsgDataImport1;
    @JsonProperty("ddlTohyoYmd")
    private DropDownList ddlTohyoYmd;
    @JsonProperty("dgShohonSenkyo")
    private DataGrid<dgShohonSenkyo_Row> dgShohonSenkyo;
    @JsonProperty("lblMsgDataImport2")
    private Label lblMsgDataImport2;
    @JsonProperty("dgResult")
    private DataGrid<dgResult_Row> dgResult;
    @JsonProperty("lblImportFile")
    private Label lblImportFile;
    @JsonProperty("uplSelectImportFile")
    private UploadPanel uplSelectImportFile;
    @JsonProperty("hiddenBatchExecuteFlg")
    private Label hiddenBatchExecuteFlg;
    @JsonProperty("btnFileUploadAndExecute")
    private Button btnFileUploadAndExecute;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblMsgDataImport1
     * @return lblMsgDataImport1
     */
    @JsonProperty("lblMsgDataImport1")
    public Label getLblMsgDataImport1() {
        return lblMsgDataImport1;
    }

    /*
     * setlblMsgDataImport1
     * @param lblMsgDataImport1 lblMsgDataImport1
     */
    @JsonProperty("lblMsgDataImport1")
    public void setLblMsgDataImport1(Label lblMsgDataImport1) {
        this.lblMsgDataImport1 = lblMsgDataImport1;
    }

    /*
     * getddlTohyoYmd
     * @return ddlTohyoYmd
     */
    @JsonProperty("ddlTohyoYmd")
    public DropDownList getDdlTohyoYmd() {
        return ddlTohyoYmd;
    }

    /*
     * setddlTohyoYmd
     * @param ddlTohyoYmd ddlTohyoYmd
     */
    @JsonProperty("ddlTohyoYmd")
    public void setDdlTohyoYmd(DropDownList ddlTohyoYmd) {
        this.ddlTohyoYmd = ddlTohyoYmd;
    }

    /*
     * getdgShohonSenkyo
     * @return dgShohonSenkyo
     */
    @JsonProperty("dgShohonSenkyo")
    public DataGrid<dgShohonSenkyo_Row> getDgShohonSenkyo() {
        return dgShohonSenkyo;
    }

    /*
     * setdgShohonSenkyo
     * @param dgShohonSenkyo dgShohonSenkyo
     */
    @JsonProperty("dgShohonSenkyo")
    public void setDgShohonSenkyo(DataGrid<dgShohonSenkyo_Row> dgShohonSenkyo) {
        this.dgShohonSenkyo = dgShohonSenkyo;
    }

    /*
     * getlblMsgDataImport2
     * @return lblMsgDataImport2
     */
    @JsonProperty("lblMsgDataImport2")
    public Label getLblMsgDataImport2() {
        return lblMsgDataImport2;
    }

    /*
     * setlblMsgDataImport2
     * @param lblMsgDataImport2 lblMsgDataImport2
     */
    @JsonProperty("lblMsgDataImport2")
    public void setLblMsgDataImport2(Label lblMsgDataImport2) {
        this.lblMsgDataImport2 = lblMsgDataImport2;
    }

    /*
     * getdgResult
     * @return dgResult
     */
    @JsonProperty("dgResult")
    public DataGrid<dgResult_Row> getDgResult() {
        return dgResult;
    }

    /*
     * setdgResult
     * @param dgResult dgResult
     */
    @JsonProperty("dgResult")
    public void setDgResult(DataGrid<dgResult_Row> dgResult) {
        this.dgResult = dgResult;
    }

    /*
     * getlblImportFile
     * @return lblImportFile
     */
    @JsonProperty("lblImportFile")
    public Label getLblImportFile() {
        return lblImportFile;
    }

    /*
     * setlblImportFile
     * @param lblImportFile lblImportFile
     */
    @JsonProperty("lblImportFile")
    public void setLblImportFile(Label lblImportFile) {
        this.lblImportFile = lblImportFile;
    }

    /*
     * getuplSelectImportFile
     * @return uplSelectImportFile
     */
    @JsonProperty("uplSelectImportFile")
    public UploadPanel getUplSelectImportFile() {
        return uplSelectImportFile;
    }

    /*
     * setuplSelectImportFile
     * @param uplSelectImportFile uplSelectImportFile
     */
    @JsonProperty("uplSelectImportFile")
    public void setUplSelectImportFile(UploadPanel uplSelectImportFile) {
        this.uplSelectImportFile = uplSelectImportFile;
    }

    /*
     * gethiddenBatchExecuteFlg
     * @return hiddenBatchExecuteFlg
     */
    @JsonProperty("hiddenBatchExecuteFlg")
    public Label getHiddenBatchExecuteFlg() {
        return hiddenBatchExecuteFlg;
    }

    /*
     * sethiddenBatchExecuteFlg
     * @param hiddenBatchExecuteFlg hiddenBatchExecuteFlg
     */
    @JsonProperty("hiddenBatchExecuteFlg")
    public void setHiddenBatchExecuteFlg(Label hiddenBatchExecuteFlg) {
        this.hiddenBatchExecuteFlg = hiddenBatchExecuteFlg;
    }

    /*
     * getbtnFileUploadAndExecute
     * @return btnFileUploadAndExecute
     */
    @JsonProperty("btnFileUploadAndExecute")
    public Button getBtnFileUploadAndExecute() {
        return btnFileUploadAndExecute;
    }

    /*
     * setbtnFileUploadAndExecute
     * @param btnFileUploadAndExecute btnFileUploadAndExecute
     */
    @JsonProperty("btnFileUploadAndExecute")
    public void setBtnFileUploadAndExecute(Button btnFileUploadAndExecute) {
        this.btnFileUploadAndExecute = btnFileUploadAndExecute;
    }

    // </editor-fold>
}
