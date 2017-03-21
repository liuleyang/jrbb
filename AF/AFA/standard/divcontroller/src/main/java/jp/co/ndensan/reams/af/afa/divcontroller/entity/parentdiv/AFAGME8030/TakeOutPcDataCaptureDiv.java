package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME8030;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TakeOutPcDataCapture のクラスファイル 
 * 
 * @author 自動生成
 */
public class TakeOutPcDataCaptureDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TakeOutPcDataCaptureParam")
    private TakeOutPcDataCaptureParamDiv TakeOutPcDataCaptureParam;
    @JsonProperty("hdnUpLoad")
    private RString hdnUpLoad;
    @JsonProperty("hdnTohyoYMD")
    private RString hdnTohyoYMD;
    @JsonProperty("hdnTohyokuCode")
    private RString hdnTohyokuCode;
    @JsonProperty("hdnDataImportKubunCode")
    private RString hdnDataImportKubunCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getTakeOutPcDataCaptureParam
     * @return TakeOutPcDataCaptureParam
     */
    @JsonProperty("TakeOutPcDataCaptureParam")
    public TakeOutPcDataCaptureParamDiv getTakeOutPcDataCaptureParam() {
        return TakeOutPcDataCaptureParam;
    }

    /*
     * setTakeOutPcDataCaptureParam
     * @param TakeOutPcDataCaptureParam TakeOutPcDataCaptureParam
     */
    @JsonProperty("TakeOutPcDataCaptureParam")
    public void setTakeOutPcDataCaptureParam(TakeOutPcDataCaptureParamDiv TakeOutPcDataCaptureParam) {
        this.TakeOutPcDataCaptureParam = TakeOutPcDataCaptureParam;
    }

    /*
     * gethdnUpLoad
     * @return hdnUpLoad
     */
    @JsonProperty("hdnUpLoad")
    public RString getHdnUpLoad() {
        return hdnUpLoad;
    }

    /*
     * sethdnUpLoad
     * @param hdnUpLoad hdnUpLoad
     */
    @JsonProperty("hdnUpLoad")
    public void setHdnUpLoad(RString hdnUpLoad) {
        this.hdnUpLoad = hdnUpLoad;
    }

    /*
     * gethdnTohyoYMD
     * @return hdnTohyoYMD
     */
    @JsonProperty("hdnTohyoYMD")
    public RString getHdnTohyoYMD() {
        return hdnTohyoYMD;
    }

    /*
     * sethdnTohyoYMD
     * @param hdnTohyoYMD hdnTohyoYMD
     */
    @JsonProperty("hdnTohyoYMD")
    public void setHdnTohyoYMD(RString hdnTohyoYMD) {
        this.hdnTohyoYMD = hdnTohyoYMD;
    }

    /*
     * gethdnTohyokuCode
     * @return hdnTohyokuCode
     */
    @JsonProperty("hdnTohyokuCode")
    public RString getHdnTohyokuCode() {
        return hdnTohyokuCode;
    }

    /*
     * sethdnTohyokuCode
     * @param hdnTohyokuCode hdnTohyokuCode
     */
    @JsonProperty("hdnTohyokuCode")
    public void setHdnTohyokuCode(RString hdnTohyokuCode) {
        this.hdnTohyokuCode = hdnTohyokuCode;
    }

    /*
     * gethdnDataImportKubunCode
     * @return hdnDataImportKubunCode
     */
    @JsonProperty("hdnDataImportKubunCode")
    public RString getHdnDataImportKubunCode() {
        return hdnDataImportKubunCode;
    }

    /*
     * sethdnDataImportKubunCode
     * @param hdnDataImportKubunCode hdnDataImportKubunCode
     */
    @JsonProperty("hdnDataImportKubunCode")
    public void setHdnDataImportKubunCode(RString hdnDataImportKubunCode) {
        this.hdnDataImportKubunCode = hdnDataImportKubunCode;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblMsgDataImport1() {
        return this.getTakeOutPcDataCaptureParam().getLblMsgDataImport1();
    }

    @JsonIgnore
    public void  setLblMsgDataImport1(Label lblMsgDataImport1) {
        this.getTakeOutPcDataCaptureParam().setLblMsgDataImport1(lblMsgDataImport1);
    }

    @JsonIgnore
    public DropDownList getDdlTohyoYmd() {
        return this.getTakeOutPcDataCaptureParam().getDdlTohyoYmd();
    }

    @JsonIgnore
    public void  setDdlTohyoYmd(DropDownList ddlTohyoYmd) {
        this.getTakeOutPcDataCaptureParam().setDdlTohyoYmd(ddlTohyoYmd);
    }

    @JsonIgnore
    public DataGrid<dgShohonSenkyo_Row> getDgShohonSenkyo() {
        return this.getTakeOutPcDataCaptureParam().getDgShohonSenkyo();
    }

    @JsonIgnore
    public void  setDgShohonSenkyo(DataGrid<dgShohonSenkyo_Row> dgShohonSenkyo) {
        this.getTakeOutPcDataCaptureParam().setDgShohonSenkyo(dgShohonSenkyo);
    }

    @JsonIgnore
    public Label getLblMsgDataImport2() {
        return this.getTakeOutPcDataCaptureParam().getLblMsgDataImport2();
    }

    @JsonIgnore
    public void  setLblMsgDataImport2(Label lblMsgDataImport2) {
        this.getTakeOutPcDataCaptureParam().setLblMsgDataImport2(lblMsgDataImport2);
    }

    @JsonIgnore
    public DataGrid<dgResult_Row> getDgResult() {
        return this.getTakeOutPcDataCaptureParam().getDgResult();
    }

    @JsonIgnore
    public void  setDgResult(DataGrid<dgResult_Row> dgResult) {
        this.getTakeOutPcDataCaptureParam().setDgResult(dgResult);
    }

    @JsonIgnore
    public Label getLblImportFile() {
        return this.getTakeOutPcDataCaptureParam().getLblImportFile();
    }

    @JsonIgnore
    public void  setLblImportFile(Label lblImportFile) {
        this.getTakeOutPcDataCaptureParam().setLblImportFile(lblImportFile);
    }

    @JsonIgnore
    public UploadPanel getUplSelectImportFile() {
        return this.getTakeOutPcDataCaptureParam().getUplSelectImportFile();
    }

    @JsonIgnore
    public void  setUplSelectImportFile(UploadPanel uplSelectImportFile) {
        this.getTakeOutPcDataCaptureParam().setUplSelectImportFile(uplSelectImportFile);
    }

    @JsonIgnore
    public Label getHiddenBatchExecuteFlg() {
        return this.getTakeOutPcDataCaptureParam().getHiddenBatchExecuteFlg();
    }

    @JsonIgnore
    public void  setHiddenBatchExecuteFlg(Label hiddenBatchExecuteFlg) {
        this.getTakeOutPcDataCaptureParam().setHiddenBatchExecuteFlg(hiddenBatchExecuteFlg);
    }

    @JsonIgnore
    public Button getBtnFileUploadAndExecute() {
        return this.getTakeOutPcDataCaptureParam().getBtnFileUploadAndExecute();
    }

    @JsonIgnore
    public void  setBtnFileUploadAndExecute(Button btnFileUploadAndExecute) {
        this.getTakeOutPcDataCaptureParam().setBtnFileUploadAndExecute(btnFileUploadAndExecute);
    }

    // </editor-fold>
}
