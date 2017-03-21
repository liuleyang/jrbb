package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME8010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * TakeOutPcDataCreateParam のクラスファイル 
 * 
 * @author 自動生成
 */
public class TakeOutPcDataCreateParamDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblDownLoadMessage")
    private Label lblDownLoadMessage;
    @JsonProperty("linLine1")
    private HorizontalLine linLine1;
    @JsonProperty("lblMsgDataCreate")
    private Label lblMsgDataCreate;
    @JsonProperty("btnUsbSystemDownLoad")
    private ButtonDownLoad btnUsbSystemDownLoad;
    @JsonProperty("ddlTohyoYmd")
    private DropDownList ddlTohyoYmd;
    @JsonProperty("dgShohonSenkyo")
    private DataGrid<dgShohonSenkyo_Row> dgShohonSenkyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblDownLoadMessage
     * @return lblDownLoadMessage
     */
    @JsonProperty("lblDownLoadMessage")
    public Label getLblDownLoadMessage() {
        return lblDownLoadMessage;
    }

    /*
     * setlblDownLoadMessage
     * @param lblDownLoadMessage lblDownLoadMessage
     */
    @JsonProperty("lblDownLoadMessage")
    public void setLblDownLoadMessage(Label lblDownLoadMessage) {
        this.lblDownLoadMessage = lblDownLoadMessage;
    }

    /*
     * getlinLine1
     * @return linLine1
     */
    @JsonProperty("linLine1")
    public HorizontalLine getLinLine1() {
        return linLine1;
    }

    /*
     * setlinLine1
     * @param linLine1 linLine1
     */
    @JsonProperty("linLine1")
    public void setLinLine1(HorizontalLine linLine1) {
        this.linLine1 = linLine1;
    }

    /*
     * getlblMsgDataCreate
     * @return lblMsgDataCreate
     */
    @JsonProperty("lblMsgDataCreate")
    public Label getLblMsgDataCreate() {
        return lblMsgDataCreate;
    }

    /*
     * setlblMsgDataCreate
     * @param lblMsgDataCreate lblMsgDataCreate
     */
    @JsonProperty("lblMsgDataCreate")
    public void setLblMsgDataCreate(Label lblMsgDataCreate) {
        this.lblMsgDataCreate = lblMsgDataCreate;
    }

    /*
     * getbtnUsbSystemDownLoad
     * @return btnUsbSystemDownLoad
     */
    @JsonProperty("btnUsbSystemDownLoad")
    public ButtonDownLoad getBtnUsbSystemDownLoad() {
        return btnUsbSystemDownLoad;
    }

    /*
     * setbtnUsbSystemDownLoad
     * @param btnUsbSystemDownLoad btnUsbSystemDownLoad
     */
    @JsonProperty("btnUsbSystemDownLoad")
    public void setBtnUsbSystemDownLoad(ButtonDownLoad btnUsbSystemDownLoad) {
        this.btnUsbSystemDownLoad = btnUsbSystemDownLoad;
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

    // </editor-fold>
}
