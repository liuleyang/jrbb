package jp.co.ndensan.reams.af.afa.divcontroller.entity.commonchilddiv.AtenaSealLayout;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;

/**
 * AtenaSealLayout のクラスファイル
 *
 * @reamsid_L AF-0620-013 jihb
 */
public class AtenaSealLayoutDiv extends Panel implements IAtenaSealLayoutDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblYubinNo")
    private Label lblYubinNo;
    @JsonProperty("ddlRightUp")
    private DropDownList ddlRightUp;
    @JsonProperty("ddlJusho")
    private DropDownList ddlJusho;
    @JsonProperty("txtJusho1")
    private TextBox txtJusho1;
    @JsonProperty("txtJusho2")
    private TextBox txtJusho2;
    @JsonProperty("txtJusho3")
    private TextBox txtJusho3;
    @JsonProperty("ddlAtena")
    private DropDownList ddlAtena;
    @JsonProperty("txtAtena1")
    private TextBox txtAtena1;
    @JsonProperty("ddlKeisho1")
    private DropDownList ddlKeisho1;
    @JsonProperty("txtAtena2")
    private TextBox txtAtena2;
    @JsonProperty("ddlKeisho2")
    private DropDownList ddlKeisho2;
    @JsonProperty("ddlLeftDown")
    private DropDownList ddlLeftDown;
    @JsonProperty("ddlRightDown")
    private DropDownList ddlRightDown;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblYubinNo
     * @return lblYubinNo
     */
    @JsonProperty("lblYubinNo")
    public Label getLblYubinNo() {
        return lblYubinNo;
    }

    /*
     * setlblYubinNo
     * @param lblYubinNo lblYubinNo
     */
    @JsonProperty("lblYubinNo")
    public void setLblYubinNo(Label lblYubinNo) {
        this.lblYubinNo = lblYubinNo;
    }

    /*
     * getddlRightUp
     * @return ddlRightUp
     */
    @JsonProperty("ddlRightUp")
    public DropDownList getDdlRightUp() {
        return ddlRightUp;
    }

    /*
     * setddlRightUp
     * @param ddlRightUp ddlRightUp
     */
    @JsonProperty("ddlRightUp")
    public void setDdlRightUp(DropDownList ddlRightUp) {
        this.ddlRightUp = ddlRightUp;
    }

    /*
     * getddlJusho
     * @return ddlJusho
     */
    @JsonProperty("ddlJusho")
    public DropDownList getDdlJusho() {
        return ddlJusho;
    }

    /*
     * setddlJusho
     * @param ddlJusho ddlJusho
     */
    @JsonProperty("ddlJusho")
    public void setDdlJusho(DropDownList ddlJusho) {
        this.ddlJusho = ddlJusho;
    }

    /*
     * gettxtJusho1
     * @return txtJusho1
     */
    @JsonProperty("txtJusho1")
    public TextBox getTxtJusho1() {
        return txtJusho1;
    }

    /*
     * settxtJusho1
     * @param txtJusho1 txtJusho1
     */
    @JsonProperty("txtJusho1")
    public void setTxtJusho1(TextBox txtJusho1) {
        this.txtJusho1 = txtJusho1;
    }

    /*
     * gettxtJusho2
     * @return txtJusho2
     */
    @JsonProperty("txtJusho2")
    public TextBox getTxtJusho2() {
        return txtJusho2;
    }

    /*
     * settxtJusho2
     * @param txtJusho2 txtJusho2
     */
    @JsonProperty("txtJusho2")
    public void setTxtJusho2(TextBox txtJusho2) {
        this.txtJusho2 = txtJusho2;
    }

    /*
     * gettxtJusho3
     * @return txtJusho3
     */
    @JsonProperty("txtJusho3")
    public TextBox getTxtJusho3() {
        return txtJusho3;
    }

    /*
     * settxtJusho3
     * @param txtJusho3 txtJusho3
     */
    @JsonProperty("txtJusho3")
    public void setTxtJusho3(TextBox txtJusho3) {
        this.txtJusho3 = txtJusho3;
    }

    /*
     * getddlAtena
     * @return ddlAtena
     */
    @JsonProperty("ddlAtena")
    public DropDownList getDdlAtena() {
        return ddlAtena;
    }

    /*
     * setddlAtena
     * @param ddlAtena ddlAtena
     */
    @JsonProperty("ddlAtena")
    public void setDdlAtena(DropDownList ddlAtena) {
        this.ddlAtena = ddlAtena;
    }

    /*
     * gettxtAtena1
     * @return txtAtena1
     */
    @JsonProperty("txtAtena1")
    public TextBox getTxtAtena1() {
        return txtAtena1;
    }

    /*
     * settxtAtena1
     * @param txtAtena1 txtAtena1
     */
    @JsonProperty("txtAtena1")
    public void setTxtAtena1(TextBox txtAtena1) {
        this.txtAtena1 = txtAtena1;
    }

    /*
     * getddlKeisho1
     * @return ddlKeisho1
     */
    @JsonProperty("ddlKeisho1")
    public DropDownList getDdlKeisho1() {
        return ddlKeisho1;
    }

    /*
     * setddlKeisho1
     * @param ddlKeisho1 ddlKeisho1
     */
    @JsonProperty("ddlKeisho1")
    public void setDdlKeisho1(DropDownList ddlKeisho1) {
        this.ddlKeisho1 = ddlKeisho1;
    }

    /*
     * gettxtAtena2
     * @return txtAtena2
     */
    @JsonProperty("txtAtena2")
    public TextBox getTxtAtena2() {
        return txtAtena2;
    }

    /*
     * settxtAtena2
     * @param txtAtena2 txtAtena2
     */
    @JsonProperty("txtAtena2")
    public void setTxtAtena2(TextBox txtAtena2) {
        this.txtAtena2 = txtAtena2;
    }

    /*
     * getddlKeisho2
     * @return ddlKeisho2
     */
    @JsonProperty("ddlKeisho2")
    public DropDownList getDdlKeisho2() {
        return ddlKeisho2;
    }

    /*
     * setddlKeisho2
     * @param ddlKeisho2 ddlKeisho2
     */
    @JsonProperty("ddlKeisho2")
    public void setDdlKeisho2(DropDownList ddlKeisho2) {
        this.ddlKeisho2 = ddlKeisho2;
    }

    /*
     * getddlLeftDown
     * @return ddlLeftDown
     */
    @JsonProperty("ddlLeftDown")
    public DropDownList getDdlLeftDown() {
        return ddlLeftDown;
    }

    /*
     * setddlLeftDown
     * @param ddlLeftDown ddlLeftDown
     */
    @JsonProperty("ddlLeftDown")
    public void setDdlLeftDown(DropDownList ddlLeftDown) {
        this.ddlLeftDown = ddlLeftDown;
    }

    /*
     * getddlRightDown
     * @return ddlRightDown
     */
    @JsonProperty("ddlRightDown")
    public DropDownList getDdlRightDown() {
        return ddlRightDown;
    }

    /*
     * setddlRightDown
     * @param ddlRightDown ddlRightDown
     */
    @JsonProperty("ddlRightDown")
    public void setDdlRightDown(DropDownList ddlRightDown) {
        this.ddlRightDown = ddlRightDown;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initialize() {
        getHandler().initialize();
    }

    @Override
    public void onChange_ddlJusho() {
        getHandler().onChange_ddlJusho();
    }

    @Override
    public void onChange_ddlAtena() {
        getHandler().onChange_ddlAtena();
    }

    @JsonIgnore
    public AtenaSealLayoutHandler getHandler() {
        return new AtenaSealLayoutHandler(this);
    }
}
