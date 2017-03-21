package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2080;
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
 * RyojikanMaintenance のクラスファイル 
 * 
 * @author 自動生成
 */
public class RyojikanMaintenanceDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("RyojikanSelect")
    private RyojikanSelectDiv RyojikanSelect;
    @JsonProperty("RyojikanInput")
    private RyojikanInputDiv RyojikanInput;
    @JsonProperty("HiddenFlag")
    private RString HiddenFlag;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getRyojikanSelect
     * @return RyojikanSelect
     */
    @JsonProperty("RyojikanSelect")
    public RyojikanSelectDiv getRyojikanSelect() {
        return RyojikanSelect;
    }

    /*
     * setRyojikanSelect
     * @param RyojikanSelect RyojikanSelect
     */
    @JsonProperty("RyojikanSelect")
    public void setRyojikanSelect(RyojikanSelectDiv RyojikanSelect) {
        this.RyojikanSelect = RyojikanSelect;
    }

    /*
     * getRyojikanInput
     * @return RyojikanInput
     */
    @JsonProperty("RyojikanInput")
    public RyojikanInputDiv getRyojikanInput() {
        return RyojikanInput;
    }

    /*
     * setRyojikanInput
     * @param RyojikanInput RyojikanInput
     */
    @JsonProperty("RyojikanInput")
    public void setRyojikanInput(RyojikanInputDiv RyojikanInput) {
        this.RyojikanInput = RyojikanInput;
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
        return this.getRyojikanSelect().getBtnAdd();
    }

    @JsonIgnore
    public void  setBtnAdd(Button btnAdd) {
        this.getRyojikanSelect().setBtnAdd(btnAdd);
    }

    @JsonIgnore
    public DataGrid<dgRyojikanList_Row> getDgRyojikanList() {
        return this.getRyojikanSelect().getDgRyojikanList();
    }

    @JsonIgnore
    public void  setDgRyojikanList(DataGrid<dgRyojikanList_Row> dgRyojikanList) {
        this.getRyojikanSelect().setDgRyojikanList(dgRyojikanList);
    }

    @JsonIgnore
    public TextBoxCode getTxtCode() {
        return this.getRyojikanInput().getTxtCode();
    }

    @JsonIgnore
    public void  setTxtCode(TextBoxCode txtCode) {
        this.getRyojikanInput().setTxtCode(txtCode);
    }

    @JsonIgnore
    public TextBox getTxtName() {
        return this.getRyojikanInput().getTxtName();
    }

    @JsonIgnore
    public void  setTxtName(TextBox txtName) {
        this.getRyojikanInput().setTxtName(txtName);
    }

    @JsonIgnore
    public TextBoxKana getTxtKanaName() {
        return this.getRyojikanInput().getTxtKanaName();
    }

    @JsonIgnore
    public void  setTxtKanaName(TextBoxKana txtKanaName) {
        this.getRyojikanInput().setTxtKanaName(txtKanaName);
    }

    @JsonIgnore
    public TextBoxNum getTxtHyojiJun() {
        return this.getRyojikanInput().getTxtHyojiJun();
    }

    @JsonIgnore
    public void  setTxtHyojiJun(TextBoxNum txtHyojiJun) {
        this.getRyojikanInput().setTxtHyojiJun(txtHyojiJun);
    }

    @JsonIgnore
    public Button getBtnAddNew() {
        return this.getRyojikanInput().getBtnAddNew();
    }

    @JsonIgnore
    public void  setBtnAddNew(Button btnAddNew) {
        this.getRyojikanInput().setBtnAddNew(btnAddNew);
    }

    @JsonIgnore
    public Button getBtnStop() {
        return this.getRyojikanInput().getBtnStop();
    }

    @JsonIgnore
    public void  setBtnStop(Button btnStop) {
        this.getRyojikanInput().setBtnStop(btnStop);
    }

    // </editor-fold>
}
