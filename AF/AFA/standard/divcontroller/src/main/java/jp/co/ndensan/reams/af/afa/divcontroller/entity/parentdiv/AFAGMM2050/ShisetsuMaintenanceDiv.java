package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2050;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeInput.ICodeInputDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxKana;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxYubinNo;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxAtenaMeisho;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxJusho;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxTelNo;

/**
 * ShisetsuMaintenance のクラスファイル
 *
 * @author 自動生成
 */
public class ShisetsuMaintenanceDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShisetsuSelect")
    private ShisetsuSelectDiv ShisetsuSelect;
    @JsonProperty("ShisetsuInput")
    private ShisetsuInputDiv ShisetsuInput;
    @JsonProperty("HiddenFlag")
    private RString HiddenFlag;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShisetsuSelect
     * @return ShisetsuSelect
     */
    @JsonProperty("ShisetsuSelect")
    public ShisetsuSelectDiv getShisetsuSelect() {
        return ShisetsuSelect;
    }

    /*
     * setShisetsuSelect
     * @param ShisetsuSelect ShisetsuSelect
     */
    @JsonProperty("ShisetsuSelect")
    public void setShisetsuSelect(ShisetsuSelectDiv ShisetsuSelect) {
        this.ShisetsuSelect = ShisetsuSelect;
    }

    /*
     * getShisetsuInput
     * @return ShisetsuInput
     */
    @JsonProperty("ShisetsuInput")
    public ShisetsuInputDiv getShisetsuInput() {
        return ShisetsuInput;
    }

    /*
     * setShisetsuInput
     * @param ShisetsuInput ShisetsuInput
     */
    @JsonProperty("ShisetsuInput")
    public void setShisetsuInput(ShisetsuInputDiv ShisetsuInput) {
        this.ShisetsuInput = ShisetsuInput;
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
    public TextBoxCode getTxtCode() {
        return this.getShisetsuInput().getTxtCode();
    }

    @JsonIgnore
    public void setTxtCode(TextBoxCode txtCode) {
        this.getShisetsuInput().setTxtCode(txtCode);
    }

    @JsonIgnore
    public TextBox getTxtName() {
        return this.getShisetsuInput().getTxtName();
    }

    @JsonIgnore
    public void setTxtName(TextBox txtName) {
        this.getShisetsuInput().setTxtName(txtName);
    }

    @JsonIgnore
    public TextBoxKana getTxtKanaName() {
        return this.getShisetsuInput().getTxtKanaName();
    }

    @JsonIgnore
    public void setTxtKanaName(TextBoxKana txtKanaName) {
        this.getShisetsuInput().setTxtKanaName(txtKanaName);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtYubinNo() {
        return this.getShisetsuInput().getTxtYubinNo();
    }

    @JsonIgnore
    public void setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.getShisetsuInput().setTxtYubinNo(txtYubinNo);
    }

    @JsonIgnore
    public TextBoxJusho getTxtJusho() {
        return this.getShisetsuInput().getTxtJusho();
    }

    @JsonIgnore
    public void setTxtJusho(TextBoxJusho txtJusho) {
        this.getShisetsuInput().setTxtJusho(txtJusho);
    }

    @JsonIgnore
    public TextBoxAtenaMeisho getTxtAtenaMeisho() {
        return this.getShisetsuInput().getTxtAtenaMeisho();
    }

    @JsonIgnore
    public void setTxtAtenaMeisho(TextBoxAtenaMeisho txtAtenaMeisho) {
        this.getShisetsuInput().setTxtAtenaMeisho(txtAtenaMeisho);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtTelNo() {
        return this.getShisetsuInput().getTxtTelNo();
    }

    @JsonIgnore
    public void setTxtTelNo(TextBoxTelNo txtTelNo) {
        this.getShisetsuInput().setTxtTelNo(txtTelNo);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtFaxNo() {
        return this.getShisetsuInput().getTxtFaxNo();
    }

    @JsonIgnore
    public void setTxtFaxNo(TextBoxTelNo txtFaxNo) {
        this.getShisetsuInput().setTxtFaxNo(txtFaxNo);
    }

    @JsonIgnore
    public Button getBtnAddNew() {
        return this.getShisetsuInput().getBtnAddNew();
    }

    @JsonIgnore
    public void setBtnAddNew(Button btnAddNew) {
        this.getShisetsuInput().setBtnAddNew(btnAddNew);
    }

    @JsonIgnore
    public Button getBtnStop() {
        return this.getShisetsuInput().getBtnStop();
    }

    @JsonIgnore
    public void setBtnStop(Button btnStop) {
        this.getShisetsuInput().setBtnStop(btnStop);
    }

    @JsonIgnore
    public ICodeInputDiv getCcdShisetsuShubetsu() {
        return this.getShisetsuInput().getCcdShisetsuShubetsu();
    }

    // </editor-fold>
}
