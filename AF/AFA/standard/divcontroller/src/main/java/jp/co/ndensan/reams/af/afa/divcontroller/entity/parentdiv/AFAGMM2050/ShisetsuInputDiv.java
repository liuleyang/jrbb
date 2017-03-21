package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMM2050;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeInput.CodeInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeInput.ICodeInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShisetsuInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShisetsuInputDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtCode")
    private TextBoxCode txtCode;
    @JsonProperty("txtName")
    private TextBox txtName;
    @JsonProperty("txtKanaName")
    private TextBoxKana txtKanaName;
    @JsonProperty("txtYubinNo")
    private TextBoxYubinNo txtYubinNo;
    @JsonProperty("txtJusho")
    private TextBoxJusho txtJusho;
    @JsonProperty("txtAtenaMeisho")
    private TextBoxAtenaMeisho txtAtenaMeisho;
    @JsonProperty("txtTelNo")
    private TextBoxTelNo txtTelNo;
    @JsonProperty("txtFaxNo")
    private TextBoxTelNo txtFaxNo;
    @JsonProperty("btnAddNew")
    private Button btnAddNew;
    @JsonProperty("btnStop")
    private Button btnStop;
    @JsonProperty("ccdShisetsuShubetsu")
    private CodeInputDiv ccdShisetsuShubetsu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtCode
     * @return txtCode
     */
    @JsonProperty("txtCode")
    public TextBoxCode getTxtCode() {
        return txtCode;
    }

    /*
     * settxtCode
     * @param txtCode txtCode
     */
    @JsonProperty("txtCode")
    public void setTxtCode(TextBoxCode txtCode) {
        this.txtCode = txtCode;
    }

    /*
     * gettxtName
     * @return txtName
     */
    @JsonProperty("txtName")
    public TextBox getTxtName() {
        return txtName;
    }

    /*
     * settxtName
     * @param txtName txtName
     */
    @JsonProperty("txtName")
    public void setTxtName(TextBox txtName) {
        this.txtName = txtName;
    }

    /*
     * gettxtKanaName
     * @return txtKanaName
     */
    @JsonProperty("txtKanaName")
    public TextBoxKana getTxtKanaName() {
        return txtKanaName;
    }

    /*
     * settxtKanaName
     * @param txtKanaName txtKanaName
     */
    @JsonProperty("txtKanaName")
    public void setTxtKanaName(TextBoxKana txtKanaName) {
        this.txtKanaName = txtKanaName;
    }

    /*
     * gettxtYubinNo
     * @return txtYubinNo
     */
    @JsonProperty("txtYubinNo")
    public TextBoxYubinNo getTxtYubinNo() {
        return txtYubinNo;
    }

    /*
     * settxtYubinNo
     * @param txtYubinNo txtYubinNo
     */
    @JsonProperty("txtYubinNo")
    public void setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.txtYubinNo = txtYubinNo;
    }

    /*
     * gettxtJusho
     * @return txtJusho
     */
    @JsonProperty("txtJusho")
    public TextBoxJusho getTxtJusho() {
        return txtJusho;
    }

    /*
     * settxtJusho
     * @param txtJusho txtJusho
     */
    @JsonProperty("txtJusho")
    public void setTxtJusho(TextBoxJusho txtJusho) {
        this.txtJusho = txtJusho;
    }

    /*
     * gettxtAtenaMeisho
     * @return txtAtenaMeisho
     */
    @JsonProperty("txtAtenaMeisho")
    public TextBoxAtenaMeisho getTxtAtenaMeisho() {
        return txtAtenaMeisho;
    }

    /*
     * settxtAtenaMeisho
     * @param txtAtenaMeisho txtAtenaMeisho
     */
    @JsonProperty("txtAtenaMeisho")
    public void setTxtAtenaMeisho(TextBoxAtenaMeisho txtAtenaMeisho) {
        this.txtAtenaMeisho = txtAtenaMeisho;
    }

    /*
     * gettxtTelNo
     * @return txtTelNo
     */
    @JsonProperty("txtTelNo")
    public TextBoxTelNo getTxtTelNo() {
        return txtTelNo;
    }

    /*
     * settxtTelNo
     * @param txtTelNo txtTelNo
     */
    @JsonProperty("txtTelNo")
    public void setTxtTelNo(TextBoxTelNo txtTelNo) {
        this.txtTelNo = txtTelNo;
    }

    /*
     * gettxtFaxNo
     * @return txtFaxNo
     */
    @JsonProperty("txtFaxNo")
    public TextBoxTelNo getTxtFaxNo() {
        return txtFaxNo;
    }

    /*
     * settxtFaxNo
     * @param txtFaxNo txtFaxNo
     */
    @JsonProperty("txtFaxNo")
    public void setTxtFaxNo(TextBoxTelNo txtFaxNo) {
        this.txtFaxNo = txtFaxNo;
    }

    /*
     * getbtnAddNew
     * @return btnAddNew
     */
    @JsonProperty("btnAddNew")
    public Button getBtnAddNew() {
        return btnAddNew;
    }

    /*
     * setbtnAddNew
     * @param btnAddNew btnAddNew
     */
    @JsonProperty("btnAddNew")
    public void setBtnAddNew(Button btnAddNew) {
        this.btnAddNew = btnAddNew;
    }

    /*
     * getbtnStop
     * @return btnStop
     */
    @JsonProperty("btnStop")
    public Button getBtnStop() {
        return btnStop;
    }

    /*
     * setbtnStop
     * @param btnStop btnStop
     */
    @JsonProperty("btnStop")
    public void setBtnStop(Button btnStop) {
        this.btnStop = btnStop;
    }

    /*
     * getccdShisetsuShubetsu
     * @return ccdShisetsuShubetsu
     */
    @JsonProperty("ccdShisetsuShubetsu")
    public ICodeInputDiv getCcdShisetsuShubetsu() {
        return ccdShisetsuShubetsu;
    }

    // </editor-fold>
}
