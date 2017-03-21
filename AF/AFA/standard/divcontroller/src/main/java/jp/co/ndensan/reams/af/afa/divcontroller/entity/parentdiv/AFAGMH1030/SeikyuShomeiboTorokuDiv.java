package jp.co.ndensan.reams.af.afa.divcontroller.entity.parentdiv.AFAGMH1030;
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
 * SeikyuShomeiboToroku のクラスファイル 
 * 
 * @author 自動生成
 */
public class SeikyuShomeiboTorokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SeikyuShomeiboShomeisha")
    private SeikyuShomeiboShomeishaDiv SeikyuShomeiboShomeisha;
    @JsonProperty("SeikyuShomeiboShukei")
    private SeikyuShomeiboShukeiDiv SeikyuShomeiboShukei;
    @JsonProperty("txtHdnSeikyuNo")
    private RString txtHdnSeikyuNo;
    @JsonProperty("SearchSimpleJuminModel")
    private RString SearchSimpleJuminModel;
    @JsonProperty("txtHdnSenkyoShurui")
    private RString txtHdnSenkyoShurui;
    @JsonProperty("txtHdnShohonNo")
    private RString txtHdnShohonNo;
    @JsonProperty("txtHdnShikibetsuCode")
    private RString txtHdnShikibetsuCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSeikyuShomeiboShomeisha
     * @return SeikyuShomeiboShomeisha
     */
    @JsonProperty("SeikyuShomeiboShomeisha")
    public SeikyuShomeiboShomeishaDiv getSeikyuShomeiboShomeisha() {
        return SeikyuShomeiboShomeisha;
    }

    /*
     * setSeikyuShomeiboShomeisha
     * @param SeikyuShomeiboShomeisha SeikyuShomeiboShomeisha
     */
    @JsonProperty("SeikyuShomeiboShomeisha")
    public void setSeikyuShomeiboShomeisha(SeikyuShomeiboShomeishaDiv SeikyuShomeiboShomeisha) {
        this.SeikyuShomeiboShomeisha = SeikyuShomeiboShomeisha;
    }

    /*
     * getSeikyuShomeiboShukei
     * @return SeikyuShomeiboShukei
     */
    @JsonProperty("SeikyuShomeiboShukei")
    public SeikyuShomeiboShukeiDiv getSeikyuShomeiboShukei() {
        return SeikyuShomeiboShukei;
    }

    /*
     * setSeikyuShomeiboShukei
     * @param SeikyuShomeiboShukei SeikyuShomeiboShukei
     */
    @JsonProperty("SeikyuShomeiboShukei")
    public void setSeikyuShomeiboShukei(SeikyuShomeiboShukeiDiv SeikyuShomeiboShukei) {
        this.SeikyuShomeiboShukei = SeikyuShomeiboShukei;
    }

    /*
     * gettxtHdnSeikyuNo
     * @return txtHdnSeikyuNo
     */
    @JsonProperty("txtHdnSeikyuNo")
    public RString getTxtHdnSeikyuNo() {
        return txtHdnSeikyuNo;
    }

    /*
     * settxtHdnSeikyuNo
     * @param txtHdnSeikyuNo txtHdnSeikyuNo
     */
    @JsonProperty("txtHdnSeikyuNo")
    public void setTxtHdnSeikyuNo(RString txtHdnSeikyuNo) {
        this.txtHdnSeikyuNo = txtHdnSeikyuNo;
    }

    /*
     * getSearchSimpleJuminModel
     * @return SearchSimpleJuminModel
     */
    @JsonProperty("SearchSimpleJuminModel")
    public RString getSearchSimpleJuminModel() {
        return SearchSimpleJuminModel;
    }

    /*
     * setSearchSimpleJuminModel
     * @param SearchSimpleJuminModel SearchSimpleJuminModel
     */
    @JsonProperty("SearchSimpleJuminModel")
    public void setSearchSimpleJuminModel(RString SearchSimpleJuminModel) {
        this.SearchSimpleJuminModel = SearchSimpleJuminModel;
    }

    /*
     * gettxtHdnSenkyoShurui
     * @return txtHdnSenkyoShurui
     */
    @JsonProperty("txtHdnSenkyoShurui")
    public RString getTxtHdnSenkyoShurui() {
        return txtHdnSenkyoShurui;
    }

    /*
     * settxtHdnSenkyoShurui
     * @param txtHdnSenkyoShurui txtHdnSenkyoShurui
     */
    @JsonProperty("txtHdnSenkyoShurui")
    public void setTxtHdnSenkyoShurui(RString txtHdnSenkyoShurui) {
        this.txtHdnSenkyoShurui = txtHdnSenkyoShurui;
    }

    /*
     * gettxtHdnShohonNo
     * @return txtHdnShohonNo
     */
    @JsonProperty("txtHdnShohonNo")
    public RString getTxtHdnShohonNo() {
        return txtHdnShohonNo;
    }

    /*
     * settxtHdnShohonNo
     * @param txtHdnShohonNo txtHdnShohonNo
     */
    @JsonProperty("txtHdnShohonNo")
    public void setTxtHdnShohonNo(RString txtHdnShohonNo) {
        this.txtHdnShohonNo = txtHdnShohonNo;
    }

    /*
     * gettxtHdnShikibetsuCode
     * @return txtHdnShikibetsuCode
     */
    @JsonProperty("txtHdnShikibetsuCode")
    public RString getTxtHdnShikibetsuCode() {
        return txtHdnShikibetsuCode;
    }

    /*
     * settxtHdnShikibetsuCode
     * @param txtHdnShikibetsuCode txtHdnShikibetsuCode
     */
    @JsonProperty("txtHdnShikibetsuCode")
    public void setTxtHdnShikibetsuCode(RString txtHdnShikibetsuCode) {
        this.txtHdnShikibetsuCode = txtHdnShikibetsuCode;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtSeikyuName() {
        return this.getSeikyuShomeiboShomeisha().getTxtSeikyuName();
    }

    @JsonIgnore
    public void  setTxtSeikyuName(TextBox txtSeikyuName) {
        this.getSeikyuShomeiboShomeisha().setTxtSeikyuName(txtSeikyuName);
    }

    @JsonIgnore
    public ButtonDialog getBtnSearchSimple() {
        return this.getSeikyuShomeiboShomeisha().getBtnSearchSimple();
    }

    @JsonIgnore
    public void  setBtnSearchSimple(ButtonDialog btnSearchSimple) {
        this.getSeikyuShomeiboShomeisha().setBtnSearchSimple(btnSearchSimple);
    }

    @JsonIgnore
    public Button getBtnAddRow() {
        return this.getSeikyuShomeiboShomeisha().getBtnAddRow();
    }

    @JsonIgnore
    public void  setBtnAddRow(Button btnAddRow) {
        this.getSeikyuShomeiboShomeisha().setBtnAddRow(btnAddRow);
    }

    @JsonIgnore
    public DataGrid<dgSeikyuShomeiboShomeishaIchiran_Row> getDgSeikyuShomeiboShomeishaIchiran() {
        return this.getSeikyuShomeiboShomeisha().getDgSeikyuShomeiboShomeishaIchiran();
    }

    @JsonIgnore
    public void  setDgSeikyuShomeiboShomeishaIchiran(DataGrid<dgSeikyuShomeiboShomeishaIchiran_Row> dgSeikyuShomeiboShomeishaIchiran) {
        this.getSeikyuShomeiboShomeisha().setDgSeikyuShomeiboShomeishaIchiran(dgSeikyuShomeiboShomeishaIchiran);
    }

    @JsonIgnore
    public Button getBtnUpdate() {
        return this.getSeikyuShomeiboShomeisha().getBtnUpdate();
    }

    @JsonIgnore
    public void  setBtnUpdate(Button btnUpdate) {
        this.getSeikyuShomeiboShomeisha().setBtnUpdate(btnUpdate);
    }

    @JsonIgnore
    public tabSeikyuShomeiboShukeiDiv getTabSeikyuShomeiboShukei() {
        return this.getSeikyuShomeiboShukei().getTabSeikyuShomeiboShukei();
    }

    @JsonIgnore
    public void  setTabSeikyuShomeiboShukei(tabSeikyuShomeiboShukeiDiv tabSeikyuShomeiboShukei) {
        this.getSeikyuShomeiboShukei().setTabSeikyuShomeiboShukei(tabSeikyuShomeiboShukei);
    }

    @JsonIgnore
    public tplSeikyuShomeiboShukeiKensuTohyokuDiv getTplSeikyuShomeiboShukeiKensuTohyoku() {
        return this.getSeikyuShomeiboShukei().getTabSeikyuShomeiboShukei().getTplSeikyuShomeiboShukeiKensuTohyoku();
    }

    @JsonIgnore
    public void  setTplSeikyuShomeiboShukeiKensuTohyoku(tplSeikyuShomeiboShukeiKensuTohyokuDiv tplSeikyuShomeiboShukeiKensuTohyoku) {
        this.getSeikyuShomeiboShukei().getTabSeikyuShomeiboShukei().setTplSeikyuShomeiboShukeiKensuTohyoku(tplSeikyuShomeiboShukeiKensuTohyoku);
    }

    @JsonIgnore
    public DataGrid<dgSeikyuShomeiboShukeiKensuTohyoku_Row> getDgSeikyuShomeiboShukeiKensuTohyoku() {
        return this.getSeikyuShomeiboShukei().getTabSeikyuShomeiboShukei().getTplSeikyuShomeiboShukeiKensuTohyoku().getDgSeikyuShomeiboShukeiKensuTohyoku();
    }

    @JsonIgnore
    public void  setDgSeikyuShomeiboShukeiKensuTohyoku(DataGrid<dgSeikyuShomeiboShukeiKensuTohyoku_Row> dgSeikyuShomeiboShukeiKensuTohyoku) {
        this.getSeikyuShomeiboShukei().getTabSeikyuShomeiboShukei().getTplSeikyuShomeiboShukeiKensuTohyoku().setDgSeikyuShomeiboShukeiKensuTohyoku(dgSeikyuShomeiboShukeiKensuTohyoku);
    }

    @JsonIgnore
    public tplSeikyuShomeiboShukeiKensuJushoDiv getTplSeikyuShomeiboShukeiKensuJusho() {
        return this.getSeikyuShomeiboShukei().getTabSeikyuShomeiboShukei().getTplSeikyuShomeiboShukeiKensuJusho();
    }

    @JsonIgnore
    public void  setTplSeikyuShomeiboShukeiKensuJusho(tplSeikyuShomeiboShukeiKensuJushoDiv tplSeikyuShomeiboShukeiKensuJusho) {
        this.getSeikyuShomeiboShukei().getTabSeikyuShomeiboShukei().setTplSeikyuShomeiboShukeiKensuJusho(tplSeikyuShomeiboShukeiKensuJusho);
    }

    @JsonIgnore
    public DataGrid<dgSeikyuShomeiboShukeiKensuJusho_Row> getDgSeikyuShomeiboShukeiKensuJusho() {
        return this.getSeikyuShomeiboShukei().getTabSeikyuShomeiboShukei().getTplSeikyuShomeiboShukeiKensuJusho().getDgSeikyuShomeiboShukeiKensuJusho();
    }

    @JsonIgnore
    public void  setDgSeikyuShomeiboShukeiKensuJusho(DataGrid<dgSeikyuShomeiboShukeiKensuJusho_Row> dgSeikyuShomeiboShukeiKensuJusho) {
        this.getSeikyuShomeiboShukei().getTabSeikyuShomeiboShukei().getTplSeikyuShomeiboShukeiKensuJusho().setDgSeikyuShomeiboShukeiKensuJusho(dgSeikyuShomeiboShukeiKensuJusho);
    }

    @JsonIgnore
    public tplSeikyuShomeiboShukeiMukoTohyokuDiv getTplSeikyuShomeiboShukeiMukoTohyoku() {
        return this.getSeikyuShomeiboShukei().getTabSeikyuShomeiboShukei().getTplSeikyuShomeiboShukeiMukoTohyoku();
    }

    @JsonIgnore
    public void  setTplSeikyuShomeiboShukeiMukoTohyoku(tplSeikyuShomeiboShukeiMukoTohyokuDiv tplSeikyuShomeiboShukeiMukoTohyoku) {
        this.getSeikyuShomeiboShukei().getTabSeikyuShomeiboShukei().setTplSeikyuShomeiboShukeiMukoTohyoku(tplSeikyuShomeiboShukeiMukoTohyoku);
    }

    @JsonIgnore
    public DataGrid<dgSeikyuShomeiboShukeiMukoTohyoku_Row> getDgSeikyuShomeiboShukeiMukoTohyoku() {
        return this.getSeikyuShomeiboShukei().getTabSeikyuShomeiboShukei().getTplSeikyuShomeiboShukeiMukoTohyoku().getDgSeikyuShomeiboShukeiMukoTohyoku();
    }

    @JsonIgnore
    public void  setDgSeikyuShomeiboShukeiMukoTohyoku(DataGrid<dgSeikyuShomeiboShukeiMukoTohyoku_Row> dgSeikyuShomeiboShukeiMukoTohyoku) {
        this.getSeikyuShomeiboShukei().getTabSeikyuShomeiboShukei().getTplSeikyuShomeiboShukeiMukoTohyoku().setDgSeikyuShomeiboShukeiMukoTohyoku(dgSeikyuShomeiboShukeiMukoTohyoku);
    }

    @JsonIgnore
    public tplSeikyuShomeiboShukeiMukoJushoDiv getTplSeikyuShomeiboShukeiMukoJusho() {
        return this.getSeikyuShomeiboShukei().getTabSeikyuShomeiboShukei().getTplSeikyuShomeiboShukeiMukoJusho();
    }

    @JsonIgnore
    public void  setTplSeikyuShomeiboShukeiMukoJusho(tplSeikyuShomeiboShukeiMukoJushoDiv tplSeikyuShomeiboShukeiMukoJusho) {
        this.getSeikyuShomeiboShukei().getTabSeikyuShomeiboShukei().setTplSeikyuShomeiboShukeiMukoJusho(tplSeikyuShomeiboShukeiMukoJusho);
    }

    @JsonIgnore
    public DataGrid<dgSeikyuShomeiboShukeiMukoJusho_Row> getDgSeikyuShomeiboShukeiMukoJusho() {
        return this.getSeikyuShomeiboShukei().getTabSeikyuShomeiboShukei().getTplSeikyuShomeiboShukeiMukoJusho().getDgSeikyuShomeiboShukeiMukoJusho();
    }

    @JsonIgnore
    public void  setDgSeikyuShomeiboShukeiMukoJusho(DataGrid<dgSeikyuShomeiboShukeiMukoJusho_Row> dgSeikyuShomeiboShukeiMukoJusho) {
        this.getSeikyuShomeiboShukei().getTabSeikyuShomeiboShukei().getTplSeikyuShomeiboShukeiMukoJusho().setDgSeikyuShomeiboShukeiMukoJusho(dgSeikyuShomeiboShukeiMukoJusho);
    }

    @JsonIgnore
    public tplSeikyuShomeiboShukeiNenreiDiv getTplSeikyuShomeiboShukeiNenrei() {
        return this.getSeikyuShomeiboShukei().getTabSeikyuShomeiboShukei().getTplSeikyuShomeiboShukeiNenrei();
    }

    @JsonIgnore
    public void  setTplSeikyuShomeiboShukeiNenrei(tplSeikyuShomeiboShukeiNenreiDiv tplSeikyuShomeiboShukeiNenrei) {
        this.getSeikyuShomeiboShukei().getTabSeikyuShomeiboShukei().setTplSeikyuShomeiboShukeiNenrei(tplSeikyuShomeiboShukeiNenrei);
    }

    @JsonIgnore
    public DataGrid<dgSeikyuShomeiboShukeiNenrei_Row> getDgSeikyuShomeiboShukeiNenrei() {
        return this.getSeikyuShomeiboShukei().getTabSeikyuShomeiboShukei().getTplSeikyuShomeiboShukeiNenrei().getDgSeikyuShomeiboShukeiNenrei();
    }

    @JsonIgnore
    public void  setDgSeikyuShomeiboShukeiNenrei(DataGrid<dgSeikyuShomeiboShukeiNenrei_Row> dgSeikyuShomeiboShukeiNenrei) {
        this.getSeikyuShomeiboShukei().getTabSeikyuShomeiboShukei().getTplSeikyuShomeiboShukeiNenrei().setDgSeikyuShomeiboShukeiNenrei(dgSeikyuShomeiboShukeiNenrei);
    }

    @JsonIgnore
    public tplSeikyuShomeiboShukeiNendaiDiv getTplSeikyuShomeiboShukeiNendai() {
        return this.getSeikyuShomeiboShukei().getTabSeikyuShomeiboShukei().getTplSeikyuShomeiboShukeiNendai();
    }

    @JsonIgnore
    public void  setTplSeikyuShomeiboShukeiNendai(tplSeikyuShomeiboShukeiNendaiDiv tplSeikyuShomeiboShukeiNendai) {
        this.getSeikyuShomeiboShukei().getTabSeikyuShomeiboShukei().setTplSeikyuShomeiboShukeiNendai(tplSeikyuShomeiboShukeiNendai);
    }

    @JsonIgnore
    public DataGrid<dgSeikyuShomeiboShukeiNendai_Row> getDgSeikyuShomeiboShukeiNendai() {
        return this.getSeikyuShomeiboShukei().getTabSeikyuShomeiboShukei().getTplSeikyuShomeiboShukeiNendai().getDgSeikyuShomeiboShukeiNendai();
    }

    @JsonIgnore
    public void  setDgSeikyuShomeiboShukeiNendai(DataGrid<dgSeikyuShomeiboShukeiNendai_Row> dgSeikyuShomeiboShukeiNendai) {
        this.getSeikyuShomeiboShukei().getTabSeikyuShomeiboShukei().getTplSeikyuShomeiboShukeiNendai().setDgSeikyuShomeiboShukeiNendai(dgSeikyuShomeiboShukeiNendai);
    }

    // </editor-fold>
}
