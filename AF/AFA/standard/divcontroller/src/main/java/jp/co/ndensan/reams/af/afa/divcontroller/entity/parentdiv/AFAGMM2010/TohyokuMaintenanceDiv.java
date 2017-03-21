package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SenkyoShuruiSelect.ISenkyoShuruiSelectDiv;
import jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.SenkyoShuruiSelect.SenkyoShuruiSelectDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TohyokuMaintenance のクラスファイル 
 * 
 * @author 自動生成
 */
public class TohyokuMaintenanceDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TohyokuSelect")
    private TohyokuSelectDiv TohyokuSelect;
    @JsonProperty("TohyokuInput")
    private TohyokuInputDiv TohyokuInput;
    @JsonProperty("HiddenFlag")
    private RString HiddenFlag;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getTohyokuSelect
     * @return TohyokuSelect
     */
    @JsonProperty("TohyokuSelect")
    public TohyokuSelectDiv getTohyokuSelect() {
        return TohyokuSelect;
    }

    /*
     * setTohyokuSelect
     * @param TohyokuSelect TohyokuSelect
     */
    @JsonProperty("TohyokuSelect")
    public void setTohyokuSelect(TohyokuSelectDiv TohyokuSelect) {
        this.TohyokuSelect = TohyokuSelect;
    }

    /*
     * getTohyokuInput
     * @return TohyokuInput
     */
    @JsonProperty("TohyokuInput")
    public TohyokuInputDiv getTohyokuInput() {
        return TohyokuInput;
    }

    /*
     * setTohyokuInput
     * @param TohyokuInput TohyokuInput
     */
    @JsonProperty("TohyokuInput")
    public void setTohyokuInput(TohyokuInputDiv TohyokuInput) {
        this.TohyokuInput = TohyokuInput;
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
        return this.getTohyokuSelect().getBtnAdd();
    }

    @JsonIgnore
    public void  setBtnAdd(Button btnAdd) {
        this.getTohyokuSelect().setBtnAdd(btnAdd);
    }

    @JsonIgnore
    public DataGrid<dgTohyokuList_Row> getDgTohyokuList() {
        return this.getTohyokuSelect().getDgTohyokuList();
    }

    @JsonIgnore
    public void  setDgTohyokuList(DataGrid<dgTohyokuList_Row> dgTohyokuList) {
        this.getTohyokuSelect().setDgTohyokuList(dgTohyokuList);
    }

    @JsonIgnore
    public ISenkyoShuruiSelectDiv getCcdSenkyoShurui() {
        return this.getTohyokuSelect().getCcdSenkyoShurui();
    }

    @JsonIgnore
    public TextBoxCode getTxtCode() {
        return this.getTohyokuInput().getTxtCode();
    }

    @JsonIgnore
    public void  setTxtCode(TextBoxCode txtCode) {
        this.getTohyokuInput().setTxtCode(txtCode);
    }

    @JsonIgnore
    public TextBox getTxtName() {
        return this.getTohyokuInput().getTxtName();
    }

    @JsonIgnore
    public void  setTxtName(TextBox txtName) {
        this.getTohyokuInput().setTxtName(txtName);
    }

    @JsonIgnore
    public TextBoxKana getTxtKanaName() {
        return this.getTohyokuInput().getTxtKanaName();
    }

    @JsonIgnore
    public void  setTxtKanaName(TextBoxKana txtKanaName) {
        this.getTohyokuInput().setTxtKanaName(txtKanaName);
    }

    @JsonIgnore
    public TextBoxNum getTxtHyojiJun() {
        return this.getTohyokuInput().getTxtHyojiJun();
    }

    @JsonIgnore
    public void  setTxtHyojiJun(TextBoxNum txtHyojiJun) {
        this.getTohyokuInput().setTxtHyojiJun(txtHyojiJun);
    }

    @JsonIgnore
    public Button getBtnAddNew() {
        return this.getTohyokuInput().getBtnAddNew();
    }

    @JsonIgnore
    public void  setBtnAddNew(Button btnAddNew) {
        this.getTohyokuInput().setBtnAddNew(btnAddNew);
    }

    @JsonIgnore
    public Button getBtnStop() {
        return this.getTohyokuInput().getBtnStop();
    }

    @JsonIgnore
    public void  setBtnStop(Button btnStop) {
        this.getTohyokuInput().setBtnStop(btnStop);
    }

    // </editor-fold>
}
