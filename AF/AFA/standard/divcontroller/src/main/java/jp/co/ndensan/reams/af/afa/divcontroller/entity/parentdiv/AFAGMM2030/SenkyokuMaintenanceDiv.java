package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2030;
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
 * SenkyokuMaintenance のクラスファイル 
 * 
 * @author 自動生成
 */
public class SenkyokuMaintenanceDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SenkyokuSelect")
    private SenkyokuSelectDiv SenkyokuSelect;
    @JsonProperty("SenkyokuInput")
    private SenkyokuInputDiv SenkyokuInput;
    @JsonProperty("HiddenFlag")
    private RString HiddenFlag;
    @JsonProperty("SenkyokuTanmatsuInputDialogModel")
    private RString SenkyokuTanmatsuInputDialogModel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSenkyokuSelect
     * @return SenkyokuSelect
     */
    @JsonProperty("SenkyokuSelect")
    public SenkyokuSelectDiv getSenkyokuSelect() {
        return SenkyokuSelect;
    }

    /*
     * setSenkyokuSelect
     * @param SenkyokuSelect SenkyokuSelect
     */
    @JsonProperty("SenkyokuSelect")
    public void setSenkyokuSelect(SenkyokuSelectDiv SenkyokuSelect) {
        this.SenkyokuSelect = SenkyokuSelect;
    }

    /*
     * getSenkyokuInput
     * @return SenkyokuInput
     */
    @JsonProperty("SenkyokuInput")
    public SenkyokuInputDiv getSenkyokuInput() {
        return SenkyokuInput;
    }

    /*
     * setSenkyokuInput
     * @param SenkyokuInput SenkyokuInput
     */
    @JsonProperty("SenkyokuInput")
    public void setSenkyokuInput(SenkyokuInputDiv SenkyokuInput) {
        this.SenkyokuInput = SenkyokuInput;
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
     * getSenkyokuTanmatsuInputDialogModel
     * @return SenkyokuTanmatsuInputDialogModel
     */
    @JsonProperty("SenkyokuTanmatsuInputDialogModel")
    public RString getSenkyokuTanmatsuInputDialogModel() {
        return SenkyokuTanmatsuInputDialogModel;
    }

    /*
     * setSenkyokuTanmatsuInputDialogModel
     * @param SenkyokuTanmatsuInputDialogModel SenkyokuTanmatsuInputDialogModel
     */
    @JsonProperty("SenkyokuTanmatsuInputDialogModel")
    public void setSenkyokuTanmatsuInputDialogModel(RString SenkyokuTanmatsuInputDialogModel) {
        this.SenkyokuTanmatsuInputDialogModel = SenkyokuTanmatsuInputDialogModel;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnAdd() {
        return this.getSenkyokuSelect().getBtnAdd();
    }

    @JsonIgnore
    public void  setBtnAdd(Button btnAdd) {
        this.getSenkyokuSelect().setBtnAdd(btnAdd);
    }

    @JsonIgnore
    public DataGrid<dgSenkyokuList_Row> getDgSenkyokuList() {
        return this.getSenkyokuSelect().getDgSenkyokuList();
    }

    @JsonIgnore
    public void  setDgSenkyokuList(DataGrid<dgSenkyokuList_Row> dgSenkyokuList) {
        this.getSenkyokuSelect().setDgSenkyokuList(dgSenkyokuList);
    }

    @JsonIgnore
    public ISenkyoShuruiSelectDiv getCcdSenkyoShurui() {
        return this.getSenkyokuSelect().getCcdSenkyoShurui();
    }

    // </editor-fold>
}
