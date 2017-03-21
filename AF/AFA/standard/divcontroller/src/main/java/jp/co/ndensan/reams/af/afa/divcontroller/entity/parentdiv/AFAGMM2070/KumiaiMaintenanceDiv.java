package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2070;
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
 * KumiaiMaintenance のクラスファイル 
 * 
 * @author 自動生成
 */
public class KumiaiMaintenanceDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KumiaiSelect")
    private KumiaiSelectDiv KumiaiSelect;
    @JsonProperty("KumiaiInput")
    private KumiaiInputDiv KumiaiInput;
    @JsonProperty("HiddenFlag")
    private RString HiddenFlag;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKumiaiSelect
     * @return KumiaiSelect
     */
    @JsonProperty("KumiaiSelect")
    public KumiaiSelectDiv getKumiaiSelect() {
        return KumiaiSelect;
    }

    /*
     * setKumiaiSelect
     * @param KumiaiSelect KumiaiSelect
     */
    @JsonProperty("KumiaiSelect")
    public void setKumiaiSelect(KumiaiSelectDiv KumiaiSelect) {
        this.KumiaiSelect = KumiaiSelect;
    }

    /*
     * getKumiaiInput
     * @return KumiaiInput
     */
    @JsonProperty("KumiaiInput")
    public KumiaiInputDiv getKumiaiInput() {
        return KumiaiInput;
    }

    /*
     * setKumiaiInput
     * @param KumiaiInput KumiaiInput
     */
    @JsonProperty("KumiaiInput")
    public void setKumiaiInput(KumiaiInputDiv KumiaiInput) {
        this.KumiaiInput = KumiaiInput;
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
        return this.getKumiaiSelect().getBtnAdd();
    }

    @JsonIgnore
    public void  setBtnAdd(Button btnAdd) {
        this.getKumiaiSelect().setBtnAdd(btnAdd);
    }

    @JsonIgnore
    public DataGrid<dgKumiaiList_Row> getDgKumiaiList() {
        return this.getKumiaiSelect().getDgKumiaiList();
    }

    @JsonIgnore
    public void  setDgKumiaiList(DataGrid<dgKumiaiList_Row> dgKumiaiList) {
        this.getKumiaiSelect().setDgKumiaiList(dgKumiaiList);
    }

    @JsonIgnore
    public TextBoxCode getTxtCode() {
        return this.getKumiaiInput().getTxtCode();
    }

    @JsonIgnore
    public void  setTxtCode(TextBoxCode txtCode) {
        this.getKumiaiInput().setTxtCode(txtCode);
    }

    @JsonIgnore
    public TextBox getTxtName() {
        return this.getKumiaiInput().getTxtName();
    }

    @JsonIgnore
    public void  setTxtName(TextBox txtName) {
        this.getKumiaiInput().setTxtName(txtName);
    }

    @JsonIgnore
    public TextBoxKana getTxtKanaName() {
        return this.getKumiaiInput().getTxtKanaName();
    }

    @JsonIgnore
    public void  setTxtKanaName(TextBoxKana txtKanaName) {
        this.getKumiaiInput().setTxtKanaName(txtKanaName);
    }

    @JsonIgnore
    public TextBoxJusho getTxtJusho() {
        return this.getKumiaiInput().getTxtJusho();
    }

    @JsonIgnore
    public void  setTxtJusho(TextBoxJusho txtJusho) {
        this.getKumiaiInput().setTxtJusho(txtJusho);
    }

    @JsonIgnore
    public Button getBtnAddNew() {
        return this.getKumiaiInput().getBtnAddNew();
    }

    @JsonIgnore
    public void  setBtnAddNew(Button btnAddNew) {
        this.getKumiaiInput().setBtnAddNew(btnAddNew);
    }

    @JsonIgnore
    public Button getBtnStop() {
        return this.getKumiaiInput().getBtnStop();
    }

    @JsonIgnore
    public void  setBtnStop(Button btnStop) {
        this.getKumiaiInput().setBtnStop(btnStop);
    }

    // </editor-fold>
}
