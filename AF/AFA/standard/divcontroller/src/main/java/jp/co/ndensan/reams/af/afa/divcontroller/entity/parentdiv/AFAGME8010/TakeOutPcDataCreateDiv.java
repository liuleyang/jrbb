package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGME8010;
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
 * TakeOutPcDataCreate のクラスファイル 
 * 
 * @author 自動生成
 */
public class TakeOutPcDataCreateDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TakeOutPcDataCreateParam")
    private TakeOutPcDataCreateParamDiv TakeOutPcDataCreateParam;
    @JsonProperty("dataCreatFlg")
    private RString dataCreatFlg;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getTakeOutPcDataCreateParam
     * @return TakeOutPcDataCreateParam
     */
    @JsonProperty("TakeOutPcDataCreateParam")
    public TakeOutPcDataCreateParamDiv getTakeOutPcDataCreateParam() {
        return TakeOutPcDataCreateParam;
    }

    /*
     * setTakeOutPcDataCreateParam
     * @param TakeOutPcDataCreateParam TakeOutPcDataCreateParam
     */
    @JsonProperty("TakeOutPcDataCreateParam")
    public void setTakeOutPcDataCreateParam(TakeOutPcDataCreateParamDiv TakeOutPcDataCreateParam) {
        this.TakeOutPcDataCreateParam = TakeOutPcDataCreateParam;
    }

    /*
     * getdataCreatFlg
     * @return dataCreatFlg
     */
    @JsonProperty("dataCreatFlg")
    public RString getDataCreatFlg() {
        return dataCreatFlg;
    }

    /*
     * setdataCreatFlg
     * @param dataCreatFlg dataCreatFlg
     */
    @JsonProperty("dataCreatFlg")
    public void setDataCreatFlg(RString dataCreatFlg) {
        this.dataCreatFlg = dataCreatFlg;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblDownLoadMessage() {
        return this.getTakeOutPcDataCreateParam().getLblDownLoadMessage();
    }

    @JsonIgnore
    public void  setLblDownLoadMessage(Label lblDownLoadMessage) {
        this.getTakeOutPcDataCreateParam().setLblDownLoadMessage(lblDownLoadMessage);
    }

    @JsonIgnore
    public HorizontalLine getLinLine1() {
        return this.getTakeOutPcDataCreateParam().getLinLine1();
    }

    @JsonIgnore
    public void  setLinLine1(HorizontalLine linLine1) {
        this.getTakeOutPcDataCreateParam().setLinLine1(linLine1);
    }

    @JsonIgnore
    public Label getLblMsgDataCreate() {
        return this.getTakeOutPcDataCreateParam().getLblMsgDataCreate();
    }

    @JsonIgnore
    public void  setLblMsgDataCreate(Label lblMsgDataCreate) {
        this.getTakeOutPcDataCreateParam().setLblMsgDataCreate(lblMsgDataCreate);
    }

    @JsonIgnore
    public ButtonDownLoad getBtnUsbSystemDownLoad() {
        return this.getTakeOutPcDataCreateParam().getBtnUsbSystemDownLoad();
    }

    @JsonIgnore
    public void  setBtnUsbSystemDownLoad(ButtonDownLoad btnUsbSystemDownLoad) {
        this.getTakeOutPcDataCreateParam().setBtnUsbSystemDownLoad(btnUsbSystemDownLoad);
    }

    @JsonIgnore
    public DropDownList getDdlTohyoYmd() {
        return this.getTakeOutPcDataCreateParam().getDdlTohyoYmd();
    }

    @JsonIgnore
    public void  setDdlTohyoYmd(DropDownList ddlTohyoYmd) {
        this.getTakeOutPcDataCreateParam().setDdlTohyoYmd(ddlTohyoYmd);
    }

    @JsonIgnore
    public DataGrid<dgShohonSenkyo_Row> getDgShohonSenkyo() {
        return this.getTakeOutPcDataCreateParam().getDgShohonSenkyo();
    }

    @JsonIgnore
    public void  setDgShohonSenkyo(DataGrid<dgShohonSenkyo_Row> dgShohonSenkyo) {
        this.getTakeOutPcDataCreateParam().setDgShohonSenkyo(dgShohonSenkyo);
    }

    // </editor-fold>
}
