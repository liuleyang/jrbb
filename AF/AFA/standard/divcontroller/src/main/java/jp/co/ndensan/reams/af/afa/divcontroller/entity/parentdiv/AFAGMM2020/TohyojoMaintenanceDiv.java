package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2020;
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
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * TohyojoMaintenance のクラスファイル 
 * 
 * @author 自動生成
 */
public class TohyojoMaintenanceDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TohyojoSelect")
    private TohyojoSelectDiv TohyojoSelect;
    @JsonProperty("TohyojoInput")
    private TohyojoInputDiv TohyojoInput;
    @JsonProperty("HiddenFlag")
    private RString HiddenFlag;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getTohyojoSelect
     * @return TohyojoSelect
     */
    @JsonProperty("TohyojoSelect")
    public TohyojoSelectDiv getTohyojoSelect() {
        return TohyojoSelect;
    }

    /*
     * setTohyojoSelect
     * @param TohyojoSelect TohyojoSelect
     */
    @JsonProperty("TohyojoSelect")
    public void setTohyojoSelect(TohyojoSelectDiv TohyojoSelect) {
        this.TohyojoSelect = TohyojoSelect;
    }

    /*
     * getTohyojoInput
     * @return TohyojoInput
     */
    @JsonProperty("TohyojoInput")
    public TohyojoInputDiv getTohyojoInput() {
        return TohyojoInput;
    }

    /*
     * setTohyojoInput
     * @param TohyojoInput TohyojoInput
     */
    @JsonProperty("TohyojoInput")
    public void setTohyojoInput(TohyojoInputDiv TohyojoInput) {
        this.TohyojoInput = TohyojoInput;
    }

    /*
     * getHiddenFlag
     * @return HiddenFlag
     */
    @JsonProperty("HiddenFlag")
    public RString getHiddenFlag() {
        return HiddenFlag;
    }

    /*
     * setHiddenFlag
     * @param HiddenFlag HiddenFlag
     */
    @JsonProperty("HiddenFlag")
    public void setHiddenFlag(RString HiddenFlag) {
        this.HiddenFlag = HiddenFlag;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnAdd() {
        return this.getTohyojoSelect().getBtnAdd();
    }

    @JsonIgnore
    public void  setBtnAdd(Button btnAdd) {
        this.getTohyojoSelect().setBtnAdd(btnAdd);
    }

    @JsonIgnore
    public DataGrid<dgTohyojoList_Row> getDgTohyojoList() {
        return this.getTohyojoSelect().getDgTohyojoList();
    }

    @JsonIgnore
    public void  setDgTohyojoList(DataGrid<dgTohyojoList_Row> dgTohyojoList) {
        this.getTohyojoSelect().setDgTohyojoList(dgTohyojoList);
    }

    @JsonIgnore
    public TextBoxCode getTxtCode() {
        return this.getTohyojoInput().getTxtCode();
    }

    @JsonIgnore
    public void  setTxtCode(TextBoxCode txtCode) {
        this.getTohyojoInput().setTxtCode(txtCode);
    }

    @JsonIgnore
    public TextBox getTxtName() {
        return this.getTohyojoInput().getTxtName();
    }

    @JsonIgnore
    public void  setTxtName(TextBox txtName) {
        this.getTohyojoInput().setTxtName(txtName);
    }

    @JsonIgnore
    public TextBoxKana getTxtKanaName() {
        return this.getTohyojoInput().getTxtKanaName();
    }

    @JsonIgnore
    public void  setTxtKanaName(TextBoxKana txtKanaName) {
        this.getTohyojoInput().setTxtKanaName(txtKanaName);
    }

    @JsonIgnore
    public TextBoxTimeRange getTxtTohyoTimeRange() {
        return this.getTohyojoInput().getTxtTohyoTimeRange();
    }

    @JsonIgnore
    public void  setTxtTohyoTimeRange(TextBoxTimeRange txtTohyoTimeRange) {
        this.getTohyojoInput().setTxtTohyoTimeRange(txtTohyoTimeRange);
    }

    @JsonIgnore
    public CheckBoxList getChkZaigaiTohyoKanoFlag() {
        return this.getTohyojoInput().getChkZaigaiTohyoKanoFlag();
    }

    @JsonIgnore
    public void  setChkZaigaiTohyoKanoFlag(CheckBoxList chkZaigaiTohyoKanoFlag) {
        this.getTohyojoInput().setChkZaigaiTohyoKanoFlag(chkZaigaiTohyoKanoFlag);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtYubinNo() {
        return this.getTohyojoInput().getTxtYubinNo();
    }

    @JsonIgnore
    public void  setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.getTohyojoInput().setTxtYubinNo(txtYubinNo);
    }

    @JsonIgnore
    public TextBoxJusho getTxtJusho() {
        return this.getTohyojoInput().getTxtJusho();
    }

    @JsonIgnore
    public void  setTxtJusho(TextBoxJusho txtJusho) {
        this.getTohyojoInput().setTxtJusho(txtJusho);
    }

    @JsonIgnore
    public TextBoxAtenaMeisho getTxtAtenaMeisho() {
        return this.getTohyojoInput().getTxtAtenaMeisho();
    }

    @JsonIgnore
    public void  setTxtAtenaMeisho(TextBoxAtenaMeisho txtAtenaMeisho) {
        this.getTohyojoInput().setTxtAtenaMeisho(txtAtenaMeisho);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtTelNo() {
        return this.getTohyojoInput().getTxtTelNo();
    }

    @JsonIgnore
    public void  setTxtTelNo(TextBoxTelNo txtTelNo) {
        this.getTohyojoInput().setTxtTelNo(txtTelNo);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtFaxNo() {
        return this.getTohyojoInput().getTxtFaxNo();
    }

    @JsonIgnore
    public void  setTxtFaxNo(TextBoxTelNo txtFaxNo) {
        this.getTohyojoInput().setTxtFaxNo(txtFaxNo);
    }

    @JsonIgnore
    public TextBox getTxtMapFileName() {
        return this.getTohyojoInput().getTxtMapFileName();
    }

    @JsonIgnore
    public void  setTxtMapFileName(TextBox txtMapFileName) {
        this.getTohyojoInput().setTxtMapFileName(txtMapFileName);
    }

    @JsonIgnore
    public StaticImage getImgChizu() {
        return this.getTohyojoInput().getImgChizu();
    }

    @JsonIgnore
    public void  setImgChizu(StaticImage imgChizu) {
        this.getTohyojoInput().setImgChizu(imgChizu);
    }

    @JsonIgnore
    public Button getBtnAddNew() {
        return this.getTohyojoInput().getBtnAddNew();
    }

    @JsonIgnore
    public void  setBtnAddNew(Button btnAddNew) {
        this.getTohyojoInput().setBtnAddNew(btnAddNew);
    }

    @JsonIgnore
    public Button getBtnStop() {
        return this.getTohyojoInput().getBtnStop();
    }

    @JsonIgnore
    public void  setBtnStop(Button btnStop) {
        this.getTohyojoInput().setBtnStop(btnStop);
    }

    // </editor-fold>
}
